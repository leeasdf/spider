<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
    <el-form-item label="项目名称" prop="projectName">
      <el-input v-model="dataForm.projectName" placeholder="项目名称"></el-input>
    </el-form-item>
    <el-form-item label="承担单位" prop="company">
      <el-input v-model="dataForm.company" placeholder="承担单位"></el-input>
    </el-form-item>
    <el-form-item label="项目类型" prop="projectType">
      <el-input v-model="dataForm.projectType" placeholder="项目类型"></el-input>
    </el-form-item>
    <el-form-item label="" prop="amount">
      <el-input v-model="dataForm.amount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="note">
      <el-input v-model="dataForm.note" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="来源excel表名" prop="excelSource">
      <el-input v-model="dataForm.excelSource" placeholder="来源excel表名"></el-input>
    </el-form-item>
    <el-form-item label="统计年份" prop="statisticsYear">
      <el-date-picker type="year" v-model="dataForm.statisticsYear" placeholder="统计年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="文件号" prop="fileNumber">
      <el-input v-model="dataForm.fileNumber" placeholder="文件号"></el-input>
    </el-form-item>
    <!-- <el-form-item label="绑定会员id" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="绑定会员id"></el-input>
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
          projectName: '',
          company: '',
          projectType: '',
          amount: '',
          note: '',
          excelSource: '',
          statisticsYear: '',
          fileNumber: '',
          memId: '',
          enterpriseId: ''
        },
        dataRule: {
          projectName: [
            { required: true, message: '项目名称不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '承担单位不能为空', trigger: 'blur' }
          ],
          projectType: [
            { required: true, message: '项目类型不能为空', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          excelSource: [
            { required: true, message: '来源excel表名不能为空', trigger: 'blur' }
          ],
          statisticsYear: [
            { required: true, message: '统计年份不能为空', trigger: 'blur' }
          ],
          fileNumber: [
            { required: true, message: '文件号不能为空', trigger: 'blur' }
          ],
         /* memId: [
            { required: true, message: '绑定会员id不能为空', trigger: 'blur' }
          ], */
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
              url: this.$http.adornUrl(`/spider/enthightechprojectdeclare/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.projectName = data.entHighTechProjectDeclare.projectName
                this.dataForm.company = data.entHighTechProjectDeclare.company
                this.dataForm.projectType = data.entHighTechProjectDeclare.projectType
                this.dataForm.amount = data.entHighTechProjectDeclare.amount
                this.dataForm.note = data.entHighTechProjectDeclare.note
                this.dataForm.excelSource = data.entHighTechProjectDeclare.excelSource
                this.dataForm.statisticsYear = data.entHighTechProjectDeclare.statisticsYear
                this.dataForm.fileNumber = data.entHighTechProjectDeclare.fileNumber
                this.dataForm.memId = data.entHighTechProjectDeclare.memId
                this.dataForm.enterpriseId = data.entHighTechProjectDeclare.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechprojectdeclare/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'projectName': this.dataForm.projectName,
                'company': this.dataForm.company,
                'projectType': this.dataForm.projectType,
                'amount': this.dataForm.amount,
                'note': this.dataForm.note,
                'excelSource': this.dataForm.excelSource,
                'statisticsYear': this.dataForm.statisticsYear,
                'fileNumber': this.dataForm.fileNumber,
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
