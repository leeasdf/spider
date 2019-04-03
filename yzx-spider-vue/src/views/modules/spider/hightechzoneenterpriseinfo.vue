<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.enterpriseName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:hightechzoneenterpriseinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:hightechzoneenterpriseinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form label-width="140px" inline class="yzx-table-expand">
            <el-form-item label="营业执照号"><span>{{props.row.businessLicenseNo}}</span></el-form-item>
            <el-form-item label="税号"><span>{{props.row.taxNo}}</span></el-form-item>
            <el-form-item label="统一社会信用代码"><span>{{props.row.creditCode}}</span></el-form-item>
            <el-form-item label="行业归属"><span>{{fmtIndustryType(props.row.industryType)}}</span></el-form-item>
            <el-form-item label="注册日期"><span>{{props.row.esDate}}</span></el-form-item>
            <el-form-item label="注册资本"><span>{{props.row.regCap}}</span></el-form-item>
            <el-form-item label="入园时间"><span>{{props.row.entryDate}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
            <el-form-item label="更新时间"><span>{{props.row.updateTime}}</span></el-form-item>
            <el-form-item label="省份"><span>{{props.row.province}}</span></el-form-item>
            <el-form-item label="城市"><span>{{props.row.city}}</span></el-form-item>
            <el-form-item label="官网网址"><span>{{props.row.webSite}}</span></el-form-item>
            <el-form-item label="地址"><span>{{props.row.address}}</span></el-form-item>
            <el-form-item label="联系电话列表"><span>{{props.row.phones}}</span></el-form-item>
            <el-form-item label="邮箱"><span>{{props.row.email}}</span></el-form-item>
            <el-form-item label="简介"><span>{{props.row.content}}</span></el-form-item>
            <el-form-item label="renameFlag"><span>{{props.row.renameFlag}}</span></el-form-item>
            <el-form-item label="历史名称"><span>{{props.row.oldName}}</span></el-form-item>
            <el-form-item label="备注"><span>{{props.row.remark}}</span></el-form-item>
            <el-form-item label="出资时间"><span>{{props.row.tycUpdateTime}}</span></el-form-item>
            <!--<el-form-item label="天眼查得分"><span>{{props.row.score}}</span></el-form-item> -->
            <el-form-item label="标签列表"><span>{{props.row.tagList}}</span></el-form-item>
            <el-form-item label="曾用名列表"><span>{{props.row.historyList}}</span></el-form-item>
            <el-form-item label="新企业名称"><span>{{props.row.newName}}</span></el-form-item>
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
      </el-table-column>
      <el-table-column
        prop="taxNo"
        header-align="center"
        align="center"
        label="税号">
      </el-table-column> -->
     <!--  <el-table-column
        prop="esDate"
        header-align="center"
        align="center"
        label="注册日期">
      </el-table-column>
      <el-table-column
        prop="regCap"
        header-align="center"
        align="center"
        label="注册资本">
      </el-table-column> -->
      <!-- <el-table-column
        prop="entryDate"
        header-align="center"
        align="center"
        label="入园时间">
      </el-table-column>
      <el-table-column
        prop="createtime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column> -->
      <!-- <el-table-column
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
      </el-table-column> -->
      <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        width="80"
        label="数据状态" :formatter="fmtDataState">
      </el-table-column>
      <!-- <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="更新时间">
      </el-table-column> -->
     <!--  <el-table-column
        prop="province"
        header-align="center"
        align="center"
        label="省份">
      </el-table-column>
      <el-table-column
        prop="city"
        header-align="center"
        align="center"
        label="城市">
      </el-table-column> -->
      <el-table-column
        prop="regTime"
        header-align="center"
        align="center"
        width="100"
        label="注册时间">
      </el-table-column>
     <!--  <el-table-column
        prop="tycEnterpriseid"
        header-align="center"
        align="center"
        label="天眼查企业ID">
      </el-table-column> -->
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        width="80"
        label="企业状态">
      </el-table-column>
      <el-table-column
        prop="dataSource"
        header-align="center"
        align="center"
        width="80"
        label="数据来源">
      </el-table-column>
     <!--  <el-table-column
        prop="webSite"
        header-align="center"
        align="center"
        label="官网网址">
      </el-table-column> -->
      <!-- <el-table-column
        prop="address"
        header-align="center"
        align="center"
        label="地址">
      </el-table-column>
      <el-table-column
        prop="phones"
        header-align="center"
        align="center"
        label="联系电话列表">
      </el-table-column>
      <el-table-column
        prop="email"
        header-align="center"
        align="center"
        label="邮箱">
      </el-table-column>
      <el-table-column
        prop="content"
        header-align="center"
        align="center"
        label="简介">
      </el-table-column> -->
      <el-table-column
        prop="legalPersonName"
        header-align="center"
        align="center"
        width="140"
        label="企业法人">
      </el-table-column>
      <!-- <el-table-column
        prop="renameFlag"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="oldName"
        header-align="center"
        align="center"
        label="历史名称">
      </el-table-column> -->
      <!-- <el-table-column
        prop="remark"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column>
      <el-table-column
        prop="tycUpdateTime"
        header-align="center"
        align="center"
        label="出资时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="score"
        header-align="center"
        align="center"
        label="天眼查得分">
      </el-table-column>
      <el-table-column
        prop="version"
        header-align="center"
        align="center"
        label="版本号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="oldEnterpriseId"
        header-align="center"
        align="center"
        label="旧企业ID">
      </el-table-column> -->
      <!-- <el-table-column
        prop="newName"
        header-align="center"
        align="center"
        label="新企业名称">
      </el-table-column> -->
      <!-- <el-table-column
        prop="newEnterpriseId"
        header-align="center"
        align="center"
        label="新企业ID">
      </el-table-column> -->
      <!-- <el-table-column
        prop="tagList"
        header-align="center"
        align="center"
        label="标签列表">
      </el-table-column>
      <el-table-column
        prop="historyList"
        header-align="center"
        align="center"
        label="曾用名列表">
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
  import AddOrUpdate from './hightechzoneenterpriseinfo-add-or-update'
  import { formatIndustryType, formatDataState } from '@/utils/dataFormat'
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
          url: this.$http.adornUrl('/spider/hightechzoneenterpriseinfo/list'),
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
            url: this.$http.adornUrl('/spider/hightechzoneenterpriseinfo/delete'),
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
      fmtIndustryType (value) {
        return formatIndustryType(value)
      },
      fmtDataState (row, col, value, index) {
        return formatDataState(value)
      }
    }
  }
</script>
