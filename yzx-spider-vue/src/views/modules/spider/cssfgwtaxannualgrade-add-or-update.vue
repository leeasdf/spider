<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
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
    <el-form-item label="纳税人识别号" prop="nsrsbh">
      <el-input v-model="dataForm.nsrsbh" placeholder="纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="纳税人名称" prop="nsrmc">
      <el-input v-model="dataForm.nsrmc" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="pjnd">
      <!-- <el-input v-model="dataForm.pjnd" placeholder="评价年度"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.pjnd" placeholder="评价年度"></el-date-picker>
    </el-form-item>
    <el-form-item label="主管税务机关" prop="zgswjg">
      <el-input v-model="dataForm.zgswjg" placeholder="主管税务机关"></el-input>
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
          nsrsbh: '',
          nsrmc: '',
          pjnd: '',
          zgswjg: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          nsrsbh: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          nsrmc: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          pjnd: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          zgswjg: [
            { required: true, message: '主管税务机关不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwtaxannualgrade/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwTaxAnnualgrade.isinvalid
                this.dataForm.lastdate = data.csSfgwTaxAnnualgrade.lastdate
                this.dataForm.nsrsbh = data.csSfgwTaxAnnualgrade.nsrsbh
                this.dataForm.nsrmc = data.csSfgwTaxAnnualgrade.nsrmc
                this.dataForm.pjnd = data.csSfgwTaxAnnualgrade.pjnd
                this.dataForm.zgswjg = data.csSfgwTaxAnnualgrade.zgswjg
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
              url: this.$http.adornUrl(`/spider/cssfgwtaxannualgrade/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'nsrsbh': this.dataForm.nsrsbh,
                'nsrmc': this.dataForm.nsrmc,
                'pjnd': this.dataForm.pjnd,
                'zgswjg': this.dataForm.zgswjg,
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
