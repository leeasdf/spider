<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
    <!-- <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="作品名称" prop="title">
          <el-input v-model="dataForm.title" placeholder="作品名称"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="登记号" prop="regnum">
          <el-input v-model="dataForm.regnum" placeholder="登记号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="类别" prop="category">
          <el-input v-model="dataForm.category" placeholder="类别"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="创作完成日期" prop="finishDate">
          <el-date-picker v-model="dataForm.finishDate" value-format="yyyy-MM-dd" placeholder="创作完成日期"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="登记日期" prop="regtime">
          <el-date-picker v-model="dataForm.regtime" value-format="yyyy-MM-dd" placeholder="登记日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="首次发布日期" prop="publishtime">
          <el-date-picker v-model="dataForm.publishtime" value-format="yyyy-MM-dd" placeholder="首次发布日期"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
         <el-form-item label="数据状态" prop="dataState">
          <el-radio-group v-model="dataForm.dataState">
            <el-radio :label="1">正常</el-radio>
            <el-radio :label="0">删除</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
    </el-row>
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
          enterpriseId: '',
          id: 0,
          entName: '',
          title: '',
          regnum: '',
          category: '',
          finishDate: '',
          regtime: '',
          publishtime: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '作品名称不能为空', trigger: 'blur' }
          ],
          regnum: [
            { required: true, message: '登记号不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          finishDate: [
            { required: true, message: '创作完成日期不能为空', trigger: 'blur' }
          ],
          regtime: [
            { required: true, message: '登记日期不能为空', trigger: 'blur' }
          ],
          publishtime: [
            { required: true, message: '首次发布日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnworksright/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnWorksRight.enterpriseId
                this.dataForm.entName = data.rptTnWorksRight.entName
                this.dataForm.title = data.rptTnWorksRight.title
                this.dataForm.regnum = data.rptTnWorksRight.regnum
                this.dataForm.category = data.rptTnWorksRight.category
                this.dataForm.finishDate = data.rptTnWorksRight.finishDate
                this.dataForm.regtime = data.rptTnWorksRight.regtime
                this.dataForm.publishtime = data.rptTnWorksRight.publishtime
                this.dataForm.creator = data.rptTnWorksRight.creator
                this.dataForm.createTime = data.rptTnWorksRight.createTime
                this.dataForm.updater = data.rptTnWorksRight.updater
                this.dataForm.updateTime = data.rptTnWorksRight.updateTime
                this.dataForm.dataState = data.rptTnWorksRight.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnworksright/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'enterpriseId': this.dataForm.enterpriseId,
                'id': this.dataForm.id || undefined,
                'entName': this.dataForm.entName,
                'title': this.dataForm.title,
                'regnum': this.dataForm.regnum,
                'category': this.dataForm.category,
                'finishDate': this.dataForm.finishDate,
                'regtime': this.dataForm.regtime,
                'publishtime': this.dataForm.publishtime,
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
