<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
    <!-- <el-form-item label="公司ID" prop="companyId">
      <el-input v-model="dataForm.companyId" placeholder="公司ID"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="专利名称" prop="title">
          <el-input v-model="dataForm.title" placeholder="专利名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="专利类型" prop="type">
          <el-input v-model="dataForm.type" placeholder="专利类型"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="主分类号" prop="mainClassCode">
          <el-input v-model="dataForm.mainClassCode" placeholder="主分类号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="分类号" prop="classCode">
          <el-input v-model="dataForm.classCode" placeholder="分类号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="发明人" prop="designer">
          <el-input v-model="dataForm.designer" placeholder="发明人"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="专利号" prop="patentNumber">
          <el-input v-model="dataForm.patentNumber" placeholder="专利号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="申请者" prop="applicant">
          <el-input v-model="dataForm.applicant" placeholder="申请者"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="申请日期" prop="applyDate">
          <el-date-picker v-model="dataForm.applyDate" value-format="yyyy-MM-dd" placeholder="申请日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="专利代理机构" prop="agentOrg">
          <el-input v-model="dataForm.agentOrg" placeholder="专利代理机构"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="代理人" prop="agent">
          <el-input v-model="dataForm.agent" placeholder="代理人"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公开号" prop="pubNum">
          <el-input v-model="dataForm.pubNum" placeholder="公开号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="公开日期" prop="pubDate">
          <el-date-picker v-model="dataForm.pubDate" value-format="yyyy-MM-dd" placeholder="公开日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="国际申请" prop="intelApply">
          <el-input v-model="dataForm.intelApply" placeholder="国际申请"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="国际公布" prop="intelPub">
          <el-input v-model="dataForm.intelPub" placeholder="国际公布"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="进入国家日期" prop="intoChinaDate">
          <el-date-picker v-model="dataForm.intoChinaDate" value-format="yyyy-MM-dd" placeholder="进入国家日期"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="地址" prop="address">
          <el-input v-model="dataForm.address" placeholder="地址"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="专利摘要" prop="summary">
      <el-input type="textarea" v-model="dataForm.summary" placeholder="专利摘要"></el-input>
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
          companyId: '',
          title: '',
          mainClassCode: '',
          type: '',
          classCode: '',
          designer: '',
          address: '',
          summary: '',
          applicant: '',
          patentNumber: '',
          applyDate: '',
          agentOrg: '',
          pubNum: '',
          agent: '',
          pubDate: '',
          intelPub: '',
          intelApply: '',
          intoChinaDate: '',
          createTime: ''
        },
        dataRule: {
          companyId: [
            { required: true, message: '公司ID不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '专利名称不能为空', trigger: 'blur' }
          ],
          mainClassCode: [
            { required: true, message: '主分类号不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '专利类型不能为空', trigger: 'blur' }
          ],
          classCode: [
            { required: true, message: '分类号不能为空', trigger: 'blur' }
          ],
          designer: [
            { required: true, message: '发明人不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '地址不能为空', trigger: 'blur' }
          ],
          summary: [
            { required: true, message: '专利摘要不能为空', trigger: 'blur' }
          ],
          applicant: [
            { required: true, message: '申请者不能为空', trigger: 'blur' }
          ],
          patentNumber: [
            { required: true, message: '专利号不能为空', trigger: 'blur' }
          ],
          applyDate: [
            { required: true, message: '申请日期不能为空', trigger: 'blur' }
          ],
          agentOrg: [
            { required: true, message: '专利代理机构不能为空', trigger: 'blur' }
          ],
          pubNum: [
            { required: true, message: '公开号不能为空', trigger: 'blur' }
          ],
          agent: [
            { required: true, message: '代理人不能为空', trigger: 'blur' }
          ],
          pubDate: [
            { required: true, message: '公开日期不能为空', trigger: 'blur' }
          ],
          intelPub: [
            { required: true, message: '国际公布不能为空', trigger: 'blur' }
          ],
          intelApply: [
            { required: true, message: '国际申请不能为空', trigger: 'blur' }
          ],
          intoChinaDate: [
            { required: true, message: '进入国家日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttcxypatentbase/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.companyId = data.rptTcxyPatentBase.companyId
                this.dataForm.title = data.rptTcxyPatentBase.title
                this.dataForm.mainClassCode = data.rptTcxyPatentBase.mainClassCode
                this.dataForm.type = data.rptTcxyPatentBase.type
                this.dataForm.classCode = data.rptTcxyPatentBase.classCode
                this.dataForm.designer = data.rptTcxyPatentBase.designer
                this.dataForm.address = data.rptTcxyPatentBase.address
                this.dataForm.summary = data.rptTcxyPatentBase.summary
                this.dataForm.applicant = data.rptTcxyPatentBase.applicant
                this.dataForm.patentNumber = data.rptTcxyPatentBase.patentNumber
                this.dataForm.applyDate = data.rptTcxyPatentBase.applyDate
                this.dataForm.agentOrg = data.rptTcxyPatentBase.agentOrg
                this.dataForm.pubNum = data.rptTcxyPatentBase.pubNum
                this.dataForm.agent = data.rptTcxyPatentBase.agent
                this.dataForm.pubDate = data.rptTcxyPatentBase.pubDate
                this.dataForm.intelPub = data.rptTcxyPatentBase.intelPub
                this.dataForm.intelApply = data.rptTcxyPatentBase.intelApply
                this.dataForm.intoChinaDate = data.rptTcxyPatentBase.intoChinaDate
                this.dataForm.createTime = data.rptTcxyPatentBase.createTime
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
              url: this.$http.adornUrl(`/spider/rpttcxypatentbase/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'companyId': this.dataForm.companyId,
                'title': this.dataForm.title,
                'mainClassCode': this.dataForm.mainClassCode,
                'type': this.dataForm.type,
                'classCode': this.dataForm.classCode,
                'designer': this.dataForm.designer,
                'address': this.dataForm.address,
                'summary': this.dataForm.summary,
                'applicant': this.dataForm.applicant,
                'patentNumber': this.dataForm.patentNumber,
                'applyDate': this.dataForm.applyDate,
                'agentOrg': this.dataForm.agentOrg,
                'pubNum': this.dataForm.pubNum,
                'agent': this.dataForm.agent,
                'pubDate': this.dataForm.pubDate,
                'intelPub': this.dataForm.intelPub,
                'intelApply': this.dataForm.intelApply,
                'intoChinaDate': this.dataForm.intoChinaDate,
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
