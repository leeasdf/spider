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
    <el-form-item label="时间" prop="date">
      <el-input v-model="dataForm.date" placeholder="时间"></el-input>
    </el-form-item>
    <el-form-item label="轮次" prop="time">
      <el-input v-model="dataForm.time" placeholder="轮次"></el-input>
    </el-form-item>
    <el-form-item label="估值" prop="price">
      <el-input v-model="dataForm.price" placeholder="估值"></el-input>
    </el-form-item>
    <el-form-item label="金额" prop="amount">
      <el-input v-model="dataForm.amount" placeholder="金额"></el-input>
    </el-form-item>
    <el-form-item label="比例" prop="perice">
      <el-input v-model="dataForm.perice" placeholder="比例"></el-input>
    </el-form-item>
    <el-form-item label="投资方" prop="company">
      <el-input v-model="dataForm.company" placeholder="投资方"></el-input>
    </el-form-item>
    <el-form-item label="新闻来源" prop="news">
      <el-input v-model="dataForm.news" placeholder="新闻来源"></el-input>
    </el-form-item>
    <el-form-item label="新闻URL" prop="newsurl">
      <el-input v-model="dataForm.newsurl" placeholder="新闻URL"></el-input>
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
          date: '',
          time: '',
          price: '',
          amount: '',
          perice: '',
          company: '',
          news: '',
          newsurl: '',
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
          date: [
            { required: true, message: '时间不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '轮次不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '估值不能为空', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '金额不能为空', trigger: 'blur' }
          ],
          perice: [
            { required: true, message: '比例不能为空', trigger: 'blur' }
          ],
          company: [
            { required: true, message: '投资方不能为空', trigger: 'blur' }
          ],
          news: [
            { required: true, message: '新闻来源不能为空', trigger: 'blur' }
          ],
          newsurl: [
            { required: true, message: '新闻URL不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnfinance/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnFinance.enterpriseId
                this.dataForm.entName = data.rptTnFinance.entName
                this.dataForm.date = data.rptTnFinance.date
                this.dataForm.time = data.rptTnFinance.time
                this.dataForm.price = data.rptTnFinance.price
                this.dataForm.amount = data.rptTnFinance.amount
                this.dataForm.perice = data.rptTnFinance.perice
                this.dataForm.company = data.rptTnFinance.company
                this.dataForm.news = data.rptTnFinance.news
                this.dataForm.newsurl = data.rptTnFinance.newsurl
                this.dataForm.creator = data.rptTnFinance.creator
                this.dataForm.createTime = data.rptTnFinance.createTime
                this.dataForm.updater = data.rptTnFinance.updater
                this.dataForm.updateTime = data.rptTnFinance.updateTime
                this.dataForm.dataState = data.rptTnFinance.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnfinance/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'date': this.dataForm.date,
                'time': this.dataForm.time,
                'price': this.dataForm.price,
                'amount': this.dataForm.amount,
                'perice': this.dataForm.perice,
                'company': this.dataForm.company,
                'news': this.dataForm.news,
                'newsurl': this.dataForm.newsurl,
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
