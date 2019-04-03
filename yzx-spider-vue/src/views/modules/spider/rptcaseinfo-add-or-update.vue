<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="200px">
    <!-- <el-form-item label="会员ID" prop="memid">
      <el-input v-model="dataForm.memid" placeholder="会员ID"></el-input>
    </el-form-item> -->
    
    <el-form-item label="案发时间" prop="casetime">
      <!-- <el-input v-model="dataForm.casetime" placeholder="案发时间"></el-input> -->
      <el-date-picker v-model="dataForm.casetime" value-format="yyyy-MM-dd" placeholder="案发时间"></el-date-picker>
    </el-form-item>
    <el-form-item label="案由" prop="casereason">
      <el-input v-model="dataForm.casereason" placeholder="案由"></el-input>
    </el-form-item>
    <el-form-item label="案值" prop="caseval">
      <el-input v-model="dataForm.caseval" placeholder="案值"></el-input>
    </el-form-item>
    <el-form-item label="案件类型" prop="casetype">
      <el-input v-model="dataForm.casetype" placeholder="案件类型"></el-input>
    </el-form-item>
    <el-form-item label="执行类别" prop="exesort">
      <el-input v-model="dataForm.exesort" placeholder="执行类别"></el-input>
    </el-form-item>
    <el-form-item label="案件结果" prop="caseresult">
      <el-input v-model="dataForm.caseresult" placeholder="案件结果"></el-input>
    </el-form-item>
    <el-form-item label="处罚决定文书" prop="pendecno">
      <el-input v-model="dataForm.pendecno" placeholder="处罚决定文书"></el-input>
    </el-form-item>
    <el-form-item label="处罚决定书签发日期" prop="pendecissdate">
      <!-- <el-input v-model="dataForm.pendecissdate" placeholder="处罚决定书签发日期"></el-input> -->
      <el-date-picker v-model="dataForm.pendecissdate" value-format="yyyy-MM-dd" placeholder="处罚决定书签发日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="作出行政处罚决定机关名称" prop="penauth">
      <el-input v-model="dataForm.penauth" placeholder="作出行政处罚决定机关名称"></el-input>
    </el-form-item>
    <el-form-item label="主要违法事实" prop="illegfact">
      <el-input v-model="dataForm.illegfact" placeholder="主要违法事实"></el-input>
    </el-form-item>
    <el-form-item label="处罚依据" prop="penbasis">
      <el-input v-model="dataForm.penbasis" placeholder="处罚依据"></el-input>
    </el-form-item>
    <el-form-item label="处罚种类" prop="pentype">
      <el-input v-model="dataForm.pentype" placeholder="处罚种类"></el-input>
    </el-form-item>
    <el-form-item label="处罚结果" prop="penresult">
      <el-input v-model="dataForm.penresult" placeholder="处罚结果"></el-input>
    </el-form-item>
    <el-form-item label="处罚金额" prop="penam">
      <el-input v-model="dataForm.penam" placeholder="处罚金额"></el-input>
    </el-form-item>
    <el-form-item label="处罚执行情况" prop="penexest">
      <el-input v-model="dataForm.penexest" placeholder="处罚执行情况"></el-input>
    </el-form-item>
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
          id: 0,
          memid: '',
          enterpriseId: '',
          casetime: '',
          casereason: '',
          caseval: '',
          casetype: '',
          exesort: '',
          caseresult: '',
          pendecno: '',
          pendecissdate: '',
          penauth: '',
          illegfact: '',
          penbasis: '',
          pentype: '',
          penresult: '',
          penam: '',
          penexest: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          memid: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          casetime: [
            { required: true, message: '案发时间不能为空', trigger: 'blur' }
          ],
          casereason: [
            { required: true, message: '案由不能为空', trigger: 'blur' }
          ],
          caseval: [
            { required: true, message: '案值不能为空', trigger: 'blur' }
          ],
          casetype: [
            { required: true, message: '案件类型不能为空', trigger: 'blur' }
          ],
          exesort: [
            { required: true, message: '执行类别不能为空', trigger: 'blur' }
          ],
          caseresult: [
            { required: true, message: '案件结果不能为空', trigger: 'blur' }
          ],
          pendecno: [
            { required: true, message: '处罚决定文书不能为空', trigger: 'blur' }
          ],
          pendecissdate: [
            { required: true, message: '处罚决定书签发日期不能为空', trigger: 'blur' }
          ],
          penauth: [
            { required: true, message: '作出行政处罚决定机关名称不能为空', trigger: 'blur' }
          ],
          illegfact: [
            { required: true, message: '主要违法事实不能为空', trigger: 'blur' }
          ],
          penbasis: [
            { required: true, message: '处罚依据不能为空', trigger: 'blur' }
          ],
          pentype: [
            { required: true, message: '处罚种类不能为空', trigger: 'blur' }
          ],
          penresult: [
            { required: true, message: '处罚结果不能为空', trigger: 'blur' }
          ],
          penam: [
            { required: true, message: '处罚金额不能为空', trigger: 'blur' }
          ],
          penexest: [
            { required: true, message: '处罚执行情况不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
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
              url: this.$http.adornUrl(`/spider/rptcaseinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memid = data.rptCaseInfo.memid
                this.dataForm.enterpriseId = data.rptCaseInfo.enterpriseId
                this.dataForm.casetime = data.rptCaseInfo.casetime
                this.dataForm.casereason = data.rptCaseInfo.casereason
                this.dataForm.caseval = data.rptCaseInfo.caseval
                this.dataForm.casetype = data.rptCaseInfo.casetype
                this.dataForm.exesort = data.rptCaseInfo.exesort
                this.dataForm.caseresult = data.rptCaseInfo.caseresult
                this.dataForm.pendecno = data.rptCaseInfo.pendecno
                this.dataForm.pendecissdate = data.rptCaseInfo.pendecissdate
                this.dataForm.penauth = data.rptCaseInfo.penauth
                this.dataForm.illegfact = data.rptCaseInfo.illegfact
                this.dataForm.penbasis = data.rptCaseInfo.penbasis
                this.dataForm.pentype = data.rptCaseInfo.pentype
                this.dataForm.penresult = data.rptCaseInfo.penresult
                this.dataForm.penam = data.rptCaseInfo.penam
                this.dataForm.penexest = data.rptCaseInfo.penexest
                this.dataForm.creator = data.rptCaseInfo.creator
                this.dataForm.createTime = data.rptCaseInfo.createTime
                this.dataForm.updater = data.rptCaseInfo.updater
                this.dataForm.updateTime = data.rptCaseInfo.updateTime
                this.dataForm.dataState = data.rptCaseInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptcaseinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memid': this.dataForm.memid,
                'enterpriseId': this.dataForm.enterpriseId,
                'casetime': this.dataForm.casetime,
                'casereason': this.dataForm.casereason,
                'caseval': this.dataForm.caseval,
                'casetype': this.dataForm.casetype,
                'exesort': this.dataForm.exesort,
                'caseresult': this.dataForm.caseresult,
                'pendecno': this.dataForm.pendecno,
                'pendecissdate': this.dataForm.pendecissdate,
                'penauth': this.dataForm.penauth,
                'illegfact': this.dataForm.illegfact,
                'penbasis': this.dataForm.penbasis,
                'pentype': this.dataForm.pentype,
                'penresult': this.dataForm.penresult,
                'penam': this.dataForm.penam,
                'penexest': this.dataForm.penexest,
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
