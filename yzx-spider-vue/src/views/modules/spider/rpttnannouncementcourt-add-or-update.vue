<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="开庭日期" prop="startDate">
            <el-date-picker type="datetime" v-model="dataForm.startDate" format="yyyy-MM-dd hh:mm"  value-format="yyyy-MM-dd hh:mm" placeholder="开庭日期"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="案件原由" prop="caseReason">
            <el-input v-model="dataForm.caseReason" placeholder="案件原由"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="案件编号" prop="caseNo">
            <el-input v-model="dataForm.caseNo" placeholder="案件编号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="法庭" prop="courtroom">
            <el-input v-model="dataForm.courtroom" placeholder="法庭"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="法院" prop="court">
            <el-input v-model="dataForm.court" placeholder="法院"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="审判者/主审人" prop="contractors">
            <el-input v-model="dataForm.contractors" placeholder="审判者/主审人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="关联名单" prop="connList">
            <el-input v-model="dataForm.connList" placeholder="关联名单"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="类别" prop="type">
            <el-input v-model="dataForm.type" placeholder="类别"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="事件时间" prop="eventTime">
            <el-date-picker v-model="dataForm.eventTime" value-format="yyyy-MM-dd" placeholder="事件时间"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="搜索类别" prop="searchType">
            <el-input v-model="dataForm.searchType" placeholder="搜索类别"></el-input>
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
      <el-form-item label="诉讼当事人" prop="litigant">
        <el-input type="textarea" v-model="dataForm.litigant" placeholder="诉讼当事人"></el-input>
      </el-form-item>
      <el-form-item label="原告/上诉人" prop="plaintiff">
        <el-input v-model="dataForm.plaintiff" type="textarea" placeholder="原告/上诉人"></el-input>
      </el-form-item>
      <el-form-item label="被告/被上诉人" prop="defendant">
        <el-input v-model="dataForm.defendant" type="textarea" placeholder="被告/被上诉人"></el-input>
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
          startDate: '',
          plaintiff: '',
          defendant: '',
          caseReason: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          courtroom: '',
          caseNo: '',
          court: '',
          aid: '',
          searchType: '',
          litigant: '',
          type: '',
          connList: '',
          contractors: '',
          eventTime: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          startDate: [
            { required: true, message: '开庭日期不能为空', trigger: 'blur' }
          ],
          plaintiff: [
            { required: true, message: '原告/上诉人不能为空', trigger: 'blur' }
          ],
          defendant: [
            { required: true, message: '被告/被上诉人不能为空', trigger: 'blur' }
          ],
          caseReason: [
            { required: true, message: '案件原由不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          courtroom: [
            { required: true, message: '法庭不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '案件编号不能为空', trigger: 'blur' }
          ],
          court: [
            { required: true, message: '法院不能为空', trigger: 'blur' }
          ],
          /* aid: [
            { required: true, message: '事件ID不能为空', trigger: 'blur' }
          ], */
          searchType: [
            { required: true, message: '搜索类别不能为空', trigger: 'blur' }
          ],
          litigant: [
            { required: true, message: '诉讼当事人不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          connList: [
            { required: true, message: '关联名单不能为空', trigger: 'blur' }
          ],
          contractors: [
            { required: true, message: '审判者/主审人不能为空', trigger: 'blur' }
          ],
          eventTime: [
            { required: true, message: '事件时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnannouncementcourt/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnAnnouncementcourt.enterpriseId
                this.dataForm.entName = data.rptTnAnnouncementcourt.entName
                this.dataForm.startDate = data.rptTnAnnouncementcourt.startDate
                this.dataForm.plaintiff = data.rptTnAnnouncementcourt.plaintiff
                this.dataForm.defendant = data.rptTnAnnouncementcourt.defendant
                this.dataForm.caseReason = data.rptTnAnnouncementcourt.caseReason
                this.dataForm.creator = data.rptTnAnnouncementcourt.creator
                this.dataForm.createTime = data.rptTnAnnouncementcourt.createTime
                this.dataForm.updater = data.rptTnAnnouncementcourt.updater
                this.dataForm.updateTime = data.rptTnAnnouncementcourt.updateTime
                this.dataForm.dataState = data.rptTnAnnouncementcourt.dataState
                this.dataForm.courtroom = data.rptTnAnnouncementcourt.courtroom
                this.dataForm.caseNo = data.rptTnAnnouncementcourt.caseNo
                this.dataForm.court = data.rptTnAnnouncementcourt.court
                this.dataForm.aid = data.rptTnAnnouncementcourt.aid
                this.dataForm.searchType = data.rptTnAnnouncementcourt.searchType
                this.dataForm.litigant = data.rptTnAnnouncementcourt.litigant
                this.dataForm.type = data.rptTnAnnouncementcourt.type
                this.dataForm.connList = data.rptTnAnnouncementcourt.connList
                this.dataForm.contractors = data.rptTnAnnouncementcourt.contractors
                this.dataForm.eventTime = data.rptTnAnnouncementcourt.eventTime
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
              url: this.$http.adornUrl(`/spider/rpttnannouncementcourt/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'startDate': this.dataForm.startDate,
                'plaintiff': this.dataForm.plaintiff,
                'defendant': this.dataForm.defendant,
                'caseReason': this.dataForm.caseReason,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'courtroom': this.dataForm.courtroom,
                'caseNo': this.dataForm.caseNo,
                'court': this.dataForm.court,
                'aid': this.dataForm.aid,
                'searchType': this.dataForm.searchType,
                'litigant': this.dataForm.litigant,
                'type': this.dataForm.type,
                'connList': this.dataForm.connList,
                'contractors': this.dataForm.contractors,
                'eventTime': this.dataForm.eventTime
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
