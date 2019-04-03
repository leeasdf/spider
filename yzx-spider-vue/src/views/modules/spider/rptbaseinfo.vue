<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rptbaseinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rptbaseinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form inline label-width="130px" class="yzx-table-expand">
            <el-form-item label="经营状态"><span>{{props.row.entstatus}}</span></el-form-item>
            <el-form-item label="企业(机构)类型"><span>{{props.row.enttype}}</span></el-form-item>
            <el-form-item label="开业日期"><span>{{props.row.esdate}}</span></el-form-item>
            <el-form-item label="经营期限自"><span>{{props.row.opfrom}}</span></el-form-item>
            <el-form-item label="经营期限至"><span>{{props.row.opto}}</span></el-form-item>
            <el-form-item label="登记机关"><span>{{props.row.regorg}}</span></el-form-item>
            <el-form-item label="最后年检年度"><span>{{props.row.ancheyear}}</span></el-form-item>
            <el-form-item label="变更日期"><span>{{props.row.changedate}}</span></el-form-item>
            <el-form-item label="注销日期"><span>{{props.row.candate}}</span></el-form-item>
            <el-form-item label="吊销日期"><span>{{props.row.revdate}}</span></el-form-item>
            <el-form-item label="最后年检日期"><span>{{props.row.anchedate}}</span></el-form-item>
            <el-form-item label="行业门类代码"><span>{{props.row.industryphycode}}</span></el-form-item>
            <el-form-item label="行业门类名称"><span>{{props.row.industryphyname}}</span></el-form-item>
            <el-form-item label="国民经济行业代码"><span>{{props.row.industrycocode}}</span></el-form-item>
            <el-form-item label="国民经济行业名称"><span>{{props.row.industryconame}}</span></el-form-item>
            <el-form-item label="原注册号"><span>{{props.row.oriregno}}</span></el-form-item>
            <el-form-item label="住址" class="yzx-table-rowspan"><span>{{props.row.dom}}</span></el-form-item>
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
        prop="memId"
        header-align="center"
        align="center"
        label="会员ID">
      </el-table-column>
      <el-table-column
        prop="enterpriseId"
        header-align="center"
        align="center"
        label="企业ID">
      </el-table-column> -->
      <el-table-column
        prop="entname"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="regno"
        header-align="center"
        align="center"
        width="140"
        label="注册号">
      </el-table-column>
      <!-- <el-table-column
        prop="oriregno"
        header-align="center"
        align="center"
        label="原注册号">
      </el-table-column> -->
      <el-table-column
        prop="frname"
        header-align="center"
        align="center"
        width="120"
        label="法定代表人姓名">
      </el-table-column>
      <el-table-column
        prop="regcap"
        header-align="center"
        align="center"
        width="120"
        label="">
      </el-table-column>
      <el-table-column
        prop="reccap"
        header-align="center"
        align="center"
        width="120"
        label="">
      </el-table-column>
      <el-table-column
        prop="regcapcur"
        header-align="center"
        align="center"
        width="90"
        label="币种">
      </el-table-column>
      <!-- <el-table-column
        prop="entstatus"
        header-align="center"
        align="center"
        label="经营状态">
      </el-table-column>
      <el-table-column
        prop="enttype"
        header-align="center"
        align="center"
        label="企业(机构)类型">
      </el-table-column>
      <el-table-column
        prop="esdate"
        header-align="center"
        align="center"
        label="开业日期">
      </el-table-column>
      <el-table-column
        prop="opfrom"
        header-align="center"
        align="center"
        label="经营期限自">
      </el-table-column>
      <el-table-column
        prop="opto"
        header-align="center"
        align="center"
        label="经营期限至">
      </el-table-column>
      <el-table-column
        prop="dom"
        header-align="center"
        align="center"
        label="住址">
      </el-table-column>
      <el-table-column
        prop="regorg"
        header-align="center"
        align="center"
        label="登记机关">
      </el-table-column>
      <el-table-column
        prop="abuitem"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="cbuitem"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="opscope"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="opscoandform"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="ancheyear"
        header-align="center"
        align="center"
        label="最后年检年度">
      </el-table-column>
      <el-table-column
        prop="changedate"
        header-align="center"
        align="center"
        label="变更日期">
      </el-table-column>
      <el-table-column
        prop="candate"
        header-align="center"
        align="center"
        label="注销日期">
      </el-table-column>
      <el-table-column
        prop="revdate"
        header-align="center"
        align="center"
        label="吊销日期">
      </el-table-column>
      <el-table-column
        prop="anchedate"
        header-align="center"
        align="center"
        label="最后年检日期">
      </el-table-column>
      <el-table-column
        prop="industryphycode"
        header-align="center"
        align="center"
        label="行业门类代码">
      </el-table-column>
      <el-table-column
        prop="industryphyname"
        header-align="center"
        align="center"
        label="行业门类名称">
      </el-table-column>
      <el-table-column
        prop="industrycocode"
        header-align="center"
        align="center"
        label="国民经济行业代码">
      </el-table-column>
      <el-table-column
        prop="industryconame"
        header-align="center"
        align="center"
        label="国民经济行业名称">
      </el-table-column> -->
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        width="100"
        label="创建时间">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="120"
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
  import AddOrUpdate from './rptbaseinfo-add-or-update'
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
          url: this.$http.adornUrl('/spider/rptbaseinfo/list'),
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
            url: this.$http.adornUrl('/spider/rptbaseinfo/delete'),
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
