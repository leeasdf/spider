<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <el-form-item label="企业名称" prop="companyName">
      <el-input v-model="dataForm.companyName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="年开单金额" prop="billingFee">
      <el-input v-model="dataForm.billingFee" placeholder="年开单金额">
        <span slot="append">元</span>
      </el-input>
    </el-form-item>
    <el-form-item label="是否欠排污费" prop="oweFlag">
      <el-radio-group v-model="dataForm.oweFlag">
        <el-radio label="1">是</el-radio>
        <el-radio label="0">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <!-- <el-form-item label="序号" prop="serialNo">
      <el-input v-model="dataForm.serialNo" placeholder="序号"></el-input>
    </el-form-item> -->
    <el-form-item label="年入库金额" prop="payIn">
      <el-input v-model="dataForm.payIn" placeholder="年入库金额">
        <span slot="append">元</span>
      </el-input>
    </el-form-item>
    <el-form-item label="上级机构" prop="parentInstitution">
      <el-input v-model="dataForm.parentInstitution" placeholder="上级机构"></el-input>
    </el-form-item>
    <el-form-item label="年份" prop="year">
      <!-- <el-input v-model="dataForm.year" placeholder="年份"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.year" placeholder="年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="欠缴排污费" prop="oweFee">
      <el-input v-model="dataForm.oweFee" placeholder="欠缴排污费">
        <span slot="append">元</span>
      </el-input>
    </el-form-item>
    <el-form-item label="缴纳金额" prop="payOweFee">
      <el-input v-model="dataForm.payOweFee" placeholder="缴纳金额">
        <span slot="append">元</span>
      </el-input>
    </el-form-item>
    <el-form-item label="缴纳时间" prop="payTime">
      <el-input v-model="dataForm.payTime" placeholder="缴纳时间"></el-input>
    </el-form-item>
    <el-form-item label="说明（处理意见等说明）" prop="remark">
      <el-input type="textarea" v-model="dataForm.remark" placeholder="说明（处理意见等说明）"></el-input>
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
          companyName: '',
          billingFee: '',
          oweFlag: '',
          serialNo: '',
          payIn: '',
          parentInstitution: '',
          year: '',
          oweFee: '',
          payOweFee: '',
          payTime: '',
          remark: ''
        },
        dataRule: {
          companyName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          billingFee: [
            { required: true, message: '年开单金额不能为空', trigger: 'blur' }
          ],
          oweFlag: [
            { required: true, message: '是否欠排污费不能为空', trigger: 'change' }
          ],
          /* serialNo: [
            { required: true, message: '序号不能为空', trigger: 'blur' }
          ], */
          payIn: [
            { required: true, message: '年入库金额不能为空', trigger: 'blur' }
          ],
          parentInstitution: [
            { required: true, message: '上级机构不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '年份不能为空', trigger: 'blur' }
          ],
          oweFee: [
            { required: true, message: '欠缴排污费不能为空', trigger: 'blur' }
          ],
          payOweFee: [
            { required: true, message: '缴纳金额不能为空', trigger: 'blur' }
          ],
          payTime: [
            { required: true, message: '缴纳时间不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '说明（处理意见等说明）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/entdrainageowefee/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.companyName = data.entDrainageOweFee.companyName
                this.dataForm.billingFee = data.entDrainageOweFee.billingFee
                this.dataForm.oweFlag = data.entDrainageOweFee.oweFlag
                this.dataForm.serialNo = data.entDrainageOweFee.serialNo
                this.dataForm.payIn = data.entDrainageOweFee.payIn
                this.dataForm.parentInstitution = data.entDrainageOweFee.parentInstitution
                this.dataForm.year = data.entDrainageOweFee.year
                this.dataForm.oweFee = data.entDrainageOweFee.oweFee
                this.dataForm.payOweFee = data.entDrainageOweFee.payOweFee
                this.dataForm.payTime = data.entDrainageOweFee.payTime
                this.dataForm.remark = data.entDrainageOweFee.remark
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
              url: this.$http.adornUrl(`/spider/entdrainageowefee/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'companyName': this.dataForm.companyName,
                'billingFee': this.dataForm.billingFee,
                'oweFlag': this.dataForm.oweFlag,
                'serialNo': this.dataForm.serialNo,
                'payIn': this.dataForm.payIn,
                'parentInstitution': this.dataForm.parentInstitution,
                'year': this.dataForm.year,
                'oweFee': this.dataForm.oweFee,
                'payOweFee': this.dataForm.payOweFee,
                'payTime': this.dataForm.payTime,
                'remark': this.dataForm.remark
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
