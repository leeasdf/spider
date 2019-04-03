<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
    
    <el-form-item label="纳税人名称" prop="taxpayerName">
      <el-input v-model="dataForm.taxpayerName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="uniformSocialCreditCode">
      <el-input v-model="dataForm.uniformSocialCreditCode" placeholder="统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="组织机构代码" prop="organizationCode">
      <el-input v-model="dataForm.organizationCode" placeholder="组织机构代码"></el-input>
    </el-form-item>
    <el-form-item label="工商登记码" prop="businessRegistrationCode">
      <el-input v-model="dataForm.businessRegistrationCode" placeholder="工商登记码"></el-input>
    </el-form-item>
    <el-form-item label="税务登记码" prop="taxRegistrationCode">
      <el-input v-model="dataForm.taxRegistrationCode" placeholder="税务登记码"></el-input>
    </el-form-item>
    <el-form-item label="居民身份证号" prop="certNo">
      <el-input v-model="dataForm.certNo" placeholder="居民身份证号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人" prop="legalRepresentative">
      <el-input v-model="dataForm.legalRepresentative" placeholder="法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="evaluationYear">
      <!-- <el-input v-model="dataForm.evaluationYear" placeholder="评价年度"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.evaluationYear" placeholder="评价年度"></el-date-picker>
    </el-form-item>
    <el-form-item label="信用级别A" prop="creditRating">
      <el-input v-model="dataForm.creditRating" placeholder="信用级别A"></el-input>
    </el-form-item>
    <el-form-item label="主管税务机关" prop="taxAuthority">
      <el-input v-model="dataForm.taxAuthority" placeholder="主管税务机关"></el-input>
    </el-form-item>
    <!-- <el-form-item label="数据更新时间戳" prop="dataUpdateTime">
      <el-input v-model="dataForm.dataUpdateTime" placeholder="数据更新时间戳"></el-input>
    </el-form-item> -->
    
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isIDCard } from '@/utils/validate'
  export default {
    data () {
      const validateIDCard = function (rule, value, callback) {
        if (!isIDCard(value)) {
          callback(new Error('身份证号格式错误'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          taxpayerName: '',
          uniformSocialCreditCode: '',
          organizationCode: '',
          businessRegistrationCode: '',
          taxRegistrationCode: '',
          certNo: '',
          legalRepresentative: '',
          evaluationYear: '',
          creditRating: '',
          taxAuthority: '',
          dataUpdateTime: '',
          createTime: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ], */
          taxpayerName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          uniformSocialCreditCode: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          organizationCode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          businessRegistrationCode: [
            { required: true, message: '工商登记码不能为空', trigger: 'blur' }
          ],
          taxRegistrationCode: [
            { required: true, message: '税务登记码不能为空', trigger: 'blur' }
          ],
          certNo: [
            { required: true, message: '居民身份证号不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          legalRepresentative: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          evaluationYear: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          creditRating: [
            { required: true, message: '信用级别A不能为空', trigger: 'blur' }
          ],
          taxAuthority: [
            { required: true, message: '主管税务机关不能为空', trigger: 'blur' }
          ]
          /* dataUpdateTime: [
            { required: true, message: '数据更新时间戳不能为空', trigger: 'blur' }
          ] */
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
              url: this.$http.adornUrl(`/spider/orienterprisetaxtaxpayer/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.oriEnterpriseTaxTaxpayer.enterpriseId
                this.dataForm.taxpayerName = data.oriEnterpriseTaxTaxpayer.taxpayerName
                this.dataForm.uniformSocialCreditCode = data.oriEnterpriseTaxTaxpayer.uniformSocialCreditCode
                this.dataForm.organizationCode = data.oriEnterpriseTaxTaxpayer.organizationCode
                this.dataForm.businessRegistrationCode = data.oriEnterpriseTaxTaxpayer.businessRegistrationCode
                this.dataForm.taxRegistrationCode = data.oriEnterpriseTaxTaxpayer.taxRegistrationCode
                this.dataForm.certNo = data.oriEnterpriseTaxTaxpayer.certNo
                this.dataForm.legalRepresentative = data.oriEnterpriseTaxTaxpayer.legalRepresentative
                this.dataForm.evaluationYear = data.oriEnterpriseTaxTaxpayer.evaluationYear
                this.dataForm.creditRating = data.oriEnterpriseTaxTaxpayer.creditRating
                this.dataForm.taxAuthority = data.oriEnterpriseTaxTaxpayer.taxAuthority
                this.dataForm.dataUpdateTime = data.oriEnterpriseTaxTaxpayer.dataUpdateTime
                this.dataForm.createTime = data.oriEnterpriseTaxTaxpayer.createTime
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
              url: this.$http.adornUrl(`/spider/orienterprisetaxtaxpayer/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'taxpayerName': this.dataForm.taxpayerName,
                'uniformSocialCreditCode': this.dataForm.uniformSocialCreditCode,
                'organizationCode': this.dataForm.organizationCode,
                'businessRegistrationCode': this.dataForm.businessRegistrationCode,
                'taxRegistrationCode': this.dataForm.taxRegistrationCode,
                'certNo': this.dataForm.certNo,
                'legalRepresentative': this.dataForm.legalRepresentative,
                'evaluationYear': this.dataForm.evaluationYear,
                'creditRating': this.dataForm.creditRating,
                'taxAuthority': this.dataForm.taxAuthority,
                'dataUpdateTime': this.dataForm.dataUpdateTime,
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
