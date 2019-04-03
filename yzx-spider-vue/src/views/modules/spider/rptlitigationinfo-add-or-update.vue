<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    
   <!--  <el-form-item label="信息ID" prop="dataId">
      <el-input v-model="dataForm.dataId" placeholder="信息ID"></el-input>
    </el-form-item> -->
    <el-form-item label="类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型"></el-input>
    </el-form-item>
    <el-form-item label="文书类型" prop="caseType">
      <el-input v-model="dataForm.caseType" placeholder="文书类型"></el-input>
    </el-form-item>
    <el-form-item label="标题" prop="title">
      <el-input v-model="dataForm.title" placeholder="标题"></el-input>
    </el-form-item>
    <el-form-item label="内容" prop="body">
      <el-input type="textarea" :autosize="{ minRows:1, maxRows:4 }" v-model="dataForm.body" placeholder="内容"></el-input>
    </el-form-item>
    <el-form-item label="时间" prop="sortTime">
      <!-- <el-input v-model="dataForm.sortTime" placeholder="时间"></el-input> -->
      <el-date-picker v-model="dataForm.sortTime" placeholder="时间"></el-date-picker>
    </el-form-item>
    <el-form-item label="法院名称" prop="court">
      <el-input v-model="dataForm.court" placeholder="法院名称"></el-input>
    </el-form-item>
    <el-form-item label="案号" prop="caseNo">
      <el-input v-model="dataForm.caseNo" placeholder="案号"></el-input>
    </el-form-item>
    <el-form-item label="被诉人" prop="party">
      <el-input v-model="dataForm.party" placeholder="被诉人"></el-input>
    </el-form-item>
    <el-form-item label="案由" prop="caseCause">
      <el-input v-model="dataForm.caseCause" placeholder="案由"></el-input>
    </el-form-item>
    <el-form-item label="执行状态" prop="status">
      <el-input v-model="dataForm.status" placeholder="执行状态"></el-input>
    </el-form-item>
    <el-form-item label="执行标的" prop="execMoney">
      <el-input v-model="dataForm.execMoney" placeholder="执行标的"></el-input>
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
          dataId: '',
          type: '',
          caseType: '',
          title: '',
          body: '',
          sortTime: '',
          court: '',
          caseNo: '',
          party: '',
          caseCause: '',
          status: '',
          execMoney: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          dataId: [
            { required: true, message: '信息ID不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          caseType: [
            { required: true, message: '文书类型不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '标题不能为空', trigger: 'blur' }
          ],
          body: [
            { required: true, message: '内容不能为空', trigger: 'blur' }
          ],
          sortTime: [
            { required: true, message: '时间不能为空', trigger: 'blur' }
          ],
          court: [
            { required: true, message: '法院名称不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '案号不能为空', trigger: 'blur' }
          ],
          party: [
            { required: true, message: '被诉人不能为空', trigger: 'blur' }
          ],
          caseCause: [
            { required: true, message: '案由不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '执行状态不能为空', trigger: 'blur' }
          ],
          execMoney: [
            { required: true, message: '执行标的不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptlitigationinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptLitigationInfo.memId
                this.dataForm.enterpriseId = data.rptLitigationInfo.enterpriseId
                this.dataForm.dataId = data.rptLitigationInfo.dataId
                this.dataForm.type = data.rptLitigationInfo.type
                this.dataForm.caseType = data.rptLitigationInfo.caseType
                this.dataForm.title = data.rptLitigationInfo.title
                this.dataForm.body = data.rptLitigationInfo.body
                this.dataForm.sortTime = data.rptLitigationInfo.sortTime
                this.dataForm.court = data.rptLitigationInfo.court
                this.dataForm.caseNo = data.rptLitigationInfo.caseNo
                this.dataForm.party = data.rptLitigationInfo.party
                this.dataForm.caseCause = data.rptLitigationInfo.caseCause
                this.dataForm.status = data.rptLitigationInfo.status
                this.dataForm.execMoney = data.rptLitigationInfo.execMoney
                this.dataForm.creator = data.rptLitigationInfo.creator
                this.dataForm.createTime = data.rptLitigationInfo.createTime
                this.dataForm.updater = data.rptLitigationInfo.updater
                this.dataForm.updateTime = data.rptLitigationInfo.updateTime
                this.dataForm.dataState = data.rptLitigationInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptlitigationinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'dataId': this.dataForm.dataId,
                'type': this.dataForm.type,
                'caseType': this.dataForm.caseType,
                'title': this.dataForm.title,
                'body': this.dataForm.body,
                'sortTime': this.dataForm.sortTime,
                'court': this.dataForm.court,
                'caseNo': this.dataForm.caseNo,
                'party': this.dataForm.party,
                'caseCause': this.dataForm.caseCause,
                'status': this.dataForm.status,
                'execMoney': this.dataForm.execMoney,
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
