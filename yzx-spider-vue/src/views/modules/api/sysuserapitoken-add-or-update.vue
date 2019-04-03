<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="应用id" prop="appId">
      <el-input v-model="dataForm.appId" placeholder="应用id"></el-input>
    </el-form-item>
    <el-form-item label="应用名称" prop="appName">
      <el-input v-model="dataForm.appName" placeholder="应用名称"></el-input>
    </el-form-item>
    <el-form-item label="token" prop="token">
      <el-input v-model="dataForm.token" placeholder="token"></el-input>
    </el-form-item>
    <el-form-item label="过期时间" prop="expireTime">
      <el-date-picker  v-model="dataForm.expireTime" value-format="yyyy-MM-dd" type="date" placeholder="过期时间">
      </el-date-picker>
    </el-form-item>
      <el-form-item label="状态" size="mini" prop="status">
        <el-radio-group v-model="dataForm.status">
          <el-radio :label="0">禁用</el-radio>
          <el-radio :label="1">正常</el-radio>
        </el-radio-group>
      </el-form-item>
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
          userId: 0,
          appId: '',
          appName: '',
          token: '',
          expireTime: '',
          updateTime: '',
          createTime: '',
          status: 1
        },
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
          this.$http({
            url: this.$http.adornUrl(`/api/sysuserapitoken/info/${this.dataForm.userId}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.dataForm.appId = data.sysUserApiToken.appId
              this.dataForm.appName = data.sysUserApiToken.appName
              this.dataForm.token = data.sysUserApiToken.token
              this.dataForm.expireTime = data.sysUserApiToken.expireTime
              this.dataForm.status = data.sysUserApiToken.status
            }
          })
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
                'status': this.dataForm.status
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
