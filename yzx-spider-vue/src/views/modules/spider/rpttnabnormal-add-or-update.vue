<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="决定机关" prop="agency">
          <el-input v-model="dataForm.agency" placeholder="决定机关"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="列入日期" prop="date">
          <el-date-picker v-model="dataForm.date" value-format="yyyy-MM-dd" placeholder="列入日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="移除机关" prop="removeAgency">
          <el-input v-model="dataForm.removeAgency" placeholder="移除机关"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
         <el-form-item label="移除日期" prop="removeDate">
          <el-date-picker v-model="dataForm.removeDate" value-format="yyyy-MM-dd" placeholder="移除日期">></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="列入原因" prop="reason">
      <el-input type="textarea" v-model="dataForm.reason" placeholder="列入原因"></el-input>
    </el-form-item>
    <el-form-item label="移除原因" prop="removeReason">
      <el-input type="textarea" v-model="dataForm.removeReason" placeholder="移除原因"></el-input>
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
          agency: '',
          reason: '',
          removeDate: '',
          removeAgency: '',
          removeReason: '',
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
          date: [
            { required: true, message: '列入日期不能为空', trigger: 'blur' }
          ],
          agency: [
            { required: true, message: '决定机关不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '列入原因不能为空', trigger: 'blur' }
          ],
          removeDate: [
            { required: true, message: '移除日期不能为空', trigger: 'blur' }
          ],
          removeAgency: [
            { required: true, message: '移除机关不能为空', trigger: 'blur' }
          ],
          removeReason: [
            { required: true, message: '移除原因不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnabnormal/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnAbnormal.enterpriseId
                this.dataForm.entName = data.rptTnAbnormal.entName
                this.dataForm.date = data.rptTnAbnormal.date
                this.dataForm.agency = data.rptTnAbnormal.agency
                this.dataForm.reason = data.rptTnAbnormal.reason
                this.dataForm.removeDate = data.rptTnAbnormal.removeDate
                this.dataForm.removeAgency = data.rptTnAbnormal.removeAgency
                this.dataForm.removeReason = data.rptTnAbnormal.removeReason
                this.dataForm.creator = data.rptTnAbnormal.creator
                this.dataForm.createTime = data.rptTnAbnormal.createTime
                this.dataForm.updater = data.rptTnAbnormal.updater
                this.dataForm.updateTime = data.rptTnAbnormal.updateTime
                this.dataForm.dataState = data.rptTnAbnormal.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnabnormal/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'date': this.dataForm.date,
                'agency': this.dataForm.agency,
                'reason': this.dataForm.reason,
                'removeDate': this.dataForm.removeDate,
                'removeAgency': this.dataForm.removeAgency,
                'removeReason': this.dataForm.removeReason,
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
