<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <el-form-item label="数据状态" prop="isinvalid">
      <el-radio-group v-model="dataForm.isinvalid">
        <el-radio :label="0">正常</el-radio>
        <el-radio :label="1">更新</el-radio>
        <el-radio :label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="工商内置唯一码" prop="invtNo">
      <el-input v-model="dataForm.invtNo" placeholder="工商内置唯一码"></el-input>
    </el-form-item>
    <el-form-item label="企业信息外键" prop="etpsId">
      <el-input v-model="dataForm.etpsId" placeholder="企业信息外键"></el-input>
    </el-form-item>
    <el-form-item label="投资者类型" prop="invtype">
      <el-input v-model="dataForm.invtype" placeholder="投资者类型"></el-input>
    </el-form-item>
    <el-form-item label="自然人姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="自然人姓名"></el-input>
    </el-form-item>
    <el-form-item label="自然人证件类型" prop="certype">
      <el-input v-model="dataForm.certype" placeholder="自然人证件类型"></el-input>
    </el-form-item>
    <el-form-item label="自然人证件号码" prop="cerno">
      <el-input v-model="dataForm.cerno" placeholder="自然人证件号码"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entname">
      <el-input v-model="dataForm.entname" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="证照类型" prop="blictype">
      <el-input v-model="dataForm.blictype" placeholder="证照类型"></el-input>
    </el-form-item>
    <el-form-item label="证照号码" prop="blicno">
      <el-input v-model="dataForm.blicno" placeholder="证照号码"></el-input>
    </el-form-item>
    <el-form-item label="认缴出资金额" prop="subconam">
      <el-input v-model="dataForm.subconam" placeholder="认缴出资金额"></el-input>
    </el-form-item>
    <el-form-item label="认缴出资时间" prop="condate">
      <el-date-picker v-model="dataForm.condate" value-format="yyyy-MM-dd" placeholder="认缴出资时间"></el-date-picker>
    </el-form-item>
    <el-form-item label="认缴出资方式" prop="conform">
      <el-input v-model="dataForm.conform" placeholder="认缴出资方式"></el-input>
    </el-form-item>
    <el-form-item label="认缴出资比例" prop="subconprop">
      <el-input v-model="dataForm.subconprop" placeholder="认缴出资比例"></el-input>
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
          isinvalid: '',
          lastdate: '',
          invtNo: '',
          etpsId: '',
          invtype: '',
          name: '',
          certype: '',
          cerno: '',
          entname: '',
          blictype: '',
          blicno: '',
          subconam: '',
          condate: '',
          conform: '',
          subconprop: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态（0：正常 1：更新 2：删除）不能为空', trigger: 'blur' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          invtNo: [
            { required: true, message: '工商内置唯一码不能为空', trigger: 'blur' }
          ],
          etpsId: [
            { required: true, message: '企业信息外键不能为空', trigger: 'blur' }
          ],
          invtype: [
            { required: true, message: '投资者类型不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '自然人姓名不能为空', trigger: 'blur' }
          ],
          certype: [
            { required: true, message: '自然人证件类型不能为空', trigger: 'blur' }
          ],
          cerno: [
            { required: true, message: '自然人证件号码不能为空', trigger: 'blur' }
          ],
          entname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          blictype: [
            { required: true, message: '证照类型不能为空', trigger: 'blur' }
          ],
          blicno: [
            { required: true, message: '证照号码不能为空', trigger: 'blur' }
          ],
          subconam: [
            { required: true, message: '认缴出资金额不能为空', trigger: 'blur' }
          ],
          condate: [
            { required: true, message: '认缴出资时间不能为空', trigger: 'blur' }
          ],
          conform: [
            { required: true, message: '认缴出资方式不能为空', trigger: 'blur' }
          ],
          subconprop: [
            { required: true, message: '认缴出资比例不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.zjid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.zjid) {
            this.$http({
              url: this.$http.adornUrl(`/spider/cssfgwaicinvestordocument/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwAicInvestordocument.isinvalid
                this.dataForm.lastdate = data.csSfgwAicInvestordocument.lastdate
                this.dataForm.invtNo = data.csSfgwAicInvestordocument.invtNo
                this.dataForm.etpsId = data.csSfgwAicInvestordocument.etpsId
                this.dataForm.invtype = data.csSfgwAicInvestordocument.invtype
                this.dataForm.name = data.csSfgwAicInvestordocument.name
                this.dataForm.certype = data.csSfgwAicInvestordocument.certype
                this.dataForm.cerno = data.csSfgwAicInvestordocument.cerno
                this.dataForm.entname = data.csSfgwAicInvestordocument.entname
                this.dataForm.blictype = data.csSfgwAicInvestordocument.blictype
                this.dataForm.blicno = data.csSfgwAicInvestordocument.blicno
                this.dataForm.subconam = data.csSfgwAicInvestordocument.subconam
                this.dataForm.condate = data.csSfgwAicInvestordocument.condate
                this.dataForm.conform = data.csSfgwAicInvestordocument.conform
                this.dataForm.subconprop = data.csSfgwAicInvestordocument.subconprop
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
              url: this.$http.adornUrl(`/spider/cssfgwaicinvestordocument/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'invtNo': this.dataForm.invtNo,
                'etpsId': this.dataForm.etpsId,
                'invtype': this.dataForm.invtype,
                'name': this.dataForm.name,
                'certype': this.dataForm.certype,
                'cerno': this.dataForm.cerno,
                'entname': this.dataForm.entname,
                'blictype': this.dataForm.blictype,
                'blicno': this.dataForm.blicno,
                'subconam': this.dataForm.subconam,
                'condate': this.dataForm.condate,
                'conform': this.dataForm.conform,
                'subconprop': this.dataForm.subconprop,
                'zjid': this.dataForm.zjid || undefined
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
