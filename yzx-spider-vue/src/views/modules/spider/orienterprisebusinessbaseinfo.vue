<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.enterpriseName" placeholder="企业名称" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('spider:orienterprisebusinessbaseinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('spider:orienterprisebusinessbaseinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
            <el-form-item label="原注册号"><span>{{props.row.oriRegisterNo}}</span></el-form-item>
            <el-form-item label="注册号"><span>{{props.row.registerNo}}</span></el-form-item>
            <el-form-item label="企业(机构)类型"><span>{{props.row.enterpriseType}}</span></el-form-item>
            <el-form-item label="隶属企业注册号"><span>{{props.row.belongRegisterNo}}</span></el-form-item>
            <el-form-item label="隶属关系"><span>{{props.row.belongRelationship}}</span></el-form-item>
            <el-form-item label="行业门类"><span>{{props.row.industryCategories}}</span></el-form-item>
            <el-form-item label="行业代码"><span>{{props.row.industryCode}}</span></el-form-item>
            <el-form-item label="许可经营项目"><span>{{props.row.permittedOperatingItems}}</span></el-form-item>
            <el-form-item label="一般经营项目"><span>{{props.row.generalOperatingItems}}</span></el-form-item>
            <el-form-item label="经营(驻在)期限"><span>{{props.row.businessPeriodBegin}} 至 {{props.row.businessPeriodEnd}}</span></el-form-item>
            <el-form-item label="邮政编码"><span>{{props.row.zipCode}}</span></el-form-item>
            <el-form-item label="联系电话"><span>{{props.row.phone}}</span></el-form-item>
            <el-form-item label="电子邮箱"><span>{{props.row.email}}</span></el-form-item>
            <el-form-item label="属地监管工商所"><span>{{props.row.belongIndustryCommerceBureau}}</span></el-form-item>
            <el-form-item label="信用等级"><span>{{props.row.creditRating}}</span></el-form-item>
            <el-form-item label="分类日期"><span>{{props.row.classificationDate}}</span></el-form-item>
            <el-form-item label="成立日期"><span>{{props.row.setUpDate}}</span></el-form-item>
            <el-form-item label="核准日期"><span>{{props.row.approvalDate}}</span></el-form-item>
            <el-form-item label="登记机关"><span>{{props.row.registrationAuthority}}</span></el-form-item>
            <el-form-item label="企业分类码"><span>{{props.row.enterpriseClassificationCode}}</span></el-form-item>
            <el-form-item label="企业状态"><span>{{props.row.enterpriseState}}</span></el-form-item>
            <el-form-item label="经营(业务)范围" class="yzx-table-rowspan"><span>{{props.row.operationScope}}</span></el-form-item>
            <el-form-item label="经营方式" class="yzx-table-rowspan"><span>{{props.row.operationMode}}</span></el-form-item>
            <el-form-item label="经营范围及方式" class="yzx-table-rowspan"><span>{{props.row.operationScopeMode}}</span></el-form-item>
            <el-form-item label="兼营范围" class="yzx-table-rowspan"><span>{{props.row.engagedScope}}</span></el-form-item>
            <el-form-item label="住所" class="yzx-table-rowspan"><span>{{props.row.domicile}}</span></el-form-item>
            <el-form-item label="住所所在行政区划"><span>{{props.row.domicileArea}}</span></el-form-item>
            <el-form-item label="住所所在经济开发区"><span>{{props.row.domicileDevelopZone}}</span></el-form-item>
            <el-form-item label="住所产权"><span>{{props.row.houseProperty}}</span></el-form-item>
            <el-form-item label="经营场所所在行政区划"><span>{{props.row.premisesArea}}</span></el-form-item>
            <el-form-item label="经营场所" class="yzx-table-rowspan"><span>{{props.row.premises}}</span></el-form-item>
            <el-form-item label="设立方式"><span>{{props.row.setUpMode}}</span></el-form-item>
            <el-form-item label="合伙人数"><span>{{props.row.partnershipNo}}</span></el-form-item>
            <el-form-item label="有限合伙人数"><span>{{props.row.partnersLimitedNo}}</span></el-form-item>
            <el-form-item label="合伙方式"><span>{{props.row.partnershipMode}}</span></el-form-item>
            <el-form-item label="执行人数"><span>{{props.row.performNo}}</span></el-form-item>
            <el-form-item label="从业人数"><span>{{props.row.employeesNo}}</span></el-form-item>
            <el-form-item label="出资方式(个独)或组成形式（个体）"><span>{{props.row.contributionMode}}</span></el-form-item>
            <el-form-item label="外资产业代码"><span>{{props.row.foreignIndustryCode}}</span></el-form-item>
            <el-form-item label="中西部优势产业代码"><span>{{props.row.midwestIndustrialCode}}</span></el-form-item>
            <el-form-item label="项目类型"><span>{{props.row.projectType}}</span></el-form-item>
            <el-form-item label="投资总额"><span>{{props.row.investmentTotalAmount}}</span></el-form-item>
            <el-form-item label="投资总额币种"><span>{{props.row.investmentTotalAmountCurrency}}</span></el-form-item>
            <el-form-item label="投资总额折万美元"><span>{{props.row.investmentTotalAmountUsd}}</span></el-form-item>
            <el-form-item label="注册资本(金)折万美元"><span>{{props.row.registeredCapitalUsd}}</span></el-form-item>
            <el-form-item label="注册资本(金)币种"><span>{{props.row.registeredCapitalCurrency}}</span></el-form-item>
            <el-form-item label="注册资本(金)折万人民币"><span>{{props.row.registeredCapitalCny}}</span></el-form-item>
            <el-form-item label="外方注册资本(金)币种"><span>{{props.row.foreignRegisteredCapitalCurrency}}</span></el-form-item>
            <el-form-item label="外方注册资本(金)折万美元"><span>{{props.row.foreignRegisteredCapitalUsd}}</span></el-form-item>
            <el-form-item label="外方实收资本折万美元"><span>{{props.row.foreignPaidInCapitalUsd}}</span></el-form-item>
            <el-form-item label="营运资金"><span>{{props.row.workingCapital}}</span></el-form-item>
            <el-form-item label="转型日期"><span>{{props.row.transformationDate}}</span></el-form-item>
            <el-form-item label="经营活动类型"><span>{{props.row.businessType}}</span></el-form-item>
            <el-form-item label="外国(地区)企业名称"><span>{{props.row.foreignEnterpriseName}}</span></el-form-item>
            <el-form-item label="主管部门"><span>{{props.row.competentDepartment}}</span></el-form-item>
            <el-form-item label="国别(地区)"><span>{{props.row.country}}</span></el-form-item>
            <el-form-item label="承包工程或经营管理项目"><span>{{props.row.contractProject}}</span></el-form-item>
            <el-form-item label="承包工程或经营管理内容"><span>{{props.row.contractProjectRemark}}</span></el-form-item>
            <el-form-item label="境外住所"><span>{{props.row.outsideHouse}}</span></el-form-item>
            <el-form-item label="境外注册资本"><span>{{props.row.overseasRegisteredCapital}}</span></el-form-item>
            <el-form-item label="境外经营范围"><span>{{props.row.overseasBusinessScope}}</span></el-form-item>
            <el-form-item label="企业性质"><span>{{props.row.enterpriseNature}}</span></el-form-item>
            <el-form-item label="境外主体类型"><span>{{props.row.overseasSubjectType}}</span></el-form-item>
            <el-form-item label="经营类别"><span>{{props.row.businessCategory}}</span></el-form-item>
            <el-form-item label="隶属企业统一社会信用代码"><span>{{props.row.belongUniformSocialCreditCode}}</span></el-form-item>
            <el-form-item label="主体身份代码"><span>{{props.row.principalIdentityCode}}</span></el-form-item>
            <el-form-item label="创建时间"><span>{{props.row.createTime}}</span></el-form-item>
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
        label="企业ID">
      </el-table-column> -->
      <el-table-column
        prop="enterpriseName"
        header-align="center"
        align="center"
        label="企业(机构)名称">
      </el-table-column>
      <!-- <el-table-column
        prop="oriRegisterNo"
        header-align="center"
        align="center"
        label="原注册号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="registerNo"
        header-align="center"
        align="center"
        label="注册号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="enterpriseType"
        header-align="center"
        align="center"
        label="企业(机构)类型">
      </el-table-column> -->
      <el-table-column
        prop="subjectIdentityCode"
        header-align="center"
        align="center"
        label="隶属企业主体身份代码">
      </el-table-column>
      <el-table-column
        prop="belongEnterpriseName"
        header-align="center"
        align="center"
        label="隶属企业机构名称">
      </el-table-column>
      <!-- <el-table-column
        prop="belongRegisterNo"
        header-align="center"
        align="center"
        label="隶属企业注册号">
      </el-table-column> -->
      <!-- <el-table-column
        prop="belongRelationship"
        header-align="center"
        align="center"
        label="隶属关系">
      </el-table-column>
      <el-table-column
        prop="industryCategories"
        header-align="center"
        align="center"
        label="行业门类">
      </el-table-column> -->
     <!--  <el-table-column
        prop="industryCode"
        header-align="center"
        align="center"
        label="行业代码">
      </el-table-column> -->
      <!-- <el-table-column
        prop="permittedOperatingItems"
        header-align="center"
        align="center"
        label="许可经营项目">
      </el-table-column>
      <el-table-column
        prop="generalOperatingItems"
        header-align="center"
        align="center"
        label="一般经营项目">
      </el-table-column>
      <el-table-column
        prop="businessPeriodBegin"
        header-align="center"
        align="center"
        label="经营(驻在)期限自">
      </el-table-column>
      <el-table-column
        prop="businessPeriodEnd"
        header-align="center"
        align="center"
        label="经营(驻在)期限至">
      </el-table-column> -->
      <!-- <el-table-column
        prop="zipCode"
        header-align="center"
        align="center"
        label="邮政编码">
      </el-table-column> -->
      <!-- <el-table-column
        prop="phone"
        header-align="center"
        align="center"
        label="联系电话">
      </el-table-column>
      <el-table-column
        prop="email"
        header-align="center"
        align="center"
        label="电子邮箱">
      </el-table-column> -->
      <!-- <el-table-column
        prop="belongIndustryCommerceBureau"
        header-align="center"
        align="center"
        label="属地监管工商所">
      </el-table-column>
      <el-table-column
        prop="creditRating"
        header-align="center"
        align="center"
        label="信用等级">
      </el-table-column> -->
      <!-- <el-table-column
        prop="classificationDate"
        header-align="center"
        align="center"
        label="分类日期">
      </el-table-column>
      <el-table-column
        prop="setUpDate"
        header-align="center"
        align="center"
        label="成立日期">
      </el-table-column> -->
      <!-- <el-table-column
        prop="approvalDate"
        header-align="center"
        align="center"
        label="核准日期">
      </el-table-column>
      <el-table-column
        prop="registrationAuthority"
        header-align="center"
        align="center"
        label="登记机关">
      </el-table-column> -->
      <!-- <el-table-column
        prop="enterpriseClassificationCode"
        header-align="center"
        align="center"
        label="企业分类码">
      </el-table-column>
      <el-table-column
        prop="enterpriseState"
        header-align="center"
        align="center"
        label="企业状态">
      </el-table-column> -->
      <el-table-column
        prop="registeredCapital"
        header-align="center"
        align="center"
        width="120"
        label="注册资金">
      </el-table-column>
      <!-- <el-table-column
        prop="operationScope"
        header-align="center"
        align="center"
        label="经营(业务)范围">
      </el-table-column>
      <el-table-column
        prop="operationMode"
        header-align="center"
        align="center"
        label="经营方式">
      </el-table-column>
      <el-table-column
        prop="operationScopeMode"
        header-align="center"
        align="center"
        label="经营范围及方式">
      </el-table-column> -->
      <!-- <el-table-column
        prop="engagedScope"
        header-align="center"
        align="center"
        label="兼营范围">
      </el-table-column>
      <el-table-column
        prop="domicileArea"
        header-align="center"
        align="center"
        label="住所所在行政区划">
      </el-table-column>
      <el-table-column
        prop="domicile"
        header-align="center"
        align="center"
        label="住所">
      </el-table-column> -->
      <!-- <el-table-column
        prop="domicileDevelopZone"
        header-align="center"
        align="center"
        label="住所所在经济开发区">
      </el-table-column>
      <el-table-column
        prop="houseProperty"
        header-align="center"
        align="center"
        label="住所产权">
      </el-table-column>
      <el-table-column
        prop="premisesArea"
        header-align="center"
        align="center"
        label="经营场所所在行政区划">
      </el-table-column> -->
      <!-- <el-table-column
        prop="premises"
        header-align="center"
        align="center"
        label="经营场所">
      </el-table-column> -->
      <el-table-column
        prop="paidInCapital"
        header-align="center"
        align="center"
        width="120"
        label="实收资本">
      </el-table-column>
      <!-- <el-table-column
        prop="setUpMode"
        header-align="center"
        align="center"
        label="设立方式">
      </el-table-column>
      <el-table-column
        prop="partnershipNo"
        header-align="center"
        align="center"
        label="合伙人数">
      </el-table-column>
      <el-table-column
        prop="partnersLimitedNo"
        header-align="center"
        align="center"
        label="有限合伙人数">
      </el-table-column> -->
      <!-- <el-table-column
        prop="partnershipMode"
        header-align="center"
        align="center"
        label="合伙方式">
      </el-table-column>
      <el-table-column
        prop="performNo"
        header-align="center"
        align="center"
        label="执行人数">
      </el-table-column> -->
      <!-- <el-table-column
        prop="employeesNo"
        header-align="center"
        align="center"
        label="从业人数">
      </el-table-column>
      <el-table-column
        prop="contributionMode"
        header-align="center"
        align="center"
        label="出资方式(个独)或组成形式（个体）">
      </el-table-column>
      <el-table-column
        prop="foreignIndustryCode"
        header-align="center"
        align="center"
        label="外资产业代码">
      </el-table-column>
      <el-table-column
        prop="midwestIndustrialCode"
        header-align="center"
        align="center"
        label="中西部优势产业代码">
      </el-table-column> -->
      <!-- <el-table-column
        prop="projectType"
        header-align="center"
        align="center"
        label="项目类型">
      </el-table-column>
      <el-table-column
        prop="investmentTotalAmount"
        header-align="center"
        align="center"
        label="投资总额">
      </el-table-column>
      <el-table-column
        prop="investmentTotalAmountCurrency"
        header-align="center"
        align="center"
        label="投资总额币种">
      </el-table-column> -->
      <!-- <el-table-column
        prop="investmentTotalAmountUsd"
        header-align="center"
        align="center"
        label="投资总额折万美元">
      </el-table-column>
      <el-table-column
        prop="registeredCapitalUsd"
        header-align="center"
        align="center"
        label="注册资本(金)折万美元">
      </el-table-column>
      <el-table-column
        prop="registeredCapitalCurrency"
        header-align="center"
        align="center"
        label="注册资本(金)币种">
      </el-table-column> 
      <el-table-column
        prop="registeredCapitalCny"
        header-align="center"
        align="center"
        label="注册资本(金)折万人民币">
      </el-table-column> -->
      <!-- <el-table-column
        prop="foreignRegisteredCapitalCurrency"
        header-align="center"
        align="center"
        label="外方注册资本(金)币种">
      </el-table-column>
      <el-table-column
        prop="foreignRegisteredCapitalUsd"
        header-align="center"
        align="center"
        label="外方注册资本(金)折万美元">
      </el-table-column>
      <el-table-column
        prop="foreignPaidInCapitalUsd"
        header-align="center"
        align="center"
        label="外方实收资本折万美元">
      </el-table-column> -->
      <!-- <el-table-column
        prop="workingCapital"
        header-align="center"
        align="center"
        label="营运资金">
      </el-table-column>
      <el-table-column
        prop="transformationDate"
        header-align="center"
        align="center"
        label="转型日期">
      </el-table-column>
      <el-table-column
        prop="businessType"
        header-align="center"
        align="center"
        label="经营活动类型">
      </el-table-column> -->
      <!-- <el-table-column
        prop="foreignEnterpriseName"
        header-align="center"
        align="center"
        label="外国(地区)企业名称">
      </el-table-column>
      <el-table-column
        prop="competentDepartment"
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
        prop="contractProject"
        header-align="center"
        align="center"
        label="承包工程或经营管理项目">
      </el-table-column>
      <el-table-column
        prop="contractProjectRemark"
        header-align="center"
        align="center"
        label="承包工程或经营管理内容">
      </el-table-column> -->
      <!-- <el-table-column
        prop="outsideHouse"
        header-align="center"
        align="center"
        label="境外住所">
      </el-table-column>
      <el-table-column
        prop="overseasRegisteredCapital"
        header-align="center"
        align="center"
        label="境外注册资本">
      </el-table-column>
      <el-table-column
        prop="overseasBusinessScope"
        header-align="center"
        align="center"
        label="境外经营范围">
      </el-table-column>
      <el-table-column
        prop="enterpriseNature"
        header-align="center"
        align="center"
        label="企业性质">
      </el-table-column>
      <el-table-column
        prop="overseasSubjectType"
        header-align="center"
        align="center"
        label="境外主体类型">
      </el-table-column> -->
      <!-- <el-table-column
        prop="businessCategory"
        header-align="center"
        align="center"
        label="经营类别">
      </el-table-column> -->
      <el-table-column
        prop="uniformSocialCreditCode"
        header-align="center"
        align="center"
        label="统一社会信用代码">
      </el-table-column>
      <!-- <el-table-column
        prop="belongUniformSocialCreditCode"
        header-align="center"
        align="center"
        label="隶属企业统一社会信用代码">
      </el-table-column>
      <el-table-column
        prop="principalIdentityCode"
        header-align="center"
        align="center"
        label="主体身份代码">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间">
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
  import AddOrUpdate from './orienterprisebusinessbaseinfo-add-or-update'
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
          url: this.$http.adornUrl('/spider/orienterprisebusinessbaseinfo/list'),
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
            url: this.$http.adornUrl('/spider/orienterprisebusinessbaseinfo/delete'),
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
