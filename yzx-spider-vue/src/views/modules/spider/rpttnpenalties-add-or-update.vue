<template>
  <el-dialog
    width="700px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
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
        <el-form-item label="决定日期" prop="decisionDate">
          <el-date-picker v-model="dataForm.decisionDate" value-format="yyyy-MM-dd" placeholder="决定日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="决定机关" prop="departmentName">
          <el-input v-model="dataForm.departmentName" placeholder="决定机关"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="决定书文号" prop="punishNumber">
          <el-input v-model="dataForm.punishNumber" placeholder="决定书文号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="类型" prop="type">
          <el-input v-model="dataForm.type" placeholder="类型"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="处罚名称" prop="punishmentName">
          <el-input v-model="dataForm.punishmentName" placeholder="处罚名称"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="注册号" prop="regNum">
          <el-input v-model="dataForm.regNum" placeholder="注册号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="法人" prop="legalPersonName">
          <el-input v-model="dataForm.legalPersonName" placeholder="法人"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="发布日期" prop="publishDate">
          <el-date-picker v-model="dataForm.publishDate" value-format="yyyy-MM-dd" placeholder="发布日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="地域" prop="areaName">
          <el-input v-model="dataForm.areaName" placeholder="地域"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="地点" prop="base">
          <el-input v-model="dataForm.base" placeholder="地点"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="处罚内容" prop="content">
      <el-input type="textarea" v-model="dataForm.content" placeholder="处罚内容"></el-input>
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
          enterpriseId: '',
          entName: '',
          decisionDate: '',
          punishNumber: '',
          type: '',
          departmentName: '',
          content: '',
          areaName: '',
          punishmentName: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          regNum: '',
          name: '',
          publishDate: '',
          base: '',
          legalPersonName: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          decisionDate: [
            { required: true, message: '决定日期不能为空', trigger: 'blur' }
          ],
          punishNumber: [
            { required: true, message: '决定书文号不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          departmentName: [
            { required: true, message: '决定机关不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '处罚内容不能为空', trigger: 'blur' }
          ],
          areaName: [
            { required: true, message: '地域不能为空', trigger: 'blur' }
          ],
          punishmentName: [
            { required: true, message: '处罚名称不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          regNum: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '发布日期不能为空', trigger: 'blur' }
          ],
          base: [
            { required: true, message: '地点不能为空', trigger: 'blur' }
          ],
          legalPersonName: [
            { required: true, message: '法人不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnpenalties/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnPenalties.enterpriseId
                this.dataForm.entName = data.rptTnPenalties.entName
                this.dataForm.decisionDate = data.rptTnPenalties.decisionDate
                this.dataForm.punishNumber = data.rptTnPenalties.punishNumber
                this.dataForm.type = data.rptTnPenalties.type
                this.dataForm.departmentName = data.rptTnPenalties.departmentName
                this.dataForm.content = data.rptTnPenalties.content
                this.dataForm.areaName = data.rptTnPenalties.areaName
                this.dataForm.punishmentName = data.rptTnPenalties.punishmentName
                this.dataForm.creator = data.rptTnPenalties.creator
                this.dataForm.createTime = data.rptTnPenalties.createTime
                this.dataForm.updater = data.rptTnPenalties.updater
                this.dataForm.updateTime = data.rptTnPenalties.updateTime
                this.dataForm.dataState = data.rptTnPenalties.dataState
                this.dataForm.regNum = data.rptTnPenalties.regNum
                this.dataForm.name = data.rptTnPenalties.name
                this.dataForm.publishDate = data.rptTnPenalties.publishDate
                this.dataForm.base = data.rptTnPenalties.base
                this.dataForm.legalPersonName = data.rptTnPenalties.legalPersonName
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
              url: this.$http.adornUrl(`/spider/rpttnpenalties/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'decisionDate': this.dataForm.decisionDate,
                'punishNumber': this.dataForm.punishNumber,
                'type': this.dataForm.type,
                'departmentName': this.dataForm.departmentName,
                'content': this.dataForm.content,
                'areaName': this.dataForm.areaName,
                'punishmentName': this.dataForm.punishmentName,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'regNum': this.dataForm.regNum,
                'name': this.dataForm.name,
                'publishDate': this.dataForm.publishDate,
                'base': this.dataForm.base,
                'legalPersonName': this.dataForm.legalPersonName
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
