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
    <el-form-item label="认缴出资时间" prop="paidDate">
      <el-input v-model="dataForm.paidDate" placeholder="认缴出资时间"></el-input>
    </el-form-item>
    <el-form-item label="股东url" prop="nameUrl">
      <el-input v-model="dataForm.nameUrl" placeholder="股东url"></el-input>
    </el-form-item>
    <el-form-item label="股东" prop="name">
      <el-input v-model="dataForm.name" placeholder="股东"></el-input>
    </el-form-item>
    <el-form-item label="认缴出资方式" prop="paidInvestType">
      <el-input v-model="dataForm.paidInvestType" placeholder="认缴出资方式"></el-input>
    </el-form-item>
    <el-form-item label="实缴出资方式" prop="actInvestType">
      <el-input v-model="dataForm.actInvestType" placeholder="实缴出资方式"></el-input>
    </el-form-item>
    <el-form-item label="认缴出资额（万元）" prop="paidAmount">
      <el-input v-model="dataForm.paidAmount" placeholder="认缴出资额（万元）"></el-input>
    </el-form-item>
    <el-form-item label="实缴出资额（万元）" prop="actAmount">
      <el-input v-model="dataForm.actAmount" placeholder="实缴出资额（万元）"></el-input>
    </el-form-item>
    <el-form-item label="实缴出资时间" prop="actDate">
      <el-input v-model="dataForm.actDate" placeholder="实缴出资时间"></el-input>
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
          paidDate: '',
          nameUrl: '',
          name: '',
          paidInvestType: '',
          actInvestType: '',
          paidAmount: '',
          actAmount: '',
          actDate: '',
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
          paidDate: [
            { required: true, message: '认缴出资时间不能为空', trigger: 'blur' }
          ],
          nameUrl: [
            { required: true, message: '股东url不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '股东不能为空', trigger: 'blur' }
          ],
          paidInvestType: [
            { required: true, message: '认缴出资方式不能为空', trigger: 'blur' }
          ],
          actInvestType: [
            { required: true, message: '实缴出资方式不能为空', trigger: 'blur' }
          ],
          paidAmount: [
            { required: true, message: '认缴出资额（万元）不能为空', trigger: 'blur' }
          ],
          actAmount: [
            { required: true, message: '实缴出资额（万元）不能为空', trigger: 'blur' }
          ],
          actDate: [
            { required: true, message: '实缴出资时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnreportshareholder/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnReportShareholder.enterpriseId
                this.dataForm.entName = data.rptTnReportShareholder.entName
                this.dataForm.reportId = data.rptTnReportShareholder.reportId
                this.dataForm.paidDate = data.rptTnReportShareholder.paidDate
                this.dataForm.nameUrl = data.rptTnReportShareholder.nameUrl
                this.dataForm.name = data.rptTnReportShareholder.name
                this.dataForm.paidInvestType = data.rptTnReportShareholder.paidInvestType
                this.dataForm.actInvestType = data.rptTnReportShareholder.actInvestType
                this.dataForm.paidAmount = data.rptTnReportShareholder.paidAmount
                this.dataForm.actAmount = data.rptTnReportShareholder.actAmount
                this.dataForm.actDate = data.rptTnReportShareholder.actDate
                this.dataForm.creator = data.rptTnReportShareholder.creator
                this.dataForm.createTime = data.rptTnReportShareholder.createTime
                this.dataForm.updater = data.rptTnReportShareholder.updater
                this.dataForm.updateTime = data.rptTnReportShareholder.updateTime
                this.dataForm.dataState = data.rptTnReportShareholder.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnreportshareholder/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'reportId': this.dataForm.reportId,
                'paidDate': this.dataForm.paidDate,
                'nameUrl': this.dataForm.nameUrl,
                'name': this.dataForm.name,
                'paidInvestType': this.dataForm.paidInvestType,
                'actInvestType': this.dataForm.actInvestType,
                'paidAmount': this.dataForm.paidAmount,
                'actAmount': this.dataForm.actAmount,
                'actDate': this.dataForm.actDate,
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
