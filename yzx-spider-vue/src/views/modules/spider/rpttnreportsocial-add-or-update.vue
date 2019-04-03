<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="年报主键" prop="reportId">
      <el-input v-model="dataForm.reportId" placeholder="年报主键"></el-input>
    </el-form-item>
    <el-form-item label="单位参加工伤保险缴费基数" prop="injuryRadix">
      <el-input v-model="dataForm.injuryRadix" placeholder="单位参加工伤保险缴费基数"></el-input>
    </el-form-item>
    <el-form-item label="工伤保险" prop="injuryNum">
      <el-input v-model="dataForm.injuryNum" placeholder="工伤保险"></el-input>
    </el-form-item>
    <el-form-item label="参加工伤保险本期实际缴费金额" prop="injuryAmount">
      <el-input v-model="dataForm.injuryAmount" placeholder="参加工伤保险本期实际缴费金额"></el-input>
    </el-form-item>
    <el-form-item label="参加失业保险本期实际缴费金额" prop="unemployAmount">
      <el-input v-model="dataForm.unemployAmount" placeholder="参加失业保险本期实际缴费金额"></el-input>
    </el-form-item>
    <el-form-item label="单位参加职工基本医疗保险累积欠缴金额" prop="medicalnsureOweAmount">
      <el-input v-model="dataForm.medicalnsureOweAmount" placeholder="单位参加职工基本医疗保险累积欠缴金额"></el-input>
    </el-form-item>
    <el-form-item label="参加城镇职工基本养老保险本期实际缴费金额" prop="oldAgeAmount">
      <el-input v-model="dataForm.oldAgeAmount" placeholder="参加城镇职工基本养老保险本期实际缴费金额"></el-input>
    </el-form-item>
    <el-form-item label="城镇职工基本养老保险" prop="oldAgeNum">
      <el-input v-model="dataForm.oldAgeNum" placeholder="城镇职工基本养老保险"></el-input>
    </el-form-item>
    <el-form-item label="失业保险" prop="unemployNum">
      <el-input v-model="dataForm.unemployNum" placeholder="失业保险"></el-input>
    </el-form-item>
    <el-form-item label="职工基本医疗保险" prop="medicalNum">
      <el-input v-model="dataForm.medicalNum" placeholder="职工基本医疗保险"></el-input>
    </el-form-item>
    <el-form-item label="生育保险" prop="maternityNum">
      <el-input v-model="dataForm.maternityNum" placeholder="生育保险"></el-input>
    </el-form-item>
    <el-form-item label="单位参加生育保险缴费基数" prop="maternityRadix">
      <el-input v-model="dataForm.maternityRadix" placeholder="单位参加生育保险缴费基数"></el-input>
    </el-form-item>
    <el-form-item label="单位参加工伤保险累积欠缴金额" prop="injuryinsureOweAmount">
      <el-input v-model="dataForm.injuryinsureOweAmount" placeholder="单位参加工伤保险累积欠缴金额"></el-input>
    </el-form-item>
    <el-form-item label="单位参加城镇职工基本养老保险缴费基数" prop="oldAgeRadix">
      <el-input v-model="dataForm.oldAgeRadix" placeholder="单位参加城镇职工基本养老保险缴费基数"></el-input>
    </el-form-item>
    <el-form-item label="单位参加城镇职工基本养老保险累积欠缴金额" prop="oldAgelnsureOweAmount">
      <el-input v-model="dataForm.oldAgelnsureOweAmount" placeholder="单位参加城镇职工基本养老保险累积欠缴金额"></el-input>
    </el-form-item>
    <el-form-item label="参加职工基本医疗保险本期实际缴费金额" prop="medicalAmount">
      <el-input v-model="dataForm.medicalAmount" placeholder="参加职工基本医疗保险本期实际缴费金额"></el-input>
    </el-form-item>
    <el-form-item label="单位参加失业保险缴费基数" prop="unemployRadix">
      <el-input v-model="dataForm.unemployRadix" placeholder="单位参加失业保险缴费基数"></el-input>
    </el-form-item>
    <el-form-item label="单位参加生育保险累积欠缴金额" prop="maternityInsureOweAmount">
      <el-input v-model="dataForm.maternityInsureOweAmount" placeholder="单位参加生育保险累积欠缴金额"></el-input>
    </el-form-item>
    <el-form-item label="参加生育保险本期实际缴费金额" prop="maternityAmount">
      <el-input v-model="dataForm.maternityAmount" placeholder="参加生育保险本期实际缴费金额"></el-input>
    </el-form-item>
    <el-form-item label="单位参加失业保险累积欠缴金额" prop="unemploylnsureOweAmount">
      <el-input v-model="dataForm.unemploylnsureOweAmount" placeholder="单位参加失业保险累积欠缴金额"></el-input>
    </el-form-item>
    <el-form-item label="单位参加职工基本医疗保险缴费基数" prop="medicalRadix">
      <el-input v-model="dataForm.medicalRadix" placeholder="单位参加职工基本医疗保险缴费基数"></el-input>
    </el-form-item>
    <el-form-item label="创建人ID" prop="creator">
      <el-input v-model="dataForm.creator" placeholder="创建人ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人ID" prop="updater">
      <el-input v-model="dataForm.updater" placeholder="修改人ID"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="数据状态：1-正常 0-删除" prop="dataState">
      <el-input v-model="dataForm.dataState" placeholder="数据状态：1-正常 0-删除"></el-input>
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
          entName: '',
          reportId: '',
          injuryRadix: '',
          injuryNum: '',
          injuryAmount: '',
          unemployAmount: '',
          medicalnsureOweAmount: '',
          oldAgeAmount: '',
          oldAgeNum: '',
          unemployNum: '',
          medicalNum: '',
          maternityNum: '',
          maternityRadix: '',
          injuryinsureOweAmount: '',
          oldAgeRadix: '',
          oldAgelnsureOweAmount: '',
          medicalAmount: '',
          unemployRadix: '',
          maternityInsureOweAmount: '',
          maternityAmount: '',
          unemploylnsureOweAmount: '',
          medicalRadix: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          reportId: [
            { required: true, message: '年报主键不能为空', trigger: 'blur' }
          ],
          injuryRadix: [
            { required: true, message: '单位参加工伤保险缴费基数不能为空', trigger: 'blur' }
          ],
          injuryNum: [
            { required: true, message: '工伤保险不能为空', trigger: 'blur' }
          ],
          injuryAmount: [
            { required: true, message: '参加工伤保险本期实际缴费金额不能为空', trigger: 'blur' }
          ],
          unemployAmount: [
            { required: true, message: '参加失业保险本期实际缴费金额不能为空', trigger: 'blur' }
          ],
          medicalnsureOweAmount: [
            { required: true, message: '单位参加职工基本医疗保险累积欠缴金额不能为空', trigger: 'blur' }
          ],
          oldAgeAmount: [
            { required: true, message: '参加城镇职工基本养老保险本期实际缴费金额不能为空', trigger: 'blur' }
          ],
          oldAgeNum: [
            { required: true, message: '城镇职工基本养老保险不能为空', trigger: 'blur' }
          ],
          unemployNum: [
            { required: true, message: '失业保险不能为空', trigger: 'blur' }
          ],
          medicalNum: [
            { required: true, message: '职工基本医疗保险不能为空', trigger: 'blur' }
          ],
          maternityNum: [
            { required: true, message: '生育保险不能为空', trigger: 'blur' }
          ],
          maternityRadix: [
            { required: true, message: '单位参加生育保险缴费基数不能为空', trigger: 'blur' }
          ],
          injuryinsureOweAmount: [
            { required: true, message: '单位参加工伤保险累积欠缴金额不能为空', trigger: 'blur' }
          ],
          oldAgeRadix: [
            { required: true, message: '单位参加城镇职工基本养老保险缴费基数不能为空', trigger: 'blur' }
          ],
          oldAgelnsureOweAmount: [
            { required: true, message: '单位参加城镇职工基本养老保险累积欠缴金额不能为空', trigger: 'blur' }
          ],
          medicalAmount: [
            { required: true, message: '参加职工基本医疗保险本期实际缴费金额不能为空', trigger: 'blur' }
          ],
          unemployRadix: [
            { required: true, message: '单位参加失业保险缴费基数不能为空', trigger: 'blur' }
          ],
          maternityInsureOweAmount: [
            { required: true, message: '单位参加生育保险累积欠缴金额不能为空', trigger: 'blur' }
          ],
          maternityAmount: [
            { required: true, message: '参加生育保险本期实际缴费金额不能为空', trigger: 'blur' }
          ],
          unemploylnsureOweAmount: [
            { required: true, message: '单位参加失业保险累积欠缴金额不能为空', trigger: 'blur' }
          ],
          medicalRadix: [
            { required: true, message: '单位参加职工基本医疗保险缴费基数不能为空', trigger: 'blur' }
          ],
          creator: [
            { required: true, message: '创建人ID不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updater: [
            { required: true, message: '修改人ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnreportsocial/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnReportSocial.enterpriseId
                this.dataForm.entName = data.rptTnReportSocial.entName
                this.dataForm.reportId = data.rptTnReportSocial.reportId
                this.dataForm.injuryRadix = data.rptTnReportSocial.injuryRadix
                this.dataForm.injuryNum = data.rptTnReportSocial.injuryNum
                this.dataForm.injuryAmount = data.rptTnReportSocial.injuryAmount
                this.dataForm.unemployAmount = data.rptTnReportSocial.unemployAmount
                this.dataForm.medicalnsureOweAmount = data.rptTnReportSocial.medicalnsureOweAmount
                this.dataForm.oldAgeAmount = data.rptTnReportSocial.oldAgeAmount
                this.dataForm.oldAgeNum = data.rptTnReportSocial.oldAgeNum
                this.dataForm.unemployNum = data.rptTnReportSocial.unemployNum
                this.dataForm.medicalNum = data.rptTnReportSocial.medicalNum
                this.dataForm.maternityNum = data.rptTnReportSocial.maternityNum
                this.dataForm.maternityRadix = data.rptTnReportSocial.maternityRadix
                this.dataForm.injuryinsureOweAmount = data.rptTnReportSocial.injuryinsureOweAmount
                this.dataForm.oldAgeRadix = data.rptTnReportSocial.oldAgeRadix
                this.dataForm.oldAgelnsureOweAmount = data.rptTnReportSocial.oldAgelnsureOweAmount
                this.dataForm.medicalAmount = data.rptTnReportSocial.medicalAmount
                this.dataForm.unemployRadix = data.rptTnReportSocial.unemployRadix
                this.dataForm.maternityInsureOweAmount = data.rptTnReportSocial.maternityInsureOweAmount
                this.dataForm.maternityAmount = data.rptTnReportSocial.maternityAmount
                this.dataForm.unemploylnsureOweAmount = data.rptTnReportSocial.unemploylnsureOweAmount
                this.dataForm.medicalRadix = data.rptTnReportSocial.medicalRadix
                this.dataForm.creator = data.rptTnReportSocial.creator
                this.dataForm.createTime = data.rptTnReportSocial.createTime
                this.dataForm.updater = data.rptTnReportSocial.updater
                this.dataForm.updateTime = data.rptTnReportSocial.updateTime
                this.dataForm.dataState = data.rptTnReportSocial.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnreportsocial/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'reportId': this.dataForm.reportId,
                'injuryRadix': this.dataForm.injuryRadix,
                'injuryNum': this.dataForm.injuryNum,
                'injuryAmount': this.dataForm.injuryAmount,
                'unemployAmount': this.dataForm.unemployAmount,
                'medicalnsureOweAmount': this.dataForm.medicalnsureOweAmount,
                'oldAgeAmount': this.dataForm.oldAgeAmount,
                'oldAgeNum': this.dataForm.oldAgeNum,
                'unemployNum': this.dataForm.unemployNum,
                'medicalNum': this.dataForm.medicalNum,
                'maternityNum': this.dataForm.maternityNum,
                'maternityRadix': this.dataForm.maternityRadix,
                'injuryinsureOweAmount': this.dataForm.injuryinsureOweAmount,
                'oldAgeRadix': this.dataForm.oldAgeRadix,
                'oldAgelnsureOweAmount': this.dataForm.oldAgelnsureOweAmount,
                'medicalAmount': this.dataForm.medicalAmount,
                'unemployRadix': this.dataForm.unemployRadix,
                'maternityInsureOweAmount': this.dataForm.maternityInsureOweAmount,
                'maternityAmount': this.dataForm.maternityAmount,
                'unemploylnsureOweAmount': this.dataForm.unemploylnsureOweAmount,
                'medicalRadix': this.dataForm.medicalRadix,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState
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
