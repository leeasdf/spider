<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="200px">
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
    <el-form-item label="欠税人名称" prop="nsrmc">
      <el-input v-model="dataForm.nsrmc" placeholder="欠税人名称"></el-input>
    </el-form-item>
    <el-form-item label="欠税人识别号" prop="nsrsbh">
      <el-input v-model="dataForm.nsrsbh" placeholder="欠税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人/负责人" prop="fddbrxm">
      <el-input v-model="dataForm.fddbrxm" placeholder="法定代表人（负责人）"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人/负责人身份证号" prop="fddbrsfzjhm">
      <el-input v-model="dataForm.fddbrsfzjhm" placeholder="法定代表人（负责人）身份证件号"></el-input>
    </el-form-item>
    <el-form-item label="欠税余额" prop="qsye">
      <el-input v-model="dataForm.qsye" placeholder="欠税余额"></el-input>
    </el-form-item>
    <el-form-item label="生产经营地址" prop="scjydz">
      <el-input type="textarea" v-model="dataForm.scjydz" placeholder="生产经营地址"></el-input>
    </el-form-item>
    <el-form-item label="公告日期" prop="ggrq">
      <el-date-picker v-model="dataForm.ggrq" placeholder="公告日期" value-format="yyyy-MM-dd"></el-date-picker>
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
      const validateIDCard = function (rule, value, callback) {
        if (!isIDCard(value)) {
          callback(new Error('身份证号格式错误'))
        } else {
          callback()
        }
      }
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          isinvalid: '',
          lastdate: '',
          nsrmc: '',
          nsrsbh: '',
          fddbrxm: '',
          fddbrsfzjhm: '',
          qsye: '',
          scjydz: '',
          ggrq: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态（0：正常 1：更新 2：删除）不能为空', trigger: 'blur' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          nsrmc: [
            { required: true, message: '欠税人名称不能为空', trigger: 'blur' }
          ],
          nsrsbh: [
            { required: true, message: '欠税人识别号不能为空', trigger: 'blur' }
          ],
          fddbrxm: [
            { required: true, message: '法定代表人（负责人）不能为空', trigger: 'blur' }
          ],
          fddbrsfzjhm: [
            { required: true, message: '法定代表人（负责人）身份证件号不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          qsye: [
            { required: true, message: '欠税余额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          scjydz: [
            { required: true, message: '生产经营地址不能为空', trigger: 'blur' }
          ],
          ggrq: [
            { required: true, message: '公告日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwdsrentownedtaxofperson/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwDsRentownedtaxofperson.isinvalid
                this.dataForm.lastdate = data.csSfgwDsRentownedtaxofperson.lastdate
                this.dataForm.nsrmc = data.csSfgwDsRentownedtaxofperson.nsrmc
                this.dataForm.nsrsbh = data.csSfgwDsRentownedtaxofperson.nsrsbh
                this.dataForm.fddbrxm = data.csSfgwDsRentownedtaxofperson.fddbrxm
                this.dataForm.fddbrsfzjhm = data.csSfgwDsRentownedtaxofperson.fddbrsfzjhm
                this.dataForm.qsye = data.csSfgwDsRentownedtaxofperson.qsye
                this.dataForm.scjydz = data.csSfgwDsRentownedtaxofperson.scjydz
                this.dataForm.ggrq = data.csSfgwDsRentownedtaxofperson.ggrq
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
              url: this.$http.adornUrl(`/spider/cssfgwdsrentownedtaxofperson/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'nsrmc': this.dataForm.nsrmc,
                'nsrsbh': this.dataForm.nsrsbh,
                'fddbrxm': this.dataForm.fddbrxm,
                'fddbrsfzjhm': this.dataForm.fddbrsfzjhm,
                'qsye': this.dataForm.qsye,
                'scjydz': this.dataForm.scjydz,
                'ggrq': this.dataForm.ggrq,
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
