<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
    
    <el-form-item label="纳税人名称" prop="taxpayerName">
      <el-input v-model="dataForm.taxpayerName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="纳税人识别号" prop="taxpayerId">
      <el-input v-model="dataForm.taxpayerId" placeholder="纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="信用级别" prop="creditLevel">
      <el-input v-model="dataForm.creditLevel" placeholder="信用级别"></el-input>
    </el-form-item>
    <el-form-item label="评级级别" prop="ratingLevel">
      <el-input v-model="dataForm.ratingLevel" placeholder="评级级别"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="ratingYear">
      <!-- <el-input v-model="dataForm.ratingYear" placeholder="评价年度"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.ratingYear" placeholder="评价年度"></el-date-picker>
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
          stateTaxId: 0,
          enterpriseId: '',
          taxpayerName: '',
          taxpayerId: '',
          creditLevel: '',
          ratingLevel: '',
          ratingYear: '',
          memId: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          taxpayerName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxpayerId: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          creditLevel: [
            { required: true, message: '信用级别不能为空', trigger: 'blur' }
          ],
          ratingLevel: [
            { required: true, message: '评级级别不能为空', trigger: 'blur' }
          ],
          ratingYear: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.stateTaxId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.stateTaxId) {
            this.$http({
              url: this.$http.adornUrl(`/spider/entstatetaxcreditinfo/info/${this.dataForm.stateTaxId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.entStateTaxCreditInfo.enterpriseId
                this.dataForm.taxpayerName = data.entStateTaxCreditInfo.taxpayerName
                this.dataForm.taxpayerId = data.entStateTaxCreditInfo.taxpayerId
                this.dataForm.creditLevel = data.entStateTaxCreditInfo.creditLevel
                this.dataForm.ratingLevel = data.entStateTaxCreditInfo.ratingLevel
                this.dataForm.ratingYear = data.entStateTaxCreditInfo.ratingYear
                this.dataForm.memId = data.entStateTaxCreditInfo.memId
                this.dataForm.creator = data.entStateTaxCreditInfo.creator
                this.dataForm.createTime = data.entStateTaxCreditInfo.createTime
                this.dataForm.updater = data.entStateTaxCreditInfo.updater
                this.dataForm.updateTime = data.entStateTaxCreditInfo.updateTime
                this.dataForm.dataState = data.entStateTaxCreditInfo.dataState
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
              url: this.$http.adornUrl(`/spider/entstatetaxcreditinfo/${!this.dataForm.stateTaxId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'stateTaxId': this.dataForm.stateTaxId || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'taxpayerName': this.dataForm.taxpayerName,
                'taxpayerId': this.dataForm.taxpayerId,
                'creditLevel': this.dataForm.creditLevel,
                'ratingLevel': this.dataForm.ratingLevel,
                'ratingYear': this.dataForm.ratingYear,
                'memId': this.dataForm.memId,
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
