<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:enthightechlandledger:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:enthightechlandledger:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
            <el-form-item label="原土地证号"><span>{{props.row.oldLandUseNumber}}</span></el-form-item>
            <el-form-item label="台账年份"><span>{{props.row.year}}</span></el-form-item>
            <el-form-item label="土地位置"><span>{{props.row.landAddress}}</span></el-form-item>
            <el-form-item label="宗地面积"><span>{{props.row.area}}</span></el-form-item>
            <el-form-item label="土地使用期限"><span>{{props.row.limitDate}}</span></el-form-item>
            <el-form-item label="联系方式"><span>{{props.row.contact}}</span></el-form-item>
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
        prop="id"
        header-align="center"
        align="center"
        label="">
      </el-table-column> -->
      <el-table-column
        prop="company"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="businessType"
        header-align="center"
        align="center"
        width="160"
        label="业务类型">
      </el-table-column>
      <el-table-column
        prop="landUseNumber"
        header-align="center"
        align="center"
        width="180"
        label="土地使用权证号">
      </el-table-column>
      <!-- <el-table-column
        prop="oldLandUseNumber"
        header-align="center"
        align="center"
        label="原土地证号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="landAddress"
        header-align="center"
        align="center"
        label="土地位置">
      </el-table-column>
      <el-table-column
        prop="area"
        header-align="center"
        align="center"
        label="宗地面积">
      </el-table-column> -->
      <el-table-column
        prop="landUse"
        header-align="center"
        align="center"
        width="140"
        label="土地用途" show-overflow-tooltip>
      </el-table-column>
      <el-table-column
        prop="landUseType"
        header-align="center"
        align="center"
        width="100"
        label="使用权类型">
      </el-table-column>
      <el-table-column
        prop="registerDate"
        header-align="center"
        align="center"
        width="110"
        label="登记审批日期">
      </el-table-column>
      <!-- <el-table-column
        prop="limitDate"
        header-align="center"
        align="center"
        label="土地使用期限">
      </el-table-column>
      <el-table-column
        prop="contact"
        header-align="center"
        align="center"
        label="联系方式">
      </el-table-column> -->
      <!-- <el-table-column
        prop="year"
        header-align="center"
        align="center"
        width="80"
        label="台账年份">
      </el-table-column> -->
      <!-- <el-table-column
        prop="memId"
        header-align="center"
        align="center"
        label="绑定mem_id">
      </el-table-column>
      <el-table-column
        prop="enterpriseId"
        header-align="center"
        align="center"
        label="企业ID"> -->
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
  import AddOrUpdate from './enthightechlandledger-add-or-update'
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
          url: this.$http.adornUrl('/spider/enthightechlandledger/list'),
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
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/spider/enthightechlandledger/delete'),
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
