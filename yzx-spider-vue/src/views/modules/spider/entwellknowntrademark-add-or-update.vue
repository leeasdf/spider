<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="160px">
    <!-- <el-form-item label="会员id" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员id"></el-input>
    </el-form-item> -->
    
    <el-form-item label="类别" prop="type">
      <el-input v-model="dataForm.type" placeholder="类别"></el-input>
    </el-form-item>
   <!--  <el-form-item label="序号" prop="serialNumber">
      <el-input v-model="dataForm.serialNumber" placeholder="序号"></el-input>
    </el-form-item> -->
    <el-form-item label="企业名称(商标所有人)" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称(商标所有人)"></el-input>
    </el-form-item>
    <el-form-item label="主要商品" prop="mainProduct">
      <el-input v-model="dataForm.mainProduct" placeholder="主要商品"></el-input>
    </el-form-item>
    <el-form-item label="注册时间" prop="regTime">
      <!-- <el-input v-model="dataForm.regTime" placeholder="注册时间"></el-input> -->
      <el-date-picker v-model="dataForm.regTime" value-format="yyyy-MM-dd" placeholder="注册时间"></el-date-picker>
    </el-form-item>
    <el-form-item label="区县" prop="country">
      <el-input v-model="dataForm.country" placeholder="区县"></el-input>
    </el-form-item>
    <el-form-item label="市州" prop="city">
      <el-input v-model="dataForm.city" placeholder="市州"></el-input>
    </el-form-item>
    <el-form-item label="注册号" prop="regNumber">
      <el-input v-model="dataForm.regNumber" placeholder="注册号"></el-input>
    </el-form-item>
    <el-form-item label="商标" prop="trademark">
      <el-input v-model="dataForm.trademark" placeholder="商标"></el-input>
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
          memId: '',
          enterpriseId: '',
          type: '',
          serialNumber: '',
          enterpriseName: '',
          mainProduct: '',
          regTime: '',
          country: '',
          city: '',
          regNumber: '',
          trademark: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '会员id不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          serialNumber: [
            { required: true, message: '序号不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '企业名称(商标所有人)不能为空', trigger: 'blur' }
          ],
          mainProduct: [
            { required: true, message: '主要商品不能为空', trigger: 'blur' }
          ],
          regTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
          ],
          country: [
            { required: true, message: '区县不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '市州不能为空', trigger: 'blur' }
          ],
          regNumber: [
            { required: true, message: '注册号不能为空', trigger: 'blur' }
          ],
          trademark: [
            { required: true, message: '商标不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/entwellknowntrademark/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.entWellknownTrademark.memId
                this.dataForm.enterpriseId = data.entWellknownTrademark.enterpriseId
                this.dataForm.type = data.entWellknownTrademark.type
                this.dataForm.serialNumber = data.entWellknownTrademark.serialNumber
                this.dataForm.enterpriseName = data.entWellknownTrademark.enterpriseName
                this.dataForm.mainProduct = data.entWellknownTrademark.mainProduct
                this.dataForm.regTime = data.entWellknownTrademark.regTime
                this.dataForm.country = data.entWellknownTrademark.country
                this.dataForm.city = data.entWellknownTrademark.city
                this.dataForm.regNumber = data.entWellknownTrademark.regNumber
                this.dataForm.trademark = data.entWellknownTrademark.trademark
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
              url: this.$http.adornUrl(`/spider/entwellknowntrademark/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'type': this.dataForm.type,
                'serialNumber': this.dataForm.serialNumber,
                'enterpriseName': this.dataForm.enterpriseName,
                'mainProduct': this.dataForm.mainProduct,
                'regTime': this.dataForm.regTime,
                'country': this.dataForm.country,
                'city': this.dataForm.city,
                'regNumber': this.dataForm.regNumber,
                'trademark': this.dataForm.trademark
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
