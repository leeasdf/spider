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
        <el-form-item label="企业名称" prop="entAme">
          <el-input v-model="dataForm.entAme" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
         <el-form-item label="软件全称" prop="fullname">
          <el-input v-model="dataForm.fullname" placeholder="软件全称"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="软件简称" prop="simplename">
          <el-input v-model="dataForm.simplename" placeholder="软件简称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
         <el-form-item label="登记号" prop="regnum">
          <el-input v-model="dataForm.regnum" placeholder="登记号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="分类号" prop="catnum">
          <el-input v-model="dataForm.catnum" placeholder="分类号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="版本号" prop="version">
          <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="著作权人(国籍)" prop="authorNationality">
          <el-input v-model="dataForm.authorNationality" placeholder="著作权人(国籍)"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="首次发表日期" prop="publishtime">
          <el-date-picker type="date" v-model="dataForm.publishtime" placeholder="首次发表日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="登记日期" prop="regtime">
          <el-date-picker type="date" v-model="dataForm.regtime" placeholder="登记日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
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
          entAme: '',
          fullname: '',
          simplename: '',
          regnum: '',
          catnum: '',
          version: '',
          authorNationality: '',
          publishtime: '',
          regtime: '',
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
          entAme: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          fullname: [
            { required: true, message: '软件全称不能为空', trigger: 'blur' }
          ],
          simplename: [
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
          authorNationality: [
            { required: true, message: '著作权人(国籍)不能为空', trigger: 'blur' }
          ],
          publishtime: [
            { required: true, message: '首次发表日期不能为空', trigger: 'blur' }
          ],
          regtime: [
            { required: true, message: '登记日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnsoftwarerightauthor/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnSoftwareRightAuthor.enterpriseId
                this.dataForm.entAme = data.rptTnSoftwareRightAuthor.entAme
                this.dataForm.fullname = data.rptTnSoftwareRightAuthor.fullname
                this.dataForm.simplename = data.rptTnSoftwareRightAuthor.simplename
                this.dataForm.regnum = data.rptTnSoftwareRightAuthor.regnum
                this.dataForm.catnum = data.rptTnSoftwareRightAuthor.catnum
                this.dataForm.version = data.rptTnSoftwareRightAuthor.version
                this.dataForm.authorNationality = data.rptTnSoftwareRightAuthor.authorNationality
                this.dataForm.publishtime = data.rptTnSoftwareRightAuthor.publishtime
                this.dataForm.regtime = data.rptTnSoftwareRightAuthor.regtime
                this.dataForm.creator = data.rptTnSoftwareRightAuthor.creator
                this.dataForm.createTime = data.rptTnSoftwareRightAuthor.createTime
                this.dataForm.updater = data.rptTnSoftwareRightAuthor.updater
                this.dataForm.updateTime = data.rptTnSoftwareRightAuthor.updateTime
                this.dataForm.dataState = data.rptTnSoftwareRightAuthor.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnsoftwarerightauthor/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entAme': this.dataForm.entAme,
                'fullname': this.dataForm.fullname,
                'simplename': this.dataForm.simplename,
                'regnum': this.dataForm.regnum,
                'catnum': this.dataForm.catnum,
                'version': this.dataForm.version,
                'authorNationality': this.dataForm.authorNationality,
                'publishtime': this.dataForm.publishtime,
                'regtime': this.dataForm.regtime,
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
