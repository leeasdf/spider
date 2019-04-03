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
    <el-form-item label="修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item>
    <el-form-item label="经营异常名录ID" prop="busexclist">
      <el-input v-model="dataForm.busexclist" placeholder="经营异常名录ID"></el-input>
    </el-form-item>
    <el-form-item label="主体身份代码" prop="pripid">
      <el-input v-model="dataForm.pripid" placeholder="主体身份代码"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entname">
      <el-input v-model="dataForm.entname" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="uniscid">
      <el-input v-model="dataForm.uniscid" placeholder="统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="regno">
      <el-input v-model="dataForm.regno" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人" prop="lerep">
      <el-input v-model="dataForm.lerep" placeholder="法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="证件类型" prop="certype">
      <el-input v-model="dataForm.certype" placeholder="证件类型"></el-input>
    </el-form-item>
    <el-form-item label="证件号码" prop="cerno">
      <el-input v-model="dataForm.cerno" placeholder="证件号码"></el-input>
    </el-form-item>
    <el-form-item label="列入经营异常名录原因类型" prop="specause">
      <el-input v-model="dataForm.specause" placeholder="列入经营异常名录原因类型"></el-input>
    </el-form-item>
    <el-form-item label="列入经营异常名录原因类型名称" prop="specausename">
      <el-input v-model="dataForm.specausename" placeholder="列入经营异常名录原因类型名称"></el-input>
    </el-form-item>
    <el-form-item label="列入日期" prop="abntime">
      <el-date-picker v-model="dataForm.abntime" value-format="yyyy-MM-dd" placeholder="列入日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="列入决定机关" prop="decorg">
      <el-input v-model="dataForm.decorg" placeholder="列入决定机关"></el-input>
    </el-form-item>
    <el-form-item label="列入决定机关名称" prop="decorgname">
      <el-input v-model="dataForm.decorgname" placeholder="列入决定机关名称"></el-input>
    </el-form-item>
    <el-form-item label="是否移出" prop="ismove">
      <el-input v-model="dataForm.ismove" placeholder="是否移出"></el-input>
    </el-form-item>
    <el-form-item label="移出经营异常名录原因" prop="remexcpres">
      <el-input v-model="dataForm.remexcpres" placeholder="移出经营异常名录原因"></el-input>
    </el-form-item>
    <el-form-item label="移出经营异常名录原因名称" prop="remexcpresname">
      <el-input v-model="dataForm.remexcpresname" placeholder="移出经营异常名录原因名称"></el-input>
    </el-form-item>
    <el-form-item label="移出日期" prop="remdate">
      <el-date-picker v-model="dataForm.remdate" value-format="yyyy-MM-dd" placeholder="移出日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="移出决定机关" prop="ycdecorg">
      <el-input v-model="dataForm.ycdecorg" placeholder="移出决定机关"></el-input>
    </el-form-item>
    <el-form-item label="移出决定机关名称" prop="ycdecorgname">
      <el-input v-model="dataForm.ycdecorgname" placeholder="移出决定机关名称"></el-input>
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
          busexclist: '',
          pripid: '',
          entname: '',
          uniscid: '',
          regno: '',
          lerep: '',
          certype: '',
          cerno: '',
          specause: '',
          specausename: '',
          abntime: '',
          decorg: '',
          decorgname: '',
          ismove: '',
          remexcpres: '',
          remexcpresname: '',
          remdate: '',
          ycdecorg: '',
          ycdecorgname: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态（0：正常 1：更新 2：删除）不能为空', trigger: 'blur' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          busexclist: [
            { required: true, message: '经营异常名录ID不能为空', trigger: 'blur' }
          ],
          pripid: [
            { required: true, message: '主体身份代码不能为空', trigger: 'blur' }
          ],
          entname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          uniscid: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          regno: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          lerep: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          certype: [
            { required: true, message: '证件类型不能为空', trigger: 'blur' }
          ],
          cerno: [
            { required: true, message: '证件号码不能为空', trigger: 'blur' }
          ],
          specause: [
            { required: true, message: '列入经营异常名录原因类型不能为空', trigger: 'blur' }
          ],
          specausename: [
            { required: true, message: '列入经营异常名录原因类型名称不能为空', trigger: 'blur' }
          ],
          abntime: [
            { required: true, message: '列入日期不能为空', trigger: 'blur' }
          ],
          decorg: [
            { required: true, message: '列入决定机关不能为空', trigger: 'blur' }
          ],
          decorgname: [
            { required: true, message: '列入决定机关名称不能为空', trigger: 'blur' }
          ],
          ismove: [
            { required: true, message: '是否移出不能为空', trigger: 'blur' }
          ],
          remexcpres: [
            { required: true, message: '移出经营异常名录原因不能为空', trigger: 'blur' }
          ],
          remexcpresname: [
            { required: true, message: '移出经营异常名录原因名称不能为空', trigger: 'blur' }
          ],
          remdate: [
            { required: true, message: '移出日期不能为空', trigger: 'blur' }
          ],
          ycdecorg: [
            { required: true, message: '移出决定机关不能为空', trigger: 'blur' }
          ],
          ycdecorgname: [
            { required: true, message: '移出决定机关名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwaicejyycmlxx/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwAicEJyycmlxx.isinvalid
                this.dataForm.lastdate = data.csSfgwAicEJyycmlxx.lastdate
                this.dataForm.busexclist = data.csSfgwAicEJyycmlxx.busexclist
                this.dataForm.pripid = data.csSfgwAicEJyycmlxx.pripid
                this.dataForm.entname = data.csSfgwAicEJyycmlxx.entname
                this.dataForm.uniscid = data.csSfgwAicEJyycmlxx.uniscid
                this.dataForm.regno = data.csSfgwAicEJyycmlxx.regno
                this.dataForm.lerep = data.csSfgwAicEJyycmlxx.lerep
                this.dataForm.certype = data.csSfgwAicEJyycmlxx.certype
                this.dataForm.cerno = data.csSfgwAicEJyycmlxx.cerno
                this.dataForm.specause = data.csSfgwAicEJyycmlxx.specause
                this.dataForm.specausename = data.csSfgwAicEJyycmlxx.specausename
                this.dataForm.abntime = data.csSfgwAicEJyycmlxx.abntime
                this.dataForm.decorg = data.csSfgwAicEJyycmlxx.decorg
                this.dataForm.decorgname = data.csSfgwAicEJyycmlxx.decorgname
                this.dataForm.ismove = data.csSfgwAicEJyycmlxx.ismove
                this.dataForm.remexcpres = data.csSfgwAicEJyycmlxx.remexcpres
                this.dataForm.remexcpresname = data.csSfgwAicEJyycmlxx.remexcpresname
                this.dataForm.remdate = data.csSfgwAicEJyycmlxx.remdate
                this.dataForm.ycdecorg = data.csSfgwAicEJyycmlxx.ycdecorg
                this.dataForm.ycdecorgname = data.csSfgwAicEJyycmlxx.ycdecorgname
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
              url: this.$http.adornUrl(`/spider/cssfgwaicejyycmlxx/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'busexclist': this.dataForm.busexclist,
                'pripid': this.dataForm.pripid,
                'entname': this.dataForm.entname,
                'uniscid': this.dataForm.uniscid,
                'regno': this.dataForm.regno,
                'lerep': this.dataForm.lerep,
                'certype': this.dataForm.certype,
                'cerno': this.dataForm.cerno,
                'specause': this.dataForm.specause,
                'specausename': this.dataForm.specausename,
                'abntime': this.dataForm.abntime,
                'decorg': this.dataForm.decorg,
                'decorgname': this.dataForm.decorgname,
                'ismove': this.dataForm.ismove,
                'remexcpres': this.dataForm.remexcpres,
                'remexcpresname': this.dataForm.remexcpresname,
                'remdate': this.dataForm.remdate,
                'ycdecorg': this.dataForm.ycdecorg,
                'ycdecorgname': this.dataForm.ycdecorgname,
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
