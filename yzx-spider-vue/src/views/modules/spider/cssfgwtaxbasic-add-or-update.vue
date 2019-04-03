<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
    <el-form-item label="数据状态" prop="isinvalid">
      <el-radio-group v-model="dataForm.isinvalid">
        <el-radio :label="0">正常</el-radio>
        <el-radio :label="1">更新</el-radio>
        <el-radio :label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <!-- <el-form-item label="数据最后修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item> -->
    <el-form-item label="组织机构代码" prop="organizationcode">
      <el-input v-model="dataForm.organizationcode" placeholder="组织机构代码"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="corporationname">
      <el-input v-model="dataForm.corporationname" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="工商营业执照注册号" prop="businesslicense">
      <el-input v-model="dataForm.businesslicense" placeholder="工商营业执照注册号"></el-input>
    </el-form-item>
    <el-form-item label="税务登记证号（国）" prop="taxcode">
      <el-input v-model="dataForm.taxcode" placeholder="税务登记证号（国）"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人（负责人）" prop="legalrepresentative">
      <el-input v-model="dataForm.legalrepresentative" placeholder="法定代表人（负责人）"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人（负责人）身份证件号" prop="legalrepresentativeidcard">
      <el-input v-model="dataForm.legalrepresentativeidcard" placeholder="法定代表人（负责人）身份证件号"></el-input>
    </el-form-item>
    <el-form-item label="注册地址" prop="registeraddress">
      <el-input v-model="dataForm.registeraddress" placeholder="注册地址"></el-input>
    </el-form-item>
    <el-form-item label="经营地址（国）" prop="businessaddress">
      <el-input v-model="dataForm.businessaddress" placeholder="经营地址（国）"></el-input>
    </el-form-item>
    <el-form-item label="经营方式" prop="businessmode">
      <el-input v-model="dataForm.businessmode" placeholder="经营方式"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="contactphone">
      <el-input v-model="dataForm.contactphone" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item label="企业状态编码（国）" prop="taxstatecode">
      <el-input v-model="dataForm.taxstatecode" placeholder="企业状态编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="税务部门编码（国）" prop="taxdeptcode">
      <el-input v-model="dataForm.taxdeptcode" placeholder="税务部门编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="发证日期" prop="issuedate">
      <el-date-picker v-model="dataForm.issuedate" placeholder="发证日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="税务登记日期（国）" prop="taxregisterdate">
      <el-date-picker v-model="dataForm.taxregisterdate" placeholder="税务登记日期（国）" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="登记注册类型" prop="registertype">
      <el-input v-model="dataForm.registertype" placeholder="登记注册类型"></el-input>
    </el-form-item>
    <el-form-item label="经营期限" prop="deadlineofbusiness">
      <el-date-picker v-model="dataForm.deadlineofbusiness" placeholder="经营期限" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="注册资本" prop="capital">
      <el-input v-model="dataForm.capital" placeholder="注册资本"></el-input>
    </el-form-item>
    <el-form-item label="注册资本币种编码" prop="capitalcode">
      <el-input v-model="dataForm.capitalcode" placeholder="注册资本币种编码"></el-input>
    </el-form-item>
    <el-form-item label="银行编码（国）" prop="taxbankcode">
      <el-input v-model="dataForm.taxbankcode" placeholder="银行编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="银行网点编码（国）" prop="taxbanknodecode">
      <el-input v-model="dataForm.taxbanknodecode" placeholder="银行网点编码（国）"></el-input>
    </el-form-item>
    <el-form-item label="缴税银行帐号（国）" prop="taxbankcard">
      <el-input v-model="dataForm.taxbankcard" placeholder="缴税银行帐号（国）"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isIDCard, isFloat, isPhone, isMobile } from '@/utils/validate'
  export default {
    data () {
      const validatePhone = function (rule, value, callback) {
        if (!isPhone(value) && !isMobile(value)) {
          callback(new Error('请输入正确的电话格式，如固定号码、区号-固定号码或移动号码'))
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
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          isinvalid: '',
          lastdate: '',
          organizationcode: '',
          corporationname: '',
          businesslicense: '',
          taxcode: '',
          legalrepresentative: '',
          legalrepresentativeidcard: '',
          registeraddress: '',
          businessaddress: '',
          businessmode: '',
          contactphone: '',
          taxstatecode: '',
          taxdeptcode: '',
          issuedate: '',
          taxregisterdate: '',
          registertype: '',
          deadlineofbusiness: '',
          capital: '',
          capitalcode: '',
          taxbankcode: '',
          taxbanknodecode: '',
          taxbankcard: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          /* lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ], */
          organizationcode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          corporationname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          businesslicense: [
            { required: true, message: '工商营业执照注册号不能为空', trigger: 'blur' }
          ],
          taxcode: [
            { required: true, message: '税务登记证号（国）不能为空', trigger: 'blur' }
          ],
          legalrepresentative: [
            { required: true, message: '法定代表人（负责人）不能为空', trigger: 'blur' }
          ],
          legalrepresentativeidcard: [
            { required: true, message: '法定代表人（负责人）身份证件号不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          registeraddress: [
            { required: true, message: '注册地址不能为空', trigger: 'blur' }
          ],
          businessaddress: [
            { required: true, message: '经营地址（国）不能为空', trigger: 'blur' }
          ],
          businessmode: [
            { required: true, message: '经营方式不能为空', trigger: 'blur' }
          ],
          contactphone: [
            { required: true, message: '电话不能为空', trigger: 'blur' },
            { validator: validatePhone, trigger: 'blur' }
          ],
          taxstatecode: [
            { required: true, message: '企业状态编码（国）不能为空', trigger: 'blur' }
          ],
          taxdeptcode: [
            { required: true, message: '税务部门编码（国）不能为空', trigger: 'blur' }
          ],
          issuedate: [
            { required: true, message: '发证日期不能为空', trigger: 'blur' }
          ],
          taxregisterdate: [
            { required: true, message: '税务登记日期（国）不能为空', trigger: 'blur' }
          ],
          registertype: [
            { required: true, message: '登记注册类型不能为空', trigger: 'blur' }
          ],
          deadlineofbusiness: [
            { required: true, message: '经营期限不能为空', trigger: 'blur' }
          ],
          capital: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          capitalcode: [
            { required: true, message: '注册资本币种编码不能为空', trigger: 'blur' }
          ],
          taxbankcode: [
            { required: true, message: '银行编码（国）不能为空', trigger: 'blur' }
          ],
          taxbanknodecode: [
            { required: true, message: '银行网点编码（国）不能为空', trigger: 'blur' }
          ],
          taxbankcard: [
            { required: true, message: '缴税银行帐号（国）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.zjid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.zjid) {
            this.$http({
              url: this.$http.adornUrl(`/spider/cssfgwtaxbasic/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwTaxBasic.isinvalid
                this.dataForm.lastdate = data.csSfgwTaxBasic.lastdate
                this.dataForm.organizationcode = data.csSfgwTaxBasic.organizationcode
                this.dataForm.corporationname = data.csSfgwTaxBasic.corporationname
                this.dataForm.businesslicense = data.csSfgwTaxBasic.businesslicense
                this.dataForm.taxcode = data.csSfgwTaxBasic.taxcode
                this.dataForm.legalrepresentative = data.csSfgwTaxBasic.legalrepresentative
                this.dataForm.legalrepresentativeidcard = data.csSfgwTaxBasic.legalrepresentativeidcard
                this.dataForm.registeraddress = data.csSfgwTaxBasic.registeraddress
                this.dataForm.businessaddress = data.csSfgwTaxBasic.businessaddress
                this.dataForm.businessmode = data.csSfgwTaxBasic.businessmode
                this.dataForm.contactphone = data.csSfgwTaxBasic.contactphone
                this.dataForm.taxstatecode = data.csSfgwTaxBasic.taxstatecode
                this.dataForm.taxdeptcode = data.csSfgwTaxBasic.taxdeptcode
                this.dataForm.issuedate = data.csSfgwTaxBasic.issuedate
                this.dataForm.taxregisterdate = data.csSfgwTaxBasic.taxregisterdate
                this.dataForm.registertype = data.csSfgwTaxBasic.registertype
                this.dataForm.deadlineofbusiness = data.csSfgwTaxBasic.deadlineofbusiness
                this.dataForm.capital = data.csSfgwTaxBasic.capital
                this.dataForm.capitalcode = data.csSfgwTaxBasic.capitalcode
                this.dataForm.taxbankcode = data.csSfgwTaxBasic.taxbankcode
                this.dataForm.taxbanknodecode = data.csSfgwTaxBasic.taxbanknodecode
                this.dataForm.taxbankcard = data.csSfgwTaxBasic.taxbankcard
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
              url: this.$http.adornUrl(`/spider/cssfgwtaxbasic/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'organizationcode': this.dataForm.organizationcode,
                'corporationname': this.dataForm.corporationname,
                'businesslicense': this.dataForm.businesslicense,
                'taxcode': this.dataForm.taxcode,
                'legalrepresentative': this.dataForm.legalrepresentative,
                'legalrepresentativeidcard': this.dataForm.legalrepresentativeidcard,
                'registeraddress': this.dataForm.registeraddress,
                'businessaddress': this.dataForm.businessaddress,
                'businessmode': this.dataForm.businessmode,
                'contactphone': this.dataForm.contactphone,
                'taxstatecode': this.dataForm.taxstatecode,
                'taxdeptcode': this.dataForm.taxdeptcode,
                'issuedate': this.dataForm.issuedate,
                'taxregisterdate': this.dataForm.taxregisterdate,
                'registertype': this.dataForm.registertype,
                'deadlineofbusiness': this.dataForm.deadlineofbusiness,
                'capital': this.dataForm.capital,
                'capitalcode': this.dataForm.capitalcode,
                'taxbankcode': this.dataForm.taxbankcode,
                'taxbanknodecode': this.dataForm.taxbanknodecode,
                'taxbankcard': this.dataForm.taxbankcard,
                'zjid': this.dataForm.zjid || undefined
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
