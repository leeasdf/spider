<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="企业名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="行业分类" prop="industryClassification">
      <el-input v-model="dataForm.industryClassification" placeholder="行业分类"></el-input>
    </el-form-item>
    <el-form-item label="产值年份" prop="year">
      <!-- <el-input v-model="dataForm.year" placeholder="产值年份"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.year" placeholder="产值年份" value-format="yyyy"></el-date-picker>
    </el-form-item>
    <el-form-item label="产值" prop="output">
      <el-input v-model="dataForm.output" placeholder="产值"></el-input>
    </el-form-item>
    <!-- <el-form-item label="会员ID" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员ID"></el-input>
    </el-form-item> -->
    <!-- <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item> -->
    
    <!-- <el-form-item label="修改人ID" prop="updater">
      <el-input v-model="dataForm.updater" placeholder="修改人ID"></el-input>
    </el-form-item> -->
    
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
          industrialOutputId: 0,
          enterpriseName: '',
          industryClassification: '',
          year: '',
          output: '',
          memId: '',
          updateTime: '',
          creator: '',
          updater: '',
          createTime: '',
          dataState: '',
          enterpriseId: ''
        },
        dataRule: {
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          industryClassification: [
            { required: true, message: '行业分类不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '产值年份不能为空', trigger: 'blur' }
          ],
          output: [
            { required: true, message: '产值不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          /* memId: [
            { required: true, message: '会员ID不能为空', trigger: 'blur' }
          ], */
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
         /* creator: [
            { required: true, message: '创建人ID不能为空', trigger: 'blur' }
          ],
          updater: [
            { required: true, message: '修改人ID不能为空', trigger: 'blur' }
          ], */
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ]
          /* enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ] */
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.industrialOutputId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.industrialOutputId) {
            this.$http({
              url: this.$http.adornUrl(`/spider/entindustrialoutput/info/${this.dataForm.industrialOutputId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseName = data.entIndustrialOutput.enterpriseName
                this.dataForm.industryClassification = data.entIndustrialOutput.industryClassification
                this.dataForm.year = data.entIndustrialOutput.year
                this.dataForm.output = data.entIndustrialOutput.output
                this.dataForm.memId = data.entIndustrialOutput.memId
                this.dataForm.updateTime = data.entIndustrialOutput.updateTime
                this.dataForm.creator = data.entIndustrialOutput.creator
                this.dataForm.updater = data.entIndustrialOutput.updater
                this.dataForm.createTime = data.entIndustrialOutput.createTime
                this.dataForm.dataState = data.entIndustrialOutput.dataState
                this.dataForm.enterpriseId = data.entIndustrialOutput.enterpriseId
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
              url: this.$http.adornUrl(`/spider/entindustrialoutput/${!this.dataForm.industrialOutputId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'industrialOutputId': this.dataForm.industrialOutputId || undefined,
                'enterpriseName': this.dataForm.enterpriseName,
                'industryClassification': this.dataForm.industryClassification,
                'year': this.dataForm.year,
                'output': this.dataForm.output,
                'memId': this.dataForm.memId,
                'updateTime': this.dataForm.updateTime,
                'creator': this.dataForm.creator,
                'updater': this.dataForm.updater,
                'createTime': this.dataForm.createTime,
                'dataState': this.dataForm.dataState,
                'enterpriseId': this.dataForm.enterpriseId
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
