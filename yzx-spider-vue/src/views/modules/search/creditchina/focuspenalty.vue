<template>
  <div>
    <template v-if="totalPage > 0">
    <h4 class="clearfix">重点关注名单－证监会 <el-tag size="mini">{{totalPage}}</el-tag></h4>
    <el-table
      header-row-class-name="headerCls"
      :data="dataList"
      border
      v-loading="dataListLoading"
      style="width: 100%;">
      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form inline class="yzx-table-expand">
            <el-form-item label="处罚内容" class="yzx-table-rowspan"><span>{{props.row.punishmentContent}}</span></el-form-item>
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
        prop="punishmentName"
        header-align="center"
        align="center"
        label="处罚名称">
      </el-table-column>
      <el-table-column
        prop="punishmentOrgan"
        header-align="center"
        align="center"
        width="120"
        label="处罚机关">
      </el-table-column>
      <el-table-column
        prop="type"
        header-align="center"
        align="center"
        width="120"
        label="数据类别">
      </el-table-column>
      <el-table-column
        prop="punishmentObject"
        header-align="center"
        align="center"
        label="处罚对象名称">
      </el-table-column>
      <el-table-column
        prop="punishmentDepart"
        header-align="center"
        align="center"
        label="实际处罚部门">
      </el-table-column>
      <el-table-column
        prop="punishmentType"
        header-align="center"
        align="center"
        label="处罚处理种类">
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
    </template>
  </div>
</template>
<script>
  export default {
    name: 'focuspenalty',
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
          url: this.$http.adornUrl('/dataparser/creditchinafocuspenalty/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'enterpriseName': this.enterpriseName
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
