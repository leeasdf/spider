<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <!-- <el-form-item label="企业id" prop="companyId">
      <el-input v-model="dataForm.companyId" placeholder="企业id"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="作品名称" prop="fullName">
          <el-input v-model="dataForm.fullName" placeholder="作品名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="著作权人" prop="ownerName">
          <el-input v-model="dataForm.ownerName" placeholder="著作权人"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="登记号" prop="registerCode">
          <el-input v-model="dataForm.registerCode" placeholder="登记号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="登记日期" prop="registerDate">
          <el-date-picker v-model="dataForm.registerDate" value-format="yyyy-MM-dd" placeholder="登记日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="作品类别" prop="cateName">
          <el-input v-model="dataForm.cateName" placeholder="作品类别"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="分类号" prop="classifyCode">
          <el-input v-model="dataForm.classifyCode" placeholder="分类号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="首次发表时间" prop="launchDate">
          <el-date-picker type="date" v-model="dataForm.launchDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd" placeholder="首次发表时间"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="首次发表时间" prop="finishDate">
          <el-date-picker type="date" v-model="dataForm.finishDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd" placeholder="首次发表时间"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="版本号" prop="version">
          <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
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
          companyId: '',
          classifyCode: '',
          version: '',
          registerCode: '',
          registerDate: '',
          ownerName: '',
          fullName: '',
          launchDate: '',
          finishDate: '',
          cateName: '',
          createTime: ''
        },
        dataRule: {
          companyId: [
            { required: true, message: '企业id不能为空', trigger: 'blur' }
          ],
          classifyCode: [
            { required: true, message: '分类号不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
          ],
          registerCode: [
            { required: true, message: '登记号不能为空', trigger: 'blur' }
          ],
          registerDate: [
            { required: true, message: '登记日期不能为空', trigger: 'blur' }
          ],
          ownerName: [
            { required: true, message: '著作权人不能为空', trigger: 'blur' }
          ],
          fullName: [
            { required: true, message: '作品名称不能为空', trigger: 'blur' }
          ],
          launchDate: [
            { required: true, message: '首次发表时间不能为空', trigger: 'blur' }
          ],
          finishDate: [
            { required: true, message: '首次发表时间不能为空', trigger: 'blur' }
          ],
          cateName: [
            { required: true, message: '作品类别不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttcxycompanycopyright/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.companyId = data.rptTcxyCompanyCopyright.companyId
                this.dataForm.classifyCode = data.rptTcxyCompanyCopyright.classifyCode
                this.dataForm.version = data.rptTcxyCompanyCopyright.version
                this.dataForm.registerCode = data.rptTcxyCompanyCopyright.registerCode
                this.dataForm.registerDate = data.rptTcxyCompanyCopyright.registerDate
                this.dataForm.ownerName = data.rptTcxyCompanyCopyright.ownerName
                this.dataForm.fullName = data.rptTcxyCompanyCopyright.fullName
                this.dataForm.launchDate = data.rptTcxyCompanyCopyright.launchDate
                this.dataForm.finishDate = data.rptTcxyCompanyCopyright.finishDate
                this.dataForm.cateName = data.rptTcxyCompanyCopyright.cateName
                this.dataForm.createTime = data.rptTcxyCompanyCopyright.createTime
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
              url: this.$http.adornUrl(`/spider/rpttcxycompanycopyright/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'companyId': this.dataForm.companyId,
                'classifyCode': this.dataForm.classifyCode,
                'version': this.dataForm.version,
                'registerCode': this.dataForm.registerCode,
                'registerDate': this.dataForm.registerDate,
                'ownerName': this.dataForm.ownerName,
                'fullName': this.dataForm.fullName,
                'launchDate': this.dataForm.launchDate,
                'finishDate': this.dataForm.finishDate,
                'cateName': this.dataForm.cateName,
                'createTime': this.dataForm.createTime
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
