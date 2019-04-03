<template>
  <el-dialog
    width="780px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
      <el-row>
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
      <el-row>
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
      <el-row>
        <el-col :span="12">
          <el-form-item label="统一社会信用代码" prop="creditCode">
            <el-input v-model="dataForm.creditCode" placeholder="统一社会信用代码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册资本" prop="regCap">
            <el-input v-model="dataForm.regCap" placeholder="注册资本"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="注册日期" prop="esDate">
            <el-date-picker type="date" v-model="dataForm.esDate" placeholder="注册日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="入园时间" prop="entryDate">
            <el-date-picker type="date" v-model="dataForm.entryDate" placeholder="入园时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="行业归属" prop="industryType">
            <el-select v-model="dataForm.industryType">
              <el-option v-for="item in industryTypeList" :key="item.key" :label="item.text" :value="item.key"></el-option>
            </el-select>
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
          <el-form-item label="省份" prop="province">
            <el-input v-model="dataForm.province" placeholder="省份"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="城市" prop="city">
            <el-input v-model="dataForm.city" placeholder="城市"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="联系电话列表" prop="phones">
            <el-input v-model="dataForm.phones" placeholder="联系电话列表"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="dataForm.email" placeholder=""></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业法人" prop="legalPersonName">
            <el-input v-model="dataForm.legalPersonName" placeholder="企业法人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="出资时间" prop="tycUpdateTime">
            <el-date-picker type="date" v-model="dataForm.tycUpdateTime" placeholder="出资时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="注册时间" prop="regTime">
            <el-date-picker type="date" v-model="dataForm.regTime" placeholder="注册时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
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
      <el-row :gutter="20">
      <!--
        <el-col :span="12">
          <el-form-item label="天眼查企业ID" prop="tycEnterpriseid">
            <el-input v-model="dataForm.tycEnterpriseid" placeholder="天眼查企业ID"></el-input>
          </el-form-item>
        </el-col>
        -->
        <el-col :span="12">
          <el-form-item label="数据来源" prop="dataSource">
            <el-input v-model="dataForm.dataSource" placeholder="数据来源"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="renameFlag" prop="renameFlag">
            <el-input v-model="dataForm.renameFlag" placeholder=""></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="历史名称" prop="oldName">
            <el-input v-model="dataForm.oldName" placeholder="历史名称"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
      	<!--
        <el-col :span="12">
          <el-form-item label="天眼查得分" prop="score">
            <el-input v-model="dataForm.score" placeholder="天眼查得分"></el-input>
          </el-form-item>
        </el-col>
          -->
        <el-col :span="12">
          <el-form-item label="版本号" prop="version">
            <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="新企业名称" prop="newName">
            <el-input v-model="dataForm.newName" placeholder="新企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          
        </el-col>
        <el-col :span="12">
          
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          
        </el-col>
        <el-col :span="12">
          
        </el-col>
      </el-row>
    <!-- <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    <el-form-item label="官网网址" prop="webSite">
      <el-input v-model="dataForm.webSite" placeholder="官网网址"></el-input>
    </el-form-item>
    <el-form-item label="地址" prop="address">
      <el-input v-model="dataForm.address" placeholder="地址"></el-input>
    </el-form-item>
    
    <el-form-item label="简介" prop="content">
      <el-input type="textarea" v-model="dataForm.content" placeholder="简介"></el-input>
    </el-form-item>
    <!-- <el-form-item label="旧企业ID" prop="oldEnterpriseId">
      <el-input v-model="dataForm.oldEnterpriseId" placeholder="旧企业ID"></el-input>
    </el-form-item> -->
    
    <!-- <el-form-item label="新企业ID" prop="newEnterpriseId">
      <el-input v-model="dataForm.newEnterpriseId" placeholder="新企业ID"></el-input>
    </el-form-item> -->
    <el-form-item label="标签列表" prop="tagList">
      <el-input v-model="dataForm.tagList" placeholder="标签列表"></el-input>
    </el-form-item>
    <el-form-item label="曾用名列表" prop="historyList">
      <el-input v-model="dataForm.historyList" placeholder="曾用名列表"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import global_ from '@/utils/dataFormat'
  import { isEmail } from '@/utils/validate'
  export default {
    data () {
      const validateEmail = function (rule, value, callback) {
        if (!isEmail) {
          callback(new Error('邮箱格式错误'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        industryTypeList: global_.industryTypeList,
        dataForm: {
          id: 0,
          enterpriseName: '',
          organizationCode: '',
          businessLicenseNo: '',
          taxNo: '',
          esDate: '',
          regCap: '',
          entryDate: '',
          createtime: '',
          creditCode: '',
          industryType: '',
          dataState: '',
          updateTime: '',
          province: '',
          city: '',
          regTime: '',
          tycEnterpriseid: '',
          status: '',
          dataSource: '',
          webSite: '',
          address: '',
          phones: '',
          email: '',
          content: '',
          legalPersonName: '',
          renameFlag: '',
          oldName: '',
          remark: '',
          tycUpdateTime: '',
          score: '',
          version: '',
          oldEnterpriseId: '',
          newName: '',
          newEnterpriseId: '',
          tagList: '',
          historyList: ''
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
          esDate: [
            { required: true, message: '注册日期不能为空', trigger: 'blur' }
          ],
          regCap: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' }
          ],
          entryDate: [
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
          ],
          /* updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ], */
          province: [
            { required: true, message: '省份不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '城市不能为空', trigger: 'blur' }
          ],
          regTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '企业状态不能为空', trigger: 'blur' }
          ],
          dataSource: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          webSite: [
            { required: true, message: '官网网址不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '地址不能为空', trigger: 'blur' }
          ],
          phones: [
            { required: true, message: '联系电话列表不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' },
            { validator: validateEmail, trigger: 'blur' }
          ],
          content: [
            { required: true, message: '简介不能为空', trigger: 'blur' }
          ],
          legalPersonName: [
            { required: true, message: '企业法人不能为空', trigger: 'blur' }
          ],
          renameFlag: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          oldName: [
            { required: true, message: '历史名称不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          tycUpdateTime: [
            { required: true, message: '出资时间不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
          ],
          oldEnterpriseId: [
            { required: true, message: '旧企业ID不能为空', trigger: 'blur' }
          ],
          newName: [
            { required: true, message: '新企业名称不能为空', trigger: 'blur' }
          ],
          newEnterpriseId: [
            { required: true, message: '新企业ID不能为空', trigger: 'blur' }
          ],
          tagList: [
            { required: true, message: '标签列表不能为空', trigger: 'blur' }
          ],
          historyList: [
            { required: true, message: '曾用名列表不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/hightechzoneenterpriseinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseName = data.highTechZoneEnterpriseInfo.enterpriseName
                this.dataForm.organizationCode = data.highTechZoneEnterpriseInfo.organizationCode
                this.dataForm.businessLicenseNo = data.highTechZoneEnterpriseInfo.businessLicenseNo
                this.dataForm.taxNo = data.highTechZoneEnterpriseInfo.taxNo
                this.dataForm.esDate = data.highTechZoneEnterpriseInfo.esDate
                this.dataForm.regCap = data.highTechZoneEnterpriseInfo.regCap
                this.dataForm.entryDate = data.highTechZoneEnterpriseInfo.entryDate
                this.dataForm.createtime = data.highTechZoneEnterpriseInfo.createtime
                this.dataForm.creditCode = data.highTechZoneEnterpriseInfo.creditCode
                this.dataForm.industryType = data.highTechZoneEnterpriseInfo.industryType
                this.dataForm.dataState = data.highTechZoneEnterpriseInfo.dataState
                this.dataForm.updateTime = data.highTechZoneEnterpriseInfo.updateTime
                this.dataForm.province = data.highTechZoneEnterpriseInfo.province
                this.dataForm.city = data.highTechZoneEnterpriseInfo.city
                this.dataForm.regTime = data.highTechZoneEnterpriseInfo.regTime
                this.dataForm.tycEnterpriseid = data.highTechZoneEnterpriseInfo.tycEnterpriseid
                this.dataForm.status = data.highTechZoneEnterpriseInfo.status
                this.dataForm.dataSource = data.highTechZoneEnterpriseInfo.dataSource
                this.dataForm.webSite = data.highTechZoneEnterpriseInfo.webSite
                this.dataForm.address = data.highTechZoneEnterpriseInfo.address
                this.dataForm.phones = data.highTechZoneEnterpriseInfo.phones
                this.dataForm.email = data.highTechZoneEnterpriseInfo.email
                this.dataForm.content = data.highTechZoneEnterpriseInfo.content
                this.dataForm.legalPersonName = data.highTechZoneEnterpriseInfo.legalPersonName
                this.dataForm.renameFlag = data.highTechZoneEnterpriseInfo.renameFlag
                this.dataForm.oldName = data.highTechZoneEnterpriseInfo.oldName
                this.dataForm.remark = data.highTechZoneEnterpriseInfo.remark
                this.dataForm.tycUpdateTime = data.highTechZoneEnterpriseInfo.tycUpdateTime
                this.dataForm.score = data.highTechZoneEnterpriseInfo.score
                this.dataForm.version = data.highTechZoneEnterpriseInfo.version
                this.dataForm.oldEnterpriseId = data.highTechZoneEnterpriseInfo.oldEnterpriseId
                this.dataForm.newName = data.highTechZoneEnterpriseInfo.newName
                this.dataForm.newEnterpriseId = data.highTechZoneEnterpriseInfo.newEnterpriseId
                this.dataForm.tagList = data.highTechZoneEnterpriseInfo.tagList
                this.dataForm.historyList = data.highTechZoneEnterpriseInfo.historyList
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
              url: this.$http.adornUrl(`/spider/hightechzoneenterpriseinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseName': this.dataForm.enterpriseName,
                'organizationCode': this.dataForm.organizationCode,
                'businessLicenseNo': this.dataForm.businessLicenseNo,
                'taxNo': this.dataForm.taxNo,
                'esDate': this.dataForm.esDate,
                'regCap': this.dataForm.regCap,
                'entryDate': this.dataForm.entryDate,
                'createtime': this.dataForm.createtime,
                'creditCode': this.dataForm.creditCode,
                'industryType': this.dataForm.industryType,
                'dataState': this.dataForm.dataState,
                'updateTime': this.dataForm.updateTime,
                'province': this.dataForm.province,
                'city': this.dataForm.city,
                'regTime': this.dataForm.regTime,
                'tycEnterpriseid': this.dataForm.tycEnterpriseid,
                'status': this.dataForm.status,
                'dataSource': this.dataForm.dataSource,
                'webSite': this.dataForm.webSite,
                'address': this.dataForm.address,
                'phones': this.dataForm.phones,
                'email': this.dataForm.email,
                'content': this.dataForm.content,
                'legalPersonName': this.dataForm.legalPersonName,
                'renameFlag': this.dataForm.renameFlag,
                'oldName': this.dataForm.oldName,
                'remark': this.dataForm.remark,
                'tycUpdateTime': this.dataForm.tycUpdateTime,
                'score': this.dataForm.score,
                'version': this.dataForm.version,
                'oldEnterpriseId': this.dataForm.oldEnterpriseId,
                'newName': this.dataForm.newName,
                'newEnterpriseId': this.dataForm.newEnterpriseId,
                'tagList': this.dataForm.tagList,
                'historyList': this.dataForm.historyList
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
