<template>
  <el-dialog
    width="780px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="被投资法定代表人" prop="legalPerson">
            <el-input v-model="dataForm.legalPerson" placeholder="被投资法定代表人"></el-input>
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
          <el-form-item label="注册资本" prop="invAmount">
            <el-input v-model="dataForm.invAmount" placeholder="注册资本"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="被投资公司名称" prop="cmpName">
            <el-input v-model="dataForm.cmpName" placeholder="被投资公司名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="投资占比" prop="invRatio">
            <el-input v-model="dataForm.invRatio" placeholder="投资占比"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="状态" prop="status">
            <el-input v-model="dataForm.status" placeholder="状态"></el-input>
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
      <!--
      <el-form-item label="天眼查地址" prop="url">
        <el-input v-model="dataForm.url" placeholder="天眼查地址"></el-input>
      </el-form-item>
      -->
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isPercentage } from '@/utils/validate'
  export default {
    data () {
      /*
      const validateUrl = function (rule, value, callback) {
        if (!isURL(value)) {
          callback(new Error('网址格式错误'))
        } else {
          callback()
        }
      }
      */
      const validatePercentage = function (rule, value, callback) {
        if (!isPercentage(value)) {
          callback(new Error('请输入百分比数值，最多两位小数'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          entName: '',
          regTime: '',
          legalPerson: '',
          invAmount: '',
          cmpName: '',
          invRatio: '',
          status: '',
          regCap: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          url: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业（机构）名称不能为空', trigger: 'blur' }
          ],
          regTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
          ],
          legalPerson: [
            { required: true, message: '被投资法定代表人不能为空', trigger: 'blur' }
          ],
          invAmount: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' }
          ],
          cmpName: [
            { required: true, message: '被投资公司名称不能为空', trigger: 'blur' }
          ],
          invRatio: [
            { required: true, message: '投资占比不能为空', trigger: 'blur' },
            { validator: validatePercentage, trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          /* regCap: [
            { required: true, message: '（已废弃）不能为空', trigger: 'blur' }
          ], */
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
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
              url: this.$http.adornUrl(`/spider/rpttninvest/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnInvest.enterpriseId
                this.dataForm.entName = data.rptTnInvest.entName
                this.dataForm.regTime = data.rptTnInvest.regTime
                this.dataForm.legalPerson = data.rptTnInvest.legalPerson
                this.dataForm.invAmount = data.rptTnInvest.invAmount
                this.dataForm.cmpName = data.rptTnInvest.cmpName
                this.dataForm.invRatio = data.rptTnInvest.invRatio
                this.dataForm.status = data.rptTnInvest.status
                this.dataForm.regCap = data.rptTnInvest.regCap
                this.dataForm.creator = data.rptTnInvest.creator
                this.dataForm.createTime = data.rptTnInvest.createTime
                this.dataForm.updater = data.rptTnInvest.updater
                this.dataForm.updateTime = data.rptTnInvest.updateTime
                this.dataForm.dataState = data.rptTnInvest.dataState
                this.dataForm.url = data.rptTnInvest.url
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
              url: this.$http.adornUrl(`/spider/rpttninvest/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'regTime': this.dataForm.regTime,
                'legalPerson': this.dataForm.legalPerson,
                'invAmount': this.dataForm.invAmount,
                'cmpName': this.dataForm.cmpName,
                'invRatio': this.dataForm.invRatio,
                'status': this.dataForm.status,
                'regCap': this.dataForm.regCap,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'url': this.dataForm.url
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
