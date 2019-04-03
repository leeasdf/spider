<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    
    <el-form-item label="孵化器企业ID" prop="incubatorEnterpriseId">
      <el-input v-model="dataForm.incubatorEnterpriseId" placeholder="孵化器企业ID"></el-input>
    </el-form-item>
    <el-form-item label="孵化器名称" prop="incubatorName">
      <el-input v-model="dataForm.incubatorName" placeholder="孵化器名称"></el-input>
    </el-form-item>
    <el-form-item label="企业名称" prop="enterpriseName">
      <el-input v-model="dataForm.enterpriseName" placeholder="企业名称"></el-input>
    </el-form-item>
    <el-form-item label="楼栋房号" prop="buildingRoomNo">
      <el-input v-model="dataForm.buildingRoomNo" placeholder="楼栋房号"></el-input>
    </el-form-item>
    <el-form-item label="费用类型" prop="costType">
      <el-input v-model="dataForm.costType" placeholder="费用类型"></el-input>
    </el-form-item>
    <el-form-item label="年月份" prop="yearMonth">
      <el-date-picker type="month" format="yyyyMM" value-format="yyyyMM" v-model="dataForm.yearMonth" placeholder="年月份"></el-date-picker>
    </el-form-item>
    <el-form-item label="额度类型" prop="costLimitType">
      <el-input v-model="dataForm.costLimitType" placeholder="额度类型"></el-input>
    </el-form-item>
    <el-form-item label="数量" prop="quantity">
      <el-input v-model="dataForm.quantity" placeholder="数量"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
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
          callback(new Error('请输入数字'))
        } else {
          callback()
        }
      }
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          incubatorEnterpriseId: '',
          incubatorName: '',
          enterpriseName: '',
          buildingRoomNo: '',
          costType: '',
          yearMonth: '',
          costLimitType: '',
          quantity: '',
          remark: '',
          createtime: ''
        },
        dataRule: {
          enterpriseId: [
            { required: true, message: '企业ID不能为空', trigger: 'blur' }
          ],
          incubatorEnterpriseId: [
            { required: true, message: '孵化器企业ID不能为空', trigger: 'blur' }
          ],
          incubatorName: [
            { required: true, message: '孵化器名称不能为空', trigger: 'blur' }
          ],
          enterpriseName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          buildingRoomNo: [
            { required: true, message: '楼栋房号不能为空', trigger: 'blur' }
          ],
          costType: [
            { required: true, message: '费用类型不能为空', trigger: 'blur' }
          ],
          yearMonth: [
            { required: true, message: '年月份不能为空', trigger: 'blur' }
          ],
          costLimitType: [
            { required: true, message: '额度类型不能为空', trigger: 'blur' }
          ],
          quantity: [
            { required: true, message: '数量不能为空', trigger: 'blur' },
            { validator: validateFloat, trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/enterprisewaterelectricity/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.enterpriseWaterElectricity.enterpriseId
                this.dataForm.incubatorEnterpriseId = data.enterpriseWaterElectricity.incubatorEnterpriseId
                this.dataForm.incubatorName = data.enterpriseWaterElectricity.incubatorName
                this.dataForm.enterpriseName = data.enterpriseWaterElectricity.enterpriseName
                this.dataForm.buildingRoomNo = data.enterpriseWaterElectricity.buildingRoomNo
                this.dataForm.costType = data.enterpriseWaterElectricity.costType
                this.dataForm.yearMonth = data.enterpriseWaterElectricity.yearMonth
                this.dataForm.costLimitType = data.enterpriseWaterElectricity.costLimitType
                this.dataForm.quantity = data.enterpriseWaterElectricity.quantity
                this.dataForm.remark = data.enterpriseWaterElectricity.remark
                this.dataForm.createtime = data.enterpriseWaterElectricity.createtime
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
              url: this.$http.adornUrl(`/spider/enterprisewaterelectricity/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'incubatorEnterpriseId': this.dataForm.incubatorEnterpriseId,
                'incubatorName': this.dataForm.incubatorName,
                'enterpriseName': this.dataForm.enterpriseName,
                'buildingRoomNo': this.dataForm.buildingRoomNo,
                'costType': this.dataForm.costType,
                'yearMonth': this.dataForm.yearMonth,
                'costLimitType': this.dataForm.costLimitType,
                'quantity': this.dataForm.quantity,
                'remark': this.dataForm.remark,
                'createtime': this.dataForm.createtime
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
