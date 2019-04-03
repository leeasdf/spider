<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <!-- <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="申请公布日期" prop="appDate">
          <el-date-picker v-model="dataForm.appDate" value-format="yyyy-MM-dd" placeholder="申请公布日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="专利名称" prop="name">
          <el-input v-model="dataForm.name" placeholder="专利名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="申请号" prop="appNum">
          <el-input v-model="dataForm.appNum" placeholder="申请号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="申请公开号" prop="appPubNum">
          <el-input v-model="dataForm.appPubNum" placeholder="申请公开号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="专利类型" prop="type">
          <el-input v-model="dataForm.type" placeholder="专利类型"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
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
          entName: '',
          appDate: '',
          name: '',
          appNum: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          appPubNum: '',
          type: ''
        },
        dataRule: {
         /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          appDate: [
            { required: true, message: '申请公布日期不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '专利名称不能为空', trigger: 'blur' }
          ],
          appNum: [
            { required: true, message: '申请号不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          appPubNum: [
            { required: true, message: '申请公开号不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '专利类型不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnpatent/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnPatent.enterpriseId
                this.dataForm.entName = data.rptTnPatent.entName
                this.dataForm.appDate = data.rptTnPatent.appDate
                this.dataForm.name = data.rptTnPatent.name
                this.dataForm.appNum = data.rptTnPatent.appNum
                this.dataForm.creator = data.rptTnPatent.creator
                this.dataForm.createTime = data.rptTnPatent.createTime
                this.dataForm.updater = data.rptTnPatent.updater
                this.dataForm.updateTime = data.rptTnPatent.updateTime
                this.dataForm.dataState = data.rptTnPatent.dataState
                this.dataForm.appPubNum = data.rptTnPatent.appPubNum
                this.dataForm.type = data.rptTnPatent.type
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
              url: this.$http.adornUrl(`/spider/rpttnpatent/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'appDate': this.dataForm.appDate,
                'name': this.dataForm.name,
                'appNum': this.dataForm.appNum,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'appPubNum': this.dataForm.appPubNum,
                'type': this.dataForm.type
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
