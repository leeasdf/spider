<template>
  <el-dialog
    width="700px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
   <!--  <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="注册时间" prop="regTime">
          <el-date-picker type="date" v-model="dataForm.regTime" format="yyyy-MM-dd" value-format="yyyy-MM-dd" placeholder="注册时间"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="法人" prop="legalPerson">
          <el-input v-model="dataForm.legalPerson" placeholder="法人"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="经营状态" prop="status">
          <el-input v-model="dataForm.status" placeholder="经营状态"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公司名" prop="cmpName">
          <el-input v-model="dataForm.cmpName" placeholder="公司名"></el-input>
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
      /*
      const validateUrl = function (rule, value, callback) {
        if (!isURL(value)) {
          callback(new Error('网址格式错误'))
        } else {
          callback()
        }
      }
      */
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          entName: '',
          regTime: '',
          legalPerson: '',
          cmpName: '',
          status: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          url: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          regTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
          ],
          legalPerson: [
            { required: true, message: '法人不能为空', trigger: 'blur' }
          ],
          cmpName: [
            { required: true, message: '公司名不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '经营状态不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || undefined
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/spider/rpttnbranches/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                // this.dataForm = data.rptTnBranches
                this.dataForm.enterpriseId = data.rptTnBranches.enterpriseId
                this.dataForm.entName = data.rptTnBranches.entName
                this.dataForm.regTime = data.rptTnBranches.regTime
                this.dataForm.legalPerson = data.rptTnBranches.legalPerson
                this.dataForm.cmpName = data.rptTnBranches.cmpName
                this.dataForm.status = data.rptTnBranches.status
                this.dataForm.creator = data.rptTnBranches.creator
                this.dataForm.createTime = data.rptTnBranches.createTime
                this.dataForm.updater = data.rptTnBranches.updater
                this.dataForm.updateTime = data.rptTnBranches.updateTime
                this.dataForm.dataState = data.rptTnBranches.dataState
                this.dataForm.url = data.rptTnBranches.url
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
              url: this.$http.adornUrl(`/spider/rpttnbranches/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData(this.dataForm)
              /* data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'regTime': this.dataForm.regTime,
                'legalPerson': this.dataForm.legalPerson,
                'cmpName': this.dataForm.cmpName,
                'status': this.dataForm.status,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'url': this.dataForm.url
              }) */
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
