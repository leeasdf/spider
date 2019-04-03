<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="企业名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="缴税年份" prop="taxYear">
      <!-- <el-input v-model="dataForm.taxYear" placeholder="缴税年份"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.taxYear" placeholder="缴税年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="地税" prop="localTax">
      <el-input v-model="dataForm.localTax" placeholder="地税"></el-input>
    </el-form-item>
    <el-form-item label="国税" prop="stateTax">
      <el-input v-model="dataForm.stateTax" placeholder="国税"></el-input>
    </el-form-item>
    <el-form-item label="合计税收" prop="totalTax">
      <el-input v-model="dataForm.totalTax" placeholder="合计税收"></el-input>
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
          taxInfoId: 0,
          enterpriseName: '',
          taxYear: '',
          localTax: '',
          stateTax: '',
          totalTax: '',
          memId: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          enterpriseId: ''
        },
        dataRule: {
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          taxYear: [
            { required: true, message: '缴税年份不能为空', trigger: 'blur' }
          ],
          localTax: [
            { required: true, message: '地税不能为空', trigger: 'blur' }
          ],
          stateTax: [
            { required: true, message: '国税不能为空', trigger: 'blur' }
          ],
          totalTax: [
            { required: true, message: '合计税收不能为空', trigger: 'blur' }
          ],
          /* memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ], */
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
        this.dataForm.taxInfoId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.taxInfoId) {
            this.$http({
              url: this.$http.adornUrl(`/spider/enttaxinfo/info/${this.dataForm.taxInfoId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseName = data.entTaxInfo.enterpriseName
                this.dataForm.taxYear = data.entTaxInfo.taxYear
                this.dataForm.localTax = data.entTaxInfo.localTax
                this.dataForm.stateTax = data.entTaxInfo.stateTax
                this.dataForm.totalTax = data.entTaxInfo.totalTax
                this.dataForm.memId = data.entTaxInfo.memId
                this.dataForm.creator = data.entTaxInfo.creator
                this.dataForm.createTime = data.entTaxInfo.createTime
                this.dataForm.updater = data.entTaxInfo.updater
                this.dataForm.updateTime = data.entTaxInfo.updateTime
                this.dataForm.dataState = data.entTaxInfo.dataState
                this.dataForm.enterpriseId = data.entTaxInfo.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enttaxinfo/${!this.dataForm.taxInfoId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'taxInfoId': this.dataForm.taxInfoId || undefined,
                'enterpriseName': this.dataForm.enterpriseName,
                'taxYear': this.dataForm.taxYear,
                'localTax': this.dataForm.localTax,
                'stateTax': this.dataForm.stateTax,
                'totalTax': this.dataForm.totalTax,
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
