<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:enthightechfaithlose:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:enthightechfaithlose:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="memId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="infoName"
        header-align="center"
        align="center"
        label="信息名称">
      </el-table-column>
      <el-table-column
        prop="source"
        header-align="center"
        align="center"
        label="数据来源">
      </el-table-column>
      <el-table-column
        prop="infoType"
        header-align="center"
        align="center"
        label="信息类型">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="更新时间，保留原始数据">
      </el-table-column>
      <el-table-column
        prop="company"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="cityState"
        header-align="center"
        align="center"
        label="所在市州">
      </el-table-column>
      <el-table-column
        prop="districtCounty"
        header-align="center"
        align="center"
        label="所在区县">
      </el-table-column>
      <el-table-column
        prop="companyType"
        header-align="center"
        align="center"
        label="企业类型">
      </el-table-column>
      <el-table-column
        prop="evaluationYear"
        header-align="center"
        align="center"
        label="评价年份">
      </el-table-column>
      <el-table-column
        prop="caseName"
        header-align="center"
        align="center"
        label="案件名称">
      </el-table-column>
      <el-table-column
        prop="punishNo"
        header-align="center"
        align="center"
        label="处罚文件号">
      </el-table-column>
      <el-table-column
        prop="executiveRelativeName"
        header-align="center"
        align="center"
        label="行政相对人名称">
      </el-table-column>
      <el-table-column
        prop="legalPerson"
        header-align="center"
        align="center"
        label="法定代表人">
      </el-table-column>
      <el-table-column
        prop="enforcementDept"
        header-align="center"
        align="center"
        label="执法部门">
      </el-table-column>
      <el-table-column
        prop="punishDate"
        header-align="center"
        align="center"
        label="作出行政处罚的日期">
      </el-table-column>
      <el-table-column
        prop="checkedCompany"
        header-align="center"
        align="center"
        label="被抽查单位">
      </el-table-column>
      <el-table-column
        prop="reportId"
        header-align="center"
        align="center"
        label="报告编号">
      </el-table-column>
      <el-table-column
        prop="checkedProductionName"
        header-align="center"
        align="center"
        label="检品名称">
      </el-table-column>
      <el-table-column
        prop="productDate"
        header-align="center"
        align="center"
        label="批号或生产日期">
      </el-table-column>
      <el-table-column
        prop="specification"
        header-align="center"
        align="center"
        label="规格">
      </el-table-column>
      <el-table-column
        prop="productCompany"
        header-align="center"
        align="center"
        label="标示生产单位">
      </el-table-column>
      <el-table-column
        prop="unPassProject"
        header-align="center"
        align="center"
        label="不合格项目">
      </el-table-column>
      <el-table-column
        prop="inspectionStandard"
        header-align="center"
        align="center"
        label="检验依据">
      </el-table-column>
      <el-table-column
        prop="inspectionResult"
        header-align="center"
        align="center"
        label="检验结果">
      </el-table-column>
      <el-table-column
        prop="standardRegulation"
        header-align="center"
        align="center"
        label="标准规定">
      </el-table-column>
      <el-table-column
        prop="inspectionOrganization"
        header-align="center"
        align="center"
        label="检验机构">
      </el-table-column>
      <el-table-column
        prop="checkDate"
        header-align="center"
        align="center"
        label="检查日期">
      </el-table-column>
      <el-table-column
        prop="checkDept"
        header-align="center"
        align="center"
        label="检查单位">
      </el-table-column>
      <el-table-column
        prop="checkContent"
        header-align="center"
        align="center"
        label="检查内容">
      </el-table-column>
      <el-table-column
        prop="unPassContent"
        header-align="center"
        align="center"
        label="不合格内容">
      </el-table-column>
      <el-table-column
        prop="monitoringPointName"
        header-align="center"
        align="center"
        label="监测点名称">
      </el-table-column>
      <el-table-column
        prop="sampleName"
        header-align="center"
        align="center"
        label="样品名称">
      </el-table-column>
      <el-table-column
        prop="samplingNum"
        header-align="center"
        align="center"
        label="抽样编号">
      </el-table-column>
      <el-table-column
        prop="testingDepartment"
        header-align="center"
        align="center"
        label="检测部门">
      </el-table-column>
      <el-table-column
        prop="testDate"
        header-align="center"
        align="center"
        label="检测日期">
      </el-table-column>
      <el-table-column
        prop="originSource"
        header-align="center"
        align="center"
        label="产地来源">
      </el-table-column>
      <el-table-column
        prop="testResultJudgment"
        header-align="center"
        align="center"
        label="检测结果判断">
      </el-table-column>
      <el-table-column
        prop="brokenFaithPersonName"
        header-align="center"
        align="center"
        label="失信被执行人名称">
      </el-table-column>
      <el-table-column
        prop="caseNo"
        header-align="center"
        align="center"
        label="案号">
      </el-table-column>
      <el-table-column
        prop="organizationCode"
        header-align="center"
        align="center"
        label="组织机构代码">
      </el-table-column>
      <el-table-column
        prop="enterpriseLegalPersonName"
        header-align="center"
        align="center"
        label="企业法人姓名">
      </el-table-column>
      <el-table-column
        prop="executionCourt"
        header-align="center"
        align="center"
        label="执行法院">
      </el-table-column>
      <el-table-column
        prop="geographicalName"
        header-align="center"
        align="center"
        label="地域名称">
      </el-table-column>
      <el-table-column
        prop="executionReferenceNo"
        header-align="center"
        align="center"
        label="执行依据文号">
      </el-table-column>
      <el-table-column
        prop="executionUnit"
        header-align="center"
        align="center"
        label="作出执行依据单位">
      </el-table-column>
      <el-table-column
        prop="personExecutedPerformance"
        header-align="center"
        align="center"
        label="被执行人的履行情况">
      </el-table-column>
      <el-table-column
        prop="specificCircumstances"
        header-align="center"
        align="center"
        label="失信被执行人具体情形">
      </el-table-column>
      <el-table-column
        prop="releaseTime"
        header-align="center"
        align="center"
        label="发布时间">
      </el-table-column>
      <el-table-column
        prop="filingTime"
        header-align="center"
        align="center"
        label="立案时间">
      </el-table-column>
      <el-table-column
        prop="executedPart"
        header-align="center"
        align="center"
        label="已履行部分">
      </el-table-column>
      <el-table-column
        prop="unexecutedPart"
        header-align="center"
        align="center"
        label="未履行部分">
      </el-table-column>
      <el-table-column
        prop="evaluationResult"
        header-align="center"
        align="center"
        label="评价结果">
      </el-table-column>
      <el-table-column
        prop="upgradeResult"
        header-align="center"
        align="center"
        label="升级结果">
      </el-table-column>
      <el-table-column
        prop="gradationBasis"
        header-align="center"
        align="center"
        label="定级依据">
      </el-table-column>
      <el-table-column
        prop="punishmentDate"
        header-align="center"
        align="center"
        label="处罚（理）日期">
      </el-table-column>
      <el-table-column
        prop="documentNum"
        header-align="center"
        align="center"
        label="决定文书号">
      </el-table-column>
      <el-table-column
        prop="punishmentBasis"
        header-align="center"
        align="center"
        label="处罚（理）依据">
      </el-table-column>
      <el-table-column
        prop="punishmentResult"
        header-align="center"
        align="center"
        label="处罚（理）结果">
      </el-table-column>
      <el-table-column
        prop="areaCode"
        header-align="center"
        align="center"
        label="行政区划代码">
      </el-table-column>
      <el-table-column
        prop="punishmentUnitName"
        header-align="center"
        align="center"
        label="实施处罚单位名称">
      </el-table-column>
      <el-table-column
        prop="punishmentReason"
        header-align="center"
        align="center"
        label="处罚（理）原因">
      </el-table-column>
      <el-table-column
        prop="enterpriseId"
        header-align="center"
        align="center"
        label="企业ID">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './enthightechfaithlose-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/spider/enthightechfaithlose/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/spider/enthightechfaithlose/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
