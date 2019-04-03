<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="gsmc" prop="company">
      <el-input v-model="dataForm.company" placeholder="gsmc"></el-input>
    </el-form-item>
    <el-form-item label="xmmc" prop="projectName">
      <el-input v-model="dataForm.projectName" placeholder="xmmc"></el-input>
    </el-form-item>
    <el-form-item label="备注bz" prop="note">
      <el-input v-model="dataForm.note" placeholder="备注bz"></el-input>
    </el-form-item>
    <el-form-item label="" prop="memId">
      <el-input v-model="dataForm.memId" placeholder=""></el-input>
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
          company: '',
          projectName: '',
          note: '',
          memId: '',
          enterpriseId: ''
        },
        dataRule: {
          company: [
            { required: true, message: 'gsmc不能为空', trigger: 'blur' }
          ],
          projectName: [
            { required: true, message: 'xmmc不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '备注bz不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechmerchants/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.company = data.entHighTechMerchants.company
                this.dataForm.projectName = data.entHighTechMerchants.projectName
                this.dataForm.note = data.entHighTechMerchants.note
                this.dataForm.memId = data.entHighTechMerchants.memId
                this.dataForm.enterpriseId = data.entHighTechMerchants.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechmerchants/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'company': this.dataForm.company,
                'projectName': this.dataForm.projectName,
                'note': this.dataForm.note,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId
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
