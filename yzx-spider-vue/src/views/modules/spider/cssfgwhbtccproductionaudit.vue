<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:cssfgwhbtccproductionaudit:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:cssfgwhbtccproductionaudit:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
            <el-form-item label="组织机构代码"><span>{{props.row.organizationcode}}</span></el-form-item>
            <el-form-item label="注册所在地"><span>{{props.row.placeofregistration}}</span></el-form-item>
            <el-form-item label="企业性质"><span>{{props.row.nature}}</span></el-form-item>
            <el-form-item label="所属行业"><span>{{props.row.industry}}</span></el-form-item>
            <el-form-item label="名单发布机关"><span>{{props.row.releasemechanism}}</span></el-form-item>
            <el-form-item label="名单发布日期"><span>{{props.row.releasedate}}</span></el-form-item>
            <el-form-item label="文号"><span>{{props.row.documentnumber}}</span></el-form-item>
            <el-form-item label="提交审核报告时间"><span>{{props.row.auditdate}}</span></el-form-item>
            <el-form-item label="完成验收时间"><span>{{props.row.completedacceptancetime}}</span></el-form-item>
            <el-form-item label="完成评估时间"><span>{{props.row.finishtime}}</span></el-form-item>
            <el-form-item label=""><span></span></el-form-item>
            <el-form-item label=""><span></span></el-form-item>
            <el-form-item label=""><span></span></el-form-item>
            <el-form-item label=""><span></span></el-form-item>
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
        prop="isinvalid"
        header-align="center"
        align="center"
        width="90"
        label="数据状态" :formatter="fmtIsInvalid">
      </el-table-column>
      <!-- <el-table-column
        prop="lastdate"
        header-align="center"
        align="center"
        label="数据最后修改时间">
      </el-table-column> -->
      <el-table-column
        prop="corporationname"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
     <!--  <el-table-column
        prop="organizationcode"
        header-align="center"
        align="center"
        label="组织机构代码">
      </el-table-column>
      <el-table-column
        prop="placeofregistration"
        header-align="center"
        align="center"
        label="注册所在地">
      </el-table-column>
      <el-table-column
        prop="nature"
        header-align="center"
        align="center"
        label="企业性质">
      </el-table-column>
      <el-table-column
        prop="industry"
        header-align="center"
        align="center"
        label="所属行业">
      </el-table-column> -->
      <!-- <el-table-column
        prop="releasemechanism"
        header-align="center"
        align="center"
        label="名单发布机关">
      </el-table-column>
      <el-table-column
        prop="releasedate"
        header-align="center"
        align="center"
        label="名单发布日期">
      </el-table-column>
      <el-table-column
        prop="documentnumber"
        header-align="center"
        align="center"
        label="文号">
      </el-table-column> -->
      <el-table-column
        prop="executiontimelimit"
        header-align="center"
        align="center"
        label="强制执行时限">
      </el-table-column>
     <!--  <el-table-column
        prop="auditdate"
        header-align="center"
        align="center"
        label="提交审核报告时间">
      </el-table-column>
      <el-table-column
        prop="completedacceptancetime"
        header-align="center"
        align="center"
        label="完成验收时间">
      </el-table-column>
      <el-table-column
        prop="finishtime"
        header-align="center"
        align="center"
        label="完成评估时间">
      </el-table-column> -->
      <el-table-column
        prop="auditorganizationname"
        header-align="center"
        align="center"
        label="审核机构名称">
      </el-table-column>
      <el-table-column
        prop="acceptanceproofmaterial"
        header-align="center"
        align="center"
        label="验收证明材料">
      </el-table-column>
      <el-table-column
        prop="productionaudit"
        header-align="center"
        align="center"
        width="120"
        label="最近一轮清洁生产审核时段">
      </el-table-column>
      <el-table-column
        prop="praccetime"
        header-align="center"
        align="center"
        width="100"
        label="上轮清洁生产验收时间">
      </el-table-column>
      <!-- <el-table-column
        prop="zjid"
        header-align="center"
        align="center"
        label="主键">
      </el-table-column> -->
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="100"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.zjid)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.zjid)">删除</el-button>
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
  import AddOrUpdate from './cssfgwhbtccproductionaudit-add-or-update'
  import { formatIsInvalid } from '@/utils/dataFormat'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
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
          url: this.$http.adornUrl('/spider/cssfgwhbtccproductionaudit/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
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
          return item.zjid
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/spider/cssfgwhbtccproductionaudit/delete'),
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
      fmtIsInvalid (row, col, value, index) {
        return formatIsInvalid(value)
      }
    }
  }
</script>
