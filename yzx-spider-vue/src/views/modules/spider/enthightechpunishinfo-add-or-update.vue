<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="150px">
    <!-- <el-form-item label="" prop="memId">
      <el-input v-model="dataForm.memId" placeholder=""></el-input>
    </el-form-item> -->
    <el-form-item label="执法部门" prop="lawEnforcement">
      <el-input v-model="dataForm.lawEnforcement" placeholder="执法部门"></el-input>
    </el-form-item>
    <el-form-item label="行政处罚决定书文号" prop="punishNum">
      <el-input v-model="dataForm.punishNum" placeholder="行政处罚决定书文号"></el-input>
    </el-form-item>
    <el-form-item label="公司名称" prop="company">
      <el-input v-model="dataForm.company" placeholder="公司名称"></el-input>
    </el-form-item>
    <el-form-item label="企业法人" prop="companyLegalPerson">
      <el-input v-model="dataForm.companyLegalPerson" placeholder="企业法人"></el-input>
    </el-form-item>
    <el-form-item label="作出行政处罚的日期" prop="publishDate">
      <!-- <el-input v-model="dataForm.publishDate" placeholder="作出行政处罚的日期"></el-input> -->
      <el-date-picker v-model="dataForm.publishDate" value-format="yyyy-MM-dd" placeholder="作出行政处罚的日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="案例名称" prop="caseName">
      <el-input v-model="dataForm.caseName" placeholder="案例名称"></el-input>
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
          memId: '',
          lawEnforcement: '',
          punishNum: '',
          company: '',
          companyLegalPerson: '',
          publishDate: '',
          caseName: '',
          enterpriseId: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          lawEnforcement: [
            { required: true, message: '执法部门不能为空', trigger: 'blur' }
          ],
          punishNum: [
            { required: true, message: '行政处罚决定书文号不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '公司名称不能为空', trigger: 'blur' }
          ],
          companyLegalPerson: [
            { required: true, message: '企业法人不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '作出行政处罚的日期不能为空', trigger: 'blur' }
          ],
          caseName: [
            { required: true, message: '案例名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechpunishinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.entHighTechPunishInfo.memId
                this.dataForm.lawEnforcement = data.entHighTechPunishInfo.lawEnforcement
                this.dataForm.punishNum = data.entHighTechPunishInfo.punishNum
                this.dataForm.company = data.entHighTechPunishInfo.company
                this.dataForm.companyLegalPerson = data.entHighTechPunishInfo.companyLegalPerson
                this.dataForm.publishDate = data.entHighTechPunishInfo.publishDate
                this.dataForm.caseName = data.entHighTechPunishInfo.caseName
                this.dataForm.enterpriseId = data.entHighTechPunishInfo.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechpunishinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'lawEnforcement': this.dataForm.lawEnforcement,
                'punishNum': this.dataForm.punishNum,
                'company': this.dataForm.company,
                'companyLegalPerson': this.dataForm.companyLegalPerson,
                'publishDate': this.dataForm.publishDate,
                'caseName': this.dataForm.caseName,
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
