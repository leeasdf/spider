<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
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
        <el-form-item label="出质股权数额" prop="equityAmount">
          <el-input v-model="dataForm.equityAmount" placeholder="出质股权数额"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公布日期" prop="publishDate">
          <el-date-picker v-model="dataForm.publishDate" value-format="yyyy-MM-dd" placeholder="公布日期"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="登记日" prop="regDate">
          <el-date-picker v-model="dataForm.regDate" value-format="yyyy-MM-dd" placeholder="登记日"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="登记编号" prop="regNumber">
          <el-input v-model="dataForm.regNumber" placeholder="登记编号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="状态" prop="state">
          <el-input v-model="dataForm.state" placeholder="状态"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="质权人证件号码" prop="certifNumber">
          <el-input v-model="dataForm.certifNumber" placeholder="质权人证件号码"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="出质人证件号码" prop="certifNumberR">
          <el-input v-model="dataForm.certifNumberR" placeholder="出质人证件号码"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="出质人" prop="pledgee">
          <el-input v-model="dataForm.pledgee" placeholder="出质人"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="质权人" prop="pledgor">
          <el-input v-model="dataForm.pledgor" placeholder="质权人"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="出质人列表" prop="pledgeeList">
          <el-input v-model="dataForm.pledgeeList" placeholder="出质人列表"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="质权人列表" prop="pledgorList">
          <el-input v-model="dataForm.pledgorList" placeholder="质权人列表"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公司列表" prop="companyList">
          <el-input v-model="dataForm.companyList" placeholder="公司列表"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="来源" prop="base">
          <el-input v-model="dataForm.base" placeholder="来源"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        
        <el-form-item label="质权人网址" prop="pledgorStr">
          <el-input v-model="dataForm.pledgorStr" placeholder="质权人网址"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="出质人网址" prop="pledgeeStr">
          <el-input v-model="dataForm.pledgeeStr" placeholder="出质人网址"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
   <!--  <el-form-item label="待定" prop="putDate">
      <el-input v-model="dataForm.putDate" placeholder="待定"></el-input>
    </el-form-item> -->
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
          equityAmount: '',
          putDate: '',
          publishDate: '',
          pledgorStr: '',
          regDate: '',
          state: '',
          certifNumber: '',
          regNumber: '',
          pledgee: '',
          companyList: '',
          pledgeeList: '',
          pledgorList: '',
          pledgor: '',
          certifNumberR: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          base: '',
          pledgeeStr: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          equityAmount: [
            { required: true, message: '出质股权数额不能为空', trigger: 'blur' }
          ],
          putDate: [
            { required: true, message: '待定不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '公布日期不能为空', trigger: 'blur' }
          ],
          pledgorStr: [
            { required: true, message: '质权人网址不能为空', trigger: 'blur' }
          ],
          regDate: [
            { required: true, message: '登记日不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          certifNumber: [
            { required: true, message: '质权人证件号码不能为空', trigger: 'blur' }
          ],
          regNumber: [
            { required: true, message: '登记编号不能为空', trigger: 'blur' }
          ],
          pledgee: [
            { required: true, message: '出质人不能为空', trigger: 'blur' }
          ],
          companyList: [
            { required: true, message: '公司列表不能为空', trigger: 'blur' }
          ],
          pledgeeList: [
            { required: true, message: '出质人列表不能为空', trigger: 'blur' }
          ],
          pledgorList: [
            { required: true, message: '质权人列表不能为空', trigger: 'blur' }
          ],
          pledgor: [
            { required: true, message: '质权人不能为空', trigger: 'blur' }
          ],
          certifNumberR: [
            { required: true, message: '出质人证件号码不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          base: [
            { required: true, message: '来源不能为空', trigger: 'blur' }
          ],
          pledgeeStr: [
            { required: true, message: '出质人网址不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnequity/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnEquity.enterpriseId
                this.dataForm.entName = data.rptTnEquity.entName
                this.dataForm.equityAmount = data.rptTnEquity.equityAmount
                this.dataForm.putDate = data.rptTnEquity.putDate
                this.dataForm.publishDate = data.rptTnEquity.publishDate
                this.dataForm.pledgorStr = data.rptTnEquity.pledgorStr
                this.dataForm.regDate = data.rptTnEquity.regDate
                this.dataForm.state = data.rptTnEquity.state
                this.dataForm.certifNumber = data.rptTnEquity.certifNumber
                this.dataForm.regNumber = data.rptTnEquity.regNumber
                this.dataForm.pledgee = data.rptTnEquity.pledgee
                this.dataForm.companyList = data.rptTnEquity.companyList
                this.dataForm.pledgeeList = data.rptTnEquity.pledgeeList
                this.dataForm.pledgorList = data.rptTnEquity.pledgorList
                this.dataForm.pledgor = data.rptTnEquity.pledgor
                this.dataForm.certifNumberR = data.rptTnEquity.certifNumberR
                this.dataForm.creator = data.rptTnEquity.creator
                this.dataForm.createTime = data.rptTnEquity.createTime
                this.dataForm.updater = data.rptTnEquity.updater
                this.dataForm.updateTime = data.rptTnEquity.updateTime
                this.dataForm.dataState = data.rptTnEquity.dataState
                this.dataForm.base = data.rptTnEquity.base
                this.dataForm.pledgeeStr = data.rptTnEquity.pledgeeStr
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
              url: this.$http.adornUrl(`/spider/rpttnequity/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'equityAmount': this.dataForm.equityAmount,
                'putDate': this.dataForm.putDate,
                'publishDate': this.dataForm.publishDate,
                'pledgorStr': this.dataForm.pledgorStr,
                'regDate': this.dataForm.regDate,
                'state': this.dataForm.state,
                'certifNumber': this.dataForm.certifNumber,
                'regNumber': this.dataForm.regNumber,
                'pledgee': this.dataForm.pledgee,
                'companyList': this.dataForm.companyList,
                'pledgeeList': this.dataForm.pledgeeList,
                'pledgorList': this.dataForm.pledgorList,
                'pledgor': this.dataForm.pledgor,
                'certifNumberR': this.dataForm.certifNumberR,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'base': this.dataForm.base,
                'pledgeeStr': this.dataForm.pledgeeStr
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
