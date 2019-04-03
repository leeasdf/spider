<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible"
    width="70%">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="应用信息">
          <el-row :gutter="2">
             <el-col :span="6"><el-input v-model="dataForm.appName" placeholder="应用名称"></el-input></el-col>
             <el-col :span="8"><el-input v-model="dataForm.token" placeholder="应用TOKEN"></el-input> </el-col>
             <el-col :span="6"><el-date-picker v-model="dataForm.expireTime" type="date" placeholder="选择日期" value-format="yyyy-MM-dd">
                               </el-date-picker>
             </el-col>
          </el-row>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      height="400"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      ref="table"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>

      <el-table-column
        prop="apiDesc"
        header-align="center"
        align="center"
        label="api接口描述">
      </el-table-column>

      <el-table-column
        prop="apiUrl"
        header-align="center"
        align="left"
        label="api访问地址">
      </el-table-column>

      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="更新时间">
      </el-table-column>
    </el-table>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>
<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          userId: 0,
          appId: '',
          appName: '',
          token: '',
          expireTime: '',
          status: ''
        },
        dataList: [],
        userApiList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        dataRule: {
          appId: [
            { required: true, message: '应用id不能为空', trigger: 'blur' }
          ],
          appName: [
            { required: true, message: '应用名称不能为空', trigger: 'blur' }
          ],
          token: [
            { required: true, message: 'token不能为空', trigger: 'blur' }
          ],
          expireTime: [
            { required: true, message: '过期时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.userId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          this.getDataList()
          this.getUsersApiDataList()
          if (this.dataForm.userId) {
            this.$http({
              url: this.$http.adornUrl(`/api/sysuserapitoken/info/${this.dataForm.userId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0 && data.sysUserApiToken != null) {
                this.dataForm.appId = data.sysUserApiToken.appId
                this.dataForm.appName = data.sysUserApiToken.appName
                this.dataForm.token = data.sysUserApiToken.token
                this.dataForm.expireTime = data.sysUserApiToken.expireTime
                this.dataForm.status = data.sysUserApiToken.status
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/api/sysuserapitoken/${!this.dataForm.userId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'userId': this.dataForm.userId || undefined,
                'appId': this.dataForm.appId,
                'appName': this.dataForm.appName,
                'token': this.dataForm.token,
                'expireTime': this.dataForm.expireTime,
                'status': this.dataForm.status,
                'apiIdList': this.dataListSelections.map(item => { return item.apiId })
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      },
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/api/sysapimenu/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': 100,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 获得该用户已有的API数据数据列表
      getUsersApiDataList () {
        this.$http({
          url: this.$http.adornUrl(`/api/sysapimenu/listByUserId/${this.dataForm.userId}`),
          method: 'get',
          params: this.$http.adornParams()
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.userApiList = data.list
            for (var i = 0; i < this.userApiList.length; i++) {
              for (var j = 0; j < this.dataList.length; j++) {
                if (this.userApiList[i].apiId === this.dataList[j].apiId) {
                  this.$refs.table.toggleRowSelection(this.dataList[j], true)
                }
              }
            }
          }
        })
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      }
    }
  }
</script>
