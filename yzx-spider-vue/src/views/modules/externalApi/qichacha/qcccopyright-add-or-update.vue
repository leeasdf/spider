<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="分类号" prop="category">
      <el-input v-model="dataForm.category" placeholder="分类号"></el-input>
    </el-form-item>
    <el-form-item label="发布日期" prop="publishDate">
      <el-input v-model="dataForm.publishDate" placeholder="发布日期"></el-input>
    </el-form-item>
    <el-form-item label="版本号" prop="versionNo">
      <el-input v-model="dataForm.versionNo" placeholder="版本号"></el-input>
    </el-form-item>
    <el-form-item label="登记号" prop="registerNo">
      <el-input v-model="dataForm.registerNo" placeholder="登记号"></el-input>
    </el-form-item>
    <el-form-item label="登记批准日期" prop="registerAperDate">
      <el-input v-model="dataForm.registerAperDate" placeholder="登记批准日期"></el-input>
    </el-form-item>
    <el-form-item label="软件全称" prop="name">
      <el-input v-model="dataForm.name" placeholder="软件全称"></el-input>
    </el-form-item>
    <el-form-item label="软件简称" prop="shortName">
      <el-input v-model="dataForm.shortName" placeholder="软件简称"></el-input>
    </el-form-item>
    <el-form-item label="软件著作权人" prop="owner">
      <el-input v-model="dataForm.owner" placeholder="软件著作权人"></el-input>
    </el-form-item>
    <el-form-item label="关键字(公司名或keyNo)" prop="entName">
      <el-input v-model="dataForm.entName" placeholder="关键字(公司名或keyNo)"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="版本号" prop="version">
      <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataStatus">
      <el-input v-model="dataForm.dataStatus" placeholder="数据状态"></el-input>
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
          category: '',
          publishDate: '',
          versionNo: '',
          registerNo: '',
          registerAperDate: '',
          name: '',
          shortName: '',
          owner: '',
          entName: '',
          createTime: '',
          updateTime: '',
          remark: '',
          version: '',
          dataStatus: ''
        },
        dataRule: {
          category: [
            { required: true, message: '分类号不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '发布日期不能为空', trigger: 'blur' }
          ],
          versionNo: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
          ],
          registerNo: [
            { required: true, message: '登记号不能为空', trigger: 'blur' }
          ],
          registerAperDate: [
            { required: true, message: '登记批准日期不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '软件全称不能为空', trigger: 'blur' }
          ],
          shortName: [
            { required: true, message: '软件简称不能为空', trigger: 'blur' }
          ],
          owner: [
            { required: true, message: '软件著作权人不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '关键字(公司名或keyNo)不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
          ],
          dataStatus: [
            { required: true, message: '数据状态不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/qichacha/qcccopyright/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.category = data.qccCopyright.category
                this.dataForm.publishDate = data.qccCopyright.publishDate
                this.dataForm.versionNo = data.qccCopyright.versionNo
                this.dataForm.registerNo = data.qccCopyright.registerNo
                this.dataForm.registerAperDate = data.qccCopyright.registerAperDate
                this.dataForm.name = data.qccCopyright.name
                this.dataForm.shortName = data.qccCopyright.shortName
                this.dataForm.owner = data.qccCopyright.owner
                this.dataForm.entName = data.qccCopyright.entName
                this.dataForm.createTime = data.qccCopyright.createTime
                this.dataForm.updateTime = data.qccCopyright.updateTime
                this.dataForm.remark = data.qccCopyright.remark
                this.dataForm.version = data.qccCopyright.version
                this.dataForm.dataStatus = data.qccCopyright.dataStatus
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
              url: this.$http.adornUrl(`/qichacha/qcccopyright/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'category': this.dataForm.category,
                'publishDate': this.dataForm.publishDate,
                'versionNo': this.dataForm.versionNo,
                'registerNo': this.dataForm.registerNo,
                'registerAperDate': this.dataForm.registerAperDate,
                'name': this.dataForm.name,
                'shortName': this.dataForm.shortName,
                'owner': this.dataForm.owner,
                'entName': this.dataForm.entName,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'remark': this.dataForm.remark,
                'version': this.dataForm.version,
                'dataStatus': this.dataForm.dataStatus
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
