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
          <el-form-item label="组织机构代码" prop="organizeCode">
            <el-input v-model="dataForm.organizeCode" placeholder="组织机构代码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="法定代表人" prop="legalRepresentative">
            <el-input v-model="dataForm.legalRepresentative" placeholder="法定代表人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="身份证件号" prop="identityCard">
            <el-input v-model="dataForm.identityCard" placeholder="身份证件号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="非正常户认定日期" prop="affirmDate">
            <el-input v-model="dataForm.affirmDate" placeholder="非正常户认定日期"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公告日期" prop="declarationDate">
            <el-input v-model="dataForm.declarationDate" placeholder="公告日期"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="主管税务机关" prop="taxAuthority">
        <el-input v-model="dataForm.taxAuthority" placeholder="主管税务机关"></el-input>
      </el-form-item>
      <el-form-item label="生产经营地址" prop="businessAddress">
        <el-input v-model="dataForm.businessAddress" placeholder="生产经营地址"></el-input>
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
          taxpayer: '',
          organizeCode: '',
          legalRepresentative: '',
          identityCard: '',
          taxAuthority: '',
          declarationDate: '',
          affirmDate: '',
          businessAddress: ''
        },
        dataRule: {
          taxpayer: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          organizeCode: [
            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
          ],
          legalRepresentative: [
            { required: true, message: '法定代表人不能为空', trigger: 'blur' }
          ],
          identityCard: [
            { required: true, message: '身份证件号不能为空', trigger: 'blur' }
          ],
          taxAuthority: [
            { required: true, message: '主管税务机关不能为空', trigger: 'blur' }
          ],
          declarationDate: [
            { required: true, message: '公告日期不能为空', trigger: 'blur' }
          ],
          affirmDate: [
            { required: true, message: '非正常户认定日期不能为空', trigger: 'blur' }
          ],
          businessAddress: [
            { required: true, message: '生产经营地址不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/dataparser/credithunanabnormalnotice/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.taxpayer = data.credithunanAbnormalNotice.taxpayer
                this.dataForm.organizeCode = data.credithunanAbnormalNotice.organizeCode
                this.dataForm.legalRepresentative = data.credithunanAbnormalNotice.legalRepresentative
                this.dataForm.identityCard = data.credithunanAbnormalNotice.identityCard
                this.dataForm.taxAuthority = data.credithunanAbnormalNotice.taxAuthority
                this.dataForm.declarationDate = data.credithunanAbnormalNotice.declarationDate
                this.dataForm.affirmDate = data.credithunanAbnormalNotice.affirmDate
                this.dataForm.businessAddress = data.credithunanAbnormalNotice.businessAddress
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
              url: this.$http.adornUrl(`/dataparser/credithunanabnormalnotice/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'taxpayer': this.dataForm.taxpayer,
                'organizeCode': this.dataForm.organizeCode,
                'legalRepresentative': this.dataForm.legalRepresentative,
                'identityCard': this.dataForm.identityCard,
                'taxAuthority': this.dataForm.taxAuthority,
                'declarationDate': this.dataForm.declarationDate,
                'affirmDate': this.dataForm.affirmDate,
                'businessAddress': this.dataForm.businessAddress

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
