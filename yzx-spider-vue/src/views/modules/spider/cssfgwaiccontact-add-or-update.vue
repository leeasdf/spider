<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
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
    <el-form-item label="工商内置唯一码" prop="etpsId">
      <el-input v-model="dataForm.etpsId" placeholder="工商内置唯一码"></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="证件类型" prop="certype">
      <el-input v-model="dataForm.certype" placeholder="证件类型"></el-input>
    </el-form-item>
    <el-form-item label="证件号码" prop="cerno">
      <el-input v-model="dataForm.cerno" placeholder="证件号码"></el-input>
    </el-form-item>
    <el-form-item label="固定电话" prop="fixedtel">
      <el-input v-model="dataForm.fixedtel" placeholder="固定电话"></el-input>
    </el-form-item>
    <el-form-item label="移动电话" prop="mobilephone">
      <el-input v-model="dataForm.mobilephone" placeholder="移动电话"></el-input>
    </el-form-item>
    <el-form-item label="电子邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="电子邮箱"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isEmail, isPhone, isMobile } from '@/utils/validate'
  export default {
    data () {
      const validatePhone = function (rule, value, callback) {
        if (!isPhone(value)) {
          callback(new Error('固定电话格式错误'))
        } else {
          callback()
        }
      }
      const validateMobile = function (rule, value, callback) {
        if (!isMobile(value)) {
          callback(new Error('移动电话格式错误'))
        } else {
          callback()
        }
      }
      const validateEmail = function (rule, value, callback) {
        if (!isEmail(value)) {
          callback(new Error('邮箱格式错误'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          isinvalid: '',
          lastdate: '',
          etpsId: '',
          name: '',
          certype: '',
          cerno: '',
          fixedtel: '',
          mobilephone: '',
          email: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          etpsId: [
            { required: true, message: '工商内置唯一码不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          certype: [
            { required: true, message: '证件类型不能为空', trigger: 'blur' }
          ],
          cerno: [
            { required: true, message: '证件号码不能为空', trigger: 'blur' }
          ],
          fixedtel: [
            { required: true, message: '固定电话不能为空', trigger: 'blur' },
            { validator: validatePhone, trigger: 'blur' }
          ],
          mobilephone: [
            { required: true, message: '移动电话不能为空', trigger: 'blur' },
            { validator: validateMobile, trigger: 'blur' }
          ],
          email: [
            { required: true, message: '电子邮箱不能为空', trigger: 'blur' },
            { validator: validateEmail, trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwaiccontact/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwAicContact.isinvalid
                this.dataForm.lastdate = data.csSfgwAicContact.lastdate
                this.dataForm.etpsId = data.csSfgwAicContact.etpsId
                this.dataForm.name = data.csSfgwAicContact.name
                this.dataForm.certype = data.csSfgwAicContact.certype
                this.dataForm.cerno = data.csSfgwAicContact.cerno
                this.dataForm.fixedtel = data.csSfgwAicContact.fixedtel
                this.dataForm.mobilephone = data.csSfgwAicContact.mobilephone
                this.dataForm.email = data.csSfgwAicContact.email
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
              url: this.$http.adornUrl(`/spider/cssfgwaiccontact/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'etpsId': this.dataForm.etpsId,
                'name': this.dataForm.name,
                'certype': this.dataForm.certype,
                'cerno': this.dataForm.cerno,
                'fixedtel': this.dataForm.fixedtel,
                'mobilephone': this.dataForm.mobilephone,
                'email': this.dataForm.email,
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
