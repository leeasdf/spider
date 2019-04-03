<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!--
    <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    -->
    <el-form-item label="纳税人名称" prop="taxName">
      <el-input v-model="dataForm.taxName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="纳税人识别号" prop="taxNo">
      <el-input v-model="dataForm.taxNo" placeholder="纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人(负责人)姓名" prop="legalName">
      <el-input v-model="dataForm.legalName" placeholder="法定代表人(负责人)姓名"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人(负责人)证件类型" prop="certType">
      <el-input v-model="dataForm.certType" placeholder="法定代表人(负责人)证件类型"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人(负责人)证件号码" prop="certNo">
      <el-input v-model="dataForm.certNo" placeholder="法定代表人(负责人)证件号码"></el-input>
    </el-form-item>
    <el-form-item label="经营地点" prop="address">
      <el-input v-model="dataForm.address" placeholder="经营地点"></el-input>
    </el-form-item>
    <el-form-item label="欠税税种" prop="oweTaxType">
      <el-input v-model="dataForm.oweTaxType" placeholder="欠税税种"></el-input>
    </el-form-item>
    <el-form-item label="欠税余额（元）" prop="oweTaxBalance">
      <el-input v-model="dataForm.oweTaxBalance" placeholder="欠税余额（元）"></el-input>
    </el-form-item>
    <el-form-item label="当期新发生的欠税金额（元）" prop="currentOccurreAmount">
      <el-input v-model="dataForm.currentOccurreAmount" placeholder="当期新发生的欠税金额（元）"></el-input>
    </el-form-item>
    <el-form-item label="公示时间" prop="publishDate">
      <el-input v-model="dataForm.publishDate" placeholder="公示时间"></el-input>
    </el-form-item>
    <!--
    <el-form-item label="数据来源" prop="dataSource">
      <el-input v-model="dataForm.dataSource" placeholder="数据来源"></el-input>
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
    -->
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
          taxName: '',
          taxNo: '',
          legalName: '',
          certType: '',
          certNo: '',
          address: '',
          oweTaxType: '',
          oweTaxBalance: '',
          currentOccurreAmount: '',
          publishDate: '',
          dataSource: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          taxName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxNo: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          legalName: [
            { required: true, message: '法定代表人(负责人)姓名不能为空', trigger: 'blur' }
          ],
          certType: [
            { required: true, message: '法定代表人(负责人)证件类型不能为空', trigger: 'blur' }
          ],
          certNo: [
            { required: true, message: '法定代表人(负责人)证件号码不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '经营地点不能为空', trigger: 'blur' }
          ],
          oweTaxType: [
            { required: true, message: '欠税税种不能为空', trigger: 'blur' }
          ],
          oweTaxBalance: [
            { required: true, message: '欠税余额（元）不能为空', trigger: 'blur' }
          ],
          currentOccurreAmount: [
            { required: true, message: '当期新发生的欠税金额（元）不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '公示时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/hntaxowetaxinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.hntaxOweTaxInfo.enterpriseId
                this.dataForm.entName = data.hntaxOweTaxInfo.entName
                this.dataForm.taxName = data.hntaxOweTaxInfo.taxName
                this.dataForm.taxNo = data.hntaxOweTaxInfo.taxNo
                this.dataForm.legalName = data.hntaxOweTaxInfo.legalName
                this.dataForm.certType = data.hntaxOweTaxInfo.certType
                this.dataForm.certNo = data.hntaxOweTaxInfo.certNo
                this.dataForm.address = data.hntaxOweTaxInfo.address
                this.dataForm.oweTaxType = data.hntaxOweTaxInfo.oweTaxType
                this.dataForm.oweTaxBalance = data.hntaxOweTaxInfo.oweTaxBalance
                this.dataForm.currentOccurreAmount = data.hntaxOweTaxInfo.currentOccurreAmount
                this.dataForm.publishDate = data.hntaxOweTaxInfo.publishDate
                this.dataForm.dataSource = data.hntaxOweTaxInfo.dataSource
                this.dataForm.creator = data.hntaxOweTaxInfo.creator
                this.dataForm.createTime = data.hntaxOweTaxInfo.createTime
                this.dataForm.updater = data.hntaxOweTaxInfo.updater
                this.dataForm.updateTime = data.hntaxOweTaxInfo.updateTime
                this.dataForm.dataState = data.hntaxOweTaxInfo.dataState
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
              url: this.$http.adornUrl(`/spider/hntaxowetaxinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'taxName': this.dataForm.taxName,
                'taxNo': this.dataForm.taxNo,
                'legalName': this.dataForm.legalName,
                'certType': this.dataForm.certType,
                'certNo': this.dataForm.certNo,
                'address': this.dataForm.address,
                'oweTaxType': this.dataForm.oweTaxType,
                'oweTaxBalance': this.dataForm.oweTaxBalance,
                'currentOccurreAmount': this.dataForm.currentOccurreAmount,
                'publishDate': this.dataForm.publishDate,
                'dataSource': this.dataForm.dataSource,
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
