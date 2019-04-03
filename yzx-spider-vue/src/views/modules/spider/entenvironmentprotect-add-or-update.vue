<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="170px">
    <el-form-item label="组织机构代码" prop="organizationCode">
      <el-input v-model="dataForm.organizationCode" placeholder="组织机构代码"></el-input>
    </el-form-item>
    <!-- <el-form-item label="序号" prop="serialNo">
      <el-input v-model="dataForm.serialNo" placeholder="序号"></el-input>
    </el-form-item> -->
    <el-form-item label="来源" prop="source">
      <el-input v-model="dataForm.source" placeholder="来源"></el-input>
    </el-form-item>
    <el-form-item label="行政区代码" prop="areaCode">
      <el-input v-model="dataForm.areaCode" placeholder="行政区代码"></el-input>
    </el-form-item>
    <el-form-item label="县（区）" prop="county">
      <el-input v-model="dataForm.county" placeholder="县（区）"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="companyName">
      <el-input v-model="dataForm.companyName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="年份" prop="year">
      <!-- <el-input v-model="dataForm.year" placeholder="年份"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.year" placeholder="年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="是否国家监控污染企业" prop="countryMonitorFlag">
      <el-radio-group v-model="dataForm.countryMonitorFlag">
        <el-radio label="1">是</el-radio>
        <el-radio label="0">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="市（地、州、盟）" prop="city">
      <el-input v-model="dataForm.city" placeholder="市（地、州、盟）"></el-input>
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
          organizationCode: '',
          serialNo: '',
          source: '',
          areaCode: '',
          county: '',
          companyName: '',
          year: '',
          countryMonitorFlag: '',
          city: ''
        },
        dataRule: {
          organizationCode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
         /* serialNo: [
            { required: true, message: '序号不能为空', trigger: 'blur' }
          ], */
          source: [
            { required: true, message: '来源不能为空', trigger: 'blur' }
          ],
          areaCode: [
            { required: true, message: '行政区代码不能为空', trigger: 'blur' }
          ],
          county: [
            { required: true, message: '县（区）不能为空', trigger: 'blur' }
          ],
          companyName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '年份不能为空', trigger: 'blur' }
          ],
          countryMonitorFlag: [
            { required: true, message: '否是国家监控污染企业不能为空', trigger: 'change' }
          ],
          city: [
            { required: true, message: '市（地、州、盟）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/entenvironmentprotect/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.organizationCode = data.entEnvironmentProtect.organizationCode
                this.dataForm.serialNo = data.entEnvironmentProtect.serialNo
                this.dataForm.source = data.entEnvironmentProtect.source
                this.dataForm.areaCode = data.entEnvironmentProtect.areaCode
                this.dataForm.county = data.entEnvironmentProtect.county
                this.dataForm.companyName = data.entEnvironmentProtect.companyName
                this.dataForm.year = data.entEnvironmentProtect.year
                this.dataForm.countryMonitorFlag = data.entEnvironmentProtect.countryMonitorFlag
                this.dataForm.city = data.entEnvironmentProtect.city
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
              url: this.$http.adornUrl(`/spider/entenvironmentprotect/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'organizationCode': this.dataForm.organizationCode,
                'serialNo': this.dataForm.serialNo,
                'source': this.dataForm.source,
                'areaCode': this.dataForm.areaCode,
                'county': this.dataForm.county,
                'companyName': this.dataForm.companyName,
                'year': this.dataForm.year,
                'countryMonitorFlag': this.dataForm.countryMonitorFlag,
                'city': this.dataForm.city
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
