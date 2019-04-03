<template>
	<div>
		<h4>网站备案 <el-tag size="mini">{{totalPage}}</el-tag></h4>
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
        label="序号"
        width="50">
      </el-table-column>
      <el-table-column
        prop="approveDate"
        header-align="center"
        align="center"
        width="100"
        label="审核时间">
      </el-table-column>
      <el-table-column
        prop="siteName"
        header-align="center"
        align="center"
        label="网站名称">
      </el-table-column>
       <el-table-column
        prop="homepage"
        header-align="center"
        align="center"
        label="网站首页">
      </el-table-column>
      <el-table-column
        prop="domainName"
        header-align="center"
        align="center"
        label="域名">
      </el-table-column>
      <el-table-column
        prop="recordNo"
        header-align="center"
        align="center"
        label="备案号">
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        width="90"
        label="状态">
      </el-table-column>
      <el-table-column
        prop="unitProperties"
        header-align="center"
        align="center"
        width="90"
        label="单位性质">
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
    name: 'icp',
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
          url: this.$http.adornUrl('/spider/rpttnicp/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'enterpriseId': this.enterpriseId
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