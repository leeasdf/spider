<template>
  <el-dialog
    width="780px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="作出决定机关" prop="orgName">
          <el-input v-model="dataForm.orgName" placeholder="作出决定机关"></el-input>
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
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="列入日期" prop="onDate">
          <el-date-picker v-model="dataForm.onDate" value-format="yyyy-MM-dd" placeholder="列入日期"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="列入经营异常原因" prop="onReason">
          <el-input v-model="dataForm.onReason" placeholder="列入经营异常原因"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="移出日期" prop="outDate">
          <el-date-picker v-model="dataForm.outDate" value-format="yyyy-MM-dd" placeholder="移出日期"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="移出经营异常原因" prop="outReason">
          <el-input v-model="dataForm.outReason" placeholder="移出经营异常原因"></el-input>
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
          memId: '',
          enterpriseId: '',
          orgName: '',
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
          ], */
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          orgName: [
            { required: true, message: '作出决定机关不能为空', trigger: 'blur' }
          ],
          onReason: [
            { required: true, message: '列入经营异常原因不能为空', trigger: 'blur' }
          ],
          onDate: [
            { required: true, message: '列入日期不能为空', trigger: 'blur' }
          ],
          outReason: [
            { required: true, message: '移出经营异常原因不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptopexinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptOpexInfo.memId
                this.dataForm.enterpriseId = data.rptOpexInfo.enterpriseId
                this.dataForm.orgName = data.rptOpexInfo.orgName
                this.dataForm.onReason = data.rptOpexInfo.onReason
                this.dataForm.onDate = data.rptOpexInfo.onDate
                this.dataForm.outReason = data.rptOpexInfo.outReason
                this.dataForm.outDate = data.rptOpexInfo.outDate
                this.dataForm.creator = data.rptOpexInfo.creator
                this.dataForm.createTime = data.rptOpexInfo.createTime
                this.dataForm.updater = data.rptOpexInfo.updater
                this.dataForm.updateTime = data.rptOpexInfo.updateTime
                this.dataForm.dataState = data.rptOpexInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptopexinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'orgName': this.dataForm.orgName,
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
