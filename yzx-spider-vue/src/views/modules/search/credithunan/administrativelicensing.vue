<template>
	<div>
		<h4>行政许可 <el-tag size="mini">{{totalPage}}</el-tag></h4>
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
        prop="lawEnforcingDepartment"
        header-align="center"
        align="center"
        label="执法部门">
      </el-table-column>
      <el-table-column
        prop="licensingDate"
        header-align="center"
        align="center"
        label="许可日期">
      </el-table-column>
      <el-table-column
        prop="publishTime"
        header-align="center"
        align="center"
        label="发布日期">
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  export default {
    name: 'administrativelicensing',
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
          url: this.$http.adornUrl('/dataparser/credithunanadministrativelicensing/info/list'),
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
