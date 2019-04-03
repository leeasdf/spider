<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="memId">
      <el-input v-model="dataForm.memId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="信息名称" prop="infoName">
      <el-input v-model="dataForm.infoName" placeholder="信息名称"></el-input>
    </el-form-item>
    <el-form-item label="数据来源" prop="source">
      <el-input v-model="dataForm.source" placeholder="数据来源"></el-input>
    </el-form-item>
    <el-form-item label="信息类型" prop="infoType">
      <el-input v-model="dataForm.infoType" placeholder="信息类型"></el-input>
    </el-form-item>
    <el-form-item label="更新时间，保留原始数据" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间，保留原始数据"></el-input>
    </el-form-item>
    <el-form-item label="" prop="company">
      <el-input v-model="dataForm.company" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="所在市州" prop="cityState">
      <el-input v-model="dataForm.cityState" placeholder="所在市州"></el-input>
    </el-form-item>
    <el-form-item label="所在区县" prop="districtCounty">
      <el-input v-model="dataForm.districtCounty" placeholder="所在区县"></el-input>
    </el-form-item>
    <el-form-item label="企业类型" prop="companyType">
      <el-input v-model="dataForm.companyType" placeholder="企业类型"></el-input>
    </el-form-item>
    <el-form-item label="评价年份" prop="evaluationYear">
      <el-date-picker type="year" v-model="dataForm.evaluationYear" placeholder="评价年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="案件名称" prop="caseName">
      <el-input v-model="dataForm.caseName" placeholder="案件名称"></el-input>
    </el-form-item>
    <el-form-item label="处罚文件号" prop="punishNo">
      <el-input v-model="dataForm.punishNo" placeholder="处罚文件号"></el-input>
    </el-form-item>
    <el-form-item label="行政相对人名称" prop="executiveRelativeName">
      <el-input v-model="dataForm.executiveRelativeName" placeholder="行政相对人名称"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人" prop="legalPerson">
      <el-input v-model="dataForm.legalPerson" placeholder="法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="执法部门" prop="enforcementDept">
      <el-input v-model="dataForm.enforcementDept" placeholder="执法部门"></el-input>
    </el-form-item>
    <el-form-item label="作出行政处罚的日期" prop="punishDate">
      <el-input v-model="dataForm.punishDate" placeholder="作出行政处罚的日期"></el-input>
    </el-form-item>
    <el-form-item label="被抽查单位" prop="checkedCompany">
      <el-input v-model="dataForm.checkedCompany" placeholder="被抽查单位"></el-input>
    </el-form-item>
    <el-form-item label="报告编号" prop="reportId">
      <el-input v-model="dataForm.reportId" placeholder="报告编号"></el-input>
    </el-form-item>
    <el-form-item label="检品名称" prop="checkedProductionName">
      <el-input v-model="dataForm.checkedProductionName" placeholder="检品名称"></el-input>
    </el-form-item>
    <el-form-item label="批号或生产日期" prop="productDate">
      <el-input v-model="dataForm.productDate" placeholder="批号或生产日期"></el-input>
    </el-form-item>
    <el-form-item label="规格" prop="specification">
      <el-input v-model="dataForm.specification" placeholder="规格"></el-input>
    </el-form-item>
    <el-form-item label="标示生产单位" prop="productCompany">
      <el-input v-model="dataForm.productCompany" placeholder="标示生产单位"></el-input>
    </el-form-item>
    <el-form-item label="不合格项目" prop="unPassProject">
      <el-input v-model="dataForm.unPassProject" placeholder="不合格项目"></el-input>
    </el-form-item>
    <el-form-item label="检验依据" prop="inspectionStandard">
      <el-input v-model="dataForm.inspectionStandard" placeholder="检验依据"></el-input>
    </el-form-item>
    <el-form-item label="检验结果" prop="inspectionResult">
      <el-input v-model="dataForm.inspectionResult" placeholder="检验结果"></el-input>
    </el-form-item>
    <el-form-item label="标准规定" prop="standardRegulation">
      <el-input v-model="dataForm.standardRegulation" placeholder="标准规定"></el-input>
    </el-form-item>
    <el-form-item label="检验机构" prop="inspectionOrganization">
      <el-input v-model="dataForm.inspectionOrganization" placeholder="检验机构"></el-input>
    </el-form-item>
    <el-form-item label="检查日期" prop="checkDate">
      <el-date-picker v-model="dataForm.checkDate" placeholder="检查日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="检查单位" prop="checkDept">
      <el-input v-model="dataForm.checkDept" placeholder="检查单位"></el-input>
    </el-form-item>
    <el-form-item label="检查内容" prop="checkContent">
      <el-input v-model="dataForm.checkContent" placeholder="检查内容"></el-input>
    </el-form-item>
    <el-form-item label="不合格内容" prop="unPassContent">
      <el-input v-model="dataForm.unPassContent" placeholder="不合格内容"></el-input>
    </el-form-item>
    <el-form-item label="监测点名称" prop="monitoringPointName">
      <el-input v-model="dataForm.monitoringPointName" placeholder="监测点名称"></el-input>
    </el-form-item>
    <el-form-item label="样品名称" prop="sampleName">
      <el-input v-model="dataForm.sampleName" placeholder="样品名称"></el-input>
    </el-form-item>
    <el-form-item label="抽样编号" prop="samplingNum">
      <el-input v-model="dataForm.samplingNum" placeholder="抽样编号"></el-input>
    </el-form-item>
    <el-form-item label="检测部门" prop="testingDepartment">
      <el-input v-model="dataForm.testingDepartment" placeholder="检测部门"></el-input>
    </el-form-item>
    <el-form-item label="检测日期" prop="testDate">
      <el-date-picker v-model="dataForm.testDate" placeholder="检测日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="产地来源" prop="originSource">
      <el-input v-model="dataForm.originSource" placeholder="产地来源"></el-input>
    </el-form-item>
    <el-form-item label="检测结果判断" prop="testResultJudgment">
      <el-input v-model="dataForm.testResultJudgment" placeholder="检测结果判断"></el-input>
    </el-form-item>
    <el-form-item label="失信被执行人名称" prop="brokenFaithPersonName">
      <el-input v-model="dataForm.brokenFaithPersonName" placeholder="失信被执行人名称"></el-input>
    </el-form-item>
    <el-form-item label="案号" prop="caseNo">
      <el-input v-model="dataForm.caseNo" placeholder="案号"></el-input>
    </el-form-item>
    <el-form-item label="组织机构代码" prop="organizationCode">
      <el-input v-model="dataForm.organizationCode" placeholder="组织机构代码"></el-input>
    </el-form-item>
    <el-form-item label="企业法人姓名" prop="enterpriseLegalPersonName">
      <el-input v-model="dataForm.enterpriseLegalPersonName" placeholder="企业法人姓名"></el-input>
    </el-form-item>
    <el-form-item label="执行法院" prop="executionCourt">
      <el-input v-model="dataForm.executionCourt" placeholder="执行法院"></el-input>
    </el-form-item>
    <el-form-item label="地域名称" prop="geographicalName">
      <el-input v-model="dataForm.geographicalName" placeholder="地域名称"></el-input>
    </el-form-item>
    <el-form-item label="执行依据文号" prop="executionReferenceNo">
      <el-input v-model="dataForm.executionReferenceNo" placeholder="执行依据文号"></el-input>
    </el-form-item>
    <el-form-item label="作出执行依据单位" prop="executionUnit">
      <el-input v-model="dataForm.executionUnit" placeholder="作出执行依据单位"></el-input>
    </el-form-item>
    <el-form-item label="被执行人的履行情况" prop="personExecutedPerformance">
      <el-input v-model="dataForm.personExecutedPerformance" placeholder="被执行人的履行情况"></el-input>
    </el-form-item>
    <el-form-item label="失信被执行人具体情形" prop="specificCircumstances">
      <el-input v-model="dataForm.specificCircumstances" placeholder="失信被执行人具体情形"></el-input>
    </el-form-item>
    <el-form-item label="发布时间" prop="releaseTime">
      <el-date-picker v-model="dataForm.releaseTime" placeholder="发布时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="立案时间" prop="filingTime">
      <el-date-picker v-model="dataForm.filingTime" placeholder="立案时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="已履行部分" prop="executedPart">
      <el-input v-model="dataForm.executedPart" placeholder="已履行部分"></el-input>
    </el-form-item>
    <el-form-item label="未履行部分" prop="unexecutedPart">
      <el-input v-model="dataForm.unexecutedPart" placeholder="未履行部分"></el-input>
    </el-form-item>
    <el-form-item label="评价结果" prop="evaluationResult">
      <el-input v-model="dataForm.evaluationResult" placeholder="评价结果"></el-input>
    </el-form-item>
    <el-form-item label="升级结果" prop="upgradeResult">
      <el-input v-model="dataForm.upgradeResult" placeholder="升级结果"></el-input>
    </el-form-item>
    <el-form-item label="定级依据" prop="gradationBasis">
      <el-input v-model="dataForm.gradationBasis" placeholder="定级依据"></el-input>
    </el-form-item>
    <el-form-item label="处罚（理）日期" prop="punishmentDate">
      <el-date-picker v-model="dataForm.punishmentDate" placeholder="处罚（理）日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="决定文书号" prop="documentNum">
      <el-input v-model="dataForm.documentNum" placeholder="决定文书号"></el-input>
    </el-form-item>
    <el-form-item label="处罚（理）依据" prop="punishmentBasis">
      <el-input v-model="dataForm.punishmentBasis" placeholder="处罚（理）依据"></el-input>
    </el-form-item>
    <el-form-item label="处罚（理）结果" prop="punishmentResult">
      <el-input v-model="dataForm.punishmentResult" placeholder="处罚（理）结果"></el-input>
    </el-form-item>
    <el-form-item label="行政区划代码" prop="areaCode">
      <el-input v-model="dataForm.areaCode" placeholder="行政区划代码"></el-input>
    </el-form-item>
    <el-form-item label="实施处罚单位名称" prop="punishmentUnitName">
      <el-input v-model="dataForm.punishmentUnitName" placeholder="实施处罚单位名称"></el-input>
    </el-form-item>
    <el-form-item label="处罚（理）原因" prop="punishmentReason">
      <el-input v-model="dataForm.punishmentReason" placeholder="处罚（理）原因"></el-input>
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
          memId: '',
          infoName: '',
          source: '',
          infoType: '',
          updateTime: '',
          company: '',
          cityState: '',
          districtCounty: '',
          companyType: '',
          evaluationYear: '',
          caseName: '',
          punishNo: '',
          executiveRelativeName: '',
          legalPerson: '',
          enforcementDept: '',
          punishDate: '',
          checkedCompany: '',
          reportId: '',
          checkedProductionName: '',
          productDate: '',
          specification: '',
          productCompany: '',
          unPassProject: '',
          inspectionStandard: '',
          inspectionResult: '',
          standardRegulation: '',
          inspectionOrganization: '',
          checkDate: '',
          checkDept: '',
          checkContent: '',
          unPassContent: '',
          monitoringPointName: '',
          sampleName: '',
          samplingNum: '',
          testingDepartment: '',
          testDate: '',
          originSource: '',
          testResultJudgment: '',
          brokenFaithPersonName: '',
          caseNo: '',
          organizationCode: '',
          enterpriseLegalPersonName: '',
          executionCourt: '',
          geographicalName: '',
          executionReferenceNo: '',
          executionUnit: '',
          personExecutedPerformance: '',
          specificCircumstances: '',
          releaseTime: '',
          filingTime: '',
          executedPart: '',
          unexecutedPart: '',
          evaluationResult: '',
          upgradeResult: '',
          gradationBasis: '',
          punishmentDate: '',
          documentNum: '',
          punishmentBasis: '',
          punishmentResult: '',
          areaCode: '',
          punishmentUnitName: '',
          punishmentReason: '',
          enterpriseId: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          infoName: [
            { required: true, message: '信息名称不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          infoType: [
            { required: true, message: '信息类型不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间，保留原始数据不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cityState: [
            { required: true, message: '所在市州不能为空', trigger: 'blur' }
          ],
          districtCounty: [
            { required: true, message: '所在区县不能为空', trigger: 'blur' }
          ],
          companyType: [
            { required: true, message: '企业类型不能为空', trigger: 'blur' }
          ],
          evaluationYear: [
            { required: true, message: '评价年份不能为空', trigger: 'blur' }
          ],
          caseName: [
            { required: true, message: '案件名称不能为空', trigger: 'blur' }
          ],
          punishNo: [
            { required: true, message: '处罚文件号不能为空', trigger: 'blur' }
          ],
          executiveRelativeName: [
            { required: true, message: '行政相对人名称不能为空', trigger: 'blur' }
          ],
          legalPerson: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          enforcementDept: [
            { required: true, message: '执法部门不能为空', trigger: 'blur' }
          ],
          punishDate: [
            { required: true, message: '作出行政处罚的日期不能为空', trigger: 'blur' }
          ],
          checkedCompany: [
            { required: true, message: '被抽查单位不能为空', trigger: 'blur' }
          ],
          reportId: [
            { required: true, message: '报告编号不能为空', trigger: 'blur' }
          ],
          checkedProductionName: [
            { required: true, message: '检品名称不能为空', trigger: 'blur' }
          ],
          productDate: [
            { required: true, message: '批号或生产日期不能为空', trigger: 'blur' }
          ],
          specification: [
            { required: true, message: '规格不能为空', trigger: 'blur' }
          ],
          productCompany: [
            { required: true, message: '标示生产单位不能为空', trigger: 'blur' }
          ],
          unPassProject: [
            { required: true, message: '不合格项目不能为空', trigger: 'blur' }
          ],
          inspectionStandard: [
            { required: true, message: '检验依据不能为空', trigger: 'blur' }
          ],
          inspectionResult: [
            { required: true, message: '检验结果不能为空', trigger: 'blur' }
          ],
          standardRegulation: [
            { required: true, message: '标准规定不能为空', trigger: 'blur' }
          ],
          inspectionOrganization: [
            { required: true, message: '检验机构不能为空', trigger: 'blur' }
          ],
          checkDate: [
            { required: true, message: '检查日期不能为空', trigger: 'blur' }
          ],
          checkDept: [
            { required: true, message: '检查单位不能为空', trigger: 'blur' }
          ],
          checkContent: [
            { required: true, message: '检查内容不能为空', trigger: 'blur' }
          ],
          unPassContent: [
            { required: true, message: '不合格内容不能为空', trigger: 'blur' }
          ],
          monitoringPointName: [
            { required: true, message: '监测点名称不能为空', trigger: 'blur' }
          ],
          sampleName: [
            { required: true, message: '样品名称不能为空', trigger: 'blur' }
          ],
          samplingNum: [
            { required: true, message: '抽样编号不能为空', trigger: 'blur' }
          ],
          testingDepartment: [
            { required: true, message: '检测部门不能为空', trigger: 'blur' }
          ],
          testDate: [
            { required: true, message: '检测日期不能为空', trigger: 'blur' }
          ],
          originSource: [
            { required: true, message: '产地来源不能为空', trigger: 'blur' }
          ],
          testResultJudgment: [
            { required: true, message: '检测结果判断不能为空', trigger: 'blur' }
          ],
          brokenFaithPersonName: [
            { required: true, message: '失信被执行人名称不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '案号不能为空', trigger: 'blur' }
          ],
          organizationCode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          enterpriseLegalPersonName: [
            { required: true, message: '企业法人姓名不能为空', trigger: 'blur' }
          ],
          executionCourt: [
            { required: true, message: '执行法院不能为空', trigger: 'blur' }
          ],
          geographicalName: [
            { required: true, message: '地域名称不能为空', trigger: 'blur' }
          ],
          executionReferenceNo: [
            { required: true, message: '执行依据文号不能为空', trigger: 'blur' }
          ],
          executionUnit: [
            { required: true, message: '作出执行依据单位不能为空', trigger: 'blur' }
          ],
          personExecutedPerformance: [
            { required: true, message: '被执行人的履行情况不能为空', trigger: 'blur' }
          ],
          specificCircumstances: [
            { required: true, message: '失信被执行人具体情形不能为空', trigger: 'blur' }
          ],
          releaseTime: [
            { required: true, message: '发布时间不能为空', trigger: 'blur' }
          ],
          filingTime: [
            { required: true, message: '立案时间不能为空', trigger: 'blur' }
          ],
          executedPart: [
            { required: true, message: '已履行部分不能为空', trigger: 'blur' }
          ],
          unexecutedPart: [
            { required: true, message: '未履行部分不能为空', trigger: 'blur' }
          ],
          evaluationResult: [
            { required: true, message: '评价结果不能为空', trigger: 'blur' }
          ],
          upgradeResult: [
            { required: true, message: '升级结果不能为空', trigger: 'blur' }
          ],
          gradationBasis: [
            { required: true, message: '定级依据不能为空', trigger: 'blur' }
          ],
          punishmentDate: [
            { required: true, message: '处罚（理）日期不能为空', trigger: 'blur' }
          ],
          documentNum: [
            { required: true, message: '决定文书号不能为空', trigger: 'blur' }
          ],
          punishmentBasis: [
            { required: true, message: '处罚（理）依据不能为空', trigger: 'blur' }
          ],
          punishmentResult: [
            { required: true, message: '处罚（理）结果不能为空', trigger: 'blur' }
          ],
          areaCode: [
            { required: true, message: '行政区划代码不能为空', trigger: 'blur' }
          ],
          punishmentUnitName: [
            { required: true, message: '实施处罚单位名称不能为空', trigger: 'blur' }
          ],
          punishmentReason: [
            { required: true, message: '处罚（理）原因不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechfaithlose/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.entHighTechFaithLose.memId
                this.dataForm.infoName = data.entHighTechFaithLose.infoName
                this.dataForm.source = data.entHighTechFaithLose.source
                this.dataForm.infoType = data.entHighTechFaithLose.infoType
                this.dataForm.updateTime = data.entHighTechFaithLose.updateTime
                this.dataForm.company = data.entHighTechFaithLose.company
                this.dataForm.cityState = data.entHighTechFaithLose.cityState
                this.dataForm.districtCounty = data.entHighTechFaithLose.districtCounty
                this.dataForm.companyType = data.entHighTechFaithLose.companyType
                this.dataForm.evaluationYear = data.entHighTechFaithLose.evaluationYear
                this.dataForm.caseName = data.entHighTechFaithLose.caseName
                this.dataForm.punishNo = data.entHighTechFaithLose.punishNo
                this.dataForm.executiveRelativeName = data.entHighTechFaithLose.executiveRelativeName
                this.dataForm.legalPerson = data.entHighTechFaithLose.legalPerson
                this.dataForm.enforcementDept = data.entHighTechFaithLose.enforcementDept
                this.dataForm.punishDate = data.entHighTechFaithLose.punishDate
                this.dataForm.checkedCompany = data.entHighTechFaithLose.checkedCompany
                this.dataForm.reportId = data.entHighTechFaithLose.reportId
                this.dataForm.checkedProductionName = data.entHighTechFaithLose.checkedProductionName
                this.dataForm.productDate = data.entHighTechFaithLose.productDate
                this.dataForm.specification = data.entHighTechFaithLose.specification
                this.dataForm.productCompany = data.entHighTechFaithLose.productCompany
                this.dataForm.unPassProject = data.entHighTechFaithLose.unPassProject
                this.dataForm.inspectionStandard = data.entHighTechFaithLose.inspectionStandard
                this.dataForm.inspectionResult = data.entHighTechFaithLose.inspectionResult
                this.dataForm.standardRegulation = data.entHighTechFaithLose.standardRegulation
                this.dataForm.inspectionOrganization = data.entHighTechFaithLose.inspectionOrganization
                this.dataForm.checkDate = data.entHighTechFaithLose.checkDate
                this.dataForm.checkDept = data.entHighTechFaithLose.checkDept
                this.dataForm.checkContent = data.entHighTechFaithLose.checkContent
                this.dataForm.unPassContent = data.entHighTechFaithLose.unPassContent
                this.dataForm.monitoringPointName = data.entHighTechFaithLose.monitoringPointName
                this.dataForm.sampleName = data.entHighTechFaithLose.sampleName
                this.dataForm.samplingNum = data.entHighTechFaithLose.samplingNum
                this.dataForm.testingDepartment = data.entHighTechFaithLose.testingDepartment
                this.dataForm.testDate = data.entHighTechFaithLose.testDate
                this.dataForm.originSource = data.entHighTechFaithLose.originSource
                this.dataForm.testResultJudgment = data.entHighTechFaithLose.testResultJudgment
                this.dataForm.brokenFaithPersonName = data.entHighTechFaithLose.brokenFaithPersonName
                this.dataForm.caseNo = data.entHighTechFaithLose.caseNo
                this.dataForm.organizationCode = data.entHighTechFaithLose.organizationCode
                this.dataForm.enterpriseLegalPersonName = data.entHighTechFaithLose.enterpriseLegalPersonName
                this.dataForm.executionCourt = data.entHighTechFaithLose.executionCourt
                this.dataForm.geographicalName = data.entHighTechFaithLose.geographicalName
                this.dataForm.executionReferenceNo = data.entHighTechFaithLose.executionReferenceNo
                this.dataForm.executionUnit = data.entHighTechFaithLose.executionUnit
                this.dataForm.personExecutedPerformance = data.entHighTechFaithLose.personExecutedPerformance
                this.dataForm.specificCircumstances = data.entHighTechFaithLose.specificCircumstances
                this.dataForm.releaseTime = data.entHighTechFaithLose.releaseTime
                this.dataForm.filingTime = data.entHighTechFaithLose.filingTime
                this.dataForm.executedPart = data.entHighTechFaithLose.executedPart
                this.dataForm.unexecutedPart = data.entHighTechFaithLose.unexecutedPart
                this.dataForm.evaluationResult = data.entHighTechFaithLose.evaluationResult
                this.dataForm.upgradeResult = data.entHighTechFaithLose.upgradeResult
                this.dataForm.gradationBasis = data.entHighTechFaithLose.gradationBasis
                this.dataForm.punishmentDate = data.entHighTechFaithLose.punishmentDate
                this.dataForm.documentNum = data.entHighTechFaithLose.documentNum
                this.dataForm.punishmentBasis = data.entHighTechFaithLose.punishmentBasis
                this.dataForm.punishmentResult = data.entHighTechFaithLose.punishmentResult
                this.dataForm.areaCode = data.entHighTechFaithLose.areaCode
                this.dataForm.punishmentUnitName = data.entHighTechFaithLose.punishmentUnitName
                this.dataForm.punishmentReason = data.entHighTechFaithLose.punishmentReason
                this.dataForm.enterpriseId = data.entHighTechFaithLose.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechfaithlose/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'infoName': this.dataForm.infoName,
                'source': this.dataForm.source,
                'infoType': this.dataForm.infoType,
                'updateTime': this.dataForm.updateTime,
                'company': this.dataForm.company,
                'cityState': this.dataForm.cityState,
                'districtCounty': this.dataForm.districtCounty,
                'companyType': this.dataForm.companyType,
                'evaluationYear': this.dataForm.evaluationYear,
                'caseName': this.dataForm.caseName,
                'punishNo': this.dataForm.punishNo,
                'executiveRelativeName': this.dataForm.executiveRelativeName,
                'legalPerson': this.dataForm.legalPerson,
                'enforcementDept': this.dataForm.enforcementDept,
                'punishDate': this.dataForm.punishDate,
                'checkedCompany': this.dataForm.checkedCompany,
                'reportId': this.dataForm.reportId,
                'checkedProductionName': this.dataForm.checkedProductionName,
                'productDate': this.dataForm.productDate,
                'specification': this.dataForm.specification,
                'productCompany': this.dataForm.productCompany,
                'unPassProject': this.dataForm.unPassProject,
                'inspectionStandard': this.dataForm.inspectionStandard,
                'inspectionResult': this.dataForm.inspectionResult,
                'standardRegulation': this.dataForm.standardRegulation,
                'inspectionOrganization': this.dataForm.inspectionOrganization,
                'checkDate': this.dataForm.checkDate,
                'checkDept': this.dataForm.checkDept,
                'checkContent': this.dataForm.checkContent,
                'unPassContent': this.dataForm.unPassContent,
                'monitoringPointName': this.dataForm.monitoringPointName,
                'sampleName': this.dataForm.sampleName,
                'samplingNum': this.dataForm.samplingNum,
                'testingDepartment': this.dataForm.testingDepartment,
                'testDate': this.dataForm.testDate,
                'originSource': this.dataForm.originSource,
                'testResultJudgment': this.dataForm.testResultJudgment,
                'brokenFaithPersonName': this.dataForm.brokenFaithPersonName,
                'caseNo': this.dataForm.caseNo,
                'organizationCode': this.dataForm.organizationCode,
                'enterpriseLegalPersonName': this.dataForm.enterpriseLegalPersonName,
                'executionCourt': this.dataForm.executionCourt,
                'geographicalName': this.dataForm.geographicalName,
                'executionReferenceNo': this.dataForm.executionReferenceNo,
                'executionUnit': this.dataForm.executionUnit,
                'personExecutedPerformance': this.dataForm.personExecutedPerformance,
                'specificCircumstances': this.dataForm.specificCircumstances,
                'releaseTime': this.dataForm.releaseTime,
                'filingTime': this.dataForm.filingTime,
                'executedPart': this.dataForm.executedPart,
                'unexecutedPart': this.dataForm.unexecutedPart,
                'evaluationResult': this.dataForm.evaluationResult,
                'upgradeResult': this.dataForm.upgradeResult,
                'gradationBasis': this.dataForm.gradationBasis,
                'punishmentDate': this.dataForm.punishmentDate,
                'documentNum': this.dataForm.documentNum,
                'punishmentBasis': this.dataForm.punishmentBasis,
                'punishmentResult': this.dataForm.punishmentResult,
                'areaCode': this.dataForm.areaCode,
                'punishmentUnitName': this.dataForm.punishmentUnitName,
                'punishmentReason': this.dataForm.punishmentReason,
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
