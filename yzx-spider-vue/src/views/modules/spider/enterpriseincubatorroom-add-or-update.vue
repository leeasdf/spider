<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
    
    <el-form-item label="孵化器名称" prop="incubatorName">
      <el-input v-model="dataForm.incubatorName" placeholder="孵化器名称"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="楼栋房号" prop="buildingRoomNo">
      <el-input v-model="dataForm.buildingRoomNo" placeholder="楼栋房号"></el-input>
    </el-form-item>
    <el-form-item label="面积" prop="enterpriseArea">
      <el-input v-model="dataForm.enterpriseArea" placeholder="面积"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
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
          incubatorName: '',
          enterpriseName: '',
          buildingRoomNo: '',
          enterpriseArea: '',
          remark: '',
          createtime: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          incubatorName: [
            { required: true, message: '孵化器名称不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          buildingRoomNo: [
            { required: true, message: '楼栋房号不能为空', trigger: 'blur' }
          ],
          enterpriseArea: [
            { required: true, message: '面积不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enterpriseincubatorroom/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.enterpriseIncubatorRoom.enterpriseId
                this.dataForm.incubatorName = data.enterpriseIncubatorRoom.incubatorName
                this.dataForm.enterpriseName = data.enterpriseIncubatorRoom.enterpriseName
                this.dataForm.buildingRoomNo = data.enterpriseIncubatorRoom.buildingRoomNo
                this.dataForm.enterpriseArea = data.enterpriseIncubatorRoom.enterpriseArea
                this.dataForm.remark = data.enterpriseIncubatorRoom.remark
                this.dataForm.createtime = data.enterpriseIncubatorRoom.createtime
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
              url: this.$http.adornUrl(`/spider/enterpriseincubatorroom/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'incubatorName': this.dataForm.incubatorName,
                'enterpriseName': this.dataForm.enterpriseName,
                'buildingRoomNo': this.dataForm.buildingRoomNo,
                'enterpriseArea': this.dataForm.enterpriseArea,
                'remark': this.dataForm.remark,
                'createtime': this.dataForm.createtime
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
