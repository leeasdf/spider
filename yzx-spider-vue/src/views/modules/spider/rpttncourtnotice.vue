<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.entName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:rpttncourtnotice:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:rpttncourtnotice:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form label-position="left" label-width="120px" inline class="yzx-table-expand">
            <el-form-item label="公告状态"><span>{{props.row.bltnstate}}</span></el-form-item>
            <el-form-item label="判决人联系方式"><span>{{props.row.judgephone}}</span></el-form-item>
            <el-form-item label="省份"><span>{{props.row.province}}</span></el-form-item>
            <el-form-item label="刊登日期"><span>{{props.row.showtxtdate}}</span></el-form-item>
            <el-form-item label="临时保存编号"><span>{{props.row.tmpsaversn}}</span></el-form-item>
            <el-form-item label="发布界面"><span>{{props.row.publishpage}}</span></el-form-item>
            <el-form-item label="被诉方网址"><span>{{props.row.party2str}}</span></el-form-item>
            <el-form-item label="判决人"><span>{{props.row.judge}}</span></el-form-item>
            <el-form-item label="上诉方网址"><span>{{props.row.party1str}}</span></el-form-item>
            <el-form-item label="案件编号"><span>{{props.row.caseno}}</span></el-form-item>
            <el-form-item label="法院标识"><span>{{props.row.courtflag}}</span></el-form-item>
            <el-form-item label="联系方式"><span>{{props.row.mobilephone}}</span></el-form-item>
            <el-form-item label="企业列表"><span>{{props.row.companyList}}</span></el-form-item>
            <el-form-item label="cn编号"><span>{{props.row.cnId}}</span></el-form-item>
            <el-form-item label="公告内容" class="yzx-table-rowspan"><span>{{props.row.content}}</span></el-form-item>
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
      <el-table-column
        prop="publishdate"
        header-align="center"
        align="center"
        width="100"
        label="公告时间">
      </el-table-column>
      <el-table-column
        prop="party1"
        header-align="center"
        align="center"
        label="上诉方">
      </el-table-column>
      <el-table-column
        prop="party2"
        header-align="center"
        align="center"
        label="被诉方">
      </el-table-column>
      <el-table-column
        prop="bltntypename"
        header-align="center"
        align="center"
        label="公告类型">
      </el-table-column>
      <el-table-column
        prop="courtcode"
        header-align="center"
        align="center"
        label="法院编码">
      </el-table-column>
      <!-- <el-table-column
        prop="content"
        header-align="center"
        align="center"
        label="公告内容">
      </el-table-column> -->
      
      <!-- <el-table-column
        prop="dataState"
        header-align="center"
        align="center"
        label="数据状态：1-正常 0-删除">
      </el-table-column> -->
      <!-- <el-table-column
        prop="announceId"
        header-align="center"
        align="center"
        label="公告ID"> 
      </el-table-column>-->
      <!-- <el-table-column
        prop="reason"
        header-align="center"
        align="center"
        label="公告内容">
      </el-table-column> -->
      <el-table-column
        prop="bltnno"
        header-align="center"
        align="center"
        label="公告编号">
      </el-table-column>
     <!--  <el-table-column
        prop="bltnstate"
        header-align="center"
        align="center"
        label="公告状态">
      </el-table-column>
      <el-table-column
        prop="judgephone"
        header-align="center"
        align="center"
        label="判决人联系方式">
      </el-table-column> -->
      <!-- <el-table-column
        prop="dealgradename"
        header-align="center"
        align="center"
        label="暂无">
      </el-table-column>
      <el-table-column
        prop="dealgrade"
        header-align="center"
        align="center"
        label="暂无">
      </el-table-column> -->
      <!-- <el-table-column
        prop="province"
        header-align="center"
        align="center"
        label="省份">
      </el-table-column> -->
      <el-table-column
        prop="bltntype"
        header-align="center"
        align="center"
        label="公告类别">
      </el-table-column>
     <!--  <el-table-column
        prop="showtxtdate"
        header-align="center"
        align="center"
        label="刊登日期">
      </el-table-column> -->
     <!--  <el-table-column
        prop="tmpsaversn"
        header-align="center"
        align="center"
        label="临时保存编号">
      </el-table-column> -->
     <!--  <el-table-column
        prop="publishpage"
        header-align="center"
        align="center"
        label="发布界面">
      </el-table-column> -->
      <!-- <el-table-column
        prop="party2str"
        header-align="center"
        align="center"
        label="被诉方网址">
      </el-table-column> -->
      <!-- <el-table-column
        prop="tycId"
        header-align="center"
        align="center"
        label="天眼查ID">
      </el-table-column> -->
      <!-- <el-table-column
        prop="judge"
        header-align="center"
        align="center"
        label="判决人">
      </el-table-column> -->
     <!--  <el-table-column
        prop="party1str"
        header-align="center"
        align="center"
        label="上诉方网址">
      </el-table-column> -->
      <!-- <el-table-column
        prop="caseno"
        header-align="center"
        align="center"
        label="案件编号">
      </el-table-column>
      <el-table-column
        prop="courtflag"
        header-align="center"
        align="center"
        label="法院标识">
      </el-table-column> -->
      <!-- <el-table-column
        prop="customno"
        header-align="center"
        align="center"
        label="暂无">
      </el-table-column> -->
      <!-- <el-table-column
        prop="mobilephone"
        header-align="center"
        align="center"
        label="联系方式">
      </el-table-column> -->
      <!-- <el-table-column
        prop="companyList"
        header-align="center"
        align="center"
        label="企业列表">
      </el-table-column>
      <el-table-column
        prop="cnId"
        header-align="center"
        align="center"
        label="cn编号">
      </el-table-column> -->
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
  import AddOrUpdate from './rpttncourtnotice-add-or-update'
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
          url: this.$http.adornUrl('/spider/rpttncourtnotice/list'),
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
            url: this.$http.adornUrl('/spider/rpttncourtnotice/delete'),
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
