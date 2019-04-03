<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="主要人员名称" prop="name">
            <el-input v-model="dataForm.name" placeholder="主要人员名称"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="职位" prop="job">
            <el-input v-model="dataForm.job" placeholder="职位"></el-input>
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
      <!--
      <el-form-item label="天眼查地址" prop="url">
        <el-input v-model="dataForm.url" placeholder="天眼查地址"></el-input>
      </el-form-item>
      -->
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
          name: '',
          job: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          url: ''
        },
        dataRule: {
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '主要人员名称不能为空', trigger: 'blur' }
          ],
          job: [
            { required: true, message: '职位不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnperson/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnPerson.enterpriseId
                this.dataForm.entName = data.rptTnPerson.entName
                this.dataForm.name = data.rptTnPerson.name
                this.dataForm.job = data.rptTnPerson.job
                this.dataForm.creator = data.rptTnPerson.creator
                this.dataForm.createTime = data.rptTnPerson.createTime
                this.dataForm.updater = data.rptTnPerson.updater
                this.dataForm.updateTime = data.rptTnPerson.updateTime
                this.dataForm.dataState = data.rptTnPerson.dataState
                this.dataForm.url = data.rptTnPerson.url
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
              url: this.$http.adornUrl(`/spider/rpttnperson/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'name': this.dataForm.name,
                'job': this.dataForm.job,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'url': this.dataForm.url
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
