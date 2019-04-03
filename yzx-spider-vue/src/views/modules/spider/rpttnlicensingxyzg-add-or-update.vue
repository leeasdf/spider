<template>
  <el-dialog
    width="700px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="100px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有效时间" prop="validityTime">
            <el-input v-model="dataForm.validityTime" placeholder="有效时间"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="决定书文号" prop="licenceNumber">
            <el-input v-model="dataForm.licenceNumber" placeholder="决定书文号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="决定机关" prop="department">
            <el-input v-model="dataForm.department" placeholder="决定机关"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="决定日期" prop="decisionDate">
            <el-date-picker v-model="dataForm.decisionDate" value-format="yyyy-MM-dd" placeholder="决定日期"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="结束日期" prop="endDate">
            <el-date-picker v-model="dataForm.endDate" value-format="yyyy-MM-dd" placeholder="结束日期"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="法人" prop="legalPersonName">
            <el-input v-model="dataForm.legalPersonName" placeholder="法人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="当地编码" prop="localCode">
            <el-input v-model="dataForm.localCode" placeholder="当地编码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="类型" prop="audiType">
            <el-input v-model="dataForm.audiType" placeholder="类型"></el-input>
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
      <el-form-item label="处罚内容" prop="licenceContent">
        <el-input type="textarea" v-model="dataForm.licenceContent" placeholder="处罚内容"></el-input>
      </el-form-item>
      <!-- <el-form-item label="法人ID" prop="legalPersonId">
        <el-input v-model="dataForm.legalPersonId" placeholder="法人ID"></el-input>
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
          validityTime: '',
          licenceNumber: '',
          department: '',
          licenceContent: '',
          endDate: '',
          audiType: '',
          decisionDate: '',
          legalPersonName: '',
          cid: '',
          localCode: '',
          legalPersonId: '',
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
          validityTime: [
            { required: true, message: '有效时间不能为空', trigger: 'blur' }
          ],
          licenceNumber: [
            { required: true, message: '决定书文号不能为空', trigger: 'blur' }
          ],
          department: [
            { required: true, message: '决定机关不能为空', trigger: 'blur' }
          ],
          licenceContent: [
            { required: true, message: '处罚内容不能为空', trigger: 'blur' }
          ],
          endDate: [
            { required: true, message: '结束日期不能为空', trigger: 'blur' }
          ],
          audiType: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          decisionDate: [
            { required: true, message: '决定日期不能为空', trigger: 'blur' }
          ],
          legalPersonName: [
            { required: true, message: '法人不能为空', trigger: 'blur' }
          ],
          cid: [
            { required: true, message: '处罚ID不能为空', trigger: 'blur' }
          ],
          localCode: [
            { required: true, message: '当地编码不能为空', trigger: 'blur' }
          ],
          legalPersonId: [
            { required: true, message: '法人ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnlicensingxyzg/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnLicensingXyzg.enterpriseId
                this.dataForm.entName = data.rptTnLicensingXyzg.entName
                this.dataForm.validityTime = data.rptTnLicensingXyzg.validityTime
                this.dataForm.licenceNumber = data.rptTnLicensingXyzg.licenceNumber
                this.dataForm.department = data.rptTnLicensingXyzg.department
                this.dataForm.licenceContent = data.rptTnLicensingXyzg.licenceContent
                this.dataForm.endDate = data.rptTnLicensingXyzg.endDate
                this.dataForm.audiType = data.rptTnLicensingXyzg.audiType
                this.dataForm.decisionDate = data.rptTnLicensingXyzg.decisionDate
                this.dataForm.legalPersonName = data.rptTnLicensingXyzg.legalPersonName
                this.dataForm.cid = data.rptTnLicensingXyzg.cid
                this.dataForm.localCode = data.rptTnLicensingXyzg.localCode
                this.dataForm.legalPersonId = data.rptTnLicensingXyzg.legalPersonId
                this.dataForm.creator = data.rptTnLicensingXyzg.creator
                this.dataForm.createTime = data.rptTnLicensingXyzg.createTime
                this.dataForm.updater = data.rptTnLicensingXyzg.updater
                this.dataForm.updateTime = data.rptTnLicensingXyzg.updateTime
                this.dataForm.dataState = data.rptTnLicensingXyzg.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnlicensingxyzg/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'validityTime': this.dataForm.validityTime,
                'licenceNumber': this.dataForm.licenceNumber,
                'department': this.dataForm.department,
                'licenceContent': this.dataForm.licenceContent,
                'endDate': this.dataForm.endDate,
                'audiType': this.dataForm.audiType,
                'decisionDate': this.dataForm.decisionDate,
                'legalPersonName': this.dataForm.legalPersonName,
                'cid': this.dataForm.cid,
                'localCode': this.dataForm.localCode,
                'legalPersonId': this.dataForm.legalPersonId,
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
