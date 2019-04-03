<template>
  <el-dialog
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
    <el-form-item label="决定日期" prop="result">
      <el-input v-model="dataForm.result" placeholder="决定日期"></el-input>
    </el-form-item>
    <el-form-item label="决定书文号" prop="departmentName">
      <el-input v-model="dataForm.departmentName" placeholder="决定书文号"></el-input>
    </el-form-item>
    <el-form-item label="类型" prop="reason">
      <el-input v-model="dataForm.reason" placeholder="类型"></el-input>
    </el-form-item>
    <el-form-item label="决定机关" prop="punishName">
      <el-input v-model="dataForm.punishName" placeholder="决定机关"></el-input>
    </el-form-item>
    <el-form-item label="处罚内容" prop="evidence">
      <el-input v-model="dataForm.evidence" placeholder="处罚内容"></el-input>
    </el-form-item>
    <el-form-item label="地域" prop="areaName">
      <el-input v-model="dataForm.areaName" placeholder="地域"></el-input>
    </el-form-item>
    <el-form-item label="处罚名称" prop="punishNumber">
      <el-input v-model="dataForm.punishNumber" placeholder="处罚名称"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="typeSecond">
      <el-input v-model="dataForm.typeSecond" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="type">
      <el-input v-model="dataForm.type" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="发布日期" prop="decisionDate">
      <el-input v-model="dataForm.decisionDate" placeholder="发布日期"></el-input>
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
          result: '',
          departmentName: '',
          reason: '',
          punishName: '',
          evidence: '',
          areaName: '',
          punishNumber: '',
          typeSecond: '',
          type: '',
          decisionDate: '',
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
          result: [
            { required: true, message: '决定日期不能为空', trigger: 'blur' }
          ],
          departmentName: [
            { required: true, message: '决定书文号不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          punishName: [
            { required: true, message: '决定机关不能为空', trigger: 'blur' }
          ],
          evidence: [
            { required: true, message: '处罚内容不能为空', trigger: 'blur' }
          ],
          areaName: [
            { required: true, message: '地域不能为空', trigger: 'blur' }
          ],
          punishNumber: [
            { required: true, message: '处罚名称不能为空', trigger: 'blur' }
          ],
          typeSecond: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          decisionDate: [
            { required: true, message: '发布日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/api/rpttnpunishcreditchina/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnPunishCreditchina.enterpriseId
                this.dataForm.entName = data.rptTnPunishCreditchina.entName
                this.dataForm.result = data.rptTnPunishCreditchina.result
                this.dataForm.departmentName = data.rptTnPunishCreditchina.departmentName
                this.dataForm.reason = data.rptTnPunishCreditchina.reason
                this.dataForm.punishName = data.rptTnPunishCreditchina.punishName
                this.dataForm.evidence = data.rptTnPunishCreditchina.evidence
                this.dataForm.areaName = data.rptTnPunishCreditchina.areaName
                this.dataForm.punishNumber = data.rptTnPunishCreditchina.punishNumber
                this.dataForm.typeSecond = data.rptTnPunishCreditchina.typeSecond
                this.dataForm.type = data.rptTnPunishCreditchina.type
                this.dataForm.decisionDate = data.rptTnPunishCreditchina.decisionDate
                this.dataForm.creator = data.rptTnPunishCreditchina.creator
                this.dataForm.createTime = data.rptTnPunishCreditchina.createTime
                this.dataForm.updater = data.rptTnPunishCreditchina.updater
                this.dataForm.updateTime = data.rptTnPunishCreditchina.updateTime
                this.dataForm.dataState = data.rptTnPunishCreditchina.dataState
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
              url: this.$http.adornUrl(`/api/rpttnpunishcreditchina/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'result': this.dataForm.result,
                'departmentName': this.dataForm.departmentName,
                'reason': this.dataForm.reason,
                'punishName': this.dataForm.punishName,
                'evidence': this.dataForm.evidence,
                'areaName': this.dataForm.areaName,
                'punishNumber': this.dataForm.punishNumber,
                'typeSecond': this.dataForm.typeSecond,
                'type': this.dataForm.type,
                'decisionDate': this.dataForm.decisionDate,
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
