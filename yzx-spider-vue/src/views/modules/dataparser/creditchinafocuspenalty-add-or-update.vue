<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="处罚对象名称" prop="punishmentObject">
            <el-input v-model="dataForm.punishmentObject" placeholder="处罚对象名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="实际处罚部门" prop="punishmentDepart">
            <el-input v-model="dataForm.punishmentDepart" placeholder="实际处罚部门"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="处罚机关" prop="punishmentOrgan">
            <el-input v-model="dataForm.punishmentOrgan" placeholder="处罚机关"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="处罚处理日期" prop="punishmentDate">
            <el-date-picker v-model="dataForm.punishmentDate" placeholder="处罚处理日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
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
          <el-form-item label="处罚处理名称" prop="punishmentName">
            <el-input v-model="dataForm.punishmentName" placeholder="处罚处理名称"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="处罚决定书ID" prop="penaltyDecision">
            <el-input v-model="dataForm.penaltyDecision" placeholder="处罚决定书ID"></el-input>
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
          <el-form-item label="处罚处理种类" prop="punishmentType">
            <el-input v-model="dataForm.punishmentType" placeholder="处罚处理种类"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="信息类型" prop="informationType">
            <el-input v-model="dataForm.informationType" placeholder="信息类型"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    <!-- <el-form-item label="最新更新日期" prop="lastUpdateTime">
      <el-input v-model="dataForm.lastUpdateTime" placeholder="最新更新日期"></el-input>
    </el-form-item> -->
    <el-form-item label="处罚处理内容" prop="punishmentContent">
      <el-input type="textarea" v-model="dataForm.punishmentContent" placeholder="处罚处理内容"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
   <!--  <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    
    <!--<el-form-item label="数据状态" prop="dataStatus">
      <el-input v-model="dataForm.dataStatus" placeholder="数据状态"></el-input>
    </el-form-item>-->
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
          punishmentDate: '',
          punishmentObject: '',
          punishmentDepart: '',
          punishmentOrgan: '',
          type: '',
          punishmentName: '',
          lastUpdateTime: '',
          penaltyDecision: '',
          source: '',
          informationType: '',
          punishmentContent: '',
          punishmentType: '',
          createTime: '',
          updateTime: '',
          remark: '',
          dataStatus: ''
        },
        dataRule: {
          punishmentDate: [
            { required: true, message: '处罚处理日期不能为空', trigger: 'blur' }
          ],
          punishmentObject: [
            { required: true, message: '处罚对象名称不能为空', trigger: 'blur' }
          ],
          punishmentDepart: [
            { required: true, message: '实际处罚部门不能为空', trigger: 'blur' }
          ],
          punishmentOrgan: [
            { required: true, message: '处罚机关不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '数据类别不能为空', trigger: 'blur' }
          ],
          punishmentName: [
            { required: true, message: '处罚处理名称不能为空', trigger: 'blur' }
          ],
          /* lastUpdateTime: [
            { required: true, message: '最新更新日期不能为空', trigger: 'blur' }
          ], */
          penaltyDecision: [
            { required: true, message: '处罚决定书ID不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '数据来源不能为空', trigger: 'blur' }
          ],
          informationType: [
            { required: true, message: '信息类型不能为空', trigger: 'blur' }
          ],
          punishmentContent: [
            { required: true, message: '处罚处理内容不能为空', trigger: 'blur' }
          ],
          punishmentType: [
            { required: true, message: '处罚处理种类不能为空', trigger: 'blur' }
          ]
          /* ,createTime: [
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
              url: this.$http.adornUrl(`/dataparser/creditchinafocuspenalty/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.punishmentDate = data.creditchinaFocusPenalty.punishmentDate
                this.dataForm.punishmentObject = data.creditchinaFocusPenalty.punishmentObject
                this.dataForm.punishmentDepart = data.creditchinaFocusPenalty.punishmentDepart
                this.dataForm.punishmentOrgan = data.creditchinaFocusPenalty.punishmentOrgan
                this.dataForm.type = data.creditchinaFocusPenalty.type
                this.dataForm.punishmentName = data.creditchinaFocusPenalty.punishmentName
                this.dataForm.lastUpdateTime = data.creditchinaFocusPenalty.lastUpdateTime
                this.dataForm.penaltyDecision = data.creditchinaFocusPenalty.penaltyDecision
                this.dataForm.source = data.creditchinaFocusPenalty.source
                this.dataForm.informationType = data.creditchinaFocusPenalty.informationType
                this.dataForm.punishmentContent = data.creditchinaFocusPenalty.punishmentContent
                this.dataForm.punishmentType = data.creditchinaFocusPenalty.punishmentType
                this.dataForm.createTime = data.creditchinaFocusPenalty.createTime
                this.dataForm.updateTime = data.creditchinaFocusPenalty.updateTime
                this.dataForm.remark = data.creditchinaFocusPenalty.remark
                this.dataForm.dataStatus = data.creditchinaFocusPenalty.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/creditchinafocuspenalty/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'punishmentDate': this.dataForm.punishmentDate,
                'punishmentObject': this.dataForm.punishmentObject,
                'punishmentDepart': this.dataForm.punishmentDepart,
                'punishmentOrgan': this.dataForm.punishmentOrgan,
                'type': this.dataForm.type,
                'punishmentName': this.dataForm.punishmentName,
                'lastUpdateTime': this.dataForm.lastUpdateTime,
                'penaltyDecision': this.dataForm.penaltyDecision,
                'source': this.dataForm.source,
                'informationType': this.dataForm.informationType,
                'punishmentContent': this.dataForm.punishmentContent,
                'punishmentType': this.dataForm.punishmentType,
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
