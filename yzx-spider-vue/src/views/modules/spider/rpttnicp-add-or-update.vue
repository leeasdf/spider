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
        <el-form-item label="单位性质" prop="unitProperties">
          <el-input v-model="dataForm.unitProperties" placeholder="单位性质"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="审核时间" prop="approveDate">
          <el-date-picker v-model="dataForm.approveDate" value-format="yyyy-MM-dd" placeholder="审核时间"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="域名" prop="domainName">
          <el-input v-model="dataForm.domainName" placeholder="域名"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="网站名称" prop="siteName">
          <el-input v-model="dataForm.siteName" placeholder="网站名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
       <el-form-item label="备案号" prop="recordNo">
          <el-input v-model="dataForm.recordNo" placeholder="备案号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="状态" prop="status">
          <el-input v-model="dataForm.status" placeholder="状态"></el-input>
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
     <el-form-item label="网站首页" prop="homepage">
        <el-input v-model="dataForm.homepage" placeholder="网站首页"></el-input>
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
          unitProperties: '',
          approveDate: '',
          domainName: '',
          recordNo: '',
          homepage: '',
          status: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          siteName: ''
        },
        dataRule: {
         /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          unitProperties: [
            { required: true, message: '单位性质不能为空', trigger: 'blur' }
          ],
          approveDate: [
            { required: true, message: '审核时间不能为空', trigger: 'blur' }
          ],
          domainName: [
            { required: true, message: '域名不能为空', trigger: 'blur' }
          ],
          recordNo: [
            { required: true, message: '备案号不能为空', trigger: 'blur' }
          ],
          homepage: [
            { required: true, message: '网站首页不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          siteName: [
            { required: true, message: '网站名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnicp/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnIcp.enterpriseId
                this.dataForm.entName = data.rptTnIcp.entName
                this.dataForm.unitProperties = data.rptTnIcp.unitProperties
                this.dataForm.approveDate = data.rptTnIcp.approveDate
                this.dataForm.domainName = data.rptTnIcp.domainName
                this.dataForm.recordNo = data.rptTnIcp.recordNo
                this.dataForm.homepage = data.rptTnIcp.homepage
                this.dataForm.status = data.rptTnIcp.status
                this.dataForm.creator = data.rptTnIcp.creator
                this.dataForm.createTime = data.rptTnIcp.createTime
                this.dataForm.updater = data.rptTnIcp.updater
                this.dataForm.updateTime = data.rptTnIcp.updateTime
                this.dataForm.dataState = data.rptTnIcp.dataState
                this.dataForm.siteName = data.rptTnIcp.siteName
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
              url: this.$http.adornUrl(`/spider/rpttnicp/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'unitProperties': this.dataForm.unitProperties,
                'approveDate': this.dataForm.approveDate,
                'domainName': this.dataForm.domainName,
                'recordNo': this.dataForm.recordNo,
                'homepage': this.dataForm.homepage,
                'status': this.dataForm.status,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'siteName': this.dataForm.siteName
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
