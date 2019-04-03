<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
	<!--
    <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
	-->
    <el-form-item label="纳税人名称" prop="taxper">
      <el-input v-model="dataForm.taxper" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="税务登记号" prop="taxNo">
      <el-input v-model="dataForm.taxNo" placeholder="税务登记号"></el-input>
    </el-form-item>
    <el-form-item label="信用级别" prop="level">
      <el-input v-model="dataForm.level" placeholder="信用级别"></el-input>
    </el-form-item>
    <el-form-item label="评价税务䩪" prop="authority">
      <el-input v-model="dataForm.authority" placeholder="评价税务䩪"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="years">
      <el-input v-model="dataForm.years" placeholder="评价年度"></el-input>
    </el-form-item>
    <el-form-item label="评价日期" prop="evaluateDate">
      <el-input v-model="dataForm.evaluateDate" placeholder="评价日期"></el-input>
    </el-form-item>
	<!--
    <el-form-item label="数据来源" prop="dataSource">
      <el-input v-model="dataForm.dataSource" placeholder="数据来源"></el-input>
    </el-form-item>
    <el-form-item label="创建人ID" prop="creator">
      <el-input v-model="dataForm.creator" placeholder="创建人ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人ID" prop="updater">
      <el-input v-model="dataForm.updater" placeholder="修改人ID"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
	-->
    <el-form-item label="数据状态：1-正常 0-删除" prop="dataState">
      <el-input v-model="dataForm.dataState" placeholder="数据状态：1-正常 0-删除"></el-input>
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
          taxper: '',
          taxNo: '',
          level: '',
          authority: '',
          years: '',
          evaluateDate: '',
          dataSource: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          taxper: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxNo: [
            { required: true, message: '税务登记号不能为空', trigger: 'blur' }
          ],
          level: [
            { required: true, message: '信用级别不能为空', trigger: 'blur' }
          ],
          authority: [
            { required: true, message: '评价税务䩪不能为空', trigger: 'blur' }
          ],
          years: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          evaluateDate: [
            { required: true, message: '评价日期不能为空', trigger: 'blur' }
          ],

          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/hndscreditlevel/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.hndsCreditLevel.enterpriseId
                this.dataForm.entName = data.hndsCreditLevel.entName
                this.dataForm.taxper = data.hndsCreditLevel.taxper
                this.dataForm.taxNo = data.hndsCreditLevel.taxNo
                this.dataForm.level = data.hndsCreditLevel.level
                this.dataForm.authority = data.hndsCreditLevel.authority
                this.dataForm.years = data.hndsCreditLevel.years
                this.dataForm.evaluateDate = data.hndsCreditLevel.evaluateDate
                this.dataForm.dataSource = data.hndsCreditLevel.dataSource
                this.dataForm.creator = data.hndsCreditLevel.creator
                this.dataForm.createTime = data.hndsCreditLevel.createTime
                this.dataForm.updater = data.hndsCreditLevel.updater
                this.dataForm.updateTime = data.hndsCreditLevel.updateTime
                this.dataForm.dataState = data.hndsCreditLevel.dataState
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
              url: this.$http.adornUrl(`/spider/hndscreditlevel/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'taxper': this.dataForm.taxper,
                'taxNo': this.dataForm.taxNo,
                'level': this.dataForm.level,
                'authority': this.dataForm.authority,
                'years': this.dataForm.years,
                'evaluateDate': this.dataForm.evaluateDate,
                'dataSource': this.dataForm.dataSource,
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
