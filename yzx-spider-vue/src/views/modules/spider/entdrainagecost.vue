<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:entdrainagecost:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:entdrainagecost:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
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
        prop="companyName"
        header-align="center"
        align="center"
        label="企业名称">
      </el-table-column>
      <el-table-column
        prop="source"
        header-align="center"
        align="center"
        label="来源" show-overflow-tooltip>
      </el-table-column>
      <el-table-column
        prop="drainageFlag"
        header-align="center"
        align="center"
        width="80"
        label="是否排污企业" :formatter="fmtDrainageFlag">
      </el-table-column>
      <!-- <el-table-column
        prop="serialNo"
        header-align="center"
        align="center"
        label="序号">
      </el-table-column> -->
      <el-table-column
        prop="levyInstitution"
        header-align="center"
        align="center"
        label="征收机构">
      </el-table-column>
      <el-table-column
        prop="billingAmount"
        header-align="center"
        align="center"
        width="100"
        label="开单金额(单位:元)">
      </el-table-column>
      <el-table-column
        prop="payinAmount"
        header-align="center"
        align="center"
        width="100"
        label="入库金额(单位:元)">
      </el-table-column>
      <el-table-column
        prop="parentInstitution"
        header-align="center"
        align="center"
        width="90"
        label="上级机构">
      </el-table-column>
      <el-table-column
        prop="type"
        header-align="center"
        align="center"
        width="80"
        label="企业状态类型" :formatter="fmtType">
      </el-table-column>
      <el-table-column
        prop="year"
        header-align="center"
        align="center"
        width="70"
        label="年份">
      </el-table-column>
      <el-table-column
        prop="quarter"
        header-align="center"
        align="center"
        width="70"
        label="季度">
      </el-table-column>
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
  import AddOrUpdate from './entdrainagecost-add-or-update'
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
          url: this.$http.adornUrl('/spider/entdrainagecost/list'),
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
            url: this.$http.adornUrl('/spider/entdrainagecost/delete'),
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
      fmtType (row, col, value, index) {
        let type = ''
        if (value === '0') {
          type = '正常'
        } else if (value === '1') {
          type = '政策性免征'
        } else if (value === '2') {
          type = '停产'
        } else if (value === '3') {
          type = '永久性停产'
        } else if (value === '4') {
          type = '关闭'
        } else if (value === '5') {
          type = '未正式投产'
        } else if (value === '6') {
          type = '零排放'
        } else if (value === '7') {
          type = '其他'
        }
        return type
      },
      fmtDrainageFlag (row, col, value, index) {
        return value === '1' ? '是' : '否'
      }
    }
  }
</script>
