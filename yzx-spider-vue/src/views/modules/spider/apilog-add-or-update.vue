<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="业务ID" prop="bizId">
      <el-input v-model="dataForm.bizId" placeholder="业务ID"></el-input>
    </el-form-item>
    <el-form-item label="请求信息" prop="reqInfo">
      <el-input v-model="dataForm.reqInfo" placeholder="请求信息"></el-input>
    </el-form-item>
    <el-form-item label="请求ID" prop="reqId">
      <el-input v-model="dataForm.reqId" placeholder="请求ID"></el-input>
    </el-form-item>
    <el-form-item label="通道类型" prop="channelType">
      <el-input v-model="dataForm.channelType" placeholder="通道类型"></el-input>
    </el-form-item>
    <el-form-item label="" prop="respInfo">
      <el-input v-model="dataForm.respInfo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="返回码" prop="respCode">
      <el-input v-model="dataForm.respCode" placeholder="返回码"></el-input>
    </el-form-item>
    <el-form-item label="返回信息" prop="respMessage">
      <el-input v-model="dataForm.respMessage" placeholder="返回信息"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态"></el-input>
    </el-form-item>
    
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          id: 0,
          bizId: '',
          reqInfo: '',
          reqId: '',
          channelType: '',
          respInfo: '',
          respCode: '',
          respMessage: '',
          status: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          bizId: [
            { required: true, message: '业务ID不能为空', trigger: 'blur' }
          ],
          reqInfo: [
            { required: true, message: '请求信息不能为空', trigger: 'blur' }
          ],
          reqId: [
            { required: true, message: '请求ID不能为空', trigger: 'blur' }
          ],
          channelType: [
            { required: true, message: '通道类型不能为空', trigger: 'blur' }
          ],
          respInfo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          respCode: [
            { required: true, message: '返回码不能为空', trigger: 'blur' }
          ],
          respMessage: [
            { required: true, message: '返回信息不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/spider/apilog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.bizId = data.apiLog.bizId
                this.dataForm.reqInfo = data.apiLog.reqInfo
                this.dataForm.reqId = data.apiLog.reqId
                this.dataForm.channelType = data.apiLog.channelType
                this.dataForm.respInfo = data.apiLog.respInfo
                this.dataForm.respCode = data.apiLog.respCode
                this.dataForm.respMessage = data.apiLog.respMessage
                this.dataForm.status = data.apiLog.status
                this.dataForm.createTime = data.apiLog.createTime
                this.dataForm.updateTime = data.apiLog.updateTime
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
              url: this.$http.adornUrl(`/spider/apilog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'bizId': this.dataForm.bizId,
                'reqInfo': this.dataForm.reqInfo,
                'reqId': this.dataForm.reqId,
                'channelType': this.dataForm.channelType,
                'respInfo': this.dataForm.respInfo,
                'respCode': this.dataForm.respCode,
                'respMessage': this.dataForm.respMessage,
                'status': this.dataForm.status,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
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
