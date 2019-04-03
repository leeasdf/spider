<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.cfXdrMc" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="dataForm.cfFr" placeholder="法人代表人姓名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button v-if="isAuth('dataparser:creditchinapubpenalty:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('dataparser:creditchinapubpenalty:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form label-width="120px" inline class="yzx-table-expand">
            <el-form-item label="处罚机关"><span>{{props.row.cfXzjg}}</span></el-form-item>
            <el-form-item label="决定日期"><span>{{props.row.cfJdrq}}</span></el-form-item>
            <el-form-item label="处罚结果" class="yzx-table-rowspan"><span>{{props.row.cfJg}}</span></el-form-item>
            <el-form-item label="处罚事由" class="yzx-table-rowspan"><span>{{props.row.cfSy}}</span></el-form-item>
            <el-form-item label="处罚依据" class="yzx-table-rowspan"><span>{{props.row.cfYj}}</span></el-form-item>
            <el-form-item label="上传时间"><span>{{props.row.uploadDate}}</span></el-form-item>
            <el-form-item label="数据更新时间"><span>{{props.row.cfSjc}}</span></el-form-item>
            <el-form-item label="areaCode"><span>{{props.row.areaCode}}</span></el-form-item>
            <el-form-item label="cfBz"><span>{{props.row.cfBz}}</span></el-form-item>
            <el-form-item label="cfCflb2"><span>{{props.row.cfCflb2}}</span></el-form-item>
            <el-form-item label="cfDfbm"><span>{{props.row.cfDfbm}}</span></el-form-item>
            <el-form-item label="cfQx"><span>{{props.row.cfQx}}</span></el-form-item>
            <el-form-item label="cfZt"><span>{{props.row.cfZt}}</span></el-form-item>

            <el-form-item label="cfXdrGsdj"><span>{{props.row.cfXdrGsdj}}</span></el-form-item>
            <el-form-item label="cfXdrSfz"><span>{{props.row.cfXdrSfz}}</span></el-form-item>
            <el-form-item label="cfXdrShxym"><span>{{props.row.cfXdrShxym}}</span></el-form-item>
            <el-form-item label="cfXdrSwdj"><span>{{props.row.cfXdrSwdj}}</span></el-form-item>
            <el-form-item label="cfXdrZdm"><span>{{props.row.cfXdrZdm}}</span></el-form-item>
            <el-form-item label="cfXzbm"><span>{{props.row.cfXzbm}}</span></el-form-item>

            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
            <el-form-item label="更新时间"><span>{{props.row.updateTime}}</span></el-form-item>
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
        prop="cfXdrMc"
        header-align="center"
        align="center"
        label="对象名称">
      </el-table-column>
      <el-table-column
        prop="cfFr"
        header-align="center"
        align="center"
        width="80"
        label="法人">
      </el-table-column>
      <el-table-column
        prop="cfCflb1"
        header-align="center"
        align="center"
        width="100"
        label="处罚类别">
      </el-table-column>
      <el-table-column
        prop="cfWsh"
        header-align="center"
        align="center"
        label="决定书文号">
      </el-table-column>
      <el-table-column
        prop="cfCfmc"
        header-align="center"
        align="center"
        label="处罚名称">
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
  import AddOrUpdate from './creditchinapubpenalty-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          cfXdrMc: '',
          cfFr: ''
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
          url: this.$http.adornUrl('/dataparser/creditchinapubpenalty/list'),
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
            url: this.$http.adornUrl('/dataparser/creditchinapubpenalty/delete'),
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
