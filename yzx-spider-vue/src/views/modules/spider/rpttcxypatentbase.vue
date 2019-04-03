<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rpttcxypatentbase:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rpttcxypatentbase:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form inline label-width="100px" class="yzx-table-expand">
            <el-form-item label="主分类号"><span>{{props.row.mainClassCode}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{formatDate(props.row.createTime)}}</span></el-form-item>
            <el-form-item label="专利代理机构"><span>{{props.row.agentOrg}}</span></el-form-item>
            <el-form-item label="代理人"><span>{{props.row.agent}}</span></el-form-item>
            <el-form-item label="公开号"><span>{{props.row.pubNum}}</span></el-form-item>
            <el-form-item label="公开日期"><span>{{props.row.pubDate}}</span></el-form-item>
            <el-form-item label="分类号" class="yzx-table-rowspan"><span>{{props.row.classCode}}</span></el-form-item>
            <el-form-item label="专利摘要" class="yzx-table-rowspan"><span>{{props.row.summary}}</span></el-form-item>
            <el-form-item label="地址" class="yzx-table-rowspan"><span>{{props.row.address}}</span></el-form-item>
            <el-form-item label="国际公布"><span>{{props.row.intelPub}}</span></el-form-item>
            <el-form-item label="国际申请"><span>{{props.row.intelApply}}</span></el-form-item>
            <el-form-item label="进入国家日期"><span>{{props.row.intoChinaDate}}</span></el-form-item>
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
        prop="companyId"
        header-align="center"
        align="center"
        label="公司ID">
      </el-table-column> -->
      <el-table-column
        prop="title"
        header-align="center"
        align="center"
        label="专利名称" show-overflow-tooltip>
      </el-table-column>
     <!--  <el-table-column
        prop="mainClassCode"
        header-align="center"
        align="center"
        label="主分类号">
      </el-table-column> -->
      <el-table-column
        prop="type"
        header-align="center"
        align="center"
        width="100"
        label="专利类型">
      </el-table-column>
     <!--  <el-table-column
        prop="classCode"
        header-align="center"
        align="center"
        label="分类号">
      </el-table-column> -->
      <el-table-column
        prop="designer"
        header-align="center"
        align="center"
        width="140"
        label="发明人" show-overflow-tooltip>
      </el-table-column>
     <!--  <el-table-column
        prop="address"
        header-align="center"
        align="center"
        label="地址">
      </el-table-column> -->
      <!-- <el-table-column
        prop="summary"
        header-align="center"
        align="center"
        label="专利摘要">
      </el-table-column> -->
      <el-table-column
        prop="applicant"
        header-align="center"
        align="center"
        label="申请者">
      </el-table-column>
      <el-table-column
        prop="patentNumber"
        header-align="center"
        align="center"
        width="160"
        label="专利号">
      </el-table-column>
      <el-table-column
        prop="applyDate"
        header-align="center"
        align="center"
        width="100"
        label="申请日期" :formatter="fmtDate">
      </el-table-column>
      <!-- <el-table-column
        prop="agentOrg"
        header-align="center"
        align="center"
        label="专利代理机构">
      </el-table-column> -->
      <!-- <el-table-column
        prop="pubNum"
        header-align="center"
        align="center"
        label="公开号">
      </el-table-column>
      <el-table-column
        prop="agent"
        header-align="center"
        align="center"
        label="代理人">
      </el-table-column> -->
      <!-- <el-table-column
        prop="pubDate"
        header-align="center"
        align="center"
        label="公开日期">
      </el-table-column>
      <el-table-column
        prop="intelPub"
        header-align="center"
        align="center"
        label="国际公布">
      </el-table-column>
      <el-table-column
        prop="intelApply"
        header-align="center"
        align="center"
        label="国际申请">
      </el-table-column>
      <el-table-column
        prop="intoChinaDate"
        header-align="center"
        align="center"
        label="进入国家日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column> -->
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
  import AddOrUpdate from './rpttcxypatentbase-add-or-update'
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
          url: this.$http.adornUrl('/spider/rpttcxypatentbase/list'),
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
            url: this.$http.adornUrl('/spider/rpttcxypatentbase/delete'),
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
      formatDate (value) {
        if (value) {
          return value.split(' ')[0]
        } else {
          return value
        }
      },
      fmtDate (row, col, value, index) {
        return this.formatDate(value)
      }
    }
  }
</script>
