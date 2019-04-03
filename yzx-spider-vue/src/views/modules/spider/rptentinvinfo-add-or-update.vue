<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    
    <el-form-item label="企业(机构)名称" prop="entname">
      <el-input v-model="dataForm.entname" placeholder="企业(机构)名称"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="regno">
      <el-input v-model="dataForm.regno" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="企业(机构)类型" prop="enttype">
      <el-input v-model="dataForm.enttype" placeholder="企业(机构)类型"></el-input>
    </el-form-item>
    <el-form-item label="注册资本" prop="regcap">
      <el-input v-model="dataForm.regcap" placeholder="注册资本"></el-input>
    </el-form-item>
    <el-form-item label="注册资本币种" prop="regcapcur">
      <el-input v-model="dataForm.regcapcur" placeholder="注册资本币种"></el-input>
    </el-form-item>
    <el-form-item label="企业状态" prop="entstatus">
      <el-input v-model="dataForm.entstatus" placeholder="企业状态"></el-input>
    </el-form-item>
    <el-form-item label="注销日期" prop="candate">
      <el-date-picker v-model="dataForm.candate" value-format="yyyy-MM-dd" placeholder="注销日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="吊销日期" prop="revdate">
      <el-date-picker v-model="dataForm.revdate" value-format="yyyy-MM-dd" placeholder="吊销日期"></el-date-picker>
    </el-form-item>
    <el-form-item label="登记机关" prop="regorg">
      <el-input v-model="dataForm.regorg" placeholder="登记机关"></el-input>
    </el-form-item>
    <el-form-item label="实缴资本" prop="subconam">
      <el-input v-model="dataForm.subconam" placeholder="实缴资本"></el-input>
    </el-form-item>
    <el-form-item label="认缴出资币种" prop="congrocur">
      <el-input v-model="dataForm.congrocur" placeholder="认缴出资币种"></el-input>
    </el-form-item>
    <el-form-item label="出资方式" prop="conform">
      <el-input v-model="dataForm.conform" placeholder="出资方式"></el-input>
    </el-form-item>
    <el-form-item label="出资比例" prop="fundedratio">
      <el-input v-model="dataForm.fundedratio" placeholder="出资比例"></el-input>
    </el-form-item>
    <el-form-item label="企业总数量" prop="binvvamount">
      <el-input v-model="dataForm.binvvamount" placeholder="企业总数量"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="法定代表人姓名"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataState">
      <el-radio-group v-model="dataForm.dataState">
        <el-radio :label="1">正常</el-radio>
        <el-radio :label="0">删除</el-radio>
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
  import { isInterger, isPercentage, isFloat } from '@/utils/validate'
  export default {
    data () {
      const validateInterger = function (rule, value, callback) {
        if (!isInterger(value)) {
          callback(new Error('请输入大于0的正整数'))
        } else {
          callback()
        }
      }
      const validatePercentage = function (rule, value, callback) {
        if (!isPercentage(value)) {
          callback(new Error('请输入百分比正确格式，最多包含两位小数'))
        } else {
          callback()
        }
      }
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
          id: 0,
          memId: '',
          enterpriseId: '',
          entname: '',
          regno: '',
          enttype: '',
          regcap: '',
          regcapcur: '',
          entstatus: '',
          candate: '',
          revdate: '',
          regorg: '',
          subconam: '',
          congrocur: '',
          conform: '',
          fundedratio: '',
          binvvamount: '',
          name: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
         /* memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ], */
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          entname: [
            { required: true, message: '企业(机构)名称不能为空', trigger: 'blur' }
          ],
          regno: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          enttype: [
            { required: true, message: '企业(机构)类型不能为空', trigger: 'blur' }
          ],
          regcap: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' },
            { validator: validataFloat, trigger: 'blur' }
          ],
          regcapcur: [
            { required: true, message: '注册资本币种不能为空', trigger: 'blur' }
          ],
          entstatus: [
            { required: true, message: '企业状态不能为空', trigger: 'blur' }
          ],
          candate: [
            { required: true, message: '注销日期不能为空', trigger: 'blur' }
          ],
          revdate: [
            { required: true, message: '吊销日期不能为空', trigger: 'blur' }
          ],
          regorg: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          subconam: [
            { required: true, message: '实缴资本不能为空', trigger: 'blur' },
            { validator: validataFloat, trigger: 'blur' }
          ],
          congrocur: [
            { required: true, message: '认缴出资币种不能为空', trigger: 'blur' }
          ],
          conform: [
            { required: true, message: '出资方式不能为空', trigger: 'blur' }
          ],
          fundedratio: [
            { required: true, message: '出资比例不能为空', trigger: 'blur' },
            { validator: validatePercentage, trigger: 'blur' }
          ],
          binvvamount: [
            { required: true, message: '企业总数量不能为空', trigger: 'blur' },
            { validator: validateInterger, trigger: 'blur' }
          ],
          name: [
            { required: true, message: '法定代表人姓名不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptentinvinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptEntinvInfo.memId
                this.dataForm.enterpriseId = data.rptEntinvInfo.enterpriseId
                this.dataForm.entname = data.rptEntinvInfo.entname
                this.dataForm.regno = data.rptEntinvInfo.regno
                this.dataForm.enttype = data.rptEntinvInfo.enttype
                this.dataForm.regcap = data.rptEntinvInfo.regcap
                this.dataForm.regcapcur = data.rptEntinvInfo.regcapcur
                this.dataForm.entstatus = data.rptEntinvInfo.entstatus
                this.dataForm.candate = data.rptEntinvInfo.candate
                this.dataForm.revdate = data.rptEntinvInfo.revdate
                this.dataForm.regorg = data.rptEntinvInfo.regorg
                this.dataForm.subconam = data.rptEntinvInfo.subconam
                this.dataForm.congrocur = data.rptEntinvInfo.congrocur
                this.dataForm.conform = data.rptEntinvInfo.conform
                this.dataForm.fundedratio = data.rptEntinvInfo.fundedratio
                this.dataForm.binvvamount = data.rptEntinvInfo.binvvamount
                this.dataForm.name = data.rptEntinvInfo.name
                this.dataForm.creator = data.rptEntinvInfo.creator
                this.dataForm.createTime = data.rptEntinvInfo.createTime
                this.dataForm.updater = data.rptEntinvInfo.updater
                this.dataForm.updateTime = data.rptEntinvInfo.updateTime
                this.dataForm.dataState = data.rptEntinvInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptentinvinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'entname': this.dataForm.entname,
                'regno': this.dataForm.regno,
                'enttype': this.dataForm.enttype,
                'regcap': this.dataForm.regcap,
                'regcapcur': this.dataForm.regcapcur,
                'entstatus': this.dataForm.entstatus,
                'candate': this.dataForm.candate,
                'revdate': this.dataForm.revdate,
                'regorg': this.dataForm.regorg,
                'subconam': this.dataForm.subconam,
                'congrocur': this.dataForm.congrocur,
                'conform': this.dataForm.conform,
                'fundedratio': this.dataForm.fundedratio,
                'binvvamount': this.dataForm.binvvamount,
                'name': this.dataForm.name,
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
