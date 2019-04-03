<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
    <!-- <el-form-item label="会员id" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员id"></el-input>
    </el-form-item>
    <el-form-item label="公开ID" prop="publicId">
      <el-input v-model="dataForm.publicId" placeholder="公开ID"></el-input>
    </el-form-item> -->
    <el-form-item label="当事人名称或姓名" prop="partyName">
      <el-input v-model="dataForm.partyName" placeholder="当事人名称或姓名"></el-input>
    </el-form-item>
    <el-form-item label="主要违法事实" prop="illegact">
      <el-input type="textarea" v-model="dataForm.illegact" placeholder="主要违法事实"></el-input>
    </el-form-item>
    <el-form-item label="处罚内容" prop="punishdesicion">
      <el-input type="textarea" v-model="dataForm.punishdesicion" placeholder="处罚内容"></el-input>
    </el-form-item>
    <el-form-item label="处罚依据" prop="quabasisText">
      <el-input v-model="dataForm.quabasisText" placeholder="处罚依据"></el-input>
    </el-form-item>
    <el-form-item label="处罚日期" prop="pendesissDate">
      <!-- <el-input v-model="dataForm.pendesissDate" placeholder="处罚日期"></el-input> -->
      <el-date-picker v-model="dataForm.pendesissDate" value-format="yyyy-MM-dd" placeholder="处罚日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="办案机关" prop="bsjgText">
      <el-input v-model="dataForm.bsjgText" placeholder="办案机关"></el-input>
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
          publicId: '',
          partyName: '',
          illegact: '',
          punishdesicion: '',
          quabasisText: '',
          pendesissDate: '',
          bsjgText: '',
          enterpriseId: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '会员id不能为空', trigger: 'blur' }
          ],
          publicId: [
            { required: true, message: '公开ID不能为空', trigger: 'blur' }
          ],
          partyName: [
            { required: true, message: '当事人名称或姓名不能为空', trigger: 'blur' }
          ],
          illegact: [
            { required: true, message: '主要违法事实不能为空', trigger: 'blur' }
          ],
          punishdesicion: [
            { required: true, message: '处罚内容不能为空', trigger: 'blur' }
          ],
          quabasisText: [
            { required: true, message: '处罚依据不能为空', trigger: 'blur' }
          ],
          pendesissDate: [
            { required: true, message: '处罚日期不能为空', trigger: 'blur' }
          ],
          bsjgText: [
            { required: true, message: '办案机关不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/entillegalpunishinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.entIllegalPunishInfo.memId
                this.dataForm.publicId = data.entIllegalPunishInfo.publicId
                this.dataForm.partyName = data.entIllegalPunishInfo.partyName
                this.dataForm.illegact = data.entIllegalPunishInfo.illegact
                this.dataForm.punishdesicion = data.entIllegalPunishInfo.punishdesicion
                this.dataForm.quabasisText = data.entIllegalPunishInfo.quabasisText
                this.dataForm.pendesissDate = data.entIllegalPunishInfo.pendesissDate
                this.dataForm.bsjgText = data.entIllegalPunishInfo.bsjgText
                this.dataForm.enterpriseId = data.entIllegalPunishInfo.enterpriseId
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
              url: this.$http.adornUrl(`/spider/entillegalpunishinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'publicId': this.dataForm.publicId,
                'partyName': this.dataForm.partyName,
                'illegact': this.dataForm.illegact,
                'punishdesicion': this.dataForm.punishdesicion,
                'quabasisText': this.dataForm.quabasisText,
                'pendesissDate': this.dataForm.pendesissDate,
                'bsjgText': this.dataForm.bsjgText,
                'enterpriseId': this.dataForm.enterpriseId
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
