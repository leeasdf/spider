<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="纳税人名称" prop="taxpayerName">
      <el-input v-model="dataForm.taxpayerName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="税务登记码" prop="taxNo">
      <el-input v-model="dataForm.taxNo" placeholder="税务登记码"></el-input>
    </el-form-item>
    <el-form-item label="信用级别A" prop="creditRating">
      <el-input v-model="dataForm.creditRating" placeholder="信用级别A"></el-input>
    </el-form-item>
    <el-form-item label="评价税务机关" prop="taxAuthority">
      <el-input v-model="dataForm.taxAuthority" placeholder="评价税务机关"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="evaluationYear">
      <el-input v-model="dataForm.evaluationYear" placeholder="评价年度"></el-input>
    </el-form-item>
    <el-form-item label="评价日期" prop="evaluationDate">
      <el-input v-model="dataForm.evaluationDate" placeholder="评价日期"></el-input>
    </el-form-item>
    <el-form-item label="数据状态（0：正常 1：更新 2：删除）" prop="dataState">
      <el-input v-model="dataForm.dataState" placeholder="数据状态（0：正常 1：更新 2：删除）"></el-input>
    </el-form-item>
    <el-form-item label="最后修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="最后修改时间"></el-input>
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
          id: 0,
          taxpayerName: '',
          taxNo: '',
          creditRating: '',
          taxAuthority: '',
          evaluationYear: '',
          evaluationDate: '',
          dataState: '',
          updateTime: '',
          createTime: ''
        },
        dataRule: {
          taxpayerName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxNo: [
            { required: true, message: '税务登记码不能为空', trigger: 'blur' }
          ],
          creditRating: [
            { required: true, message: '信用级别A不能为空', trigger: 'blur' }
          ],
          taxAuthority: [
            { required: true, message: '评价税务机关不能为空', trigger: 'blur' }
          ],
          evaluationYear: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          evaluationDate: [
            { required: true, message: '评价日期不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态（0：正常 1：更新 2：删除）不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '最后修改时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/xylgtaxpayercreditresult/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taxpayerName = data.xylgTaxpayerCreditResult.taxpayerName
                this.dataForm.taxNo = data.xylgTaxpayerCreditResult.taxNo
                this.dataForm.creditRating = data.xylgTaxpayerCreditResult.creditRating
                this.dataForm.taxAuthority = data.xylgTaxpayerCreditResult.taxAuthority
                this.dataForm.evaluationYear = data.xylgTaxpayerCreditResult.evaluationYear
                this.dataForm.evaluationDate = data.xylgTaxpayerCreditResult.evaluationDate
                this.dataForm.dataState = data.xylgTaxpayerCreditResult.dataState
                this.dataForm.updateTime = data.xylgTaxpayerCreditResult.updateTime
                this.dataForm.createTime = data.xylgTaxpayerCreditResult.createTime
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
              url: this.$http.adornUrl(`/spider/xylgtaxpayercreditresult/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'taxpayerName': this.dataForm.taxpayerName,
                'taxNo': this.dataForm.taxNo,
                'creditRating': this.dataForm.creditRating,
                'taxAuthority': this.dataForm.taxAuthority,
                'evaluationYear': this.dataForm.evaluationYear,
                'evaluationDate': this.dataForm.evaluationDate,
                'dataState': this.dataForm.dataState,
                'updateTime': this.dataForm.updateTime,
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
