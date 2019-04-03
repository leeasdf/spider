<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.punishmentObject" placeholder="处罚对象名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="isAuth('dataparser:creditchinafocuspenalty:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('dataparser:creditchinafocuspenalty:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">

      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form label-width="100px" inline class="yzx-table-expand">
            <el-form-item label="处罚名称" class="yzx-table-rowspan"><span>{{props.row.punishmentName}}</span></el-form-item>
            <el-form-item label="决定书ID"><span>{{props.row.penaltyDecision}}</span></el-form-item>
            <el-form-item label="处理日期"><span>{{props.row.punishmentDate}}</span></el-form-item>
            <el-form-item label="最新更新日期"><span>{{props.row.lastUpdateTime}}</span></el-form-item>
            <el-form-item label="数据来源"><span>{{props.row.source}}</span></el-form-item>
            <el-form-item label="数据类别"><span>{{props.row.type}}</span></el-form-item>
            <el-form-item label="信息类型"><span>{{props.row.informationType}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
            <el-form-item label="更新时间"><span>{{props.row.updateTime}}</span></el-form-item>
            <el-form-item label="处罚内容" class="yzx-table-rowspan"><span>{{props.row.punishmentContent}}</span></el-form-item>
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
  import AddOrUpdate from './creditchinafocuspenalty-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          punishmentObject: ''
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
        let params = this.dataForm
        params.page = this.pageIndex
        params.limit = this.pageSize
        this.$http({
          url: this.$http.adornUrl('/dataparser/creditchinafocuspenalty/list'),
          method: 'get',
          params: this.$http.adornParams(params)
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
            url: this.$http.adornUrl('/dataparser/creditchinafocuspenalty/delete'),
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
