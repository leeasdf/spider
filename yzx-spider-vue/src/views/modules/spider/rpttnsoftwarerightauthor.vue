<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rpttnsoftwarerightauthor:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rpttnsoftwarerightauthor:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
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
        prop="entAme"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="fullname"
        header-align="center"
        align="center"
        label="软件全称">
      </el-table-column>
      <el-table-column
        prop="simplename"
        header-align="center"
        align="center"
        label="软件简称">
      </el-table-column>
      <el-table-column
        prop="regnum"
        header-align="center"
        align="center"
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
      <el-table-column
        prop="authorNationality"
        header-align="center"
        align="center"
        label="著作权人(国籍)">
      </el-table-column>
      <el-table-column
        prop="publishtime"
        header-align="center"
        align="center"
        label="首次发表日期">
      </el-table-column>
      <el-table-column
        prop="regtime"
        header-align="center"
        align="center"
        label="登记日期">
      </el-table-column>
      
      <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
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
  import AddOrUpdate from './rpttnsoftwarerightauthor-add-or-update'
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
          url: this.$http.adornUrl('/spider/rpttnsoftwarerightauthor/list'),
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
            url: this.$http.adornUrl('/spider/rpttnsoftwarerightauthor/delete'),
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
