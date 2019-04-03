<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="爬虫名称" prop="spiderMissionName">
            <el-input v-model="dataForm.spiderMissionName" placeholder="爬虫名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否可用" prop="ifAvailable">
            <el-radio-group v-model="dataForm.ifAvailable">
              <el-radio :label="1">是</el-radio>
              <el-radio :label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="bean名称" prop="beanName">
            <el-input v-model="dataForm.beanName" placeholder="bean名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="方法名" prop="methodName">
            <el-input v-model="dataForm.methodName" placeholder="方法名"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="重试次数" prop="retryTimes">
            <el-input-number v-model="dataForm.retryTimes" :min="0" label="重试次数"></el-input-number>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="note">
            <el-input v-model="dataForm.note" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="爬取对象网址" prop="indexUrl">
        <el-input type="textarea" v-model="dataForm.indexUrl" placeholder="爬取对象网址"></el-input>
      </el-form-item>
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
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          spiderMissionName: '',
          ifAvailable: 1,
          retryTimes: '',
          indexUrl: '',
          beanName: '',
          methodName: '',
          note: '',
          dataState: 1,
          updateTime: '',
          createTime: '',
          updater: '',
          creator: ''
        },
        dataRule: {
          spiderMissionName: [
            { required: true, message: '爬虫名称不能为空', trigger: 'blur' }
          ],
          ifAvailable: [
            { required: true, message: '是否可用不能为空', trigger: 'blur' }
          ],
          retryTimes: [
            { required: true, message: '重试次数不能为空', trigger: 'blur' }
          ],
          indexUrl: [
            { required: true, message: '爬取对象首页网址不能为空', trigger: 'blur' }
          ],
          beanName: [
            { required: true, message: 'bean名称不能为空', trigger: 'blur' }
          ],
          methodName: [
            { required: true, message: '方法名不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ]
          /* updateTime: [
            { required: true, message: '最后修改时间不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updater: [
            { required: true, message: '更新者不能为空', trigger: 'blur' }
          ],
          creator: [
            { required: true, message: '创建者不能为空', trigger: 'blur' }
          ] */
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
              url: this.$http.adornUrl(`/spider/spidermission/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.spiderMissionName = data.spiderMission.spiderMissionName
                this.dataForm.ifAvailable = data.spiderMission.ifAvailable
                this.dataForm.retryTimes = data.spiderMission.retryTimes
                this.dataForm.indexUrl = data.spiderMission.indexUrl
                this.dataForm.beanName = data.spiderMission.beanName
                this.dataForm.methodName = data.spiderMission.methodName
                this.dataForm.note = data.spiderMission.note
                this.dataForm.dataState = data.spiderMission.dataState
                this.dataForm.updateTime = data.spiderMission.updateTime
                this.dataForm.createTime = data.spiderMission.createTime
                this.dataForm.updater = data.spiderMission.updater
                this.dataForm.creator = data.spiderMission.creator
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
              url: this.$http.adornUrl(`/spider/spidermission/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'spiderMissionName': this.dataForm.spiderMissionName,
                'ifAvailable': this.dataForm.ifAvailable,
                'retryTimes': this.dataForm.retryTimes,
                'indexUrl': this.dataForm.indexUrl,
                'beanName': this.dataForm.beanName,
                'methodName': this.dataForm.methodName,
                'note': this.dataForm.note,
                'dataState': this.dataForm.dataState,
                'updateTime': this.dataForm.updateTime,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'creator': this.dataForm.creator
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
