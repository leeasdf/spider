<template>
  <el-dialog
    width="700px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
    <!-- <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="类别" prop="type">
          <el-input v-model="dataForm.type" placeholder="类别"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
   <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="证书编号" prop="certNo">
          <el-input v-model="dataForm.certNo" placeholder="证书编号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="发证日期" prop="publishDate">
          <el-date-picker type="date" v-model="dataForm.publishDate" placeholder="发证日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="截止日期" prop="deadlineDate">
          <el-date-picker type="date" v-model="dataForm.deadlineDate" placeholder="截止日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="数据状态" prop="dataState">
          <el-radio-group v-model="dataForm.dataState">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">删除</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
    </el-row>
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
          type: '',
          certNo: '',
          publishDate: '',
          deadlineDate: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          certNo: [
            { required: true, message: '证书编号不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '发证日期不能为空', trigger: 'blur' }
          ],
          deadlineDate: [
            { required: true, message: '截止日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttncertificate/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnCertificate.enterpriseId
                this.dataForm.entName = data.rptTnCertificate.entName
                this.dataForm.type = data.rptTnCertificate.type
                this.dataForm.certNo = data.rptTnCertificate.certNo
                this.dataForm.publishDate = data.rptTnCertificate.publishDate
                this.dataForm.deadlineDate = data.rptTnCertificate.deadlineDate
                this.dataForm.creator = data.rptTnCertificate.creator
                this.dataForm.createTime = data.rptTnCertificate.createTime
                this.dataForm.updater = data.rptTnCertificate.updater
                this.dataForm.updateTime = data.rptTnCertificate.updateTime
                this.dataForm.dataState = data.rptTnCertificate.dataState
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
              url: this.$http.adornUrl(`/spider/rpttncertificate/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'type': this.dataForm.type,
                'certNo': this.dataForm.certNo,
                'publishDate': this.dataForm.publishDate,
                'deadlineDate': this.dataForm.deadlineDate,
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
