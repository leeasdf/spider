<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="150px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    
    <el-form-item label="分支机构名称" prop="brname">
      <el-input v-model="dataForm.brname" placeholder="分支机构名称"></el-input>
    </el-form-item>
    <el-form-item label="分支机构企业注册号" prop="brregno">
      <el-input v-model="dataForm.brregno" placeholder="分支机构企业注册号"></el-input>
    </el-form-item>
    <el-form-item label="分支机构负责人" prop="brprincipal">
      <el-input v-model="dataForm.brprincipal" placeholder="分支机构负责人"></el-input>
    </el-form-item>
    <el-form-item label="一般经营项目" prop="cbuitem">
      <el-input v-model="dataForm.cbuitem" placeholder="一般经营项目"></el-input>
    </el-form-item>
    <el-form-item label="分支机构地址" prop="braddr">
      <el-input v-model="dataForm.braddr" placeholder="分支机构地址"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataState">
      <el-radio-group v-model="dataForm.dataState">
        <el-radio :label="1">正常</el-radio>
        <el-radio :label="0">删除</el-radio>
      </el-radio-group>
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
          brname: '',
          brregno: '',
          brprincipal: '',
          cbuitem: '',
          braddr: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          brname: [
            { required: true, message: '分支机构名称不能为空', trigger: 'blur' }
          ],
          brregno: [
            { required: true, message: '分支机构企业注册号不能为空', trigger: 'blur' }
          ],
          brprincipal: [
            { required: true, message: '分支机构负责人不能为空', trigger: 'blur' }
          ],
          cbuitem: [
            { required: true, message: '一般经营项目不能为空', trigger: 'blur' }
          ],
          braddr: [
            { required: true, message: '分支机构地址不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptfiliationinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptFiliationInfo.memId
                this.dataForm.enterpriseId = data.rptFiliationInfo.enterpriseId
                this.dataForm.brname = data.rptFiliationInfo.brname
                this.dataForm.brregno = data.rptFiliationInfo.brregno
                this.dataForm.brprincipal = data.rptFiliationInfo.brprincipal
                this.dataForm.cbuitem = data.rptFiliationInfo.cbuitem
                this.dataForm.braddr = data.rptFiliationInfo.braddr
                this.dataForm.creator = data.rptFiliationInfo.creator
                this.dataForm.createTime = data.rptFiliationInfo.createTime
                this.dataForm.updater = data.rptFiliationInfo.updater
                this.dataForm.updateTime = data.rptFiliationInfo.updateTime
                this.dataForm.dataState = data.rptFiliationInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptfiliationinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'brname': this.dataForm.brname,
                'brregno': this.dataForm.brregno,
                'brprincipal': this.dataForm.brprincipal,
                'cbuitem': this.dataForm.cbuitem,
                'braddr': this.dataForm.braddr,
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
