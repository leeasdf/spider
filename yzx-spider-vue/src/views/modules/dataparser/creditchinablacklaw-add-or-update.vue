<template>
  <el-dialog
    width="860px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="失信被执行人名称" prop="dishonestName">
            <el-input v-model="dataForm.dishonestName" placeholder="失信被执行人名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="企业法人姓名" prop="enterpriseLegal">
            <el-input v-model="dataForm.enterpriseLegal" placeholder="企业法人姓名"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="案号" prop="caseNo">
            <el-input v-model="dataForm.caseNo" placeholder="案号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="执行法院" prop="court">
            <el-input v-model="dataForm.court" placeholder="执行法院"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="执行依据文号" prop="basisNumber">
            <el-input v-model="dataForm.basisNumber" placeholder="执行依据文号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="作出执行依据单位" prop="executionBasis">
            <el-input v-model="dataForm.executionBasis" placeholder="作出执行依据单位"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="数据类别" prop="type">
            <el-input v-model="dataForm.type" placeholder="数据类别"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数据来源" prop="source">
            <el-input v-model="dataForm.source" placeholder="数据来源"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="发布时间" prop="published">
            <el-date-picker v-model="dataForm.published" placeholder="发布时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="立案时间" prop="filingTime">
            <el-date-picker v-model="dataForm.filingTime" placeholder="立案时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="地域名称" prop="area">
            <el-input v-model="dataForm.area" placeholder="地域名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="最新更新日期" prop="lastUpdateTime">
            <el-date-picker v-model="dataForm.lastUpdateTime" placeholder="最新更新日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="法律生效文书确定的义务" prop="lawDuty">
        <el-input v-model="dataForm.lawDuty" type="textarea" placeholder="法律生效文书确定的义务"></el-input>
      </el-form-item>
      <el-form-item label="被执行人的履行情况" prop="performance">
        <el-input v-model="dataForm.performance" type="textarea" placeholder="被执行人的履行情况"></el-input>
      </el-form-item>
      <el-form-item label="失信被执行人具体情形" prop="situation">
        <el-input v-model="dataForm.situation" type="textarea" placeholder="失信被执行人具体情形"></el-input>
      </el-form-item>
      <el-form-item label="已履行部分" prop="fulfilledPart">
        <el-input v-model="dataForm.fulfilledPart" type="textarea" placeholder="已履行部分"></el-input>
      </el-form-item>
      <el-form-item label="未履行部分" prop="unfulfilledPart">
        <el-input v-model="dataForm.unfulfilledPart" type="textarea" placeholder="未履行部分"></el-input>
      </el-form-item>
     
      <!--
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
      <!--
    <el-form-item label="数据状态" prop="dataStatus">
      <el-input v-model="dataForm.dataStatus" placeholder="数据状态"></el-input>
    </el-form-item>
    -->
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
          type: '',
          source: '',
          caseNo: '',
          dishonestName: '',
          enterpriseLegal: '',
          court: '',
          area: '',
          basisNumber: '',
          executionBasis: '',
          lawDuty: '',
          performance: '',
          situation: '',
          published: '',
          filingTime: '',
          fulfilledPart: '',
          unfulfilledPart: '',
          lastUpdateTime: '',
          createTime: '',
          updateTime: '',
          remark: '',
          dataStatus: ''
        },
        dataRule: {
          type: [
            { required: true, message: '数据类别不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '案号不能为空', trigger: 'blur' }
          ],
          dishonestName: [
            { required: true, message: '失信被执行人名称不能为空', trigger: 'blur' }
          ],
          enterpriseLegal: [
            { required: true, message: '企业法人姓名不能为空', trigger: 'blur' }
          ],
          court: [
            { required: true, message: '执行法院不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '地域名称不能为空', trigger: 'blur' }
          ],
          basisNumber: [
            { required: true, message: '执行依据文号不能为空', trigger: 'blur' }
          ],
          executionBasis: [
            { required: true, message: '作出执行依据单位不能为空', trigger: 'blur' }
          ],
          lawDuty: [
            { required: true, message: '法律生效文书确定的义务不能为空', trigger: 'blur' }
          ],
          performance: [
            { required: true, message: '被执行人的履行情况不能为空', trigger: 'blur' }
          ],
          situation: [
            { required: true, message: '失信被执行人具体情形不能为空', trigger: 'blur' }
          ],
          published: [
            { required: true, message: '发布时间不能为空', trigger: 'blur' }
          ],
          filingTime: [
            { required: true, message: '立案时间不能为空', trigger: 'blur' }
          ],
          fulfilledPart: [
            { required: true, message: '已履行部分不能为空', trigger: 'blur' }
          ],
          unfulfilledPart: [
            { required: true, message: '未履行部分不能为空', trigger: 'blur' }
          ]
          /*
          ,
          lastUpdateTime: [
            { required: true, message: '最新更新日期不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          dataStatus: [
            { required: true, message: '数据状态不能为空', trigger: 'blur' }
          ]
          */
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
              url: this.$http.adornUrl(`/dataparser/creditchinablacklaw/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.type = data.creditchinaBlackLaw.type
                this.dataForm.source = data.creditchinaBlackLaw.source
                this.dataForm.caseNo = data.creditchinaBlackLaw.caseNo
                this.dataForm.dishonestName = data.creditchinaBlackLaw.dishonestName
                this.dataForm.enterpriseLegal = data.creditchinaBlackLaw.enterpriseLegal
                this.dataForm.court = data.creditchinaBlackLaw.court
                this.dataForm.area = data.creditchinaBlackLaw.area
                this.dataForm.basisNumber = data.creditchinaBlackLaw.basisNumber
                this.dataForm.executionBasis = data.creditchinaBlackLaw.executionBasis
                this.dataForm.lawDuty = data.creditchinaBlackLaw.lawDuty
                this.dataForm.performance = data.creditchinaBlackLaw.performance
                this.dataForm.situation = data.creditchinaBlackLaw.situation
                this.dataForm.published = data.creditchinaBlackLaw.published
                this.dataForm.filingTime = data.creditchinaBlackLaw.filingTime
                this.dataForm.fulfilledPart = data.creditchinaBlackLaw.fulfilledPart
                this.dataForm.unfulfilledPart = data.creditchinaBlackLaw.unfulfilledPart
                this.dataForm.lastUpdateTime = data.creditchinaBlackLaw.lastUpdateTime
                this.dataForm.createTime = data.creditchinaBlackLaw.createTime
                this.dataForm.updateTime = data.creditchinaBlackLaw.updateTime
                this.dataForm.remark = data.creditchinaBlackLaw.remark
                this.dataForm.dataStatus = data.creditchinaBlackLaw.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/creditchinablacklaw/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'type': this.dataForm.type,
                'source': this.dataForm.source,
                'caseNo': this.dataForm.caseNo,
                'dishonestName': this.dataForm.dishonestName,
                'enterpriseLegal': this.dataForm.enterpriseLegal,
                'court': this.dataForm.court,
                'area': this.dataForm.area,
                'basisNumber': this.dataForm.basisNumber,
                'executionBasis': this.dataForm.executionBasis,
                'lawDuty': this.dataForm.lawDuty,
                'performance': this.dataForm.performance,
                'situation': this.dataForm.situation,
                'published': this.dataForm.published,
                'filingTime': this.dataForm.filingTime,
                'fulfilledPart': this.dataForm.fulfilledPart,
                'unfulfilledPart': this.dataForm.unfulfilledPart,
                'lastUpdateTime': this.dataForm.lastUpdateTime,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'remark': this.dataForm.remark,
                'dataStatus': this.dataForm.dataStatus
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
