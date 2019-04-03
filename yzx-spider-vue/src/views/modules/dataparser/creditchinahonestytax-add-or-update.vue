<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
    <!--<el-form-item label="序号" prop="no">-->
      <!--<el-input v-model="dataForm.no" placeholder="序号"></el-input>-->
    <!--</el-form-item>-->
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="纳税人名称" prop="taxName">
          <el-input v-model="dataForm.taxName" placeholder="纳税人名称"></el-input>
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
        <el-form-item label="数据类别" prop="type">
          <el-input v-model="dataForm.type" placeholder="数据类别"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="评价年度" prop="year">
          <el-date-picker type="year" v-model="dataForm.year" placeholder="评价年度" value-format="yyyy"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="最新更新日期" prop="lastUpdateTime">
          <el-date-picker v-model="dataForm.lastUpdateTime" placeholder="最新更新日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="文件名" prop="fileName">
          <el-input v-model="dataForm.fileName" placeholder="文件名"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <!-- <el-form-item label="信用类型中间记录表数据记录id" prop="creditTypeRecordId">
      <el-input v-model="dataForm.creditTypeRecordId" placeholder="信用类型中间记录表数据记录id"></el-input>
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
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
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
          no: '',
          source: '',
          type: '',
          fileName: '',
          lastUpdateTime: '',
          taxName: '',
          year: '',
          creditTypeRecordId: '',
          spiderId: '',
          createTime: '',
          updateTime: '',
          remark: '',
          dataStatus: ''
        },
        dataRule: {
//          no: [
//            { required: true, message: '序号不能为空', trigger: 'blur' }
//          ],
          source: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '数据类别不能为空', trigger: 'blur' }
          ],
//          fileName: [
//            { required: true, message: '文件名不能为空', trigger: 'blur' }
//          ],
          lastUpdateTime: [
            { required: true, message: '最新更新日期不能为空', trigger: 'blur' }
          ],
          taxName: [
            { required: true, message: '纳税人名称不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '评价年度不能为空', trigger: 'blur' }
          ]
//          ,
          /*
          creditTypeRecordId: [
            { required: true, message: '信用类型中间记录表数据记录id不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/dataparser/creditchinahonestytax/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.no = data.creditchinaHonestyTax.no
                this.dataForm.source = data.creditchinaHonestyTax.source
                this.dataForm.type = data.creditchinaHonestyTax.type
                this.dataForm.fileName = data.creditchinaHonestyTax.fileName
                this.dataForm.lastUpdateTime = data.creditchinaHonestyTax.lastUpdateTime
                this.dataForm.taxName = data.creditchinaHonestyTax.taxName
                this.dataForm.year = data.creditchinaHonestyTax.year
                this.dataForm.creditTypeRecordId = data.creditchinaHonestyTax.creditTypeRecordId
                this.dataForm.spiderId = data.creditchinaHonestyTax.spiderId
                this.dataForm.createTime = data.creditchinaHonestyTax.createTime
                this.dataForm.updateTime = data.creditchinaHonestyTax.updateTime
                this.dataForm.remark = data.creditchinaHonestyTax.remark
                this.dataForm.dataStatus = data.creditchinaHonestyTax.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/creditchinahonestytax/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'no': this.dataForm.no,
                'source': this.dataForm.source,
                'type': this.dataForm.type,
                'fileName': this.dataForm.fileName,
                'lastUpdateTime': this.dataForm.lastUpdateTime,
                'taxName': this.dataForm.taxName,
                'year': this.dataForm.year,
                'creditTypeRecordId': this.dataForm.creditTypeRecordId,
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
