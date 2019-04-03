<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!-- <el-form-item label="会员主键" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员主键"></el-input>
    </el-form-item> -->
    
    <el-form-item label="软件全称" prop="fullName">
      <el-input v-model="dataForm.fullName" placeholder="软件全称"></el-input>
    </el-form-item>
    <el-form-item label="版本号" prop="version">
      <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
    </el-form-item>
    <el-form-item label="登记号" prop="registerCode">
      <el-input v-model="dataForm.registerCode" placeholder="登记号"></el-input>
    </el-form-item>
    <el-form-item label="分类号" prop="classifyCode">
      <el-input v-model="dataForm.classifyCode" placeholder="分类号"></el-input>
    </el-form-item>
    <el-form-item label="申请时间" prop="registerDate">
      <el-date-picker v-model="dataForm.registerDate" value-format="yyyy-MM-dd" placeholder="申请时间"></el-date-picker>
    </el-form-item>
    <el-form-item label="简称" prop="shortName">
      <el-input v-model="dataForm.shortName" placeholder="简称"></el-input>
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
          memId: '',
          enterpriseId: '',
          fullName: '',
          version: '',
          registerCode: '',
          classifyCode: '',
          registerDate: '',
          shortName: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          /* memId: [
            { required: true, message: '会员主键不能为空', trigger: 'blur' }
          ], */
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          fullName: [
            { required: true, message: '软件全称不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
          ],
          registerCode: [
            { required: true, message: '登记号不能为空', trigger: 'blur' }
          ],
          classifyCode: [
            { required: true, message: '分类号不能为空', trigger: 'blur' }
          ],
          registerDate: [
            { required: true, message: '申请时间不能为空', trigger: 'blur' }
          ],
          shortName: [
            { required: true, message: '简称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptcopyrightinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptCopyrightInfo.memId
                this.dataForm.enterpriseId = data.rptCopyrightInfo.enterpriseId
                this.dataForm.fullName = data.rptCopyrightInfo.fullName
                this.dataForm.version = data.rptCopyrightInfo.version
                this.dataForm.registerCode = data.rptCopyrightInfo.registerCode
                this.dataForm.classifyCode = data.rptCopyrightInfo.classifyCode
                this.dataForm.registerDate = data.rptCopyrightInfo.registerDate
                this.dataForm.shortName = data.rptCopyrightInfo.shortName
                this.dataForm.creator = data.rptCopyrightInfo.creator
                this.dataForm.createTime = data.rptCopyrightInfo.createTime
                this.dataForm.updater = data.rptCopyrightInfo.updater
                this.dataForm.updateTime = data.rptCopyrightInfo.updateTime
                this.dataForm.dataState = data.rptCopyrightInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptcopyrightinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'fullName': this.dataForm.fullName,
                'version': this.dataForm.version,
                'registerCode': this.dataForm.registerCode,
                'classifyCode': this.dataForm.classifyCode,
                'registerDate': this.dataForm.registerDate,
                'shortName': this.dataForm.shortName,
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
