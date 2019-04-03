<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rpttnmortgage:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rpttnmortgage:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="expand"
        width="40">
        <template slot-scope="props">
          <el-form inline class="yzx-table-expand">
            <el-form-item label="登记机关"><span>{{props.row.regDepartment}}</span></el-form-item>
            <el-form-item label="登记日期"><span>{{props.row.regDate}}</span></el-form-item>
            <el-form-item label="登记编号"><span>{{props.row.regNum}}</span></el-form-item>
            <el-form-item label="公布日期"><span>{{props.row.publishDate}}</span></el-form-item>
            <el-form-item label="经营范围" class="yzx-table-rowspan"><span>{{props.row.scope}}</span></el-form-item>
            <el-form-item label="债务人履行债务期限"><span>{{props.row.term}}</span></el-form-item>
            <el-form-item label="动产抵押登记信息"><span>{{props.row.changeInfoList}}</span></el-form-item>
            <el-form-item label="抵押权人信息"><span>{{props.row.peopleInfo}}</span></el-form-item>
            <el-form-item label="抵押物信息"><span>{{props.row.pawnInfoList}}</span></el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>

      <!-- <el-table-column
        prop="enterpriseId"
        header-align="center"
        align="center"
        label="企业主键">
      </el-table-column> -->
      <el-table-column
        prop="entName"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="overviewAmount"
        header-align="center"
        align="center"
        label="被担保债权数额">
      </el-table-column>
      <!-- <el-table-column
        prop="scope"
        header-align="center"
        align="center"
        label="经营范围">
      </el-table-column> -->
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        width="80"
        label="状态">
      </el-table-column>
      <el-table-column
        prop="overviewScope"
        header-align="center"
        align="center"
        label="担保范围">
      </el-table-column>
      <!-- <el-table-column
        prop="mId"
        header-align="center"
        align="center"
        label="担保ID">
      </el-table-column> -->
      <el-table-column
        prop="amount"
        header-align="center"
        align="center"
        width="100"
        label="金额">
      </el-table-column>
     <!--  <el-table-column
        prop="regDepartment"
        header-align="center"
        align="center"
        label="登记机关">
      </el-table-column>
      <el-table-column
        prop="regDate"
        header-align="center"
        align="center"
        label="登记日期">
      </el-table-column> -->
      <el-table-column
        prop="overviewTerm"
        header-align="center"
        align="center"
        width="100"
        label="担保时间">
      </el-table-column>
      <!-- <el-table-column
        prop="regNum"
        header-align="center"
        align="center"
        label="登记编号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="term"
        header-align="center"
        align="center"
        label="债务人履行债务期限">
      </el-table-column> -->
      <!-- <el-table-column
        prop="publishDate"
        header-align="center"
        align="center"
        label="公布日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="changeInfoList"
        header-align="center"
        align="center"
        label="动产抵押登记信息">
      </el-table-column> -->
      <!-- <el-table-column
        prop="pawnInfoList"
        header-align="center"
        align="center"
        label="抵押物信息">
      </el-table-column> -->
      <!-- <el-table-column
        prop="peopleInfo"
        header-align="center"
        align="center"
        label="抵押权人信息">
      </el-table-column> -->
      
      <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        width="80"
        label="数据状态" :formatter="fmtDataState">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="100"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
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
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './rpttnmortgage-add-or-update'
  import { formatDataState } from '@/utils/dataFormat'
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
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/spider/rpttnmortgage/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'entName': this.dataForm.entName
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
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/spider/rpttnmortgage/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      },
      fmtDataState (row, col, value, index) {
        return formatDataState(value)
      }
    }
  }
</script>
