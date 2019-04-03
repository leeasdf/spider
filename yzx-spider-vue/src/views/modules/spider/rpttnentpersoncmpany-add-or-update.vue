<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="姓名" prop="personname">
          <el-input v-model="dataForm.personname" placeholder="姓名"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="角色" prop="role">
          <el-input v-model="dataForm.role" placeholder="角色"></el-input>
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
          <el-date-picker type="date" v-model="dataForm.opendate" placeholder="开业日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="注册资本" prop="regcap">
          <el-input v-model="dataForm.regcap" placeholder="注册资本"></el-input>
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
          personid: '',
          personname: '',
          role: '',
          province: '',
          cmpname: '',
          opendate: '',
          status: '',
          regcap: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          personid: [
            { required: true, message: '个人ID不能为空', trigger: 'blur' }
          ],
          personname: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
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
          regcap: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnentpersoncmpany/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.personid = data.rptTnEntPersonCmpany.personid
                this.dataForm.personname = data.rptTnEntPersonCmpany.personname
                this.dataForm.role = data.rptTnEntPersonCmpany.role
                this.dataForm.province = data.rptTnEntPersonCmpany.province
                this.dataForm.cmpname = data.rptTnEntPersonCmpany.cmpname
                this.dataForm.opendate = data.rptTnEntPersonCmpany.opendate
                this.dataForm.status = data.rptTnEntPersonCmpany.status
                this.dataForm.regcap = data.rptTnEntPersonCmpany.regcap
                this.dataForm.creator = data.rptTnEntPersonCmpany.creator
                this.dataForm.createTime = data.rptTnEntPersonCmpany.createTime
                this.dataForm.updater = data.rptTnEntPersonCmpany.updater
                this.dataForm.updateTime = data.rptTnEntPersonCmpany.updateTime
                this.dataForm.dataState = data.rptTnEntPersonCmpany.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnentpersoncmpany/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'personid': this.dataForm.personid,
                'personname': this.dataForm.personname,
                'role': this.dataForm.role,
                'province': this.dataForm.province,
                'cmpname': this.dataForm.cmpname,
                'opendate': this.dataForm.opendate,
                'status': this.dataForm.status,
                'regcap': this.dataForm.regcap,
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
