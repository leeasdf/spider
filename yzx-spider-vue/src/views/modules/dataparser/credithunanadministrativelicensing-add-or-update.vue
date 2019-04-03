<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="行政相对人名称" prop="caseObject">
            <el-input v-model="dataForm.caseObject" placeholder="行政相对人名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="法人/负责人" prop="legalRepresentative">
            <el-input v-model="dataForm.legalRepresentative" placeholder="法定代表人（或单位负责人）"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="案件名称" prop="caseName">
            <el-input v-model="dataForm.caseName" placeholder="案件名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行决定书文号" prop="caseNo">
            <el-input v-model="dataForm.caseNo" placeholder="行政许可决定书文号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="执法部门" prop="lawEnforcingDepartment">
            <el-input v-model="dataForm.lawEnforcingDepartment" placeholder="执法部门"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="决定日期" prop="licensingDate">
            <el-date-picker v-model="dataForm.licensingDate" placeholder="作出行政许可的日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="行政许可决定书" prop="content">
        <el-input type="textarea" v-model="dataForm.content" placeholder="行政许可决定书"></el-input>
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
          caseName: '',
          caseNo: '',
          caseObject: '',
          legalRepresentative: '',
          lawEnforcingDepartment: '',
          licensingDate: '',
          content: ''
        },
        dataRule: {
          caseName: [
            { required: true, message: '案件名称不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '行政许可决定书文号不能为空', trigger: 'blur' }
          ],
          caseObject: [
            { required: true, message: '行政相对人名称不能为空', trigger: 'blur' }
          ],
          legalRepresentative: [
            { required: true, message: '法人（或单位负责人）不能为空', trigger: 'blur' }
          ],
          lawEnforcingDepartment: [
            { required: true, message: '执法部门不能为空', trigger: 'blur' }
          ],
          licensingDate: [
            { required: true, message: '作出行政许可的日期不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '行政许可决定书不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/dataparser/credithunanadministrativelicensing/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.caseName = data.credithunanAdministrativeLicensing.caseName
                this.dataForm.caseNo = data.credithunanAdministrativeLicensing.caseNo
                this.dataForm.caseObject = data.credithunanAdministrativeLicensing.caseObject
                this.dataForm.legalRepresentative = data.credithunanAdministrativeLicensing.legalRepresentative
                this.dataForm.lawEnforcingDepartment = data.credithunanAdministrativeLicensing.lawEnforcingDepartment
                this.dataForm.licensingDate = data.credithunanAdministrativeLicensing.licensingDate
                this.dataForm.content = data.credithunanAdministrativeLicensing.content
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
              url: this.$http.adornUrl(`/dataparser/credithunanadministrativelicensing/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'caseName': this.dataForm.caseName,
                'caseNo': this.dataForm.caseNo,
                'caseObject': this.dataForm.caseObject,
                'legalRepresentative': this.dataForm.legalRepresentative,
                'lawEnforcingDepartment': this.dataForm.lawEnforcingDepartment,
                'licensingDate': this.dataForm.licensingDate,
                'content': this.dataForm.content

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
