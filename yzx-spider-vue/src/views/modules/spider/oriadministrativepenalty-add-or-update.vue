<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
    <!-- <el-form-item label="序号" prop="no">
      <el-input v-model="dataForm.no" placeholder="序号"></el-input>
    </el-form-item> -->
    <el-form-item label="污染源编号" prop="pollutionSourceNumber">
      <el-input v-model="dataForm.pollutionSourceNumber" placeholder="污染源编号"></el-input>
    </el-form-item>
    <el-form-item label="污染源名称" prop="pollutionSourceName">
      <el-input v-model="dataForm.pollutionSourceName" placeholder="污染源名称"></el-input>
    </el-form-item>
    <el-form-item label="年度" prop="year">
      <el-date-picker type="year" v-model="dataForm.year" placeholder="年度"></el-date-picker>
    </el-form-item>
    <el-form-item label="处罚主体" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="处罚主体"></el-input>
    </el-form-item>
    <el-form-item label="调查机构" prop="investigationOrganization">
      <el-input v-model="dataForm.investigationOrganization" placeholder="调查机构"></el-input>
    </el-form-item>
    <el-form-item label="立案号" prop="caseNumber">
      <el-input v-model="dataForm.caseNumber" placeholder="立案号"></el-input>
    </el-form-item>
    <el-form-item label="决定书文号" prop="decisionDocument">
      <el-input v-model="dataForm.decisionDocument" placeholder="决定书文号"></el-input>
    </el-form-item>
    <el-form-item label="立案日期" prop="caseDate">
      <el-date-picker v-model="dataForm.caseDate" placeholder="立案日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="案情简介" prop="caseIntroduction">
      <el-input v-model="dataForm.caseIntroduction" placeholder="案情简介"></el-input>
    </el-form-item>
    <el-form-item label="主要违法行为" prop="majorViolations">
      <el-input v-model="dataForm.majorViolations" placeholder="主要违法行为"></el-input>
    </el-form-item>
    <el-form-item label="处罚依据" prop="punishmentBasis">
      <el-input type="textarea" v-model="dataForm.punishmentBasis" placeholder="处罚依据"></el-input>
    </el-form-item>
    <el-form-item label="处罚种类" prop="punishmentType">
      <el-input v-model="dataForm.punishmentType" placeholder="处罚种类"></el-input>
    </el-form-item>
    <el-form-item label="罚款数额" prop="fineFee">
      <el-input v-model="dataForm.fineFee" placeholder="罚款数额">
        <span slot="append">万元</span>
      </el-input>
    </el-form-item>
    <el-form-item label="行政命令种类" prop="administrativeDecree">
      <el-input v-model="dataForm.administrativeDecree" placeholder="行政命令种类"></el-input>
    </el-form-item>
    <el-form-item label="是否举行听证" prop="isHearing">
      <el-radio-group v-model="dataForm.isHearing">
        <el-radio label="是">是</el-radio>
        <el-radio label="否">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="决定下达日期" prop="decideDate">
      <el-date-picker v-model="dataForm.decideDate" placeholder="决定下达日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="决定书内容" prop="decideContent">
      <el-input v-model="dataForm.decideContent" placeholder="决定书内容"></el-input>
    </el-form-item>
    <el-form-item label="执行情况" prop="implementation">
      <el-input v-model="dataForm.implementation" placeholder="执行情况"></el-input>
    </el-form-item>
    <el-form-item label="执行完毕日期" prop="executionDate">
      <el-date-picker v-model="dataForm.executionDate" placeholder="执行完毕日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="复议结果" prop="reconsiderationResult">
      <el-input v-model="dataForm.reconsiderationResult" placeholder="复议结果"></el-input>
    </el-form-item>
    <el-form-item label="诉讼结果" prop="lawsuitResult">
      <el-input v-model="dataForm.lawsuitResult" placeholder="诉讼结果"></el-input>
    </el-form-item>
    <el-form-item label="移送信息" prop="transferInformation">
      <el-input v-model="dataForm.transferInformation" placeholder="移送信息"></el-input>
    </el-form-item>
    <el-form-item label="结案日期" prop="closeDate">
      <el-date-picker v-model="dataForm.closeDate" placeholder="结案日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="是否结案" prop="isClose">
      <el-radio-group v-model="dataForm.isClose">
        <el-radio label="Y">已结案</el-radio>
        <el-radio label="N">未结案</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="案卷号" prop="fileNumber">
      <el-input v-model="dataForm.fileNumber" placeholder="案卷号"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    
    <!-- <el-form-item label="修改时间" prop="updateTine">
      <el-input v-model="dataForm.updateTine" placeholder="修改时间"></el-input>
    </el-form-item> -->
    <el-form-item label="数据来源" prop="resource">
      <el-input v-model="dataForm.resource" placeholder="数据来源"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="status">
      <el-radio-group v-model="dataForm.isClose">
        <el-radio label="0">新增</el-radio>
        <el-radio label="1">修改</el-radio>
        <el-radio label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="是否已交换" prop="exchangeStatus">
      <el-radio-group v-model="dataForm.exchangeStatus">
        <el-radio label="Y">已交换</el-radio>
        <el-radio label="N">未交换</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="审核状态" prop="examineStatus">
      <el-input v-model="dataForm.examineStatus" placeholder="审核状态"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="creditCode">
      <el-input v-model="dataForm.creditCode" placeholder="统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="作出决定的相关材料" prop="relatedMaterials">
      <el-input v-model="dataForm.relatedMaterials" placeholder="作出决定的相关材料"></el-input>
    </el-form-item>
    <el-form-item label="违法案件类型" prop="casesType">
      <el-input v-model="dataForm.casesType" placeholder="违法案件类型"></el-input>
    </el-form-item>
    <!-- <el-form-item label="更新时间戳" prop="timestamp">
      <el-input v-model="dataForm.timestamp" placeholder="更新时间戳"></el-input>
    </el-form-item> -->
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
          no: '',
          pollutionSourceNumber: '',
          pollutionSourceName: '',
          year: '',
          enterpriseName: '',
          investigationOrganization: '',
          caseNumber: '',
          decisionDocument: '',
          caseDate: '',
          caseIntroduction: '',
          majorViolations: '',
          punishmentBasis: '',
          punishmentType: '',
          fineFee: '',
          administrativeDecree: '',
          isHearing: '',
          decideDate: '',
          decideContent: '',
          implementation: '',
          executionDate: '',
          reconsiderationResult: '',
          lawsuitResult: '',
          transferInformation: '',
          closeDate: '',
          isClose: '',
          fileNumber: '',
          remark: '',
          createTime: '',
          updateTine: '',
          resource: '',
          status: '',
          exchangeStatus: '',
          examineStatus: '',
          creditCode: '',
          relatedMaterials: '',
          casesType: '',
          timestamp: ''
        },
        dataRule: {
          no: [
            { required: true, message: '序号不能为空', trigger: 'blur' }
          ],
          pollutionSourceNumber: [
            { required: true, message: '污染源编号不能为空', trigger: 'blur' }
          ],
          pollutionSourceName: [
            { required: true, message: '污染源名称不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '年度不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '处罚主体不能为空', trigger: 'blur' }
          ],
          investigationOrganization: [
            { required: true, message: '调查机构不能为空', trigger: 'blur' }
          ],
          caseNumber: [
            { required: true, message: '立案号不能为空', trigger: 'blur' }
          ],
          decisionDocument: [
            { required: true, message: '决定书文号不能为空', trigger: 'blur' }
          ],
          caseDate: [
            { required: true, message: '立案日期不能为空', trigger: 'blur' }
          ],
          caseIntroduction: [
            { required: true, message: '案情简介不能为空', trigger: 'blur' }
          ],
          majorViolations: [
            { required: true, message: '主要违法行为不能为空', trigger: 'blur' }
          ],
          punishmentBasis: [
            { required: true, message: '处罚依据不能为空', trigger: 'blur' }
          ],
          punishmentType: [
            { required: true, message: '处罚种类不能为空', trigger: 'blur' }
          ],
          fineFee: [
            { required: true, message: '罚款数额不能为空', trigger: 'blur' }
          ],
          administrativeDecree: [
            { required: true, message: '行政命令种类不能为空', trigger: 'blur' }
          ],
          isHearing: [
            { required: true, message: '是否举行听证不能为空', trigger: 'blur' }
          ],
          decideDate: [
            { required: true, message: '决定下达日期不能为空', trigger: 'blur' }
          ],
          decideContent: [
            { required: true, message: '决定书内容不能为空', trigger: 'blur' }
          ],
          implementation: [
            { required: true, message: '执行情况不能为空', trigger: 'blur' }
          ],
          executionDate: [
            { required: true, message: '执行完毕日期不能为空', trigger: 'blur' }
          ],
          reconsiderationResult: [
            { required: true, message: '复议结果不能为空', trigger: 'blur' }
          ],
          lawsuitResult: [
            { required: true, message: '诉讼结果不能为空', trigger: 'blur' }
          ],
          transferInformation: [
            { required: true, message: '移送信息不能为空', trigger: 'blur' }
          ],
          closeDate: [
            { required: true, message: '结案日期不能为空', trigger: 'blur' }
          ],
          isClose: [
            { required: true, message: '是否结案不能为空', trigger: 'change' }
          ],
          fileNumber: [
            { required: true, message: '案卷号不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          /* updateTine: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ], */
          resource: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'change' }
          ],
          exchangeStatus: [
            { required: true, message: '是否已交换不能为空', trigger: 'change' }
          ],
          examineStatus: [
            { required: true, message: '审核状态不能为空', trigger: 'blur' }
          ],
          creditCode: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          relatedMaterials: [
            { required: true, message: '作出决定的相关材料不能为空', trigger: 'blur' }
          ],
          casesType: [
            { required: true, message: '违法案件类型不能为空', trigger: 'blur' }
          ]
          /* timestamp: [
            { required: true, message: '更新时间戳不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/oriadministrativepenalty/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.no = data.oriAdministrativePenalty.no
                this.dataForm.pollutionSourceNumber = data.oriAdministrativePenalty.pollutionSourceNumber
                this.dataForm.pollutionSourceName = data.oriAdministrativePenalty.pollutionSourceName
                this.dataForm.year = data.oriAdministrativePenalty.year
                this.dataForm.enterpriseName = data.oriAdministrativePenalty.enterpriseName
                this.dataForm.investigationOrganization = data.oriAdministrativePenalty.investigationOrganization
                this.dataForm.caseNumber = data.oriAdministrativePenalty.caseNumber
                this.dataForm.decisionDocument = data.oriAdministrativePenalty.decisionDocument
                this.dataForm.caseDate = data.oriAdministrativePenalty.caseDate
                this.dataForm.caseIntroduction = data.oriAdministrativePenalty.caseIntroduction
                this.dataForm.majorViolations = data.oriAdministrativePenalty.majorViolations
                this.dataForm.punishmentBasis = data.oriAdministrativePenalty.punishmentBasis
                this.dataForm.punishmentType = data.oriAdministrativePenalty.punishmentType
                this.dataForm.fineFee = data.oriAdministrativePenalty.fineFee
                this.dataForm.administrativeDecree = data.oriAdministrativePenalty.administrativeDecree
                this.dataForm.isHearing = data.oriAdministrativePenalty.isHearing
                this.dataForm.decideDate = data.oriAdministrativePenalty.decideDate
                this.dataForm.decideContent = data.oriAdministrativePenalty.decideContent
                this.dataForm.implementation = data.oriAdministrativePenalty.implementation
                this.dataForm.executionDate = data.oriAdministrativePenalty.executionDate
                this.dataForm.reconsiderationResult = data.oriAdministrativePenalty.reconsiderationResult
                this.dataForm.lawsuitResult = data.oriAdministrativePenalty.lawsuitResult
                this.dataForm.transferInformation = data.oriAdministrativePenalty.transferInformation
                this.dataForm.closeDate = data.oriAdministrativePenalty.closeDate
                this.dataForm.isClose = data.oriAdministrativePenalty.isClose
                this.dataForm.fileNumber = data.oriAdministrativePenalty.fileNumber
                this.dataForm.remark = data.oriAdministrativePenalty.remark
                this.dataForm.createTime = data.oriAdministrativePenalty.createTime
                this.dataForm.updateTine = data.oriAdministrativePenalty.updateTine
                this.dataForm.resource = data.oriAdministrativePenalty.resource
                this.dataForm.status = data.oriAdministrativePenalty.status
                this.dataForm.exchangeStatus = data.oriAdministrativePenalty.exchangeStatus
                this.dataForm.examineStatus = data.oriAdministrativePenalty.examineStatus
                this.dataForm.creditCode = data.oriAdministrativePenalty.creditCode
                this.dataForm.relatedMaterials = data.oriAdministrativePenalty.relatedMaterials
                this.dataForm.casesType = data.oriAdministrativePenalty.casesType
                this.dataForm.timestamp = data.oriAdministrativePenalty.timestamp
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
              url: this.$http.adornUrl(`/spider/oriadministrativepenalty/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'no': this.dataForm.no,
                'pollutionSourceNumber': this.dataForm.pollutionSourceNumber,
                'pollutionSourceName': this.dataForm.pollutionSourceName,
                'year': this.dataForm.year,
                'enterpriseName': this.dataForm.enterpriseName,
                'investigationOrganization': this.dataForm.investigationOrganization,
                'caseNumber': this.dataForm.caseNumber,
                'decisionDocument': this.dataForm.decisionDocument,
                'caseDate': this.dataForm.caseDate,
                'caseIntroduction': this.dataForm.caseIntroduction,
                'majorViolations': this.dataForm.majorViolations,
                'punishmentBasis': this.dataForm.punishmentBasis,
                'punishmentType': this.dataForm.punishmentType,
                'fineFee': this.dataForm.fineFee,
                'administrativeDecree': this.dataForm.administrativeDecree,
                'isHearing': this.dataForm.isHearing,
                'decideDate': this.dataForm.decideDate,
                'decideContent': this.dataForm.decideContent,
                'implementation': this.dataForm.implementation,
                'executionDate': this.dataForm.executionDate,
                'reconsiderationResult': this.dataForm.reconsiderationResult,
                'lawsuitResult': this.dataForm.lawsuitResult,
                'transferInformation': this.dataForm.transferInformation,
                'closeDate': this.dataForm.closeDate,
                'isClose': this.dataForm.isClose,
                'fileNumber': this.dataForm.fileNumber,
                'remark': this.dataForm.remark,
                'createTime': this.dataForm.createTime,
                'updateTine': this.dataForm.updateTine,
                'resource': this.dataForm.resource,
                'status': this.dataForm.status,
                'exchangeStatus': this.dataForm.exchangeStatus,
                'examineStatus': this.dataForm.examineStatus,
                'creditCode': this.dataForm.creditCode,
                'relatedMaterials': this.dataForm.relatedMaterials,
                'casesType': this.dataForm.casesType,
                'timestamp': this.dataForm.timestamp
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
