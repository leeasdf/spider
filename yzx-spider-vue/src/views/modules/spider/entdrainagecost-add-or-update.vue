<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
    <el-form-item label="企业名称" prop="companyName">
      <el-input v-model="dataForm.companyName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="来源" prop="source">
      <el-input v-model="dataForm.source" placeholder="来源"></el-input>
    </el-form-item>
    <el-form-item label="是否排污企业" prop="drainageFlag">
      <el-radio-group v-model="dataForm.drainageFlag">
        <el-radio label="1">是</el-radio>
        <el-radio label="0">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <!-- <el-form-item label="序号" prop="serialNo">
      <el-input v-model="dataForm.serialNo" placeholder="序号"></el-input>
    </el-form-item> -->
    <el-form-item label="征收机构" prop="levyInstitution">
      <el-input v-model="dataForm.levyInstitution" placeholder="征收机构"></el-input>
    </el-form-item>
    <el-form-item label="开单金额(单位:元)" prop="billingAmount">
      <el-input v-model="dataForm.billingAmount" placeholder="开单金额(单位:元)"></el-input>
    </el-form-item>
    <el-form-item label="入库金额(单位:元)" prop="payinAmount">
      <el-input v-model="dataForm.payinAmount" placeholder="入库金额(单位:元)"></el-input>
    </el-form-item>
    <el-form-item label="上级机构" prop="parentInstitution">
      <el-input v-model="dataForm.parentInstitution" placeholder="上级机构"></el-input>
    </el-form-item>
    <el-form-item label="企业状态类型" prop="type">
      <el-radio-group v-model="dataForm.type" class="yzx-radio-group">
        <el-radio label="0">正常</el-radio>
        <el-radio label="1">政策性免征</el-radio>
        <el-radio label="2">停产</el-radio>
        <el-radio label="3">永久性停产</el-radio>
        <el-radio label="4">关闭</el-radio>
        <el-radio label="5">未正式投产</el-radio>
        <el-radio label="6">零排放</el-radio>
        <el-radio label="7">其他</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="年份" prop="year">
      <el-date-picker type="year" v-model="dataForm.year" placeholder="年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="季度" prop="quarter">
      <el-radio-group v-model="dataForm.quarter">
        <el-radio label="1">1</el-radio>
        <el-radio label="2">2</el-radio>
        <el-radio label="3">3</el-radio>
        <el-radio label="4">4</el-radio>
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
  import { isFloat } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          companyName: '',
          source: '',
          drainageFlag: '',
          serialNo: '',
          levyInstitution: '',
          billingAmount: '',
          payinAmount: '',
          parentInstitution: '',
          type: '',
          year: '',
          quarter: ''
        },
        dataRule: {
          companyName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '来源不能为空', trigger: 'blur' }
          ],
          drainageFlag: [
            { required: true, message: '是否排污企业不能为空', trigger: 'change' }
          ],
          /* serialNo: [
            { required: true, message: '序号不能为空', trigger: 'blur' }
          ], */
          levyInstitution: [
            { required: true, message: '征收机构不能为空', trigger: 'blur' }
          ],
          billingAmount: [
            { required: true, message: '开单金额(单位:元)不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          payinAmount: [
            { required: true, message: '入库金额(单位:元)不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          parentInstitution: [
            { required: true, message: '上级机构不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '企业状态类型不能为空', trigger: 'change' }
          ],
          year: [
            { required: true, message: '年份不能为空', trigger: 'blur' }
          ],
          quarter: [
            { required: true, message: '季度不能为空', trigger: 'change' }
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
              url: this.$http.adornUrl(`/spider/entdrainagecost/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.companyName = data.entDrainageCost.companyName
                this.dataForm.source = data.entDrainageCost.source
                this.dataForm.drainageFlag = data.entDrainageCost.drainageFlag
                this.dataForm.serialNo = data.entDrainageCost.serialNo
                this.dataForm.levyInstitution = data.entDrainageCost.levyInstitution
                this.dataForm.billingAmount = data.entDrainageCost.billingAmount
                this.dataForm.payinAmount = data.entDrainageCost.payinAmount
                this.dataForm.parentInstitution = data.entDrainageCost.parentInstitution
                this.dataForm.type = data.entDrainageCost.type
                this.dataForm.year = data.entDrainageCost.year
                this.dataForm.quarter = data.entDrainageCost.quarter
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
              url: this.$http.adornUrl(`/spider/entdrainagecost/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'companyName': this.dataForm.companyName,
                'source': this.dataForm.source,
                'drainageFlag': this.dataForm.drainageFlag,
                'serialNo': this.dataForm.serialNo,
                'levyInstitution': this.dataForm.levyInstitution,
                'billingAmount': this.dataForm.billingAmount,
                'payinAmount': this.dataForm.payinAmount,
                'parentInstitution': this.dataForm.parentInstitution,
                'type': this.dataForm.type,
                'year': this.dataForm.year,
                'quarter': this.dataForm.quarter
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
