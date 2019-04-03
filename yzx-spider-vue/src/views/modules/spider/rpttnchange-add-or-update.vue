<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="企业名称"></el-input>
    </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="变更时间" prop="changeDate">
          <el-date-picker type="date" v-model="dataForm.changeDate" placeholder="变更时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="变更项" prop="changeItem">
      <el-input v-model="dataForm.changeItem" placeholder="变更项"></el-input>
    </el-form-item>
    <el-form-item label="变更前" prop="changeBefore">
      <el-input v-model="dataForm.changeBefore" placeholder="变更前"></el-input>
    </el-form-item>
    <el-form-item label="变更后" prop="changeAfter">
      <el-input v-model="dataForm.changeAfter" placeholder="变更后"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataState">
      <el-radio-group v-model="dataForm.dataState">
        <el-radio :label="1">正常</el-radio>
        <el-radio :label="0">删除</el-radio>
      </el-radio-group>
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
          enterpriseId: '',
          name: '',
          changeDate: '',
          changeAfter: '',
          changeItem: '',
          changeBefore: '',
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
          name: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          changeDate: [
            { required: true, message: '变更时间不能为空', trigger: 'blur' }
          ],
          changeAfter: [
            { required: true, message: '变更后不能为空', trigger: 'blur' }
          ],
          changeItem: [
            { required: true, message: '变更项不能为空', trigger: 'blur' }
          ],
          changeBefore: [
            { required: true, message: '变更前不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnchange/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnChange.enterpriseId
                this.dataForm.name = data.rptTnChange.name
                this.dataForm.changeDate = data.rptTnChange.changeDate
                this.dataForm.changeAfter = data.rptTnChange.changeAfter
                this.dataForm.changeItem = data.rptTnChange.changeItem
                this.dataForm.changeBefore = data.rptTnChange.changeBefore
                this.dataForm.creator = data.rptTnChange.creator
                this.dataForm.createTime = data.rptTnChange.createTime
                this.dataForm.updater = data.rptTnChange.updater
                this.dataForm.updateTime = data.rptTnChange.updateTime
                this.dataForm.dataState = data.rptTnChange.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnchange/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'name': this.dataForm.name,
                'changeDate': this.dataForm.changeDate,
                'changeAfter': this.dataForm.changeAfter,
                'changeItem': this.dataForm.changeItem,
                'changeBefore': this.dataForm.changeBefore,
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
