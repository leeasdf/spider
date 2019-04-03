<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="160px">
   <!--  <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    
    <el-form-item label="作出决定机关" prop="organName">
      <el-input v-model="dataForm.organName" placeholder="作出决定机关"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="type">
      <el-input v-model="dataForm.type" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="列入失信黑名单原因" prop="onReason">
      <el-input v-model="dataForm.onReason" placeholder="列入失信黑名单原因"></el-input>
    </el-form-item>
    <el-form-item label="列入日期" prop="onDate">
      <el-date-picker v-model="dataForm.onDate" value-format="yyyy-MM-dd" placeholder="列入日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="移出失信黑名单原因" prop="outReason">
      <el-input v-model="dataForm.outReason" placeholder="移出失信黑名单原因"></el-input>
    </el-form-item>
    <el-form-item label="移出日期" prop="outDate">
      <el-date-picker v-model="dataForm.outDate" value-format="yyyy-MM-dd" placeholder="移出日期"></el-date-picker>
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
          organName: '',
          type: '',
          onReason: '',
          onDate: '',
          outReason: '',
          outDate: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          /* memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ], */
          organName: [
            { required: true, message: '作出决定机关不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          onReason: [
            { required: true, message: '列入失信黑名单原因不能为空', trigger: 'blur' }
          ],
          onDate: [
            { required: true, message: '列入日期不能为空', trigger: 'blur' }
          ],
          outReason: [
            { required: true, message: '移出失信黑名单原因不能为空', trigger: 'blur' }
          ],
          outDate: [
            { required: true, message: '移出日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptcblackinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptCblackInfo.memId
                this.dataForm.enterpriseId = data.rptCblackInfo.enterpriseId
                this.dataForm.organName = data.rptCblackInfo.organName
                this.dataForm.type = data.rptCblackInfo.type
                this.dataForm.onReason = data.rptCblackInfo.onReason
                this.dataForm.onDate = data.rptCblackInfo.onDate
                this.dataForm.outReason = data.rptCblackInfo.outReason
                this.dataForm.outDate = data.rptCblackInfo.outDate
                this.dataForm.creator = data.rptCblackInfo.creator
                this.dataForm.createTime = data.rptCblackInfo.createTime
                this.dataForm.updater = data.rptCblackInfo.updater
                this.dataForm.updateTime = data.rptCblackInfo.updateTime
                this.dataForm.dataState = data.rptCblackInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptcblackinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'organName': this.dataForm.organName,
                'type': this.dataForm.type,
                'onReason': this.dataForm.onReason,
                'onDate': this.dataForm.onDate,
                'outReason': this.dataForm.outReason,
                'outDate': this.dataForm.outDate,
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
