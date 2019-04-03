<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="年报主键" prop="reportId">
      <el-input v-model="dataForm.reportId" placeholder="年报主键"></el-input>
    </el-form-item>
    <el-form-item label="资产总额" prop="totalAmount">
      <el-input v-model="dataForm.totalAmount" placeholder="资产总额"></el-input>
    </el-form-item>
    <el-form-item label="所有者权益合计" prop="ownerAmount">
      <el-input v-model="dataForm.ownerAmount" placeholder="所有者权益合计"></el-input>
    </el-form-item>
    <el-form-item label="销售总额" prop="saleAmount">
      <el-input v-model="dataForm.saleAmount" placeholder="销售总额"></el-input>
    </el-form-item>
    <el-form-item label="利润总额" prop="profitAmount">
      <el-input v-model="dataForm.profitAmount" placeholder="利润总额"></el-input>
    </el-form-item>
    <el-form-item label="营业总收入中主营业务收入" prop="mainBusinessIncome">
      <el-input v-model="dataForm.mainBusinessIncome" placeholder="营业总收入中主营业务收入"></el-input>
    </el-form-item>
    <el-form-item label="净利润" prop="netProfitAmount">
      <el-input v-model="dataForm.netProfitAmount" placeholder="净利润"></el-input>
    </el-form-item>
    <el-form-item label="纳税总额" prop="taxAmount">
      <el-input v-model="dataForm.taxAmount" placeholder="纳税总额"></el-input>
    </el-form-item>
    <el-form-item label=" 负债总额" prop="indebtAmount">
      <el-input v-model="dataForm.indebtAmount" placeholder=" 负债总额"></el-input>
    </el-form-item>
    <el-form-item label="创建人ID" prop="creator">
      <el-input v-model="dataForm.creator" placeholder="创建人ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人ID" prop="updater">
      <el-input v-model="dataForm.updater" placeholder="修改人ID"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="数据状态：1-正常 0-删除" prop="dataState">
      <el-input v-model="dataForm.dataState" placeholder="数据状态：1-正常 0-删除"></el-input>
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
          enterpriseId: '',
          entName: '',
          reportId: '',
          totalAmount: '',
          ownerAmount: '',
          saleAmount: '',
          profitAmount: '',
          mainBusinessIncome: '',
          netProfitAmount: '',
          taxAmount: '',
          indebtAmount: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          reportId: [
            { required: true, message: '年报主键不能为空', trigger: 'blur' }
          ],
          totalAmount: [
            { required: true, message: '资产总额不能为空', trigger: 'blur' }
          ],
          ownerAmount: [
            { required: true, message: '所有者权益合计不能为空', trigger: 'blur' }
          ],
          saleAmount: [
            { required: true, message: '销售总额不能为空', trigger: 'blur' }
          ],
          profitAmount: [
            { required: true, message: '利润总额不能为空', trigger: 'blur' }
          ],
          mainBusinessIncome: [
            { required: true, message: '营业总收入中主营业务收入不能为空', trigger: 'blur' }
          ],
          netProfitAmount: [
            { required: true, message: '净利润不能为空', trigger: 'blur' }
          ],
          taxAmount: [
            { required: true, message: '纳税总额不能为空', trigger: 'blur' }
          ],
          indebtAmount: [
            { required: true, message: ' 负债总额不能为空', trigger: 'blur' }
          ],
          creator: [
            { required: true, message: '创建人ID不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updater: [
            { required: true, message: '修改人ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnreportamount/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnReportAmount.enterpriseId
                this.dataForm.entName = data.rptTnReportAmount.entName
                this.dataForm.reportId = data.rptTnReportAmount.reportId
                this.dataForm.totalAmount = data.rptTnReportAmount.totalAmount
                this.dataForm.ownerAmount = data.rptTnReportAmount.ownerAmount
                this.dataForm.saleAmount = data.rptTnReportAmount.saleAmount
                this.dataForm.profitAmount = data.rptTnReportAmount.profitAmount
                this.dataForm.mainBusinessIncome = data.rptTnReportAmount.mainBusinessIncome
                this.dataForm.netProfitAmount = data.rptTnReportAmount.netProfitAmount
                this.dataForm.taxAmount = data.rptTnReportAmount.taxAmount
                this.dataForm.indebtAmount = data.rptTnReportAmount.indebtAmount
                this.dataForm.creator = data.rptTnReportAmount.creator
                this.dataForm.createTime = data.rptTnReportAmount.createTime
                this.dataForm.updater = data.rptTnReportAmount.updater
                this.dataForm.updateTime = data.rptTnReportAmount.updateTime
                this.dataForm.dataState = data.rptTnReportAmount.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnreportamount/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'reportId': this.dataForm.reportId,
                'totalAmount': this.dataForm.totalAmount,
                'ownerAmount': this.dataForm.ownerAmount,
                'saleAmount': this.dataForm.saleAmount,
                'profitAmount': this.dataForm.profitAmount,
                'mainBusinessIncome': this.dataForm.mainBusinessIncome,
                'netProfitAmount': this.dataForm.netProfitAmount,
                'taxAmount': this.dataForm.taxAmount,
                'indebtAmount': this.dataForm.indebtAmount,
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
