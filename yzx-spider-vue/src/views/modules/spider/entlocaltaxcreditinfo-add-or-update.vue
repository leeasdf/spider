<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <el-form-item label="纳税人名称" prop="taxpayerName">
      <el-input v-model="dataForm.taxpayerName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="税务登记号" prop="taxRegistrationId">
      <el-input v-model="dataForm.taxRegistrationId" placeholder="税务登记号"></el-input>
    </el-form-item>
    <el-form-item label="信用级别" prop="creditLevel">
      <el-input v-model="dataForm.creditLevel" placeholder="信用级别"></el-input>
    </el-form-item>
    <el-form-item label="评价税务机关" prop="ratingTaxAuthority">
      <el-input v-model="dataForm.ratingTaxAuthority" placeholder="评价税务机关"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="ratingYear">
      <el-input v-model="dataForm.ratingYear" placeholder="评价年度"></el-input>
    </el-form-item>
    <el-form-item label="评价日期" prop="ratingDate">
      <!-- <el-input v-model="dataForm.ratingDate" placeholder="评价日期"></el-input> -->
      <el-date-picker v-model="dataForm.ratingDate" value-format="yyyy-MM-dd" placeholder="评价日期"></el-date-picker>
    </el-form-item>
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
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
          localTaxId: 0,
          taxpayerName: '',
          taxRegistrationId: '',
          creditLevel: '',
          ratingTaxAuthority: '',
          ratingYear: '',
          ratingDate: '',
          memId: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          enterpriseId: ''
        },
        dataRule: {
          taxpayerName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxRegistrationId: [
            { required: true, message: '税务登记号不能为空', trigger: 'blur' }
          ],
          creditLevel: [
            { required: true, message: '信用级别不能为空', trigger: 'blur' }
          ],
          ratingTaxAuthority: [
            { required: true, message: '评价税务机关不能为空', trigger: 'blur' }
          ],
          ratingYear: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          ratingDate: [
            { required: true, message: '评价日期不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.localTaxId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.localTaxId) {
            this.$http({
              url: this.$http.adornUrl(`/spider/entlocaltaxcreditinfo/info/${this.dataForm.localTaxId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taxpayerName = data.entLocalTaxCreditInfo.taxpayerName
                this.dataForm.taxRegistrationId = data.entLocalTaxCreditInfo.taxRegistrationId
                this.dataForm.creditLevel = data.entLocalTaxCreditInfo.creditLevel
                this.dataForm.ratingTaxAuthority = data.entLocalTaxCreditInfo.ratingTaxAuthority
                this.dataForm.ratingYear = data.entLocalTaxCreditInfo.ratingYear
                this.dataForm.ratingDate = data.entLocalTaxCreditInfo.ratingDate
                this.dataForm.memId = data.entLocalTaxCreditInfo.memId
                this.dataForm.creator = data.entLocalTaxCreditInfo.creator
                this.dataForm.createTime = data.entLocalTaxCreditInfo.createTime
                this.dataForm.updater = data.entLocalTaxCreditInfo.updater
                this.dataForm.updateTime = data.entLocalTaxCreditInfo.updateTime
                this.dataForm.dataState = data.entLocalTaxCreditInfo.dataState
                this.dataForm.enterpriseId = data.entLocalTaxCreditInfo.enterpriseId
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
              url: this.$http.adornUrl(`/spider/entlocaltaxcreditinfo/${!this.dataForm.localTaxId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'localTaxId': this.dataForm.localTaxId || undefined,
                'taxpayerName': this.dataForm.taxpayerName,
                'taxRegistrationId': this.dataForm.taxRegistrationId,
                'creditLevel': this.dataForm.creditLevel,
                'ratingTaxAuthority': this.dataForm.ratingTaxAuthority,
                'ratingYear': this.dataForm.ratingYear,
                'ratingDate': this.dataForm.ratingDate,
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
