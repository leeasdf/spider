<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="工商注册号" prop="regNo">
            <el-input v-model="dataForm.regNo" placeholder="工商注册号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业类别" prop="entType">
            <el-input v-model="dataForm.entType" placeholder="企业类别"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行业" prop="industryPhyName">
            <el-input v-model="dataForm.industryPhyName" placeholder="行业"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="社会信用代码" prop="creCode">
            <el-input v-model="dataForm.creCode" placeholder="统一社会信用代码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="纳税人识别号" prop="ideNum">
            <el-input v-model="dataForm.ideNum" placeholder="纳税人识别号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="组织机构代码" prop="orgCode">
            <el-input v-model="dataForm.orgCode" placeholder="组织机构代码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记机关" prop="regAuthority">
            <el-input v-model="dataForm.regAuthority" placeholder="登记机关"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="营业期限" prop="opePeriod">
            <el-input v-model="dataForm.opePeriod" placeholder="营业期限"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="核准日期" prop="appDate">
            <el-date-picker type="date" v-model="dataForm.appDate" value-format="yyyy-MM-dd" placeholder="核准日期"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="法人" prop="legalPerson">
            <el-input v-model="dataForm.legalPerson" placeholder="法人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册资本" prop="regCap">
            <el-input v-model="dataForm.regCap" placeholder="注册资本"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="注册时间" prop="regTime">
            <el-date-picker type="date" v-model="dataForm.regTime" value-format="yyyy-MM-dd" placeholder="注册时间"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="企业状态" prop="status">
            <el-input v-model="dataForm.status" placeholder="企业状态"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="数据状态" prop="dataState">
            <el-radio-group v-model="dataForm.dataState">
              <el-radio :label="1">正常</el-radio>
              <el-radio :label="0">删除</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公司名称" prop="cmpName">
            <el-input v-model="dataForm.cmpName" placeholder="公司名称"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="注册地址" prop="regAddress">
        <el-input v-model="dataForm.regAddress" placeholder="注册地址"></el-input>
      </el-form-item>
      <el-form-item label="经营范围" prop="busScope">
        <el-input type="textarea" v-model="dataForm.busScope" placeholder="经营范围"></el-input>
      </el-form-item>
      <el-form-item label="英文名称">
        <el-input v-model="dataForm.engName" placeholder="英文名称"></el-input>
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
      const validataFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点数'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: '',
          enterpriseId: '',
          entName: '',
          regNo: '',
          entType: '',
          industryPhyName: '',
          ideNum: '',
          creCode: '',
          engName: '',
          orgCode: '',
          regAuthority: '',
          opePeriod: '',
          appDate: '',
          regAddress: '',
          busScope: '',
          cmpName: '',
          regTime: '',
          legalPerson: '',
          regCap: '',
          status: '',
          dataState: ''
        },
        dataRule: {
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          regNo: [
            { required: true, message: '工商注册号不能为空', trigger: 'blur' }
          ],
          entType: [
            { required: true, message: '企业类别不能为空', trigger: 'blur' }
          ],
          industryPhyName: [
            { required: true, message: '行业不能为空', trigger: 'blur' }
          ],
          ideNum: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          creCode: [
            { required: true, message: '统一社会信用代码不能为空', trigger: 'blur' }
          ],
          orgCode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          regAuthority: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          opePeriod: [
            { required: true, message: '营业期限不能为空', trigger: 'blur' }
          ],
          appDate: [
            { required: true, message: '核准日期不能为空', trigger: 'blur' }
          ],
          regAddress: [
            { required: true, message: '注册地址不能为空', trigger: 'blur' }
          ],
          busScope: [
            { required: true, message: '经营范围不能为空', trigger: 'blur' }
          ],
          cmpName: [
            { required: true, message: '公司名称不能为空', trigger: 'blur' }
          ],
          regTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
          ],
          legalPerson: [
            { required: true, message: '法人不能为空', trigger: 'blur' }
          ],
          regCap: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' },
            { validator: validataFloat, trigger: 'blur' }
          ],
          status: [
            { required: true, message: '企业状态不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || undefined
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/spider/rpttnbasicinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnBasicInfo.enterpriseId
                this.dataForm.entName = data.rptTnBasicInfo.entName
                this.dataForm.regNo = data.rptTnBasicInfo.regNo
                this.dataForm.entType = data.rptTnBasicInfo.entType
                this.dataForm.industryPhyName = data.rptTnBasicInfo.industryPhyName
                this.dataForm.ideNum = data.rptTnBasicInfo.ideNum
                this.dataForm.creCode = data.rptTnBasicInfo.creCode
                this.dataForm.engName = data.rptTnBasicInfo.engName
                this.dataForm.orgCode = data.rptTnBasicInfo.orgCode
                this.dataForm.regAuthority = data.rptTnBasicInfo.regAuthority
                this.dataForm.opePeriod = data.rptTnBasicInfo.opePeriod
                this.dataForm.appDate = data.rptTnBasicInfo.appDate
                this.dataForm.regAddress = data.rptTnBasicInfo.regAddress
                this.dataForm.busScope = data.rptTnBasicInfo.busScope
                this.dataForm.cmpName = data.rptTnBasicInfo.cmpName
                this.dataForm.regTime = data.rptTnBasicInfo.regTime
                this.dataForm.legalPerson = data.rptTnBasicInfo.legalPerson
                this.dataForm.regCap = data.rptTnBasicInfo.regCap
                this.dataForm.status = data.rptTnBasicInfo.status
                this.dataForm.creator = data.rptTnBasicInfo.creator
                this.dataForm.createTime = data.rptTnBasicInfo.createTime
                this.dataForm.updater = data.rptTnBasicInfo.updater
                this.dataForm.updateTime = data.rptTnBasicInfo.updateTime
                this.dataForm.dataState = data.rptTnBasicInfo.dataState
                this.dataForm.version = data.rptTnBasicInfo.version
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
              url: this.$http.adornUrl(`/spider/rpttnbasicinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData(this.dataForm)
              /* data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'regNo': this.dataForm.regNo,
                'entType': this.dataForm.entType,
                'industryPhyName': this.dataForm.industryPhyName,
                'ideNum': this.dataForm.ideNum,
                'creCode': this.dataForm.creCode,
                'engName': this.dataForm.engName,
                'orgCode': this.dataForm.orgCode,
                'regAuthority': this.dataForm.regAuthority,
                'opePeriod': this.dataForm.opePeriod,
                'appDate': this.dataForm.appDate,
                'regAddress': this.dataForm.regAddress,
                'busScope': this.dataForm.busScope,
                'cmpName': this.dataForm.cmpName,
                'regTime': this.dataForm.regTime,
                'legalPerson': this.dataForm.legalPerson,
                'regCap': this.dataForm.regCap,
                'status': this.dataForm.status,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'version': this.dataForm.version
              }) */
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
