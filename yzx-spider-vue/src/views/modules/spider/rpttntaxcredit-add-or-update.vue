<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
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
        <el-form-item label="纳税评级" prop="taxLevel">
          <el-input v-model="dataForm.taxLevel" placeholder="纳税评级"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="纳税人识别号" prop="taxNo">
          <el-input v-model="dataForm.taxNo" placeholder="纳税人识别号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="评价单位" prop="agency">
          <el-input v-model="dataForm.agency" placeholder="评价单位"></el-input>
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
        <el-form-item label="年份" prop="years">
          <el-date-picker type="year" v-model="dataForm.years" value-format="yyyy" placeholder="年份"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
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
          taxLevel: '',
          taxNo: '',
          agency: '',
          type: '',
          years: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          taxLevel: [
            { required: true, message: '纳税评级不能为空', trigger: 'blur' }
          ],
          taxNo: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          agency: [
            { required: true, message: '评价单位不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          years: [
            { required: true, message: '年份不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttntaxcredit/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnTaxCredit.enterpriseId
                this.dataForm.entName = data.rptTnTaxCredit.entName
                this.dataForm.taxLevel = data.rptTnTaxCredit.taxLevel
                this.dataForm.taxNo = data.rptTnTaxCredit.taxNo
                this.dataForm.agency = data.rptTnTaxCredit.agency
                this.dataForm.type = data.rptTnTaxCredit.type
                this.dataForm.years = data.rptTnTaxCredit.years
                this.dataForm.creator = data.rptTnTaxCredit.creator
                this.dataForm.createTime = data.rptTnTaxCredit.createTime
                this.dataForm.updater = data.rptTnTaxCredit.updater
                this.dataForm.updateTime = data.rptTnTaxCredit.updateTime
                this.dataForm.dataState = data.rptTnTaxCredit.dataState
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
              url: this.$http.adornUrl(`/spider/rpttntaxcredit/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'taxLevel': this.dataForm.taxLevel,
                'taxNo': this.dataForm.taxNo,
                'agency': this.dataForm.agency,
                'type': this.dataForm.type,
                'years': this.dataForm.years,
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
