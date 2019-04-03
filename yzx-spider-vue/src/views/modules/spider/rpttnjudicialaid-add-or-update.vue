<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="被执行人" prop="executedPerson">
      <el-input v-model="dataForm.executedPerson" placeholder="被执行人"></el-input>
    </el-form-item>
    <el-form-item label="股权数额" prop="equityAmountOther">
      <el-input v-model="dataForm.equityAmountOther" placeholder="股权数额"></el-input>
    </el-form-item>
    <el-form-item label="执行法院" prop="executiveCourt">
      <el-input v-model="dataForm.executiveCourt" placeholder="执行法院"></el-input>
    </el-form-item>
    <el-form-item label="执行通知文号" prop="executeNoticeNum">
      <el-input v-model="dataForm.executeNoticeNum" placeholder="执行通知文号"></el-input>
    </el-form-item>
    <el-form-item label="类型|状态" prop="executedPersonType">
      <el-input v-model="dataForm.executedPersonType" placeholder="类型|状态"></el-input>
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
          executedPerson: '',
          equityAmountOther: '',
          executiveCourt: '',
          executeNoticeNum: '',
          executedPersonType: '',
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
          executedPerson: [
            { required: true, message: '被执行人不能为空', trigger: 'blur' }
          ],
          equityAmountOther: [
            { required: true, message: '股权数额不能为空', trigger: 'blur' }
          ],
          executiveCourt: [
            { required: true, message: '执行法院不能为空', trigger: 'blur' }
          ],
          executeNoticeNum: [
            { required: true, message: '执行通知文号不能为空', trigger: 'blur' }
          ],
          executedPersonType: [
            { required: true, message: '类型|状态不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnjudicialaid/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnJudicialAid.enterpriseId
                this.dataForm.entName = data.rptTnJudicialAid.entName
                this.dataForm.executedPerson = data.rptTnJudicialAid.executedPerson
                this.dataForm.equityAmountOther = data.rptTnJudicialAid.equityAmountOther
                this.dataForm.executiveCourt = data.rptTnJudicialAid.executiveCourt
                this.dataForm.executeNoticeNum = data.rptTnJudicialAid.executeNoticeNum
                this.dataForm.executedPersonType = data.rptTnJudicialAid.executedPersonType
                this.dataForm.creator = data.rptTnJudicialAid.creator
                this.dataForm.createTime = data.rptTnJudicialAid.createTime
                this.dataForm.updater = data.rptTnJudicialAid.updater
                this.dataForm.updateTime = data.rptTnJudicialAid.updateTime
                this.dataForm.dataState = data.rptTnJudicialAid.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnjudicialaid/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'executedPerson': this.dataForm.executedPerson,
                'equityAmountOther': this.dataForm.equityAmountOther,
                'executiveCourt': this.dataForm.executiveCourt,
                'executeNoticeNum': this.dataForm.executeNoticeNum,
                'executedPersonType': this.dataForm.executedPersonType,
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
