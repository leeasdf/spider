<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
    
    <el-form-item label="企业(机构)名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业(机构)名称"></el-input>
    </el-form-item>
    <el-form-item label="原注册号" prop="oriRegisterNo">
      <el-input v-model="dataForm.oriRegisterNo" placeholder="原注册号"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="registerNo">
      <el-input v-model="dataForm.registerNo" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="企业(机构)类型" prop="enterpriseType">
      <el-input v-model="dataForm.enterpriseType" placeholder="企业(机构)类型"></el-input>
    </el-form-item>
    <el-form-item label="隶属企业主体身份代码" prop="subjectIdentityCode">
      <el-input v-model="dataForm.subjectIdentityCode" placeholder="隶属企业主体身份代码"></el-input>
    </el-form-item>
    <el-form-item label="隶属企业机构名称" prop="belongEnterpriseName">
      <el-input v-model="dataForm.belongEnterpriseName" placeholder="隶属企业机构名称"></el-input>
    </el-form-item>
    <el-form-item label="隶属企业注册号" prop="belongRegisterNo">
      <el-input v-model="dataForm.belongRegisterNo" placeholder="隶属企业注册号"></el-input>
    </el-form-item>
    <el-form-item label="隶属关系" prop="belongRelationship">
      <el-input v-model="dataForm.belongRelationship" placeholder="隶属关系"></el-input>
    </el-form-item>
    <el-form-item label="行业门类" prop="industryCategories">
      <el-input v-model="dataForm.industryCategories" placeholder="行业门类"></el-input>
    </el-form-item>
    <el-form-item label="行业代码" prop="industryCode">
      <el-input v-model="dataForm.industryCode" placeholder="行业代码"></el-input>
    </el-form-item>
    <el-form-item label="许可经营项目" prop="permittedOperatingItems">
      <el-input v-model="dataForm.permittedOperatingItems" placeholder="许可经营项目"></el-input>
    </el-form-item>
    <el-form-item label="一般经营项目" prop="generalOperatingItems">
      <el-input v-model="dataForm.generalOperatingItems" placeholder="一般经营项目"></el-input>
    </el-form-item>
    <el-form-item label="经营(驻在)期限自" prop="businessPeriodBegin">
      <el-date-picker v-model="dataForm.businessPeriodBegin" format="yyyy-MM-dd" value-format="yyyy-MM-dd" ></el-date-picker>
    </el-form-item>
    <el-form-item label="经营(驻在)期限至" prop="businessPeriodEnd">
      <el-date-picker v-model="dataForm.businessPeriodEnd" format="yyyy-MM-dd" value-format="yyyy-MM-dd" ></el-date-picker>
    </el-form-item>
    <el-form-item label="邮政编码" prop="zipCode">
      <el-input v-model="dataForm.zipCode" placeholder="邮政编码"></el-input>
    </el-form-item>
    <el-form-item label="联系电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="联系电话"></el-input>
    </el-form-item>
    <el-form-item label="电子邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="电子邮箱"></el-input>
    </el-form-item>
    <el-form-item label="属地监管工商所" prop="belongIndustryCommerceBureau">
      <el-input v-model="dataForm.belongIndustryCommerceBureau" placeholder="属地监管工商所"></el-input>
    </el-form-item>
    <el-form-item label="信用等级" prop="creditRating">
      <el-input v-model="dataForm.creditRating" placeholder="信用等级"></el-input>
    </el-form-item>
    <el-form-item label="分类日期" prop="classificationDate">
      <el-date-picker v-model="dataForm.classificationDate" placeholder="分类日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="成立日期" prop="setUpDate">
      <el-date-picker v-model="dataForm.setUpDate" placeholder="成立日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="核准日期" prop="approvalDate">
      <el-date-picker v-model="dataForm.approvalDate" placeholder="核准日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="登记机关" prop="registrationAuthority">
      <el-input v-model="dataForm.registrationAuthority" placeholder="登记机关"></el-input>
    </el-form-item>
    <el-form-item label="企业分类码" prop="enterpriseClassificationCode">
      <el-input v-model="dataForm.enterpriseClassificationCode" placeholder="企业分类码"></el-input>
    </el-form-item>
    <el-form-item label="企业状态" prop="enterpriseState">
      <el-input v-model="dataForm.enterpriseState" placeholder="企业状态"></el-input>
    </el-form-item>
    <el-form-item label="注册资金" prop="registeredCapital">
      <el-input v-model="dataForm.registeredCapital" placeholder="注册资金"></el-input>
    </el-form-item>
    <el-form-item label="经营(业务)范围" prop="operationScope">
      <el-input v-model="dataForm.operationScope" placeholder="经营(业务)范围"></el-input>
    </el-form-item>
    <el-form-item label="经营方式" prop="operationMode">
      <el-input v-model="dataForm.operationMode" placeholder="经营方式"></el-input>
    </el-form-item>
    <el-form-item label="经营范围及方式" prop="operationScopeMode">
      <el-input v-model="dataForm.operationScopeMode" placeholder="经营范围及方式"></el-input>
    </el-form-item>
    <el-form-item label="兼营范围" prop="engagedScope">
      <el-input v-model="dataForm.engagedScope" placeholder="兼营范围"></el-input>
    </el-form-item>
    <el-form-item label="住所所在行政区划" prop="domicileArea">
      <el-input v-model="dataForm.domicileArea" placeholder="住所所在行政区划"></el-input>
    </el-form-item>
    <el-form-item label="住所" prop="domicile">
      <el-input v-model="dataForm.domicile" placeholder="住所"></el-input>
    </el-form-item>
    <el-form-item label="住所所在经济开发区" prop="domicileDevelopZone">
      <el-input v-model="dataForm.domicileDevelopZone" placeholder="住所所在经济开发区"></el-input>
    </el-form-item>
    <el-form-item label="住所产权" prop="houseProperty">
      <el-input v-model="dataForm.houseProperty" placeholder="住所产权"></el-input>
    </el-form-item>
    <el-form-item label="经营场所所在行政区划" prop="premisesArea">
      <el-input v-model="dataForm.premisesArea" placeholder="经营场所所在行政区划"></el-input>
    </el-form-item>
    <el-form-item label="经营场所" prop="premises">
      <el-input v-model="dataForm.premises" placeholder="经营场所"></el-input>
    </el-form-item>
    <el-form-item label="实收资本" prop="paidInCapital">
      <el-input v-model="dataForm.paidInCapital" placeholder="实收资本"></el-input>
    </el-form-item>
    <el-form-item label="设立方式" prop="setUpMode">
      <el-input v-model="dataForm.setUpMode" placeholder="设立方式"></el-input>
    </el-form-item>
    <el-form-item label="合伙人数" prop="partnershipNo">
      <el-input v-model="dataForm.partnershipNo" placeholder="合伙人数"></el-input>
    </el-form-item>
    <el-form-item label="有限合伙人数" prop="partnersLimitedNo">
      <el-input v-model="dataForm.partnersLimitedNo" placeholder="有限合伙人数"></el-input>
    </el-form-item>
    <el-form-item label="合伙方式" prop="partnershipMode">
      <el-input v-model="dataForm.partnershipMode" placeholder="合伙方式"></el-input>
    </el-form-item>
    <el-form-item label="执行人数" prop="performNo">
      <el-input v-model="dataForm.performNo" placeholder="执行人数"></el-input>
    </el-form-item>
    <el-form-item label="从业人数" prop="employeesNo">
      <el-input v-model="dataForm.employeesNo" placeholder="从业人数"></el-input>
    </el-form-item>
    <el-form-item label="出资方式(个独)或组成形式（个体）" prop="contributionMode">
      <el-input v-model="dataForm.contributionMode" placeholder="出资方式(个独)或组成形式（个体）"></el-input>
    </el-form-item>
    <el-form-item label="外资产业代码" prop="foreignIndustryCode">
      <el-input v-model="dataForm.foreignIndustryCode" placeholder="外资产业代码"></el-input>
    </el-form-item>
    <el-form-item label="中西部优势产业代码" prop="midwestIndustrialCode">
      <el-input v-model="dataForm.midwestIndustrialCode" placeholder="中西部优势产业代码"></el-input>
    </el-form-item>
    <el-form-item label="项目类型" prop="projectType">
      <el-input v-model="dataForm.projectType" placeholder="项目类型"></el-input>
    </el-form-item>
    <el-form-item label="投资总额" prop="investmentTotalAmount">
      <el-input v-model="dataForm.investmentTotalAmount" placeholder="投资总额"></el-input>
    </el-form-item>
    <el-form-item label="投资总额币种" prop="investmentTotalAmountCurrency">
      <el-input v-model="dataForm.investmentTotalAmountCurrency" placeholder="投资总额币种"></el-input>
    </el-form-item>
    <el-form-item label="投资总额折万美元" prop="investmentTotalAmountUsd">
      <el-input v-model="dataForm.investmentTotalAmountUsd" placeholder="投资总额折万美元"></el-input>
    </el-form-item>
    <el-form-item label="注册资本(金)折万美元" prop="registeredCapitalUsd">
      <el-input v-model="dataForm.registeredCapitalUsd" placeholder="注册资本(金)折万美元"></el-input>
    </el-form-item>
    <el-form-item label="注册资本(金)币种" prop="registeredCapitalCurrency">
      <el-input v-model="dataForm.registeredCapitalCurrency" placeholder="注册资本(金)币种"></el-input>
    </el-form-item>
    <el-form-item label="注册资本(金)折万人民币" prop="registeredCapitalCny">
      <el-input v-model="dataForm.registeredCapitalCny" placeholder="注册资本(金)折万人民币"></el-input>
    </el-form-item>
    <el-form-item label="外方注册资本(金)币种" prop="foreignRegisteredCapitalCurrency">
      <el-input v-model="dataForm.foreignRegisteredCapitalCurrency" placeholder="外方注册资本(金)币种"></el-input>
    </el-form-item>
    <el-form-item label="外方注册资本(金)折万美元" prop="foreignRegisteredCapitalUsd">
      <el-input v-model="dataForm.foreignRegisteredCapitalUsd" placeholder="外方注册资本(金)折万美元"></el-input>
    </el-form-item>
    <el-form-item label="外方实收资本折万美元" prop="foreignPaidInCapitalUsd">
      <el-input v-model="dataForm.foreignPaidInCapitalUsd" placeholder="外方实收资本折万美元"></el-input>
    </el-form-item>
    <el-form-item label="营运资金" prop="workingCapital">
      <el-input v-model="dataForm.workingCapital" placeholder="营运资金"></el-input>
    </el-form-item>
    <el-form-item label="转型日期" prop="transformationDate">
      <el-date-picker v-model="dataForm.transformationDate" placeholder="转型日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="经营活动类型" prop="businessType">
      <el-input v-model="dataForm.businessType" placeholder="经营活动类型"></el-input>
    </el-form-item>
    <el-form-item label="外国(地区)企业名称" prop="foreignEnterpriseName">
      <el-input v-model="dataForm.foreignEnterpriseName" placeholder="外国(地区)企业名称"></el-input>
    </el-form-item>
    <el-form-item label="主管部门" prop="competentDepartment">
      <el-input v-model="dataForm.competentDepartment" placeholder="主管部门"></el-input>
    </el-form-item>
    <el-form-item label="国别(地区)" prop="country">
      <el-input v-model="dataForm.country" placeholder="国别(地区)"></el-input>
    </el-form-item>
    <el-form-item label="承包工程或经营管理项目" prop="contractProject">
      <el-input v-model="dataForm.contractProject" placeholder="承包工程或经营管理项目"></el-input>
    </el-form-item>
    <el-form-item label="承包工程或经营管理内容" prop="contractProjectRemark">
      <el-input v-model="dataForm.contractProjectRemark" placeholder="承包工程或经营管理内容"></el-input>
    </el-form-item>
    <el-form-item label="境外住所" prop="outsideHouse">
      <el-input v-model="dataForm.outsideHouse" placeholder="境外住所"></el-input>
    </el-form-item>
    <el-form-item label="境外注册资本" prop="overseasRegisteredCapital">
      <el-input v-model="dataForm.overseasRegisteredCapital" placeholder="境外注册资本"></el-input>
    </el-form-item>
    <el-form-item label="境外经营范围" prop="overseasBusinessScope">
      <el-input v-model="dataForm.overseasBusinessScope" placeholder="境外经营范围"></el-input>
    </el-form-item>
    <el-form-item label="企业性质" prop="enterpriseNature">
      <el-input v-model="dataForm.enterpriseNature" placeholder="企业性质"></el-input>
    </el-form-item>
    <el-form-item label="境外主体类型" prop="overseasSubjectType">
      <el-input v-model="dataForm.overseasSubjectType" placeholder="境外主体类型"></el-input>
    </el-form-item>
    <el-form-item label="经营类别" prop="businessCategory">
      <el-input v-model="dataForm.businessCategory" placeholder="经营类别"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="uniformSocialCreditCode">
      <el-input v-model="dataForm.uniformSocialCreditCode" placeholder="统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="隶属企业统一社会信用代码" prop="belongUniformSocialCreditCode">
      <el-input v-model="dataForm.belongUniformSocialCreditCode" placeholder="隶属企业统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="主体身份代码" prop="principalIdentityCode">
      <el-input v-model="dataForm.principalIdentityCode" placeholder="主体身份代码"></el-input>
    </el-form-item>
    
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isFloat, isEmail, isPhone, isMobile, isNumber } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      const validateEmail = function (rule, value, callback) {
        if (!isEmail(value)) {
          callback(new Error('邮箱格式错误'))
        } else {
          callback()
        }
      }
      const validatePhone = function (rule, value, callback) {
        if (!isPhone(value) && !isMobile(value)) {
          callback(new Error('请输入正确的电话格式，如固定号码、区号-固定号码或移动号码'))
        } else {
          callback()
        }
      }
      const validateNumber = function (rule, value, callback) {
        if (!isNumber(value)) {
          callback(new Error('请输入数字'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          enterpriseName: '',
          oriRegisterNo: '',
          registerNo: '',
          enterpriseType: '',
          subjectIdentityCode: '',
          belongEnterpriseName: '',
          belongRegisterNo: '',
          belongRelationship: '',
          industryCategories: '',
          industryCode: '',
          permittedOperatingItems: '',
          generalOperatingItems: '',
          businessPeriodBegin: '',
          businessPeriodEnd: '',
          zipCode: '',
          phone: '',
          email: '',
          belongIndustryCommerceBureau: '',
          creditRating: '',
          classificationDate: '',
          setUpDate: '',
          approvalDate: '',
          registrationAuthority: '',
          enterpriseClassificationCode: '',
          enterpriseState: '',
          registeredCapital: '',
          operationScope: '',
          operationMode: '',
          operationScopeMode: '',
          engagedScope: '',
          domicileArea: '',
          domicile: '',
          domicileDevelopZone: '',
          houseProperty: '',
          premisesArea: '',
          premises: '',
          paidInCapital: '',
          setUpMode: '',
          partnershipNo: '',
          partnersLimitedNo: '',
          partnershipMode: '',
          performNo: '',
          employeesNo: '',
          contributionMode: '',
          foreignIndustryCode: '',
          midwestIndustrialCode: '',
          projectType: '',
          investmentTotalAmount: '',
          investmentTotalAmountCurrency: '',
          investmentTotalAmountUsd: '',
          registeredCapitalUsd: '',
          registeredCapitalCurrency: '',
          registeredCapitalCny: '',
          foreignRegisteredCapitalCurrency: '',
          foreignRegisteredCapitalUsd: '',
          foreignPaidInCapitalUsd: '',
          workingCapital: '',
          transformationDate: '',
          businessType: '',
          foreignEnterpriseName: '',
          competentDepartment: '',
          country: '',
          contractProject: '',
          contractProjectRemark: '',
          outsideHouse: '',
          overseasRegisteredCapital: '',
          overseasBusinessScope: '',
          enterpriseNature: '',
          overseasSubjectType: '',
          businessCategory: '',
          uniformSocialCreditCode: '',
          belongUniformSocialCreditCode: '',
          principalIdentityCode: '',
          createTime: '',
          bprange: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '企业(机构)名称不能为空', trigger: 'blur' }
          ],
          oriRegisterNo: [
            { required: true, message: '原注册号不能为空', trigger: 'blur' }
          ],
          registerNo: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          enterpriseType: [
            { required: true, message: '企业(机构)类型不能为空', trigger: 'blur' }
          ],
          subjectIdentityCode: [
            { required: true, message: '隶属企业主体身份代码不能为空', trigger: 'blur' }
          ],
          belongEnterpriseName: [
            { required: true, message: '隶属企业机构名称不能为空', trigger: 'blur' }
          ],
          belongRegisterNo: [
            { required: true, message: '隶属企业注册号不能为空', trigger: 'blur' }
          ],
          belongRelationship: [
            { required: true, message: '隶属关系不能为空', trigger: 'blur' }
          ],
          industryCategories: [
            { required: true, message: '行业门类不能为空', trigger: 'blur' }
          ],
          industryCode: [
            { required: true, message: '行业代码不能为空', trigger: 'blur' }
          ],
          permittedOperatingItems: [
            { required: true, message: '许可经营项目不能为空', trigger: 'blur' }
          ],
          generalOperatingItems: [
            { required: true, message: '一般经营项目不能为空', trigger: 'blur' }
          ],
          businessPeriodBegin: [
            { required: true, message: '经营(驻在)期限自不能为空', trigger: 'blur' }
          ],
          businessPeriodEnd: [
            { required: true, message: '经营(驻在)期限至不能为空', trigger: 'blur' }
          ],
          zipCode: [
            { required: true, message: '邮政编码不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '联系电话不能为空', trigger: 'blur' },
            { validator: validatePhone, trigger: 'blur' }
          ],
          email: [
            { required: true, message: '电子邮箱不能为空', trigger: 'blur' },
            { validator: validateEmail, trigger: 'blur' }
          ],
          belongIndustryCommerceBureau: [
            { required: true, message: '属地监管工商所不能为空', trigger: 'blur' }
          ],
          creditRating: [
            { required: true, message: '信用等级不能为空', trigger: 'blur' }
          ],
          classificationDate: [
            { required: true, message: '分类日期不能为空', trigger: 'blur' }
          ],
          setUpDate: [
            { required: true, message: '成立日期不能为空', trigger: 'blur' }
          ],
          approvalDate: [
            { required: true, message: '核准日期不能为空', trigger: 'blur' }
          ],
          registrationAuthority: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          enterpriseClassificationCode: [
            { required: true, message: '企业分类码不能为空', trigger: 'blur' }
          ],
          enterpriseState: [
            { required: true, message: '企业状态不能为空', trigger: 'blur' }
          ],
          registeredCapital: [
            { required: true, message: '注册资金不能为空', trigger: 'blur' }
          ],
          operationScope: [
            { required: true, message: '经营(业务)范围不能为空', trigger: 'blur' }
          ],
          operationMode: [
            { required: true, message: '经营方式不能为空', trigger: 'blur' }
          ],
          operationScopeMode: [
            { required: true, message: '经营范围及方式不能为空', trigger: 'blur' }
          ],
          engagedScope: [
            { required: true, message: '兼营范围不能为空', trigger: 'blur' }
          ],
          domicileArea: [
            { required: true, message: '住所所在行政区划不能为空', trigger: 'blur' }
          ],
          domicile: [
            { required: true, message: '住所不能为空', trigger: 'blur' }
          ],
          domicileDevelopZone: [
            { required: true, message: '住所所在经济开发区不能为空', trigger: 'blur' }
          ],
          houseProperty: [
            { required: true, message: '住所产权不能为空', trigger: 'blur' }
          ],
          premisesArea: [
            { required: true, message: '经营场所所在行政区划不能为空', trigger: 'blur' }
          ],
          premises: [
            { required: true, message: '经营场所不能为空', trigger: 'blur' }
          ],
          paidInCapital: [
            { required: true, message: '实收资本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          setUpMode: [
            { required: true, message: '设立方式不能为空', trigger: 'blur' }
          ],
          partnershipNo: [
            { required: true, message: '合伙人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          partnersLimitedNo: [
            { required: true, message: '有限合伙人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          partnershipMode: [
            { required: true, message: '合伙方式不能为空', trigger: 'blur' }
          ],
          performNo: [
            { required: true, message: '执行人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          employeesNo: [
            { required: true, message: '从业人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          contributionMode: [
            { required: true, message: '出资方式(个独)或组成形式（个体）不能为空', trigger: 'blur' }
          ],
          foreignIndustryCode: [
            { required: true, message: '外资产业代码不能为空', trigger: 'blur' }
          ],
          midwestIndustrialCode: [
            { required: true, message: '中西部优势产业代码不能为空', trigger: 'blur' }
          ],
          projectType: [
            { required: true, message: '项目类型不能为空', trigger: 'blur' }
          ],
          investmentTotalAmount: [
            { required: true, message: '投资总额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          investmentTotalAmountCurrency: [
            { required: true, message: '投资总额币种不能为空', trigger: 'blur' }
          ],
          investmentTotalAmountUsd: [
            { required: true, message: '投资总额折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          registeredCapitalUsd: [
            { required: true, message: '注册资本(金)折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          registeredCapitalCurrency: [
            { required: true, message: '注册资本(金)币种不能为空', trigger: 'blur' }
          ],
          registeredCapitalCny: [
            { required: true, message: '注册资本(金)折万人民币不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          foreignRegisteredCapitalCurrency: [
            { required: true, message: '外方注册资本(金)币种不能为空', trigger: 'blur' }
          ],
          foreignRegisteredCapitalUsd: [
            { required: true, message: '外方注册资本(金)折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          foreignPaidInCapitalUsd: [
            { required: true, message: '外方实收资本折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          workingCapital: [
            { required: true, message: '营运资金不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          transformationDate: [
            { required: true, message: '转型日期不能为空', trigger: 'blur' }
          ],
          businessType: [
            { required: true, message: '经营活动类型不能为空', trigger: 'blur' }
          ],
          foreignEnterpriseName: [
            { required: true, message: '外国(地区)企业名称不能为空', trigger: 'blur' }
          ],
          competentDepartment: [
            { required: true, message: '主管部门不能为空', trigger: 'blur' }
          ],
          country: [
            { required: true, message: '国别(地区)不能为空', trigger: 'blur' }
          ],
          contractProject: [
            { required: true, message: '承包工程或经营管理项目不能为空', trigger: 'blur' }
          ],
          contractProjectRemark: [
            { required: true, message: '承包工程或经营管理内容不能为空', trigger: 'blur' }
          ],
          outsideHouse: [
            { required: true, message: '境外住所不能为空', trigger: 'blur' }
          ],
          overseasRegisteredCapital: [
            { required: true, message: '境外注册资本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          overseasBusinessScope: [
            { required: true, message: '境外经营范围不能为空', trigger: 'blur' }
          ],
          enterpriseNature: [
            { required: true, message: '企业性质不能为空', trigger: 'blur' }
          ],
          overseasSubjectType: [
            { required: true, message: '境外主体类型不能为空', trigger: 'blur' }
          ],
          businessCategory: [
            { required: true, message: '经营类别不能为空', trigger: 'blur' }
          ],
          uniformSocialCreditCode: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          belongUniformSocialCreditCode: [
            { required: true, message: '隶属企业统一社会信用代码不能为空', trigger: 'blur' }
          ],
          principalIdentityCode: [
            { required: true, message: '主体身份代码不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/spider/orienterprisebusinessbaseinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.oriEnterpriseBusinessBaseInfo.enterpriseId
                this.dataForm.enterpriseName = data.oriEnterpriseBusinessBaseInfo.enterpriseName
                this.dataForm.oriRegisterNo = data.oriEnterpriseBusinessBaseInfo.oriRegisterNo
                this.dataForm.registerNo = data.oriEnterpriseBusinessBaseInfo.registerNo
                this.dataForm.enterpriseType = data.oriEnterpriseBusinessBaseInfo.enterpriseType
                this.dataForm.subjectIdentityCode = data.oriEnterpriseBusinessBaseInfo.subjectIdentityCode
                this.dataForm.belongEnterpriseName = data.oriEnterpriseBusinessBaseInfo.belongEnterpriseName
                this.dataForm.belongRegisterNo = data.oriEnterpriseBusinessBaseInfo.belongRegisterNo
                this.dataForm.belongRelationship = data.oriEnterpriseBusinessBaseInfo.belongRelationship
                this.dataForm.industryCategories = data.oriEnterpriseBusinessBaseInfo.industryCategories
                this.dataForm.industryCode = data.oriEnterpriseBusinessBaseInfo.industryCode
                this.dataForm.permittedOperatingItems = data.oriEnterpriseBusinessBaseInfo.permittedOperatingItems
                this.dataForm.generalOperatingItems = data.oriEnterpriseBusinessBaseInfo.generalOperatingItems
                this.dataForm.businessPeriodBegin = data.oriEnterpriseBusinessBaseInfo.businessPeriodBegin
                this.dataForm.businessPeriodEnd = data.oriEnterpriseBusinessBaseInfo.businessPeriodEnd
                this.dataForm.zipCode = data.oriEnterpriseBusinessBaseInfo.zipCode
                this.dataForm.phone = data.oriEnterpriseBusinessBaseInfo.phone
                this.dataForm.email = data.oriEnterpriseBusinessBaseInfo.email
                this.dataForm.belongIndustryCommerceBureau = data.oriEnterpriseBusinessBaseInfo.belongIndustryCommerceBureau
                this.dataForm.creditRating = data.oriEnterpriseBusinessBaseInfo.creditRating
                this.dataForm.classificationDate = data.oriEnterpriseBusinessBaseInfo.classificationDate
                this.dataForm.setUpDate = data.oriEnterpriseBusinessBaseInfo.setUpDate
                this.dataForm.approvalDate = data.oriEnterpriseBusinessBaseInfo.approvalDate
                this.dataForm.registrationAuthority = data.oriEnterpriseBusinessBaseInfo.registrationAuthority
                this.dataForm.enterpriseClassificationCode = data.oriEnterpriseBusinessBaseInfo.enterpriseClassificationCode
                this.dataForm.enterpriseState = data.oriEnterpriseBusinessBaseInfo.enterpriseState
                this.dataForm.registeredCapital = data.oriEnterpriseBusinessBaseInfo.registeredCapital
                this.dataForm.operationScope = data.oriEnterpriseBusinessBaseInfo.operationScope
                this.dataForm.operationMode = data.oriEnterpriseBusinessBaseInfo.operationMode
                this.dataForm.operationScopeMode = data.oriEnterpriseBusinessBaseInfo.operationScopeMode
                this.dataForm.engagedScope = data.oriEnterpriseBusinessBaseInfo.engagedScope
                this.dataForm.domicileArea = data.oriEnterpriseBusinessBaseInfo.domicileArea
                this.dataForm.domicile = data.oriEnterpriseBusinessBaseInfo.domicile
                this.dataForm.domicileDevelopZone = data.oriEnterpriseBusinessBaseInfo.domicileDevelopZone
                this.dataForm.houseProperty = data.oriEnterpriseBusinessBaseInfo.houseProperty
                this.dataForm.premisesArea = data.oriEnterpriseBusinessBaseInfo.premisesArea
                this.dataForm.premises = data.oriEnterpriseBusinessBaseInfo.premises
                this.dataForm.paidInCapital = data.oriEnterpriseBusinessBaseInfo.paidInCapital
                this.dataForm.setUpMode = data.oriEnterpriseBusinessBaseInfo.setUpMode
                this.dataForm.partnershipNo = data.oriEnterpriseBusinessBaseInfo.partnershipNo
                this.dataForm.partnersLimitedNo = data.oriEnterpriseBusinessBaseInfo.partnersLimitedNo
                this.dataForm.partnershipMode = data.oriEnterpriseBusinessBaseInfo.partnershipMode
                this.dataForm.performNo = data.oriEnterpriseBusinessBaseInfo.performNo
                this.dataForm.employeesNo = data.oriEnterpriseBusinessBaseInfo.employeesNo
                this.dataForm.contributionMode = data.oriEnterpriseBusinessBaseInfo.contributionMode
                this.dataForm.foreignIndustryCode = data.oriEnterpriseBusinessBaseInfo.foreignIndustryCode
                this.dataForm.midwestIndustrialCode = data.oriEnterpriseBusinessBaseInfo.midwestIndustrialCode
                this.dataForm.projectType = data.oriEnterpriseBusinessBaseInfo.projectType
                this.dataForm.investmentTotalAmount = data.oriEnterpriseBusinessBaseInfo.investmentTotalAmount
                this.dataForm.investmentTotalAmountCurrency = data.oriEnterpriseBusinessBaseInfo.investmentTotalAmountCurrency
                this.dataForm.investmentTotalAmountUsd = data.oriEnterpriseBusinessBaseInfo.investmentTotalAmountUsd
                this.dataForm.registeredCapitalUsd = data.oriEnterpriseBusinessBaseInfo.registeredCapitalUsd
                this.dataForm.registeredCapitalCurrency = data.oriEnterpriseBusinessBaseInfo.registeredCapitalCurrency
                this.dataForm.registeredCapitalCny = data.oriEnterpriseBusinessBaseInfo.registeredCapitalCny
                this.dataForm.foreignRegisteredCapitalCurrency = data.oriEnterpriseBusinessBaseInfo.foreignRegisteredCapitalCurrency
                this.dataForm.foreignRegisteredCapitalUsd = data.oriEnterpriseBusinessBaseInfo.foreignRegisteredCapitalUsd
                this.dataForm.foreignPaidInCapitalUsd = data.oriEnterpriseBusinessBaseInfo.foreignPaidInCapitalUsd
                this.dataForm.workingCapital = data.oriEnterpriseBusinessBaseInfo.workingCapital
                this.dataForm.transformationDate = data.oriEnterpriseBusinessBaseInfo.transformationDate
                this.dataForm.businessType = data.oriEnterpriseBusinessBaseInfo.businessType
                this.dataForm.foreignEnterpriseName = data.oriEnterpriseBusinessBaseInfo.foreignEnterpriseName
                this.dataForm.competentDepartment = data.oriEnterpriseBusinessBaseInfo.competentDepartment
                this.dataForm.country = data.oriEnterpriseBusinessBaseInfo.country
                this.dataForm.contractProject = data.oriEnterpriseBusinessBaseInfo.contractProject
                this.dataForm.contractProjectRemark = data.oriEnterpriseBusinessBaseInfo.contractProjectRemark
                this.dataForm.outsideHouse = data.oriEnterpriseBusinessBaseInfo.outsideHouse
                this.dataForm.overseasRegisteredCapital = data.oriEnterpriseBusinessBaseInfo.overseasRegisteredCapital
                this.dataForm.overseasBusinessScope = data.oriEnterpriseBusinessBaseInfo.overseasBusinessScope
                this.dataForm.enterpriseNature = data.oriEnterpriseBusinessBaseInfo.enterpriseNature
                this.dataForm.overseasSubjectType = data.oriEnterpriseBusinessBaseInfo.overseasSubjectType
                this.dataForm.businessCategory = data.oriEnterpriseBusinessBaseInfo.businessCategory
                this.dataForm.uniformSocialCreditCode = data.oriEnterpriseBusinessBaseInfo.uniformSocialCreditCode
                this.dataForm.belongUniformSocialCreditCode = data.oriEnterpriseBusinessBaseInfo.belongUniformSocialCreditCode
                this.dataForm.principalIdentityCode = data.oriEnterpriseBusinessBaseInfo.principalIdentityCode
                this.dataForm.createTime = data.oriEnterpriseBusinessBaseInfo.createTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/spider/orienterprisebusinessbaseinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'enterpriseName': this.dataForm.enterpriseName,
                'oriRegisterNo': this.dataForm.oriRegisterNo,
                'registerNo': this.dataForm.registerNo,
                'enterpriseType': this.dataForm.enterpriseType,
                'subjectIdentityCode': this.dataForm.subjectIdentityCode,
                'belongEnterpriseName': this.dataForm.belongEnterpriseName,
                'belongRegisterNo': this.dataForm.belongRegisterNo,
                'belongRelationship': this.dataForm.belongRelationship,
                'industryCategories': this.dataForm.industryCategories,
                'industryCode': this.dataForm.industryCode,
                'permittedOperatingItems': this.dataForm.permittedOperatingItems,
                'generalOperatingItems': this.dataForm.generalOperatingItems,
                'businessPeriodBegin': this.dataForm.businessPeriodBegin,
                'businessPeriodEnd': this.dataForm.businessPeriodEnd,
                'zipCode': this.dataForm.zipCode,
                'phone': this.dataForm.phone,
                'email': this.dataForm.email,
                'belongIndustryCommerceBureau': this.dataForm.belongIndustryCommerceBureau,
                'creditRating': this.dataForm.creditRating,
                'classificationDate': this.dataForm.classificationDate,
                'setUpDate': this.dataForm.setUpDate,
                'approvalDate': this.dataForm.approvalDate,
                'registrationAuthority': this.dataForm.registrationAuthority,
                'enterpriseClassificationCode': this.dataForm.enterpriseClassificationCode,
                'enterpriseState': this.dataForm.enterpriseState,
                'registeredCapital': this.dataForm.registeredCapital,
                'operationScope': this.dataForm.operationScope,
                'operationMode': this.dataForm.operationMode,
                'operationScopeMode': this.dataForm.operationScopeMode,
                'engagedScope': this.dataForm.engagedScope,
                'domicileArea': this.dataForm.domicileArea,
                'domicile': this.dataForm.domicile,
                'domicileDevelopZone': this.dataForm.domicileDevelopZone,
                'houseProperty': this.dataForm.houseProperty,
                'premisesArea': this.dataForm.premisesArea,
                'premises': this.dataForm.premises,
                'paidInCapital': this.dataForm.paidInCapital,
                'setUpMode': this.dataForm.setUpMode,
                'partnershipNo': this.dataForm.partnershipNo,
                'partnersLimitedNo': this.dataForm.partnersLimitedNo,
                'partnershipMode': this.dataForm.partnershipMode,
                'performNo': this.dataForm.performNo,
                'employeesNo': this.dataForm.employeesNo,
                'contributionMode': this.dataForm.contributionMode,
                'foreignIndustryCode': this.dataForm.foreignIndustryCode,
                'midwestIndustrialCode': this.dataForm.midwestIndustrialCode,
                'projectType': this.dataForm.projectType,
                'investmentTotalAmount': this.dataForm.investmentTotalAmount,
                'investmentTotalAmountCurrency': this.dataForm.investmentTotalAmountCurrency,
                'investmentTotalAmountUsd': this.dataForm.investmentTotalAmountUsd,
                'registeredCapitalUsd': this.dataForm.registeredCapitalUsd,
                'registeredCapitalCurrency': this.dataForm.registeredCapitalCurrency,
                'registeredCapitalCny': this.dataForm.registeredCapitalCny,
                'foreignRegisteredCapitalCurrency': this.dataForm.foreignRegisteredCapitalCurrency,
                'foreignRegisteredCapitalUsd': this.dataForm.foreignRegisteredCapitalUsd,
                'foreignPaidInCapitalUsd': this.dataForm.foreignPaidInCapitalUsd,
                'workingCapital': this.dataForm.workingCapital,
                'transformationDate': this.dataForm.transformationDate,
                'businessType': this.dataForm.businessType,
                'foreignEnterpriseName': this.dataForm.foreignEnterpriseName,
                'competentDepartment': this.dataForm.competentDepartment,
                'country': this.dataForm.country,
                'contractProject': this.dataForm.contractProject,
                'contractProjectRemark': this.dataForm.contractProjectRemark,
                'outsideHouse': this.dataForm.outsideHouse,
                'overseasRegisteredCapital': this.dataForm.overseasRegisteredCapital,
                'overseasBusinessScope': this.dataForm.overseasBusinessScope,
                'enterpriseNature': this.dataForm.enterpriseNature,
                'overseasSubjectType': this.dataForm.overseasSubjectType,
                'businessCategory': this.dataForm.businessCategory,
                'uniformSocialCreditCode': this.dataForm.uniformSocialCreditCode,
                'belongUniformSocialCreditCode': this.dataForm.belongUniformSocialCreditCode,
                'principalIdentityCode': this.dataForm.principalIdentityCode,
                'createTime': this.dataForm.createTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
