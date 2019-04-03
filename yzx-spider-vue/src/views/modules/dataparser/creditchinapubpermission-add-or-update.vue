<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <!--<el-form-item label="" prop="areaCode">
      <el-input v-model="dataForm.areaCode" placeholder=""></el-input>
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
    </el-form-item>-->
    <!--<el-form-item label="上传时间" prop="uploadDate">-->
      <!--<el-input v-model="dataForm.uploadDate" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="xkBz">-->
      <!--<el-input v-model="dataForm.xkBz" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="xkXdr">
          <el-input v-model="dataForm.xkXdr" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="审核类型" prop="xkSplb">
          <el-input v-model="dataForm.xkSplb" placeholder="审核类型"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="许可书文号" prop="xkWsh">
          <el-input v-model="dataForm.xkWsh" placeholder="行政许可决定书文号"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="法人代表人姓名" prop="xkFr">
          <el-input v-model="dataForm.xkFr" placeholder="法人代表人姓名"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="许可决定日期" prop="xkJdrq">
          <el-date-picker v-model="dataForm.xkJdrq" placeholder="许可决定日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="许可截止日期" prop="xkJzq">
          <el-date-picker v-model="dataForm.xkJzq" placeholder="许可截止日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="内容许可" type="textarea" prop="xkNr">
          <el-input v-model="dataForm.xkNr" placeholder="内容许可"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="许可机关" prop="xkXzjg">
          <el-input v-model="dataForm.xkXzjg" placeholder="许可机关"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="地方编码" prop="xkDfbm">
          <el-input v-model="dataForm.xkDfbm" placeholder="地方编码"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="数据更新时间" prop="xkSjc">
          <el-date-picker v-model="dataForm.xkSjc" placeholder="数据更新时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
     <!-- <el-form-item label="" prop="xkXdrGsdj">
      <el-input v-model="dataForm.xkXdrGsdj" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="xkXdrSfz">
      <el-input v-model="dataForm.xkXdrSfz" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="xkXdrShxym">
      <el-input v-model="dataForm.xkXdrShxym" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="xkXdrSwdj">
      <el-input v-model="dataForm.xkXdrSwdj" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="xkXdrZdm">
      <el-input v-model="dataForm.xkXdrZdm" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="xkXmmc">
      <el-input v-model="dataForm.xkXmmc" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="xkXzbm">
      <el-input v-model="dataForm.xkXzbm" placeholder=""></el-input>
    </el-form-item>

    <el-form-item label="" prop="xkYxq">
      <el-input v-model="dataForm.xkYxq" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="xkZt">
      <el-input v-model="dataForm.xkZt" placeholder=""></el-input>
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
    <el-form-item label="备注" prop="remark">
      <el-input type="textarea" v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
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
          fileId: '',
          fingerPrint: '',
          pv: '',
          roleId: '',
          subjectId: '',
          uploadDate: '',
          xkBz: '',
          xkDfbm: '',
          xkFr: '',
          xkJdrq: '',
          xkJzq: '',
          xkNr: '',
          xkSjc: '',
          xkSplb: '',
          xkWsh: '',
          xkXdr: '',
          xkXdrGsdj: '',
          xkXdrSfz: '',
          xkXdrShxym: '',
          xkXdrSwdj: '',
          xkXdrZdm: '',
          xkXmmc: '',
          xkXzbm: '',
          xkXzjg: '',
          xkYxq: '',
          xkZt: '',
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
          ],
          xkBz: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          xkDfbm: [
            { required: true, message: '地方编码不能为空', trigger: 'blur' }
          ],
          xkFr: [
            { required: true, message: '法人代表人姓名不能为空', trigger: 'blur' }
          ],
          xkJdrq: [
            { required: true, message: '许可决定日期不能为空', trigger: 'blur' }
          ],
          xkJzq: [
            { required: true, message: '许可截止日期不能为空', trigger: 'blur' }
          ],
          xkNr: [
            { required: true, message: '内容许可不能为空', trigger: 'blur' }
          ],
          xkSjc: [
            { required: true, message: '数据更新时间不能为空', trigger: 'blur' }
          ],
          xkSplb: [
            { required: true, message: '审核类型不能为空', trigger: 'blur' }
          ],
          xkWsh: [
            { required: true, message: '行政许可决定书文号不能为空', trigger: 'blur' }
          ],
          xkXdr: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          /* xkXdrGsdj: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkXdrSfz: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkXdrShxym: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkXdrSwdj: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkXdrZdm: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkXmmc: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkXzbm: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ], */
          xkXzjg: [
            { required: true, message: '许可机关不能为空', trigger: 'blur' }
          ]
