<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
        <el-form-item label="申请日期" prop="appDate">
          <el-date-picker v-model="dataForm.appDate" value-format="yyyy-MM-dd" placeholder="申请日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="商标名称" prop="name">
          <el-input v-model="dataForm.name" placeholder="商标名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="注册号" prop="appNum">
          <el-input v-model="dataForm.appNum" placeholder="注册号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="类别" prop="category">
          <el-input v-model="dataForm.category" placeholder="类别"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="流程状态" prop="processStatus">
          <el-input v-model="dataForm.processStatus" placeholder="流程状态"></el-input>
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
          category: '',
          processStatus: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          appDate: [
            { required: true, message: '申请日期不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '商标名称不能为空', trigger: 'blur' }
          ],
          appNum: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          processStatus: [
            { required: true, message: '流程状态不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttntrademark/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnTrademark.enterpriseId
                this.dataForm.entName = data.rptTnTrademark.entName
                this.dataForm.appDate = data.rptTnTrademark.appDate
                this.dataForm.name = data.rptTnTrademark.name
                this.dataForm.appNum = data.rptTnTrademark.appNum
                this.dataForm.category = data.rptTnTrademark.category
                this.dataForm.processStatus = data.rptTnTrademark.processStatus
                this.dataForm.creator = data.rptTnTrademark.creator
                this.dataForm.createTime = data.rptTnTrademark.createTime
                this.dataForm.updater = data.rptTnTrademark.updater
                this.dataForm.updateTime = data.rptTnTrademark.updateTime
                this.dataForm.dataState = data.rptTnTrademark.dataState
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
              url: this.$http.adornUrl(`/spider/rpttntrademark/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'appDate': this.dataForm.appDate,
                'name': this.dataForm.name,
                'appNum': this.dataForm.appNum,
                'category': this.dataForm.category,
                'processStatus': this.dataForm.processStatus,
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
