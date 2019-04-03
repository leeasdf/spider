<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
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
    <el-form-item label="组织机构代码" prop="organizationcode">
      <el-input v-model="dataForm.organizationcode" placeholder="组织机构代码"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="corporationname">
      <el-input v-model="dataForm.corporationname" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="欠税余额" prop="taxbalance">
      <el-input v-model="dataForm.taxbalance" placeholder="欠税余额">
        <span slot="append">元</span>
      </el-input>
    </el-form-item>
    <el-form-item label="截止日期" prop="enddate">
      <!-- <el-input v-model="dataForm.enddate" placeholder="截止日期"></el-input> -->
      <el-date-picker v-model="dataForm.enddate" placeholder="截止日期" value-format="yyyy-MM-dd"></el-date-picker>
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
          organizationcode: '',
          corporationname: '',
          taxbalance: '',
          enddate: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态（0：正常 1：更新 2：删除）不能为空', trigger: 'blur' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          organizationcode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          corporationname: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          taxbalance: [
            { required: true, message: '欠税余额（元）不能为空', trigger: 'blur' }
          ],
          enddate: [
            { required: true, message: '截止日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/cssfgwtaxtaxofnopayed/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwTaxTaxofnopayed.isinvalid
                this.dataForm.lastdate = data.csSfgwTaxTaxofnopayed.lastdate
                this.dataForm.organizationcode = data.csSfgwTaxTaxofnopayed.organizationcode
                this.dataForm.corporationname = data.csSfgwTaxTaxofnopayed.corporationname
                this.dataForm.taxbalance = data.csSfgwTaxTaxofnopayed.taxbalance
                this.dataForm.enddate = data.csSfgwTaxTaxofnopayed.enddate
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
              url: this.$http.adornUrl(`/spider/cssfgwtaxtaxofnopayed/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'organizationcode': this.dataForm.organizationcode,
                'corporationname': this.dataForm.corporationname,
                'taxbalance': this.dataForm.taxbalance,
                'enddate': this.dataForm.enddate,
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
