<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="产品" prop="product">
      <el-input v-model="dataForm.product" placeholder="产品"></el-input>
    </el-form-item>
    <el-form-item label="地区" prop="area">
      <el-input v-model="dataForm.area" placeholder="地区"></el-input>
    </el-form-item>
    <el-form-item label="当前轮次" prop="turn">
      <el-input v-model="dataForm.turn" placeholder="当前轮次"></el-input>
    </el-form-item>
    <el-form-item label="行业" prop="industry">
      <el-input v-model="dataForm.industry" placeholder="行业"></el-input>
    </el-form-item>
    <el-form-item label="业务" prop="business">
      <el-input v-model="dataForm.business" placeholder="业务"></el-input>
    </el-form-item>
    <el-form-item label="成立时间" prop="datetime">
      <el-input v-model="dataForm.datetime" placeholder="成立时间"></el-input>
    </el-form-item>
    <el-form-item label="估值" prop="price">
      <el-input v-model="dataForm.price" placeholder="估值"></el-input>
    </el-form-item>
    <el-form-item label="创建人ID" prop="creator">
      <el-input v-model="dataForm.creator" placeholder="创建人ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人ID" prop="updater">
      <el-input v-model="dataForm.updater" placeholder="修改人ID"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="数据状态：1-正常 0-删除" prop="dataState">
      <el-input v-model="dataForm.dataState" placeholder="数据状态：1-正常 0-删除"></el-input>
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
          enterpriseId: '',
          entName: '',
          product: '',
          area: '',
          turn: '',
          industry: '',
          business: '',
          datetime: '',
          price: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          product: [
            { required: true, message: '产品不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '地区不能为空', trigger: 'blur' }
          ],
          turn: [
            { required: true, message: '当前轮次不能为空', trigger: 'blur' }
          ],
          industry: [
            { required: true, message: '行业不能为空', trigger: 'blur' }
          ],
          business: [
            { required: true, message: '业务不能为空', trigger: 'blur' }
          ],
          datetime: [
            { required: true, message: '成立时间不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '估值不能为空', trigger: 'blur' }
          ],
          creator: [
            { required: true, message: '创建人ID不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updater: [
            { required: true, message: '修改人ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttncompetitive/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnCompetitive.enterpriseId
                this.dataForm.entName = data.rptTnCompetitive.entName
                this.dataForm.product = data.rptTnCompetitive.product
                this.dataForm.area = data.rptTnCompetitive.area
                this.dataForm.turn = data.rptTnCompetitive.turn
                this.dataForm.industry = data.rptTnCompetitive.industry
                this.dataForm.business = data.rptTnCompetitive.business
                this.dataForm.datetime = data.rptTnCompetitive.datetime
                this.dataForm.price = data.rptTnCompetitive.price
                this.dataForm.creator = data.rptTnCompetitive.creator
                this.dataForm.createTime = data.rptTnCompetitive.createTime
                this.dataForm.updater = data.rptTnCompetitive.updater
                this.dataForm.updateTime = data.rptTnCompetitive.updateTime
                this.dataForm.dataState = data.rptTnCompetitive.dataState
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
              url: this.$http.adornUrl(`/spider/rpttncompetitive/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'product': this.dataForm.product,
                'area': this.dataForm.area,
                'turn': this.dataForm.turn,
                'industry': this.dataForm.industry,
                'business': this.dataForm.business,
                'datetime': this.dataForm.datetime,
                'price': this.dataForm.price,
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
