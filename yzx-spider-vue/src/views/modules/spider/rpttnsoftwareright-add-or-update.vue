<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
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
        <el-form-item label="批准日期" prop="appDate">
         <el-date-picker v-model="dataForm.appDate" value-format="yyyy-MM-dd" placeholder="批准日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="软件全称" prop="fullname">
          <el-input v-model="dataForm.fullname" placeholder="软件全称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="软件简称" prop="simpleName">
          <el-input v-model="dataForm.simpleName" placeholder="软件简称"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="登记号" prop="regnum">
          <el-input v-model="dataForm.regnum" placeholder="登记号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="分类号" prop="catnum">
          <el-input v-model="dataForm.catnum" placeholder="分类号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="版本号" prop="version">
          <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
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
    <el-form-item label="著作详情信息" prop="author">
      <el-input v-model="dataForm.author" type="textarea" placeholder="著作详情信息"></el-input>
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
          fullname: '',
          simpleName: '',
          regnum: '',
          catnum: '',
          version: '',
          author: '',
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
            { required: true, message: '批准日期不能为空', trigger: 'blur' }
          ],
          fullname: [
            { required: true, message: '软件全称不能为空', trigger: 'blur' }
          ],
          simpleName: [
            { required: true, message: '软件简称不能为空', trigger: 'blur' }
          ],
          regnum: [
            { required: true, message: '登记号不能为空', trigger: 'blur' }
          ],
          catnum: [
            { required: true, message: '分类号不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
          ],
          author: [
            { required: true, message: '著作详情信息不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnsoftwareright/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnSoftwareRight.enterpriseId
                this.dataForm.entName = data.rptTnSoftwareRight.entName
                this.dataForm.appDate = data.rptTnSoftwareRight.appDate
                this.dataForm.fullname = data.rptTnSoftwareRight.fullname
                this.dataForm.simpleName = data.rptTnSoftwareRight.simpleName
                this.dataForm.regnum = data.rptTnSoftwareRight.regnum
                this.dataForm.catnum = data.rptTnSoftwareRight.catnum
                this.dataForm.version = data.rptTnSoftwareRight.version
                this.dataForm.author = data.rptTnSoftwareRight.author
                this.dataForm.creator = data.rptTnSoftwareRight.creator
                this.dataForm.createTime = data.rptTnSoftwareRight.createTime
                this.dataForm.updater = data.rptTnSoftwareRight.updater
                this.dataForm.updateTime = data.rptTnSoftwareRight.updateTime
                this.dataForm.dataState = data.rptTnSoftwareRight.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnsoftwareright/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'appDate': this.dataForm.appDate,
                'fullname': this.dataForm.fullname,
                'simpleName': this.dataForm.simpleName,
                'regnum': this.dataForm.regnum,
                'catnum': this.dataForm.catnum,
                'version': this.dataForm.version,
                'author': this.dataForm.author,
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
