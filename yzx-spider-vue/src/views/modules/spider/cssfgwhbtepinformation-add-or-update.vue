<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <el-form-item label="数据状态" prop="isinvalid">
      <el-radio-group v-model="dataForm.isinvalid">
        <el-radio :label="0">正常</el-radio>
        <el-radio :label="1">更新</el-radio>
        <el-radio :label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <!-- <el-form-item label="数据最后修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item> -->
    <el-form-item label="企业名称" prop="corporationname">
      <el-input v-model="dataForm.corporationname" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="排污许可证编号" prop="license">
      <el-input v-model="dataForm.license" placeholder="排污许可证编号"></el-input>
    </el-form-item>
    <el-form-item label="排污许可证类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="排污许可证类型"></el-input>
    </el-form-item>
    <el-form-item label="发证机关名称" prop="issuingauthority">
      <el-input v-model="dataForm.issuingauthority" placeholder="发证机关名称"></el-input>
    </el-form-item>
    <el-form-item label="有效期" prop="periodofvalidity">
      <!-- <el-input v-model="dataForm.periodofvalidity" placeholder="有效期"></el-input> -->
      <el-date-picker v-model="dataForm.periodofvalidity" placeholder="有效期" value-format="yyyy-MM-dd"></el-date-picker>
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
          isinvalid: '',
          lastdate: '',
          corporationname: '',
          license: '',
          type: '',
          issuingauthority: '',
          periodofvalidity: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          /* lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ], */
          corporationname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          license: [
            { required: true, message: '排污许可证编号不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '排污许可证类型不能为空', trigger: 'blur' }
          ],
          issuingauthority: [
            { required: true, message: '发证机关名称不能为空', trigger: 'blur' }
          ],
          periodofvalidity: [
            { required: true, message: '有效期不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.zjid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.zjid) {
            this.$http({
              url: this.$http.adornUrl(`/spider/cssfgwhbtepinformation/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwHbtEpinformation.isinvalid
                this.dataForm.lastdate = data.csSfgwHbtEpinformation.lastdate
                this.dataForm.corporationname = data.csSfgwHbtEpinformation.corporationname
                this.dataForm.license = data.csSfgwHbtEpinformation.license
                this.dataForm.type = data.csSfgwHbtEpinformation.type
                this.dataForm.issuingauthority = data.csSfgwHbtEpinformation.issuingauthority
                this.dataForm.periodofvalidity = data.csSfgwHbtEpinformation.periodofvalidity
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
              url: this.$http.adornUrl(`/spider/cssfgwhbtepinformation/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'corporationname': this.dataForm.corporationname,
                'license': this.dataForm.license,
                'type': this.dataForm.type,
                'issuingauthority': this.dataForm.issuingauthority,
                'periodofvalidity': this.dataForm.periodofvalidity,
                'zjid': this.dataForm.zjid || undefined
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
