<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="日期" prop="date">
            <el-date-picker v-model="dataForm.date" value-format="yyyy-MM-dd" placeholder="日期"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="案由" prop="reason">
            <el-input v-model="dataForm.reason" placeholder="案由"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="案号" prop="caseNum">
            <el-input v-model="dataForm.caseNum" placeholder="案号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="案件身份" prop="identity">
        <el-input type="textarea" v-model="dataForm.identity" placeholder="案件身份"></el-input>
      </el-form-item>
      <el-form-item label="裁判文书" prop="referee">
        <el-input type="textarea" v-model="dataForm.referee" placeholder="裁判文书"></el-input>
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
          enterpriseId: '',
          entName: '',
          date: '',
          referee: '',
          reason: '',
          identity: '',
          caseNum: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          plaintiff: '',
          defendant: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          date: [
            { required: true, message: '日期不能为空', trigger: 'blur' }
          ],
          referee: [
            { required: true, message: '裁判文书不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '案由不能为空', trigger: 'blur' }
          ],
          identity: [
            { required: true, message: '案件身份不能为空', trigger: 'blur' }
          ],
          caseNum: [
            { required: true, message: '案号不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ]
          /* plaintiff: [
            { required: true, message: '待定不能为空', trigger: 'blur' }
          ],
          defendant: [
            { required: true, message: '待定不能为空', trigger: 'blur' }
          ] */
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
              url: this.$http.adornUrl(`/spider/rpttnlawsuit/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnLawsuit.enterpriseId
                this.dataForm.entName = data.rptTnLawsuit.entName
                this.dataForm.date = data.rptTnLawsuit.date
                this.dataForm.referee = data.rptTnLawsuit.referee
                this.dataForm.reason = data.rptTnLawsuit.reason
                this.dataForm.identity = data.rptTnLawsuit.identity
                this.dataForm.caseNum = data.rptTnLawsuit.caseNum
                this.dataForm.creator = data.rptTnLawsuit.creator
                this.dataForm.createTime = data.rptTnLawsuit.createTime
                this.dataForm.updater = data.rptTnLawsuit.updater
                this.dataForm.updateTime = data.rptTnLawsuit.updateTime
                this.dataForm.dataState = data.rptTnLawsuit.dataState
                this.dataForm.plaintiff = data.rptTnLawsuit.plaintiff
                this.dataForm.defendant = data.rptTnLawsuit.defendant
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
              url: this.$http.adornUrl(`/spider/rpttnlawsuit/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'date': this.dataForm.date,
                'referee': this.dataForm.referee,
                'reason': this.dataForm.reason,
                'identity': this.dataForm.identity,
                'caseNum': this.dataForm.caseNum,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'plaintiff': this.dataForm.plaintiff,
                'defendant': this.dataForm.defendant
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
