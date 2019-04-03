<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
    <el-form-item label="企业名称" prop="company">
      <el-input v-model="dataForm.company" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="业务类型" prop="businessType">
      <el-input v-model="dataForm.businessType" placeholder="业务类型"></el-input>
    </el-form-item>
    <el-form-item label="土地使用权证号" prop="landUseNumber">
      <el-input v-model="dataForm.landUseNumber" placeholder="土地使用权证号"></el-input>
    </el-form-item>
    <el-form-item label="原土地证号" prop="oldLandUseNumber">
      <el-input v-model="dataForm.oldLandUseNumber" placeholder="原土地证号"></el-input>
    </el-form-item>
    <el-form-item label="土地位置" prop="landAddress">
      <el-input v-model="dataForm.landAddress" placeholder="土地位置"></el-input>
    </el-form-item>
    <el-form-item label="宗地面积" prop="area">
      <el-input v-model="dataForm.area" placeholder="宗地面积"></el-input>
    </el-form-item>
    <el-form-item label="土地用途" prop="landUse">
      <el-input v-model="dataForm.landUse" placeholder="土地用途"></el-input>
    </el-form-item>
    <el-form-item label="使用权类型" prop="landUseType">
      <el-input v-model="dataForm.landUseType" placeholder="使用权类型"></el-input>
    </el-form-item>
    <el-form-item label="登记审批日期" prop="registerDate">
      <el-input v-model="dataForm.registerDate" placeholder="登记审批日期"></el-input>
    </el-form-item>
    <el-form-item label="土地使用期限" prop="limitDate">
      <el-input v-model="dataForm.limitDate" placeholder="土地使用期限"></el-input>
    </el-form-item>
    <el-form-item label="联系方式" prop="contact">
      <el-input v-model="dataForm.contact" placeholder="联系方式"></el-input>
    </el-form-item>
    <el-form-item label="台账年份" prop="year">
      <!-- <el-input v-model="dataForm.year" placeholder="台账年份"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.year" placeholder="台账年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
   <!--  <el-form-item label="绑定mem_id" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="绑定mem_id"></el-input>
    </el-form-item> -->
    
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
          company: '',
          businessType: '',
          landUseNumber: '',
          oldLandUseNumber: '',
          landAddress: '',
          area: '',
          landUse: '',
          landUseType: '',
          registerDate: '',
          limitDate: '',
          contact: '',
          year: '',
          memId: '',
          enterpriseId: ''
        },
        dataRule: {
          company: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          businessType: [
            { required: true, message: '业务类型不能为空', trigger: 'blur' }
          ],
          landUseNumber: [
            { required: true, message: '土地使用权证号不能为空', trigger: 'blur' }
          ],
          oldLandUseNumber: [
            { required: true, message: '原土地证号不能为空', trigger: 'blur' }
          ],
          landAddress: [
            { required: true, message: '土地位置不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '宗地面积不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          landUse: [
            { required: true, message: '土地用途不能为空', trigger: 'blur' }
          ],
          landUseType: [
            { required: true, message: '使用权类型不能为空', trigger: 'blur' }
          ],
          registerDate: [
            { required: true, message: '登记审批日期不能为空', trigger: 'blur' }
          ],
          limitDate: [
            { required: true, message: '土地使用期限不能为空', trigger: 'blur' }
          ],
          contact: [
            { required: true, message: '联系方式不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '台账年份不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '绑定mem_id不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechlandledger/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.company = data.entHighTechLandLedger.company
                this.dataForm.businessType = data.entHighTechLandLedger.businessType
                this.dataForm.landUseNumber = data.entHighTechLandLedger.landUseNumber
                this.dataForm.oldLandUseNumber = data.entHighTechLandLedger.oldLandUseNumber
                this.dataForm.landAddress = data.entHighTechLandLedger.landAddress
                this.dataForm.area = data.entHighTechLandLedger.area
                this.dataForm.landUse = data.entHighTechLandLedger.landUse
                this.dataForm.landUseType = data.entHighTechLandLedger.landUseType
                this.dataForm.registerDate = data.entHighTechLandLedger.registerDate
                this.dataForm.limitDate = data.entHighTechLandLedger.limitDate
                this.dataForm.contact = data.entHighTechLandLedger.contact
                this.dataForm.year = data.entHighTechLandLedger.year
                this.dataForm.memId = data.entHighTechLandLedger.memId
                this.dataForm.enterpriseId = data.entHighTechLandLedger.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechlandledger/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'company': this.dataForm.company,
                'businessType': this.dataForm.businessType,
                'landUseNumber': this.dataForm.landUseNumber,
                'oldLandUseNumber': this.dataForm.oldLandUseNumber,
                'landAddress': this.dataForm.landAddress,
                'area': this.dataForm.area,
                'landUse': this.dataForm.landUse,
                'landUseType': this.dataForm.landUseType,
                'registerDate': this.dataForm.registerDate,
                'limitDate': this.dataForm.limitDate,
                'contact': this.dataForm.contact,
                'year': this.dataForm.year,
                'memId': this.dataForm.memId,
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
