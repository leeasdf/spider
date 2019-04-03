<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="150px">
    <el-form-item label="数据状态" prop="isinvalid">
      <el-radio-group v-model="dataForm.isinvalid">
        <el-radio :label="0">正常</el-radio>
        <el-radio :label="1">更新</el-radio>
        <el-radio :label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <!-- <el-form-item label="数据最后修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item>
    <el-form-item label="序号" prop="xh">
      <el-input v-model="dataForm.xh" placeholder="序号"></el-input>
    </el-form-item> -->
    <el-form-item label="污染源编号" prop="wrybh">
      <el-input v-model="dataForm.wrybh" placeholder="污染源编号"></el-input>
    </el-form-item>
    <el-form-item label="污染源名称" prop="wrymc">
      <el-input v-model="dataForm.wrymc" placeholder="污染源名称"></el-input>
    </el-form-item>
    <el-form-item label="年度" prop="nd">
      <!-- <el-input v-model="dataForm.nd" placeholder="年度"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.nd" placeholder="年度"></el-date-picker>
    </el-form-item>
    <el-form-item label="处罚主体" prop="cfzt">
      <el-input v-model="dataForm.cfzt" placeholder="处罚主体"></el-input>
    </el-form-item>
    <el-form-item label="调查机构" prop="dcjg">
      <el-input v-model="dataForm.dcjg" placeholder="调查机构"></el-input>
    </el-form-item>
    <el-form-item label="立案号" prop="lah">
      <el-input v-model="dataForm.lah" placeholder="立案号"></el-input>
    </el-form-item>
    <el-form-item label="决定书文号" prop="jdswh">
      <el-input v-model="dataForm.jdswh" placeholder="决定书文号"></el-input>
    </el-form-item>
    <el-form-item label="立案日期" prop="larq">
      <!-- <el-input v-model="dataForm.larq" placeholder="立案日期"></el-input> -->
      <el-date-picker v-model="dataForm.larq" placeholder="立案日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="案情简介" prop="aqjj">
      <el-input v-model="dataForm.aqjj" placeholder="案情简介"></el-input>
    </el-form-item>
    <el-form-item label="主要违法行为" prop="zywfxw">
      <el-input v-model="dataForm.zywfxw" placeholder="主要违法行为"></el-input>
    </el-form-item>
    <el-form-item label="处罚依据" prop="cfyj">
      <el-input type="textarea" v-model="dataForm.cfyj" placeholder="处罚依据"></el-input>
    </el-form-item>
    <el-form-item label="处罚种类" prop="cfzl">
      <el-input v-model="dataForm.cfzl" placeholder="处罚种类"></el-input>
    </el-form-item>
    <el-form-item label="罚款数额" prop="fkse">
      <el-input v-model="dataForm.fkse" placeholder="罚款数额（万元）">
        <span slot="append">万元</span>
      </el-input>
    </el-form-item>
    <el-form-item label="行政命令种类" prop="xzmlzl">
      <el-input v-model="dataForm.xzmlzl" placeholder="行政命令种类"></el-input>
    </el-form-item>
    <el-form-item label="是否举行听证" prop="sfjxtz">
      <!-- <el-input v-model="dataForm.sfjxtz" placeholder="是否举行听证"></el-input> -->
      <el-radio-group v-model="dataForm.sfjxtz">
        <el-radio label="是">是</el-radio>
        <el-radio label="否">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="决定下达日期" prop="jdxdrq">
      <!-- <el-input v-model="dataForm.jdxdrq" placeholder="决定下达日期"></el-input> -->
      <el-date-picker v-model="dataForm.jdxdrq" placeholder="决定下达日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="决定书内容" prop="jdsnr">
      <el-input v-model="dataForm.jdsnr" placeholder="决定书内容"></el-input>
    </el-form-item>
    <el-form-item label="执行情况" prop="zxqk">
      <el-input v-model="dataForm.zxqk" placeholder="执行情况"></el-input>
    </el-form-item>
    <el-form-item label="执行完毕日期" prop="zxwbrq">
      <!-- <el-input v-model="dataForm.zxwbrq" placeholder="执行完毕日期"></el-input> -->
      <el-date-picker v-model="dataForm.zxwbrq" placeholder="执行完毕日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="复议结果" prop="fyjg">
      <el-input v-model="dataForm.fyjg" placeholder="复议结果"></el-input>
    </el-form-item>
    <el-form-item label="诉讼结果" prop="ssjg">
      <el-input v-model="dataForm.ssjg" placeholder="诉讼结果"></el-input>
    </el-form-item>
    <el-form-item label="移送信息" prop="ysxx">
      <el-input v-model="dataForm.ysxx" placeholder="移送信息"></el-input>
    </el-form-item>
    <el-form-item label="结案日期" prop="jarq">
      <!-- <el-input v-model="dataForm.jarq" placeholder="结案日期"></el-input> -->
      <el-date-picker v-model="dataForm.jarq" placeholder="结案日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="是否结案" prop="sfja">
      <el-radio-group v-model="dataForm.sfja">
        <el-radio label="Y">已结案</el-radio>
        <el-radio label="N">未结案</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="案卷号" prop="ajh">
      <el-input v-model="dataForm.ajh" placeholder="案卷号"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="bz">
      <el-input v-model="dataForm.bz" placeholder="备注"></el-input>
    </el-form-item>
    <!-- <el-form-item label="创建时间" prop="cjsj">
      <el-input v-model="dataForm.cjsj" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="xgsj">
      <el-input v-model="dataForm.xgsj" placeholder="修改时间"></el-input>
    </el-form-item> -->
    <el-form-item label="数据来源" prop="sjly">
      <el-input v-model="dataForm.sjly" placeholder="数据来源"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="zt">
      <el-radio-group v-model="dataForm.zt">
        <el-radio label="0">新增</el-radio>
        <el-radio label="1">修改</el-radio>
        <el-radio label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="是否已交换" prop="sfyjh">
      <el-radio-group v-model="dataForm.sfyjh">
        <el-radio label="Y">已交换</el-radio>
        <el-radio label="N">未交换</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="审核状态" prop="shzt">
      <el-input v-model="dataForm.shzt" placeholder="审核状态"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="tyshxydm">
      <el-input v-model="dataForm.tyshxydm" placeholder="统一社会信用代码"></el-input>
    </el-form-item>
    <el-form-item label="作出决定的相关材料" prop="zcjdxgcl">
      <el-input v-model="dataForm.zcjdxgcl" placeholder="作出决定的相关材料"></el-input>
    </el-form-item>
    <el-form-item label="违法案件类型" prop="wfajlx">
      <el-input v-model="dataForm.wfajlx" placeholder="违法案件类型"></el-input>
    </el-form-item>
   <!--  <el-form-item label="更新时间戳" prop="xyhnDbTime">
      <el-input v-model="dataForm.xyhnDbTime" placeholder="更新时间戳"></el-input>
    </el-form-item> -->
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
          xh: '',
          wrybh: '',
          wrymc: '',
          nd: '',
          cfzt: '',
          dcjg: '',
          lah: '',
          jdswh: '',
          larq: '',
          aqjj: '',
          zywfxw: '',
          cfyj: '',
          cfzl: '',
          fkse: '',
          xzmlzl: '',
          sfjxtz: '',
          jdxdrq: '',
          jdsnr: '',
          zxqk: '',
          zxwbrq: '',
          fyjg: '',
          ssjg: '',
          ysxx: '',
          jarq: '',
          sfja: '',
          ajh: '',
          bz: '',
          cjsj: '',
          xgsj: '',
          sjly: '',
          zt: '',
          sfyjh: '',
          shzt: '',
          tyshxydm: '',
          zcjdxgcl: '',
          wfajlx: '',
          xyhnDbTime: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          /* lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          xh: [
            { required: true, message: '序号不能为空', trigger: 'blur' }
          ], */
          wrybh: [
            { required: true, message: '污染源编号不能为空', trigger: 'blur' }
          ],
          wrymc: [
            { required: true, message: '污染源名称不能为空', trigger: 'blur' }
          ],
          nd: [
            { required: true, message: '年度不能为空', trigger: 'blur' }
          ],
          cfzt: [
            { required: true, message: '处罚主体不能为空', trigger: 'blur' }
          ],
          dcjg: [
            { required: true, message: '调查机构不能为空', trigger: 'blur' }
          ],
          lah: [
            { required: true, message: '立案号不能为空', trigger: 'blur' }
          ],
          jdswh: [
            { required: true, message: '决定书文号不能为空', trigger: 'blur' }
          ],
          larq: [
            { required: true, message: '立案日期不能为空', trigger: 'blur' }
          ],
          aqjj: [
            { required: true, message: '案情简介不能为空', trigger: 'blur' }
          ],
          zywfxw: [
            { required: true, message: '主要违法行为不能为空', trigger: 'blur' }
          ],
          cfyj: [
            { required: true, message: '处罚依据不能为空', trigger: 'blur' }
          ],
          cfzl: [
            { required: true, message: '处罚种类不能为空', trigger: 'blur' }
          ],
          fkse: [
            { required: true, message: '罚款数额（万元）不能为空', trigger: 'blur' }
          ],
          xzmlzl: [
            { required: true, message: '行政命令种类不能为空', trigger: 'blur' }
          ],
          sfjxtz: [
            { required: true, message: '是否举行听证不能为空', trigger: 'blur' }
          ],
          jdxdrq: [
            { required: true, message: '决定下达日期不能为空', trigger: 'blur' }
          ],
          jdsnr: [
            { required: true, message: '决定书内容不能为空', trigger: 'blur' }
          ],
          zxqk: [
            { required: true, message: '执行情况不能为空', trigger: 'blur' }
          ],
          zxwbrq: [
            { required: true, message: '执行完毕日期不能为空', trigger: 'blur' }
          ],
          fyjg: [
            { required: true, message: '复议结果不能为空', trigger: 'blur' }
          ],
          ssjg: [
            { required: true, message: '诉讼结果不能为空', trigger: 'blur' }
          ],
          ysxx: [
            { required: true, message: '移送信息不能为空', trigger: 'blur' }
          ],
          jarq: [
            { required: true, message: '结案日期不能为空', trigger: 'blur' }
          ],
          sfja: [
            { required: true, message: '是否结案不能为空', trigger: 'change' }
          ],
          ajh: [
            { required: true, message: '案卷号不能为空', trigger: 'blur' }
          ],
          bz: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          cjsj: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          /* xgsj: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ], */
          sjly: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          zt: [
            { required: true, message: '状态不能为空', trigger: 'change' }
          ],
          sfyjh: [
            { required: true, message: '是否已交换不能为空', trigger: 'change' }
          ],
          shzt: [
            { required: true, message: '审核状态不能为空', trigger: 'blur' }
          ],
          tyshxydm: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          zcjdxgcl: [
            { required: true, message: '作出决定的相关材料不能为空', trigger: 'blur' }
          ],
          wfajlx: [
            { required: true, message: '违法案件类型不能为空', trigger: 'blur' }
          ]
          /* xyhnDbTime: [
            { required: true, message: '更新时间戳不能为空', trigger: 'blur' }
          ] */
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
              url: this.$http.adornUrl(`/spider/cssfgwhbtsjzxgxxzcf/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwHbtSjzxGxXzcf.isinvalid
                this.dataForm.lastdate = data.csSfgwHbtSjzxGxXzcf.lastdate
                this.dataForm.xh = data.csSfgwHbtSjzxGxXzcf.xh
                this.dataForm.wrybh = data.csSfgwHbtSjzxGxXzcf.wrybh
                this.dataForm.wrymc = data.csSfgwHbtSjzxGxXzcf.wrymc
                this.dataForm.nd = data.csSfgwHbtSjzxGxXzcf.nd
                this.dataForm.cfzt = data.csSfgwHbtSjzxGxXzcf.cfzt
                this.dataForm.dcjg = data.csSfgwHbtSjzxGxXzcf.dcjg
                this.dataForm.lah = data.csSfgwHbtSjzxGxXzcf.lah
                this.dataForm.jdswh = data.csSfgwHbtSjzxGxXzcf.jdswh
                this.dataForm.larq = data.csSfgwHbtSjzxGxXzcf.larq
                this.dataForm.aqjj = data.csSfgwHbtSjzxGxXzcf.aqjj
                this.dataForm.zywfxw = data.csSfgwHbtSjzxGxXzcf.zywfxw
                this.dataForm.cfyj = data.csSfgwHbtSjzxGxXzcf.cfyj
                this.dataForm.cfzl = data.csSfgwHbtSjzxGxXzcf.cfzl
                this.dataForm.fkse = data.csSfgwHbtSjzxGxXzcf.fkse
                this.dataForm.xzmlzl = data.csSfgwHbtSjzxGxXzcf.xzmlzl
                this.dataForm.sfjxtz = data.csSfgwHbtSjzxGxXzcf.sfjxtz
                this.dataForm.jdxdrq = data.csSfgwHbtSjzxGxXzcf.jdxdrq
                this.dataForm.jdsnr = data.csSfgwHbtSjzxGxXzcf.jdsnr
                this.dataForm.zxqk = data.csSfgwHbtSjzxGxXzcf.zxqk
                this.dataForm.zxwbrq = data.csSfgwHbtSjzxGxXzcf.zxwbrq
                this.dataForm.fyjg = data.csSfgwHbtSjzxGxXzcf.fyjg
                this.dataForm.ssjg = data.csSfgwHbtSjzxGxXzcf.ssjg
                this.dataForm.ysxx = data.csSfgwHbtSjzxGxXzcf.ysxx
                this.dataForm.jarq = data.csSfgwHbtSjzxGxXzcf.jarq
                this.dataForm.sfja = data.csSfgwHbtSjzxGxXzcf.sfja
                this.dataForm.ajh = data.csSfgwHbtSjzxGxXzcf.ajh
                this.dataForm.bz = data.csSfgwHbtSjzxGxXzcf.bz
                this.dataForm.cjsj = data.csSfgwHbtSjzxGxXzcf.cjsj
                this.dataForm.xgsj = data.csSfgwHbtSjzxGxXzcf.xgsj
                this.dataForm.sjly = data.csSfgwHbtSjzxGxXzcf.sjly
                this.dataForm.zt = data.csSfgwHbtSjzxGxXzcf.zt
                this.dataForm.sfyjh = data.csSfgwHbtSjzxGxXzcf.sfyjh
                this.dataForm.shzt = data.csSfgwHbtSjzxGxXzcf.shzt
                this.dataForm.tyshxydm = data.csSfgwHbtSjzxGxXzcf.tyshxydm
                this.dataForm.zcjdxgcl = data.csSfgwHbtSjzxGxXzcf.zcjdxgcl
                this.dataForm.wfajlx = data.csSfgwHbtSjzxGxXzcf.wfajlx
                this.dataForm.xyhnDbTime = data.csSfgwHbtSjzxGxXzcf.xyhnDbTime
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
              url: this.$http.adornUrl(`/spider/cssfgwhbtsjzxgxxzcf/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'xh': this.dataForm.xh,
                'wrybh': this.dataForm.wrybh,
                'wrymc': this.dataForm.wrymc,
                'nd': this.dataForm.nd,
                'cfzt': this.dataForm.cfzt,
                'dcjg': this.dataForm.dcjg,
                'lah': this.dataForm.lah,
                'jdswh': this.dataForm.jdswh,
                'larq': this.dataForm.larq,
                'aqjj': this.dataForm.aqjj,
                'zywfxw': this.dataForm.zywfxw,
                'cfyj': this.dataForm.cfyj,
                'cfzl': this.dataForm.cfzl,
                'fkse': this.dataForm.fkse,
                'xzmlzl': this.dataForm.xzmlzl,
                'sfjxtz': this.dataForm.sfjxtz,
                'jdxdrq': this.dataForm.jdxdrq,
                'jdsnr': this.dataForm.jdsnr,
                'zxqk': this.dataForm.zxqk,
                'zxwbrq': this.dataForm.zxwbrq,
                'fyjg': this.dataForm.fyjg,
                'ssjg': this.dataForm.ssjg,
                'ysxx': this.dataForm.ysxx,
                'jarq': this.dataForm.jarq,
                'sfja': this.dataForm.sfja,
                'ajh': this.dataForm.ajh,
                'bz': this.dataForm.bz,
                'cjsj': this.dataForm.cjsj,
                'xgsj': this.dataForm.xgsj,
                'sjly': this.dataForm.sjly,
                'zt': this.dataForm.zt,
                'sfyjh': this.dataForm.sfyjh,
                'shzt': this.dataForm.shzt,
                'tyshxydm': this.dataForm.tyshxydm,
                'zcjdxgcl': this.dataForm.zcjdxgcl,
                'wfajlx': this.dataForm.wfajlx,
                'xyhnDbTime': this.dataForm.xyhnDbTime,
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
