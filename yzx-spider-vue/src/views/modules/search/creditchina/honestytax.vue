<template>
  <div>
    <h4 class="clearfix">守信红名单 <el-tag size="mini">{{totalPage}}</el-tag></h4>
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
        prop="taxName"
        header-align="center"
        align="center"
        label="纳税人名称">
      </el-table-column>
      <el-table-column
        prop="year"
        header-align="center"
        align="center"
        width="120"
        label="评价年度">
      </el-table-column>
      <el-table-column
        prop="source"
        header-align="center"
        align="center"
        label="数据来源">
      </el-table-column>
      <el-table-column
        prop="type"
        header-align="center"
        align="center"
        label="数据类别">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        width="160"
        label="更新时间">
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
    name: 'honestytax',
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
          url: this.$http.adornUrl('/dataparser/creditchinahonestytax/info/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'taxName': this.enterpriseName
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
