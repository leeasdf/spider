<template>
	<div>
		<h4 class="clearfix">股东信息 <el-tag size="mini">{{totalPage}}</el-tag></h4>
		<el-table
			header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column
      	type="index"
      	label="序号"
      	width="50">
      </el-table-column>
      <el-table-column
        prop="name"
        header-align="center"
        align="center"
        label="股东（发起人）">
      </el-table-column>
      <el-table-column
        prop="funRatio"
        header-align="center"
        align="center"
        label="出资比例">
      </el-table-column>
      <el-table-column
        prop="subFunding"
        header-align="center"
        align="center"
        label="认缴出资">
      </el-table-column>
      <el-table-column
        prop="amountDate"
        header-align="center"
        align="center"
        label="出资时间">
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
    name: 'shareholders',
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
          url: this.$http.adornUrl('/spider/rpttnshareholders/list'),
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