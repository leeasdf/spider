<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
   <!--  <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="行业种类" prop="industryCategory">
          <el-input v-model="dataForm.industryCategory" placeholder="行业种类"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="年报情况" prop="annualReport">
          <el-input v-model="dataForm.annualReport" placeholder="年报情况"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="海关注销标识" prop="status">
          <el-input v-model="dataForm.status" placeholder="海关注销标识"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="行政区划" prop="administrativeDivision">
          <el-input v-model="dataForm.administrativeDivision" placeholder="行政区划"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="经营类别" prop="managementCategory">
          <el-input v-model="dataForm.managementCategory" placeholder="经营类别"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="注册海关" prop="customsRegisteredAddress">
          <el-input v-model="dataForm.customsRegisteredAddress" placeholder="注册海关"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="报关有效期" prop="validityDate">
          <el-date-picker v-model="dataForm.validityDate" value-format="yyyy-MM-dd" placeholder="报关有效期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="经济区划" prop="economicDivision">
          <el-input v-model="dataForm.economicDivision" placeholder="经济区划"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="注册日期" prop="recordDate">
          <el-date-picker v-model="dataForm.recordDate" value-format="yyyy-MM-dd" placeholder="注册日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="海关注册号" prop="crCode">
          <el-input v-model="dataForm.crCode" placeholder="海关注册号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="特殊贸易区域" prop="specialTradeArea">
          <el-input v-model="dataForm.specialTradeArea" placeholder="特殊贸易区域"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
     <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="电子商务类型" prop="types">
          <el-input v-model="dataForm.types" placeholder="跨境贸易电子商务类型"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="信用登记" prop="creditRating">
          <el-input v-model="dataForm.creditRating" placeholder="信用登记"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
     <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="sanction" prop="sanction">
          <el-input v-model="dataForm.sanction" placeholder="sanction"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="数据状态" prop="dataState">
          <el-radio-group v-model="dataForm.dataState">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">删除</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
    </el-row>
    </el-row>
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
          id: 0,
          enterpriseId: '',
          entName: '',
          industryCategory: '',
          annualReport: '',
          status: '',
          administrativeDivision: '',
          managementCategory: '',
          customsRegisteredAddress: '',
          validityDate: '',
          economicDivision: '',
          recordDate: '',
          crCode: '',
          specialTradeArea: '',
          types: '',
          creditRating: '',
          sanction: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          industryCategory: [
            { required: true, message: '行业种类不能为空', trigger: 'blur' }
          ],
          annualReport: [
            { required: true, message: '年报情况不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '海关注销标识不能为空', trigger: 'blur' }
          ],
          administrativeDivision: [
            { required: true, message: '行政区划不能为空', trigger: 'blur' }
          ],
          managementCategory: [
            { required: true, message: '经营类别不能为空', trigger: 'blur' }
          ],
          customsRegisteredAddress: [
            { required: true, message: '注册海关不能为空', trigger: 'blur' }
          ],
          validityDate: [
            { required: true, message: '报关有效期不能为空', trigger: 'blur' }
          ],
          economicDivision: [
            { required: true, message: '经济区划不能为空', trigger: 'blur' }
          ],
          recordDate: [
            { required: true, message: '注册日期不能为空', trigger: 'blur' }
          ],
          crCode: [
            { required: true, message: '海关注册号不能为空', trigger: 'blur' }
          ],
          specialTradeArea: [
            { required: true, message: '特殊贸易区域不能为空', trigger: 'blur' }
          ],
          types: [
            { required: true, message: '跨境贸易电子商务类型不能为空', trigger: 'blur' }
          ],
          creditRating: [
            { required: true, message: '信用登记不能为空', trigger: 'blur' }
          ],
          sanction: [
            { required: true, message: 'sanction不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnimportexport/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnImportExport.enterpriseId
                this.dataForm.entName = data.rptTnImportExport.entName
                this.dataForm.industryCategory = data.rptTnImportExport.industryCategory
                this.dataForm.annualReport = data.rptTnImportExport.annualReport
                this.dataForm.status = data.rptTnImportExport.status
                this.dataForm.administrativeDivision = data.rptTnImportExport.administrativeDivision
                this.dataForm.managementCategory = data.rptTnImportExport.managementCategory
                this.dataForm.customsRegisteredAddress = data.rptTnImportExport.customsRegisteredAddress
                this.dataForm.validityDate = data.rptTnImportExport.validityDate
                this.dataForm.economicDivision = data.rptTnImportExport.economicDivision
                this.dataForm.recordDate = data.rptTnImportExport.recordDate
                this.dataForm.crCode = data.rptTnImportExport.crCode
                this.dataForm.specialTradeArea = data.rptTnImportExport.specialTradeArea
                this.dataForm.types = data.rptTnImportExport.types
                this.dataForm.creditRating = data.rptTnImportExport.creditRating
                this.dataForm.sanction = data.rptTnImportExport.sanction
                this.dataForm.creator = data.rptTnImportExport.creator
                this.dataForm.createTime = data.rptTnImportExport.createTime
                this.dataForm.updater = data.rptTnImportExport.updater
                this.dataForm.updateTime = data.rptTnImportExport.updateTime
                this.dataForm.dataState = data.rptTnImportExport.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnimportexport/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'industryCategory': this.dataForm.industryCategory,
                'annualReport': this.dataForm.annualReport,
                'status': this.dataForm.status,
                'administrativeDivision': this.dataForm.administrativeDivision,
                'managementCategory': this.dataForm.managementCategory,
                'customsRegisteredAddress': this.dataForm.customsRegisteredAddress,
                'validityDate': this.dataForm.validityDate,
                'economicDivision': this.dataForm.economicDivision,
                'recordDate': this.dataForm.recordDate,
                'crCode': this.dataForm.crCode,
                'specialTradeArea': this.dataForm.specialTradeArea,
                'types': this.dataForm.types,
                'creditRating': this.dataForm.creditRating,
                'sanction': this.dataForm.sanction,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
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
