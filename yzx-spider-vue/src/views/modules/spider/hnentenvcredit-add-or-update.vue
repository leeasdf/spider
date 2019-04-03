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
    <el-form-item label="企业名称" prop="comName">
      <el-input v-model="dataForm.comName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="区域id" prop="areaId">
      <el-input v-model="dataForm.areaId" placeholder="区域id"></el-input>
    </el-form-item>
    <el-form-item label="区域名称" prop="areaName">
      <el-input v-model="dataForm.areaName" placeholder="区域名称"></el-input>
    </el-form-item>
    <!--
    <el-form-item label="行号" prop="rowno">
      <el-input v-model="dataForm.rowno" placeholder="行号"></el-input>
    </el-form-item>
    -->
    <el-form-item label="企业类别" prop="comType">
      <el-input v-model="dataForm.comType" placeholder="企业类别"></el-input>
    </el-form-item>
    <el-form-item label="评级时间" prop="ext1">
      <el-input v-model="dataForm.ext1" placeholder="评级时间"></el-input>
    </el-form-item>
    <el-form-item label="年份" prop="years">
      <el-input v-model="dataForm.years" placeholder="年份"></el-input>
    </el-form-item>
    <el-form-item label="结果3 ID" prop="result3RId">
      <el-input v-model="dataForm.result3RId" placeholder="结果3 ID"></el-input>
    </el-form-item>
    <el-form-item label="结果3" prop="result3">
      <el-input v-model="dataForm.result3" placeholder="结果3"></el-input>
    </el-form-item>
    <el-form-item label="结果4 ID" prop="result4RId">
      <el-input v-model="dataForm.result4RId" placeholder="结果4 ID"></el-input>
    </el-form-item>
    <el-form-item label="结果4" prop="result4">
      <el-input v-model="dataForm.result4" placeholder="结果4"></el-input>
    </el-form-item>
    <el-form-item label="结果5 ID" prop="result5RId">
      <el-input v-model="dataForm.result5RId" placeholder="结果5 ID"></el-input>
    </el-form-item>
    <el-form-item label="评定等级" prop="result5">
      <el-input v-model="dataForm.result5" placeholder="评定等级"></el-input>
    </el-form-item>
    <el-form-item label="结果6 ID" prop="result6RId">
      <el-input v-model="dataForm.result6RId" placeholder="结果6 ID"></el-input>
    </el-form-item>
    <el-form-item label="结果6" prop="result6">
      <el-input v-model="dataForm.result6" placeholder="结果6"></el-input>
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
          comName: '',
          areaId: '',
          areaName: '',
          rowno: '',
          comType: '',
          ext1: '',
          years: '',
          result3RId: '',
          result3: '',
          result4RId: '',
          result4: '',
          result5RId: '',
          result5: '',
          result6RId: '',
          result6: '',
          dataSource: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          comName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          areaId: [
            { required: true, message: '区域id不能为空', trigger: 'blur' }
          ],
          areaName: [
            { required: true, message: '区域名称不能为空', trigger: 'blur' }
          ],
          comType: [
            { required: true, message: '企业类别不能为空', trigger: 'blur' }
          ],
          ext1: [
            { required: true, message: '评级时间不能为空', trigger: 'blur' }
          ],
          years: [
            { required: true, message: '年份不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/hnentenvcredit/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.hnEntEnvCredit.enterpriseId
                this.dataForm.entName = data.hnEntEnvCredit.entName
                this.dataForm.comName = data.hnEntEnvCredit.comName
                this.dataForm.areaId = data.hnEntEnvCredit.areaId
                this.dataForm.areaName = data.hnEntEnvCredit.areaName
                this.dataForm.rowno = data.hnEntEnvCredit.rowno
                this.dataForm.comType = data.hnEntEnvCredit.comType
                this.dataForm.ext1 = data.hnEntEnvCredit.ext1
                this.dataForm.years = data.hnEntEnvCredit.years
                this.dataForm.result3RId = data.hnEntEnvCredit.result3RId
                this.dataForm.result3 = data.hnEntEnvCredit.result3
                this.dataForm.result4RId = data.hnEntEnvCredit.result4RId
                this.dataForm.result4 = data.hnEntEnvCredit.result4
                this.dataForm.result5RId = data.hnEntEnvCredit.result5RId
                this.dataForm.result5 = data.hnEntEnvCredit.result5
                this.dataForm.result6RId = data.hnEntEnvCredit.result6RId
                this.dataForm.result6 = data.hnEntEnvCredit.result6
                this.dataForm.dataSource = data.hnEntEnvCredit.dataSource
                this.dataForm.creator = data.hnEntEnvCredit.creator
                this.dataForm.createTime = data.hnEntEnvCredit.createTime
                this.dataForm.updater = data.hnEntEnvCredit.updater
                this.dataForm.updateTime = data.hnEntEnvCredit.updateTime
                this.dataForm.dataState = data.hnEntEnvCredit.dataState
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
              url: this.$http.adornUrl(`/spider/hnentenvcredit/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'comName': this.dataForm.comName,
                'areaId': this.dataForm.areaId,
                'areaName': this.dataForm.areaName,
                'rowno': this.dataForm.rowno,
                'comType': this.dataForm.comType,
                'ext1': this.dataForm.ext1,
                'years': this.dataForm.years,
                'result3RId': this.dataForm.result3RId,
                'result3': this.dataForm.result3,
                'result4RId': this.dataForm.result4RId,
                'result4': this.dataForm.result4,
                'result5RId': this.dataForm.result5RId,
                'result5': this.dataForm.result5,
                'result6RId': this.dataForm.result6RId,
                'result6': this.dataForm.result6,
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
