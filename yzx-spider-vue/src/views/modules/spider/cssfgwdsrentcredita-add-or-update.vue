<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="180px">
    <el-form-item label="数据状态" prop="isinvalid">
      <el-radio-group v-model="dataForm.isinvalid">
        <el-radio :label="0">正常</el-radio>
        <el-radio :label="1">更新</el-radio>
        <el-radio :label="2">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    <!-- <el-form-item label="数据最后修改时间" prop="lastdate">
      <el-input v-model="dataForm.lastdate" placeholder="数据最后修改时间"></el-input>
    </el-form-item> -->
    <el-form-item label="纳税人名称" prop="nsrmc">
      <el-input v-model="dataForm.nsrmc" placeholder="纳税人名称"></el-input>
    </el-form-item>
    <el-form-item label="统一社会信用代码" prop="xkXdrShxym">
      <el-input v-model="dataForm.xkXdrShxym" placeholder="行政相对人代码_1（统一社会信用代码）"></el-input>
    </el-form-item>
    <el-form-item label="组织机构代码" prop="xkXdrZdm">
      <el-input v-model="dataForm.xkXdrZdm" placeholder="行政相对人代码_2（组织机构代码）"></el-input>
    </el-form-item>
    <el-form-item label="工商登记码" prop="xkXdrGsdj">
      <el-input v-model="dataForm.xkXdrGsdj" placeholder="行政相对人代码_3（工商登记码）"></el-input>
    </el-form-item>
    <el-form-item label="税务登记号" prop="xkXdrSwdj">
      <el-input v-model="dataForm.xkXdrSwdj" placeholder="行政相对人代码_4（税务登记号）"></el-input>
    </el-form-item>
    <el-form-item label="居民身份证号" prop="xkXdrSfz">
      <el-input v-model="dataForm.xkXdrSfz" placeholder="行政相对人代码_5（居民身份证号）"></el-input>
    </el-form-item>
    <el-form-item label="法定代表人（负责人）" prop="fddbrxm">
      <el-input v-model="dataForm.fddbrxm" placeholder="法定代表人（负责人）"></el-input>
    </el-form-item>
    <el-form-item label="评价年度" prop="pjnd">
      <!-- <el-input v-model="dataForm.pjnd" placeholder="评价年度"></el-input> -->
      <el-date-picker type="year" v-model="dataForm.pjnd" placeholder="评价年度"></el-date-picker>
    </el-form-item>
    <el-form-item label="信用级别A级" prop="xyjbA">
      <el-input v-model="dataForm.xyjbA" placeholder="信用级别A级"></el-input>
    </el-form-item>
    <el-form-item label="主管税务机关" prop="zgswjg">
      <el-input v-model="dataForm.zgswjg" placeholder="主管税务机关"></el-input>
    </el-form-item>
    <!-- <el-form-item label="数据更新时间戳" prop="sjc">
      <el-input v-model="dataForm.sjc" placeholder="数据更新时间戳"></el-input>
    </el-form-item> -->
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isIDCard } from '@/utils/validate'
  export default {
    data () {
      const validateIDCard = function (rule, value, callback) {
        if (!isIDCard(value)) {
          callback(new Error('身份证号格式错误'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          isinvalid: '',
          lastdate: '',
          nsrmc: '',
          xkXdrShxym: '',
          xkXdrZdm: '',
          xkXdrGsdj: '',
          xkXdrSwdj: '',
          xkXdrSfz: '',
          fddbrxm: '',
          pjnd: '',
          xyjbA: '',
          zgswjg: '',
          sjc: '',
          zjid: 0
        },
        dataRule: {
          isinvalid: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          lastdate: [
            { required: true, message: '数据最后修改时间不能为空', trigger: 'blur' }
          ],
          nsrmc: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          xkXdrShxym: [
            { required: true, message: '行政相对人代码_1（统一社会信用代码）不能为空', trigger: 'blur' }
          ],
          xkXdrZdm: [
            { required: true, message: '行政相对人代码_2（组织机构代码）不能为空', trigger: 'blur' }
          ],
          xkXdrGsdj: [
            { required: true, message: '行政相对人代码_3（工商登记码）不能为空', trigger: 'blur' }
          ],
          xkXdrSwdj: [
            { required: true, message: '行政相对人代码_4（税务登记号）不能为空', trigger: 'blur' }
          ],
          xkXdrSfz: [
            { required: true, message: '行政相对人代码_5（居民身份证号）不能为空', trigger: 'blur' },
            { validator: validateIDCard, trigger: 'blur' }
          ],
          fddbrxm: [
            { required: true, message: '法定代表人（负责人）不能为空', trigger: 'blur' }
          ],
          pjnd: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ],
          xyjbA: [
            { required: true, message: '信用级别A级不能为空', trigger: 'blur' }
          ],
          zgswjg: [
            { required: true, message: '主管税务机关不能为空', trigger: 'blur' }
          ]
          /* sjc: [
            { required: true, message: '数据更新时间戳不能为空', trigger: 'blur' }
          ] */
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.zjid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.zjid) {
            this.$http({
              url: this.$http.adornUrl(`/spider/cssfgwdsrentcredita/info/${this.dataForm.zjid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.isinvalid = data.csSfgwDsRentcredita.isinvalid
                this.dataForm.lastdate = data.csSfgwDsRentcredita.lastdate
                this.dataForm.nsrmc = data.csSfgwDsRentcredita.nsrmc
                this.dataForm.xkXdrShxym = data.csSfgwDsRentcredita.xkXdrShxym
                this.dataForm.xkXdrZdm = data.csSfgwDsRentcredita.xkXdrZdm
                this.dataForm.xkXdrGsdj = data.csSfgwDsRentcredita.xkXdrGsdj
                this.dataForm.xkXdrSwdj = data.csSfgwDsRentcredita.xkXdrSwdj
                this.dataForm.xkXdrSfz = data.csSfgwDsRentcredita.xkXdrSfz
                this.dataForm.fddbrxm = data.csSfgwDsRentcredita.fddbrxm
                this.dataForm.pjnd = data.csSfgwDsRentcredita.pjnd
                this.dataForm.xyjbA = data.csSfgwDsRentcredita.xyjbA
                this.dataForm.zgswjg = data.csSfgwDsRentcredita.zgswjg
                this.dataForm.sjc = data.csSfgwDsRentcredita.sjc
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
              url: this.$http.adornUrl(`/spider/cssfgwdsrentcredita/${!this.dataForm.zjid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'isinvalid': this.dataForm.isinvalid,
                'lastdate': this.dataForm.lastdate,
                'nsrmc': this.dataForm.nsrmc,
                'xkXdrShxym': this.dataForm.xkXdrShxym,
                'xkXdrZdm': this.dataForm.xkXdrZdm,
                'xkXdrGsdj': this.dataForm.xkXdrGsdj,
                'xkXdrSwdj': this.dataForm.xkXdrSwdj,
                'xkXdrSfz': this.dataForm.xkXdrSfz,
                'fddbrxm': this.dataForm.fddbrxm,
                'pjnd': this.dataForm.pjnd,
                'xyjbA': this.dataForm.xyjbA,
                'zgswjg': this.dataForm.zgswjg,
                'sjc': this.dataForm.sjc,
                'zjid': this.dataForm.zjid || undefined
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
