<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rpttninvest:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rpttninvest:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form label-position="left" inline class="yzx-table-expand">
            <el-form-item label="（已废弃）"><span>{{props.row.regCap}}</span></el-form-item>
            <!--
            <el-form-item label="天眼查地址"><span>{{props.row.url}}</span></el-form-item>
            -->
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="entName"
        header-align="center"
        align="center"
        label="企业（机构）名称">
      </el-table-column>
      <el-table-column
        prop="regTime"
        header-align="center"
        align="center"
        width="100"
        label="注册时间">
      </el-table-column>
      <el-table-column
        prop="legalPerson"
        header-align="center"
        align="center"
        width="90"
        label="被投资法定代表人">
      </el-table-column>
      <el-table-column
        prop="invAmount"
        header-align="center"
        align="center"
        width="130"
        label="注册资本">
      </el-table-column>
      <el-table-column
        prop="cmpName"
        header-align="center"
        align="center"
        label="被投资公司名称">
      </el-table-column>
      <el-table-column
        prop="invRatio"
        header-align="center"
        align="center"
        width="90"
        label="投资占比">
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        width="120"
        label="状态">
      </el-table-column>
     <!--  <el-table-column
        prop="regCap"
        header-align="center"
        align="center"
        label="（已废弃）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        label="数据状态：1-正常 0-删除">
      </el-table-column> -->
      <!-- <el-table-column
        prop="url"
        header-align="center"
        align="center"
        label="天眼查地址">
      </el-table-column> -->
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="120"
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
  import AddOrUpdate from './rpttninvest-add-or-update'
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
          url: this.$http.adornUrl('/spider/rpttninvest/list'),
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
            url: this.$http.adornUrl('/spider/rpttninvest/delete'),
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
      }
    }
  }
</script>
