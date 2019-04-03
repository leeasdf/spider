<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="210px">
    <el-form-item label="纳税人名称" prop="company">
      <el-input v-model="dataForm.company" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="纳税人识别号" prop="taxpayerId">
      <el-input v-model="dataForm.taxpayerId" placeholder="纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="法人（业主）姓名" prop="legalPersonName">
      <el-input v-model="dataForm.legalPersonName" placeholder="法人（业主）姓名"></el-input>
    </el-form-item>
    <el-form-item label="法人（业主）身份证号" prop="legalPersonId">
      <el-input v-model="dataForm.legalPersonId" placeholder="法人（业主）身份证号"></el-input>
    </el-form-item>
    <el-form-item label="经营地址" prop="companyAddress">
      <el-input v-model="dataForm.companyAddress" placeholder="经营地址"></el-input>
    </el-form-item>
    <el-form-item label="营业税-欠税余额" prop="saleTax">
      <el-input v-model="dataForm.saleTax" placeholder="营业税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="营业税-其中本年新欠" prop="saleTaxNew">
      <el-input v-model="dataForm.saleTaxNew" placeholder="营业税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="房产税-欠税余额" prop="houseTax">
      <el-input v-model="dataForm.houseTax" placeholder="房产税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="房产税-其中本年新欠" prop="houseTaxNew">
      <el-input v-model="dataForm.houseTaxNew" placeholder="房产税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="城市维护建设税-欠税余额" prop="cityBuildTax">
      <el-input v-model="dataForm.cityBuildTax" placeholder="城市维护建设税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="城市维护建设税-其中本年新欠" prop="cityBuildTaxNew">
      <el-input v-model="dataForm.cityBuildTaxNew" placeholder="城市维护建设税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="教育费附加-欠税余额" prop="educationTax">
      <el-input v-model="dataForm.educationTax" placeholder="教育费附加-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="教育费附加-其中本年新欠" prop="educationTaxNew">
      <el-input v-model="dataForm.educationTaxNew" placeholder="教育费附加-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="耕地占用税-欠税余额" prop="farmLandOccupyTax">
      <el-input v-model="dataForm.farmLandOccupyTax" placeholder="耕地占用税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="耕地占用税-其中本年新欠" prop="farmLandOccupyTaxNew">
      <el-input v-model="dataForm.farmLandOccupyTaxNew" placeholder="耕地占用税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="土地使用税-欠税余额" prop="landUseTax">
      <el-input v-model="dataForm.landUseTax" placeholder="土地使用税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="土地使用税-其中本年新欠" prop="landUseTaxNew">
      <el-input v-model="dataForm.landUseTaxNew" placeholder="土地使用税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="土地增值税-欠税余额" prop="landValueAddTax">
      <el-input v-model="dataForm.landValueAddTax" placeholder="土地增值税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="土地增值税-其中本年新欠" prop="landValueAddTaxNew">
      <el-input v-model="dataForm.landValueAddTaxNew" placeholder="土地增值税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="个人所得税-欠税余额" prop="personalIncomeTax">
      <el-input v-model="dataForm.personalIncomeTax" placeholder="个人所得税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="个人所得税-其中本年新欠" prop="personalIncomeTaxNew">
      <el-input v-model="dataForm.personalIncomeTaxNew" placeholder="个人所得税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="企业所得税-欠税余额" prop="companyIncomeTax">
      <el-input v-model="dataForm.companyIncomeTax" placeholder="企业所得税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="企业所得税-其中本年新欠" prop="companyIncomeTaxNew">
      <el-input v-model="dataForm.companyIncomeTaxNew" placeholder="企业所得税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="印花税-欠税余额" prop="printTax">
      <el-input v-model="dataForm.printTax" placeholder="印花税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="印花税-其中本年新欠" prop="printTaxNew">
      <el-input v-model="dataForm.printTaxNew" placeholder="印花税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="车船税-欠税余额" prop="carShipTax">
      <el-input v-model="dataForm.carShipTax" placeholder="车船税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="车船税-其中本年新欠" prop="carShipTaxNew">
      <el-input v-model="dataForm.carShipTaxNew" placeholder="车船税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="契税-欠税余额" prop="contractTax">
      <el-input v-model="dataForm.contractTax" placeholder="契税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="契税-其中本年新欠" prop="contractTaxNew">
      <el-input v-model="dataForm.contractTaxNew" placeholder="契税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="资源税-欠税余额" prop="resourceTax">
      <el-input v-model="dataForm.resourceTax" placeholder="资源税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="资源税-其中本年新欠" prop="resourceTaxNew">
      <el-input v-model="dataForm.resourceTaxNew" placeholder="资源税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="合计-欠税余额" prop="totalTax">
      <el-input v-model="dataForm.totalTax" placeholder="合计-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="合计-其中本年新欠" prop="totalTaxNew">
      <el-input v-model="dataForm.totalTaxNew" placeholder="合计-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="时间戳" prop="defaultDate">
      <el-input v-model="dataForm.defaultDate" placeholder="时间戳"></el-input>
    </el-form-item>
    <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataState">
      <el-radio-group v-model="dataForm.dataState">
        <el-radio :label="1">正常</el-radio>
        <el-radio :label="0">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          taxDefaultInfoId: 0,
          company: '',
          taxpayerId: '',
          legalPersonName: '',
          legalPersonId: '',
          companyAddress: '',
          saleTax: '',
          saleTaxNew: '',
          houseTax: '',
          houseTaxNew: '',
          cityBuildTax: '',
          cityBuildTaxNew: '',
          educationTax: '',
          educationTaxNew: '',
          farmLandOccupyTax: '',
          farmLandOccupyTaxNew: '',
          landUseTax: '',
          landUseTaxNew: '',
          landValueAddTax: '',
          landValueAddTaxNew: '',
          personalIncomeTax: '',
          personalIncomeTaxNew: '',
          companyIncomeTax: '',
          companyIncomeTaxNew: '',
          printTax: '',
          printTaxNew: '',
          carShipTax: '',
          carShipTaxNew: '',
          contractTax: '',
          contractTaxNew: '',
          resourceTax: '',
          resourceTaxNew: '',
          totalTax: '',
          totalTaxNew: '',
          defaultDate: '',
          memId: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          enterpriseId: ''
        },
        dataRule: {
          company: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxpayerId: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          legalPersonName: [
            { required: true, message: '法人（业主）姓名不能为空', trigger: 'blur' }
          ],
          legalPersonId: [
            { required: true, message: '法人（业主）身份证号不能为空', trigger: 'blur' }
          ],
          companyAddress: [
            { required: true, message: '经营地址不能为空', trigger: 'blur' }
          ],
          saleTax: [
            { required: true, message: '营业税-欠税余额不能为空', trigger: 'blur' }
          ],
          saleTaxNew: [
            { required: true, message: '营业税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          houseTax: [
            { required: true, message: '房产税-欠税余额不能为空', trigger: 'blur' }
          ],
          houseTaxNew: [
            { required: true, message: '房产税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          cityBuildTax: [
            { required: true, message: '城市维护建设税-欠税余额不能为空', trigger: 'blur' }
          ],
          cityBuildTaxNew: [
            { required: true, message: '城市维护建设税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          educationTax: [
            { required: true, message: '教育费附加-欠税余额不能为空', trigger: 'blur' }
          ],
          educationTaxNew: [
            { required: true, message: '教育费附加-其中本年新欠不能为空', trigger: 'blur' }
          ],
          farmLandOccupyTax: [
            { required: true, message: '耕地占用税-欠税余额不能为空', trigger: 'blur' }
          ],
          farmLandOccupyTaxNew: [
            { required: true, message: '耕地占用税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          landUseTax: [
            { required: true, message: '土地使用税-欠税余额不能为空', trigger: 'blur' }
          ],
          landUseTaxNew: [
            { required: true, message: '土地使用税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          landValueAddTax: [
            { required: true, message: '土地增值税-欠税余额不能为空', trigger: 'blur' }
          ],
          landValueAddTaxNew: [
            { required: true, message: '土地增值税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          personalIncomeTax: [
            { required: true, message: '个人所得税-欠税余额不能为空', trigger: 'blur' }
          ],
          personalIncomeTaxNew: [
            { required: true, message: '个人所得税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          companyIncomeTax: [
            { required: true, message: '企业所得税-欠税余额不能为空', trigger: 'blur' }
          ],
          companyIncomeTaxNew: [
            { required: true, message: '企业所得税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          printTax: [
            { required: true, message: '印花税-欠税余额不能为空', trigger: 'blur' }
          ],
          printTaxNew: [
            { required: true, message: '印花税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          carShipTax: [
            { required: true, message: '车船税-欠税余额不能为空', trigger: 'blur' }
          ],
          carShipTaxNew: [
            { required: true, message: '车船税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          contractTax: [
            { required: true, message: '契税-欠税余额不能为空', trigger: 'blur' }
          ],
          contractTaxNew: [
            { required: true, message: '契税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          resourceTax: [
            { required: true, message: '资源税-欠税余额不能为空', trigger: 'blur' }
          ],
          resourceTaxNew: [
            { required: true, message: '资源税-其中本年新欠不能为空', trigger: 'blur' }
          ],
          totalTax: [
            { required: true, message: '合计-欠税余额不能为空', trigger: 'blur' }
          ],
          totalTaxNew: [
            { required: true, message: '合计-其中本年新欠不能为空', trigger: 'blur' }
          ],
          defaultDate: [
            { required: true, message: '时间戳不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.taxDefaultInfoId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.taxDefaultInfoId) {
            this.$http({
              url: this.$http.adornUrl(`/spider/entchangshataxdefaultinfo/info/${this.dataForm.taxDefaultInfoId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.company = data.entChangshaTaxDefaultInfo.company
                this.dataForm.taxpayerId = data.entChangshaTaxDefaultInfo.taxpayerId
                this.dataForm.legalPersonName = data.entChangshaTaxDefaultInfo.legalPersonName
                this.dataForm.legalPersonId = data.entChangshaTaxDefaultInfo.legalPersonId
                this.dataForm.companyAddress = data.entChangshaTaxDefaultInfo.companyAddress
                this.dataForm.saleTax = data.entChangshaTaxDefaultInfo.saleTax
                this.dataForm.saleTaxNew = data.entChangshaTaxDefaultInfo.saleTaxNew
                this.dataForm.houseTax = data.entChangshaTaxDefaultInfo.houseTax
                this.dataForm.houseTaxNew = data.entChangshaTaxDefaultInfo.houseTaxNew
                this.dataForm.cityBuildTax = data.entChangshaTaxDefaultInfo.cityBuildTax
                this.dataForm.cityBuildTaxNew = data.entChangshaTaxDefaultInfo.cityBuildTaxNew
                this.dataForm.educationTax = data.entChangshaTaxDefaultInfo.educationTax
                this.dataForm.educationTaxNew = data.entChangshaTaxDefaultInfo.educationTaxNew
                this.dataForm.farmLandOccupyTax = data.entChangshaTaxDefaultInfo.farmLandOccupyTax
                this.dataForm.farmLandOccupyTaxNew = data.entChangshaTaxDefaultInfo.farmLandOccupyTaxNew
                this.dataForm.landUseTax = data.entChangshaTaxDefaultInfo.landUseTax
                this.dataForm.landUseTaxNew = data.entChangshaTaxDefaultInfo.landUseTaxNew
                this.dataForm.landValueAddTax = data.entChangshaTaxDefaultInfo.landValueAddTax
                this.dataForm.landValueAddTaxNew = data.entChangshaTaxDefaultInfo.landValueAddTaxNew
                this.dataForm.personalIncomeTax = data.entChangshaTaxDefaultInfo.personalIncomeTax
                this.dataForm.personalIncomeTaxNew = data.entChangshaTaxDefaultInfo.personalIncomeTaxNew
                this.dataForm.companyIncomeTax = data.entChangshaTaxDefaultInfo.companyIncomeTax
                this.dataForm.companyIncomeTaxNew = data.entChangshaTaxDefaultInfo.companyIncomeTaxNew
                this.dataForm.printTax = data.entChangshaTaxDefaultInfo.printTax
                this.dataForm.printTaxNew = data.entChangshaTaxDefaultInfo.printTaxNew
                this.dataForm.carShipTax = data.entChangshaTaxDefaultInfo.carShipTax
                this.dataForm.carShipTaxNew = data.entChangshaTaxDefaultInfo.carShipTaxNew
                this.dataForm.contractTax = data.entChangshaTaxDefaultInfo.contractTax
                this.dataForm.contractTaxNew = data.entChangshaTaxDefaultInfo.contractTaxNew
                this.dataForm.resourceTax = data.entChangshaTaxDefaultInfo.resourceTax
                this.dataForm.resourceTaxNew = data.entChangshaTaxDefaultInfo.resourceTaxNew
                this.dataForm.totalTax = data.entChangshaTaxDefaultInfo.totalTax
                this.dataForm.totalTaxNew = data.entChangshaTaxDefaultInfo.totalTaxNew
                this.dataForm.defaultDate = data.entChangshaTaxDefaultInfo.defaultDate
                this.dataForm.memId = data.entChangshaTaxDefaultInfo.memId
                this.dataForm.creator = data.entChangshaTaxDefaultInfo.creator
                this.dataForm.createTime = data.entChangshaTaxDefaultInfo.createTime
                this.dataForm.updater = data.entChangshaTaxDefaultInfo.updater
                this.dataForm.updateTime = data.entChangshaTaxDefaultInfo.updateTime
                this.dataForm.dataState = data.entChangshaTaxDefaultInfo.dataState
                this.dataForm.enterpriseId = data.entChangshaTaxDefaultInfo.enterpriseId
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
              url: this.$http.adornUrl(`/spider/entchangshataxdefaultinfo/${!this.dataForm.taxDefaultInfoId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'taxDefaultInfoId': this.dataForm.taxDefaultInfoId || undefined,
                'company': this.dataForm.company,
                'taxpayerId': this.dataForm.taxpayerId,
                'legalPersonName': this.dataForm.legalPersonName,
                'legalPersonId': this.dataForm.legalPersonId,
                'companyAddress': this.dataForm.companyAddress,
                'saleTax': this.dataForm.saleTax,
                'saleTaxNew': this.dataForm.saleTaxNew,
                'houseTax': this.dataForm.houseTax,
                'houseTaxNew': this.dataForm.houseTaxNew,
                'cityBuildTax': this.dataForm.cityBuildTax,
                'cityBuildTaxNew': this.dataForm.cityBuildTaxNew,
                'educationTax': this.dataForm.educationTax,
                'educationTaxNew': this.dataForm.educationTaxNew,
                'farmLandOccupyTax': this.dataForm.farmLandOccupyTax,
                'farmLandOccupyTaxNew': this.dataForm.farmLandOccupyTaxNew,
                'landUseTax': this.dataForm.landUseTax,
                'landUseTaxNew': this.dataForm.landUseTaxNew,
                'landValueAddTax': this.dataForm.landValueAddTax,
                'landValueAddTaxNew': this.dataForm.landValueAddTaxNew,
                'personalIncomeTax': this.dataForm.personalIncomeTax,
                'personalIncomeTaxNew': this.dataForm.personalIncomeTaxNew,
                'companyIncomeTax': this.dataForm.companyIncomeTax,
                'companyIncomeTaxNew': this.dataForm.companyIncomeTaxNew,
                'printTax': this.dataForm.printTax,
                'printTaxNew': this.dataForm.printTaxNew,
                'carShipTax': this.dataForm.carShipTax,
                'carShipTaxNew': this.dataForm.carShipTaxNew,
                'contractTax': this.dataForm.contractTax,
                'contractTaxNew': this.dataForm.contractTaxNew,
                'resourceTax': this.dataForm.resourceTax,
                'resourceTaxNew': this.dataForm.resourceTaxNew,
                'totalTax': this.dataForm.totalTax,
                'totalTaxNew': this.dataForm.totalTaxNew,
                'defaultDate': this.dataForm.defaultDate,
                'memId': this.dataForm.memId,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'enterpriseId': this.dataForm.enterpriseId
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
