<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.taxpayer" placeholder="纳税人名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="dataForm.taxpayerNo" placeholder="纳税人识别号" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-date-picker type="year" v-model="dataForm.year" placeholder="评价年度" value-format="yyyy"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('dataparser:credithunantaxa:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('dataparser:credithunantaxa:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">

      <el-table-column type="expand" width="40">
        <template slot-scope="props">
          <el-form label-width="100px" inline class="yzx-table-expand">
            <el-form-item label="组织机构代码"><span>{{props.row.orgCode}}</span></el-form-item>
            <el-form-item label="负责人"><span>{{props.row.responsiblePerson}}</span></el-form-item>
            <el-form-item label="主管税务机关" ><span>{{props.row.taxAuthorities}}</span></el-form-item>
            <el-form-item label="资源更新时间"><span>{{props.row.sourceTime}}</span></el-form-item>
            <el-form-item label="税务更新时间"><span>{{props.row.taxUpdateTime}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
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
        prop="taxpayer"
        header-align="center"
        align="center"
        label="纳税人名称">
      </el-table-column>
      <el-table-column
        prop="taxpayerNo"
        header-align="center"
        align="center"
        width="160"
        label="纳税人识别号">
      </el-table-column>

      <el-table-column
        prop="creditLevel"
        header-align="center"
        align="center"
        width="80"
        label="信用等级">
      </el-table-column>
      <el-table-column
        prop="year"
        header-align="center"
        align="center"
        width="80"
        label="评价年度">
      </el-table-column>
      <el-table-column
        prop="infomationName"
        header-align="center"
        align="center"
        label="信息名称">
      </el-table-column>
      <el-table-column
        prop="source"
        header-align="center"
        align="center"
        width="90"
        label="数据来源">
      </el-table-column>
      <el-table-column
        prop="infomationType"
        header-align="center"
        align="center"
        width="100"
        label="信息类型">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="160"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
          <el-button type="text" size="small" @click="updateHandle(scope.row.taxpayer,scope.row.taxType)">重新获取</el-button>
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
  import AddOrUpdate from './credithunantaxa-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          taxpayer: '',
          taxpayerNo: '',
          year: ''
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
          url: this.$http.adornUrl('/dataparser/credithunantaxa/list'),
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
            url: this.$http.adornUrl('/dataparser/credithunantaxa/delete'),
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
      // 重新获取 人工重试
      updateHandle (entName, taxtype) {
        this.$confirm(`确定对[企业:${entName}]进行重新获取]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/dataparser/credithunantaxa/reset'),
            method: 'post',
            params: this.$http.adornParams({entName: entName, taxtype: taxtype})
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
