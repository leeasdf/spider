<template>
  <div class="mod-search">
    <el-form inline :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">搜索</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column
        prop="enterpriseName"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="organizationCode"
        header-align="center"
        align="center"
        label="组织机构编码">
      </el-table-column>
      <el-table-column
        prop="businessLicenseNo"
        header-align="center"
        align="center"
        label="营业执照号">
      </el-table-column>
      <el-table-column
        prop="taxNo"
        header-align="center"
        align="center"
        label="税号">
      </el-table-column>
      <el-table-column
        prop="creditCode"
        header-align="center"
        align="center"
        label="统一社会信用代码">
      </el-table-column>
       <el-table-column
        prop="industryType"
        header-align="center"
        align="center"
        label="行业归属" :formatter="fmtIndustryType">
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        label="企业状态">
      </el-table-column>
      <el-table-column
        prop="dataSource"
        header-align="center"
        align="center"
        label="数据来源">
      </el-table-column>
      <el-table-column
        prop="legalPersonName"
        header-align="center"
        align="center"
        label="企业法人">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="120"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="viewHandle(scope.row)">查看</el-button>
        </template>
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
  import { formatIndustryType } from '@/utils/dataFormat'
  export default {
    data () {
      return {
        dataForm: {
          entName: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false
      }
    },
    created () {
      this.dataForm.entName = this.$route.params.key
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/spider/hightechzoneenterpriseinfo/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'enterpriseName': this.dataForm.entName
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
      viewHandle (row) {
        this.$router.push('/search-enterpriseinfo/' + row.id + '/' + row.enterpriseName)
      },
      fmtIndustryType (row, col, value, index) {
        return formatIndustryType(value)
      }
    }
  }
</script>
