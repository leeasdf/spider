<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
    <el-form-item label="组织机构代码" prop="organizationCode">
      <el-input v-model="dataForm.organizationCode" placeholder="组织机构代码"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="工商营业执照注册号" prop="licenseRegisterNumber">
      <el-input v-model="dataForm.licenseRegisterNumber" placeholder="工商营业执照注册号"></el-input>
    </el-form-item>
    <el-form-item label="税务登记证号" prop="taxNumber">
      <el-input v-model="dataForm.taxNumber" placeholder="税务登记证号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人（负责人）" prop="legal">
      <el-input v-model="dataForm.legal" placeholder="法定代表人（负责人）"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人（负责人）身份证件号" prop="cardNumber">
      <el-input v-model="dataForm.cardNumber" placeholder="法定代表人（负责人）身份证件号"></el-input>
    </el-form-item>
    <el-form-item label="注册地址" prop="registerAddress">
      <el-input v-model="dataForm.registerAddress" placeholder="注册地址"></el-input>
    </el-form-item>
    <el-form-item label="经营地址（国）" prop="businessAddress">
      <el-input v-model="dataForm.businessAddress" placeholder="经营地址（国）"></el-input>
    </el-form-item>
    <el-form-item label="经营方式" prop="businessWay">
      <el-input v-model="dataForm.businessWay" placeholder="经营方式"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="telephone">
      <el-input v-model="dataForm.telephone" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item label="企业状态编码（国）" prop="enterpriseStatus">
      <el-input v-model="dataForm.enterpriseStatus" placeholder="企业状态编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="税务部门编码（国）" prop="taxDepartmentCode">
      <el-input v-model="dataForm.taxDepartmentCode" placeholder="税务部门编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="发证日期" prop="certificationDate">
      <el-date-picker v-model="dataForm.certificationDate" placeholder="发证日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="税务登记日期（国）" prop="taxRegisterDate">
      <!-- <el-input v-model="dataForm.taxRegisterDate" placeholder="税务登记日期（国）"></el-input> -->
      <el-date-picker v-model="dataForm.taxRegisterDate" placeholder="税务登记日期（国）" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="登记注册类型" prop="registerType">
      <el-input v-model="dataForm.registerType" placeholder="登记注册类型"></el-input>
    </el-form-item>
    <el-form-item label="经营期限" prop="businessDeadline">
      <el-date-picker v-model="dataForm.businessDeadline" placeholder="经营期限" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="注册资本" prop="registeredCapital">
      <el-input v-model="dataForm.registeredCapital" placeholder="注册资本"></el-input>
    </el-form-item>
    <el-form-item label="注册资本币种" prop="currency">
      <el-input v-model="dataForm.currency" placeholder="注册资本币种"></el-input>
    </el-form-item>
    <el-form-item label="银行编码（国）" prop="bank">
      <el-input v-model="dataForm.bank" placeholder="银行编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="银行网点编码（国）" prop="bankDot">
      <el-input v-model="dataForm.bankDot" placeholder="银行网点编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="缴税银行帐号（国）" prop="payingBankAccount">
      <el-input v-model="dataForm.payingBankAccount" placeholder="缴税银行帐号（国）"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isFloat, isIDCard, isPhone, isMobile } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      const validateIDCard = function (rule, value, callback) {
        if (!isIDCard(value)) {
          callback(new Error('身份证号格式错误'))
        } else {
          callback()
        }
      }
      const validatePhone = function (rule, value, callback) {
        if (!isPhone(value) && !isMobile(value)) {
          callback(new Error('请输入正确的电话格式，如固定号码、区号-固定号码或移动号码'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          organizationCode: '',
          enterpriseName: '',
          licenseRegisterNumber: '',
          taxNumber: '',
          legal: '',
          cardNumber: '',
          registerAddress: '',
          businessAddress: '',
          businessWay: '',
          telephone: '',
          enterpriseStatus: '',
          taxDepartmentCode: '',
          certificationDate: '',
          taxRegisterDate: '',
          registerType: '',
          businessDeadline: '',
          registeredCapital: '',
          currency: '',
          bank: '',
          bankDot: '',
          payingBankAccount: ''
        },
        dataRule: {
          organizationCode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          licenseRegisterNumber: [
            { required: true, message: '工商营业执照注册号不能为空', trigger: 'blur' }
          ],
          taxNumber: [
            { required: true, message: '税务登记证号不能为空', trigger: 'blur' }
          ],
          legal: [
            { required: true, message: '法定代表人（负责人）不能为空', trigger: 'blur' }
          ],
          cardNumber: [
            { required: true, message: '法定代表人（负责人）身份证件号不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          registerAddress: [
            { required: true, message: '注册地址不能为空', trigger: 'blur' }
          ],
          businessAddress: [
            { required: true, message: '经营地址（国）不能为空', trigger: 'blur' }
          ],
          businessWay: [
            { required: true, message: '经营方式不能为空', trigger: 'blur' }
          ],
          telephone: [
            { required: true, message: '电话不能为空', trigger: 'blur' },
            { validator: validatePhone, trigger: 'blur' }
          ],
          enterpriseStatus: [
            { required: true, message: '企业状态编码（国）不能为空', trigger: 'blur' }
          ],
          taxDepartmentCode: [
            { required: true, message: '税务部门编码（国）不能为空', trigger: 'blur' }
          ],
          certificationDate: [
            { required: true, message: '发证日期不能为空', trigger: 'blur' }
          ],
          taxRegisterDate: [
            { required: true, message: '税务登记日期（国）不能为空', trigger: 'blur' }
          ],
          registerType: [
            { required: true, message: '登记注册类型不能为空', trigger: 'blur' }
          ],
          businessDeadline: [
            { required: true, message: '经营期限不能为空', trigger: 'blur' }
          ],
          registeredCapital: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          currency: [
            { required: true, message: '注册资本币种不能为空', trigger: 'blur' }
          ],
          bank: [
            { required: true, message: '银行编码（国）不能为空', trigger: 'blur' }
          ],
          bankDot: [
            { required: true, message: '银行网点编码（国）不能为空', trigger: 'blur' }
          ],
          payingBankAccount: [
            { required: true, message: '缴税银行帐号（国）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/orinationaltaxbase/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.organizationCode = data.oriNationalTaxBase.organizationCode
                this.dataForm.enterpriseName = data.oriNationalTaxBase.enterpriseName
                this.dataForm.licenseRegisterNumber = data.oriNationalTaxBase.licenseRegisterNumber
                this.dataForm.taxNumber = data.oriNationalTaxBase.taxNumber
                this.dataForm.legal = data.oriNationalTaxBase.legal
                this.dataForm.cardNumber = data.oriNationalTaxBase.cardNumber
                this.dataForm.registerAddress = data.oriNationalTaxBase.registerAddress
                this.dataForm.businessAddress = data.oriNationalTaxBase.businessAddress
                this.dataForm.businessWay = data.oriNationalTaxBase.businessWay
                this.dataForm.telephone = data.oriNationalTaxBase.telephone
                this.dataForm.enterpriseStatus = data.oriNationalTaxBase.enterpriseStatus
                this.dataForm.taxDepartmentCode = data.oriNationalTaxBase.taxDepartmentCode
                this.dataForm.certificationDate = data.oriNationalTaxBase.certificationDate
                this.dataForm.taxRegisterDate = data.oriNationalTaxBase.taxRegisterDate
                this.dataForm.registerType = data.oriNationalTaxBase.registerType
                this.dataForm.businessDeadline = data.oriNationalTaxBase.businessDeadline
                this.dataForm.registeredCapital = data.oriNationalTaxBase.registeredCapital
                this.dataForm.currency = data.oriNationalTaxBase.currency
                this.dataForm.bank = data.oriNationalTaxBase.bank
                this.dataForm.bankDot = data.oriNationalTaxBase.bankDot
                this.dataForm.payingBankAccount = data.oriNationalTaxBase.payingBankAccount
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
              url: this.$http.adornUrl(`/spider/orinationaltaxbase/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'organizationCode': this.dataForm.organizationCode,
                'enterpriseName': this.dataForm.enterpriseName,
                'licenseRegisterNumber': this.dataForm.licenseRegisterNumber,
                'taxNumber': this.dataForm.taxNumber,
                'legal': this.dataForm.legal,
                'cardNumber': this.dataForm.cardNumber,
                'registerAddress': this.dataForm.registerAddress,
                'businessAddress': this.dataForm.businessAddress,
                'businessWay': this.dataForm.businessWay,
                'telephone': this.dataForm.telephone,
                'enterpriseStatus': this.dataForm.enterpriseStatus,
                'taxDepartmentCode': this.dataForm.taxDepartmentCode,
                'certificationDate': this.dataForm.certificationDate,
                'taxRegisterDate': this.dataForm.taxRegisterDate,
                'registerType': this.dataForm.registerType,
                'businessDeadline': this.dataForm.businessDeadline,
                'registeredCapital': this.dataForm.registeredCapital,
                'currency': this.dataForm.currency,
                'bank': this.dataForm.bank,
                'bankDot': this.dataForm.bankDot,
                'payingBankAccount': this.dataForm.payingBankAccount
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
