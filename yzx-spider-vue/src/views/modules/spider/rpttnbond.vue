<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rpttnbond:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rpttnbond:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form label-width="120px" inline class="yzx-table-expand">
            <el-form-item label="上市交易日"><span>{{props.row.bondTradeTime}}</span></el-form-item>
            <el-form-item label="计息方式"><span>{{props.row.calInterestType}}</span></el-form-item>
            <el-form-item label="债券摘牌日"><span>{{props.row.bondStopTime}}</span></el-form-item>
            <el-form-item label="信用评级机构"><span>{{props.row.creditRatingGov}}</span></el-form-item>
            <el-form-item label="债项评级"><span>{{props.row.debtRating}}</span></el-form-item>
            <el-form-item label="面值"><span>{{props.row.faceValue}}</span></el-form-item>
            <el-form-item label="参考利率"><span>{{props.row.refInterestRate}}</span></el-form-item>
            <el-form-item label="票面利率"><span>{{props.row.faceInterestRate}}</span></el-form-item>
            <el-form-item label="实际发行量"><span>{{props.row.realIssuedQuantity}}</span></el-form-item>
            <el-form-item label="计划发行量"><span>{{props.row.planIssuedQuantity}}</span></el-form-item>
            <el-form-item label="发行价格"><span>{{props.row.issuedPrice}}</span></el-form-item>
            <el-form-item label="利差"><span>{{props.row.interestDiff}}</span></el-form-item>
            <el-form-item label="付息频率"><span>{{props.row.payInterestHz}}</span></el-form-item>
            <el-form-item label="债券起息日"><span>{{props.row.startCalInterestTime}}</span></el-form-item>
            <el-form-item label="行权类型"><span>{{props.row.exeRightType}}</span></el-form-item>
            <el-form-item label="行权日期"><span>{{props.row.exeRightTime}}</span></el-form-item>
            <el-form-item label="托管机构"><span>{{props.row.escrowAgent}}</span></el-form-item>
            <el-form-item label="范围"><span>{{props.row.flowRange}}</span></el-form-item>
            <el-form-item label="备注"><span>{{props.row.remark}}</span></el-form-item>
            <el-form-item label="提示"><span>{{props.row.tip}}</span></el-form-item>
            <el-form-item label="债券创建时间"><span>{{props.row.bCreateTime}}</span></el-form-item>
            <el-form-item label="债券更新时间"><span>{{props.row.bUpdateTime}}</span></el-form-item>
            <el-form-item label="删除标识"><span>{{props.row.isDelete}}</span></el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>

     <!--  <el-table-column
        prop="enterpriseId"
        header-align="center"
        align="center"
        label="企业主键">
      </el-table-column> -->
      <el-table-column
        prop="entName"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <!-- <el-table-column
        prop="bId"
        header-align="center"
        align="center"
        label="债券ID">
      </el-table-column> -->
      <el-table-column
        prop="bondName"
        header-align="center"
        align="center"
        label="债券名称">
      </el-table-column>
      <el-table-column
        prop="bondNum"
        header-align="center"
        align="center"
        label="债券代码">
      </el-table-column>
      <el-table-column
        prop="publisherName"
        header-align="center"
        align="center"
        label="发行人">
      </el-table-column>
      <el-table-column
        prop="bondType"
        header-align="center"
        align="center"
        label="债券类型">
      </el-table-column>
      <el-table-column
        prop="publishTime"
        header-align="center"
        align="center"
        label="发行日期">
      </el-table-column>
      <el-table-column
        prop="publishExpireTime"
        header-align="center"
        align="center"
        label="债劵到期日">
      </el-table-column>
      <el-table-column
        prop="bondTimeLimit"
        header-align="center"
        align="center"
        label="债劵期限">
      </el-table-column>
     <!--  <el-table-column
        prop="bondTradeTime"
        header-align="center"
        align="center"
        label="上市交易日">
      </el-table-column> -->
      <!-- <el-table-column
        prop="calInterestType"
        header-align="center"
        align="center"
        label="计息方式">
      </el-table-column> -->
      <!-- <el-table-column
        prop="bondStopTime"
        header-align="center"
        align="center"
        label="债劵摘牌日">
      </el-table-column> -->
      <!-- <el-table-column
        prop="creditRatingGov"
        header-align="center"
        align="center"
        label="信用评级机构">
      </el-table-column> -->
      <!-- <el-table-column
        prop="debtRating"
        header-align="center"
        align="center"
        label="债项评级">
      </el-table-column> -->
      <!-- <el-table-column
        prop="faceValue"
        header-align="center"
        align="center"
        label="面值（元）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="refInterestRate"
        header-align="center"
        align="center"
        label="参考利率（％）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="faceInterestRate"
        header-align="center"
        align="center"
        label="票面利率（％）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="realIssuedQuantity"
        header-align="center"
        align="center"
        label="实际发行量（亿）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="planIssuedQuantity"
        header-align="center"
        align="center"
        label="计划发行量（亿）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="issuedPrice"
        header-align="center"
        align="center"
        label="发行价格（元）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="interestDiff"
        header-align="center"
        align="center"
        label="利差（BP）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="payInterestHz"
        header-align="center"
        align="center"
        label="付息频率">
      </el-table-column> -->
      <!-- <el-table-column
        prop="startCalInterestTime"
        header-align="center"
        align="center"
        label="债劵起息日">
      </el-table-column> -->
      <!-- <el-table-column
        prop="exeRightType"
        header-align="center"
        align="center"
        label="行权类型">
      </el-table-column> -->
      <!-- <el-table-column
        prop="exeRightTime"
        header-align="center"
        align="center"
        label="行权日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="escrowAgent"
        header-align="center"
        align="center"
        label="托管机构">
      </el-table-column> -->
      <!-- <el-table-column
        prop="flowRange"
        header-align="center"
        align="center"
        label="范围">
      </el-table-column> -->
      <!-- <el-table-column
        prop="remark"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column> -->
      <!-- <el-table-column
        prop="tip"
        header-align="center"
        align="center"
        label="提示">
      </el-table-column> -->
      <!-- <el-table-column
        prop="bCreateTime"
        header-align="center"
        align="center"
        label="债券创建时间">
      </el-table-column>
      <el-table-column
        prop="bUpdateTime"
        header-align="center"
        align="center"
        label="债券更新时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="isDelete"
        header-align="center"
        align="center"
        label="删除标识">
      </el-table-column> -->
      
      <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        label="数据状态" :formatter="fmtDateState">
      </el-table-column>
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
  import AddOrUpdate from './rpttnbond-add-or-update'
  import { formatDataState } from '@/utils/dataFormat'
  export default {
    data () {
      return {
        dataForm: {
          entName: ''
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
          url: this.$http.adornUrl('/spider/rpttnbond/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'entName': this.dataForm.entName
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
            url: this.$http.adornUrl('/spider/rpttnbond/delete'),
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
      fmtDateState (row, col, value, index) {
        return formatDataState(value)
      }
    }
  }
</script>
