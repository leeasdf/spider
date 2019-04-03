<template>
	<div>
		<h4>行政处罚[工商局] <el-tag size="mini">{{totalPage}}</el-tag></h4>
		 <el-table
      header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form inline class="yzx-table-expand">
            <el-form-item label="类型" class="yzx-table-rowspan"><span>{{props.row.type}}</span></el-form-item>
            <el-form-item label="决定机关" class="yzx-table-rowspan"><span>{{props.row.departmentName}}</span></el-form-item>
            <el-form-item label="地域"><span>{{props.row.areaName}}</span></el-form-item>
            <el-form-item label="注册号"><span>{{props.row.regNum}}</span></el-form-item>
            <el-form-item label="姓名"><span>{{props.row.name}}</span></el-form-item>
            <el-form-item label="发布日期"><span>{{props.row.publishDate}}</span></el-form-item>
            <el-form-item label="地点"><span>{{props.row.base}}</span></el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        type="index"
        header-align="center"
        align="center"
        label="序号"
        width="50">
      </el-table-column>
      <el-table-column
        prop="decisionDate"
        header-align="center"
        align="center"
        width="100"
        label="决定日期">
      </el-table-column>
      <el-table-column
        prop="punishNumber"
        header-align="center"
        align="center"
        label="决定书文号">
      </el-table-column>
      <el-table-column
        prop="type"
        header-align="center"
        align="center"
        label="类型">
      </el-table-column>
      <el-table-column
        prop="departmentName"
        header-align="center"
        align="center"
        label="决定机关">
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
    name: 'penalties',
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
          url: this.$http.adornUrl('/spider/rpttnpenalties/list'),
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