<template>
  <el-dialog
    width="700px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="立案日期" prop="date">
          <el-date-picker v-model="dataForm.date" placeholder="立案日期" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="执行标的" prop="target">
          <el-input v-model="dataForm.target" placeholder="执行标的"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="案号" prop="caseNo">
          <el-input v-model="dataForm.caseNo" placeholder="案号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="执行法院" prop="court">
          <el-input v-model="dataForm.court" placeholder="执行法院"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="数据状态" prop="dataState">
          <el-radio-group v-model="dataForm.dataState">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">删除</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
    </el-row>
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
          date: '',
          target: '',
          caseNo: '',
          court: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          date: [
            { required: true, message: '立案日期不能为空', trigger: 'blur' }
          ],
          target: [
            { required: true, message: '执行标的不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '案号不能为空', trigger: 'blur' }
          ],
          court: [
            { required: true, message: '执行法院不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
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
              url: this.$http.adornUrl(`/spider/rpttnzhixing/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnZhixing.enterpriseId
                this.dataForm.entName = data.rptTnZhixing.entName
                this.dataForm.date = data.rptTnZhixing.date
                this.dataForm.target = data.rptTnZhixing.target
                this.dataForm.caseNo = data.rptTnZhixing.caseNo
                this.dataForm.court = data.rptTnZhixing.court
                this.dataForm.creator = data.rptTnZhixing.creator
                this.dataForm.createTime = data.rptTnZhixing.createTime
                this.dataForm.updater = data.rptTnZhixing.updater
                this.dataForm.updateTime = data.rptTnZhixing.updateTime
                this.dataForm.dataState = data.rptTnZhixing.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnzhixing/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'date': this.dataForm.date,
                'target': this.dataForm.target,
                'caseNo': this.dataForm.caseNo,
                'court': this.dataForm.court,
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
