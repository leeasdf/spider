<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    
    <el-form-item label="企业名称" prop="entname">
      <el-input v-model="dataForm.entname" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="regno">
      <el-input v-model="dataForm.regno" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="原注册号" prop="oriregno">
      <el-input v-model="dataForm.oriregno" placeholder="原注册号"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人姓名" prop="frname">
      <el-input v-model="dataForm.frname" placeholder="法定代表人姓名"></el-input>
    </el-form-item>
    <el-form-item label="" prop="regcap">
      <el-input v-model="dataForm.regcap" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reccap">
      <el-input v-model="dataForm.reccap" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="币种" prop="regcapcur">
      <el-input v-model="dataForm.regcapcur" placeholder="币种"></el-input>
    </el-form-item>
    <el-form-item label="经营状态" prop="entstatus">
      <el-input v-model="dataForm.entstatus" placeholder="经营状态"></el-input>
    </el-form-item>
    <el-form-item label="企业(机构)类型" prop="enttype">
      <el-input v-model="dataForm.enttype" placeholder="企业(机构)类型"></el-input>
    </el-form-item>
    <el-form-item label="开业日期" prop="esdate">
      <el-date-picker v-model="dataForm.esdate" value-format="yyyy-MM-dd" placeholder="开业日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="经营期限自" prop="opfrom">
      <el-date-picker v-model="dataForm.opfrom" value-format="yyyy-MM-dd" placeholder="经营期限自"></el-date-picker>
    </el-form-item>
    <el-form-item label="经营期限至" prop="opto">
      <el-date-picker v-model="dataForm.opto" value-format="yyyy-MM-dd" placeholder="经营期限至"></el-date-picker>
    </el-form-item>
    <el-form-item label="住址" prop="dom">
      <el-input v-model="dataForm.dom" placeholder="住址"></el-input>
    </el-form-item>
    <el-form-item label="登记机关" prop="regorg">
      <el-input v-model="dataForm.regorg" placeholder="登记机关"></el-input>
    </el-form-item>
    <el-form-item label="" prop="abuitem">
      <el-input type="textarea" :autosize="{ minRows:1, maxRows:4}" v-model="dataForm.abuitem" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cbuitem">
      <el-input type="textarea" :autosize="{ minRows:1, maxRows:4}"  v-model="dataForm.cbuitem" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="opscope">
      <el-input type="textarea" :autosize="{ minRows:1, maxRows:4}"  v-model="dataForm.opscope" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="opscoandform">
      <el-input type="textarea" :autosize="{ minRows:1, maxRows:4}"  v-model="dataForm.opscoandform" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="最后年检年度" prop="ancheyear">
      <el-date-picker type="year" v-model="dataForm.ancheyear" placeholder="最后年检年度"></el-date-picker>
    </el-form-item>
    <el-form-item label="变更日期" prop="changedate">
      <el-date-picker v-model="dataForm.changedate" value-format="yyyy-MM-dd" placeholder="变更日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="注销日期" prop="candate">
      <el-date-picker v-model="dataForm.candate" value-format="yyyy-MM-dd" placeholder="注销日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="吊销日期" prop="revdate">
      <el-date-picker v-model="dataForm.revdate" value-format="yyyy-MM-dd" placeholder="吊销日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="最后年检日期" prop="anchedate">
      <el-date-picker v-model="dataForm.anchedate" value-format="yyyy-MM-dd" placeholder="最后年检日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="行业门类代码" prop="industryphycode">
      <el-input v-model="dataForm.industryphycode" placeholder="行业门类代码"></el-input>
    </el-form-item>
    <el-form-item label="行业门类名称" prop="industryphyname">
      <el-input v-model="dataForm.industryphyname" placeholder="行业门类名称"></el-input>
    </el-form-item>
    <el-form-item label="国民经济行业代码" prop="industrycocode">
      <el-input v-model="dataForm.industrycocode" placeholder="国民经济行业代码"></el-input>
    </el-form-item>
    <el-form-item label="国民经济行业名称" prop="industryconame">
      <el-input v-model="dataForm.industryconame" placeholder="国民经济行业名称"></el-input>
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
          memId: '',
          enterpriseId: '',
          entname: '',
          regno: '',
          oriregno: '',
          frname: '',
          regcap: '',
          reccap: '',
          regcapcur: '',
          entstatus: '',
          enttype: '',
          esdate: '',
          opfrom: '',
          opto: '',
          dom: '',
          regorg: '',
          abuitem: '',
          cbuitem: '',
          opscope: '',
          opscoandform: '',
          ancheyear: '',
          changedate: '',
          candate: '',
          revdate: '',
          anchedate: '',
          industryphycode: '',
          industryphyname: '',
          industrycocode: '',
          industryconame: '',
          createTime: ''
        },
        dataRule: {
          /* memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ], */
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          entname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          regno: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          oriregno: [
            { required: true, message: '原注册号不能为空', trigger: 'blur' }
          ],
          frname: [
            { required: true, message: '法定代表人姓名不能为空', trigger: 'blur' }
          ],
          regcap: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reccap: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          regcapcur: [
            { required: true, message: '币种不能为空', trigger: 'blur' }
          ],
          entstatus: [
            { required: true, message: '经营状态不能为空', trigger: 'blur' }
          ],
          enttype: [
            { required: true, message: '企业(机构)类型不能为空', trigger: 'blur' }
          ],
          esdate: [
            { required: true, message: '开业日期不能为空', trigger: 'blur' }
          ],
          opfrom: [
            { required: true, message: '经营期限自不能为空', trigger: 'blur' }
          ],
          opto: [
            { required: true, message: '经营期限至不能为空', trigger: 'blur' }
          ],
          dom: [
            { required: true, message: '住址不能为空', trigger: 'blur' }
          ],
          regorg: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          abuitem: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cbuitem: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          opscope: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          opscoandform: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          ancheyear: [
            { required: true, message: '最后年检年度不能为空', trigger: 'blur' }
          ],
          changedate: [
            { required: true, message: '变更日期不能为空', trigger: 'blur' }
          ],
          candate: [
            { required: true, message: '注销日期不能为空', trigger: 'blur' }
          ],
          revdate: [
            { required: true, message: '吊销日期不能为空', trigger: 'blur' }
          ],
          anchedate: [
            { required: true, message: '最后年检日期不能为空', trigger: 'blur' }
          ],
          industryphycode: [
            { required: true, message: '行业门类代码不能为空', trigger: 'blur' }
          ],
          industryphyname: [
            { required: true, message: '行业门类名称不能为空', trigger: 'blur' }
          ],
          industrycocode: [
            { required: true, message: '国民经济行业代码不能为空', trigger: 'blur' }
          ],
          industryconame: [
            { required: true, message: '国民经济行业名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptbaseinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptBaseInfo.memId
                this.dataForm.enterpriseId = data.rptBaseInfo.enterpriseId
                this.dataForm.entname = data.rptBaseInfo.entname
                this.dataForm.regno = data.rptBaseInfo.regno
                this.dataForm.oriregno = data.rptBaseInfo.oriregno
                this.dataForm.frname = data.rptBaseInfo.frname
                this.dataForm.regcap = data.rptBaseInfo.regcap
                this.dataForm.reccap = data.rptBaseInfo.reccap
                this.dataForm.regcapcur = data.rptBaseInfo.regcapcur
                this.dataForm.entstatus = data.rptBaseInfo.entstatus
                this.dataForm.enttype = data.rptBaseInfo.enttype
                this.dataForm.esdate = data.rptBaseInfo.esdate
                this.dataForm.opfrom = data.rptBaseInfo.opfrom
                this.dataForm.opto = data.rptBaseInfo.opto
                this.dataForm.dom = data.rptBaseInfo.dom
                this.dataForm.regorg = data.rptBaseInfo.regorg
                this.dataForm.abuitem = data.rptBaseInfo.abuitem
                this.dataForm.cbuitem = data.rptBaseInfo.cbuitem
                this.dataForm.opscope = data.rptBaseInfo.opscope
                this.dataForm.opscoandform = data.rptBaseInfo.opscoandform
                this.dataForm.ancheyear = data.rptBaseInfo.ancheyear
                this.dataForm.changedate = data.rptBaseInfo.changedate
                this.dataForm.candate = data.rptBaseInfo.candate
                this.dataForm.revdate = data.rptBaseInfo.revdate
                this.dataForm.anchedate = data.rptBaseInfo.anchedate
                this.dataForm.industryphycode = data.rptBaseInfo.industryphycode
                this.dataForm.industryphyname = data.rptBaseInfo.industryphyname
                this.dataForm.industrycocode = data.rptBaseInfo.industrycocode
                this.dataForm.industryconame = data.rptBaseInfo.industryconame
                this.dataForm.createTime = data.rptBaseInfo.createTime
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
              url: this.$http.adornUrl(`/spider/rptbaseinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'entname': this.dataForm.entname,
                'regno': this.dataForm.regno,
                'oriregno': this.dataForm.oriregno,
                'frname': this.dataForm.frname,
                'regcap': this.dataForm.regcap,
                'reccap': this.dataForm.reccap,
                'regcapcur': this.dataForm.regcapcur,
                'entstatus': this.dataForm.entstatus,
                'enttype': this.dataForm.enttype,
                'esdate': this.dataForm.esdate,
                'opfrom': this.dataForm.opfrom,
                'opto': this.dataForm.opto,
                'dom': this.dataForm.dom,
                'regorg': this.dataForm.regorg,
                'abuitem': this.dataForm.abuitem,
                'cbuitem': this.dataForm.cbuitem,
                'opscope': this.dataForm.opscope,
                'opscoandform': this.dataForm.opscoandform,
                'ancheyear': this.dataForm.ancheyear,
                'changedate': this.dataForm.changedate,
                'candate': this.dataForm.candate,
                'revdate': this.dataForm.revdate,
                'anchedate': this.dataForm.anchedate,
                'industryphycode': this.dataForm.industryphycode,
                'industryphyname': this.dataForm.industryphyname,
                'industrycocode': this.dataForm.industrycocode,
                'industryconame': this.dataForm.industryconame,
                'createTime': this.dataForm.createTime
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
