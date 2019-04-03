<template>
  <div>
    <h4 class="clearfix">行政许可 <el-tag size="mini">{{totalPage}}</el-tag></h4>
    <el-table
      header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column
        type="index"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="xkWsh"
        header-align="center"
        align="center"
        label="行政许可决定书文号">
      </el-table-column>
      <el-table-column
        prop="xkSplb"
        header-align="center"
        align="center"
        label="审核类型">
      </el-table-column>
      <el-table-column
        prop="xkFr"
        header-align="center"
        align="center"
        label="法人姓名">
      </el-table-column>
      <el-table-column
        prop="xkNr"
        header-align="center"
        align="center"
        label="内容许可">
      </el-table-column>
      <el-table-column
        prop="xkJdrq"
        header-align="center"
        align="center"
        label="许可决定日期" :formatter="fmtDate">
      </el-table-column>
      <el-table-column
        prop="xkJdrq"
        header-align="center"
        align="center"
        label="许可截止日期" :formatter="fmtDate">
      </el-table-column>
      <el-table-column
        prop="xkDfbm"
        header-align="center"
        align="center"
        label="地方编码">
      </el-table-column>
      <el-table-column
        prop="xkXzjg"
        header-align="center"
        align="center"
        label="许可机关">
      </el-table-column>
      <el-table-column
        prop="xkSjc"
        header-align="center"
        align="center"
        label="数据更新时间" :formatter="fmtDate">
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
    name: 'pubpermission',
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
          url: this.$http.adornUrl('/dataparser/creditchinapubpermission/info/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'xkXdr': this.enterpriseName
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
      fmtDate (row, col, value, index) {
        if (value) {
          return value.split(' ')[0]
        } else {
          return value
        }
      }
    }
  }
</script>
