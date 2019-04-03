<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="220px">
    <el-form-item label="纳税人名称" prop="taxpayerName">
      <el-input v-model="dataForm.taxpayerName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="纳税人识别号" prop="taxNo">
      <el-input v-model="dataForm.taxNo" placeholder="纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="法人（业主）姓名" prop="legalPersonName">
      <el-input v-model="dataForm.legalPersonName" placeholder="法人（业主）姓名"></el-input>
    </el-form-item>
    <el-form-item label="法人（业主）身份证号" prop="legalPersonCertNo">
      <el-input v-model="dataForm.legalPersonCertNo" placeholder="法人（业主）身份证号"></el-input>
    </el-form-item>
    <el-form-item label="经营地址" prop="businessAddress">
      <el-input v-model="dataForm.businessAddress" placeholder="经营地址"></el-input>
    </el-form-item>
    <el-form-item label="营业税-欠税余额" prop="businessTaxOwing">
      <el-input v-model="dataForm.businessTaxOwing" placeholder="营业税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="营业税-其中本年新欠" prop="businessTaxOwingNew">
      <el-input v-model="dataForm.businessTaxOwingNew" placeholder="营业税-其中本年新欠"></el-input>
    </el-form-item>
    <el-form-item label="房产税-欠税余额" prop="propertyTaxOwing">
      <el-input v-model="dataForm.propertyTaxOwing" placeholder="房产税-欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="房产税-其中本年新欠" prop="propertyTaxOwingNew">
      <el-input v-model="dataForm.propertyTaxOwingNew" placeholder="房产税-其中本年新欠"></el-input>
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
    <el-form-item label="数据更新时间戳" prop="dataUpdateTime">
      <el-input v-model="dataForm.dataUpdateTime" placeholder="数据更新时间戳"></el-input>
    </el-form-item>
    
    <el-form-item label="最后修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="最后修改时间"></el-input>
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
  import { isFloat } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          taxpayerName: '',
          taxNo: '',
          legalPersonName: '',
          legalPersonCertNo: '',
          businessAddress: '',
          businessTaxOwing: '',
          businessTaxOwingNew: '',
          propertyTaxOwing: '',
          propertyTaxOwingNew: '',
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
          dataUpdateTime: '',
          createTime: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          taxpayerName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxNo: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          legalPersonName: [
            { required: true, message: '法人（业主）姓名不能为空', trigger: 'blur' }
          ],
          legalPersonCertNo: [
            { required: true, message: '法人（业主）身份证号不能为空', trigger: 'blur' }
          ],
          businessAddress: [
            { required: true, message: '经营地址不能为空', trigger: 'blur' }
          ],
          businessTaxOwing: [
            { required: true, message: '营业税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          businessTaxOwingNew: [
            { required: true, message: '营业税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          propertyTaxOwing: [
            { required: true, message: '房产税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          propertyTaxOwingNew: [
            { required: true, message: '房产税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          cityBuildTax: [
            { required: true, message: '城市维护建设税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          cityBuildTaxNew: [
            { required: true, message: '城市维护建设税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          educationTax: [
            { required: true, message: '教育费附加-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          educationTaxNew: [
            { required: true, message: '教育费附加-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          farmLandOccupyTax: [
            { required: true, message: '耕地占用税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          farmLandOccupyTaxNew: [
            { required: true, message: '耕地占用税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          landUseTax: [
            { required: true, message: '土地使用税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          landUseTaxNew: [
            { required: true, message: '土地使用税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          landValueAddTax: [
            { required: true, message: '土地增值税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          landValueAddTaxNew: [
            { required: true, message: '土地增值税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          personalIncomeTax: [
            { required: true, message: '个人所得税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          personalIncomeTaxNew: [
            { required: true, message: '个人所得税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          companyIncomeTax: [
            { required: true, message: '企业所得税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          companyIncomeTaxNew: [
            { required: true, message: '企业所得税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          printTax: [
            { required: true, message: '印花税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          printTaxNew: [
            { required: true, message: '印花税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          carShipTax: [
            { required: true, message: '车船税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          carShipTaxNew: [
            { required: true, message: '车船税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          contractTax: [
            { required: true, message: '契税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          contractTaxNew: [
            { required: true, message: '契税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          resourceTax: [
            { required: true, message: '资源税-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          resourceTaxNew: [
            { required: true, message: '资源税-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          totalTax: [
            { required: true, message: '合计-欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          totalTaxNew: [
            { required: true, message: '合计-其中本年新欠不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          dataUpdateTime: [
            { required: true, message: '数据更新时间戳不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '最后修改时间不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
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
              url: this.$http.adornUrl(`/spider/xylgdsjcitytaxowing/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taxpayerName = data.xylgDsjCityTaxOwing.taxpayerName
                this.dataForm.taxNo = data.xylgDsjCityTaxOwing.taxNo
                this.dataForm.legalPersonName = data.xylgDsjCityTaxOwing.legalPersonName
                this.dataForm.legalPersonCertNo = data.xylgDsjCityTaxOwing.legalPersonCertNo
                this.dataForm.businessAddress = data.xylgDsjCityTaxOwing.businessAddress
                this.dataForm.businessTaxOwing = data.xylgDsjCityTaxOwing.businessTaxOwing
                this.dataForm.businessTaxOwingNew = data.xylgDsjCityTaxOwing.businessTaxOwingNew
                this.dataForm.propertyTaxOwing = data.xylgDsjCityTaxOwing.propertyTaxOwing
                this.dataForm.propertyTaxOwingNew = data.xylgDsjCityTaxOwing.propertyTaxOwingNew
                this.dataForm.cityBuildTax = data.xylgDsjCityTaxOwing.cityBuildTax
                this.dataForm.cityBuildTaxNew = data.xylgDsjCityTaxOwing.cityBuildTaxNew
                this.dataForm.educationTax = data.xylgDsjCityTaxOwing.educationTax
                this.dataForm.educationTaxNew = data.xylgDsjCityTaxOwing.educationTaxNew
                this.dataForm.farmLandOccupyTax = data.xylgDsjCityTaxOwing.farmLandOccupyTax
                this.dataForm.farmLandOccupyTaxNew = data.xylgDsjCityTaxOwing.farmLandOccupyTaxNew
                this.dataForm.landUseTax = data.xylgDsjCityTaxOwing.landUseTax
                this.dataForm.landUseTaxNew = data.xylgDsjCityTaxOwing.landUseTaxNew
                this.dataForm.landValueAddTax = data.xylgDsjCityTaxOwing.landValueAddTax
                this.dataForm.landValueAddTaxNew = data.xylgDsjCityTaxOwing.landValueAddTaxNew
                this.dataForm.personalIncomeTax = data.xylgDsjCityTaxOwing.personalIncomeTax
                this.dataForm.personalIncomeTaxNew = data.xylgDsjCityTaxOwing.personalIncomeTaxNew
                this.dataForm.companyIncomeTax = data.xylgDsjCityTaxOwing.companyIncomeTax
                this.dataForm.companyIncomeTaxNew = data.xylgDsjCityTaxOwing.companyIncomeTaxNew
                this.dataForm.printTax = data.xylgDsjCityTaxOwing.printTax
                this.dataForm.printTaxNew = data.xylgDsjCityTaxOwing.printTaxNew
                this.dataForm.carShipTax = data.xylgDsjCityTaxOwing.carShipTax
                this.dataForm.carShipTaxNew = data.xylgDsjCityTaxOwing.carShipTaxNew
                this.dataForm.contractTax = data.xylgDsjCityTaxOwing.contractTax
                this.dataForm.contractTaxNew = data.xylgDsjCityTaxOwing.contractTaxNew
                this.dataForm.resourceTax = data.xylgDsjCityTaxOwing.resourceTax
                this.dataForm.resourceTaxNew = data.xylgDsjCityTaxOwing.resourceTaxNew
                this.dataForm.totalTax = data.xylgDsjCityTaxOwing.totalTax
                this.dataForm.totalTaxNew = data.xylgDsjCityTaxOwing.totalTaxNew
                this.dataForm.dataUpdateTime = data.xylgDsjCityTaxOwing.dataUpdateTime
                this.dataForm.createTime = data.xylgDsjCityTaxOwing.createTime
                this.dataForm.updateTime = data.xylgDsjCityTaxOwing.updateTime
                this.dataForm.dataState = data.xylgDsjCityTaxOwing.dataState
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
              url: this.$http.adornUrl(`/spider/xylgdsjcitytaxowing/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'taxpayerName': this.dataForm.taxpayerName,
                'taxNo': this.dataForm.taxNo,
                'legalPersonName': this.dataForm.legalPersonName,
                'legalPersonCertNo': this.dataForm.legalPersonCertNo,
                'businessAddress': this.dataForm.businessAddress,
                'businessTaxOwing': this.dataForm.businessTaxOwing,
                'businessTaxOwingNew': this.dataForm.businessTaxOwingNew,
                'propertyTaxOwing': this.dataForm.propertyTaxOwing,
                'propertyTaxOwingNew': this.dataForm.propertyTaxOwingNew,
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
                'dataUpdateTime': this.dataForm.dataUpdateTime,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState
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
