<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.nsrmc" placeholder="纳税人名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:cssfgwtaxinformation:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:cssfgwtaxinformation:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
            <el-form-item label="纳税识别号"><span>{{props.row.nssbh}}</span></el-form-item>
            <el-form-item label="经营地址"><span>{{props.row.jydz}}</span></el-form-item>
            <el-form-item label="标题" class="yzx-table-rowspan"><span>{{props.row.bt}}</span></el-form-item>
            <el-form-item label="内容" class="yzx-table-rowspan"><span>{{props.row.nr}}</span></el-form-item>
            
            
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
     <!--  <el-table-column
        prop="lastdate"
        header-align="center"
        align="center"
        label="数据最后修改时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="bt"
        header-align="center"
        align="center"
        label="标题">
      </el-table-column> -->
      <el-table-column
        prop="nsrmc"
        header-align="center"
        align="center"
        label="纳税人名称">
      </el-table-column>
      <!-- <el-table-column
        prop="nssbh"
        header-align="center"
        align="center"
        label="纳税识别号">
      </el-table-column> -->
      <el-table-column
        prop="fddbr"
        header-align="center"
        align="center"
        width="100"
        label="法定代表人">
      </el-table-column>
      <el-table-column
        prop="sfzhm"
        header-align="center"
        align="center"
        label="身份证号码">
      </el-table-column>
      <!-- <el-table-column
        prop="jydz"
        header-align="center"
        align="center"
        label="经营地址">
      </el-table-column> -->
      <el-table-column
        prop="qssz"
        header-align="center"
        align="center"
        width="90"
        label="欠税税种">
      </el-table-column>
      <el-table-column
        prop="qsye"
        header-align="center"
        align="center"
        width="110"
        label="欠税余额">
      </el-table-column>
      <el-table-column
        prop="bnxfsqk"
        header-align="center"
        align="center"
        width="120"
        label="本年新发生欠款">
      </el-table-column>
      <!-- <el-table-column
        prop="nr"
        header-align="center"
        align="center"
        label="内容">
      </el-table-column> -->
      <el-table-column
        prop="sj"
        header-align="center"
        align="center"
        width="100"
        label="时间">
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
        width="90"
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
  import AddOrUpdate from './cssfgwtaxinformation-add-or-update'
  import { formatIsInvalid } from '@/utils/dataFormat'
  export default {
    data () {
      return {
        dataForm: {
          nsrmc: ''
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
          url: this.$http.adornUrl('/spider/cssfgwtaxinformation/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'nsrmc': this.dataForm.nsrmc
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
            url: this.$http.adornUrl('/spider/cssfgwtaxinformation/delete'),
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
