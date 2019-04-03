<template>
  <el-dialog
    :title="分配权限"
    :close-on-click-modal="false"
    :visible.sync="visible"
    width="70%">
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
        dataForm: {
          key: ''
        },
        appId: 0,
        visible: false,
        dataList: [],
        userApiList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: []
      }
    },
    methods: {
      init (id) {
        this.appId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.getDataList()
          this.getAppApiDataList()
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$http({
          url: this.$http.adornUrl(`/api/sysappapi/save`),
          method: 'post',
          data: this.$http.adornData({
            'appId': this.appId,
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
      // 获得该应用已有的API数据数据列表
      getAppApiDataList () {
        this.$http({
          url: this.$http.adornUrl(`/api/sysapimenu/listByAppId/${this.appId}`),
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
