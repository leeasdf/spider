<template>
  <div>
    <h4 class="clearfix">重点关注名单－工商总局 <el-tag size="mini">{{totalPage}}</el-tag></h4>
    <el-table
      header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form label-position="left" inline class="yzx-table-expand">
            <el-form-item label="数据类别"><span>{{props.row.type}}</span></el-form-item>
            <el-form-item label="数据来源"><span>{{props.row.source}}</span></el-form-item>
            <el-form-item label="发布时间"><span>{{props.row.published}}</span></el-form-item>
            <el-form-item label="立案时间"><span>{{props.row.filingTime}}</span></el-form-item>
            <el-form-item label="已履行部分"><span>{{props.row.fulfilledPart}}</span></el-form-item>
            <el-form-item label="未履行部分"><span>{{props.row.unfulfilledPart}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
            <el-form-item label="更新时间"><span>{{props.row.updateTime}}</span></el-form-item>
            <el-form-item label="新更新日期"><span>{{props.row.lastUpdateTime}}</span></el-form-item>
            <el-form-item label="法律义务" class="yzx-table-rowspan"><span>{{props.row.lawDuty}}</span></el-form-item>
            <el-form-item label="履行情况"  class="yzx-table-rowspan"><span>{{props.row.performance}}</span></el-form-item>
            <el-form-item label="具体情形" class="yzx-table-rowspan"><span>{{props.row.situation}}</span></el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        type="index"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="caseNo"
        header-align="center"
        align="center"
        label="案号">
      </el-table-column>
      <!-- <el-table-column
        prop="area"
        header-align="center"
        align="center"
        width="80"
        label="地域名称">
      </el-table-column> -->
      <el-table-column
        prop="court"
        header-align="center"
        align="center"
        label="执行法院">
      </el-table-column>
      <el-table-column
        prop="basisNumber"
        header-align="center"
        align="center"
        label="执行依据文号">
      </el-table-column>
      <el-table-column
        prop="executionBasis"
        header-align="center"
        align="center"
        label="作出执行依据单位">
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
    name: 'blacklaw',
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
          url: this.$http.adornUrl('/dataparser/creditchinablacklaw/info/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'dishonestName': this.enterpriseName
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
