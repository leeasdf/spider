<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entname">
            <el-input v-model="dataForm.entname" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册资本" prop="capital">
            <el-input v-model="dataForm.capital" placeholder="注册资本"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="角色" prop="role">
            <el-input v-model="dataForm.role" placeholder="角色"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="省份地址" prop="province">
            <el-input v-model="dataForm.province" placeholder="省份地址"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="公司名" prop="cmpname">
            <el-input v-model="dataForm.cmpname" placeholder="公司名"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="开业日期" prop="opendate">
            <el-date-picker v-model="dataForm.opendate" value-format="yyyy-MM-dd" placeholder="开业日期"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="经营状态" prop="status">
            <el-input v-model="dataForm.status" placeholder="经营状态"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数据状态" prop="dataState">
            <el-radio-group v-model="dataForm.dataState">
              <el-radio :label="1">正常</el-radio>
              <el-radio :label="0">删除</el-radio>
            </el-radio-group>
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
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          entname: '',
          capital: '',
          role: '',
          province: '',
          cmpname: '',
          opendate: '',
          status: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          entname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          capital: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' }
          ],
          role: [
            { required: true, message: '角色不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '省份地址不能为空', trigger: 'blur' }
          ],
          cmpname: [
            { required: true, message: '公司名不能为空', trigger: 'blur' }
          ],
          opendate: [
            { required: true, message: '开业日期不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '经营状态不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
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
              url: this.$http.adornUrl(`/spider/rpttnbusrole/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.entname = data.rptTnBusrole.entname
                this.dataForm.capital = data.rptTnBusrole.capital
                this.dataForm.role = data.rptTnBusrole.role
                this.dataForm.province = data.rptTnBusrole.province
                this.dataForm.cmpname = data.rptTnBusrole.cmpname
                this.dataForm.opendate = data.rptTnBusrole.opendate
                this.dataForm.status = data.rptTnBusrole.status
                this.dataForm.creator = data.rptTnBusrole.creator
                this.dataForm.createTime = data.rptTnBusrole.createTime
                this.dataForm.updater = data.rptTnBusrole.updater
                this.dataForm.updateTime = data.rptTnBusrole.updateTime
                this.dataForm.dataState = data.rptTnBusrole.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnbusrole/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'entname': this.dataForm.entname,
                'capital': this.dataForm.capital,
                'role': this.dataForm.role,
                'province': this.dataForm.province,
                'cmpname': this.dataForm.cmpname,
                'opendate': this.dataForm.opendate,
                'status': this.dataForm.status,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState
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
