<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:entchangshataxdefaultinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:entchangshataxdefaultinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form inline label-width="200px" class="yzx-table-expand">
            <el-form-item label="营业税-欠税余额"><span>{{props.row.saleTax}}</span></el-form-item>
            <el-form-item label="营业税-其中本年新欠"><span>{{props.row.saleTaxNew}}</span></el-form-item>
            <el-form-item label="房产税-欠税余额"><span>{{props.row.houseTax}}</span></el-form-item>
            <el-form-item label="房产税-其中本年新欠"><span>{{props.row.houseTaxNew}}</span></el-form-item>
            <el-form-item label="市维护建设税-欠税余额"><span>{{props.row.cityBuildTax}}</span></el-form-item>
            <el-form-item label="城市维护建设税-其中本年新欠"><span>{{props.row.cityBuildTaxNew}}</span></el-form-item>
            <el-form-item label="教育费附加-欠税余额"><span>{{props.row.educationTax}}</span></el-form-item>
            <el-form-item label="教育费附加-其中本年新欠"><span>{{props.row.educationTaxNew}}</span></el-form-item>
            <el-form-item label="耕地占用税-欠税余额"><span>{{props.row.farmLandOccupyTax}}</span></el-form-item>
            <el-form-item label="耕地占用税-其中本年新欠"><span>{{props.row.farmLandOccupyTaxNew}}</span></el-form-item>
            <el-form-item label="土地使用税-欠税余额"><span>{{props.row.landUseTax}}</span></el-form-item>
            <el-form-item label="土地使用税-其中本年新欠"><span>{{props.row.landUseTaxNew}}</span></el-form-item>
            <el-form-item label="土地增值税-欠税余额"><span>{{props.row.landValueAddTax}}</span></el-form-item>
            <el-form-item label="土地增值税-其中本年新欠"><span>{{props.row.landValueAddTaxNew}}</span></el-form-item>
            <el-form-item label="个人所得税-欠税余额"><span>{{props.row.personalIncomeTax}}</span></el-form-item>
            <el-form-item label="个人所得税-其中本年新欠"><span>{{props.row.personalIncomeTaxNew}}</span></el-form-item>
            <el-form-item label="企业所得税-欠税余额"><span>{{props.row.companyIncomeTax}}</span></el-form-item>
            <el-form-item label="企业所得税-其中本年新欠"><span>{{props.row.companyIncomeTaxNew}}</span></el-form-item>
            <el-form-item label="印花税-欠税余额"><span>{{props.row.printTax}}</span></el-form-item>
            <el-form-item label="印花税-其中本年新欠"><span>{{props.row.printTaxNew}}</span></el-form-item>
            <el-form-item label="车船税-欠税余额"><span>{{props.row.carShipTax}}</span></el-form-item>
            <el-form-item label="车船税-其中本年新欠"><span>{{props.row.carShipTaxNew}}</span></el-form-item>
            <el-form-item label="契税-欠税余额"><span>{{props.row.contractTax}}</span></el-form-item>
            <el-form-item label="契税-其中本年新欠"><span>{{props.row.contractTaxNew}}</span></el-form-item>
            <el-form-item label="资源税-欠税余额"><span>{{props.row.resourceTax}}</span></el-form-item>
            <el-form-item label="资源税-其中本年新欠"><span>{{props.row.resourceTaxNew}}</span></el-form-item>
            <el-form-item label="时间戳"><span>{{props.row.defaultDate}}</span></el-form-item>
            <el-form-item label="经营地址" class="yzx-table-rowspan"><span>{{props.row.companyAddress}}</span></el-form-item>
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
        prop="taxDefaultInfoId"
        header-align="center"
        align="center"
        label="主键">
      </el-table-column> -->
      <el-table-column
        prop="company"
        header-align="center"
        align="center"
        label="纳税人名称">
      </el-table-column>
      <el-table-column
        prop="taxpayerId"
        header-align="center"
        align="center"
        label="纳税人识别号">
      </el-table-column>
      <el-table-column
        prop="legalPersonName"
        header-align="center"
        align="center"
        width="100"
        label="法人（业主）姓名">
      </el-table-column>
      <el-table-column
        prop="legalPersonId"
        header-align="center"
        align="center"
        label="法人（业主）身份证号">
      </el-table-column>
     <!--  <el-table-column
        prop="companyAddress"
        header-align="center"
        align="center"
        label="经营地址">
      </el-table-column>
      <el-table-column
        prop="saleTax"
        header-align="center"
        align="center"
        label="营业税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="saleTaxNew"
        header-align="center"
        align="center"
        label="营业税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="houseTax"
        header-align="center"
        align="center"
        label="房产税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="houseTaxNew"
        header-align="center"
        align="center"
        label="房产税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="cityBuildTax"
        header-align="center"
        align="center"
        label="城市维护建设税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="cityBuildTaxNew"
        header-align="center"
        align="center"
        label="城市维护建设税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="educationTax"
        header-align="center"
        align="center"
        label="教育费附加-欠税余额">
      </el-table-column>
      <el-table-column
        prop="educationTaxNew"
        header-align="center"
        align="center"
        label="教育费附加-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="farmLandOccupyTax"
        header-align="center"
        align="center"
        label="耕地占用税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="farmLandOccupyTaxNew"
        header-align="center"
        align="center"
        label="耕地占用税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="landUseTax"
        header-align="center"
        align="center"
        label="土地使用税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="landUseTaxNew"
        header-align="center"
        align="center"
        label="土地使用税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="landValueAddTax"
        header-align="center"
        align="center"
        label="土地增值税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="landValueAddTaxNew"
        header-align="center"
        align="center"
        label="土地增值税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="personalIncomeTax"
        header-align="center"
        align="center"
        label="个人所得税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="personalIncomeTaxNew"
        header-align="center"
        align="center"
        label="个人所得税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="companyIncomeTax"
        header-align="center"
        align="center"
        label="企业所得税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="companyIncomeTaxNew"
        header-align="center"
        align="center"
        label="企业所得税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="printTax"
        header-align="center"
        align="center"
        label="印花税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="printTaxNew"
        header-align="center"
        align="center"
        label="印花税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="carShipTax"
        header-align="center"
        align="center"
        label="车船税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="carShipTaxNew"
        header-align="center"
        align="center"
        label="车船税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="contractTax"
        header-align="center"
        align="center"
        label="契税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="contractTaxNew"
        header-align="center"
        align="center"
        label="契税-其中本年新欠">
      </el-table-column>
      <el-table-column
        prop="resourceTax"
        header-align="center"
        align="center"
        label="资源税-欠税余额">
      </el-table-column>
      <el-table-column
        prop="resourceTaxNew"
        header-align="center"
        align="center"
        label="资源税-其中本年新欠">
      </el-table-column> -->
      <el-table-column
        prop="totalTax"
        header-align="center"
        align="center"
        width="120"
        label="合计-欠税余额">
      </el-table-column>
      <el-table-column
        prop="totalTaxNew"
        header-align="center"
        align="center"
        width="100"
        label="合计-其中本年新欠">
      </el-table-column>
      <!-- <el-table-column
        prop="defaultDate"
        header-align="center"
        align="center"
        label="时间戳">
      </el-table-column> -->
      <!-- <el-table-column
        prop="memId"
        header-align="center"
        align="center"
        label="会员ID">
      </el-table-column> -->
      
      <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        width="100"
        label="数据状态" :formatter="fmtDataState">
      </el-table-column>
      <!-- <el-table-column
        prop="enterpriseId"
        header-align="center"
        align="center"
        label="企业ID">
      </el-table-column> -->
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="100"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.taxDefaultInfoId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.taxDefaultInfoId)">删除</el-button>
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
  import AddOrUpdate from './entchangshataxdefaultinfo-add-or-update'
  import { formatDataState } from '@/utils/dataFormat'
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
          url: this.$http.adornUrl('/spider/entchangshataxdefaultinfo/list'),
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
          return item.taxDefaultInfoId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/spider/entchangshataxdefaultinfo/delete'),
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
