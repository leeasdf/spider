<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="业务ID" prop="bizId">
      <el-input v-model="dataForm.bizId" placeholder="业务ID"></el-input>
    </el-form-item>
    <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="翻页类型" prop="dataType">
      <el-input v-model="dataForm.dataType" placeholder="翻页类型"></el-input>
    </el-form-item>
    <el-form-item label="翻页总条数" prop="pageTotal">
      <el-input v-model="dataForm.pageTotal" placeholder="翻页总条数"></el-input>
    </el-form-item>
    <el-form-item label="" prop="pageNum">
      <el-input v-model="dataForm.pageNum" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态"></el-input>
    </el-form-item>
    
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          bizId: '',
          enterpriseId: '',
          entName: '',
          dataType: '',
          pageTotal: '',
          pageNum: '',
          status: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          bizId: [
            { required: true, message: '业务ID不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          dataType: [
            { required: true, message: '翻页类型不能为空', trigger: 'blur' }
          ],
          pageTotal: [
            { required: true, message: '翻页总条数不能为空', trigger: 'blur' }
          ],
          pageNum: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/tycpagerecord/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.bizId = data.tycPageRecord.bizId
                this.dataForm.enterpriseId = data.tycPageRecord.enterpriseId
                this.dataForm.entName = data.tycPageRecord.entName
                this.dataForm.dataType = data.tycPageRecord.dataType
                this.dataForm.pageTotal = data.tycPageRecord.pageTotal
                this.dataForm.pageNum = data.tycPageRecord.pageNum
                this.dataForm.status = data.tycPageRecord.status
                this.dataForm.createTime = data.tycPageRecord.createTime
                this.dataForm.updateTime = data.tycPageRecord.updateTime
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
              url: this.$http.adornUrl(`/spider/tycpagerecord/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'bizId': this.dataForm.bizId,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'dataType': this.dataForm.dataType,
                'pageTotal': this.dataForm.pageTotal,
                'pageNum': this.dataForm.pageNum,
                'status': this.dataForm.status,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
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
