<template>
	<div>
		<h4>行政处罚 <el-tag size="mini">{{totalPage}}</el-tag></h4>
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
        prop="caseName"
        header-align="center"
        align="center"
        label="案件名称">
      </el-table-column>
      <el-table-column
        prop="caseNo"
        header-align="center"
        align="center"
        label="决定书文号">
      </el-table-column>
      <el-table-column
        prop="lowDepartment"
        header-align="center"
        align="center"
        width="120"
        label="执法部门">
      </el-table-column>
      <el-table-column
        prop="punishmentDate"
        header-align="center"
        align="center"
        width="120"
        label="处罚日期">
      </el-table-column>
      <el-table-column
        prop="issueDate"
        header-align="center"
        align="center"
        width="120"
        label="发布日期">
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
    name: 'administrativepenalty',
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
          url: this.$http.adornUrl('/dataparser/credithunanadministrativepenalty/info/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'caseObject': this.enterpriseName
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
