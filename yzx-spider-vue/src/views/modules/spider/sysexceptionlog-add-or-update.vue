<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="名称" prop="desc">
      <el-input v-model="dataForm.desc" placeholder="名称"></el-input>
    </el-form-item>
    <el-form-item label="异常类型（如：爬虫异常等）" prop="type">
      <el-input v-model="dataForm.type" placeholder="异常类型（如：爬虫异常等）"></el-input>
    </el-form-item>
    <el-form-item label="执行方法" prop="method">
      <el-input v-model="dataForm.method" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="异常栈" prop="stack">
      <el-input v-model="dataForm.stack" placeholder="异常栈"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
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
          name: '',
          type: '',
          method: '',
          stack: '',
          createTime: ''
        },
        dataRule: {
          name: [
            { required: true, message: '名称不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '异常类型（如：爬虫异常等）不能为空', trigger: 'blur' }
          ],
          method: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          stack: [
            { required: true, message: '异常栈不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/sysexceptionlog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.sysExceptionLog.name
                this.dataForm.type = data.sysExceptionLog.type
                this.dataForm.method = data.sysExceptionLog.method
                this.dataForm.stack = data.sysExceptionLog.stack
                this.dataForm.createTime = data.sysExceptionLog.createTime
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
              url: this.$http.adornUrl(`/spider/sysexceptionlog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'type': this.dataForm.type,
                'method': this.dataForm.method,
                'stack': this.dataForm.stack,
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
