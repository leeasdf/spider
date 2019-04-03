<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="dataForm.creCode" placeholder="统一信用代码" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="dataForm.regNo" placeholder="工商注册号" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="dataForm.orgCode" placeholder="组织机构代码" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="dataForm.ideNum" placeholder="纳税人识别号" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
      </el-form-item>
    </el-form>
    <el-row class="mb10">
        <el-col>
            <div class="pull-right">
                <el-button v-if="isAuth('spider:rpttnbasicinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
                <el-button v-if="isAuth('spider:rpttnbasicinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
            </div>
        </el-col>
    </el-row>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form label-position="left" inline class="yzx-table-expand">
            <el-form-item label="公司名称"><span>{{props.row.cmpName}}</span></el-form-item>
            <el-form-item label="企业类别"><span>{{props.row.entType}}</span></el-form-item>
            <el-form-item label="行业"><span>{{props.row.industryPhyName}}</span></el-form-item>
            <el-form-item label="法人"><span>{{props.row.legalPerson}}</span></el-form-item>
            <el-form-item label="注册资本"><span>{{props.row.regCap}}</span></el-form-item>
            <el-form-item label="企业状态"><span>{{props.row.status}}</span></el-form-item>
            <el-form-item label="登记机关"><span>{{props.row.regAuthority}}</span></el-form-item>
            <el-form-item label="修改时间"><span>{{props.row.updateTime}}</span></el-form-item>
            <el-form-item label="营业期限"><span>{{props.row.opePeriod}}</span></el-form-item>
            <el-form-item label="核准日期"><span>{{props.row.appDate}}</span></el-form-item>
            <el-form-item label="注册地址"><span>{{props.row.regAddress}}</span></el-form-item>
            <el-form-item label="英文名称"><span>{{props.row.engName}}</span></el-form-item>
            <el-form-item label="经营范围" class="yzx-table-rowspan"><span>{{props.row.busScope}}</span></el-form-item>
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
        prop="entName"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="regNo"
        header-align="center"
        align="center"
        label="工商注册号" width="140">
      </el-table-column>
      <el-table-column
        prop="ideNum"
        header-align="center"
        align="center"
        label="纳税人识别号" width="170">
      </el-table-column>
      <el-table-column
        prop="creCode"
        header-align="center"
        align="center"
        label="统一社会信用代码" width="170">
      </el-table-column>
      <el-table-column
        prop="orgCode"
        header-align="center"
        align="center"
        label="组织机构代码" width="110">
      </el-table-column>
      <el-table-column
        prop="regTime" 
        label="注册时间" 
        align="center" 
        width="100">
      </el-table-column>
      <el-table-column
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
  import AddOrUpdate from './rpttnbasicinfo-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          entNamea: '',
          entName: '',
          regNo: '',
          orgCode: '',
          creCode: '',
          ideNum: ''
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
          url: this.$http.adornUrl('/spider/rpttnbasicinfo/list'),
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
            url: this.$http.adornUrl('/spider/rpttnbasicinfo/delete'),
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
