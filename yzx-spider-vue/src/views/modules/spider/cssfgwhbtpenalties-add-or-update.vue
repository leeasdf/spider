<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
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
    <el-form-item label="所属地区" prop="reginname">
      <el-input v-model="dataForm.reginname" placeholder="所属地区"></el-input>
    </el-form-item>
    <el-form-item label="执法部门" prop="executionpunishment">
      <el-input v-model="dataForm.executionpunishment" placeholder="执法部门"></el-input>
    </el-form-item>
    <el-form-item label="处罚书文号" prop="penaltyid">
      <el-input v-model="dataForm.penaltyid" placeholder="处罚书文号"></el-input>
    </el-form-item>
    <el-form-item label="被处罚单位及法人姓名" prop="corporationname">
      <el-input v-model="dataForm.corporationname" placeholder="被处罚单位及法人姓名"></el-input>
    </el-form-item>
    <el-form-item label="处罚日期" prop="dateofpunishment">
      <!-- <el-input v-model="dataForm.dateofpunishment" placeholder="处罚日期"></el-input> -->
      <el-date-picker v-model="dataForm.dateofpunishment" placeholder="处罚日期" value-format="yyyy-MM-dd"></el-date-picker>
    </el-form-item>
    <el-form-item label="处罚类别" prop="cfTypr">
      <el-input v-model="dataForm.cfTypr" placeholder="处罚类别"></el-input>
    </el-form-item>
    <el-form-item label="处罚事由" prop="illegalfacts">
      <el-input type="textarea" v-model="dataForm.illegalfacts" placeholder="处罚事由"></el-input>
    </el-form-item>
    <el-form-item label="整改情况" prop="rectification">
      <el-input v-model="dataForm.rectification" placeholder="整改情况"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
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
          reginname: '',
          executionpunishment: '',
          penaltyid: '',
          corporationname: '',
          dateofpunishment: '',
          cfTypr: '',
          illegalfacts: '',
          rectification: '',
          remarks: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          /* lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ], */
          reginname: [
            { required: true, message: '所属地区不能为空', trigger: 'blur' }
          ],
          executionpunishment: [
            { required: true, message: '执法部门不能为空', trigger: 'blur' }
          ],
          penaltyid: [
            { required: true, message: '处罚书文号不能为空', trigger: 'blur' }
          ],
          corporationname: [
            { required: true, message: '被处罚单位及法人姓名不能为空', trigger: 'blur' }
          ],
          dateofpunishment: [
            { required: true, message: '处罚日期不能为空', trigger: 'blur' }
          ],
          cfTypr: [
            { required: true, message: '处罚类别不能为空', trigger: 'blur' }
          ],
          illegalfacts: [
            { required: true, message: '处罚事由不能为空', trigger: 'blur' }
          ],
          rectification: [
            { required: true, message: '整改情况不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwhbtpenalties/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwHbtPenalties.isinvalid
                this.dataForm.lastdate = data.csSfgwHbtPenalties.lastdate
                this.dataForm.reginname = data.csSfgwHbtPenalties.reginname
                this.dataForm.executionpunishment = data.csSfgwHbtPenalties.executionpunishment
                this.dataForm.penaltyid = data.csSfgwHbtPenalties.penaltyid
                this.dataForm.corporationname = data.csSfgwHbtPenalties.corporationname
                this.dataForm.dateofpunishment = data.csSfgwHbtPenalties.dateofpunishment
                this.dataForm.cfTypr = data.csSfgwHbtPenalties.cfTypr
                this.dataForm.illegalfacts = data.csSfgwHbtPenalties.illegalfacts
                this.dataForm.rectification = data.csSfgwHbtPenalties.rectification
                this.dataForm.remarks = data.csSfgwHbtPenalties.remarks
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
              url: this.$http.adornUrl(`/spider/cssfgwhbtpenalties/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'reginname': this.dataForm.reginname,
                'executionpunishment': this.dataForm.executionpunishment,
                'penaltyid': this.dataForm.penaltyid,
                'corporationname': this.dataForm.corporationname,
                'dateofpunishment': this.dataForm.dateofpunishment,
                'cfTypr': this.dataForm.cfTypr,
                'illegalfacts': this.dataForm.illegalfacts,
                'rectification': this.dataForm.rectification,
                'remarks': this.dataForm.remarks,
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
