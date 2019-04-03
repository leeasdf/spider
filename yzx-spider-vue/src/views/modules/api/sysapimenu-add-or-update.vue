<template>
  <el-dialog
    width='600px'
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
    <el-form-item label="api访问地址" prop="apiUrl">
      <el-input v-model="dataForm.apiUrl" placeholder="api访问地址"></el-input>
    </el-form-item>
    <el-form-item label="api接口描述" prop="apiDesc">
      <el-input v-model="dataForm.apiDesc" placeholder="api接口描述"></el-input>
    </el-form-item>
   <!--  <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item> -->
    </el-form>
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
          apiId: 0,
          apiUrl: '',
          apiDesc: '',
          updateTime: '',
          createTime: ''
        },
        dataRule: {
          apiUrl: [
            { required: true, message: 'api访问地址不能为空', trigger: 'blur' }
          ],
          apiDesc: [
            { required: true, message: 'api接口描述不能为空', trigger: 'blur' }
          ]
          /* updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ] */
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.apiId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.apiId) {
            this.$http({
              url: this.$http.adornUrl(`/api/sysapimenu/info/${this.dataForm.apiId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.apiUrl = data.sysApiMenu.apiUrl
                this.dataForm.apiDesc = data.sysApiMenu.apiDesc
                this.dataForm.updateTime = data.sysApiMenu.updateTime
                this.dataForm.createTime = data.sysApiMenu.createTime
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
              url: this.$http.adornUrl(`/api/sysapimenu/${!this.dataForm.apiId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'apiId': this.dataForm.apiId || undefined,
                'apiUrl': this.dataForm.apiUrl,
                'apiDesc': this.dataForm.apiDesc,
                'updateTime': this.dataForm.updateTime,
                'createTime': this.dataForm.createTime
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
      }
    }
  }
</script>
