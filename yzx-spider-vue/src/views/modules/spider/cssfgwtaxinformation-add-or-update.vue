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
    <!-- <el-form-item label="数据最后修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item> -->
    <el-form-item label="标题" prop="bt">
      <el-input v-model="dataForm.bt" placeholder="标题"></el-input>
    </el-form-item>
    <el-form-item label="纳税人名称" prop="nsrmc">
      <el-input v-model="dataForm.nsrmc" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="纳税识别号" prop="nssbh">
      <el-input v-model="dataForm.nssbh" placeholder="纳税识别号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人" prop="fddbr">
      <el-input v-model="dataForm.fddbr" placeholder="法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="身份证号码" prop="sfzhm">
      <el-input v-model="dataForm.sfzhm" placeholder="身份证号码"></el-input>
    </el-form-item>
    <el-form-item label="经营地址" prop="jydz">
      <el-input v-model="dataForm.jydz" placeholder="经营地址"></el-input>
    </el-form-item>
    <el-form-item label="欠税税种" prop="qssz">
      <el-input v-model="dataForm.qssz" placeholder="欠税税种"></el-input>
    </el-form-item>
    <el-form-item label="欠税余额" prop="qsye">
      <el-input v-model="dataForm.qsye" placeholder="欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="本年新发生欠款" prop="bnxfsqk">
      <el-input v-model="dataForm.bnxfsqk" placeholder="本年新发生欠款"></el-input>
    </el-form-item>
    <el-form-item label="内容" prop="nr">
      <el-input type="textarea" v-model="dataForm.nr" placeholder="内容"></el-input>
    </el-form-item>
    <el-form-item label="时间" prop="sj">
      <!-- <el-input v-model="dataForm.sj" placeholder="时间"></el-input> -->
      <el-date-picker v-model="dataForm.sj" placeholder="时间" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isFloat, isIDCard } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      const validateIDCard = function (rule, value, callback) {
        if (!isIDCard(value)) {
          callback(new Error('身份证号格式错误'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          isinvalid: '',
          lastdate: '',
          bt: '',
          nsrmc: '',
          nssbh: '',
          fddbr: '',
          sfzhm: '',
          jydz: '',
          qssz: '',
          qsye: '',
          bnxfsqk: '',
          nr: '',
          sj: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          bt: [
            { required: true, message: '标题不能为空', trigger: 'blur' }
          ],
          nsrmc: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          nssbh: [
            { required: true, message: '纳税识别号不能为空', trigger: 'blur' }
          ],
          fddbr: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          sfzhm: [
            { required: true, message: '身份证号码不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          jydz: [
            { required: true, message: '经营地址不能为空', trigger: 'blur' }
          ],
          qssz: [
            { required: true, message: '欠税税种不能为空', trigger: 'blur' }
          ],
          qsye: [
            { required: true, message: '欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          bnxfsqk: [
            { required: true, message: '本年新发生欠款不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          nr: [
            { required: true, message: '内容不能为空', trigger: 'blur' }
          ],
          sj: [
            { required: true, message: '时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwtaxinformation/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwTaxInformation.isinvalid
                this.dataForm.lastdate = data.csSfgwTaxInformation.lastdate
                this.dataForm.bt = data.csSfgwTaxInformation.bt
                this.dataForm.nsrmc = data.csSfgwTaxInformation.nsrmc
                this.dataForm.nssbh = data.csSfgwTaxInformation.nssbh
                this.dataForm.fddbr = data.csSfgwTaxInformation.fddbr
                this.dataForm.sfzhm = data.csSfgwTaxInformation.sfzhm
                this.dataForm.jydz = data.csSfgwTaxInformation.jydz
                this.dataForm.qssz = data.csSfgwTaxInformation.qssz
                this.dataForm.qsye = data.csSfgwTaxInformation.qsye
                this.dataForm.bnxfsqk = data.csSfgwTaxInformation.bnxfsqk
                this.dataForm.nr = data.csSfgwTaxInformation.nr
                this.dataForm.sj = data.csSfgwTaxInformation.sj
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
              url: this.$http.adornUrl(`/spider/cssfgwtaxinformation/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'bt': this.dataForm.bt,
                'nsrmc': this.dataForm.nsrmc,
                'nssbh': this.dataForm.nssbh,
                'fddbr': this.dataForm.fddbr,
                'sfzhm': this.dataForm.sfzhm,
                'jydz': this.dataForm.jydz,
                'qssz': this.dataForm.qssz,
                'qsye': this.dataForm.qsye,
                'bnxfsqk': this.dataForm.bnxfsqk,
                'nr': this.dataForm.nr,
                'sj': this.dataForm.sj,
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
