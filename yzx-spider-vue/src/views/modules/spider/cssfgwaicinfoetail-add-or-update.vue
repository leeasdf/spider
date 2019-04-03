<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
    <el-form-item label="数据状态" prop="isinvalid">
      <el-radio-group v-model="dataForm.isinvalid">
        <el-radio :label="0">正常</el-radio>
        <el-radio :label="1">更新</el-radio>
        <el-radio :label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="数据最后修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item>
    <el-form-item label="企业(机构)名称" prop="entname">
      <el-input v-model="dataForm.entname" placeholder="企业(机构)名称"></el-input>
    </el-form-item>
    <el-form-item label="原注册号" prop="oriregno">
      <el-input v-model="dataForm.oriregno" placeholder="原注册号"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="regno">
      <el-input v-model="dataForm.regno" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="企业(机构)类型" prop="enttype">
      <el-input v-model="dataForm.enttype" placeholder="企业(机构)类型"></el-input>
    </el-form-item>
    <el-form-item label="隶属企业主体身份代码" prop="ppripid">
      <el-input v-model="dataForm.ppripid" placeholder="隶属企业主体身份代码"></el-input>
    </el-form-item>
    <el-form-item label="隶属企业机构名称" prop="pentname">
      <el-input v-model="dataForm.pentname" placeholder="隶属企业机构名称"></el-input>
    </el-form-item>
    <el-form-item label="隶属企业注册号" prop="pregno">
      <el-input v-model="dataForm.pregno" placeholder="隶属企业注册号"></el-input>
    </el-form-item>
    <el-form-item label="隶属关系" prop="hypotaxis">
      <el-input v-model="dataForm.hypotaxis" placeholder="隶属关系"></el-input>
    </el-form-item>
    <el-form-item label="行业门类" prop="industryphy">
      <el-input v-model="dataForm.industryphy" placeholder="行业门类"></el-input>
    </el-form-item>
    <el-form-item label="行业代码" prop="industryco">
      <el-input v-model="dataForm.industryco" placeholder="行业代码"></el-input>
    </el-form-item>
    <el-form-item label="许可经营项目" prop="abuitem">
      <el-input v-model="dataForm.abuitem" placeholder="许可经营项目"></el-input>
    </el-form-item>
    <el-form-item label="一般经营项目" prop="cbuitem">
      <el-input v-model="dataForm.cbuitem" placeholder="一般经营项目"></el-input>
    </el-form-item>
    <el-form-item label="经营(驻在)期限" prop="oprange">
      <el-date-picker type="daterange" v-model="dataForm.oprange" placeholder="经营(驻在)期限" value-format="yyyy-MM-dd"range-separator="至"></el-date-picker>
    </el-form-item>
    <el-form-item label="邮政编码" prop="postalcode">
      <el-input v-model="dataForm.postalcode" placeholder="邮政编码"></el-input>
    </el-form-item>
    <el-form-item label="联系电话" prop="tel">
      <el-input v-model="dataForm.tel" placeholder="联系电话"></el-input>
    </el-form-item>
    <el-form-item label="电子邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="电子邮箱"></el-input>
    </el-form-item>
    <el-form-item label="属地监管工商所" prop="localadm">
      <el-input v-model="dataForm.localadm" placeholder="属地监管工商所"></el-input>
    </el-form-item>
    <el-form-item label="信用等级" prop="credlevel">
      <el-input v-model="dataForm.credlevel" placeholder="信用等级"></el-input>
    </el-form-item>
    <el-form-item label="分类日期" prop="assdate">
      <el-date-picker v-model="dataForm.assdate" value-format="yyyy-MM-dd" placeholder="分类日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="成立日期" prop="estdate">
      <el-date-picker v-model="dataForm.estdate" value-format="yyyy-MM-dd" placeholder="成立日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="核准日期" prop="issblicdate">
      <el-date-picker v-model="dataForm.issblicdate" placeholder="核准日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="登记机关" prop="regorg">
      <el-input v-model="dataForm.regorg" placeholder="登记机关"></el-input>
    </el-form-item>
    <el-form-item label="企业分类码" prop="entcat">
      <el-input v-model="dataForm.entcat" placeholder="企业分类码"></el-input>
    </el-form-item>
    <el-form-item label="企业状态" prop="opstate">
      <el-input v-model="dataForm.opstate" placeholder="企业状态"></el-input>
    </el-form-item>
    <el-form-item label="注册资金" prop="regcap">
      <el-input v-model="dataForm.regcap" placeholder="注册资金"></el-input>
    </el-form-item>
    <el-form-item label="经营(业务)范围" prop="opscope">
      <el-input type="textarea" :autosize="{ minRows:1, maxRows:4 }" v-model="dataForm.opscope" placeholder="经营(业务)范围"></el-input>
    </el-form-item>
    <el-form-item label="经营方式" prop="opform">
      <el-input type="textarea" :autosize="{ minRows:1, maxRows:4 }" v-model="dataForm.opform" placeholder="经营方式"></el-input>
    </el-form-item>
    <el-form-item label="经营范围及方式" prop="opscoandform">
      <el-input v-model="dataForm.opscoandform" placeholder="经营范围及方式"></el-input>
    </el-form-item>
    <el-form-item label="兼营范围" prop="ptbusscope">
      <el-input v-model="dataForm.ptbusscope" placeholder="兼营范围"></el-input>
    </el-form-item>
    <el-form-item label="住所所在行政区划" prop="domdistrict">
      <el-input v-model="dataForm.domdistrict" placeholder="住所所在行政区划"></el-input>
    </el-form-item>
    <el-form-item label="住所" prop="dom">
      <el-input v-model="dataForm.dom" placeholder="住所"></el-input>
    </el-form-item>
    <el-form-item label="住所所在经济开发区" prop="ecotecdevzone">
      <el-input v-model="dataForm.ecotecdevzone" placeholder="住所所在经济开发区"></el-input>
    </el-form-item>
    <el-form-item label="住所产权" prop="domproright">
      <el-input v-model="dataForm.domproright" placeholder="住所产权"></el-input>
    </el-form-item>
    <el-form-item label="经营场所所在行政区划" prop="oplocdistrict">
      <el-input v-model="dataForm.oplocdistrict" placeholder="经营场所所在行政区划"></el-input>
    </el-form-item>
    <el-form-item label="经营场所" prop="promana">
      <el-input v-model="dataForm.promana" placeholder="经营场所"></el-input>
    </el-form-item>
    <el-form-item label="实收资本" prop="reccap">
      <el-input v-model="dataForm.reccap" placeholder="实收资本"></el-input>
    </el-form-item>
    <el-form-item label="设立方式" prop="insform">
      <el-input v-model="dataForm.insform" placeholder="设立方式"></el-input>
    </el-form-item>
    <el-form-item label="合伙人数" prop="parnum">
      <el-input v-model="dataForm.parnum" placeholder="合伙人数"></el-input>
    </el-form-item>
    <el-form-item label="有限合伙人数" prop="limparnum">
      <el-input v-model="dataForm.limparnum" placeholder="有限合伙人数"></el-input>
    </el-form-item>
    <el-form-item label="合伙方式" prop="parform">
      <el-input v-model="dataForm.parform" placeholder="合伙方式"></el-input>
    </el-form-item>
    <el-form-item label="执行人数" prop="exenum">
      <el-input v-model="dataForm.exenum" placeholder="执行人数"></el-input>
    </el-form-item>
    <el-form-item label="从业人数" prop="empnum">
      <el-input v-model="dataForm.empnum" placeholder="从业人数"></el-input>
    </el-form-item>
    <el-form-item label="出资方式(个独)或组成形式（个体）" prop="sconform">
      <el-input v-model="dataForm.sconform" placeholder="出资方式(个独)或组成形式（个体）"></el-input>
    </el-form-item>
    <el-form-item label="外资产业代码" prop="forcapindcode">
      <el-input v-model="dataForm.forcapindcode" placeholder="外资产业代码"></el-input>
    </el-form-item>
    <el-form-item label="中西部优势产业代码" prop="midpreindcode">
      <el-input v-model="dataForm.midpreindcode" placeholder="中西部优势产业代码"></el-input>
    </el-form-item>
    <el-form-item label="项目类型" prop="protype">
      <el-input v-model="dataForm.protype" placeholder="项目类型"></el-input>
    </el-form-item>
    <el-form-item label="投资总额" prop="congro">
      <el-input v-model="dataForm.congro" placeholder="投资总额"></el-input>
    </el-form-item>
    <el-form-item label="投资总额币种" prop="congrocur">
      <el-input v-model="dataForm.congrocur" placeholder="投资总额币种"></el-input>
    </el-form-item>
    <el-form-item label="投资总额折万美元" prop="congrousd">
      <el-input v-model="dataForm.congrousd" placeholder="投资总额折万美元"></el-input>
    </el-form-item>
    <el-form-item label="注册资本(金)折万美元" prop="regcapusd">
      <el-input v-model="dataForm.regcapusd" placeholder="注册资本(金)折万美元"></el-input>
    </el-form-item>
    <el-form-item label="注册资本(金)币种" prop="regcapcur">
      <el-input v-model="dataForm.regcapcur" placeholder="注册资本(金)币种"></el-input>
    </el-form-item>
    <el-form-item label="注册资本(金)折万人民币" prop="regcaprmb">
      <el-input v-model="dataForm.regcaprmb" placeholder="注册资本(金)折万人民币"></el-input>
    </el-form-item>
    <el-form-item label="外方注册资本(金)币种" prop="forregcapcur">
      <el-input v-model="dataForm.forregcapcur" placeholder="外方注册资本(金)币种"></el-input>
    </el-form-item>
    <el-form-item label="外方注册资本(金)折万美元" prop="forregcapusd">
      <el-input v-model="dataForm.forregcapusd" placeholder="外方注册资本(金)折万美元"></el-input>
    </el-form-item>
    <el-form-item label="外方实收资本折万美元" prop="forreccapusd">
      <el-input v-model="dataForm.forreccapusd" placeholder="外方实收资本折万美元"></el-input>
    </el-form-item>
    <el-form-item label="营运资金" prop="worcap">
      <el-input v-model="dataForm.worcap" placeholder="营运资金"></el-input>
    </el-form-item>
    <el-form-item label="转型日期" prop="chamecdate">
      <el-date-picker v-model="dataForm.chamecdate" placeholder="转型日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="经营活动类型" prop="opracttype">
      <el-input v-model="dataForm.opracttype" placeholder="经营活动类型"></el-input>
    </el-form-item>
    <el-form-item label="外国(地区)企业名称" prop="forentname">
      <el-input v-model="dataForm.forentname" placeholder="外国(地区)企业名称"></el-input>
    </el-form-item>
    <el-form-item label="主管部门" prop="depincha">
      <el-input v-model="dataForm.depincha" placeholder="主管部门"></el-input>
    </el-form-item>
    <el-form-item label="国别(地区)" prop="country">
      <el-input v-model="dataForm.country" placeholder="国别(地区)"></el-input>
    </el-form-item>
    <el-form-item label="承包工程或经营管理项目" prop="itemofoporcpro">
      <el-input v-model="dataForm.itemofoporcpro" placeholder="承包工程或经营管理项目"></el-input>
    </el-form-item>
    <el-form-item label="承包工程或经营管理内容" prop="conofcontrpro">
      <el-input v-model="dataForm.conofcontrpro" placeholder="承包工程或经营管理内容"></el-input>
    </el-form-item>
    <el-form-item label="境外住所" prop="fordom">
      <el-input v-model="dataForm.fordom" placeholder="境外住所"></el-input>
    </el-form-item>
    <el-form-item label="境外注册资本" prop="forregecap">
      <el-input v-model="dataForm.forregecap" placeholder="境外注册资本"></el-input>
    </el-form-item>
    <el-form-item label="境外经营范围" prop="foropscope">
      <el-input v-model="dataForm.foropscope" placeholder="境外经营范围"></el-input>
    </el-form-item>
    <el-form-item label="企业性质" prop="sExtEntproperty">
      <el-input v-model="dataForm.sExtEntproperty" placeholder="企业性质"></el-input>
    </el-form-item>
    <el-form-item label="境外主体类型" prop="foreignbodytype">
      <el-input v-model="dataForm.foreignbodytype" placeholder="境外主体类型"></el-input>
    </el-form-item>
    <el-form-item label="经营类别" prop="manacate">
      <el-input v-model="dataForm.manacate" placeholder="经营类别"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="uscc">
      <el-input v-model="dataForm.uscc" placeholder="统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="" prop="puniscid">
      <el-input v-model="dataForm.puniscid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="主体身份代码" prop="etpsId">
      <el-input v-model="dataForm.etpsId" placeholder="主体身份代码"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isFloat, isNumber, isEmail, isPhone, isMobile } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
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
      return {
        visible: false,
        dataForm: {
          isinvalid: '',
          lastdate: '',
          entname: '',
          oriregno: '',
          regno: '',
          enttype: '',
          ppripid: '',
          pentname: '',
          pregno: '',
          hypotaxis: '',
          industryphy: '',
          industryco: '',
          abuitem: '',
          cbuitem: '',
          opfrom: '',
          opto: '',
          postalcode: '',
          tel: '',
          email: '',
          localadm: '',
          credlevel: '',
          assdate: '',
          estdate: '',
          issblicdate: '',
          regorg: '',
          entcat: '',
          opstate: '',
          regcap: '',
          opscope: '',
          opform: '',
          opscoandform: '',
          ptbusscope: '',
          domdistrict: '',
          dom: '',
          ecotecdevzone: '',
          domproright: '',
          oplocdistrict: '',
          promana: '',
          reccap: '',
          insform: '',
          parnum: '',
          limparnum: '',
          parform: '',
          exenum: '',
          empnum: '',
          sconform: '',
          forcapindcode: '',
          midpreindcode: '',
          protype: '',
          congro: '',
          congrocur: '',
          congrousd: '',
          regcapusd: '',
          regcapcur: '',
          regcaprmb: '',
          forregcapcur: '',
          forregcapusd: '',
          forreccapusd: '',
          worcap: '',
          chamecdate: '',
          opracttype: '',
          forentname: '',
          depincha: '',
          country: '',
          itemofoporcpro: '',
          conofcontrpro: '',
          fordom: '',
          forregecap: '',
          foropscope: '',
          sExtEntproperty: '',
          foreignbodytype: '',
          manacate: '',
          uscc: '',
          puniscid: '',
          etpsId: '',
          zjid: 0,
          oprange: ''
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          entname: [
            { required: true, message: '企业(机构)名称不能为空', trigger: 'blur' }
          ],
          oriregno: [
            { required: true, message: '原注册号不能为空', trigger: 'blur' }
          ],
          regno: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          enttype: [
            { required: true, message: '企业(机构)类型不能为空', trigger: 'blur' }
          ],
          ppripid: [
            { required: true, message: '隶属企业主体身份代码不能为空', trigger: 'blur' }
          ],
          pentname: [
            { required: true, message: '隶属企业机构名称不能为空', trigger: 'blur' }
          ],
          pregno: [
            { required: true, message: '隶属企业注册号不能为空', trigger: 'blur' }
          ],
          hypotaxis: [
            { required: true, message: '隶属关系不能为空', trigger: 'blur' }
          ],
          industryphy: [
            { required: true, message: '行业门类不能为空', trigger: 'blur' }
          ],
          industryco: [
            { required: true, message: '行业代码不能为空', trigger: 'blur' }
          ],
          abuitem: [
            { required: true, message: '许可经营项目不能为空', trigger: 'blur' }
          ],
          cbuitem: [
            { required: true, message: '一般经营项目不能为空', trigger: 'blur' }
          ],
          oprange: [
            { required: true, message: '经营(驻在)期限不能为空', trigger: ['blur', 'change'] }
          ],
          postalcode: [
            { required: true, message: '邮政编码不能为空', trigger: 'blur' }
          ],
          tel: [
            { required: true, message: '联系电话不能为空', trigger: 'blur' },
            { validator: validatePhone, trigger: 'blur' }
          ],
          email: [
            { required: true, message: '电子邮箱不能为空', trigger: 'blur' },
            { validator: validateEmail, trigger: 'blur' }
          ],
          localadm: [
            { required: true, message: '属地监管工商所不能为空', trigger: 'blur' }
          ],
          credlevel: [
            { required: true, message: '信用等级不能为空', trigger: 'blur' }
          ],
          assdate: [
            { required: true, message: '分类日期不能为空', trigger: 'blur' }
          ],
          estdate: [
            { required: true, message: '成立日期不能为空', trigger: 'blur' }
          ],
          issblicdate: [
            { required: true, message: '核准日期不能为空', trigger: 'blur' }
          ],
          regorg: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          entcat: [
            { required: true, message: '企业分类码不能为空', trigger: 'blur' }
          ],
          opstate: [
            { required: true, message: '企业状态不能为空', trigger: 'blur' }
          ],
          regcap: [
            { required: true, message: '注册资金不能为空', trigger: 'blur' }
          ],
          opscope: [
            { required: true, message: '经营(业务)范围不能为空', trigger: 'blur' }
          ],
          opform: [
            { required: true, message: '经营方式不能为空', trigger: 'blur' }
          ],
          opscoandform: [
            { required: true, message: '经营范围及方式不能为空', trigger: 'blur' }
          ],
          ptbusscope: [
            { required: true, message: '兼营范围不能为空', trigger: 'blur' }
          ],
          domdistrict: [
            { required: true, message: '住所所在行政区划不能为空', trigger: 'blur' }
          ],
          dom: [
            { required: true, message: '住所不能为空', trigger: 'blur' }
          ],
          ecotecdevzone: [
            { required: true, message: '住所所在经济开发区不能为空', trigger: 'blur' }
          ],
          domproright: [
            { required: true, message: '住所产权不能为空', trigger: 'blur' }
          ],
          oplocdistrict: [
            { required: true, message: '经营场所所在行政区划不能为空', trigger: 'blur' }
          ],
          promana: [
            { required: true, message: '经营场所不能为空', trigger: 'blur' }
          ],
          reccap: [
            { required: true, message: '实收资本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          insform: [
            { required: true, message: '设立方式不能为空', trigger: 'blur' }
          ],
          parnum: [
            { required: true, message: '合伙人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          limparnum: [
            { required: true, message: '有限合伙人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          parform: [
            { required: true, message: '合伙方式不能为空', trigger: 'blur' }
          ],
          exenum: [
            { required: true, message: '执行人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          empnum: [
            { required: true, message: '从业人数不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          sconform: [
            { required: true, message: '出资方式(个独)或组成形式（个体）不能为空', trigger: 'blur' }
          ],
          forcapindcode: [
            { required: true, message: '外资产业代码不能为空', trigger: 'blur' }
          ],
          midpreindcode: [
            { required: true, message: '中西部优势产业代码不能为空', trigger: 'blur' }
          ],
          protype: [
            { required: true, message: '项目类型不能为空', trigger: 'blur' }
          ],
          congro: [
            { required: true, message: '投资总额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          congrocur: [
            { required: true, message: '投资总额币种不能为空', trigger: 'blur' }
          ],
          congrousd: [
            { required: true, message: '投资总额折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          regcapusd: [
            { required: true, message: '注册资本(金)折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          regcapcur: [
            { required: true, message: '注册资本(金)币种不能为空', trigger: 'blur' }
          ],
          regcaprmb: [
            { required: true, message: '注册资本(金)折万人民币不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          forregcapcur: [
            { required: true, message: '外方注册资本(金)币种不能为空', trigger: 'blur' }
          ],
          forregcapusd: [
            { required: true, message: '外方注册资本(金)折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          forreccapusd: [
            { required: true, message: '外方实收资本折万美元不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          worcap: [
            { required: true, message: '营运资金不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          chamecdate: [
            { required: true, message: '转型日期不能为空', trigger: 'blur' }
          ],
          opracttype: [
            { required: true, message: '经营活动类型不能为空', trigger: 'blur' }
          ],
          forentname: [
            { required: true, message: '外国(地区)企业名称不能为空', trigger: 'blur' }
          ],
          depincha: [
            { required: true, message: '主管部门不能为空', trigger: 'blur' }
          ],
          country: [
            { required: true, message: '国别(地区)不能为空', trigger: 'blur' }
          ],
          itemofoporcpro: [
            { required: true, message: '承包工程或经营管理项目不能为空', trigger: 'blur' }
          ],
          conofcontrpro: [
            { required: true, message: '承包工程或经营管理内容不能为空', trigger: 'blur' }
          ],
          fordom: [
            { required: true, message: '境外住所不能为空', trigger: 'blur' }
          ],
          forregecap: [
            { required: true, message: '境外注册资本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          foropscope: [
            { required: true, message: '境外经营范围不能为空', trigger: 'blur' }
          ],
          sExtEntproperty: [
            { required: true, message: '企业性质不能为空', trigger: 'blur' }
          ],
          foreignbodytype: [
            { required: true, message: '境外主体类型不能为空', trigger: 'blur' }
          ],
          manacate: [
            { required: true, message: '经营类别不能为空', trigger: 'blur' }
          ],
          uscc: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          puniscid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          etpsId: [
            { required: true, message: '主体身份代码不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.zjid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.zjid) {
            this.$http({
              url: this.$http.adornUrl(`/spider/cssfgwaicinfoetail/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwAicInfoetail.isinvalid
                this.dataForm.lastdate = data.csSfgwAicInfoetail.lastdate
                this.dataForm.entname = data.csSfgwAicInfoetail.entname
                this.dataForm.oriregno = data.csSfgwAicInfoetail.oriregno
                this.dataForm.regno = data.csSfgwAicInfoetail.regno
                this.dataForm.enttype = data.csSfgwAicInfoetail.enttype
                this.dataForm.ppripid = data.csSfgwAicInfoetail.ppripid
                this.dataForm.pentname = data.csSfgwAicInfoetail.pentname
                this.dataForm.pregno = data.csSfgwAicInfoetail.pregno
                this.dataForm.hypotaxis = data.csSfgwAicInfoetail.hypotaxis
                this.dataForm.industryphy = data.csSfgwAicInfoetail.industryphy
                this.dataForm.industryco = data.csSfgwAicInfoetail.industryco
                this.dataForm.abuitem = data.csSfgwAicInfoetail.abuitem
                this.dataForm.cbuitem = data.csSfgwAicInfoetail.cbuitem
                this.dataForm.opfrom = data.csSfgwAicInfoetail.opfrom
                this.dataForm.opto = data.csSfgwAicInfoetail.opto
                this.dataForm.postalcode = data.csSfgwAicInfoetail.postalcode
                this.dataForm.tel = data.csSfgwAicInfoetail.tel
                this.dataForm.email = data.csSfgwAicInfoetail.email
                this.dataForm.localadm = data.csSfgwAicInfoetail.localadm
                this.dataForm.credlevel = data.csSfgwAicInfoetail.credlevel
                this.dataForm.assdate = data.csSfgwAicInfoetail.assdate
                this.dataForm.estdate = data.csSfgwAicInfoetail.estdate
                this.dataForm.issblicdate = data.csSfgwAicInfoetail.issblicdate
                this.dataForm.regorg = data.csSfgwAicInfoetail.regorg
                this.dataForm.entcat = data.csSfgwAicInfoetail.entcat
                this.dataForm.opstate = data.csSfgwAicInfoetail.opstate
                this.dataForm.regcap = data.csSfgwAicInfoetail.regcap
                this.dataForm.opscope = data.csSfgwAicInfoetail.opscope
                this.dataForm.opform = data.csSfgwAicInfoetail.opform
                this.dataForm.opscoandform = data.csSfgwAicInfoetail.opscoandform
                this.dataForm.ptbusscope = data.csSfgwAicInfoetail.ptbusscope
                this.dataForm.domdistrict = data.csSfgwAicInfoetail.domdistrict
                this.dataForm.dom = data.csSfgwAicInfoetail.dom
                this.dataForm.ecotecdevzone = data.csSfgwAicInfoetail.ecotecdevzone
                this.dataForm.domproright = data.csSfgwAicInfoetail.domproright
                this.dataForm.oplocdistrict = data.csSfgwAicInfoetail.oplocdistrict
                this.dataForm.promana = data.csSfgwAicInfoetail.promana
                this.dataForm.reccap = data.csSfgwAicInfoetail.reccap
                this.dataForm.insform = data.csSfgwAicInfoetail.insform
                this.dataForm.parnum = data.csSfgwAicInfoetail.parnum
                this.dataForm.limparnum = data.csSfgwAicInfoetail.limparnum
                this.dataForm.parform = data.csSfgwAicInfoetail.parform
                this.dataForm.exenum = data.csSfgwAicInfoetail.exenum
                this.dataForm.empnum = data.csSfgwAicInfoetail.empnum
                this.dataForm.sconform = data.csSfgwAicInfoetail.sconform
                this.dataForm.forcapindcode = data.csSfgwAicInfoetail.forcapindcode
                this.dataForm.midpreindcode = data.csSfgwAicInfoetail.midpreindcode
                this.dataForm.protype = data.csSfgwAicInfoetail.protype
                this.dataForm.congro = data.csSfgwAicInfoetail.congro
                this.dataForm.congrocur = data.csSfgwAicInfoetail.congrocur
                this.dataForm.congrousd = data.csSfgwAicInfoetail.congrousd
                this.dataForm.regcapusd = data.csSfgwAicInfoetail.regcapusd
                this.dataForm.regcapcur = data.csSfgwAicInfoetail.regcapcur
                this.dataForm.regcaprmb = data.csSfgwAicInfoetail.regcaprmb
                this.dataForm.forregcapcur = data.csSfgwAicInfoetail.forregcapcur
                this.dataForm.forregcapusd = data.csSfgwAicInfoetail.forregcapusd
                this.dataForm.forreccapusd = data.csSfgwAicInfoetail.forreccapusd
                this.dataForm.worcap = data.csSfgwAicInfoetail.worcap
                this.dataForm.chamecdate = data.csSfgwAicInfoetail.chamecdate
                this.dataForm.opracttype = data.csSfgwAicInfoetail.opracttype
                this.dataForm.forentname = data.csSfgwAicInfoetail.forentname
                this.dataForm.depincha = data.csSfgwAicInfoetail.depincha
                this.dataForm.country = data.csSfgwAicInfoetail.country
                this.dataForm.itemofoporcpro = data.csSfgwAicInfoetail.itemofoporcpro
                this.dataForm.conofcontrpro = data.csSfgwAicInfoetail.conofcontrpro
                this.dataForm.fordom = data.csSfgwAicInfoetail.fordom
                this.dataForm.forregecap = data.csSfgwAicInfoetail.forregecap
                this.dataForm.foropscope = data.csSfgwAicInfoetail.foropscope
                this.dataForm.sExtEntproperty = data.csSfgwAicInfoetail.sExtEntproperty
                this.dataForm.foreignbodytype = data.csSfgwAicInfoetail.foreignbodytype
                this.dataForm.manacate = data.csSfgwAicInfoetail.manacate
                this.dataForm.uscc = data.csSfgwAicInfoetail.uscc
                this.dataForm.puniscid = data.csSfgwAicInfoetail.puniscid
                this.dataForm.etpsId = data.csSfgwAicInfoetail.etpsId
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
              url: this.$http.adornUrl(`/spider/cssfgwaicinfoetail/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'entname': this.dataForm.entname,
                'oriregno': this.dataForm.oriregno,
                'regno': this.dataForm.regno,
                'enttype': this.dataForm.enttype,
                'ppripid': this.dataForm.ppripid,
                'pentname': this.dataForm.pentname,
                'pregno': this.dataForm.pregno,
                'hypotaxis': this.dataForm.hypotaxis,
                'industryphy': this.dataForm.industryphy,
                'industryco': this.dataForm.industryco,
                'abuitem': this.dataForm.abuitem,
                'cbuitem': this.dataForm.cbuitem,
                'opfrom': this.dataForm.opfrom,
                'opto': this.dataForm.opto,
                'postalcode': this.dataForm.postalcode,
                'tel': this.dataForm.tel,
                'email': this.dataForm.email,
                'localadm': this.dataForm.localadm,
                'credlevel': this.dataForm.credlevel,
                'assdate': this.dataForm.assdate,
                'estdate': this.dataForm.estdate,
                'issblicdate': this.dataForm.issblicdate,
                'regorg': this.dataForm.regorg,
                'entcat': this.dataForm.entcat,
                'opstate': this.dataForm.opstate,
                'regcap': this.dataForm.regcap,
                'opscope': this.dataForm.opscope,
                'opform': this.dataForm.opform,
                'opscoandform': this.dataForm.opscoandform,
                'ptbusscope': this.dataForm.ptbusscope,
                'domdistrict': this.dataForm.domdistrict,
                'dom': this.dataForm.dom,
                'ecotecdevzone': this.dataForm.ecotecdevzone,
                'domproright': this.dataForm.domproright,
                'oplocdistrict': this.dataForm.oplocdistrict,
                'promana': this.dataForm.promana,
                'reccap': this.dataForm.reccap,
                'insform': this.dataForm.insform,
                'parnum': this.dataForm.parnum,
                'limparnum': this.dataForm.limparnum,
                'parform': this.dataForm.parform,
                'exenum': this.dataForm.exenum,
                'empnum': this.dataForm.empnum,
                'sconform': this.dataForm.sconform,
                'forcapindcode': this.dataForm.forcapindcode,
                'midpreindcode': this.dataForm.midpreindcode,
                'protype': this.dataForm.protype,
                'congro': this.dataForm.congro,
                'congrocur': this.dataForm.congrocur,
                'congrousd': this.dataForm.congrousd,
                'regcapusd': this.dataForm.regcapusd,
                'regcapcur': this.dataForm.regcapcur,
                'regcaprmb': this.dataForm.regcaprmb,
                'forregcapcur': this.dataForm.forregcapcur,
                'forregcapusd': this.dataForm.forregcapusd,
                'forreccapusd': this.dataForm.forreccapusd,
                'worcap': this.dataForm.worcap,
                'chamecdate': this.dataForm.chamecdate,
                'opracttype': this.dataForm.opracttype,
                'forentname': this.dataForm.forentname,
                'depincha': this.dataForm.depincha,
                'country': this.dataForm.country,
                'itemofoporcpro': this.dataForm.itemofoporcpro,
                'conofcontrpro': this.dataForm.conofcontrpro,
                'fordom': this.dataForm.fordom,
                'forregecap': this.dataForm.forregecap,
                'foropscope': this.dataForm.foropscope,
                'sExtEntproperty': this.dataForm.sExtEntproperty,
                'foreignbodytype': this.dataForm.foreignbodytype,
                'manacate': this.dataForm.manacate,
                'uscc': this.dataForm.uscc,
                'puniscid': this.dataForm.puniscid,
                'etpsId': this.dataForm.etpsId,
                'zjid': this.dataForm.zjid || undefined
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
    },
    watch: {
      'dataForm.oprange' (val) {
        if (this.dataForm.oprange.length > 0) {
          this.dataForm.opform = this.dataForm.oprange[0]
          this.dataForm.opto = this.dataForm.oprange[1]
        } else {
          this.dataForm.opform = ''
          this.dataForm.opto = ''
        }
      }
    }
  }
</script>
