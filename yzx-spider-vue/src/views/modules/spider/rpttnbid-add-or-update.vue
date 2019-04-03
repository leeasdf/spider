<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="采购人" prop="purchaser">
            <el-input v-model="dataForm.purchaser" placeholder="采购人"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
           <el-form-item label="发布时间" prop="publishDate">
              <el-date-picker v-model="dataForm.publishDate" value-format="yyyy-MM-dd" placeholder="发布时间"></el-date-picker>
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
      <el-form-item label="标题" prop="title">
        <el-input v-model="dataForm.title" placeholder="标题"></el-input>
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
          purchaser: '',
          title: '',
          publishDate: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          purchaser: [
            { required: true, message: '采购人不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '标题不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '发布时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnbid/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnBid.enterpriseId
                this.dataForm.entName = data.rptTnBid.entName
                this.dataForm.purchaser = data.rptTnBid.purchaser
                this.dataForm.title = data.rptTnBid.title
                this.dataForm.publishDate = data.rptTnBid.publishDate
                this.dataForm.creator = data.rptTnBid.creator
                this.dataForm.createTime = data.rptTnBid.createTime
                this.dataForm.updater = data.rptTnBid.updater
                this.dataForm.updateTime = data.rptTnBid.updateTime
                this.dataForm.dataState = data.rptTnBid.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnbid/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'purchaser': this.dataForm.purchaser,
                'title': this.dataForm.title,
                'publishDate': this.dataForm.publishDate,
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