//          ,
          /* xkYxq: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkZt: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          spiderId: [
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
              url: this.$http.adornUrl(`/dataparser/creditchinapubpermission/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.areaCode = data.creditchinaPubPermission.areaCode
                this.dataForm.fileId = data.creditchinaPubPermission.fileId
                this.dataForm.fingerPrint = data.creditchinaPubPermission.fingerPrint
                this.dataForm.pv = data.creditchinaPubPermission.pv
                this.dataForm.roleId = data.creditchinaPubPermission.roleId
                this.dataForm.subjectId = data.creditchinaPubPermission.subjectId
                this.dataForm.uploadDate = data.creditchinaPubPermission.uploadDate
                this.dataForm.xkBz = data.creditchinaPubPermission.xkBz
                this.dataForm.xkDfbm = data.creditchinaPubPermission.xkDfbm
                this.dataForm.xkFr = data.creditchinaPubPermission.xkFr
                this.dataForm.xkJdrq = data.creditchinaPubPermission.xkJdrq
                this.dataForm.xkJzq = data.creditchinaPubPermission.xkJzq
                this.dataForm.xkNr = data.creditchinaPubPermission.xkNr
                this.dataForm.xkSjc = data.creditchinaPubPermission.xkSjc
                this.dataForm.xkSplb = data.creditchinaPubPermission.xkSplb
                this.dataForm.xkWsh = data.creditchinaPubPermission.xkWsh
                this.dataForm.xkXdr = data.creditchinaPubPermission.xkXdr
                this.dataForm.xkXdrGsdj = data.creditchinaPubPermission.xkXdrGsdj
                this.dataForm.xkXdrSfz = data.creditchinaPubPermission.xkXdrSfz
                this.dataForm.xkXdrShxym = data.creditchinaPubPermission.xkXdrShxym
                this.dataForm.xkXdrSwdj = data.creditchinaPubPermission.xkXdrSwdj
                this.dataForm.xkXdrZdm = data.creditchinaPubPermission.xkXdrZdm
                this.dataForm.xkXmmc = data.creditchinaPubPermission.xkXmmc
                this.dataForm.xkXzbm = data.creditchinaPubPermission.xkXzbm
                this.dataForm.xkXzjg = data.creditchinaPubPermission.xkXzjg
                this.dataForm.xkYxq = data.creditchinaPubPermission.xkYxq
                this.dataForm.xkZt = data.creditchinaPubPermission.xkZt
                this.dataForm.spiderId = data.creditchinaPubPermission.spiderId
                this.dataForm.createTime = data.creditchinaPubPermission.createTime
                this.dataForm.updateTime = data.creditchinaPubPermission.updateTime
                this.dataForm.remark = data.creditchinaPubPermission.remark
                this.dataForm.dataStatus = data.creditchinaPubPermission.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/creditchinapubpermission/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'areaCode': this.dataForm.areaCode,
                'fileId': this.dataForm.fileId,
                'fingerPrint': this.dataForm.fingerPrint,
                'pv': this.dataForm.pv,
                'roleId': this.dataForm.roleId,
                'subjectId': this.dataForm.subjectId,
                'uploadDate': this.dataForm.uploadDate,
                'xkBz': this.dataForm.xkBz,
                'xkDfbm': this.dataForm.xkDfbm,
                'xkFr': this.dataForm.xkFr,
                'xkJdrq': this.dataForm.xkJdrq,
                'xkJzq': this.dataForm.xkJzq,
                'xkNr': this.dataForm.xkNr,
                'xkSjc': this.dataForm.xkSjc,
                'xkSplb': this.dataForm.xkSplb,
                'xkWsh': this.dataForm.xkWsh,
                'xkXdr': this.dataForm.xkXdr,
                'xkXdrGsdj': this.dataForm.xkXdrGsdj,
                'xkXdrSfz': this.dataForm.xkXdrSfz,
                'xkXdrShxym': this.dataForm.xkXdrShxym,
                'xkXdrSwdj': this.dataForm.xkXdrSwdj,
                'xkXdrZdm': this.dataForm.xkXdrZdm,
                'xkXmmc': this.dataForm.xkXmmc,
                'xkXzbm': this.dataForm.xkXzbm,
                'xkXzjg': this.dataForm.xkXzjg,
                'xkYxq': this.dataForm.xkYxq,
                'xkZt': this.dataForm.xkZt,
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
