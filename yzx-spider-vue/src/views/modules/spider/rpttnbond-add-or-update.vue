<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <!-- <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="企业名称" prop="entName">
          <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="债券名称" prop="bondName">
          <el-input v-model="dataForm.bondName" placeholder="债券名称"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="债券代码" prop="bondNum">
          <el-input v-model="dataForm.bondNum" placeholder="债券代码"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="发行人" prop="publisherName">
          <el-input v-model="dataForm.publisherName" placeholder="发行人"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="债券类型" prop="bondType">
          <el-input v-model="dataForm.bondType" placeholder="债券类型"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="发行日期" prop="publishTime">
          <el-date-picker v-model="dataForm.publishTime" placeholder="发行日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="债劵到期日" prop="publishExpireTime">
          <el-date-picker type="date" v-model="dataForm.publishExpireTime" placeholder="债劵到期日" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="债劵期限" prop="bondTimeLimit">
          <el-input v-model="dataForm.bondTimeLimit" placeholder="债劵期限"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="上市交易日" prop="bondTradeTime">
          <el-date-picker type="date" v-model="dataForm.bondTradeTime" placeholder="上市交易日" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="计息方式" prop="calInterestType">
          <el-input v-model="dataForm.calInterestType" placeholder="计息方式"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="债劵摘牌日" prop="bondStopTime">
          <el-date-picker type="date" v-model="dataForm.bondStopTime" placeholder="债劵摘牌日" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="信用评级机构" prop="creditRatingGov">
          <el-input v-model="dataForm.creditRatingGov" placeholder="信用评级机构"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="债项评级" prop="debtRating">
          <el-input v-model="dataForm.debtRating" placeholder="债项评级"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="面值" prop="faceValue">
          <el-input v-model="dataForm.faceValue" placeholder="面值">
            <span slot="append">元</span>
          </el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="参考利率" prop="refInterestRate">
          <el-input v-model="dataForm.refInterestRate" placeholder="参考利率">
            <span slot="append">％</span>
          </el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="票面利率" prop="faceInterestRate">
          <el-input v-model="dataForm.faceInterestRate" placeholder="票面利率">
            <span slot="append">％</span>
          </el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="实际发行量" prop="realIssuedQuantity">
          <el-input v-model="dataForm.realIssuedQuantity" placeholder="实际发行量">
            <span slot="append">亿</span>
          </el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="计划发行量" prop="planIssuedQuantity">
          <el-input v-model="dataForm.planIssuedQuantity" placeholder="计划发行量">
            <span slot="append">亿</span>
          </el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="发行价格" prop="issuedPrice">
          <el-input v-model="dataForm.issuedPrice" placeholder="发行价格">
            <span slot="append">元</span>
          </el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="利差（BP）" prop="interestDiff">
          <el-input v-model="dataForm.interestDiff" placeholder="利差（BP）"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="付息频率" prop="payInterestHz">
          <el-input v-model="dataForm.payInterestHz" placeholder="付息频率"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="债劵起息日" prop="startCalInterestTime">
          <el-date-picker type="date" v-model="dataForm.startCalInterestTime" placeholder="债劵起息日" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="行权类型" prop="exeRightType">
          <el-input v-model="dataForm.exeRightType" placeholder="行权类型"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="行权日期" prop="exeRightTime">
          <el-date-picker type="date" v-model="dataForm.exeRightTime" placeholder="行权日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="托管机构" prop="escrowAgent">
          <el-input v-model="dataForm.escrowAgent" placeholder="托管机构"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="范围" prop="flowRange">
          <el-input v-model="dataForm.flowRange" placeholder="范围"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="备注" prop="remark">
          <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="提示" prop="tip">
          <el-input v-model="dataForm.tip" placeholder="提示"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="债券创建时间" prop="bCreateTime">
          <el-date-picker type="date" v-model="dataForm.bCreateTime" placeholder="债券创建时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="债券更新时间" prop="bUpdateTime">
          <el-date-picker type="date" v-model="dataForm.bUpdateTime" placeholder="债券更新时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="删除标识" prop="isDelete">
          <el-input v-model="dataForm.isDelete" placeholder="删除标识"></el-input>
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
    <!-- <el-form-item label="债券ID" prop="bId">
      <el-input v-model="dataForm.bId" placeholder="债券ID"></el-input>
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
          bId: '',
          bondName: '',
          bondNum: '',
          publisherName: '',
          bondType: '',
          publishTime: '',
          publishExpireTime: '',
          bondTimeLimit: '',
          bondTradeTime: '',
          calInterestType: '',
          bondStopTime: '',
          creditRatingGov: '',
          debtRating: '',
          faceValue: '',
          refInterestRate: '',
          faceInterestRate: '',
          realIssuedQuantity: '',
          planIssuedQuantity: '',
          issuedPrice: '',
          interestDiff: '',
          payInterestHz: '',
          startCalInterestTime: '',
          exeRightType: '',
          exeRightTime: '',
          escrowAgent: '',
          flowRange: '',
          remark: '',
          tip: '',
          bCreateTime: '',
          bUpdateTime: '',
          isDelete: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          bId: [
            { required: true, message: '债券ID不能为空', trigger: 'blur' }
          ],
          bondName: [
            { required: true, message: '债券名称不能为空', trigger: 'blur' }
          ],
          bondNum: [
            { required: true, message: '债券代码不能为空', trigger: 'blur' }
          ],
          publisherName: [
            { required: true, message: '发行人不能为空', trigger: 'blur' }
          ],
          bondType: [
            { required: true, message: '债券类型不能为空', trigger: 'blur' }
          ],
          publishTime: [
            { required: true, message: '发行日期不能为空', trigger: 'blur' }
          ],
          publishExpireTime: [
            { required: true, message: '债劵到期日不能为空', trigger: 'blur' }
          ],
          bondTimeLimit: [
            { required: true, message: '债劵期限不能为空', trigger: 'blur' }
          ],
          bondTradeTime: [
            { required: true, message: '上市交易日不能为空', trigger: 'blur' }
          ],
          calInterestType: [
            { required: true, message: '计息方式不能为空', trigger: 'blur' }
          ],
          bondStopTime: [
            { required: true, message: '债劵摘牌日不能为空', trigger: 'blur' }
          ],
          creditRatingGov: [
            { required: true, message: '信用评级机构不能为空', trigger: 'blur' }
          ],
          debtRating: [
            { required: true, message: '债项评级不能为空', trigger: 'blur' }
          ],
          faceValue: [
            { required: true, message: '面值（元）不能为空', trigger: 'blur' }
          ],
          refInterestRate: [
            { required: true, message: '参考利率（％）不能为空', trigger: 'blur' }
          ],
          faceInterestRate: [
            { required: true, message: '票面利率（％）不能为空', trigger: 'blur' }
          ],
          realIssuedQuantity: [
            { required: true, message: '实际发行量（亿）不能为空', trigger: 'blur' }
          ],
          planIssuedQuantity: [
            { required: true, message: '计划发行量（亿）不能为空', trigger: 'blur' }
          ],
          issuedPrice: [
            { required: true, message: '发行价格（元）不能为空', trigger: 'blur' }
          ],
          interestDiff: [
            { required: true, message: '利差（BP）不能为空', trigger: 'blur' }
          ],
          payInterestHz: [
            { required: true, message: '付息频率不能为空', trigger: 'blur' }
          ],
          startCalInterestTime: [
            { required: true, message: '债劵起息日不能为空', trigger: 'blur' }
          ],
          exeRightType: [
            { required: true, message: '行权类型不能为空', trigger: 'blur' }
          ],
          exeRightTime: [
            { required: true, message: '行权日期不能为空', trigger: 'blur' }
          ],
          escrowAgent: [
            { required: true, message: '托管机构不能为空', trigger: 'blur' }
          ],
          flowRange: [
            { required: true, message: '范围不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          tip: [
            { required: true, message: '提示不能为空', trigger: 'blur' }
          ],
          bCreateTime: [
            { required: true, message: '债券创建时间不能为空', trigger: 'blur' }
          ],
          bUpdateTime: [
            { required: true, message: '债券更新时间不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '删除标识不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnbond/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnBond.enterpriseId
                this.dataForm.entName = data.rptTnBond.entName
                this.dataForm.bId = data.rptTnBond.bId
                this.dataForm.bondName = data.rptTnBond.bondName
                this.dataForm.bondNum = data.rptTnBond.bondNum
                this.dataForm.publisherName = data.rptTnBond.publisherName
                this.dataForm.bondType = data.rptTnBond.bondType
                this.dataForm.publishTime = data.rptTnBond.publishTime
                this.dataForm.publishExpireTime = data.rptTnBond.publishExpireTime
                this.dataForm.bondTimeLimit = data.rptTnBond.bondTimeLimit
                this.dataForm.bondTradeTime = data.rptTnBond.bondTradeTime
                this.dataForm.calInterestType = data.rptTnBond.calInterestType
                this.dataForm.bondStopTime = data.rptTnBond.bondStopTime
                this.dataForm.creditRatingGov = data.rptTnBond.creditRatingGov
                this.dataForm.debtRating = data.rptTnBond.debtRating
                this.dataForm.faceValue = data.rptTnBond.faceValue
                this.dataForm.refInterestRate = data.rptTnBond.refInterestRate
                this.dataForm.faceInterestRate = data.rptTnBond.faceInterestRate
                this.dataForm.realIssuedQuantity = data.rptTnBond.realIssuedQuantity
                this.dataForm.planIssuedQuantity = data.rptTnBond.planIssuedQuantity
                this.dataForm.issuedPrice = data.rptTnBond.issuedPrice
                this.dataForm.interestDiff = data.rptTnBond.interestDiff
                this.dataForm.payInterestHz = data.rptTnBond.payInterestHz
                this.dataForm.startCalInterestTime = data.rptTnBond.startCalInterestTime
                this.dataForm.exeRightType = data.rptTnBond.exeRightType
                this.dataForm.exeRightTime = data.rptTnBond.exeRightTime
                this.dataForm.escrowAgent = data.rptTnBond.escrowAgent
                this.dataForm.flowRange = data.rptTnBond.flowRange
                this.dataForm.remark = data.rptTnBond.remark
                this.dataForm.tip = data.rptTnBond.tip
                this.dataForm.bCreateTime = data.rptTnBond.bCreateTime
                this.dataForm.bUpdateTime = data.rptTnBond.bUpdateTime
                this.dataForm.isDelete = data.rptTnBond.isDelete
                this.dataForm.dataState = data.rptTnBond.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnbond/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'bId': this.dataForm.bId,
                'bondName': this.dataForm.bondName,
                'bondNum': this.dataForm.bondNum,
                'publisherName': this.dataForm.publisherName,
                'bondType': this.dataForm.bondType,
                'publishTime': this.dataForm.publishTime,
                'publishExpireTime': this.dataForm.publishExpireTime,
                'bondTimeLimit': this.dataForm.bondTimeLimit,
                'bondTradeTime': this.dataForm.bondTradeTime,
                'calInterestType': this.dataForm.calInterestType,
                'bondStopTime': this.dataForm.bondStopTime,
                'creditRatingGov': this.dataForm.creditRatingGov,
                'debtRating': this.dataForm.debtRating,
                'faceValue': this.dataForm.faceValue,
                'refInterestRate': this.dataForm.refInterestRate,
                'faceInterestRate': this.dataForm.faceInterestRate,
                'realIssuedQuantity': this.dataForm.realIssuedQuantity,
                'planIssuedQuantity': this.dataForm.planIssuedQuantity,
                'issuedPrice': this.dataForm.issuedPrice,
                'interestDiff': this.dataForm.interestDiff,
                'payInterestHz': this.dataForm.payInterestHz,
                'startCalInterestTime': this.dataForm.startCalInterestTime,
                'exeRightType': this.dataForm.exeRightType,
                'exeRightTime': this.dataForm.exeRightTime,
                'escrowAgent': this.dataForm.escrowAgent,
                'flowRange': this.dataForm.flowRange,
                'remark': this.dataForm.remark,
                'tip': this.dataForm.tip,
                'bCreateTime': this.dataForm.bCreateTime,
                'bUpdateTime': this.dataForm.bUpdateTime,
                'isDelete': this.dataForm.isDelete,
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
