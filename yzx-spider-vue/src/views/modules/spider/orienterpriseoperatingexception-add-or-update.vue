<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="200px">
    
    <!-- <el-form-item label="经营异常名录ID" prop="operatingExceptionListId">
      <el-input v-model="dataForm.operatingExceptionListId" placeholder="经营异常名录ID"></el-input>
    </el-form-item> -->
    <el-form-item label="主体身份代码" prop="subjectIdentityCode">
      <el-input v-model="dataForm.subjectIdentityCode" placeholder="主体身份代码"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="uniformSocialCreditCode">
      <el-input v-model="dataForm.uniformSocialCreditCode" placeholder="统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="注册码" prop="registerCode">
      <el-input v-model="dataForm.registerCode" placeholder="注册码"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人" prop="legalRepresentative">
      <el-input v-model="dataForm.legalRepresentative" placeholder="法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="证件类型" prop="certType">
      <el-input v-model="dataForm.certType" placeholder="证件类型"></el-input>
    </el-form-item>
    <el-form-item label="证件号码" prop="certNo">
      <el-input v-model="dataForm.certNo" placeholder="证件号码"></el-input>
    </el-form-item>
    <el-form-item label="列入经营异常名录原因类型" prop="includedReasonType">
      <el-input v-model="dataForm.includedReasonType" placeholder="列入经营异常名录原因类型"></el-input>
    </el-form-item>
    <el-form-item label="列入经营异常名录原因类型名称" prop="includedReasonName">
      <el-input v-model="dataForm.includedReasonName" placeholder="列入经营异常名录原因类型名称"></el-input>
    </el-form-item>
    <el-form-item label="列入日期" prop="includedDatetime">
      <el-date-picker v-model="dataForm.includedDatetime" placeholder="列入日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="列入决定机关" prop="includedOrganizationCode">
      <el-input v-model="dataForm.includedOrganizationCode" placeholder="列入决定机关"></el-input>
    </el-form-item>
    <el-form-item label="列入决定机关名称" prop="includedOrganizationName">
      <el-input v-model="dataForm.includedOrganizationName" placeholder="列入决定机关名称"></el-input>
    </el-form-item>
    <el-form-item label="是否移出" prop="outFlag">
      <el-input v-model="dataForm.outFlag" placeholder="是否移出"></el-input>
    </el-form-item>
    <el-form-item label="移出经营异常名录原因" prop="outReason">
      <el-input v-model="dataForm.outReason" placeholder="移出经营异常名录原因"></el-input>
    </el-form-item>
    <el-form-item label="移出经营异常名录原因名称" prop="outReasonName">
      <el-input v-model="dataForm.outReasonName" placeholder="移出经营异常名录原因名称"></el-input>
    </el-form-item>
    <el-form-item label="移出日期" prop="outDatetime">
      <el-date-picker v-model="dataForm.outDatetime" placeholder="移出日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="移出决定机关" prop="outOrganizationCode">
      <el-input v-model="dataForm.outOrganizationCode" placeholder="移出决定机关"></el-input>
    </el-form-item>
    <el-form-item label="移出决定机关名称" prop="outOrganizationName">
      <el-input v-model="dataForm.outOrganizationName" placeholder="移出决定机关名称"></el-input>
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
          enterpriseId: '',
          operatingExceptionListId: '',
          subjectIdentityCode: '',
          enterpriseName: '',
          uniformSocialCreditCode: '',
          registerCode: '',
          legalRepresentative: '',
          certType: '',
          certNo: '',
          includedReasonType: '',
          includedReasonName: '',
          includedDatetime: '',
          includedOrganizationCode: '',
          includedOrganizationName: '',
          outFlag: '',
          outReason: '',
          outReasonName: '',
          outDatetime: '',
          outOrganizationCode: '',
          outOrganizationName: '',
          createTime: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          operatingExceptionListId: [
            { required: true, message: '经营异常名录ID不能为空', trigger: 'blur' }
          ],
          subjectIdentityCode: [
            { required: true, message: '主体身份代码不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          uniformSocialCreditCode: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          registerCode: [
            { required: true, message: '注册码不能为空', trigger: 'blur' }
          ],
          legalRepresentative: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          certType: [
            { required: true, message: '证件类型不能为空', trigger: 'blur' }
          ],
          certNo: [
            { required: true, message: '证件号码不能为空', trigger: 'blur' }
          ],
          includedReasonType: [
            { required: true, message: '列入经营异常名录原因类型不能为空', trigger: 'blur' }
          ],
          includedReasonName: [
            { required: true, message: '列入经营异常名录原因类型名称不能为空', trigger: 'blur' }
          ],
          includedDatetime: [
            { required: true, message: '列入日期不能为空', trigger: 'blur' }
          ],
          includedOrganizationCode: [
            { required: true, message: '列入决定机关不能为空', trigger: 'blur' }
          ],
          includedOrganizationName: [
            { required: true, message: '列入决定机关名称不能为空', trigger: 'blur' }
          ],
          outFlag: [
            { required: true, message: '是否移出不能为空', trigger: 'blur' }
          ],
          outReason: [
            { required: true, message: '移出经营异常名录原因不能为空', trigger: 'blur' }
          ],
          outReasonName: [
            { required: true, message: '移出经营异常名录原因名称不能为空', trigger: 'blur' }
          ],
          outDatetime: [
            { required: true, message: '移出日期不能为空', trigger: 'blur' }
          ],
          outOrganizationCode: [
            { required: true, message: '移出决定机关不能为空', trigger: 'blur' }
          ],
          outOrganizationName: [
            { required: true, message: '移出决定机关名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/orienterpriseoperatingexception/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.oriEnterpriseOperatingException.enterpriseId
                this.dataForm.operatingExceptionListId = data.oriEnterpriseOperatingException.operatingExceptionListId
                this.dataForm.subjectIdentityCode = data.oriEnterpriseOperatingException.subjectIdentityCode
                this.dataForm.enterpriseName = data.oriEnterpriseOperatingException.enterpriseName
                this.dataForm.uniformSocialCreditCode = data.oriEnterpriseOperatingException.uniformSocialCreditCode
                this.dataForm.registerCode = data.oriEnterpriseOperatingException.registerCode
                this.dataForm.legalRepresentative = data.oriEnterpriseOperatingException.legalRepresentative
                this.dataForm.certType = data.oriEnterpriseOperatingException.certType
                this.dataForm.certNo = data.oriEnterpriseOperatingException.certNo
                this.dataForm.includedReasonType = data.oriEnterpriseOperatingException.includedReasonType
                this.dataForm.includedReasonName = data.oriEnterpriseOperatingException.includedReasonName
                this.dataForm.includedDatetime = data.oriEnterpriseOperatingException.includedDatetime
                this.dataForm.includedOrganizationCode = data.oriEnterpriseOperatingException.includedOrganizationCode
                this.dataForm.includedOrganizationName = data.oriEnterpriseOperatingException.includedOrganizationName
                this.dataForm.outFlag = data.oriEnterpriseOperatingException.outFlag
                this.dataForm.outReason = data.oriEnterpriseOperatingException.outReason
                this.dataForm.outReasonName = data.oriEnterpriseOperatingException.outReasonName
                this.dataForm.outDatetime = data.oriEnterpriseOperatingException.outDatetime
                this.dataForm.outOrganizationCode = data.oriEnterpriseOperatingException.outOrganizationCode
                this.dataForm.outOrganizationName = data.oriEnterpriseOperatingException.outOrganizationName
                this.dataForm.createTime = data.oriEnterpriseOperatingException.createTime
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
              url: this.$http.adornUrl(`/spider/orienterpriseoperatingexception/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'operatingExceptionListId': this.dataForm.operatingExceptionListId,
                'subjectIdentityCode': this.dataForm.subjectIdentityCode,
                'enterpriseName': this.dataForm.enterpriseName,
                'uniformSocialCreditCode': this.dataForm.uniformSocialCreditCode,
                'registerCode': this.dataForm.registerCode,
                'legalRepresentative': this.dataForm.legalRepresentative,
                'certType': this.dataForm.certType,
                'certNo': this.dataForm.certNo,
                'includedReasonType': this.dataForm.includedReasonType,
                'includedReasonName': this.dataForm.includedReasonName,
                'includedDatetime': this.dataForm.includedDatetime,
                'includedOrganizationCode': this.dataForm.includedOrganizationCode,
                'includedOrganizationName': this.dataForm.includedOrganizationName,
                'outFlag': this.dataForm.outFlag,
                'outReason': this.dataForm.outReason,
                'outReasonName': this.dataForm.outReasonName,
                'outDatetime': this.dataForm.outDatetime,
                'outOrganizationCode': this.dataForm.outOrganizationCode,
                'outOrganizationName': this.dataForm.outOrganizationName,
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
