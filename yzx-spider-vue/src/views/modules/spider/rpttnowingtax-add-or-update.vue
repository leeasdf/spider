<template>
  <el-dialog
    width="820px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="160px">
    <!-- <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="发布日期" prop="publicDate">
          <el-date-picker v-model="dataForm.publicDate" value-format="yyyy-MM-dd" placeholder="发布日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="纳税人识别号(已加密)" prop="taxNo">
          <el-input v-model="dataForm.taxNo" placeholder="纳税人识别号(已加密)"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="欠税税种" prop="oweTaxType">
          <el-input v-model="dataForm.oweTaxType" placeholder="欠税税种"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="当前发生的欠税额" prop="currentOweTaxAmount">
          <el-input v-model="dataForm.currentOweTaxAmount" placeholder="当前发生的欠税额"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="欠税余额" prop="ownTaxBalance">
          <el-input v-model="dataForm.ownTaxBalance" placeholder="欠税余额"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="税务机关" prop="taxDepart">
          <el-input v-model="dataForm.taxDepart" placeholder="税务机关"></el-input>
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
          publicDate: '',
          taxNo: '',
          oweTaxType: '',
          currentOweTaxAmount: '',
          ownTaxBalance: '',
          taxDepart: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          publicDate: [
            { required: true, message: '发布日期不能为空', trigger: 'blur' }
          ],
          taxNo: [
            { required: true, message: '纳税人识别号(已加密)不能为空', trigger: 'blur' }
          ],
          oweTaxType: [
            { required: true, message: '欠税税种不能为空', trigger: 'blur' }
          ],
          currentOweTaxAmount: [
            { required: true, message: '当前发生的欠税额不能为空', trigger: 'blur' }
          ],
          ownTaxBalance: [
            { required: true, message: '欠税余额不能为空', trigger: 'blur' }
          ],
          taxDepart: [
            { required: true, message: '税务机关不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnowingtax/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnOwingTax.enterpriseId
                this.dataForm.entName = data.rptTnOwingTax.entName
                this.dataForm.publicDate = data.rptTnOwingTax.publicDate
                this.dataForm.taxNo = data.rptTnOwingTax.taxNo
                this.dataForm.oweTaxType = data.rptTnOwingTax.oweTaxType
                this.dataForm.currentOweTaxAmount = data.rptTnOwingTax.currentOweTaxAmount
                this.dataForm.ownTaxBalance = data.rptTnOwingTax.ownTaxBalance
                this.dataForm.taxDepart = data.rptTnOwingTax.taxDepart
                this.dataForm.creator = data.rptTnOwingTax.creator
                this.dataForm.createTime = data.rptTnOwingTax.createTime
                this.dataForm.updater = data.rptTnOwingTax.updater
                this.dataForm.updateTime = data.rptTnOwingTax.updateTime
                this.dataForm.dataState = data.rptTnOwingTax.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnowingtax/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'publicDate': this.dataForm.publicDate,
                'taxNo': this.dataForm.taxNo,
                'oweTaxType': this.dataForm.oweTaxType,
                'currentOweTaxAmount': this.dataForm.currentOweTaxAmount,
                'ownTaxBalance': this.dataForm.ownTaxBalance,
                'taxDepart': this.dataForm.taxDepart,
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
