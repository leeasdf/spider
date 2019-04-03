<template>
  <el-dialog
    width="720px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="110px">
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="立案日期" prop="regdate">
          <el-date-picker v-model="dataForm.regdate" value-format="yyyy-MM-dd" placeholder="立案日期"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="案号" prop="casecode">
          <el-input v-model="dataForm.casecode" placeholder="案号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="执行法院" prop="courtname">
          <el-input v-model="dataForm.courtname" placeholder="执行法院"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="履行状态" prop="performance">
          <el-input v-model="dataForm.performance" placeholder="履行状态"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="执行依据文号" prop="gistid">
          <el-input v-model="dataForm.gistid" placeholder="执行依据文号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="执行法院结果" prop="result">
          <el-input v-model="dataForm.result" placeholder="执行法院结果"></el-input>
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
    <!-- <el-form-item label="" prop="date">
      <el-input v-model="dataForm.date" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="type">
      <el-input v-model="dataForm.type" placeholder=""></el-input>
    </el-form-item> -->
    
    <!-- <el-form-item label="" prop="iname">
      <el-input v-model="dataForm.iname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="businessentity">
      <el-input v-model="dataForm.businessentity" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="areaname">
      <el-input v-model="dataForm.areaname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cardnum">
      <el-input v-model="dataForm.cardnum" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="公布日期" prop="publishdate">
      <el-input v-model="dataForm.publishdate" placeholder="公布日期"></el-input>
    </el-form-item>
    <el-form-item label="" prop="gistunit">
      <el-input v-model="dataForm.gistunit" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="duty">
      <el-input v-model="dataForm.duty" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="disrupttypename">
      <el-input v-model="dataForm.disrupttypename" placeholder=""></el-input>
    </el-form-item> -->
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
          regdate: '',
          casecode: '',
          courtname: '',
          performance: '',
          gistid: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          date: '',
          type: '',
          result: '',
          iname: '',
          businessentity: '',
          areaname: '',
          cardnum: '',
          publishdate: '',
          gistunit: '',
          duty: '',
          disrupttypename: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          regdate: [
            { required: true, message: '立案日期不能为空', trigger: 'blur' }
          ],
          casecode: [
            { required: true, message: '案号不能为空', trigger: 'blur' }
          ],
          courtname: [
            { required: true, message: '执行法院不能为空', trigger: 'blur' }
          ],
          performance: [
            { required: true, message: '履行状态不能为空', trigger: 'blur' }
          ],
          gistid: [
            { required: true, message: '执行依据文号不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          /* date: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          result: [
            { required: true, message: '执行法院结果不能为空', trigger: 'blur' }
          ]
          /* iname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          businessentity: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          areaname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cardnum: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          publishdate: [
            { required: true, message: '公布日期不能为空', trigger: 'blur' }
          ],
          gistunit: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          duty: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          disrupttypename: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttndishonest/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnDishonest.enterpriseId
                this.dataForm.entName = data.rptTnDishonest.entName
                this.dataForm.regdate = data.rptTnDishonest.regdate
                this.dataForm.casecode = data.rptTnDishonest.casecode
                this.dataForm.courtname = data.rptTnDishonest.courtname
                this.dataForm.performance = data.rptTnDishonest.performance
                this.dataForm.gistid = data.rptTnDishonest.gistid
                this.dataForm.creator = data.rptTnDishonest.creator
                this.dataForm.createTime = data.rptTnDishonest.createTime
                this.dataForm.updater = data.rptTnDishonest.updater
                this.dataForm.updateTime = data.rptTnDishonest.updateTime
                this.dataForm.dataState = data.rptTnDishonest.dataState
                this.dataForm.date = data.rptTnDishonest.date
                this.dataForm.type = data.rptTnDishonest.type
                this.dataForm.result = data.rptTnDishonest.result
                this.dataForm.iname = data.rptTnDishonest.iname
                this.dataForm.businessentity = data.rptTnDishonest.businessentity
                this.dataForm.areaname = data.rptTnDishonest.areaname
                this.dataForm.cardnum = data.rptTnDishonest.cardnum
                this.dataForm.publishdate = data.rptTnDishonest.publishdate
                this.dataForm.gistunit = data.rptTnDishonest.gistunit
                this.dataForm.duty = data.rptTnDishonest.duty
                this.dataForm.disrupttypename = data.rptTnDishonest.disrupttypename
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
              url: this.$http.adornUrl(`/spider/rpttndishonest/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'regdate': this.dataForm.regdate,
                'casecode': this.dataForm.casecode,
                'courtname': this.dataForm.courtname,
                'performance': this.dataForm.performance,
                'gistid': this.dataForm.gistid,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'date': this.dataForm.date,
                'type': this.dataForm.type,
                'result': this.dataForm.result,
                'iname': this.dataForm.iname,
                'businessentity': this.dataForm.businessentity,
                'areaname': this.dataForm.areaname,
                'cardnum': this.dataForm.cardnum,
                'publishdate': this.dataForm.publishdate,
                'gistunit': this.dataForm.gistunit,
                'duty': this.dataForm.duty,
                'disrupttypename': this.dataForm.disrupttypename
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
