<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
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
          <el-form-item label="组织机构代码" prop="orgCode">
            <el-input v-model="dataForm.orgCode" placeholder="组织机构代码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="负责人" prop="responsiblePerson">
            <el-input v-model="dataForm.responsiblePerson" placeholder="负责人"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="主管税务机关" prop="taxAuthorities">
            <el-input v-model="dataForm.taxAuthorities" placeholder="主管税务机关"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="信用等级" prop="creditLevel">
            <el-input v-model="dataForm.creditLevel" placeholder="信用等级"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="评价年度" prop="year">
            <el-date-picker type="year" value-format="yyyy"  v-model="dataForm.year" placeholder="评价年度"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="税务类型" prop="taxType">
            <el-radio-group v-model="dataForm.taxType">
              <el-radio label="NATIONAL_TAX">国税</el-radio>
              <el-radio label="LOCAL_TAX">地税</el-radio>
            </el-radio-group>
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
          <el-form-item label="数据来源" prop="source">
            <el-input v-model="dataForm.source" placeholder="数据来源"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="信息类型" prop="infomationType">
            <el-input v-model="dataForm.infomationType" placeholder="信息类型"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
   <!--  <el-form-item label="信息资源更新时间(网站更新 表头)" prop="sourceTime">
      <el-input v-model="dataForm.sourceTime" placeholder="信息资源更新时间(网站更新 表头)"></el-input>
    </el-form-item>
    <el-form-item label="更新时间(信用等级表中)" prop="taxUpdateTime">
      <el-input v-model="dataForm.taxUpdateTime" placeholder="更新时间(信用等级 表中)"></el-input>
    </el-form-item> -->
    <!-- <el-form-item label="爬虫表数据记录id" prop="spiderId">
      <el-input v-model="dataForm.spiderId" placeholder="爬虫表数据记录id"></el-input>
    </el-form-item> -->
   <!--  <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    
      <!--
    <el-form-item label="版本号" prop="version">
      <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataStatus">
      <el-input v-model="dataForm.dataStatus" placeholder="数据状态"></el-input>
    </el-form-item>
    -->
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
          orgCode: '',
          responsiblePerson: '',
          taxAuthorities: '',
          creditLevel: '',
          year: '',
          taxType: '',
          infomationName: '',
          source: '',
          infomationType: '',
          sourceTime: '',
          taxUpdateTime: '',
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
//          orgCode: [
//            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
//          ],
//          responsiblePerson: [
//            { required: true, message: '负责人不能为空', trigger: 'blur' }
//          ],
//          taxAuthorities: [
//            { required: true, message: '主管税务机关不能为空', trigger: 'blur' }
//          ],
          creditLevel: [
            { required: true, message: '信用等级不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          taxType: [
            { required: true, message: '税务类型不能为空', trigger: 'change' }
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
          /* sourceTime: [
            { required: true, message: '信息资源更新时间(网站更新 表头)不能为空', trigger: 'blur' }
          ],
          taxUpdateTime: [
            { required: true, message: '更新时间(信用等级 表中)不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/dataparser/credithunantaxa/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taxpayer = data.credithunanTaxA.taxpayer
                this.dataForm.taxpayerNo = data.credithunanTaxA.taxpayerNo
                this.dataForm.orgCode = data.credithunanTaxA.orgCode
                this.dataForm.responsiblePerson = data.credithunanTaxA.responsiblePerson
                this.dataForm.taxAuthorities = data.credithunanTaxA.taxAuthorities
                this.dataForm.creditLevel = data.credithunanTaxA.creditLevel
                this.dataForm.year = data.credithunanTaxA.year
                this.dataForm.taxType = data.credithunanTaxA.taxType
                this.dataForm.infomationName = data.credithunanTaxA.infomationName
                this.dataForm.source = data.credithunanTaxA.source
                this.dataForm.infomationType = data.credithunanTaxA.infomationType
                this.dataForm.sourceTime = data.credithunanTaxA.sourceTime
                this.dataForm.taxUpdateTime = data.credithunanTaxA.taxUpdateTime
                this.dataForm.spiderId = data.credithunanTaxA.spiderId
                this.dataForm.createTime = data.credithunanTaxA.createTime
                this.dataForm.updateTime = data.credithunanTaxA.updateTime
                this.dataForm.remark = data.credithunanTaxA.remark
                this.dataForm.version = data.credithunanTaxA.version
                this.dataForm.dataStatus = data.credithunanTaxA.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/credithunantaxa/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'taxpayer': this.dataForm.taxpayer,
                'taxpayerNo': this.dataForm.taxpayerNo,
                'orgCode': this.dataForm.orgCode,
                'responsiblePerson': this.dataForm.responsiblePerson,
                'taxAuthorities': this.dataForm.taxAuthorities,
                'creditLevel': this.dataForm.creditLevel,
                'year': this.dataForm.year,
                'taxType': this.dataForm.taxType,
                'infomationName': this.dataForm.infomationName,
                'source': this.dataForm.source,
                'infomationType': this.dataForm.infomationType,
                'sourceTime': this.dataForm.sourceTime,
                'taxUpdateTime': this.dataForm.taxUpdateTime,
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
