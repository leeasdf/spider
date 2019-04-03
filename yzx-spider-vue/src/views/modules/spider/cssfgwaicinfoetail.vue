<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:cssfgwaicinfoetail:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:cssfgwaicinfoetail:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
          <el-form inline label-width="180px" class="yzx-table-expand">
            <el-form-item label="注册号"><span>{{props.row.regno}}</span></el-form-item>
            <el-form-item label="原注册号"><span>{{props.row.oriregno}}</span></el-form-item>
            <el-form-item label="企业(机构)类型"><span>{{props.row.enttype}}</span></el-form-item>
            <el-form-item label="隶属企业主体身份代码"><span>{{props.row.ppripid}}</span></el-form-item>
            <el-form-item label="隶属企业机构名称"><span>{{props.row.pentname}}</span></el-form-item>
            <el-form-item label="隶属企业注册号"><span>{{props.row.pregno}}</span></el-form-item>
            <el-form-item label="隶属关系"><span>{{props.row.hypotaxis}}</span></el-form-item>
            <el-form-item label="行业代码"><span>{{props.row.industryco}}</span></el-form-item>
            <el-form-item label="许可经营项目"><span>{{props.row.abuitem}}</span></el-form-item>
            <el-form-item label="一般经营项目"><span>{{props.row.cbuitem}}</span></el-form-item>
            <el-form-item label="经营(驻在)期限自"><span>{{props.row.opfrom}}</span></el-form-item>
            <el-form-item label="经营(驻在)期限至"><span>{{props.row.opto}}</span></el-form-item>
            <el-form-item label="邮政编码"><span>{{props.row.postalcode}}</span></el-form-item>
            <el-form-item label="联系电话"><span>{{props.row.tel}}</span></el-form-item>
            <el-form-item label="电子邮箱"><span>{{props.row.email}}</span></el-form-item>
            <el-form-item label="属地监管工商所"><span>{{props.row.localadm}}</span></el-form-item>
            <el-form-item label="信用等级"><span>{{props.row.credlevel}}</span></el-form-item>
            <el-form-item label="分类日期"><span>{{props.row.assdate}}</span></el-form-item>
            <el-form-item label="核准日期"><span>{{props.row.issblicdate}}</span></el-form-item>
            <el-form-item label="登记机关"><span>{{props.row.regorg}}</span></el-form-item>
            <el-form-item label="企业分类码"><span>{{props.row.entcat}}</span></el-form-item>
            <el-form-item label="住所所在经济开发区"><span>{{props.row.ecotecdevzone}}</span></el-form-item>
            <el-form-item label="住所产权"><span>{{props.row.domproright}}</span></el-form-item>
            <el-form-item label="经营场所所在行政区划"><span>{{props.row.oplocdistrict}}</span></el-form-item>
            <el-form-item label="实收资本"><span>{{props.row.reccap}}</span></el-form-item>
            <el-form-item label="设立方式"><span>{{props.row.insform}}</span></el-form-item>
            <el-form-item label="合伙人数"><span>{{props.row.parnum}}</span></el-form-item>
            <el-form-item label="有限合伙人数"><span>{{props.row.limparnum}}</span></el-form-item>
            <el-form-item label="合伙方式"><span>{{props.row.parform}}</span></el-form-item>
            <el-form-item label="执行人数"><span>{{props.row.exenum}}</span></el-form-item>
            <el-form-item label="从业人数"><span>{{props.row.empnum}}</span></el-form-item>
            <el-form-item label="出资方式(个独)或组成形式（个体）"><span>{{props.row.sconform}}</span></el-form-item>
            <el-form-item label="外资产业代码"><span>{{props.row.forcapindcode}}</span></el-form-item>
            <el-form-item label="中西部优势产业代码"><span>{{props.row.midpreindcode}}</span></el-form-item>
            <el-form-item label="项目类型"><span>{{props.row.protype}}</span></el-form-item>
            <el-form-item label="投资总额"><span>{{props.row.congro}}</span></el-form-item>
            <el-form-item label="投资总额币种"><span>{{props.row.congrocur}}</span></el-form-item>
            <el-form-item label="投资总额折万美元"><span>{{props.row.congrousd}}</span></el-form-item>
            <el-form-item label="注册资本(金)折万美元"><span>{{props.row.regcapusd}}</span></el-form-item>
            <el-form-item label="外方注册资本(金)币种"><span>{{props.row.forregcapcur}}</span></el-form-item>
            <el-form-item label="外方注册资本(金)折万美元"><span>{{props.row.forregcapusd}}</span></el-form-item>
            <el-form-item label="外方实收资本折万美元"><span>{{props.row.forreccapusd}}</span></el-form-item>
            <el-form-item label="营运资金"><span>{{props.row.worcap}}</span></el-form-item>
            <el-form-item label="转型日期"><span>{{props.row.chamecdate}}</span></el-form-item>
            <el-form-item label="经营活动类型"><span>{{props.row.opracttype}}</span></el-form-item>
            <el-form-item label="外国(地区)企业名称"><span>{{props.row.forentname}}</span></el-form-item>
            <el-form-item label="主管部门"><span>{{props.row.depincha}}</span></el-form-item>
            <el-form-item label="国别(地区)"><span>{{props.row.country}}</span></el-form-item>
            <el-form-item label="承包工程或经营管理项目"><span>{{props.row.itemofoporcpro}}</span></el-form-item>
            <el-form-item label="承包工程或经营管理内容"><span>{{props.row.conofcontrpro}}</span></el-form-item>
            <el-form-item label="境外住所"><span>{{props.row.fordom}}</span></el-form-item>
            <el-form-item label="境外注册资本"><span>{{props.row.forregecap}}</span></el-form-item>
            <el-form-item label="境外经营范围"><span>{{props.row.foropscope}}</span></el-form-item>
            <el-form-item label="企业性质"><span>{{props.row.sExtEntproperty}}</span></el-form-item>
            <el-form-item label="境外主体类型"><span>{{props.row.foreignbodytype}}</span></el-form-item>
            <el-form-item label="经营类别"><span>{{props.row.manacate}}</span></el-form-item>
            <el-form-item label="主体身份代码"><span>{{props.row.etpsId}}</span></el-form-item>
            <el-form-item label="修改时间"><span>{{props.row.lastdate}}</span></el-form-item>
            <el-form-item label="注册资本(金)折万人民币"><span>{{props.row.regcapusd}}</span></el-form-item>
            <el-form-item label="住所所在行政区划"><span>{{props.row.domdistrict}}</span></el-form-item>
            <el-form-item label="住所" class="yzx-table-rowspan"><span>{{props.row.dom}}</span></el-form-item>
            <el-form-item label="经营场所" class="yzx-table-rowspan"><span>{{props.row.promana}}</span></el-form-item>
            <el-form-item label="经营(业务)范围" class="yzx-table-rowspan"><span>{{props.row.opscope}}</span></el-form-item>
            <el-form-item label="经营方式" class="yzx-table-rowspan"><span>{{props.row.opform}}</span></el-form-item>
            <el-form-item label="经营范围及方式" class="yzx-table-rowspan"><span>{{props.row.opscoandform}}</span></el-form-item>
            <el-form-item label="兼营范围" class="yzx-table-rowspan"><span>{{props.row.ptbusscope}}</span></el-form-item>
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
        label="数据状态" :formatter="fmtIsInvalid">
      </el-table-column>
      <!-- <el-table-column
        prop="lastdate"
        header-align="center"
        align="center"
        label="修改时间">
      </el-table-column> -->
      <el-table-column
        prop="entname"
        header-align="center"
        align="center"
        label="企业(机构)名称">
      </el-table-column>
      <!-- <el-table-column
        prop="oriregno"
        header-align="center"
        align="center"
        label="原注册号">
      </el-table-column>
      <el-table-column
        prop="regno"
        header-align="center"
        align="center"
        label="注册号">
      </el-table-column> -->
     <!--  <el-table-column
        prop="enttype"
        header-align="center"
        align="center"
        label="企业(机构)类型">
      </el-table-column> -->
      <!-- <el-table-column
        prop="ppripid"
        header-align="center"
        align="center"
        label="隶属企业主体身份代码">
      </el-table-column>
      <el-table-column
        prop="pentname"
        header-align="center"
        align="center"
        label="隶属企业机构名称">
      </el-table-column>
      <el-table-column
        prop="pregno"
        header-align="center"
        align="center"
        label="隶属企业注册号">
      </el-table-column>
      <el-table-column
        prop="hypotaxis"
        header-align="center"
        align="center"
        label="隶属关系">
      </el-table-column> -->
      <el-table-column
        prop="industryphy"
        header-align="center"
        align="center"
        label="行业门类">
      </el-table-column>
     <!--  <el-table-column
        prop="industryco"
        header-align="center"
        align="center"
        label="行业代码">
      </el-table-column> -->
      <!-- <el-table-column
        prop="abuitem"
        header-align="center"
        align="center"
        label="许可经营项目">
      </el-table-column>
      <el-table-column
        prop="cbuitem"
        header-align="center"
        align="center"
        label="一般经营项目">
      </el-table-column>
      <el-table-column
        prop="opfrom"
        header-align="center"
        align="center"
        label="经营(驻在)期限自">
      </el-table-column>
      <el-table-column
        prop="opto"
        header-align="center"
        align="center"
        label="经营(驻在)期限至">
      </el-table-column>
      <el-table-column
        prop="postalcode"
        header-align="center"
        align="center"
        label="邮政编码">
      </el-table-column> -->
     <!--  <el-table-column
        prop="tel"
        header-align="center"
        align="center"
        label="联系电话">
      </el-table-column>
      <el-table-column
        prop="email"
        header-align="center"
        align="center"
        label="电子邮箱">
      </el-table-column>
      <el-table-column
        prop="localadm"
        header-align="center"
        align="center"
        label="属地监管工商所">
      </el-table-column>
      <el-table-column
        prop="credlevel"
        header-align="center"
        align="center"
        label="信用等级">
      </el-table-column> -->
     <!--  <el-table-column
        prop="assdate"
        header-align="center"
        align="center"
        label="分类日期">
      </el-table-column> -->
      <el-table-column
        prop="estdate"
        header-align="center"
        align="center"
        width="100"
        label="成立日期">
      </el-table-column>
      <!-- <el-table-column
        prop="issblicdate"
        header-align="center"
        align="center"
        label="核准日期">
      </el-table-column> -->
     <!--  <el-table-column
        prop="regorg"
        header-align="center"
        align="center"
        label="登记机关">
      </el-table-column>
      <el-table-column
        prop="entcat"
        header-align="center"
        align="center"
        label="企业分类码">
      </el-table-column> -->
      <el-table-column
        prop="opstate"
        header-align="center"
        align="center"
        width="90"
        label="企业状态">
      </el-table-column>
      <el-table-column
        prop="regcap"
        header-align="center"
        align="center"
        width="90"
        label="注册资金">
      </el-table-column>
      <!-- <el-table-column
        prop="opscope"
        header-align="center"
        align="center"
        label="经营(业务)范围">
      </el-table-column>
      <el-table-column
        prop="opform"
        header-align="center"
        align="center"
        label="经营方式">
      </el-table-column>
      <el-table-column
        prop="opscoandform"
        header-align="center"
        align="center"
        label="经营范围及方式">
      </el-table-column>
      <el-table-column
        prop="ptbusscope"
        header-align="center"
        align="center"
        label="兼营范围">
      </el-table-column> -->
      <!-- <el-table-column
        prop="domdistrict"
        header-align="center"
        align="center"
        label="住所所在行政区划">
      </el-table-column>
      <el-table-column
        prop="dom"
        header-align="center"
        align="center"
        label="住所">
      </el-table-column>
      <el-table-column
        prop="ecotecdevzone"
        header-align="center"
        align="center"
        label="住所所在经济开发区">
      </el-table-column>
      <el-table-column
        prop="domproright"
        header-align="center"
        align="center"
        label="住所产权">
      </el-table-column>
      <el-table-column
        prop="oplocdistrict"
        header-align="center"
        align="center"
        label="经营场所所在行政区划">
      </el-table-column> -->
      <!-- <el-table-column
        prop="promana"
        header-align="center"
        align="center"
        label="经营场所">
      </el-table-column> -->
     <!--  <el-table-column
        prop="reccap"
        header-align="center"
        align="center"
        label="实收资本">
      </el-table-column>
      <el-table-column
        prop="insform"
        header-align="center"
        align="center"
        label="设立方式">
      </el-table-column>
      <el-table-column
        prop="parnum"
        header-align="center"
        align="center"
        label="合伙人数">
      </el-table-column>
      <el-table-column
        prop="limparnum"
        header-align="center"
        align="center"
        label="有限合伙人数">
      </el-table-column>
      <el-table-column
        prop="parform"
        header-align="center"
        align="center"
        label="合伙方式">
      </el-table-column> -->
      <!-- <el-table-column
        prop="exenum"
        header-align="center"
        align="center"
        label="执行人数">
      </el-table-column>
      <el-table-column
        prop="empnum"
        header-align="center"
        align="center"
        label="从业人数">
      </el-table-column>
      <el-table-column
        prop="sconform"
        header-align="center"
        align="center"
        label="出资方式(个独)或组成形式（个体）">
      </el-table-column>
      <el-table-column
        prop="forcapindcode"
        header-align="center"
        align="center"
        label="外资产业代码">
      </el-table-column> -->
      <!-- <el-table-column
        prop="midpreindcode"
        header-align="center"
        align="center"
        label="中西部优势产业代码">
      </el-table-column>
      <el-table-column
        prop="protype"
        header-align="center"
        align="center"
        label="项目类型">
      </el-table-column>
      <el-table-column
        prop="congro"
        header-align="center"
        align="center"
        label="投资总额">
      </el-table-column> -->
      <!-- <el-table-column
        prop="congrocur"
        header-align="center"
        align="center"
        label="投资总额币种">
      </el-table-column>
      <el-table-column
        prop="congrousd"
        header-align="center"
        align="center"
        label="投资总额折万美元">
      </el-table-column>
      <el-table-column
        prop="regcapusd"
        header-align="center"
        align="center"
        label="注册资本(金)折万美元">
      </el-table-column> -->
      <el-table-column
        prop="regcapcur"
        header-align="center"
        align="center"
        width="120"
        label="注册资本(金)币种">
      </el-table-column>
      <!-- <el-table-column
        prop="regcaprmb"
        header-align="center"
        align="center"
        label="注册资本(金)折万人民币">
      </el-table-column> -->
      <!-- <el-table-column
        prop="forregcapcur"
        header-align="center"
        align="center"
        label="外方注册资本(金)币种">
      </el-table-column>
      <el-table-column
        prop="forregcapusd"
        header-align="center"
        align="center"
        label="外方注册资本(金)折万美元">
      </el-table-column>
      <el-table-column
        prop="forreccapusd"
        header-align="center"
        align="center"
        label="外方实收资本折万美元">
      </el-table-column> -->
      <!-- <el-table-column
        prop="worcap"
        header-align="center"
        align="center"
        label="营运资金">
      </el-table-column>
      <el-table-column
        prop="chamecdate"
        header-align="center"
        align="center"
        label="转型日期">
      </el-table-column>
      <el-table-column
        prop="opracttype"
        header-align="center"
        align="center"
        label="经营活动类型">
      </el-table-column>
      <el-table-column
        prop="forentname"
        header-align="center"
        align="center"
        label="外国(地区)企业名称">
      </el-table-column> -->
      <!-- <el-table-column
        prop="depincha"
        header-align="center"
        align="center"
        label="主管部门">
      </el-table-column>
      <el-table-column
        prop="country"
        header-align="center"
        align="center"
        label="国别(地区)">
      </el-table-column>
      <el-table-column
        prop="itemofoporcpro"
        header-align="center"
        align="center"
        label="承包工程或经营管理项目">
      </el-table-column>
      <el-table-column
        prop="conofcontrpro"
        header-align="center"
        align="center"
        label="承包工程或经营管理内容">
      </el-table-column>
      <el-table-column
        prop="fordom"
        header-align="center"
        align="center"
        label="境外住所">
      </el-table-column>
      <el-table-column
        prop="forregecap"
        header-align="center"
        align="center"
        label="境外注册资本">
      </el-table-column> -->
      <!-- <el-table-column
        prop="foropscope"
        header-align="center"
        align="center"
        label="境外经营范围">
      </el-table-column>
      <el-table-column
        prop="sExtEntproperty"
        header-align="center"
        align="center"
        label="企业性质">
      </el-table-column>
      <el-table-column
        prop="foreignbodytype"
        header-align="center"
        align="center"
        label="境外主体类型">
      </el-table-column>
      <el-table-column
        prop="manacate"
        header-align="center"
        align="center"
        label="经营类别">
      </el-table-column> -->
      <el-table-column
        prop="uscc"
        header-align="center"
        align="center"
        label="统一社会信用代码">
      </el-table-column>
      <!-- <el-table-column
        prop="puniscid"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="etpsId"
        header-align="center"
        align="center"
        label="主体身份代码">
      </el-table-column> -->
     <!--  <el-table-column
        prop="zjid"
        header-align="center"
        align="center"
        label="主键">
      </el-table-column> -->
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
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
  import AddOrUpdate from './cssfgwaicinfoetail-add-or-update'
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
          url: this.$http.adornUrl('/spider/cssfgwaicinfoetail/list'),
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
            url: this.$http.adornUrl('/spider/cssfgwaicinfoetail/delete'),
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
