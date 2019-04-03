<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.pollutionSourceName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:oriadministrativepenalty:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:oriadministrativepenalty:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="expand"
        width="40">
        <template slot-scope="props">
          <el-form inline label-width="180px" class="yzx-table-expand">
            <el-form-item label="年度"><span>{{props.row.year}}</span></el-form-item>
            <el-form-item label="污染源编号"><span>{{props.row.pollutionSourceNumber}}</span></el-form-item>
            <el-form-item label="立案号"><span>{{props.row.caseNumber}}</span></el-form-item>
            <el-form-item label="决定书文号"><span>{{props.row.decisionDocument}}</span></el-form-item>
            <el-form-item label="案情简介"><span>{{props.row.caseIntroduction}}</span></el-form-item>
            <el-form-item label="主要违法行为"><span>{{props.row.majorViolations}}</span></el-form-item>
            <el-form-item label="处罚依据" class="yzx-table-rowspan"><span>{{props.row.punishmentBasis}}</span></el-form-item>
            <el-form-item label="处罚种类"><span>{{props.row.punishmentType}}</span></el-form-item>
            <el-form-item label="行政命令种类"><span>{{props.row.administrativeDecree}}</span></el-form-item>
            <el-form-item label="是否举行听证"><span>{{props.row.isHearing}}</span></el-form-item>
            <el-form-item label="决定下达日期"><span>{{props.row.decideDate}}</span></el-form-item>
            <el-form-item label="决定书内容"><span>{{props.row.decideContent}}</span></el-form-item>
            <el-form-item label="执行情况"><span>{{props.row.implementation}}</span></el-form-item>
            <el-form-item label="执行完毕日期"><span>{{props.row.executionDate}}</span></el-form-item>
            <el-form-item label="复议结果"><span>{{props.row.reconsiderationResult}}</span></el-form-item>
            <el-form-item label="诉讼结果"><span>{{props.row.lawsuitResult}}</span></el-form-item>
            <el-form-item label="移送信息"><span>{{props.row.transferInformation}}</span></el-form-item>
            <el-form-item label="结案日期"><span>{{props.row.closeDate}}</span></el-form-item>
            <el-form-item label="是否结案"><span>{{fmtIsClose(props.row.isClose)}}</span></el-form-item>
            <el-form-item label="案卷号"><span>{{props.row.fileNumber}}</span></el-form-item>
            <el-form-item label="备注"><span>{{props.row.remark}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
            <el-form-item label="数据来源"><span>{{props.row.resource}}</span></el-form-item>
            <el-form-item label="状态"><span>{{fmtStatus(props.row.status)}}</span></el-form-item>
            <el-form-item label="是否已交换"><span>{{fmtExchangeStatus(props.row.exchangeStatus)}}</span></el-form-item>
            <el-form-item label="审核状态"><span>{{props.row.examineStatus}}</span></el-form-item>
            <el-form-item label="作出决定的相关材料"><span>{{props.row.relatedMaterials}}</span></el-form-item>
            <el-form-item label="违法案件类型"><span>{{props.row.casesType}}</span></el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>

      <!-- <el-table-column
        prop="no"
        header-align="center"
        align="center"
        label="序号">
      </el-table-column> -->
     <!--  <el-table-column
        prop="pollutionSourceNumber"
        header-align="center"
        align="center"
        label="污染源编号">
      </el-table-column> -->
      <el-table-column
        prop="pollutionSourceName"
        header-align="center"
        align="center"
        label="污染源名称">
      </el-table-column>
      <!-- <el-table-column
        prop="year"
        header-align="center"
        align="center"
        width="80"
        label="年度">
      </el-table-column> -->
      <el-table-column
        prop="enterpriseName"
        header-align="center"
        align="center"
        label="处罚主体">
      </el-table-column>
      <el-table-column
        prop="investigationOrganization"
        header-align="center"
        align="center"
        label="调查机构">
      </el-table-column>
      <!-- <el-table-column
        prop="caseNumber"
        header-align="center"
        align="center"
        label="立案号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="decisionDocument"
        header-align="center"
        align="center"
        label="决定书文号">
      </el-table-column> -->
      <el-table-column
        prop="caseDate"
        header-align="center"
        align="center"
        width="100"
        label="立案日期">
      </el-table-column>
      <!-- <el-table-column
        prop="caseIntroduction"
        header-align="center"
        align="center"
        label="案情简介">
      </el-table-column> -->
      <!-- <el-table-column
        prop="majorViolations"
        header-align="center"
        align="center"
        label="主要违法行为">
      </el-table-column> -->
      <!-- <el-table-column
        prop="punishmentBasis"
        header-align="center"
        align="center"
        label="处罚依据">
      </el-table-column> -->
      <!-- <el-table-column
        prop="punishmentType"
        header-align="center"
        align="center"
        label="处罚种类">
      </el-table-column> -->
      <el-table-column
        prop="fineFee"
        header-align="center"
        align="center"
        width="120"
        label="罚款数额（万元）">
      </el-table-column>
     <!--  <el-table-column
        prop="administrativeDecree"
        header-align="center"
        align="center"
        label="行政命令种类">
      </el-table-column> -->
      <!-- <el-table-column
        prop="isHearing"
        header-align="center"
        align="center"
        label="是否举行听证">
      </el-table-column> -->
      <!-- <el-table-column
        prop="decideDate"
        header-align="center"
        align="center"
        label="决定下达日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="decideContent"
        header-align="center"
        align="center"
        label="决定书内容">
      </el-table-column> -->
      <!-- <el-table-column
        prop="implementation"
        header-align="center"
        align="center"
        label="执行情况">
      </el-table-column> -->
      <!-- <el-table-column
        prop="executionDate"
        header-align="center"
        align="center"
        label="执行完毕日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="reconsiderationResult"
        header-align="center"
        align="center"
        label="复议结果">
      </el-table-column> -->
      <!-- <el-table-column
        prop="lawsuitResult"
        header-align="center"
        align="center"
        label="诉讼结果">
      </el-table-column> -->
      <!-- <el-table-column
        prop="transferInformation"
        header-align="center"
        align="center"
        label="移送信息">
      </el-table-column> -->
      <!-- <el-table-column
        prop="closeDate"
        header-align="center"
        align="center"
        label="结案日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="isClose"
        header-align="center"
        align="center"
        label="是否结案N：未结案 Y：已结案">
      </el-table-column> -->
      <!-- <el-table-column
        prop="fileNumber"
        header-align="center"
        align="center"
        label="案卷号">
      </el-table-column>
      <el-table-column
        prop="remark"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="updateTine"
        header-align="center"
        align="center"
        label="修改时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="resource"
        header-align="center"
        align="center"
        label="数据来源">
      </el-table-column> -->
      <!-- <el-table-column
        prop="status"
        header-align="center"
        align="center"
        label="状态0：新增 1：修改 2：删除">
      </el-table-column> -->
      <!-- <el-table-column
        prop="exchangeStatus"
        header-align="center"
        align="center"
        label="是否已交换N：未交换 Y：已交换">
      </el-table-column> -->
      <!-- <el-table-column
        prop="examineStatus"
        header-align="center"
        align="center"
        label="审核状态">
      </el-table-column> -->
      <el-table-column
        prop="creditCode"
        header-align="center"
        align="center"
        label="统一社会信用代码">
      </el-table-column>
      <!-- <el-table-column
        prop="relatedMaterials"
        header-align="center"
        align="center"
        label="作出决定的相关材料">
      </el-table-column> -->
      <!-- <el-table-column
        prop="casesType"
        header-align="center"
        align="center"
        label="违法案件类型">
      </el-table-column> -->
      <!-- <el-table-column
        prop="timestamp"
        header-align="center"
        align="center"
        label="更新时间戳">
      </el-table-column> -->
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="100"
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
  import AddOrUpdate from './oriadministrativepenalty-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          pollutionSourceName: ''
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
          url: this.$http.adornUrl('/spider/oriadministrativepenalty/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'pollutionSourceName': this.dataForm.pollutionSourceName
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
            url: this.$http.adornUrl('/spider/oriadministrativepenalty/delete'),
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
      },
      fmtStatus (state) {
        if (state === '0') {
          return '新增'
        } else if (state === '1') {
          return '修改'
        } else if (state === '2') {
          return '删除'
        }
      },
      fmtIsClose (isClose) {
        if (isClose === 'Y') {
          return '已结案'
        } else if (isClose === 'N') {
          return '未结案'
        } else {
          return isClose
        }
      },
      fmtExchangeStatus (exStatus) {
        if (exStatus === 'Y') {
          return '已交换'
        } else if (exStatus === 'N') {
          return '未交换'
        } else {
          return exStatus
        }
      }
    }
  }
</script>
