<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item>
    <el-form-item label="资质名称" prop="qualificationName">
      <el-input v-model="dataForm.qualificationName" placeholder="资质名称"></el-input>
    </el-form-item>
    <el-form-item label="资质类型" prop="qualificationType">
      <el-input v-model="dataForm.qualificationType" placeholder="资质类型"></el-input>
    </el-form-item>
    <el-form-item label="发证机构" prop="certificateAuthority">
      <el-input v-model="dataForm.certificateAuthority" placeholder="发证机构"></el-input>
    </el-form-item>
    <el-form-item label="证书编号" prop="certificateId">
      <el-input v-model="dataForm.certificateId" placeholder="证书编号"></el-input>
    </el-form-item>
    <el-form-item label="发证时间" prop="certificateTime">
      <el-input v-model="dataForm.certificateTime" placeholder="发证时间"></el-input>
    </el-form-item>
    <el-form-item label="资质附件" prop="qualificationAccessory">
      <el-input v-model="dataForm.qualificationAccessory" placeholder="资质附件"></el-input>
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
          enterpriseQualificationId: 0,
          memId: '',
          qualificationName: '',
          qualificationType: '',
          certificateAuthority: '',
          certificateId: '',
          certificateTime: '',
          qualificationAccessory: '',
          dataState: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          qualificationName: [
            { required: true, message: '资质名称不能为空', trigger: 'blur' }
          ],
          qualificationType: [
            { required: true, message: '资质类型不能为空', trigger: 'blur' }
          ],
          certificateAuthority: [
            { required: true, message: '发证机构不能为空', trigger: 'blur' }
          ],
          certificateId: [
            { required: true, message: '证书编号不能为空', trigger: 'blur' }
          ],
          certificateTime: [
            { required: true, message: '发证时间不能为空', trigger: 'blur' }
          ],
          qualificationAccessory: [
            { required: true, message: '资质附件不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
          ],
          creator: [
            { required: true, message: '创建人ID不能为空', trigger: 'blur' }
          ],
          updater: [
            { required: true, message: '修改人ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.enterpriseQualificationId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.enterpriseQualificationId) {
            this.$http({
              url: this.$http.adornUrl(`/spider/enterprisequalification/info/${this.dataForm.enterpriseQualificationId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.enterpriseQualification.memId
                this.dataForm.qualificationName = data.enterpriseQualification.qualificationName
                this.dataForm.qualificationType = data.enterpriseQualification.qualificationType
                this.dataForm.certificateAuthority = data.enterpriseQualification.certificateAuthority
                this.dataForm.certificateId = data.enterpriseQualification.certificateId
                this.dataForm.certificateTime = data.enterpriseQualification.certificateTime
                this.dataForm.qualificationAccessory = data.enterpriseQualification.qualificationAccessory
                this.dataForm.dataState = data.enterpriseQualification.dataState
                this.dataForm.creator = data.enterpriseQualification.creator
                this.dataForm.createTime = data.enterpriseQualification.createTime
                this.dataForm.updater = data.enterpriseQualification.updater
                this.dataForm.updateTime = data.enterpriseQualification.updateTime
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
              url: this.$http.adornUrl(`/spider/enterprisequalification/${!this.dataForm.enterpriseQualificationId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'enterpriseQualificationId': this.dataForm.enterpriseQualificationId || undefined,
                'memId': this.dataForm.memId,
                'qualificationName': this.dataForm.qualificationName,
                'qualificationType': this.dataForm.qualificationType,
                'certificateAuthority': this.dataForm.certificateAuthority,
                'certificateId': this.dataForm.certificateId,
                'certificateTime': this.dataForm.certificateTime,
                'qualificationAccessory': this.dataForm.qualificationAccessory,
                'dataState': this.dataForm.dataState,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime
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
