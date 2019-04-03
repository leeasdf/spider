<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="130px">
    
    <el-form-item label="欠税人名称" prop="owingName">
      <el-input v-model="dataForm.owingName" placeholder="欠税人名称"></el-input>
    </el-form-item>
    <el-form-item label="欠税人识别号" prop="taxRegistrationCode">
      <el-input v-model="dataForm.taxRegistrationCode" placeholder="欠税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人" prop="legalRepresentative">
      <el-input v-model="dataForm.legalRepresentative" placeholder="法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人（负责人）身份证件号" prop="certNo">
      <el-input v-model="dataForm.certNo" placeholder="法定代表人（负责人）身份证件号"></el-input>
    </el-form-item>
    <el-form-item label="欠税余额" prop="amount">
      <el-input v-model="dataForm.amount" placeholder="欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="生产经营地址" prop="address">
      <el-input v-model="dataForm.address" placeholder="生产经营地址"></el-input>
    </el-form-item>
    <el-form-item label="公告日期" prop="declarationDate">
      <el-date-picker v-model="dataForm.declarationDate" placeholder="公告日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isIDCard, isFloat } from '@/utils/validate'
  export default {
    data () {
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
          id: 0,
          enterpriseId: '',
          owingName: '',
          taxRegistrationCode: '',
          legalRepresentative: '',
          certNo: '',
          amount: '',
          address: '',
          declarationDate: '',
          createTime: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ], */
          owingName: [
            { required: true, message: '欠税人名称不能为空', trigger: 'blur' }
          ],
          taxRegistrationCode: [
            { required: true, message: '欠税人识别号不能为空', trigger: 'blur' }
          ],
          legalRepresentative: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          certNo: [
            { required: true, message: '法定代表人（负责人）身份证件号不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          address: [
            { required: true, message: '生产经营地址不能为空', trigger: 'blur' }
          ],
          declarationDate: [
            { required: true, message: '公告日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/orienterprisetaxowing/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.oriEnterpriseTaxOwing.enterpriseId
                this.dataForm.owingName = data.oriEnterpriseTaxOwing.owingName
                this.dataForm.taxRegistrationCode = data.oriEnterpriseTaxOwing.taxRegistrationCode
                this.dataForm.legalRepresentative = data.oriEnterpriseTaxOwing.legalRepresentative
                this.dataForm.certNo = data.oriEnterpriseTaxOwing.certNo
                this.dataForm.amount = data.oriEnterpriseTaxOwing.amount
                this.dataForm.address = data.oriEnterpriseTaxOwing.address
                this.dataForm.declarationDate = data.oriEnterpriseTaxOwing.declarationDate
                this.dataForm.createTime = data.oriEnterpriseTaxOwing.createTime
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
              url: this.$http.adornUrl(`/spider/orienterprisetaxowing/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'owingName': this.dataForm.owingName,
                'taxRegistrationCode': this.dataForm.taxRegistrationCode,
                'legalRepresentative': this.dataForm.legalRepresentative,
                'certNo': this.dataForm.certNo,
                'amount': this.dataForm.amount,
                'address': this.dataForm.address,
                'declarationDate': this.dataForm.declarationDate,
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
