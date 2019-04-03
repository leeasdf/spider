<template>
  <div>
    <h4 class="clearfix">行政处罚 <el-tag size="mini">{{totalPage}}</el-tag></h4>
    <el-table
      header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form label-position="left" inline class="yzx-table-expand">
            <el-form-item label="处罚机关"><span>{{props.row.cfXzjg}}</span></el-form-item>
            <el-form-item label="决定日期"><span>{{props.row.cfJdrq}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
            <el-form-item label="更新时间"><span>{{props.row.updateTime}}</span></el-form-item>
            <el-form-item label="处罚结果" class="yzx-table-rowspan"><span>{{props.row.cfJg}}</span></el-form-item>
            <el-form-item label="处罚事由" class="yzx-table-rowspan"><span>{{props.row.cfSy}}</span></el-form-item>
            <el-form-item label="处罚依据" class="yzx-table-rowspan"><span>{{props.row.cfYj}}</span></el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        type="index"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="cfFr"
        header-align="center"
        align="center"
        width="120"
        label="法人">
      </el-table-column>
      <el-table-column
        prop="cfCflb1"
        header-align="center"
        align="center"
        width="180"
        label="处罚类别">
      </el-table-column>
      <el-table-column
        prop="cfWsh"
        header-align="center"
        align="center"
        width="240"
        label="决定书文号">
      </el-table-column>
      <el-table-column
        prop="cfCfmc"
        header-align="center"
        align="center"
        label="处罚名称" show-overflow-tooltip>
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
  </div>
</template>
<script>
  export default {
    name: 'pubpenalty',
    props: ['enterpriseId', 'enterpriseName'],
    data () {
      return {
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false
      }
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/dataparser/creditchinapubpenalty/info/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'cfXdrMc': this.enterpriseName
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
      }
    }
  }
</script>
