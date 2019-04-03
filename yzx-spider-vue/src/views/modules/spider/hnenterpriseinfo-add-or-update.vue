<template>
  <el-dialog
    width="780px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="enterpriseName">
            <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="组织机构编码" prop="organizationCode">
            <el-input v-model="dataForm.organizationCode" placeholder="组织机构编码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="营业执照号" prop="businessLicenseNo">
            <el-input v-model="dataForm.businessLicenseNo" placeholder="营业执照号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="税号" prop="taxNo">
            <el-input v-model="dataForm.taxNo" placeholder="税号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="注册日期" prop="esdate">
            <el-date-picker v-model="dataForm.esdate" placeholder="注册日期" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册资本" prop="regcap">
            <el-input v-model="dataForm.regcap" placeholder="注册资本"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="统一社会信用代码" prop="creditCode">
            <el-input v-model="dataForm.creditCode" placeholder="统一社会信用代码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行业归属" prop="industryType">
            <el-select v-model="dataForm.industryType">
              <el-option v-for="item in industryTypeList" :key="item.key" :label="item.text" :value="item.key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="入园时间" prop="entrydate">
            <el-date-picker v-model="dataForm.entrydate" placeholder="入园时间" value-format="yyyy-MM-dd"></el-date-picker>
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
    <!-- <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import global_ from '@/utils/dataFormat'
  export default {
    data () {
      return {
        visible: false,
        industryTypeList: global_.industryTypeList,
        dataForm: {
          id: 0,
          enterpriseName: '',
          organizationCode: '',
          businessLicenseNo: '',
          taxNo: '',
          esdate: '',
          regcap: '',
          entrydate: '',
          createtime: '',
          creditCode: '',
          industryType: '',
          dataState: '',
          updateTime: ''
        },
        dataRule: {
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          organizationCode: [
            { required: true, message: '组织机构编码不能为空', trigger: 'blur' }
          ],
          businessLicenseNo: [
            { required: true, message: '营业执照号不能为空', trigger: 'blur' }
          ],
          taxNo: [
            { required: true, message: '税号不能为空', trigger: 'blur' }
          ],
          esdate: [
            { required: true, message: '注册日期不能为空', trigger: 'blur' }
          ],
          regcap: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' }
          ],
          entrydate: [
            { required: true, message: '入园时间不能为空', trigger: 'blur' }
          ],
          creditCode: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          industryType: [
            { required: true, message: '行业归属不能为空', trigger: 'change' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ]
          /* updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ] */
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
              url: this.$http.adornUrl(`/spider/hnenterpriseinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseName = data.hnEnterpriseInfo.enterpriseName
                this.dataForm.organizationCode = data.hnEnterpriseInfo.organizationCode
                this.dataForm.businessLicenseNo = data.hnEnterpriseInfo.businessLicenseNo
                this.dataForm.taxNo = data.hnEnterpriseInfo.taxNo
                this.dataForm.esdate = data.hnEnterpriseInfo.esdate
                this.dataForm.regcap = data.hnEnterpriseInfo.regcap
                this.dataForm.entrydate = data.hnEnterpriseInfo.entrydate
                this.dataForm.createtime = data.hnEnterpriseInfo.createtime
                this.dataForm.creditCode = data.hnEnterpriseInfo.creditCode
                this.dataForm.industryType = data.hnEnterpriseInfo.industryType
                this.dataForm.dataState = data.hnEnterpriseInfo.dataState
                this.dataForm.updateTime = data.hnEnterpriseInfo.updateTime
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
              url: this.$http.adornUrl(`/spider/hnenterpriseinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseName': this.dataForm.enterpriseName,
                'organizationCode': this.dataForm.organizationCode,
                'businessLicenseNo': this.dataForm.businessLicenseNo,
                'taxNo': this.dataForm.taxNo,
                'esdate': this.dataForm.esdate,
                'regcap': this.dataForm.regcap,
                'entrydate': this.dataForm.entrydate,
                'createtime': this.dataForm.createtime,
                'creditCode': this.dataForm.creditCode,
                'industryType': this.dataForm.industryType,
                'dataState': this.dataForm.dataState,
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
