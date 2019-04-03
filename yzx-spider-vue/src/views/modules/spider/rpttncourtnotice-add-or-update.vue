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
        <el-form-item label="公告时间" prop="publishdate">
          <el-date-picker type="date" v-model="dataForm.publishdate" placeholder="公告时间" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="上诉方" prop="party1">
          <el-input v-model="dataForm.party1" placeholder="上诉方"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="被诉方" prop="party2">
          <el-input v-model="dataForm.party2" placeholder="被诉方"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公告类型" prop="bltntypename">
          <el-input v-model="dataForm.bltntypename" placeholder="公告类型"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="法院编码" prop="courtcode">
          <el-input v-model="dataForm.courtcode" placeholder="法院编码"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公告原因" prop="reason">
          <el-input v-model="dataForm.reason" placeholder="公告原因"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="公告编号" prop="bltnno">
          <el-input v-model="dataForm.bltnno" placeholder="公告编号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公告状态" prop="bltnstate">
          <el-input v-model="dataForm.bltnstate" placeholder="公告状态"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="判决人联系方式" prop="judgephone">
          <el-input v-model="dataForm.judgephone" placeholder="判决人联系方式"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="公告类别" prop="bltntype">
          <el-input v-model="dataForm.bltntype" placeholder="公告类别"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="刊登日期" prop="showtxtdate">
          <el-date-picker type="date" v-model="dataForm.showtxtdate" placeholder="刊登日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="省份" prop="province">
          <el-input v-model="dataForm.province" placeholder="省份"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="临时保存编号" prop="tmpsaversn">
          <el-input v-model="dataForm.tmpsaversn" placeholder="临时保存编号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="发布界面" prop="publishpage">
          <el-input v-model="dataForm.publishpage" placeholder="发布界面"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
         <el-form-item label="法院标识" prop="courtflag">
          <el-input v-model="dataForm.courtflag" placeholder="法院标识"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="判决人" prop="judge">
          <el-input v-model="dataForm.judge" placeholder="判决人"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="案件编号" prop="caseno">
          <el-input v-model="dataForm.caseno" placeholder="案件编号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-form-item label="联系方式" prop="mobilephone">
          <el-input v-model="dataForm.mobilephone" placeholder="联系方式"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="cn编号" prop="cnId">
          <el-input v-model="dataForm.cnId" placeholder="cn编号"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        
      </el-col>
      <el-col :span="12">
        
      </el-col>
    </el-row>
    <el-form-item label="公告内容" prop="content">
      <el-input type="textarea" :autosize="{minRows:1,maxRows:4}" v-model="dataForm.content" placeholder="公告内容"></el-input>
    </el-form-item>
    <el-form-item label="被诉方网址" prop="party2str">
      <el-input v-model="dataForm.party2str" type="textarea" placeholder="被诉方网址"></el-input>
    </el-form-item>
    <!-- <el-form-item label="天眼查ID" prop="tycId">
      <el-input v-model="dataForm.tycId" placeholder="天眼查ID"></el-input>
    </el-form-item> -->
    <el-form-item label="上诉方网址" prop="party1str">
      <el-input v-model="dataForm.party1str" type="textarea" placeholder="上诉方网址"></el-input>
    </el-form-item>
    <!-- <el-form-item label="暂无" prop="customno">
      <el-input v-model="dataForm.customno" placeholder="暂无"></el-input>
    </el-form-item> -->
    <el-form-item label="企业列表" prop="companyList">
      <el-input v-model="dataForm.companyList" type="textarea" placeholder="企业列表"></el-input>
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
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          enterpriseId: '',
          entName: '',
          publishdate: '',
          party1: '',
          party2: '',
          bltntypename: '',
          courtcode: '',
          content: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          announceId: '',
          reason: '',
          bltnno: '',
          bltnstate: '',
          judgephone: '',
          dealgradename: '',
          dealgrade: '',
          province: '',
          bltntype: '',
          showtxtdate: '',
          tmpsaversn: '',
          publishpage: '',
          party2str: '',
          tycId: '',
          judge: '',
          party1str: '',
          caseno: '',
          courtflag: '',
          customno: '',
          mobilephone: '',
          companyList: '',
          cnId: ''
        },
        dataRule: {
          /* enterpriseId: [
            { required: true, message: '企业主键不能为空', trigger: 'blur' }
          ], */
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          publishdate: [
            { required: true, message: '公告时间不能为空', trigger: 'blur' }
          ],
          party1: [
            { required: true, message: '上诉方不能为空', trigger: 'blur' }
          ],
          party2: [
            { required: true, message: '被诉方不能为空', trigger: 'blur' }
          ],
          bltntypename: [
            { required: true, message: '公告类型不能为空', trigger: 'blur' }
          ],
          courtcode: [
            { required: true, message: '法院编码不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '公告内容不能为空', trigger: 'blur' }
          ],
          dataState: [
            { required: true, message: '数据状态不能为空', trigger: 'change' }
          ],
          /* announceId: [
            { required: true, message: '公告ID不能为空', trigger: 'blur' }
          ], */
          reason: [
            { required: true, message: '公告原因不能为空', trigger: 'blur' }
          ],
          bltnno: [
            { required: true, message: '公告编号不能为空', trigger: 'blur' }
          ],
          bltnstate: [
            { required: true, message: '公告状态不能为空', trigger: 'blur' }
          ],
          judgephone: [
            { required: true, message: '判决人联系方式不能为空', trigger: 'blur' }
          ],
         /* dealgradename: [
            { required: true, message: '暂无不能为空', trigger: 'blur' }
          ],
          dealgrade: [
            { required: true, message: '暂无不能为空', trigger: 'blur' }
          ], */
          province: [
            { required: true, message: '省份不能为空', trigger: 'blur' }
          ],
          bltntype: [
            { required: true, message: '公告类别不能为空', trigger: 'blur' }
          ],
          showtxtdate: [
            { required: true, message: '刊登日期不能为空', trigger: 'blur' }
          ],
          tmpsaversn: [
            { required: true, message: '临时保存编号不能为空', trigger: 'blur' }
          ],
          publishpage: [
            { required: true, message: '发布界面不能为空', trigger: 'blur' }
          ],
          party2str: [
            { required: true, message: '被诉方网址不能为空', trigger: 'blur' }
          ],
          /* tycId: [
            { required: true, message: '天眼查ID不能为空', trigger: 'blur' }
          ], */
          judge: [
            { required: true, message: '判决人不能为空', trigger: 'blur' }
          ],
          party1str: [
            { required: true, message: '上诉方网址不能为空', trigger: 'blur' }
          ],
          caseno: [
            { required: true, message: '案件编号不能为空', trigger: 'blur' }
          ],
          courtflag: [
            { required: true, message: '法院标识不能为空', trigger: 'blur' }
          ],
          /* customno: [
            { required: true, message: '暂无不能为空', trigger: 'blur' }
          ], */
          mobilephone: [
            { required: true, message: '联系方式不能为空', trigger: 'blur' }
          ],
          companyList: [
            { required: true, message: '企业列表不能为空', trigger: 'blur' }
          ],
          cnId: [
            { required: true, message: 'cn编号不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/spider/rpttncourtnotice/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterpriseId = data.rptTnCourtNotice.enterpriseId
                this.dataForm.entName = data.rptTnCourtNotice.entName
                this.dataForm.publishdate = data.rptTnCourtNotice.publishdate
                this.dataForm.party1 = data.rptTnCourtNotice.party1
                this.dataForm.party2 = data.rptTnCourtNotice.party2
                this.dataForm.bltntypename = data.rptTnCourtNotice.bltntypename
                this.dataForm.courtcode = data.rptTnCourtNotice.courtcode
                this.dataForm.content = data.rptTnCourtNotice.content
                this.dataForm.creator = data.rptTnCourtNotice.creator
                this.dataForm.createTime = data.rptTnCourtNotice.createTime
                this.dataForm.updater = data.rptTnCourtNotice.updater
                this.dataForm.updateTime = data.rptTnCourtNotice.updateTime
                this.dataForm.dataState = data.rptTnCourtNotice.dataState
                this.dataForm.announceId = data.rptTnCourtNotice.announceId
                this.dataForm.reason = data.rptTnCourtNotice.reason
                this.dataForm.bltnno = data.rptTnCourtNotice.bltnno
                this.dataForm.bltnstate = data.rptTnCourtNotice.bltnstate
                this.dataForm.judgephone = data.rptTnCourtNotice.judgephone
                this.dataForm.dealgradename = data.rptTnCourtNotice.dealgradename
                this.dataForm.dealgrade = data.rptTnCourtNotice.dealgrade
                this.dataForm.province = data.rptTnCourtNotice.province
                this.dataForm.bltntype = data.rptTnCourtNotice.bltntype
                this.dataForm.showtxtdate = data.rptTnCourtNotice.showtxtdate
                this.dataForm.tmpsaversn = data.rptTnCourtNotice.tmpsaversn
                this.dataForm.publishpage = data.rptTnCourtNotice.publishpage
                this.dataForm.party2str = data.rptTnCourtNotice.party2str
                this.dataForm.tycId = data.rptTnCourtNotice.tycId
                this.dataForm.judge = data.rptTnCourtNotice.judge
                this.dataForm.party1str = data.rptTnCourtNotice.party1str
                this.dataForm.caseno = data.rptTnCourtNotice.caseno
                this.dataForm.courtflag = data.rptTnCourtNotice.courtflag
                this.dataForm.customno = data.rptTnCourtNotice.customno
                this.dataForm.mobilephone = data.rptTnCourtNotice.mobilephone
                this.dataForm.companyList = data.rptTnCourtNotice.companyList
                this.dataForm.cnId = data.rptTnCourtNotice.cnId
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
              url: this.$http.adornUrl(`/spider/rpttncourtnotice/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterpriseId': this.dataForm.enterpriseId,
                'entName': this.dataForm.entName,
                'publishdate': this.dataForm.publishdate,
                'party1': this.dataForm.party1,
                'party2': this.dataForm.party2,
                'bltntypename': this.dataForm.bltntypename,
                'courtcode': this.dataForm.courtcode,
                'content': this.dataForm.content,
                'creator': this.dataForm.creator,
                'createTime': this.dataForm.createTime,
                'updater': this.dataForm.updater,
                'updateTime': this.dataForm.updateTime,
                'dataState': this.dataForm.dataState,
                'announceId': this.dataForm.announceId,
                'reason': this.dataForm.reason,
                'bltnno': this.dataForm.bltnno,
                'bltnstate': this.dataForm.bltnstate,
                'judgephone': this.dataForm.judgephone,
                'dealgradename': this.dataForm.dealgradename,
                'dealgrade': this.dataForm.dealgrade,
                'province': this.dataForm.province,
                'bltntype': this.dataForm.bltntype,
                'showtxtdate': this.dataForm.showtxtdate,
                'tmpsaversn': this.dataForm.tmpsaversn,
                'publishpage': this.dataForm.publishpage,
                'party2str': this.dataForm.party2str,
                'tycId': this.dataForm.tycId,
                'judge': this.dataForm.judge,
                'party1str': this.dataForm.party1str,
                'caseno': this.dataForm.caseno,
                'courtflag': this.dataForm.courtflag,
                'customno': this.dataForm.customno,
                'mobilephone': this.dataForm.mobilephone,
                'companyList': this.dataForm.companyList,
                'cnId': this.dataForm.cnId
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
