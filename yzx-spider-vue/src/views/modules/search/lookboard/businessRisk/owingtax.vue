<template>
	<div>
		<h4>欠税登记 <el-tag size="mini">{{totalPage}}</el-tag></h4>
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
        prop="publicDate"
        header-align="center"
        align="center"
        width="100"
        label="发布日期">
      </el-table-column>
      <el-table-column
        prop="taxNo"
        header-align="center"
        align="center"
        label="纳税人识别号(已加密)">
      </el-table-column>
      <el-table-column
        prop="oweTaxType"
        header-align="center"
        align="center"
        width="100"
        label="欠税税种">
      </el-table-column>
      <el-table-column
        prop="currentOweTaxAmount"
        header-align="center"
        align="center"
        label="当前发生的欠税额">
      </el-table-column>
      <el-table-column
        prop="ownTaxBalance"
        header-align="center"
        align="center"
        label="欠税余额">
      </el-table-column>
      <el-table-column
        prop="taxDepart"
        header-align="center"
        align="center"
        label="税务机关">
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
    name: 'owingtax',
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
          url: this.$http.adornUrl('/spider/rpttnowingtax/list'),
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