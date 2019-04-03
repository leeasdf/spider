<template>
  <el-dialog
    width="800px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="150px">
    <!-- <el-form-item label="会员主键" prop="memId">
      <el-input v-model="dataForm.memId" placeholder="会员主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="机构名称" prop="ename">
          <el-input v-model="dataForm.ename" placeholder="机构名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="机构代码" prop="orgCode">
          <el-input v-model="dataForm.orgCode" placeholder="机构代码"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="营业收入" prop="operRevenue">
          <el-input v-model="dataForm.operRevenue" placeholder="营业收入"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="所属年度" prop="year">
          <el-date-picker type="year" v-model="dataForm.year" placeholder="所属年度" value-format="yyyy"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="主营业务收入" prop="mainOperRevenue">
          <el-input v-model="dataForm.mainOperRevenue" placeholder="主营业务收入"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="其他业务收入" prop="otherOperRevenue">
          <el-input v-model="dataForm.otherOperRevenue" placeholder="其他业务收入"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="营业成本" prop="operCost">
          <el-input v-model="dataForm.operCost" placeholder="营业成本"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="主营业务成本" prop="mainOperCost">
          <el-input v-model="dataForm.mainOperCost" placeholder="主营业务成本"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="其他业务成本" prop="otherOperCost">
          <el-input v-model="dataForm.otherOperCost" placeholder="其他业务成本"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="营业税金及附加信息" prop="busiTaxSurcharges">
          <el-input v-model="dataForm.busiTaxSurcharges" placeholder="营业税金及附加信息"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="管理费用" prop="adminExpense">
          <el-input v-model="dataForm.adminExpense" placeholder="管理费用"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="销售费用" prop="operExpense">
          <el-input v-model="dataForm.operExpense" placeholder="销售费用"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="财务费用" prop="financeExpense">
          <el-input v-model="dataForm.financeExpense" placeholder="财务费用"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="财产减值损失" prop="assetsLoss">
          <el-input v-model="dataForm.assetsLoss" placeholder="财产减值损失"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
         <el-form-item label="营业利润" prop="operProfit">
          <el-input v-model="dataForm.operProfit" placeholder="营业利润"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="营业外收入" prop="nonBusiIncome">
          <el-input v-model="dataForm.nonBusiIncome" placeholder="营业外收入"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="营业外支出" prop="nonBusiExpense">
          <el-input v-model="dataForm.nonBusiExpense" placeholder="营业外支出"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="利润（亏损）总额" prop="totalProfitLoss">
          <el-input v-model="dataForm.totalProfitLoss" placeholder="利润（亏损）总额"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="所得税" prop="persIncomeTax">
          <el-input v-model="dataForm.persIncomeTax" placeholder="所得税"></el-input>
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
  import { isFloat, isProfit } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      const validateProfit = function (rule, value, callback) {
        if (!isProfit(value)) {
          callback(new Error('请输入整数或浮点型数据'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          memId: '',
          enterpriseId: '',
          year: '',
          orgCode: '',
          ename: '',
          operRevenue: '',
          mainOperRevenue: '',
          otherOperRevenue: '',
          operCost: '',
          mainOperCost: '',
          otherOperCost: '',
          busiTaxSurcharges: '',
          adminExpense: '',
          operExpense: '',
          financeExpense: '',
          assetsLoss: '',
          operProfit: '',
          nonBusiIncome: '',
          nonBusiExpense: '',
          totalProfitLoss: '',
          persIncomeTax: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          memId: [
            { required: true, message: '会员主键不能为空', trigger: 'blur' }
          ],
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '所属年度不能为空', trigger: 'blur' }
          ],
          orgCode: [
            { required: true, message: '机构代码不能为空', trigger: 'blur' }
          ],
          ename: [
            { required: true, message: '机构名称不能为空', trigger: 'blur' }
          ],
          operRevenue: [
            { required: true, message: '营业收入不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          mainOperRevenue: [
            { required: true, message: '主营业务收入不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          otherOperRevenue: [
            { required: true, message: '其他业务收入不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          operCost: [
            { required: true, message: '营业成本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          mainOperCost: [
            { required: true, message: '主营业务成本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          otherOperCost: [
            { required: true, message: '其他业务成本不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          busiTaxSurcharges: [
            { required: true, message: '营业税金及附加信息不能为空', trigger: 'blur' }
          ],
          adminExpense: [
            { required: true, message: '管理费用不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          operExpense: [
            { required: true, message: '销售费用不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          financeExpense: [
            { required: true, message: '财务费用不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          assetsLoss: [
            { required: true, message: '财产减值损失不能为空', trigger: 'blur' },
            { validator: validateProfit, trigger: 'blur' }
          ],
          operProfit: [
            { required: true, message: '营业利润不能为空', trigger: 'blur' },
            { validator: validateProfit, trigger: 'blur' }
          ],
          nonBusiIncome: [
            { required: true, message: '营业外收入不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          nonBusiExpense: [
            { required: true, message: '营业外支出不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          totalProfitLoss: [
            { required: true, message: '利润（亏损）总额不能为空', trigger: 'blur' },
            { validator: validateProfit, trigger: 'blur' }
          ],
          persIncomeTax: [
            { required: true, message: '所得税不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttaxinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memId = data.rptTaxInfo.memId
                this.dataForm.enterpriseId = data.rptTaxInfo.enterpriseId
                this.dataForm.year = data.rptTaxInfo.year
                this.dataForm.orgCode = data.rptTaxInfo.orgCode
                this.dataForm.ename = data.rptTaxInfo.ename
                this.dataForm.operRevenue = data.rptTaxInfo.operRevenue
                this.dataForm.mainOperRevenue = data.rptTaxInfo.mainOperRevenue
                this.dataForm.otherOperRevenue = data.rptTaxInfo.otherOperRevenue
                this.dataForm.operCost = data.rptTaxInfo.operCost
                this.dataForm.mainOperCost = data.rptTaxInfo.mainOperCost
                this.dataForm.otherOperCost = data.rptTaxInfo.otherOperCost
                this.dataForm.busiTaxSurcharges = data.rptTaxInfo.busiTaxSurcharges
                this.dataForm.adminExpense = data.rptTaxInfo.adminExpense
                this.dataForm.operExpense = data.rptTaxInfo.operExpense
                this.dataForm.financeExpense = data.rptTaxInfo.financeExpense
                this.dataForm.assetsLoss = data.rptTaxInfo.assetsLoss
                this.dataForm.operProfit = data.rptTaxInfo.operProfit
                this.dataForm.nonBusiIncome = data.rptTaxInfo.nonBusiIncome
                this.dataForm.nonBusiExpense = data.rptTaxInfo.nonBusiExpense
                this.dataForm.totalProfitLoss = data.rptTaxInfo.totalProfitLoss
                this.dataForm.persIncomeTax = data.rptTaxInfo.persIncomeTax
                this.dataForm.creator = data.rptTaxInfo.creator
                this.dataForm.createTime = data.rptTaxInfo.createTime
                this.dataForm.updater = data.rptTaxInfo.updater
                this.dataForm.updateTime = data.rptTaxInfo.updateTime
                this.dataForm.dataState = data.rptTaxInfo.dataState
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
              url: this.$http.adornUrl(`/spider/rpttaxinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'memId': this.dataForm.memId,
                'enterpriseId': this.dataForm.enterpriseId,
                'year': this.dataForm.year,
                'orgCode': this.dataForm.orgCode,
                'ename': this.dataForm.ename,
                'operRevenue': this.dataForm.operRevenue,
                'mainOperRevenue': this.dataForm.mainOperRevenue,
                'otherOperRevenue': this.dataForm.otherOperRevenue,
                'operCost': this.dataForm.operCost,
                'mainOperCost': this.dataForm.mainOperCost,
                'otherOperCost': this.dataForm.otherOperCost,
                'busiTaxSurcharges': this.dataForm.busiTaxSurcharges,
                'adminExpense': this.dataForm.adminExpense,
                'operExpense': this.dataForm.operExpense,
                'financeExpense': this.dataForm.financeExpense,
                'assetsLoss': this.dataForm.assetsLoss,
                'operProfit': this.dataForm.operProfit,
                'nonBusiIncome': this.dataForm.nonBusiIncome,
                'nonBusiExpense': this.dataForm.nonBusiExpense,
                'totalProfitLoss': this.dataForm.totalProfitLoss,
                'persIncomeTax': this.dataForm.persIncomeTax,
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
