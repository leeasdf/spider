<template>
  <el-dialog
    width="780px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="140px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="纳税人名称" prop="taxpayer">
            <el-input v-model="dataForm.taxpayer" placeholder="纳税人名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="纳税人识别号" prop="taxpayerNo">
            <el-input v-model="dataForm.taxpayerNo" placeholder="纳税人识别号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="社会信用统一代码" prop="creditCode">
            <el-input v-model="dataForm.creditCode" placeholder="社会信用统一代码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册地址" prop="registerAddress">
            <el-input v-model="dataForm.registerAddress" placeholder="注册地址"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="法定代表人" prop="legal">
            <el-input v-model="dataForm.legal" placeholder="法定代表人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="身份证号" prop="certificationNo">
            <el-input v-model="dataForm.certificationNo" placeholder="身份证号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="实施检查单位" prop="checkUnit">
            <el-input v-model="dataForm.checkUnit" placeholder="实施检查单位"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公告日期" prop="declarationDate">
            <el-date-picker v-model="dataForm.declarationDate" placeholder="公告日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="信息名称" prop="infomationName">
            <el-input v-model="dataForm.infomationName" placeholder="信息名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="信息类型" prop="infomationType">
            <el-input v-model="dataForm.infomationType" placeholder="信息类型"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="数据来源" prop="source">
            <el-input v-model="dataForm.source" placeholder="数据来源"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    <!-- <el-form-item label="信息资源更新时间" prop="sourceTime">
      <el-input v-model="dataForm.sourceTime" placeholder="信息资源更新时间"></el-input>
    </el-form-item>
    <el-form-item label="爬虫表数据记录id" prop="spiderId">
      <el-input v-model="dataForm.spiderId" placeholder="爬虫表数据记录id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    
    <!--<el-form-item label="版本号" prop="version">-->
      <!--<el-input v-model="dataForm.version" placeholder="版本号"></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="数据状态" prop="dataStatus">-->
      <!--<el-input v-model="dataForm.dataStatus" placeholder="数据状态"></el-input>-->
    <!--</el-form-item>-->
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
          taxpayer: '',
          taxpayerNo: '',
          creditCode: '',
          registerAddress: '',
          legal: '',
          certificationNo: '',
          checkUnit: '',
          declarationDate: '',
          infomationName: '',
          source: '',
          infomationType: '',
          sourceTime: '',
          spiderId: '',
          createTime: '',
          updateTime: '',
          remark: '',
          version: '',
          dataStatus: ''
        },
        dataRule: {
          taxpayer: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          taxpayerNo: [
            { required: true, message: '纳税人识别号不能为空', trigger: 'blur' }
          ],
          creditCode: [
            { required: true, message: '社会信用统一代码不能为空', trigger: 'blur' }
          ],
          registerAddress: [
            { required: true, message: '注册地址不能为空', trigger: 'blur' }
          ],
          legal: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          certificationNo: [
            { required: true, message: '身份证号不能为空', trigger: 'blur' }
          ],
          checkUnit: [
            { required: true, message: '实施检查单位不能为空', trigger: 'blur' }
          ],
          declarationDate: [
            { required: true, message: '公告日期不能为空', trigger: 'blur' }
          ],
          infomationName: [
            { required: true, message: '信息名称不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          infomationType: [
            { required: true, message: '信息类型不能为空', trigger: 'blur' }
          ]
//          ,
//          sourceTime: [
//            { required: true, message: '信息资源更新时间不能为空', trigger: 'blur' }
//          ]
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
            { required: true, message: '备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/dataparser/credithunantaxcontravention/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taxpayer = data.credithunanTaxContravention.taxpayer
                this.dataForm.taxpayerNo = data.credithunanTaxContravention.taxpayerNo
                this.dataForm.creditCode = data.credithunanTaxContravention.creditCode
                this.dataForm.registerAddress = data.credithunanTaxContravention.registerAddress
                this.dataForm.legal = data.credithunanTaxContravention.legal
                this.dataForm.certificationNo = data.credithunanTaxContravention.certificationNo
                this.dataForm.checkUnit = data.credithunanTaxContravention.checkUnit
                this.dataForm.declarationDate = data.credithunanTaxContravention.declarationDate
                this.dataForm.infomationName = data.credithunanTaxContravention.infomationName
                this.dataForm.source = data.credithunanTaxContravention.source
                this.dataForm.infomationType = data.credithunanTaxContravention.infomationType
                this.dataForm.sourceTime = data.credithunanTaxContravention.sourceTime
                this.dataForm.spiderId = data.credithunanTaxContravention.spiderId
                this.dataForm.createTime = data.credithunanTaxContravention.createTime
                this.dataForm.updateTime = data.credithunanTaxContravention.updateTime
                this.dataForm.remark = data.credithunanTaxContravention.remark
                this.dataForm.version = data.credithunanTaxContravention.version
                this.dataForm.dataStatus = data.credithunanTaxContravention.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/credithunantaxcontravention/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'taxpayer': this.dataForm.taxpayer,
                'taxpayerNo': this.dataForm.taxpayerNo,
                'creditCode': this.dataForm.creditCode,
                'registerAddress': this.dataForm.registerAddress,
                'legal': this.dataForm.legal,
                'certificationNo': this.dataForm.certificationNo,
                'checkUnit': this.dataForm.checkUnit,
                'declarationDate': this.dataForm.declarationDate,
                'infomationName': this.dataForm.infomationName,
                'source': this.dataForm.source,
                'infomationType': this.dataForm.infomationType,
                'sourceTime': this.dataForm.sourceTime,
                'spiderId': this.dataForm.spiderId,
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
