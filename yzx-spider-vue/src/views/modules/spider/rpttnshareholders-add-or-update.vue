<template>
  <el-dialog
    width="700px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="股东(发起人)" prop="name">
            <el-input v-model="dataForm.name" placeholder="股东(发起人)"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="认缴出资" prop="subFunding">
            <el-input v-model="dataForm.subFunding" placeholder="认缴出资"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="出资比例" prop="funRatio">
            <el-input v-model="dataForm.funRatio" placeholder="出资比例"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="出资时间" prop="amountDate">
            <el-date-picker type="date" v-model="dataForm.amountDate" placeholder="出资时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <!--
        <el-col :span="12">
          <el-form-item label="天眼查地址" prop="url">
            <el-input v-model="dataForm.url" placeholder="天眼查地址"></el-input>
          </el-form-item>
        </el-col>
        -->
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="是否大股东" prop="isMax">
            <el-radio-group v-model="dataForm.isMax">
              <el-radio label="是">是</el-radio>
              <el-radio label="否">否</el-radio>
            </el-radio-group>
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
          name: '',
          funRatio: '',
          subFunding: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: 1,
          amountDate: '',
          url: '',
          isMax: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '股东(发起人)不能为空', trigger: 'blur' }
          ],
          funRatio: [
            { required: true, message: '出资比例不能为空', trigger: 'blur' },
            { validator: validatePercentage, trigger: 'blur' }
          ],
          subFunding: [
            { required: true, message: '认缴出资不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          amountDate: [
            { required: true, message: '出资时间不能为空', trigger: 'blur' }
          ],
          isMax: [
            { required: true, message: '是否大股东不能为空', trigger: 'change' }
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
              url: this.$http.adornUrl(`/spider/rpttnshareholders/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnShareholders.enterpriseId
                this.dataForm.entName = data.rptTnShareholders.entName
                this.dataForm.name = data.rptTnShareholders.name
                this.dataForm.funRatio = data.rptTnShareholders.funRatio
                this.dataForm.subFunding = data.rptTnShareholders.subFunding
                this.dataForm.creator = data.rptTnShareholders.creator
                this.dataForm.createTime = data.rptTnShareholders.createTime
                this.dataForm.updater = data.rptTnShareholders.updater
                this.dataForm.updateTime = data.rptTnShareholders.updateTime
                this.dataForm.dataState = data.rptTnShareholders.dataState
                this.dataForm.amountDate = data.rptTnShareholders.amountDate
                this.dataForm.url = data.rptTnShareholders.url
                this.dataForm.isMax = data.rptTnShareholders.isMax
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
              url: this.$http.adornUrl(`/spider/rpttnshareholders/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'name': this.dataForm.name,
                'funRatio': this.dataForm.funRatio,
                'subFunding': this.dataForm.subFunding,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'amountDate': this.dataForm.amountDate,
                'url': this.dataForm.url,
                'isMax': this.dataForm.isMax
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
