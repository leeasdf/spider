<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:cssfgwhbtsjzxgxxzcf:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:cssfgwhbtsjzxgxxzcf:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form inline label-width="140px" class="yzx-table-expand">
            <el-form-item label="污染源编号"><span>{{props.row.wrybh}}</span></el-form-item>
            <el-form-item label="立案号"><span>{{props.row.lah}}</span></el-form-item>
            <el-form-item label="决定书文号"><span>{{props.row.jdswh}}</span></el-form-item>
            <el-form-item label="案情简介"><span>{{props.row.aqjj}}</span></el-form-item>
            <el-form-item label="主要违法行为" class="yzx-table-rowspan"><span>{{props.row.zywfxw}}</span></el-form-item>
            <el-form-item label="处罚依据" class="yzx-table-rowspan"><span>{{props.row.cfyj}}</span></el-form-item>
            <el-form-item label="处罚主体" class="yzx-table-rowspan"><span>{{props.row.cfzt}}</span></el-form-item>
            <el-form-item label="处罚种类"><span>{{props.row.cfzl}}</span></el-form-item>
            <el-form-item label="罚款数额（万元）"><span>{{props.row.fkse}}</span></el-form-item>
            <el-form-item label="行政命令种类"><span>{{props.row.xzmlzl}}</span></el-form-item>
            <el-form-item label="是否举行听证"><span>{{props.row.sfjxtz}}</span></el-form-item>
            <el-form-item label="决定下达日期"><span>{{props.row.jdxdrq}}</span></el-form-item>
            <el-form-item label="决定书内容"><span>{{props.row.jdsnr}}</span></el-form-item>
            <el-form-item label="执行情况"><span>{{props.row.zxqk}}</span></el-form-item>
            <el-form-item label="执行完毕日期"><span>{{props.row.zxwbrq}}</span></el-form-item>
            <el-form-item label="复议结果"><span>{{props.row.fyjg}}</span></el-form-item>
            <el-form-item label="诉讼结果"><span>{{props.row.ssjg}}</span></el-form-item>
            <el-form-item label="移送信息"><span>{{props.row.ysxx}}</span></el-form-item>
            <el-form-item label="案卷号"><span>{{props.row.ajh}}</span></el-form-item>
            <el-form-item label="备注"><span>{{props.row.bz}}</span></el-form-item>
            <el-form-item label="数据来源"><span>{{props.row.sjly}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.cjsj}}</span></el-form-item>
            <el-form-item label="作出决定的相关材料"><span>{{props.row.zcjdxgcl}}</span></el-form-item>
            <el-form-item label="违法案件类型"><span>{{props.row.wfajlx}}</span></el-form-item>
            <el-form-item label="是否已结案"><span>{{fmtYesORNo(props.row.sfja)}}</span></el-form-item>
            <el-form-item label="结案日期"><span>{{props.row.jarq}}</span></el-form-item>
            <el-form-item label="是否已交换"><span>{{fmtYesORNo(props.row.sfyjh)}}</span></el-form-item>
            <el-form-item label="审核状态"><span>{{props.row.shzt}}</span></el-form-item>
            <el-form-item label="状态"><span>{{fmtZT(props.row.zt)}}</span></el-form-item>
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
        prop="xh"
        header-align="center"
        align="center"
        label="序号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="wrybh"
        header-align="center"
        align="center"
        label="污染源编号">
      </el-table-column> -->
      <el-table-column
        prop="wrymc"
        header-align="center"
        align="center"
        label="污染源名称">
      </el-table-column>
      <el-table-column
        prop="nd"
        header-align="center"
        align="center"
        width="80"
        label="年度">
      </el-table-column>
      <!-- <el-table-column
        prop="cfzt"
        header-align="center"
        align="center"
        label="处罚主体">
      </el-table-column> -->
      <el-table-column
        prop="dcjg"
        header-align="center"
        align="center"
        label="调查机构">
      </el-table-column>
      <!-- <el-table-column
        prop="lah"
        header-align="center"
        align="center"
        label="立案号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="jdswh"
        header-align="center"
        align="center"
        label="决定书文号">
      </el-table-column> -->
      <el-table-column
        prop="larq"
        header-align="center"
        align="center"
        width="100"
        label="立案日期">
      </el-table-column>
      <!-- <el-table-column
        prop="aqjj"
        header-align="center"
        align="center"
        label="案情简介">
      </el-table-column> -->
      <!-- <el-table-column
        prop="zywfxw"
        header-align="center"
        align="center"
        label="主要违法行为">
      </el-table-column> -->
      <!-- <el-table-column
        prop="cfyj"
        header-align="center"
        align="center"
        label="处罚依据">
      </el-table-column> -->
     <!--  <el-table-column
        prop="cfzl"
        header-align="center"
        align="center"
        label="处罚种类">
      </el-table-column> -->
      <el-table-column
        prop="fkse"
        header-align="center"
        align="center"
        width="100"
        label="罚款数额（万元）">
      </el-table-column>
     <!--  <el-table-column
        prop="xzmlzl"
        header-align="center"
        align="center"
        label="行政命令种类">
      </el-table-column> -->
      <!-- <el-table-column
        prop="sfjxtz"
        header-align="center"
        align="center"
        label="是否举行听证">
      </el-table-column> -->
     <!--  <el-table-column
        prop="jdxdrq"
        header-align="center"
        align="center"
        label="决定下达日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="jdsnr"
        header-align="center"
        align="center"
        label="决定书内容">
      </el-table-column> -->
     <!--  <el-table-column
        prop="zxqk"
        header-align="center"
        align="center"
        label="执行情况">
      </el-table-column>
      <el-table-column
        prop="zxwbrq"
        header-align="center"
        align="center"
        label="执行完毕日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="fyjg"
        header-align="center"
        align="center"
        label="复议结果">
      </el-table-column>
      <el-table-column
        prop="ssjg"
        header-align="center"
        align="center"
        label="诉讼结果">
      </el-table-column>
      <el-table-column
        prop="ysxx"
        header-align="center"
        align="center"
        label="移送信息">
      </el-table-column> -->
      <!-- <el-table-column
        prop="jarq"
        header-align="center"
        align="center"
        label="结案日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="sfja"
        header-align="center"
        align="center"
        width="80"
        label="是否结案" :formatter="fmtYesORNo">
      </el-table-column> -->
      <!-- <el-table-column
        prop="ajh"
        header-align="center"
        align="center"
        label="案卷号">
      </el-table-column>
      <el-table-column
        prop="bz"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column> -->
      <!-- <el-table-column
        prop="cjsj"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column> -->
      <!-- <el-table-column
        prop="xgsj"
        header-align="center"
        align="center"
        label="修改时间">
      </el-table-column> -->
     <!--  <el-table-column
        prop="sjly"
        header-align="center"
        align="center"
        label="数据来源">
      </el-table-column> -->
      <!-- <el-table-column
        prop="zt"
        header-align="center"
        align="center"
        width="80"
        label="状态" :formatter="fmtZT">
      </el-table-column> -->
      <!-- <el-table-column
        prop="sfyjh"
        header-align="center"
        align="center"
        label="是否已交换N：未交换Y：已交换" :formatter="fmtYesORNo">
      </el-table-column>
      <el-table-column
        prop="shzt"
        header-align="center"
        align="center"
        label="审核状态">
      </el-table-column> -->
      <el-table-column
        prop="tyshxydm"
        header-align="center"
        align="center"
        label="统一社会信用代码">
      </el-table-column>
      <!-- <el-table-column
        prop="zcjdxgcl"
        header-align="center"
        align="center"
        label="作出决定的相关材料">
      </el-table-column>
      <el-table-column
        prop="wfajlx"
        header-align="center"
        align="center"
        label="违法案件类型">
      </el-table-column> -->
      <!-- <el-table-column
        prop="xyhnDbTime"
        header-align="center"
        align="center"
        label="更新时间戳">
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
        width="100"
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
  import AddOrUpdate from './cssfgwhbtsjzxgxxzcf-add-or-update'
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
          url: this.$http.adornUrl('/spider/cssfgwhbtsjzxgxxzcf/list'),
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
            url: this.$http.adornUrl('/spider/cssfgwhbtsjzxgxxzcf/delete'),
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
      },
      fmtZT (value) {
        if (value === 0) {
          return '新增'
        } else if (value === 1) {
          return '修改'
        } else if (value === 2) {
          return '删除'
        }
      },
      fmtYesORNo (value) {
        if (value === 'N') {
          return '否'
        } else if (value === 'Y') {
          return '是'
        }
      }
    }
  }
</script>
