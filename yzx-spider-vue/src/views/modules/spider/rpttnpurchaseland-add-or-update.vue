<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业名称" prop="entName">
            <el-input v-model="dataForm.entName" placeholder="企业名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行政区" prop="adminRegion">
            <el-input v-model="dataForm.adminRegion" placeholder="行政区"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="电子监管号" prop="elecSupervisorNo">
            <el-input v-model="dataForm.elecSupervisorNo" placeholder="电子监管号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="签订日期" prop="signedDate">
            <el-date-picker type="date" v-model="dataForm.signedDate" placeholder="签订日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="供地总面积" prop="totalArea">
            <el-input v-model="dataForm.totalArea" placeholder="供地总面积">
              <span slot="append">公顷</span>
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="宗地位置" prop="location">
            <el-input v-model="dataForm.location" placeholder="宗地位置"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="受让人" prop="assignee">
            <el-input v-model="dataForm.assignee" placeholder="受让人"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="上级公司" prop="parentCompany">
            <el-input v-model="dataForm.parentCompany" placeholder="上级公司"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="土地用途" prop="purpose">
            <el-input v-model="dataForm.purpose" placeholder="土地用途"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="供应方式" prop="supplyWay">
            <el-input v-model="dataForm.supplyWay" placeholder="供应方式"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="最小容积率" prop="minVolume">
            <el-input v-model="dataForm.minVolume" placeholder="最小容积率"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="最大容积率" prop="maxVolume">
            <el-input v-model="dataForm.maxVolume" placeholder="最大容积率"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="成交价款" prop="dealPrice">
            <el-input v-model="dataForm.dealPrice" placeholder="成交价款">
              <span slot="append">万元</span>
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="约定动工时间" prop="startTime">
            <el-date-picker type="date" v-model="dataForm.startTime" placeholder="约定动工时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="链接地址" prop="linkUrl">
            <el-input v-model="dataForm.linkUrl" placeholder="链接地址"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="约定竣工时间" prop="endTime">
            <el-date-picker type="date" v-model="dataForm.endTime" placeholder="约定竣工时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
    <!-- <el-form-item label="企业主键" prop="enterpriseId">
      <el-input v-model="dataForm.enterpriseId" placeholder="企业主键"></el-input>
    </el-form-item> -->
    
    <!-- <el-form-item label="购地ID" prop="plId">
      <el-input v-model="dataForm.plId" placeholder="购地ID"></el-input>
    </el-form-item> -->
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
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          entName: '',
          plId: '',
          adminRegion: '',
          elecSupervisorNo: '',
          signedDate: '',
          totalArea: '',
          location: '',
          assignee: '',
          parentCompany: '',
          purpose: '',
          supplyWay: '',
          minVolume: '',
          maxVolume: '',
          dealPrice: '',
          startTime: '',
          linkUrl: '',
          endTime: '',
          plCreateTime: '',
          plUpdateTime: '',
          dataState: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          plId: [
            { required: true, message: '购地ID不能为空', trigger: 'blur' }
          ],
          adminRegion: [
            { required: true, message: '行政区不能为空', trigger: 'blur' }
          ],
          elecSupervisorNo: [
            { required: true, message: '电子监管号不能为空', trigger: 'blur' }
          ],
          signedDate: [
            { required: true, message: '签订日期不能为空', trigger: 'blur' }
          ],
          totalArea: [
            { required: true, message: '供地总面积不能为空', trigger: 'blur' }
          ],
          location: [
            { required: true, message: '宗地位置不能为空', trigger: 'blur' }
          ],
          assignee: [
            { required: true, message: '受让人不能为空', trigger: 'blur' }
          ],
          parentCompany: [
            { required: true, message: '上级公司不能为空', trigger: 'blur' }
          ],
          purpose: [
            { required: true, message: '土地用途不能为空', trigger: 'blur' }
          ],
          supplyWay: [
            { required: true, message: '供应方式不能为空', trigger: 'blur' }
          ],
          minVolume: [
            { required: true, message: '最小容积率不能为空', trigger: 'blur' }
          ],
          maxVolume: [
            { required: true, message: '最大容积率不能为空', trigger: 'blur' }
          ],
          dealPrice: [
            { required: true, message: '成交价款不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '约定动工时间不能为空', trigger: 'blur' }
          ],
          linkUrl: [
            { required: true, message: '链接地址不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '约定竣工时间不能为空', trigger: 'blur' }
          ],
          plCreateTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          plUpdateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttnpurchaseland/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnPurchaseland.enterpriseId
                this.dataForm.entName = data.rptTnPurchaseland.entName
                this.dataForm.plId = data.rptTnPurchaseland.plId
                this.dataForm.adminRegion = data.rptTnPurchaseland.adminRegion
                this.dataForm.elecSupervisorNo = data.rptTnPurchaseland.elecSupervisorNo
                this.dataForm.signedDate = data.rptTnPurchaseland.signedDate
                this.dataForm.totalArea = data.rptTnPurchaseland.totalArea
                this.dataForm.location = data.rptTnPurchaseland.location
                this.dataForm.assignee = data.rptTnPurchaseland.assignee
                this.dataForm.parentCompany = data.rptTnPurchaseland.parentCompany
                this.dataForm.purpose = data.rptTnPurchaseland.purpose
                this.dataForm.supplyWay = data.rptTnPurchaseland.supplyWay
                this.dataForm.minVolume = data.rptTnPurchaseland.minVolume
                this.dataForm.maxVolume = data.rptTnPurchaseland.maxVolume
                this.dataForm.dealPrice = data.rptTnPurchaseland.dealPrice
                this.dataForm.startTime = data.rptTnPurchaseland.startTime
                this.dataForm.linkUrl = data.rptTnPurchaseland.linkUrl
                this.dataForm.endTime = data.rptTnPurchaseland.endTime
                this.dataForm.plCreateTime = data.rptTnPurchaseland.plCreateTime
                this.dataForm.plUpdateTime = data.rptTnPurchaseland.plUpdateTime
                this.dataForm.dataState = data.rptTnPurchaseland.dataState
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
              url: this.$http.adornUrl(`/spider/rpttnpurchaseland/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'plId': this.dataForm.plId,
                'adminRegion': this.dataForm.adminRegion,
                'elecSupervisorNo': this.dataForm.elecSupervisorNo,
                'signedDate': this.dataForm.signedDate,
                'totalArea': this.dataForm.totalArea,
                'location': this.dataForm.location,
                'assignee': this.dataForm.assignee,
                'parentCompany': this.dataForm.parentCompany,
                'purpose': this.dataForm.purpose,
                'supplyWay': this.dataForm.supplyWay,
                'minVolume': this.dataForm.minVolume,
                'maxVolume': this.dataForm.maxVolume,
                'dealPrice': this.dataForm.dealPrice,
                'startTime': this.dataForm.startTime,
                'linkUrl': this.dataForm.linkUrl,
                'endTime': this.dataForm.endTime,
                'plCreateTime': this.dataForm.plCreateTime,
                'plUpdateTime': this.dataForm.plUpdateTime,
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
