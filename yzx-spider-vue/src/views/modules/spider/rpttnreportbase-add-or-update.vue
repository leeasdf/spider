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
    <el-form-item label="统一社会信息代码" prop="creditCode">
      <el-input v-model="dataForm.creditCode" placeholder="统一社会信息代码"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="企业联系电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="企业联系电话"></el-input>
    </el-form-item>
    <el-form-item label="邮政编码" prop="postalcode">
      <el-input v-model="dataForm.postalcode" placeholder="邮政编码"></el-input>
    </el-form-item>
    <el-form-item label="企业经营状况" prop="status">
      <el-input v-model="dataForm.status" placeholder="企业经营状况"></el-input>
    </el-form-item>
    <el-form-item label="从业人数" prop="employeeCount">
      <el-input v-model="dataForm.employeeCount" placeholder="从业人数"></el-input>
    </el-form-item>
    <el-form-item label="电子邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="电子邮箱"></el-input>
    </el-form-item>
    <el-form-item label=" 是否有网站或网点" prop="websiteFlag">
      <el-input v-model="dataForm.websiteFlag" placeholder=" 是否有网站或网点"></el-input>
    </el-form-item>
    <el-form-item label="企业通信地址" prop="address">
      <el-input v-model="dataForm.address" placeholder="企业通信地址"></el-input>
    </el-form-item>
    <el-form-item label="企业是否有投资信息或购买其他公司股权" prop="investFlag">
      <el-input v-model="dataForm.investFlag" placeholder="企业是否有投资信息或购买其他公司股权"></el-input>
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
          creditCode: '',
          name: '',
          phone: '',
          postalcode: '',
          status: '',
          employeeCount: '',
          email: '',
          websiteFlag: '',
          address: '',
          investFlag: '',
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
          creditCode: [
            { required: true, message: '统一社会信息代码不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '企业联系电话不能为空', trigger: 'blur' }
          ],
          postalcode: [
            { required: true, message: '邮政编码不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '企业经营状况不能为空', trigger: 'blur' }
          ],
          employeeCount: [
            { required: true, message: '从业人数不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '电子邮箱不能为空', trigger: 'blur' }
          ],
          websiteFlag: [
            { required: true, message: ' 是否有网站或网点不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '企业通信地址不能为空', trigger: 'blur' }
          ],
          investFlag: [
            { required: true, message: '企业是否有投资信息或购买其他公司股权不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnreportbase/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnReportBase.enterpriseId
                this.dataForm.entName = data.rptTnReportBase.entName
                this.dataForm.reportId = data.rptTnReportBase.reportId
                this.dataForm.creditCode = data.rptTnReportBase.creditCode
                this.dataForm.name = data.rptTnReportBase.name
                this.dataForm.phone = data.rptTnReportBase.phone
                this.dataForm.postalcode = data.rptTnReportBase.postalcode
                this.dataForm.status = data.rptTnReportBase.status
                this.dataForm.employeeCount = data.rptTnReportBase.employeeCount
                this.dataForm.email = data.rptTnReportBase.email
                this.dataForm.websiteFlag = data.rptTnReportBase.websiteFlag
                this.dataForm.address = data.rptTnReportBase.address
                this.dataForm.investFlag = data.rptTnReportBase.investFlag
                this.dataForm.creator = data.rptTnReportBase.creator
                this.dataForm.createTime = data.rptTnReportBase.createTime
                this.dataForm.updater = data.rptTnReportBase.updater
                this.dataForm.updateTime = data.rptTnReportBase.updateTime
                this.dataForm.dataState = data.rptTnReportBase.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnreportbase/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'reportId': this.dataForm.reportId,
                'creditCode': this.dataForm.creditCode,
                'name': this.dataForm.name,
                'phone': this.dataForm.phone,
                'postalcode': this.dataForm.postalcode,
                'status': this.dataForm.status,
                'employeeCount': this.dataForm.employeeCount,
                'email': this.dataForm.email,
                'websiteFlag': this.dataForm.websiteFlag,
                'address': this.dataForm.address,
                'investFlag': this.dataForm.investFlag,
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
