<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!--
    <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    -->
    <el-form-item label="统一社会信用代码/纳税人识别号" prop="taxNo">
      <el-input v-model="dataForm.taxNo" placeholder="统一社会信用代码/纳税人识别号"></el-input>
    </el-form-item>
    <el-form-item label="纳税人名称" prop="taxper">
      <el-input v-model="dataForm.taxper" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人" prop="legalName">
      <el-input v-model="dataForm.legalName" placeholder="法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="主管税务机关" prop="authority">
      <el-input v-model="dataForm.authority" placeholder="主管税务机关"></el-input>
    </el-form-item>
    <el-form-item label="纳税人状态" prop="taxStatus">
      <el-input v-model="dataForm.taxStatus" placeholder="纳税人状态"></el-input>
    </el-form-item>
    <!--
    <el-form-item label="数据来源" prop="dataSource">
      <el-input v-model="dataForm.dataSource" placeholder="数据来源"></el-input>
    </el-form-item>
    -->
    <el-form-item label="数据状态：1-正常 0-删除" prop="dataState">
      <el-input v-model="dataForm.dataState" placeholder="数据状态：1-正常 0-删除"></el-input>
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
          enterpriseId: '',
          entName: '',
          taxNo: '',
          taxper: '',
          legalName: '',
          authority: '',
          taxStatus: '',
          dataSource: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          taxNo: [
            { required: true, message: '统一社会信用代码/纳税人识别号不能为空', trigger: 'blur' }
          ],
          taxper: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          legalName: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          authority: [
            { required: true, message: '主管税务机关不能为空', trigger: 'blur' }
          ],
          taxStatus: [
            { required: true, message: '纳税人状态不能为空', trigger: 'blur' }
          ],
          dataSource: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/hndstaxinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.hndsTaxInfo.enterpriseId
                this.dataForm.entName = data.hndsTaxInfo.entName
                this.dataForm.taxNo = data.hndsTaxInfo.taxNo
                this.dataForm.taxper = data.hndsTaxInfo.taxper
                this.dataForm.legalName = data.hndsTaxInfo.legalName
                this.dataForm.authority = data.hndsTaxInfo.authority
                this.dataForm.taxStatus = data.hndsTaxInfo.taxStatus
                this.dataForm.dataSource = data.hndsTaxInfo.dataSource
                this.dataForm.creator = data.hndsTaxInfo.creator
                this.dataForm.createTime = data.hndsTaxInfo.createTime
                this.dataForm.updater = data.hndsTaxInfo.updater
                this.dataForm.updateTime = data.hndsTaxInfo.updateTime
                this.dataForm.dataState = data.hndsTaxInfo.dataState
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
              url: this.$http.adornUrl(`/spider/hndstaxinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'taxNo': this.dataForm.taxNo,
                'taxper': this.dataForm.taxper,
                'legalName': this.dataForm.legalName,
                'authority': this.dataForm.authority,
                'taxStatus': this.dataForm.taxStatus,
                'dataSource': this.dataForm.dataSource,
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
