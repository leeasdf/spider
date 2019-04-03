<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
    
    <el-form-item label="纳税人名称" prop="taxpayerName">
      <el-input v-model="dataForm.taxpayerName" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="纳税人识别号" prop="taxpayerId">
      <el-input v-model="dataForm.taxpayerId" placeholder="纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="信用级别" prop="creditLevel">
      <el-input v-model="dataForm.creditLevel" placeholder="信用级别"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="ratingYear">
      <el-date-picker type="year" v-model="dataForm.ratingYear" placeholder="评价年度"></el-date-picker>
    </el-form-item>
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
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
          hunanStateTaxId: 0,
          enterpriseId: '',
          taxpayerName: '',
          taxpayerId: '',
          creditLevel: '',
          ratingYear: '',
          memId: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          taxpayerName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxpayerId: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          creditLevel: [
            { required: true, message: '信用级别不能为空', trigger: 'blur' }
          ],
          ratingYear: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.hunanStateTaxId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.hunanStateTaxId) {
            this.$http({
              url: this.$http.adornUrl(`/spider/enthunanstatetaxinfo/info/${this.dataForm.hunanStateTaxId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.entHunanStateTaxInfo.enterpriseId
                this.dataForm.taxpayerName = data.entHunanStateTaxInfo.taxpayerName
                this.dataForm.taxpayerId = data.entHunanStateTaxInfo.taxpayerId
                this.dataForm.creditLevel = data.entHunanStateTaxInfo.creditLevel
                this.dataForm.ratingYear = data.entHunanStateTaxInfo.ratingYear
                this.dataForm.memId = data.entHunanStateTaxInfo.memId
                this.dataForm.creator = data.entHunanStateTaxInfo.creator
                this.dataForm.createTime = data.entHunanStateTaxInfo.createTime
                this.dataForm.updater = data.entHunanStateTaxInfo.updater
                this.dataForm.updateTime = data.entHunanStateTaxInfo.updateTime
                this.dataForm.dataState = data.entHunanStateTaxInfo.dataState
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
              url: this.$http.adornUrl(`/spider/enthunanstatetaxinfo/${!this.dataForm.hunanStateTaxId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'hunanStateTaxId': this.dataForm.hunanStateTaxId || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'taxpayerName': this.dataForm.taxpayerName,
                'taxpayerId': this.dataForm.taxpayerId,
                'creditLevel': this.dataForm.creditLevel,
                'ratingYear': this.dataForm.ratingYear,
                'memId': this.dataForm.memId,
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
