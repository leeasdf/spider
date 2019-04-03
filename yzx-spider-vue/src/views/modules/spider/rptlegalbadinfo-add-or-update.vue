<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
    <!-- <el-form-item label="会员ID" prop="memid">
      <el-input v-model="dataForm.memid" placeholder="会员ID"></el-input>
    </el-form-item> -->
    
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="身份证号码" prop="idcard">
      <el-input v-model="dataForm.idcard" placeholder="身份证号码"></el-input>
    </el-form-item>
    <el-form-item label="案发来源" prop="casesource">
      <el-input v-model="dataForm.casesource" placeholder="案发来源"></el-input>
    </el-form-item>
    <el-form-item label="案发时间" prop="casetime">
      <el-date-picker v-model="dataForm.casetime" value-format="yyyy-MM-dd" placeholder="案发时间"></el-date-picker>
    </el-form-item>
    <el-form-item label="案件类型" prop="casetype">
      <el-input v-model="dataForm.casetype" placeholder="案件类型"></el-input>
    </el-form-item>
    <el-form-item label="涉案类型" prop="crimetype">
      <el-input v-model="dataForm.crimetype" placeholder="涉案类型"></el-input>
    </el-form-item>
    
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isIDCard } from '@/utils/validate'
  export default {
    data () {
      const validateIDCard = function (rule, value, callback) {
        if (!isIDCard(value)) {
          callback(new Error('请输入正确的身份证格式，长度为15或18位'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          memid: '',
          enterpriseId: '',
          name: '',
          idcard: '',
          casesource: '',
          casetime: '',
          casetype: '',
          crimetype: '',
          createTime: ''
        },
        dataRule: {
          memid: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          idcard: [
            { required: true, message: '身份证号码不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          casesource: [
            { required: true, message: '案发来源不能为空', trigger: 'blur' }
          ],
          casetime: [
            { required: true, message: '案发时间不能为空', trigger: 'blur' }
          ],
          casetype: [
            { required: true, message: '案件类型不能为空', trigger: 'blur' }
          ],
          crimetype: [
            { required: true, message: '涉案类型不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptlegalbadinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memid = data.rptLegalbadInfo.memid
                this.dataForm.enterpriseId = data.rptLegalbadInfo.enterpriseId
                this.dataForm.name = data.rptLegalbadInfo.name
                this.dataForm.idcard = data.rptLegalbadInfo.idcard
                this.dataForm.casesource = data.rptLegalbadInfo.casesource
                this.dataForm.casetime = data.rptLegalbadInfo.casetime
                this.dataForm.casetype = data.rptLegalbadInfo.casetype
                this.dataForm.crimetype = data.rptLegalbadInfo.crimetype
                this.dataForm.createTime = data.rptLegalbadInfo.createTime
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
              url: this.$http.adornUrl(`/spider/rptlegalbadinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memid': this.dataForm.memid,
                'enterpriseId': this.dataForm.enterpriseId,
                'name': this.dataForm.name,
                'idcard': this.dataForm.idcard,
                'casesource': this.dataForm.casesource,
                'casetime': this.dataForm.casetime,
                'casetype': this.dataForm.casetype,
                'crimetype': this.dataForm.crimetype,
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
