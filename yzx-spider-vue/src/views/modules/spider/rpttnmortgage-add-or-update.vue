<template>
  <el-dialog
    width="820px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="160px">
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
        <el-form-item label="被担保债权数额" prop="overviewAmount">
          <el-input v-model="dataForm.overviewAmount" placeholder="被担保债权数额"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="抵押权人信息" prop="peopleInfo">
          <el-input v-model="dataForm.peopleInfo" placeholder="抵押权人信息"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="状态" prop="status">
          <el-input v-model="dataForm.status" placeholder="状态"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="担保范围" prop="overviewScope">
          <el-input v-model="dataForm.overviewScope" placeholder="担保范围"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="金额" prop="amount">
          <el-input v-model="dataForm.amount" placeholder="金额"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="登记机关" prop="regDepartment">
          <el-input v-model="dataForm.regDepartment" placeholder="登记机关"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="登记日期" prop="regDate">
          <el-date-picker v-model="dataForm.regDate" placeholder="登记日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="担保时间" prop="overviewTerm">
          <el-date-picker type="date" v-model="dataForm.overviewTerm" placeholder="担保时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="登记编号" prop="regNum">
          <el-input v-model="dataForm.regNum" placeholder="登记编号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="债务人履行债务期限" prop="term">
          <el-input v-model="dataForm.term" placeholder="债务人履行债务期限"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="公布日期" prop="publishDate">
          <el-date-picker v-model="dataForm.publishDate" placeholder="公布日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="动产抵押登记信息" prop="changeInfoList">
          <el-input v-model="dataForm.changeInfoList" placeholder="动产抵押登记信息"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="抵押物信息" prop="pawnInfoList">
          <el-input v-model="dataForm.pawnInfoList" placeholder="抵押物信息"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <!-- <el-form-item label="担保ID" prop="mId">
      <el-input v-model="dataForm.mId" placeholder="担保ID"></el-input>
    </el-form-item> -->
    <el-form-item label="经营范围" prop="scope">
      <el-input type="textarea" v-model="dataForm.scope" placeholder="经营范围"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataState">
      <el-radio-group v-model="dataForm.dataState">
        <el-radio :label="1">正常</el-radio>
        <el-radio :label="0">删除</el-radio>
      </el-radio-group>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  import { isFloat } from '@/utils/validate'
  export default {
    data () {
      const validateFloat = function (rule, value, callback) {
        if (!isFloat(value)) {
          callback(new Error('请输入整型或浮点型数据'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          entName: '',
          overviewAmount: '',
          scope: '',
          status: '',
          overviewScope: '',
          mId: '',
          amount: '',
          regDepartment: '',
          regDate: '',
          overviewTerm: '',
          regNum: '',
          term: '',
          publishDate: '',
          changeInfoList: '',
          pawnInfoList: '',
          peopleInfo: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          overviewAmount: [
            { required: true, message: '被担保债权数额不能为空', trigger: 'blur' }
          ],
          scope: [
            { required: true, message: '经营范围不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          overviewScope: [
            { required: true, message: '担保范围不能为空', trigger: 'blur' }
          ],
          mId: [
            { required: true, message: '担保ID不能为空', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '金额不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          regDepartment: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          regDate: [
            { required: true, message: '登记日期不能为空', trigger: 'blur' }
          ],
          overviewTerm: [
            { required: true, message: '担保时间不能为空', trigger: 'blur' }
          ],
          regNum: [
            { required: true, message: '登记编号不能为空', trigger: 'blur' }
          ],
          term: [
            { required: true, message: '债务人履行债务期限不能为空', trigger: 'blur' }
          ],
          publishDate: [
            { required: true, message: '公布日期不能为空', trigger: 'blur' }
          ],
          changeInfoList: [
            { required: true, message: '动产抵押登记信息不能为空', trigger: 'blur' }
          ],
          pawnInfoList: [
            { required: true, message: '抵押物信息不能为空', trigger: 'blur' }
          ],
          peopleInfo: [
            { required: true, message: '抵押权人信息不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnmortgage/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnMortgage.enterpriseId
                this.dataForm.entName = data.rptTnMortgage.entName
                this.dataForm.overviewAmount = data.rptTnMortgage.overviewAmount
                this.dataForm.scope = data.rptTnMortgage.scope
                this.dataForm.status = data.rptTnMortgage.status
                this.dataForm.overviewScope = data.rptTnMortgage.overviewScope
                this.dataForm.mId = data.rptTnMortgage.mId
                this.dataForm.amount = data.rptTnMortgage.amount
                this.dataForm.regDepartment = data.rptTnMortgage.regDepartment
                this.dataForm.regDate = data.rptTnMortgage.regDate
                this.dataForm.overviewTerm = data.rptTnMortgage.overviewTerm
                this.dataForm.regNum = data.rptTnMortgage.regNum
                this.dataForm.term = data.rptTnMortgage.term
                this.dataForm.publishDate = data.rptTnMortgage.publishDate
                this.dataForm.changeInfoList = data.rptTnMortgage.changeInfoList
                this.dataForm.pawnInfoList = data.rptTnMortgage.pawnInfoList
                this.dataForm.peopleInfo = data.rptTnMortgage.peopleInfo
                this.dataForm.creator = data.rptTnMortgage.creator
                this.dataForm.createTime = data.rptTnMortgage.createTime
                this.dataForm.updater = data.rptTnMortgage.updater
                this.dataForm.updateTime = data.rptTnMortgage.updateTime
                this.dataForm.dataState = data.rptTnMortgage.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnmortgage/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'overviewAmount': this.dataForm.overviewAmount,
                'scope': this.dataForm.scope,
                'status': this.dataForm.status,
                'overviewScope': this.dataForm.overviewScope,
                'mId': this.dataForm.mId,
                'amount': this.dataForm.amount,
                'regDepartment': this.dataForm.regDepartment,
                'regDate': this.dataForm.regDate,
                'overviewTerm': this.dataForm.overviewTerm,
                'regNum': this.dataForm.regNum,
                'term': this.dataForm.term,
                'publishDate': this.dataForm.publishDate,
                'changeInfoList': this.dataForm.changeInfoList,
                'pawnInfoList': this.dataForm.pawnInfoList,
                'peopleInfo': this.dataForm.peopleInfo,
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
