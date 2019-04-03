<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rptcaseinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rptcaseinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
            <el-form-item label="作出行政处罚决定机关名称"><span>{{props.row.penauth}}</span></el-form-item>
            <el-form-item label="主要违法事实"><span>{{props.row.illegfact}}</span></el-form-item>
            <el-form-item label="处罚依据"><span>{{props.row.penbasis}}</span></el-form-item>
            <el-form-item label="处罚种类"><span>{{props.row.pentype}}</span></el-form-item>
            <el-form-item label="处罚结果"><span>{{props.row.penresult}}</span></el-form-item>
            <el-form-item label="处罚金额"><span>{{props.row.penam}}</span></el-form-item>
            <el-form-item label="处罚执行情况"><span>{{props.row.penexest}}</span></el-form-item>
            <el-form-item label="案由" class="yzx-table-rowspan"><span>{{props.row.casereason}}</span></el-form-item>
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
        prop="memid"
        header-align="center"
        align="center"
        label="会员ID">
      </el-table-column>
      <el-table-column
        prop="enterpriseId"
        header-align="center"
        align="center"
        label="企业ID">
      </el-table-column> -->
      <el-table-column
        prop="casetime"
        header-align="center"
        align="center"
        width="100"
        label="案发时间">
      </el-table-column>
      <!-- <el-table-column
        prop="casereason"
        header-align="center"
        align="center"
        label="案由" show-overflow-tooltip>
      </el-table-column> -->
      <el-table-column
        prop="caseval"
        header-align="center"
        align="center"
        label="案值">
      </el-table-column>
      <el-table-column
        prop="casetype"
        header-align="center"
        align="center"
        width="100"
        label="案件类型">
      </el-table-column>
      <el-table-column
        prop="exesort"
        header-align="center"
        align="center"
        label="执行类别">
      </el-table-column>
      <el-table-column
        prop="caseresult"
        header-align="center"
        align="center"
        width="100"
        label="案件结果">
      </el-table-column>
      <el-table-column
        prop="pendecno"
        header-align="center"
        align="center"
        label="处罚决定文书">
      </el-table-column>
      <el-table-column
        prop="pendecissdate"
        header-align="center"
        align="center"
        width="100"
        label="处罚决定书签发日期">
      </el-table-column>
      <!-- <el-table-column
        prop="penauth"
        header-align="center"
        align="center"
        label="作出行政处罚决定机关名称">
      </el-table-column>
      <el-table-column
        prop="illegfact"
        header-align="center"
        align="center"
        label="主要违法事实">
      </el-table-column>
      <el-table-column
        prop="penbasis"
        header-align="center"
        align="center"
        label="处罚依据">
      </el-table-column>
      <el-table-column
        prop="pentype"
        header-align="center"
        align="center"
        label="处罚种类">
      </el-table-column>
      <el-table-column
        prop="penresult"
        header-align="center"
        align="center"
        label="处罚结果">
      </el-table-column>
      <el-table-column
        prop="penam"
        header-align="center"
        align="center"
        label="处罚金额">
      </el-table-column>
      <el-table-column
        prop="penexest"
        header-align="center"
        align="center"
        label="处罚执行情况">
      </el-table-column> -->
      
      <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        width="100"
        label="数据状态" :formatter="fmtDataState">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="120"
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
  import AddOrUpdate from './rptcaseinfo-add-or-update'
  import { formatDataState } from '@/utils/dataFormat'
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
          url: this.$http.adornUrl('/spider/rptcaseinfo/list'),
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
            url: this.$http.adornUrl('/spider/rptcaseinfo/delete'),
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
      fmtDataState (row, col, value, index) {
        return formatDataState(value)
      }
    }
  }
</script>
