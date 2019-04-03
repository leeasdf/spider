<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
    <el-form-item label="所属地区" prop="area">
      <el-input v-model="dataForm.area" placeholder="所属地区"></el-input>
    </el-form-item>
    <el-form-item label="执法部门" prop="lawDepartment">
      <el-input v-model="dataForm.lawDepartment" placeholder="执法部门"></el-input>
    </el-form-item>
    <el-form-item label="处罚书文号" prop="docNumber">
      <el-input v-model="dataForm.docNumber" placeholder="处罚书文号"></el-input>
    </el-form-item>
    <el-form-item label="被处罚单位及法人姓名" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="被处罚单位及法人姓名"></el-input>
    </el-form-item>
    <el-form-item label="处罚日期" prop="dealDate">
      <el-date-picker v-model="dataForm.dealDate" placeholder="处罚日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="处罚类别" prop="result">
      <el-input v-model="dataForm.result" placeholder="处罚类别"></el-input>
    </el-form-item>
    <el-form-item label="处罚事由" prop="reason">
      <el-input type="textarea" v-model="dataForm.reason" placeholder="处罚事由"></el-input>
    </el-form-item>
    <el-form-item label="整改情况" prop="situation">
      <el-input v-model="dataForm.situation" placeholder="整改情况"></el-input>
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
          area: '',
          lawDepartment: '',
          docNumber: '',
          enterpriseName: '',
          dealDate: '',
          result: '',
          reason: '',
          situation: ''
        },
        dataRule: {
          area: [
            { required: true, message: '所属地区不能为空', trigger: 'blur' }
          ],
          lawDepartment: [
            { required: true, message: '执法部门不能为空', trigger: 'blur' }
          ],
          docNumber: [
            { required: true, message: '处罚书文号不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '被处罚单位及法人姓名不能为空', trigger: 'blur' }
          ],
          dealDate: [
            { required: true, message: '处罚日期不能为空', trigger: 'blur' }
          ],
          result: [
            { required: true, message: '处罚类别不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '处罚事由不能为空', trigger: 'blur' }
          ],
          situation: [
            { required: true, message: '整改情况不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/orienvironmentalpenalty/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.area = data.oriEnvironmentalPenalty.area
                this.dataForm.lawDepartment = data.oriEnvironmentalPenalty.lawDepartment
                this.dataForm.docNumber = data.oriEnvironmentalPenalty.docNumber
                this.dataForm.enterpriseName = data.oriEnvironmentalPenalty.enterpriseName
                this.dataForm.dealDate = data.oriEnvironmentalPenalty.dealDate
                this.dataForm.result = data.oriEnvironmentalPenalty.result
                this.dataForm.reason = data.oriEnvironmentalPenalty.reason
                this.dataForm.situation = data.oriEnvironmentalPenalty.situation
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
              url: this.$http.adornUrl(`/spider/orienvironmentalpenalty/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'area': this.dataForm.area,
                'lawDepartment': this.dataForm.lawDepartment,
                'docNumber': this.dataForm.docNumber,
                'enterpriseName': this.dataForm.enterpriseName,
                'dealDate': this.dataForm.dealDate,
                'result': this.dataForm.result,
                'reason': this.dataForm.reason,
                'situation': this.dataForm.situation
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
