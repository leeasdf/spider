<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!-- <el-form-item label="会员主键" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员主键"></el-input>
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
        <el-form-item label="申请号" prop="patentNumber">
          <el-input v-model="dataForm.patentNumber" placeholder="申请号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="公布号" prop="pubNum">
          <el-input v-model="dataForm.pubNum" placeholder="公布号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="申请时间" prop="applyDate">
          <el-date-picker v-model="dataForm.applyDate" value-format="yyyy-MM-dd" placeholder="申请时间"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="发布日期" prop="pubDate">
          <el-date-picker v-model="dataForm.pubDate" value-format="yyyy-MM-dd" placeholder="发布日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="专利摘要" prop="summary">
      <el-input type="textarea" v-model="dataForm.summary" placeholder="专利摘要"></el-input>
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
          title: '',
          type: '',
          patentNumber: '',
          pubNum: '',
          applyDate: '',
          pubDate: '',
          summary: '',
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
          title: [
            { required: true, message: '专利名称不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '专利类型不能为空', trigger: 'blur' }
          ],
          patentNumber: [
            { required: true, message: '申请号不能为空', trigger: 'blur' }
          ],
          pubNum: [
            { required: true, message: '公布号不能为空', trigger: 'blur' }
          ],
          applyDate: [
            { required: true, message: '申请时间不能为空', trigger: 'blur' }
          ],
          pubDate: [
            { required: true, message: '发布日期不能为空', trigger: 'blur' }
          ],
          summary: [
            { required: true, message: '专利摘要不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptpatentsinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptPatentsInfo.memId
                this.dataForm.enterpriseId = data.rptPatentsInfo.enterpriseId
                this.dataForm.title = data.rptPatentsInfo.title
                this.dataForm.type = data.rptPatentsInfo.type
                this.dataForm.patentNumber = data.rptPatentsInfo.patentNumber
                this.dataForm.pubNum = data.rptPatentsInfo.pubNum
                this.dataForm.applyDate = data.rptPatentsInfo.applyDate
                this.dataForm.pubDate = data.rptPatentsInfo.pubDate
                this.dataForm.summary = data.rptPatentsInfo.summary
                this.dataForm.creator = data.rptPatentsInfo.creator
                this.dataForm.createTime = data.rptPatentsInfo.createTime
                this.dataForm.updater = data.rptPatentsInfo.updater
                this.dataForm.updateTime = data.rptPatentsInfo.updateTime
                this.dataForm.dataState = data.rptPatentsInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptpatentsinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'title': this.dataForm.title,
                'type': this.dataForm.type,
                'patentNumber': this.dataForm.patentNumber,
                'pubNum': this.dataForm.pubNum,
                'applyDate': this.dataForm.applyDate,
                'pubDate': this.dataForm.pubDate,
                'summary': this.dataForm.summary,
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
