<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item>
    
    <el-form-item label="法定代表人姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="法定代表人姓名"></el-input>
    </el-form-item>
    <el-form-item label="企业(机构)名称" prop="entname">
      <el-input v-model="dataForm.entname" placeholder="企业(机构)名称"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="regno">
      <el-input v-model="dataForm.regno" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="企业(机构)类型" prop="enttype">
      <el-input v-model="dataForm.enttype" placeholder="企业(机构)类型"></el-input>
    </el-form-item>
    <el-form-item label="注册资本" prop="regcap">
      <el-input v-model="dataForm.regcap" placeholder="注册资本"></el-input>
    </el-form-item>
    <el-form-item label="注册资本币种" prop="regcapcur">
      <el-input v-model="dataForm.regcapcur" placeholder="注册资本币种"></el-input>
    </el-form-item>
    <el-form-item label="企业状态" prop="entstatus">
      <el-input v-model="dataForm.entstatus" placeholder="企业状态"></el-input>
    </el-form-item>
    <el-form-item label="注销日期" prop="candate">
      <el-input v-model="dataForm.candate" placeholder="注销日期"></el-input>
    </el-form-item>
    <el-form-item label="吊销日期" prop="revdate">
      <el-input v-model="dataForm.revdate" placeholder="吊销日期"></el-input>
    </el-form-item>
    <el-form-item label="登记机关" prop="regorg">
      <el-input v-model="dataForm.regorg" placeholder="登记机关"></el-input>
    </el-form-item>
    <el-form-item label="职务" prop="position">
      <el-input v-model="dataForm.position" placeholder="职务"></el-input>
    </el-form-item>
    <el-form-item label="是否法定代表人" prop="lerepsign">
      <el-input v-model="dataForm.lerepsign" placeholder="是否法定代表人"></el-input>
    </el-form-item>
    <el-form-item label="开业日期" prop="esdate">
      <el-input v-model="dataForm.esdate" placeholder="开业日期"></el-input>
    </el-form-item>
    
    
    
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
          memId: '',
          enterpriseId: '',
          name: '',
          entname: '',
          regno: '',
          enttype: '',
          regcap: '',
          regcapcur: '',
          entstatus: '',
          candate: '',
          revdate: '',
          regorg: '',
          position: '',
          lerepsign: '',
          esdate: '',
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
          name: [
            { required: true, message: '法定代表人姓名不能为空', trigger: 'blur' }
          ],
          entname: [
            { required: true, message: '企业(机构)名称不能为空', trigger: 'blur' }
          ],
          regno: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          enttype: [
            { required: true, message: '企业(机构)类型不能为空', trigger: 'blur' }
          ],
          regcap: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' }
          ],
          regcapcur: [
            { required: true, message: '注册资本币种不能为空', trigger: 'blur' }
          ],
          entstatus: [
            { required: true, message: '企业状态不能为空', trigger: 'blur' }
          ],
          candate: [
            { required: true, message: '注销日期不能为空', trigger: 'blur' }
          ],
          revdate: [
            { required: true, message: '吊销日期不能为空', trigger: 'blur' }
          ],
          regorg: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          position: [
            { required: true, message: '职务不能为空', trigger: 'blur' }
          ],
          lerepsign: [
            { required: true, message: '是否法定代表人不能为空', trigger: 'blur' }
          ],
          esdate: [
            { required: true, message: '开业日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptfrpositioninfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptFrpositionInfo.memId
                this.dataForm.enterpriseId = data.rptFrpositionInfo.enterpriseId
                this.dataForm.name = data.rptFrpositionInfo.name
                this.dataForm.entname = data.rptFrpositionInfo.entname
                this.dataForm.regno = data.rptFrpositionInfo.regno
                this.dataForm.enttype = data.rptFrpositionInfo.enttype
                this.dataForm.regcap = data.rptFrpositionInfo.regcap
                this.dataForm.regcapcur = data.rptFrpositionInfo.regcapcur
                this.dataForm.entstatus = data.rptFrpositionInfo.entstatus
                this.dataForm.candate = data.rptFrpositionInfo.candate
                this.dataForm.revdate = data.rptFrpositionInfo.revdate
                this.dataForm.regorg = data.rptFrpositionInfo.regorg
                this.dataForm.position = data.rptFrpositionInfo.position
                this.dataForm.lerepsign = data.rptFrpositionInfo.lerepsign
                this.dataForm.esdate = data.rptFrpositionInfo.esdate
                this.dataForm.creator = data.rptFrpositionInfo.creator
                this.dataForm.createTime = data.rptFrpositionInfo.createTime
                this.dataForm.updater = data.rptFrpositionInfo.updater
                this.dataForm.updateTime = data.rptFrpositionInfo.updateTime
                this.dataForm.dataState = data.rptFrpositionInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptfrpositioninfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'name': this.dataForm.name,
                'entname': this.dataForm.entname,
                'regno': this.dataForm.regno,
                'enttype': this.dataForm.enttype,
                'regcap': this.dataForm.regcap,
                'regcapcur': this.dataForm.regcapcur,
                'entstatus': this.dataForm.entstatus,
                'candate': this.dataForm.candate,
                'revdate': this.dataForm.revdate,
                'regorg': this.dataForm.regorg,
                'position': this.dataForm.position,
                'lerepsign': this.dataForm.lerepsign,
                'esdate': this.dataForm.esdate,
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
