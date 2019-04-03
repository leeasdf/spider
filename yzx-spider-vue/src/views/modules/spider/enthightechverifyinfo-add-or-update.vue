<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
    <el-form-item label="企业名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="originEnterpriseName">
      <el-input v-model="dataForm.originEnterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="批次" prop="batch">
      <el-input v-model="dataForm.batch" placeholder="批次"></el-input>
    </el-form-item>
    <el-form-item label="认定年份" prop="verifyYear">
      <el-date-picker type="year" v-model="dataForm.verifyYear" placeholder="认定年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型"></el-input>
    </el-form-item>
    <el-form-item label="证书编号" prop="certno">
      <el-input v-model="dataForm.certno" placeholder="证书编号"></el-input>
    </el-form-item>
    <el-form-item label="认定批文号" prop="approvalNo">
      <el-input v-model="dataForm.approvalNo" placeholder="认定批文号"></el-input>
    </el-form-item>
    <el-form-item label="公示日期" prop="publicDate">
      <!-- <el-input v-model="dataForm.publicDate" placeholder="公示日期"></el-input> -->
      <el-date-picker v-model="dataForm.publicDate" value-format="yy-MM-dd" placeholder="公示日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="发证日期" prop="issueDate">
      <el-date-picker v-model="dataForm.issueDate" value-format="yyyy-MM-dd" placeholder="发证日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="变更类型" prop="changeType">
      <el-input v-model="dataForm.changeType" placeholder="变更类型"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
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
          enterpriseName: '',
          originEnterpriseName: '',
          batch: '',
          verifyYear: '',
          type: '',
          certno: '',
          approvalNo: '',
          publicDate: '',
          issueDate: '',
          changeType: '',
          remark: ''
        },
        dataRule: {
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          originEnterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          batch: [
            { required: true, message: '批次不能为空', trigger: 'blur' }
          ],
          verifyYear: [
            { required: true, message: '认定年份不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          certno: [
            { required: true, message: '证书编号不能为空', trigger: 'blur' }
          ],
          approvalNo: [
            { required: true, message: '认定批文号不能为空', trigger: 'blur' }
          ],
          publicDate: [
            { required: true, message: '公示日期不能为空', trigger: 'blur' }
          ],
          issueDate: [
            { required: true, message: '发证日期不能为空', trigger: 'blur' }
          ],
          changeType: [
            { required: true, message: '变更类型不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechverifyinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseName = data.entHighTechVerifyInfo.enterpriseName
                this.dataForm.originEnterpriseName = data.entHighTechVerifyInfo.originEnterpriseName
                this.dataForm.batch = data.entHighTechVerifyInfo.batch
                this.dataForm.verifyYear = data.entHighTechVerifyInfo.verifyYear
                this.dataForm.type = data.entHighTechVerifyInfo.type
                this.dataForm.certno = data.entHighTechVerifyInfo.certno
                this.dataForm.approvalNo = data.entHighTechVerifyInfo.approvalNo
                this.dataForm.publicDate = data.entHighTechVerifyInfo.publicDate
                this.dataForm.issueDate = data.entHighTechVerifyInfo.issueDate
                this.dataForm.changeType = data.entHighTechVerifyInfo.changeType
                this.dataForm.remark = data.entHighTechVerifyInfo.remark
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
              url: this.$http.adornUrl(`/spider/enthightechverifyinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseName': this.dataForm.enterpriseName,
                'originEnterpriseName': this.dataForm.originEnterpriseName,
                'batch': this.dataForm.batch,
                'verifyYear': this.dataForm.verifyYear,
                'type': this.dataForm.type,
                'certno': this.dataForm.certno,
                'approvalNo': this.dataForm.approvalNo,
                'publicDate': this.dataForm.publicDate,
                'issueDate': this.dataForm.issueDate,
                'changeType': this.dataForm.changeType,
                'remark': this.dataForm.remark
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
