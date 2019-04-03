<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <el-form-item label="工业地产单位" prop="industrialEstateUnit">
      <el-input v-model="dataForm.industrialEstateUnit" placeholder="工业地产单位"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="company">
      <el-input v-model="dataForm.company" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="面积（平方米）" prop="area">
      <el-input v-model="dataForm.area" placeholder="面积（平方米）"></el-input>
    </el-form-item>
    <el-form-item label="楼栋及房号" prop="address">
      <el-input v-model="dataForm.address" placeholder="楼栋及房号"></el-input>
    </el-form-item>
    <el-form-item label="主要产品及服务" prop="mainProduct">
      <el-input v-model="dataForm.mainProduct" placeholder="主要产品及服务"></el-input>
    </el-form-item>
    <el-form-item label="购入还是承租" prop="belongType">
      <el-input v-model="dataForm.belongType" placeholder="购入还是承租"></el-input>
    </el-form-item>
    <el-form-item label="是否转租" prop="isSublet">
      <el-input v-model="dataForm.isSublet" placeholder="是否转租"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="note">
      <el-input v-model="dataForm.note" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="所属会员" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="所属会员"></el-input>
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
          industrialEstateUnit: '',
          company: '',
          area: '',
          address: '',
          mainProduct: '',
          belongType: '',
          isSublet: '',
          note: '',
          memId: '',
          enterpriseId: ''
        },
        dataRule: {
          industrialEstateUnit: [
            { required: true, message: '工业地产单位不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '面积（平方米）不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '楼栋及房号不能为空', trigger: 'blur' }
          ],
          mainProduct: [
            { required: true, message: '主要产品及服务不能为空', trigger: 'blur' }
          ],
          belongType: [
            { required: true, message: '购入还是承租不能为空', trigger: 'blur' }
          ],
          isSublet: [
            { required: true, message: '是否转租不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          memId: [
            { required: true, message: '所属会员不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enthightechindustrialestate/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.industrialEstateUnit = data.entHighTechIndustrialEstate.industrialEstateUnit
                this.dataForm.company = data.entHighTechIndustrialEstate.company
                this.dataForm.area = data.entHighTechIndustrialEstate.area
                this.dataForm.address = data.entHighTechIndustrialEstate.address
                this.dataForm.mainProduct = data.entHighTechIndustrialEstate.mainProduct
                this.dataForm.belongType = data.entHighTechIndustrialEstate.belongType
                this.dataForm.isSublet = data.entHighTechIndustrialEstate.isSublet
                this.dataForm.note = data.entHighTechIndustrialEstate.note
                this.dataForm.memId = data.entHighTechIndustrialEstate.memId
                this.dataForm.enterpriseId = data.entHighTechIndustrialEstate.enterpriseId
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
              url: this.$http.adornUrl(`/spider/enthightechindustrialestate/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'industrialEstateUnit': this.dataForm.industrialEstateUnit,
                'company': this.dataForm.company,
                'area': this.dataForm.area,
                'address': this.dataForm.address,
                'mainProduct': this.dataForm.mainProduct,
                'belongType': this.dataForm.belongType,
                'isSublet': this.dataForm.isSublet,
                'note': this.dataForm.note,
                'memId': this.dataForm.memId,
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
