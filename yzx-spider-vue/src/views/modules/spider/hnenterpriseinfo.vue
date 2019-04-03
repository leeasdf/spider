<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.enterpriseName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:hnenterpriseinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:hnenterpriseinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
            <el-form-item label="营业执照号"><span>{{props.row.businessLicenseNo}}</span></el-form-item>
            <el-form-item label="税号"><span>{{props.row.taxNo}}</span></el-form-item>
            <el-form-item label="入园时间"><span>{{props.row.entrydate}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createtime}}</span></el-form-item>
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
        prop="enterpriseName"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="organizationCode"
        header-align="center"
        align="center"
        label="组织机构编码">
      </el-table-column>
      <!-- <el-table-column
        prop="businessLicenseNo"
        header-align="center"
        align="center"
        label="营业执照号">
      </el-table-column> -->
     <!--  <el-table-column
        prop="taxNo"
        header-align="center"
        align="center"
        label="税号">
      </el-table-column> -->
      <el-table-column
        prop="esdate"
        header-align="center"
        align="center"
        width="100"
        label="注册日期">
      </el-table-column>
      <el-table-column
        prop="regcap"
        header-align="center"
        align="center"
        width="100"
        label="注册资本">
      </el-table-column>
      <!-- <el-table-column
        prop="entrydate"
        header-align="center"
        align="center"
        label="入园时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="createtime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column> -->
      <el-table-column
        prop="creditCode"
        header-align="center"
        align="center"
        label="统一社会信用代码">
      </el-table-column>
      <el-table-column
        prop="industryType"
        header-align="center"
        align="center"
        label="行业归属" :formatter="fmtIndustryType">
      </el-table-column>
      <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        width="90"
        label="数据状态" :formatter="fmtDataState">
      </el-table-column>
      <!-- <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="更新时间">
      </el-table-column> -->
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="90"
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
  import AddOrUpdate from './hnenterpriseinfo-add-or-update'
  import { formatDataState } from '@/utils/dataFormat'
  export default {
    data () {
      return {
        dataForm: {
          enterpriseName: ''
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
          url: this.$http.adornUrl('/spider/hnenterpriseinfo/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'enterpriseName': this.dataForm.enterpriseName
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
            url: this.$http.adornUrl('/spider/hnenterpriseinfo/delete'),
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
      },
      fmtIndustryType (row, col, value, index) {
        if (value === '1') {
          return '先进装备制造产业'
        } else if (value === '2') {
          return '电子信息及互联网应用产业'
        } else if (value === '3') {
          return '新材料产业'
        } else if (value === '4') {
          return '新能源与节能环保产业'
        } else if (value === '5') {
          return '生物医药与健康产业'
        } else if (value === '6') {
          return '现代服务业'
        } else if (value === '7') {
          return '其他'
        } else {
          return value
        }
      }
    }
  }
</script>
