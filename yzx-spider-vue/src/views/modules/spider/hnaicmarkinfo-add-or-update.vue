<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!--
    <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item>
    -->
    <el-form-item label="企业名称" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="驰名商标ID" prop="markId">
      <el-input v-model="dataForm.markId" placeholder="驰名商标ID"></el-input>
    </el-form-item>
    <el-form-item label="商标类型" prop="markType">
      <el-input v-model="dataForm.markType" placeholder="商标类型"></el-input>
    </el-form-item>
    <el-form-item label="商标名称" prop="markName">
      <el-input v-model="dataForm.markName" placeholder="商标名称"></el-input>
    </el-form-item>
    <el-form-item label="商标通过号" prop="markPassNumb">
      <el-input v-model="dataForm.markPassNumb" placeholder="商标通过号"></el-input>
    </el-form-item>
    <el-form-item label="持有人" prop="blongToEnterprise">
      <el-input v-model="dataForm.blongToEnterprise" placeholder="持有人"></el-input>
    </el-form-item>
    <el-form-item label="核定商品/服务" prop="markToPro">
      <el-input v-model="dataForm.markToPro" placeholder="核定商品/服务"></el-input>
    </el-form-item>
    <el-form-item label="认定时间" prop="selectTime">
      <el-input v-model="dataForm.selectTime" placeholder="认定时间"></el-input>
    </el-form-item>
    <el-form-item label="所在地" prop="enterpriseAddr">
      <el-input v-model="dataForm.enterpriseAddr" placeholder="所在地"></el-input>
    </el-form-item>
    <!--
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
    -->
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
          markId: '',
          markType: '',
          markName: '',
          markPassNumb: '',
          blongToEnterprise: '',
          markToPro: '',
          selectTime: '',
          enterpriseAddr: '',
          dataSource: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          markId: [
            { required: true, message: '驰名商标ID不能为空', trigger: 'blur' }
          ],
          markType: [
            { required: true, message: '商标类型不能为空', trigger: 'blur' }
          ],
          markName: [
            { required: true, message: '商标名称不能为空', trigger: 'blur' }
          ],
          markPassNumb: [
            { required: true, message: '商标通过号不能为空', trigger: 'blur' }
          ],
          blongToEnterprise: [
            { required: true, message: '持有人不能为空', trigger: 'blur' }
          ],
          markToPro: [
            { required: true, message: '核定商品/服务不能为空', trigger: 'blur' }
          ],
          selectTime: [
            { required: true, message: '认定时间不能为空', trigger: 'blur' }
          ],
          enterpriseAddr: [
            { required: true, message: '所在地不能为空', trigger: 'blur' }
          ],
          dataSource: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/hnaicmarkinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.hnaicMarkInfo.enterpriseId
                this.dataForm.entName = data.hnaicMarkInfo.entName
                this.dataForm.markId = data.hnaicMarkInfo.markId
                this.dataForm.markType = data.hnaicMarkInfo.markType
                this.dataForm.markName = data.hnaicMarkInfo.markName
                this.dataForm.markPassNumb = data.hnaicMarkInfo.markPassNumb
                this.dataForm.blongToEnterprise = data.hnaicMarkInfo.blongToEnterprise
                this.dataForm.markToPro = data.hnaicMarkInfo.markToPro
                this.dataForm.selectTime = data.hnaicMarkInfo.selectTime
                this.dataForm.enterpriseAddr = data.hnaicMarkInfo.enterpriseAddr
                this.dataForm.dataSource = data.hnaicMarkInfo.dataSource
                this.dataForm.creator = data.hnaicMarkInfo.creator
                this.dataForm.createTime = data.hnaicMarkInfo.createTime
                this.dataForm.updater = data.hnaicMarkInfo.updater
                this.dataForm.updateTime = data.hnaicMarkInfo.updateTime
                this.dataForm.dataState = data.hnaicMarkInfo.dataState
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
              url: this.$http.adornUrl(`/spider/hnaicmarkinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'markId': this.dataForm.markId,
                'markType': this.dataForm.markType,
                'markName': this.dataForm.markName,
                'markPassNumb': this.dataForm.markPassNumb,
                'blongToEnterprise': this.dataForm.blongToEnterprise,
                'markToPro': this.dataForm.markToPro,
                'selectTime': this.dataForm.selectTime,
                'enterpriseAddr': this.dataForm.enterpriseAddr,
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
