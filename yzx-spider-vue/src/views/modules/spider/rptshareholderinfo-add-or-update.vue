<template>
  <el-dialog
    width="780px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="股东名称" prop="shaname">
          <el-input v-model="dataForm.shaname" placeholder="股东名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="实缴资本" prop="subconam">
          <el-input v-model="dataForm.subconam" placeholder="实缴资本"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="认缴出资币种" prop="regcapcur">
          <el-input v-model="dataForm.regcapcur" placeholder="认缴出资币种"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="出资方式" prop="conform">
          <el-input v-model="dataForm.conform" placeholder="出资方式"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="出资比例" prop="fundedratio">
          <el-input v-model="dataForm.fundedratio" placeholder="出资比例"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="出资日期" prop="condate">
          <el-date-picker v-model="dataForm.condate" value-format="yyyy-MM-dd" placeholder="出资日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="国别" prop="country">
          <el-input v-model="dataForm.country" placeholder="国别"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="股东总数量" prop="invamount">
          <el-input v-model="dataForm.invamount" placeholder="股东总数量"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="股东出资比例总和" prop="invsumfundedratio">
          <el-input v-model="dataForm.invsumfundedratio" placeholder="股东出资比例总和"></el-input>
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
  import { isPercentage, isFloat, isInterger } from '@/utils/validate'
  export default {
    data () {
      const validatePercentage = function (rule, value, callback) {
        if (!isPercentage(value)) {
          callback(new Error('请输入正确的百分比格式，最多保留两位小数'))
        } else {
          callback()
        }
      }
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点数'))
        } else {
          callback()
        }
      }
      const validateInterger = function (rule, value, callback) {
        if (!isInterger(value)) {
          callback(new Error('请输入大于0的正整数'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          memId: '',
          enterpriseId: '',
          shaname: '',
          subconam: '',
          regcapcur: '',
          conform: '',
          fundedratio: '',
          condate: '',
          country: '',
          invamount: '',
          invsumfundedratio: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          shaname: [
            { required: true, message: '股东名称不能为空', trigger: 'blur' }
          ],
          subconam: [
            { required: true, message: '实缴资本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          regcapcur: [
            { required: true, message: '认缴出资币种不能为空', trigger: 'blur' }
          ],
          conform: [
            { required: true, message: '出资方式不能为空', trigger: 'blur' }
          ],
          fundedratio: [
            { required: true, message: '出资比例不能为空', trigger: 'blur' },
            { validator: validatePercentage, trigger: 'blur' }
          ],
          condate: [
            { required: true, message: '出资日期不能为空', trigger: 'blur' }
          ],
          country: [
            { required: true, message: '国别不能为空', trigger: 'blur' }
          ],
          invamount: [
            { required: true, message: '股东总数量不能为空', trigger: 'blur' },
            { validator: validateInterger, trigger: 'blur' }
          ],
          invsumfundedratio: [
            { required: true, message: '股东出资比例总和不能为空', trigger: 'blur' },
            { validator: validatePercentage, trigger: 'blur' }
          ],
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
              url: this.$http.adornUrl(`/spider/rptshareholderinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptShareholderInfo.memId
                this.dataForm.enterpriseId = data.rptShareholderInfo.enterpriseId
                this.dataForm.shaname = data.rptShareholderInfo.shaname
                this.dataForm.subconam = data.rptShareholderInfo.subconam
                this.dataForm.regcapcur = data.rptShareholderInfo.regcapcur
                this.dataForm.conform = data.rptShareholderInfo.conform
                this.dataForm.fundedratio = data.rptShareholderInfo.fundedratio
                this.dataForm.condate = data.rptShareholderInfo.condate
                this.dataForm.country = data.rptShareholderInfo.country
                this.dataForm.invamount = data.rptShareholderInfo.invamount
                this.dataForm.invsumfundedratio = data.rptShareholderInfo.invsumfundedratio
                this.dataForm.creator = data.rptShareholderInfo.creator
                this.dataForm.createTime = data.rptShareholderInfo.createTime
                this.dataForm.updater = data.rptShareholderInfo.updater
                this.dataForm.updateTime = data.rptShareholderInfo.updateTime
                this.dataForm.dataState = data.rptShareholderInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptshareholderinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'shaname': this.dataForm.shaname,
                'subconam': this.dataForm.subconam,
                'regcapcur': this.dataForm.regcapcur,
                'conform': this.dataForm.conform,
                'fundedratio': this.dataForm.fundedratio,
                'condate': this.dataForm.condate,
                'country': this.dataForm.country,
                'invamount': this.dataForm.invamount,
                'invsumfundedratio': this.dataForm.invsumfundedratio,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState
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
