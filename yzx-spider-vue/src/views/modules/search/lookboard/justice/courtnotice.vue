<template>
	<div>
		<h4>法院公告 <el-tag size="mini">{{totalPage}}</el-tag></h4>
		<el-table
      header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form label-position="left" label-width="120px" inline class="yzx-table-expand">
            <el-form-item label="公告状态"><span>{{props.row.bltnstate}}</span></el-form-item>
            <el-form-item label="判决人联系方式"><span>{{props.row.judgephone}}</span></el-form-item>
            <el-form-item label="省份"><span>{{props.row.province}}</span></el-form-item>
            <el-form-item label="刊登日期"><span>{{props.row.showtxtdate}}</span></el-form-item>
            <el-form-item label="临时保存编号"><span>{{props.row.tmpsaversn}}</span></el-form-item>
            <el-form-item label="发布界面"><span>{{props.row.publishpage}}</span></el-form-item>
            <el-form-item label="被诉方网址"><span>{{props.row.party2str}}</span></el-form-item>
            <el-form-item label="判决人"><span>{{props.row.judge}}</span></el-form-item>
            <el-form-item label="上诉方网址"><span>{{props.row.party1str}}</span></el-form-item>
            <el-form-item label="案件编号"><span>{{props.row.caseno}}</span></el-form-item>
            <el-form-item label="法院标识"><span>{{props.row.courtflag}}</span></el-form-item>
            <el-form-item label="联系方式"><span>{{props.row.mobilephone}}</span></el-form-item>
            <el-form-item label="企业列表"><span>{{props.row.companyList}}</span></el-form-item>
            <el-form-item label="cn编号"><span>{{props.row.cnId}}</span></el-form-item>
            <el-form-item label="公告内容" class="yzx-table-rowspan"><span>{{props.row.content}}</span></el-form-item>
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
        prop="publishdate"
        header-align="center"
        align="center"
        width="100"
        label="公告时间">
      </el-table-column>
      <el-table-column
        prop="party1"
        header-align="center"
        align="center"
        label="上诉方">
      </el-table-column>
      <el-table-column
        prop="party2"
        header-align="center"
        align="center"
        label="被诉方">
      </el-table-column>
      <el-table-column
        prop="bltntypename"
        header-align="center"
        align="center"
        width="180"
        label="公告类型">
      </el-table-column>
      <el-table-column
        prop="courtcode"
        header-align="center"
        align="center"
        label="法院">
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
    name: 'courtnotice',
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
          url: this.$http.adornUrl('/spider/rpttncourtnotice/list'),
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