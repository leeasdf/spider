<template>
  <el-dialog
    width="660px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="姓名" prop="pername">
          <el-input v-model="dataForm.pername" placeholder="姓名"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="职位" prop="position">
          <el-input v-model="dataForm.position" placeholder="职位"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="dataForm.sex">
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="总人数" prop="personamount">
          <el-input v-model="dataForm.personamount" placeholder="总人数"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
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
  import { isInterger } from '@/utils/validate'
  export default {
    data () {
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
          pername: '',
          position: '',
          sex: '',
          personamount: '',
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
          pername: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          position: [
            { required: true, message: '职位不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          personamount: [
            { required: true, message: '总人数不能为空', trigger: 'blur' },
            { validator: validateInterger, trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态：1-正常 0-删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rptpersoninfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptPersonInfo.memId
                this.dataForm.enterpriseId = data.rptPersonInfo.enterpriseId
                this.dataForm.pername = data.rptPersonInfo.pername
                this.dataForm.position = data.rptPersonInfo.position
                this.dataForm.sex = data.rptPersonInfo.sex
                this.dataForm.personamount = data.rptPersonInfo.personamount
                this.dataForm.creator = data.rptPersonInfo.creator
                this.dataForm.createTime = data.rptPersonInfo.createTime
                this.dataForm.updater = data.rptPersonInfo.updater
                this.dataForm.updateTime = data.rptPersonInfo.updateTime
                this.dataForm.dataState = data.rptPersonInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rptpersoninfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'pername': this.dataForm.pername,
                'position': this.dataForm.position,
                'sex': this.dataForm.sex,
                'personamount': this.dataForm.personamount,
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
