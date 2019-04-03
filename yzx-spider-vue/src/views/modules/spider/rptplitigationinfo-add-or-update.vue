<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="裁判文书数量" prop="cpwsCount">
          <el-input-number v-model="dataForm.cpwsCount"  label="裁判文书数量"></el-input-number>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="开庭公告数量" prop="ktggCount">
          <el-input-number v-model="dataForm.ktggCount" placeholder="开庭公告数量"></el-input-number>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="执行公告数量" prop="zxggCount">
          <el-input-number v-model="dataForm.zxggCount" placeholder="执行公告数量"></el-input-number>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="失信公告数量" prop="sxggCount">
          <el-input-number v-model="dataForm.sxggCount" placeholder="失信公告数量"></el-input-number>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="网贷黑名单数量" prop="wdhmdCount">
          <el-input-number v-model="dataForm.wdhmdCount" placeholder="网贷黑名单数量"></el-input-number>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="案件流程数量" prop="ajlcCount">
          <el-input-number v-model="dataForm.ajlcCount" placeholder="案件流程数量"></el-input-number>
        </el-form-item>
      </el-col>
    </el-row>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isNumber } from '@/utils/validate'
  export default {
    data () {
      const validateNumber = function (rule, value, callback) {
        if (!isNumber(value)) {
          callback(new Error('请输入整数'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          memId: '',
          enterpriseId: '',
          cpwsCount: '',
          ktggCount: '',
          zxggCount: '',
          sxggCount: '',
          wdhmdCount: '',
          ajlcCount: ''
        },
        dataRule: {
         /* memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ], */
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          cpwsCount: [
            { required: true, message: '裁判文书数量不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          ktggCount: [
            { required: true, message: '开庭公告数量不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          zxggCount: [
            { required: true, message: '执行公告数量不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          sxggCount: [
            { required: true, message: '失信公告数量不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          wdhmdCount: [
            { required: true, message: '网贷黑名单数量不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
          ],
          ajlcCount: [
            { required: true, message: '案件流程数量不能为空', trigger: 'blur' },
            { validator: validateNumber, trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptplitigationinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptPlitigationInfo.memId
                this.dataForm.enterpriseId = data.rptPlitigationInfo.enterpriseId
                this.dataForm.cpwsCount = data.rptPlitigationInfo.cpwsCount
                this.dataForm.ktggCount = data.rptPlitigationInfo.ktggCount
                this.dataForm.zxggCount = data.rptPlitigationInfo.zxggCount
                this.dataForm.sxggCount = data.rptPlitigationInfo.sxggCount
                this.dataForm.wdhmdCount = data.rptPlitigationInfo.wdhmdCount
                this.dataForm.ajlcCount = data.rptPlitigationInfo.ajlcCount
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
              url: this.$http.adornUrl(`/spider/rptplitigationinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'cpwsCount': this.dataForm.cpwsCount,
                'ktggCount': this.dataForm.ktggCount,
                'zxggCount': this.dataForm.zxggCount,
                'sxggCount': this.dataForm.sxggCount,
                'wdhmdCount': this.dataForm.wdhmdCount,
                'ajlcCount': this.dataForm.ajlcCount
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
