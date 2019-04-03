<template>
	<div>
		<h4>软件著作权 <el-tag size="mini">{{totalPage}}</el-tag></h4>
		<el-table
      header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column
        type="expand"
        width="40">
        <template slot-scope="props">
          <el-form inline label-width="120px" class="yzx-table-expand">
            <el-form-item label="著作详情信息" class="yzx-table-rowspan"><span>{{props.row.author}}</span></el-form-item>
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
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="appDate"
        header-align="center"
        align="center"
        width="100"
        label="批准日期">
      </el-table-column>
      <el-table-column
        prop="fullname"
        header-align="center"
        align="center"
        label="软件全称" show-overflow-tooltip>
      </el-table-column>
      <el-table-column
        prop="simpleName"
        header-align="center"
        align="center"
        width="150"
        label="软件简称" show-overflow-tooltip>
      </el-table-column>
      <el-table-column
        prop="regnum"
        header-align="center"
        align="center"
        width="120"
        label="登记号">
      </el-table-column>
      <el-table-column
        prop="catnum"
        header-align="center"
        align="center"
        label="分类号">
      </el-table-column>
      <el-table-column
        prop="version"
        header-align="center"
        align="center"
        label="版本号">
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
    name: 'softwareright',
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
          url: this.$http.adornUrl('/spider/rpttnsoftwareright/list'),
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