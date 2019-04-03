<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="绑定成员" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="绑定成员"></el-input>
    </el-form-item>
    
    <el-form-item label="上榜事由" prop="reason">
      <el-input v-model="dataForm.reason" placeholder="上榜事由"></el-input>
    </el-form-item>
    <el-form-item label="来源部门" prop="sourceDepartment">
      <el-input v-model="dataForm.sourceDepartment" placeholder="来源部门"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="榜单名称" prop="blackRollName">
      <el-input v-model="dataForm.blackRollName" placeholder="榜单名称"></el-input>
    </el-form-item>
    <el-form-item label="公司名称" prop="company">
      <el-input v-model="dataForm.company" placeholder="公司名称"></el-input>
    </el-form-item>
    <el-form-item label="发布日期" prop="date">
      <el-input v-model="dataForm.date" placeholder="发布日期"></el-input>
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
          enterpriseId: '',
          reason: '',
          sourceDepartment: '',
          remarks: '',
          blackRollName: '',
          company: '',
          date: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '绑定成员不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '上榜事由不能为空', trigger: 'blur' }
          ],
          sourceDepartment: [
            { required: true, message: '来源部门不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          blackRollName: [
            { required: true, message: '榜单名称不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '公司名称不能为空', trigger: 'blur' }
          ],
          date: [
            { required: true, message: '发布日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechblackinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.entHighTechBlackInfo.memId
                this.dataForm.enterpriseId = data.entHighTechBlackInfo.enterpriseId
                this.dataForm.reason = data.entHighTechBlackInfo.reason
                this.dataForm.sourceDepartment = data.entHighTechBlackInfo.sourceDepartment
                this.dataForm.remarks = data.entHighTechBlackInfo.remarks
                this.dataForm.blackRollName = data.entHighTechBlackInfo.blackRollName
                this.dataForm.company = data.entHighTechBlackInfo.company
                this.dataForm.date = data.entHighTechBlackInfo.date
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
              url: this.$http.adornUrl(`/spider/enthightechblackinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'reason': this.dataForm.reason,
                'sourceDepartment': this.dataForm.sourceDepartment,
                'remarks': this.dataForm.remarks,
                'blackRollName': this.dataForm.blackRollName,
                'company': this.dataForm.company,
                'date': this.dataForm.date
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
