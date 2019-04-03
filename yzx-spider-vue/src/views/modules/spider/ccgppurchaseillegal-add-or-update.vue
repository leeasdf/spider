<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码（或）组织机构代码" prop="creditCode">
      <el-input v-model="dataForm.creditCode" placeholder="统一社会信用代码（或）组织机构代码"></el-input>
    </el-form-item>
    <el-form-item label="企业地址" prop="adress">
      <el-input v-model="dataForm.adress" placeholder="企业地址"></el-input>
    </el-form-item>
    <el-form-item label="严重违法失信行为的具体情形" prop="illegalDetail">
      <el-input v-model="dataForm.illegalDetail" placeholder="严重违法失信行为的具体情形"></el-input>
    </el-form-item>
    <el-form-item label="处罚结果" prop="punishResult">
      <el-input v-model="dataForm.punishResult" placeholder="处罚结果"></el-input>
    </el-form-item>
    <el-form-item label="处罚依据" prop="base">
      <el-input v-model="dataForm.base" placeholder="处罚依据"></el-input>
    </el-form-item>
    <el-form-item label="处罚日期" prop="punishDate">
      <el-input v-model="dataForm.punishDate" placeholder="处罚日期"></el-input>
    </el-form-item>
    <el-form-item label="公布日期" prop="publishDate">
      <el-input v-model="dataForm.publishDate" placeholder="公布日期"></el-input>
    </el-form-item>
    <el-form-item label="执法单位" prop="authority">
      <el-input v-model="dataForm.authority" placeholder="执法单位"></el-input>
    </el-form-item>
    <el-form-item label="数据来源" prop="dataSource">
      <el-input v-model="dataForm.dataSource" placeholder="数据来源"></el-input>
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
          creditCode: '',
          adress: '',
          illegalDetail: '',
          punishResult: '',
          base: '',
          punishDate: '',
          publishDate: '',
          authority: '',
          dataSource: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          creditCode: [
            { required: true, message: '统一社会信用代码（或）组织机构代码不能为空', trigger: 'blur' }
          ],
          adress: [
            { required: true, message: '企业地址不能为空', trigger: 'blur' }
          ],
          illegalDetail: [
            { required: true, message: '严重违法失信行为的具体情形不能为空', trigger: 'blur' }
          ],
          punishResult: [
            { required: true, message: '处罚结果不能为空', trigger: 'blur' }
          ],
          base: [
            { required: true, message: '处罚依据不能为空', trigger: 'blur' }
          ],
          punishDate: [
            { required: true, message: '处罚日期不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '公布日期不能为空', trigger: 'blur' }
          ],
          authority: [
            { required: true, message: '执法单位不能为空', trigger: 'blur' }
          ],
          dataSource: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/ccgppurchaseillegal/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.ccgpPurchaseIllegal.enterpriseId
                this.dataForm.entName = data.ccgpPurchaseIllegal.entName
                this.dataForm.creditCode = data.ccgpPurchaseIllegal.creditCode
                this.dataForm.adress = data.ccgpPurchaseIllegal.adress
                this.dataForm.illegalDetail = data.ccgpPurchaseIllegal.illegalDetail
                this.dataForm.punishResult = data.ccgpPurchaseIllegal.punishResult
                this.dataForm.base = data.ccgpPurchaseIllegal.base
                this.dataForm.punishDate = data.ccgpPurchaseIllegal.punishDate
                this.dataForm.publishDate = data.ccgpPurchaseIllegal.publishDate
                this.dataForm.authority = data.ccgpPurchaseIllegal.authority
                this.dataForm.dataSource = data.ccgpPurchaseIllegal.dataSource
                this.dataForm.creator = data.ccgpPurchaseIllegal.creator
                this.dataForm.createTime = data.ccgpPurchaseIllegal.createTime
                this.dataForm.updater = data.ccgpPurchaseIllegal.updater
                this.dataForm.updateTime = data.ccgpPurchaseIllegal.updateTime
                this.dataForm.dataState = data.ccgpPurchaseIllegal.dataState
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
              url: this.$http.adornUrl(`/spider/ccgppurchaseillegal/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'creditCode': this.dataForm.creditCode,
                'adress': this.dataForm.adress,
                'illegalDetail': this.dataForm.illegalDetail,
                'punishResult': this.dataForm.punishResult,
                'base': this.dataForm.base,
                'punishDate': this.dataForm.punishDate,
                'publishDate': this.dataForm.publishDate,
                'authority': this.dataForm.authority,
                'dataSource': this.dataForm.dataSource,
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
