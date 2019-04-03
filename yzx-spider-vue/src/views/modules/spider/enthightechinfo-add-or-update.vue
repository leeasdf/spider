<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <el-form-item label="年份" prop="year">
      <el-date-picker type="year" v-model="dataForm.year" placeholder="年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="批次" prop="batch">
      <el-input v-model="dataForm.batch" placeholder="批次"></el-input>
    </el-form-item>
    <el-form-item label="类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型（更名、复审、认定等）"></el-input>
    </el-form-item>
    <el-form-item label="原企业名称" prop="entOldName">
      <el-input v-model="dataForm.entOldName" placeholder="原企业名称"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="company">
      <el-input v-model="dataForm.company" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="认定证书编号" prop="qualificateNo">
      <el-input v-model="dataForm.qualificateNo" placeholder="认定证书编号"></el-input>
    </el-form-item>
    <el-form-item label="认定批文" prop="qualificateLicence">
      <el-input v-model="dataForm.qualificateLicence" placeholder="认定批文"></el-input>
    </el-form-item>
    <el-form-item label="公示日期" prop="publicityDate">
     <el-date-picker v-model="dataForm.publicityDate" value-format="yyyy-MM-dd" placeholder="公示日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="发证日期" prop="issuingDate">
      <el-date-picker v-model="dataForm.issuingDate" value-format="yyyy-MM-dd" placeholder="发证日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="是否高新区企业" prop="isInZone">
     <!--  <el-input v-model="dataForm.isInZone" placeholder="是否高新区企业"></el-input> -->
     <el-radio-group v-model="dataForm.isInZone">
       <el-radio :label="1">是</el-radio>
       <el-radio :label="0">否</el-radio>
     </el-radio-group>
    </el-form-item>
    <el-form-item label="变更类型" prop="changeType">
      <el-input v-model="dataForm.changeType" placeholder="变更类型"></el-input>
    </el-form-item>
    <el-form-item label="变更原因" prop="changeReason">
      <el-input v-model="dataForm.changeReason" placeholder="变更原因"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="note">
      <el-input v-model="dataForm.note" placeholder="备注"></el-input>
    </el-form-item>
   <!--  <el-form-item label="对应mem_base_info的mem_id" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="对应mem_base_info的mem_id"></el-input>
    </el-form-item> -->
    
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
          year: '',
          batch: '',
          type: '',
          entOldName: '',
          company: '',
          qualificateNo: '',
          qualificateLicence: '',
          publicityDate: '',
          issuingDate: '',
          isInZone: '',
          changeType: '',
          changeReason: '',
          note: '',
          memId: '',
          enterpriseId: ''
        },
        dataRule: {
          year: [
            { required: true, message: '年份不能为空', trigger: 'blur' }
          ],
          batch: [
            { required: true, message: '批次不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型（更名、复审、认定等）不能为空', trigger: 'blur' }
          ],
          entOldName: [
            { required: true, message: '原企业名称不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          qualificateNo: [
            { required: true, message: '认定证书编号不能为空', trigger: 'blur' }
          ],
          qualificateLicence: [
            { required: true, message: '认定批文不能为空', trigger: 'blur' }
          ],
          publicityDate: [
            { required: true, message: '公示日期不能为空', trigger: 'blur' }
          ],
          issuingDate: [
            { required: true, message: '发证日期不能为空', trigger: 'blur' }
          ],
          isInZone: [
            { required: true, message: '是否高新区企业不能为空', trigger: 'change' }
          ],
          changeType: [
            { required: true, message: '变更类型不能为空', trigger: 'blur' }
          ],
          changeReason: [
            { required: true, message: '变更原因不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
          /* memId: [
            { required: true, message: '对应mem_base_info的mem_id不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.year = data.entHighTechInfo.year
                this.dataForm.batch = data.entHighTechInfo.batch
                this.dataForm.type = data.entHighTechInfo.type
                this.dataForm.entOldName = data.entHighTechInfo.entOldName
                this.dataForm.company = data.entHighTechInfo.company
                this.dataForm.qualificateNo = data.entHighTechInfo.qualificateNo
                this.dataForm.qualificateLicence = data.entHighTechInfo.qualificateLicence
                this.dataForm.publicityDate = data.entHighTechInfo.publicityDate
                this.dataForm.issuingDate = data.entHighTechInfo.issuingDate
                this.dataForm.isInZone = data.entHighTechInfo.isInZone
                this.dataForm.changeType = data.entHighTechInfo.changeType
                this.dataForm.changeReason = data.entHighTechInfo.changeReason
                this.dataForm.note = data.entHighTechInfo.note
                this.dataForm.memId = data.entHighTechInfo.memId
                this.dataForm.enterpriseId = data.entHighTechInfo.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'year': this.dataForm.year,
                'batch': this.dataForm.batch,
                'type': this.dataForm.type,
                'entOldName': this.dataForm.entOldName,
                'company': this.dataForm.company,
                'qualificateNo': this.dataForm.qualificateNo,
                'qualificateLicence': this.dataForm.qualificateLicence,
                'publicityDate': this.dataForm.publicityDate,
                'issuingDate': this.dataForm.issuingDate,
                'isInZone': this.dataForm.isInZone,
                'changeType': this.dataForm.changeType,
                'changeReason': this.dataForm.changeReason,
                'note': this.dataForm.note,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId
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
