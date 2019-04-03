<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
   <!-- <el-form-item label="" prop="areaCode">
      <el-input v-model="dataForm.areaCode" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cfBz">
      <el-input v-model="dataForm.cfBz" placeholder=""></el-input>
    </el-form-item>

    <el-form-item label="" prop="cfCflb2">
      <el-input v-model="dataForm.cfCflb2" placeholder=""></el-input>
    </el-form-item>-->

      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="法人代表人姓名" prop="cfFr">
            <el-input v-model="dataForm.cfFr" placeholder="法人代表人姓名"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="处罚类别" prop="cfCflb1">
            <el-input v-model="dataForm.cfCflb1" placeholder="处罚类别"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="决定书文号" prop="cfWsh">
            <el-input v-model="dataForm.cfWsh" placeholder="决定书文号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="处罚名称" prop="cfCfmc">
            <el-input v-model="dataForm.cfCfmc" placeholder="处罚名称"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
         <el-form-item label="处罚机关" prop="cfXzjg">
            <el-input v-model="dataForm.cfXzjg" placeholder="处罚机关"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="处罚决定日期" prop="cfJdrq">
            <el-date-picker v-model="dataForm.cfJdrq" placeholder="处罚决定日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="数据更新时间" prop="cfSjc">
            <el-date-picker v-model="dataForm.cfSjc" placeholder="数据更新时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="处罚事由" prop="cfSy">
        <el-input v-model="dataForm.cfSy" placeholder="处罚事由" type="textarea"></el-input>
      </el-form-item>
      <el-form-item label="处罚依据" prop="cfYj">
        <el-input v-model="dataForm.cfYj" placeholder="处罚依据" type="textarea"></el-input>
      </el-form-item>
      <el-form-item label="处罚结果" prop="cfJg">
        <el-input v-model="dataForm.cfJg" placeholder="处罚结果" type="textarea"></el-input>
      </el-form-item>
      

    <!--<el-form-item label="" prop="cfDfbm">
      <el-input v-model="dataForm.cfDfbm" placeholder=""></el-input>
    </el-form-item>-->

    
    <!--<el-form-item label="" prop="cfQx">
      <el-input v-model="dataForm.cfQx" placeholder=""></el-input>
    </el-form-item>-->
    

   <!-- <el-form-item label="" prop="cfXdrGsdj">
      <el-input v-model="dataForm.cfXdrGsdj" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cfXdrMc">
      <el-input v-model="dataForm.cfXdrMc" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cfXdrSfz">
      <el-input v-model="dataForm.cfXdrSfz" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cfXdrShxym">
      <el-input v-model="dataForm.cfXdrShxym" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cfXdrSwdj">
      <el-input v-model="dataForm.cfXdrSwdj" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cfXdrZdm">
      <el-input v-model="dataForm.cfXdrZdm" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cfXzbm">
      <el-input v-model="dataForm.cfXzbm" placeholder=""></el-input>
    </el-form-item>-->
    
    <!--<el-form-item label="" prop="cfZt">
      <el-input v-model="dataForm.cfZt" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="fileId">
      <el-input v-model="dataForm.fileId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="fingerPrint">
      <el-input v-model="dataForm.fingerPrint" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pv">
      <el-input v-model="dataForm.pv" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="roleId">
      <el-input v-model="dataForm.roleId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="subjectId">
      <el-input v-model="dataForm.subjectId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uploadDate">
      <el-input v-model="dataForm.uploadDate" placeholder=""></el-input>
    </el-form-item>-->
    <!-- <el-form-item label="爬虫表数据记录id" prop="spiderId">
      <el-input v-model="dataForm.spiderId" placeholder="爬虫表数据记录id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    
   <!-- <el-form-item label="数据状态" prop="dataStatus">
      <el-input v-model="dataForm.dataStatus" placeholder="数据状态"></el-input>
    </el-form-item>-->
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
          areaCode: '',
          cfBz: '',
          cfCflb1: '',
          cfCflb2: '',
          cfCfmc: '',
          cfDfbm: '',
          cfFr: '',
          cfJdrq: '',
          cfJg: '',
          cfQx: '',
          cfSjc: '',
          cfSy: '',
          cfWsh: '',
          cfXdrGsdj: '',
          cfXdrMc: '',
          cfXdrSfz: '',
          cfXdrShxym: '',
          cfXdrSwdj: '',
          cfXdrZdm: '',
          cfXzbm: '',
          cfXzjg: '',
          cfYj: '',
          cfZt: '',
          fileId: '',
          fingerPrint: '',
          pv: '',
          roleId: '',
          subjectId: '',
          uploadDate: '',
          spiderId: '',
          createTime: '',
          updateTime: '',
          remark: '',
          dataStatus: ''
        },
        dataRule: {
          /* areaCode: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfBz: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          cfCflb1: [
            { required: true, message: '处罚类别不能为空', trigger: 'blur' }
          ],
          /* cfCflb2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          cfCfmc: [
            { required: true, message: '处罚名称不能为空', trigger: 'blur' }
          ],
         /* cfDfbm: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          cfFr: [
            { required: true, message: '法人代表人姓名不能为空', trigger: 'blur' }
          ],
          cfJdrq: [
            { required: true, message: '处罚决定日期不能为空', trigger: 'blur' }
          ],
          cfJg: [
            { required: true, message: '处罚结果不能为空', trigger: 'blur' }
          ],
         /* cfQx: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          cfSjc: [
            { required: true, message: '数据更新时间不能为空', trigger: 'blur' }
          ],
          cfSy: [
            { required: true, message: '处罚事由不能为空', trigger: 'blur' }
          ],
          cfWsh: [
            { required: true, message: '决定书文号不能为空', trigger: 'blur' }
          ],
          /* cfXdrGsdj: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfXdrMc: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfXdrSfz: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfXdrShxym: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfXdrSwdj: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfXdrZdm: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfXzbm: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          cfXzjg: [
            { required: true, message: '处罚机关不能为空', trigger: 'blur' }
          ],
          cfYj: [
            { required: true, message: '处罚依据不能为空', trigger: 'blur' }
          ]
//          ,
      /* cfZt: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fileId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fingerPrint: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pv: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          roleId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          subjectId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uploadDate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ] */
//          ,
          /* spiderId: [
            { required: true, message: '爬虫表数据记录id不能为空', trigger: 'blur' }
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
          dataStatus: [
            { required: true, message: '数据状态不能为空', trigger: 'blur' }
          ]
           */
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
              url: this.$http.adornUrl(`/dataparser/creditchinapubpenalty/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.areaCode = data.creditchinaPubPenalty.areaCode
                this.dataForm.cfBz = data.creditchinaPubPenalty.cfBz
                this.dataForm.cfCflb1 = data.creditchinaPubPenalty.cfCflb1
                this.dataForm.cfCflb2 = data.creditchinaPubPenalty.cfCflb2
                this.dataForm.cfCfmc = data.creditchinaPubPenalty.cfCfmc
                this.dataForm.cfDfbm = data.creditchinaPubPenalty.cfDfbm
                this.dataForm.cfFr = data.creditchinaPubPenalty.cfFr
                this.dataForm.cfJdrq = data.creditchinaPubPenalty.cfJdrq
                this.dataForm.cfJg = data.creditchinaPubPenalty.cfJg
                this.dataForm.cfQx = data.creditchinaPubPenalty.cfQx
                this.dataForm.cfSjc = data.creditchinaPubPenalty.cfSjc
                this.dataForm.cfSy = data.creditchinaPubPenalty.cfSy
                this.dataForm.cfWsh = data.creditchinaPubPenalty.cfWsh
                this.dataForm.cfXdrGsdj = data.creditchinaPubPenalty.cfXdrGsdj
                this.dataForm.cfXdrMc = data.creditchinaPubPenalty.cfXdrMc
                this.dataForm.cfXdrSfz = data.creditchinaPubPenalty.cfXdrSfz
                this.dataForm.cfXdrShxym = data.creditchinaPubPenalty.cfXdrShxym
                this.dataForm.cfXdrSwdj = data.creditchinaPubPenalty.cfXdrSwdj
                this.dataForm.cfXdrZdm = data.creditchinaPubPenalty.cfXdrZdm
                this.dataForm.cfXzbm = data.creditchinaPubPenalty.cfXzbm
                this.dataForm.cfXzjg = data.creditchinaPubPenalty.cfXzjg
                this.dataForm.cfYj = data.creditchinaPubPenalty.cfYj
                this.dataForm.cfZt = data.creditchinaPubPenalty.cfZt
                this.dataForm.fileId = data.creditchinaPubPenalty.fileId
                this.dataForm.fingerPrint = data.creditchinaPubPenalty.fingerPrint
                this.dataForm.pv = data.creditchinaPubPenalty.pv
                this.dataForm.roleId = data.creditchinaPubPenalty.roleId
                this.dataForm.subjectId = data.creditchinaPubPenalty.subjectId
                this.dataForm.uploadDate = data.creditchinaPubPenalty.uploadDate
                this.dataForm.spiderId = data.creditchinaPubPenalty.spiderId
                this.dataForm.createTime = data.creditchinaPubPenalty.createTime
                this.dataForm.updateTime = data.creditchinaPubPenalty.updateTime
                this.dataForm.remark = data.creditchinaPubPenalty.remark
                this.dataForm.dataStatus = data.creditchinaPubPenalty.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/creditchinapubpenalty/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'areaCode': this.dataForm.areaCode,
                'cfBz': this.dataForm.cfBz,
                'cfCflb1': this.dataForm.cfCflb1,
                'cfCflb2': this.dataForm.cfCflb2,
                'cfCfmc': this.dataForm.cfCfmc,
                'cfDfbm': this.dataForm.cfDfbm,
                'cfFr': this.dataForm.cfFr,
                'cfJdrq': this.dataForm.cfJdrq,
                'cfJg': this.dataForm.cfJg,
                'cfQx': this.dataForm.cfQx,
                'cfSjc': this.dataForm.cfSjc,
                'cfSy': this.dataForm.cfSy,
                'cfWsh': this.dataForm.cfWsh,
                'cfXdrGsdj': this.dataForm.cfXdrGsdj,
                'cfXdrMc': this.dataForm.cfXdrMc,
                'cfXdrSfz': this.dataForm.cfXdrSfz,
                'cfXdrShxym': this.dataForm.cfXdrShxym,
                'cfXdrSwdj': this.dataForm.cfXdrSwdj,
                'cfXdrZdm': this.dataForm.cfXdrZdm,
                'cfXzbm': this.dataForm.cfXzbm,
                'cfXzjg': this.dataForm.cfXzjg,
                'cfYj': this.dataForm.cfYj,
                'cfZt': this.dataForm.cfZt,
                'fileId': this.dataForm.fileId,
                'fingerPrint': this.dataForm.fingerPrint,
                'pv': this.dataForm.pv,
                'roleId': this.dataForm.roleId,
                'subjectId': this.dataForm.subjectId,
                'uploadDate': this.dataForm.uploadDate,
                'spiderId': this.dataForm.spiderId,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'remark': this.dataForm.remark,
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
