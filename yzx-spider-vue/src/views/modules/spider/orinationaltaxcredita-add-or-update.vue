<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="纳税人识别号" prop="taxNumber">
      <el-input v-model="dataForm.taxNumber" placeholder="纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="纳税人名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="year">
      <el-input v-model="dataForm.year" placeholder="评价年度"></el-input>
    </el-form-item>
    <el-form-item label="主管税务机关" prop="taxAuthorities">
      <el-input v-model="dataForm.taxAuthorities" placeholder="主管税务机关"></el-input>
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
          taxNumber: '',
          enterpriseName: '',
          year: '',
          taxAuthorities: ''
        },
        dataRule: {
          taxNumber: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          taxAuthorities: [
            { required: true, message: '主管税务机关不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/orinationaltaxcredita/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taxNumber = data.oriNationalTaxCreditA.taxNumber
                this.dataForm.enterpriseName = data.oriNationalTaxCreditA.enterpriseName
                this.dataForm.year = data.oriNationalTaxCreditA.year
                this.dataForm.taxAuthorities = data.oriNationalTaxCreditA.taxAuthorities
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
              url: this.$http.adornUrl(`/spider/orinationaltaxcredita/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'taxNumber': this.dataForm.taxNumber,
                'enterpriseName': this.dataForm.enterpriseName,
                'year': this.dataForm.year,
                'taxAuthorities': this.dataForm.taxAuthorities
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
