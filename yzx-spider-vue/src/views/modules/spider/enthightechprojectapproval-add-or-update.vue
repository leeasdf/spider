<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="年度" prop="year">
      <!-- <el-input v-model="dataForm.year" placeholder="年度"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.year" placeholder="年度"></el-date-picker>
    </el-form-item>
    <el-form-item label="归口部门" prop="belongTo">
      <el-input v-model="dataForm.belongTo" placeholder="归口部门"></el-input>
    </el-form-item>
    <el-form-item label="项目类别" prop="projectType">
      <el-input v-model="dataForm.projectType" placeholder="项目类别"></el-input>
    </el-form-item>
    <el-form-item label="项目名称" prop="projectName">
      <el-input v-model="dataForm.projectName" placeholder="项目名称"></el-input>
    </el-form-item>
    <el-form-item label="承担单位" prop="company">
      <el-input v-model="dataForm.company" placeholder="承担单位"></el-input>
    </el-form-item>
    <el-form-item label="" prop="amount">
      <el-input v-model="dataForm.amount" placeholder=""></el-input>
    </el-form-item>
    <!-- <el-form-item label="会员id" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员id"></el-input>
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
          belongTo: '',
          projectType: '',
          projectName: '',
          company: '',
          amount: '',
          memId: '',
          enterpriseId: ''
        },
        dataRule: {
          year: [
            { required: true, message: '年度不能为空', trigger: 'blur' }
          ],
          belongTo: [
            { required: true, message: '归口部门不能为空', trigger: 'blur' }
          ],
          projectType: [
            { required: true, message: '项目类别不能为空', trigger: 'blur' }
          ],
          projectName: [
            { required: true, message: '项目名称不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '承担单位不能为空', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '会员id不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechprojectapproval/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.year = data.entHighTechProjectApproval.year
                this.dataForm.belongTo = data.entHighTechProjectApproval.belongTo
                this.dataForm.projectType = data.entHighTechProjectApproval.projectType
                this.dataForm.projectName = data.entHighTechProjectApproval.projectName
                this.dataForm.company = data.entHighTechProjectApproval.company
                this.dataForm.amount = data.entHighTechProjectApproval.amount
                this.dataForm.memId = data.entHighTechProjectApproval.memId
                this.dataForm.enterpriseId = data.entHighTechProjectApproval.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechprojectapproval/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'year': this.dataForm.year,
                'belongTo': this.dataForm.belongTo,
                'projectType': this.dataForm.projectType,
                'projectName': this.dataForm.projectName,
                'company': this.dataForm.company,
                'amount': this.dataForm.amount,
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
