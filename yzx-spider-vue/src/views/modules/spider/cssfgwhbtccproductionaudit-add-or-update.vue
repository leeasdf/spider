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
   <!--  <el-form-item label="数据最后修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item> -->
    <el-form-item label="企业名称" prop="corporationname">
      <el-input v-model="dataForm.corporationname" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="组织机构代码" prop="organizationcode">
      <el-input v-model="dataForm.organizationcode" placeholder="组织机构代码"></el-input>
    </el-form-item>
    <el-form-item label="注册所在地" prop="placeofregistration">
      <el-input v-model="dataForm.placeofregistration" placeholder="注册所在地"></el-input>
    </el-form-item>
    <el-form-item label="企业性质" prop="nature">
      <el-input v-model="dataForm.nature" placeholder="企业性质"></el-input>
    </el-form-item>
    <el-form-item label="所属行业" prop="industry">
      <el-input v-model="dataForm.industry" placeholder="所属行业"></el-input>
    </el-form-item>
    <el-form-item label="名单发布机关" prop="releasemechanism">
      <el-input v-model="dataForm.releasemechanism" placeholder="名单发布机关"></el-input>
    </el-form-item>
    <el-form-item label="名单发布日期" prop="releasedate">
      <!-- <el-input v-model="dataForm.releasedate" placeholder="名单发布日期"></el-input> -->
      <el-date-picker v-model="dataForm.releasedate" placeholder="名单发布日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="文号" prop="documentnumber">
      <el-input v-model="dataForm.documentnumber" placeholder="文号"></el-input>
    </el-form-item>
    <el-form-item label="强制执行时限" prop="executiontimelimit">
      <el-input v-model="dataForm.executiontimelimit" placeholder="强制执行时限"></el-input>
    </el-form-item>
    <el-form-item label="提交审核报告时间" prop="auditdate">
      <el-input v-model="dataForm.auditdate" placeholder="提交审核报告时间"></el-input>
    </el-form-item>
    <el-form-item label="完成验收时间" prop="completedacceptancetime">
      <el-input v-model="dataForm.completedacceptancetime" placeholder="完成验收时间"></el-input>
    </el-form-item>
    <el-form-item label="完成评估时间" prop="finishtime">
      <el-input v-model="dataForm.finishtime" placeholder="完成评估时间"></el-input>
    </el-form-item>
    <el-form-item label="审核机构名称" prop="auditorganizationname">
      <el-input v-model="dataForm.auditorganizationname" placeholder="审核机构名称"></el-input>
    </el-form-item>
    <el-form-item label="验收证明材料" prop="acceptanceproofmaterial">
      <el-input v-model="dataForm.acceptanceproofmaterial" placeholder="验收证明材料"></el-input>
    </el-form-item>
    <el-form-item label="最近一轮清洁生产审核时段" prop="productionaudit">
      <el-input v-model="dataForm.productionaudit" placeholder="最近一轮清洁生产审核时段"></el-input>
    </el-form-item>
    <el-form-item label="上轮清洁生产验收时间" prop="praccetime">
      <!-- <el-input v-model="dataForm.praccetime" placeholder="上轮清洁生产验收时间"></el-input> -->
      <el-date-picker v-model="dataForm.praccetime" placeholder="上轮清洁生产验收时间" value-format="yyyy-MM-dd"></el-date-picker>
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
          corporationname: '',
          organizationcode: '',
          placeofregistration: '',
          nature: '',
          industry: '',
          releasemechanism: '',
          releasedate: '',
          documentnumber: '',
          executiontimelimit: '',
          auditdate: '',
          completedacceptancetime: '',
          finishtime: '',
          auditorganizationname: '',
          acceptanceproofmaterial: '',
          productionaudit: '',
          praccetime: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          /* lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ], */
          corporationname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          organizationcode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          placeofregistration: [
            { required: true, message: '注册所在地不能为空', trigger: 'blur' }
          ],
          nature: [
            { required: true, message: '企业性质不能为空', trigger: 'blur' }
          ],
          industry: [
            { required: true, message: '所属行业不能为空', trigger: 'blur' }
          ],
          releasemechanism: [
            { required: true, message: '名单发布机关不能为空', trigger: 'blur' }
          ],
          releasedate: [
            { required: true, message: '名单发布日期不能为空', trigger: 'blur' }
          ],
          documentnumber: [
            { required: true, message: '文号不能为空', trigger: 'blur' }
          ],
          executiontimelimit: [
            { required: true, message: '强制执行时限不能为空', trigger: 'blur' }
          ],
          auditdate: [
            { required: true, message: '提交审核报告时间不能为空', trigger: 'blur' }
          ],
          completedacceptancetime: [
            { required: true, message: '完成验收时间不能为空', trigger: 'blur' }
          ],
          finishtime: [
            { required: true, message: '完成评估时间不能为空', trigger: 'blur' }
          ],
          auditorganizationname: [
            { required: true, message: '审核机构名称不能为空', trigger: 'blur' }
          ],
          acceptanceproofmaterial: [
            { required: true, message: '验收证明材料不能为空', trigger: 'blur' }
          ],
          productionaudit: [
            { required: true, message: '最近一轮清洁生产审核时段不能为空', trigger: 'blur' }
          ],
          praccetime: [
            { required: true, message: '上轮清洁生产验收时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwhbtccproductionaudit/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwHbtCcproductionaudit.isinvalid
                this.dataForm.lastdate = data.csSfgwHbtCcproductionaudit.lastdate
                this.dataForm.corporationname = data.csSfgwHbtCcproductionaudit.corporationname
                this.dataForm.organizationcode = data.csSfgwHbtCcproductionaudit.organizationcode
                this.dataForm.placeofregistration = data.csSfgwHbtCcproductionaudit.placeofregistration
                this.dataForm.nature = data.csSfgwHbtCcproductionaudit.nature
                this.dataForm.industry = data.csSfgwHbtCcproductionaudit.industry
                this.dataForm.releasemechanism = data.csSfgwHbtCcproductionaudit.releasemechanism
                this.dataForm.releasedate = data.csSfgwHbtCcproductionaudit.releasedate
                this.dataForm.documentnumber = data.csSfgwHbtCcproductionaudit.documentnumber
                this.dataForm.executiontimelimit = data.csSfgwHbtCcproductionaudit.executiontimelimit
                this.dataForm.auditdate = data.csSfgwHbtCcproductionaudit.auditdate
                this.dataForm.completedacceptancetime = data.csSfgwHbtCcproductionaudit.completedacceptancetime
                this.dataForm.finishtime = data.csSfgwHbtCcproductionaudit.finishtime
                this.dataForm.auditorganizationname = data.csSfgwHbtCcproductionaudit.auditorganizationname
                this.dataForm.acceptanceproofmaterial = data.csSfgwHbtCcproductionaudit.acceptanceproofmaterial
                this.dataForm.productionaudit = data.csSfgwHbtCcproductionaudit.productionaudit
                this.dataForm.praccetime = data.csSfgwHbtCcproductionaudit.praccetime
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
              url: this.$http.adornUrl(`/spider/cssfgwhbtccproductionaudit/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'corporationname': this.dataForm.corporationname,
                'organizationcode': this.dataForm.organizationcode,
                'placeofregistration': this.dataForm.placeofregistration,
                'nature': this.dataForm.nature,
                'industry': this.dataForm.industry,
                'releasemechanism': this.dataForm.releasemechanism,
                'releasedate': this.dataForm.releasedate,
                'documentnumber': this.dataForm.documentnumber,
                'executiontimelimit': this.dataForm.executiontimelimit,
                'auditdate': this.dataForm.auditdate,
                'completedacceptancetime': this.dataForm.completedacceptancetime,
                'finishtime': this.dataForm.finishtime,
                'auditorganizationname': this.dataForm.auditorganizationname,
                'acceptanceproofmaterial': this.dataForm.acceptanceproofmaterial,
                'productionaudit': this.dataForm.productionaudit,
                'praccetime': this.dataForm.praccetime,
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
