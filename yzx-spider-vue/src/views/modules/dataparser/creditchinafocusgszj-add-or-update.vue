<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="enterpriseName">
            <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="法定代表人" prop="legal">
            <el-input v-model="dataForm.legal" placeholder="法定代表人"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="注册号" prop="regNo">
            <el-input v-model="dataForm.regNo" placeholder="注册号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="设立日期" prop="establishDate">
            <el-date-picker v-model="dataForm.establishDate" placeholder="设立日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
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
    <el-form-item label="决定机关名称" prop="decisionOrgan">
      <el-input v-model="dataForm.decisionOrgan" placeholder="列入决定机关名称"></el-input>
    </el-form-item>
    <el-form-item label="列入原因类型" prop="reason">
      <el-input type="textarea" v-model="dataForm.reason" placeholder="列入经营异常名录原因类型名称"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    
    
    <!-- <el-form-item label="最新更新日期" prop="lastUpdateTime">
      <el-input v-model="dataForm.lastUpdateTime" placeholder="最新更新日期"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    
   <!-- <el-form-item label="数据状态" prop="dataStatus">
      <el-input v-model="dataForm.dataStatus" placeholder="数据状态"></el-input>
    </el-form-item>-->
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
          regNo: '',
          legal: '',
          reason: '',
          enterpriseName: '',
          establishDate: '',
          decisionOrgan: '',
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
          regNo: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          legal: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '列入经营异常名录原因类型名称不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          establishDate: [
            { required: true, message: '设立日期不能为空', trigger: 'blur' }
          ],
          decisionOrgan: [
            { required: true, message: '列入决定机关名称不能为空', trigger: 'blur' }
          ]
          /*
          ,lastUpdateTime: [
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
              url: this.$http.adornUrl(`/dataparser/creditchinafocusgszj/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.type = data.creditchinaFocusGszj.type
                this.dataForm.source = data.creditchinaFocusGszj.source
                this.dataForm.regNo = data.creditchinaFocusGszj.regNo
                this.dataForm.legal = data.creditchinaFocusGszj.legal
                this.dataForm.reason = data.creditchinaFocusGszj.reason
                this.dataForm.enterpriseName = data.creditchinaFocusGszj.enterpriseName
                this.dataForm.establishDate = data.creditchinaFocusGszj.establishDate
                this.dataForm.decisionOrgan = data.creditchinaFocusGszj.decisionOrgan
                this.dataForm.lastUpdateTime = data.creditchinaFocusGszj.lastUpdateTime
                this.dataForm.createTime = data.creditchinaFocusGszj.createTime
                this.dataForm.updateTime = data.creditchinaFocusGszj.updateTime
                this.dataForm.remark = data.creditchinaFocusGszj.remark
                this.dataForm.dataStatus = data.creditchinaFocusGszj.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/creditchinafocusgszj/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'type': this.dataForm.type,
                'source': this.dataForm.source,
                'regNo': this.dataForm.regNo,
                'legal': this.dataForm.legal,
                'reason': this.dataForm.reason,
                'enterpriseName': this.dataForm.enterpriseName,
                'establishDate': this.dataForm.establishDate,
                'decisionOrgan': this.dataForm.decisionOrgan,
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
