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
    <el-form-item label="许可书文编号" prop="licenseNo">
      <el-input v-model="dataForm.licenseNo" placeholder="许可书文编号"></el-input>
    </el-form-item>
    <el-form-item label="许可文件名称" prop="licenseName">
      <el-input v-model="dataForm.licenseName" placeholder="许可文件名称"></el-input>
    </el-form-item>
    <el-form-item label="有效期自" prop="validateFrom">
      <el-input v-model="dataForm.validateFrom" placeholder="有效期自"></el-input>
    </el-form-item>
    <el-form-item label="有限期至" prop="validateTo">
      <el-input v-model="dataForm.validateTo" placeholder="有限期至"></el-input>
    </el-form-item>
    <el-form-item label="许可机关" prop="authority">
      <el-input v-model="dataForm.authority" placeholder="许可机关"></el-input>
    </el-form-item>
    <el-form-item label="许可内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="许可内容"></el-input>
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
          licenseNo: '',
          licenseName: '',
          validateFrom: '',
          validateTo: '',
          authority: '',
          content: '',
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
          licenseNo: [
            { required: true, message: '许可书文编号不能为空', trigger: 'blur' }
          ],
          licenseName: [
            { required: true, message: '许可文件名称不能为空', trigger: 'blur' }
          ],
          validateFrom: [
            { required: true, message: '有效期自不能为空', trigger: 'blur' }
          ],
          validateTo: [
            { required: true, message: '有限期至不能为空', trigger: 'blur' }
          ],
          authority: [
            { required: true, message: '许可机关不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '许可内容不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttninvestevent/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnInvestEvent.enterpriseId
                this.dataForm.entName = data.rptTnInvestEvent.entName
                this.dataForm.licenseNo = data.rptTnInvestEvent.licenseNo
                this.dataForm.licenseName = data.rptTnInvestEvent.licenseName
                this.dataForm.validateFrom = data.rptTnInvestEvent.validateFrom
                this.dataForm.validateTo = data.rptTnInvestEvent.validateTo
                this.dataForm.authority = data.rptTnInvestEvent.authority
                this.dataForm.content = data.rptTnInvestEvent.content
                this.dataForm.creator = data.rptTnInvestEvent.creator
                this.dataForm.createTime = data.rptTnInvestEvent.createTime
                this.dataForm.updater = data.rptTnInvestEvent.updater
                this.dataForm.updateTime = data.rptTnInvestEvent.updateTime
                this.dataForm.dataState = data.rptTnInvestEvent.dataState
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
              url: this.$http.adornUrl(`/spider/rpttninvestevent/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'licenseNo': this.dataForm.licenseNo,
                'licenseName': this.dataForm.licenseName,
                'validateFrom': this.dataForm.validateFrom,
                'validateTo': this.dataForm.validateTo,
                'authority': this.dataForm.authority,
                'content': this.dataForm.content,
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
