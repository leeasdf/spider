<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:cssfgwtaxbasic:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:cssfgwtaxbasic:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form inline label-width="160px" class="yzx-table-expand">
            <el-form-item label="组织机构代码"><span>{{props.row.organizationcode}}</span></el-form-item>
            <el-form-item label="工商营业执照注册号"><span>{{props.row.businesslicense}}</span></el-form-item>
            <el-form-item label="税务登记证号（国）"><span>{{props.row.taxcode}}</span></el-form-item>
            <el-form-item label="法定代表人（负责人）"><span>{{props.row.legalrepresentative}}</span></el-form-item>
            <el-form-item label="定代表人身份证件号"><span>{{props.row.legalrepresentativeidcard}}</span></el-form-item>
            <el-form-item label="注册地址" class="yzx-table-rowspan"><span>{{props.row.registeraddress}}</span></el-form-item>
            <el-form-item label="经营地址（国）" class="yzx-table-rowspan"><span>{{props.row.businessaddress}}</span></el-form-item>
            <el-form-item label="经营方式" class="yzx-table-rowspan"><span>{{props.row.businessmode}}</span></el-form-item>
            <el-form-item label="电话"><span>{{props.row.contactphone}}</span></el-form-item>
            <el-form-item label="企业状态编码（国）"><span>{{props.row.taxstatecode}}</span></el-form-item>
            <el-form-item label="税务部门编码（国）"><span>{{props.row.taxdeptcode}}</span></el-form-item>
            <el-form-item label="税务登记日期（国）"><span>{{props.row.taxregisterdate}}</span></el-form-item>
            <el-form-item label="登记注册类型"><span>{{props.row.registertype}}</span></el-form-item>
            <el-form-item label="经营期限"><span>{{props.row.deadlineofbusiness}}</span></el-form-item>
            <el-form-item label="注册资本币种编码"><span>{{props.row.capitalcode}}</span></el-form-item>
            <el-form-item label="银行编码（国）"><span>{{props.row.taxbankcode}}</span></el-form-item>
            <el-form-item label="银行网点编码（国）"><span>{{props.row.taxbanknodecode}}</span></el-form-item>
            <el-form-item label="缴税银行帐号（国）"><span>{{props.row.taxbankcard}}</span></el-form-item>
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
        width="80"
        label="数据状态" :formatter="fmtIsInvalid">
      </el-table-column>
      <!-- <el-table-column
        prop="lastdate"
        header-align="center"
        align="center"
        label="数据最后修改时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="organizationcode"
        header-align="center"
        align="center"
        label="组织机构代码">
      </el-table-column> -->
      <el-table-column
        prop="corporationname"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="businesslicense"
        header-align="center"
        align="center"
        label="工商营业执照注册号">
      </el-table-column>
      <el-table-column
        prop="taxcode"
        header-align="center"
        align="center"
        width="150"
        label="税务登记证号（国）">
      </el-table-column>
      <el-table-column
        prop="legalrepresentative"
        header-align="center"
        align="center"
        width="100"
        label="法定代表人（负责人）">
      </el-table-column>
      <!-- <el-table-column
        prop="legalrepresentativeidcard"
        header-align="center"
        align="center"
        label="法定代表人（负责人）身份证件号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="registeraddress"
        header-align="center"
        align="center"
        label="注册地址">
      </el-table-column>
      <el-table-column
        prop="businessaddress"
        header-align="center"
        align="center"
        label="经营地址（国）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="businessmode"
        header-align="center"
        align="center"
        label="经营方式">
      </el-table-column> -->
      <!-- <el-table-column
        prop="contactphone"
        header-align="center"
        align="center"
        label="电话">
      </el-table-column>
      <el-table-column
        prop="taxstatecode"
        header-align="center"
        align="center"
        label="企业状态编码（国）">
      </el-table-column>
      <el-table-column
        prop="taxdeptcode"
        header-align="center"
        align="center"
        label="税务部门编码（国）">
      </el-table-column> -->
      <el-table-column
        prop="issuedate"
        header-align="center"
        align="center"
        width="100"
        label="发证日期">
      </el-table-column>
      <el-table-column
        prop="taxregisterdate"
        header-align="center"
        align="center"
        width="100"
        label="税务登记日期（国）">
      </el-table-column>
      <!-- <el-table-column
        prop="registertype"
        header-align="center"
        align="center"
        label="登记注册类型">
      </el-table-column> -->
      <!-- <el-table-column
        prop="deadlineofbusiness"
        header-align="center"
        align="center"
        label="经营期限">
      </el-table-column> -->
      <el-table-column
        prop="capital"
        header-align="center"
        align="center"
        width="100"
        label="注册资本">
      </el-table-column>
      <!-- <el-table-column
        prop="capitalcode"
        header-align="center"
        align="center"
        label="注册资本币种编码">
      </el-table-column> -->
     <!--  <el-table-column
        prop="taxbankcode"
        header-align="center"
        align="center"
        label="银行编码（国）">
      </el-table-column>
      <el-table-column
        prop="taxbanknodecode"
        header-align="center"
        align="center"
        label="银行网点编码（国）">
      </el-table-column> -->
      <!-- <el-table-column
        prop="taxbankcard"
        header-align="center"
        align="center"
        label="缴税银行帐号（国）">
      </el-table-column> -->
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
  import AddOrUpdate from './cssfgwtaxbasic-add-or-update'
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
          url: this.$http.adornUrl('/spider/cssfgwtaxbasic/list'),
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
            url: this.$http.adornUrl('/spider/cssfgwtaxbasic/delete'),
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
