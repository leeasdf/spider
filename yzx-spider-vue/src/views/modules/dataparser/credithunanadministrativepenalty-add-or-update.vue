<template>
  <el-dialog
    width="740px"
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="120px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="案件名称" prop="caseName">
            <el-input v-model="dataForm.caseName" placeholder="案件名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="决定书文号" prop="caseNo">
            <el-input v-model="dataForm.caseNo" placeholder="行政处罚决定书文号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="行政相对人名称" prop="caseObject">
            <el-input v-model="dataForm.caseObject" placeholder="行政相对人名称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="法人/负责人" prop="representative">
            <el-input v-model="dataForm.representative" placeholder="法定代表人（或单位负责人）"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="执法部门" prop="lowDepartment">
            <el-input v-model="dataForm.lowDepartment" placeholder="执法部门"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="决定日期" prop="punishmentDate">
            <el-date-picker v-model="dataForm.punishmentDate" placeholder="决定日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="发布日期" prop="issueDate">
            <el-date-picker v-model="dataForm.issueDate" placeholder="发布日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="行政处罚决定书" prop="content">
        <el-input type="textarea" v-model="dataForm.content" placeholder="行政处罚决定书"></el-input>
      </el-form-item>
      
   <!--  <el-form-item label="爬虫表数据记录id" prop="spiderId">
      <el-input v-model="dataForm.spiderId" placeholder="爬虫表数据记录id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item> -->
    
   <!-- <el-form-item label="版本号" prop="version">
      <el-input v-model="dataForm.version" placeholder="版本号"></el-input>
    </el-form-item>
    <el-form-item label="数据状态" prop="dataStatus">
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
          caseName: '',
          caseNo: '',
          caseObject: '',
          representative: '',
          lowDepartment: '',
          punishmentDate: '',
          content: '',
          issueDate: '',
          spiderId: '',
          createTime: '',
          updateTime: '',
          remark: '',
          version: '',
          dataStatus: ''
        },
        dataRule: {
          caseName: [
            { required: true, message: '案件名称不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '行政处罚决定书文号不能为空', trigger: 'blur' }
          ],
          caseObject: [
            { required: true, message: '行政相对人名称不能为空', trigger: 'blur' }
          ],
          representative: [
            { required: true, message: '法定代表人（或单位负责人）不能为空', trigger: 'blur' }
          ],
          lowDepartment: [
            { required: true, message: '执法部门不能为空', trigger: 'blur' }
          ],
          punishmentDate: [
            { required: true, message: '作出行政处罚的日期不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '行政处罚决定书（全文或摘要）不能为空', trigger: 'blur' }
          ],
          issueDate: [
            { required: true, message: '发布日期不能为空', trigger: 'blur' }
          ]
//          ,
          /* spiderId: [
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
              url: this.$http.adornUrl(`/dataparser/credithunanadministrativepenalty/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.caseName = data.credithunanAdministrativePenalty.caseName
                this.dataForm.caseNo = data.credithunanAdministrativePenalty.caseNo
                this.dataForm.caseObject = data.credithunanAdministrativePenalty.caseObject
                this.dataForm.representative = data.credithunanAdministrativePenalty.representative
                this.dataForm.lowDepartment = data.credithunanAdministrativePenalty.lowDepartment
                this.dataForm.punishmentDate = data.credithunanAdministrativePenalty.punishmentDate
                this.dataForm.content = data.credithunanAdministrativePenalty.content
                this.dataForm.issueDate = data.credithunanAdministrativePenalty.issueDate
                this.dataForm.spiderId = data.credithunanAdministrativePenalty.spiderId
                this.dataForm.createTime = data.credithunanAdministrativePenalty.createTime
                this.dataForm.updateTime = data.credithunanAdministrativePenalty.updateTime
                this.dataForm.remark = data.credithunanAdministrativePenalty.remark
                this.dataForm.version = data.credithunanAdministrativePenalty.version
                this.dataForm.dataStatus = data.credithunanAdministrativePenalty.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/credithunanadministrativepenalty/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'caseName': this.dataForm.caseName,
                'caseNo': this.dataForm.caseNo,
                'caseObject': this.dataForm.caseObject,
                'representative': this.dataForm.representative,
                'lowDepartment': this.dataForm.lowDepartment,
                'punishmentDate': this.dataForm.punishmentDate,
                'content': this.dataForm.content,
                'issueDate': this.dataForm.issueDate,
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
