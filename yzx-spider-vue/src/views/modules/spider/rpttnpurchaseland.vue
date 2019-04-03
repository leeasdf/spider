<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rpttnpurchaseland:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rpttnpurchaseland:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
            <el-form-item label="上级公司"><span>{{props.row.parentCompany}}</span></el-form-item>
            <el-form-item label="供应方式"><span>{{props.row.supplyWay}}</span></el-form-item>
            <el-form-item label="最小容积率"><span>{{props.row.minVolume}}</span></el-form-item>
            <el-form-item label="最大容积率"><span>{{props.row.maxVolume}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.plCreateTime}}</span></el-form-item>
            <el-form-item label="修改时间"><span>{{props.row.plUpdateTime}}</span></el-form-item>
            <el-form-item label="约定动工时间"><span>{{props.row.startTime}}</span></el-form-item>
            <el-form-item label="约定竣工时间"><span>{{props.row.endTime}}</span></el-form-item>
            <el-form-item label="链接地址"><span>{{props.row.linkUrl}}</span></el-form-item>
            <el-form-item label="土地用途"><span>{{props.row.purpose}}</span></el-form-item>
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
      <!-- <el-table-column
        prop="plId"
        header-align="center"
        align="center"
        label="购地ID">
      </el-table-column> -->
      <el-table-column
        prop="adminRegion"
        header-align="center"
        align="center"
        label="行政区">
      </el-table-column>
      <el-table-column
        prop="elecSupervisorNo"
        header-align="center"
        align="center"
        label="电子监管号">
      </el-table-column>
      <el-table-column
        prop="signedDate"
        header-align="center"
        align="center"
        width="100"
        label="签订日期">
      </el-table-column>
      <el-table-column
        prop="totalArea"
        header-align="center"
        align="center"
        label="供地总面积（公顷）">
      </el-table-column>
      <el-table-column
        prop="location"
        header-align="center"
        align="center"
        label="宗地位置">
      </el-table-column>
      <el-table-column
        prop="assignee"
        header-align="center"
        align="center"
        width="100"
        label="受让人">
      </el-table-column>
     <!--  <el-table-column
        prop="parentCompany"
        header-align="center"
        align="center"
        label="上级公司">
      </el-table-column> -->
      <!-- <el-table-column
        prop="purpose"
        header-align="center"
        align="center"
        label="土地用途">
      </el-table-column> -->
      <!-- <el-table-column
        prop="supplyWay"
        header-align="center"
        align="center"
        label="供应方式">
      </el-table-column>
      <el-table-column
        prop="minVolume"
        header-align="center"
        align="center"
        label="最小容积率">
      </el-table-column>
      <el-table-column
        prop="maxVolume"
        header-align="center"
        align="center"
        label="最大容积率">
      </el-table-column> -->
      <el-table-column
        prop="dealPrice"
        header-align="center"
        align="center"
        label="成交价款（万元）">
      </el-table-column>
      <!-- <el-table-column
        prop="startTime"
        header-align="center"
        align="center"
        label="约定动工时间">
      </el-table-column>
      <el-table-column
        prop="linkUrl"
        header-align="center"
        align="center"
        label="链接地址">
      </el-table-column>
      <el-table-column
        prop="endTime"
        header-align="center"
        align="center"
        label="约定竣工时间">
      </el-table-column> -->
     <!--  <el-table-column
        prop="plCreateTime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column>
      <el-table-column
        prop="plUpdateTime"
        header-align="center"
        align="center"
        label="修改时间">
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
  import AddOrUpdate from './rpttnpurchaseland-add-or-update'
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
          url: this.$http.adornUrl('/spider/rpttnpurchaseland/list'),
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
            url: this.$http.adornUrl('/spider/rpttnpurchaseland/delete'),
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
