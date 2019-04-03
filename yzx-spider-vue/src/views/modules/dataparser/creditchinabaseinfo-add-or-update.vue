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
          <el-form-item label="信用代码" prop="creditCode">
            <el-input v-model="dataForm.creditCode" placeholder="信用代码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="企业类型" prop="enttype">
            <el-input v-model="dataForm.enttype" placeholder="企业类型"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="组织机构代码" prop="organizationCode">
            <el-input v-model="dataForm.organizationCode" placeholder="组织机构代码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="法人代表" prop="legal">
            <el-input v-model="dataForm.legal" placeholder="法人代表"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="成立日期" prop="esdate">
            <el-date-picker v-model="dataForm.esdate" placeholder="成立日期" format="yyyy-MM-dd" value-format='yyyy-MM-dd'></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="工商注册号" prop="regno">
            <el-input v-model="dataForm.regno" placeholder="工商注册号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册资本" prop="regcap">
            <el-input v-model="dataForm.regcap" placeholder="注册资本"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="企业地址" prop="dom">
        <el-input v-model="dataForm.dom" placeholder="企业地址"></el-input>
      </el-form-item>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="登记机关" prop="regorg">
            <el-input v-model="dataForm.regorg" placeholder="登记机关"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="修订日期" prop="revdate">
            <el-date-picker v-model="dataForm.revdate" placeholder="修订日期" format="yyyy-MM-dd" value-format='yyyy-MM-dd'></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="有效时间" prop="validtime">
            <el-date-picker v-model="dataForm.validtime" placeholder="有效时间" format="yyyy-MM-dd" value-format='yyyy-MM-dd'></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="税号" prop="taxCode">
            <el-input v-model="dataForm.taxCode" placeholder="税号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="备注" prop="remark">
        <el-input type="textarea" v-model="dataForm.remark" placeholder="备注"></el-input>
      </el-form-item>
    <!--<el-form-item label="" prop="apprdate">-->
      <!--<el-input v-model="dataForm.apprdate" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="area">-->
      <!--<el-input v-model="dataForm.area" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="badCount">-->
      <!--<el-input v-model="dataForm.badCount" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="candate">-->
      <!--<el-input v-model="dataForm.candate" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="cfCount">-->
      <!--<el-input v-model="dataForm.cfCount" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="dishonestyCount">-->
      <!--<el-input v-model="dataForm.dishonestyCount" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="entstatus">-->
      <!--<el-input v-model="dataForm.entstatus" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="goodCount">-->
      <!--<el-input v-model="dataForm.goodCount" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="idcard">-->
      <!--<el-input v-model="dataForm.idcard" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="opfrom">-->
      <!--<el-input v-model="dataForm.opfrom" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="opscope">-->
      <!--<el-input v-model="dataForm.opscope" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="opto">-->
      <!--<el-input v-model="dataForm.opto" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="otherCount">-->
      <!--<el-input v-model="dataForm.otherCount" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="rank">-->
      <!--<el-input v-model="dataForm.rank" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="solrStatus">-->
      <!--<el-input v-model="dataForm.solrStatus" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="source">-->
      <!--<el-input v-model="dataForm.source" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="sysUpdateTime">-->
      <!--<el-input v-model="dataForm.sysUpdateTime" placeholder=""></el-input>-->
    <!--</el-form-item>-->
    <!--<el-form-item label="" prop="xkCount">-->
      <!--<el-input v-model="dataForm.xkCount" placeholder=""></el-input>-->
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
          creditCode: '',
          entName: '',
          dom: '',
          enttype: '',
          esdate: '',
          legal: '',
          organizationCode: '',
          regcap: '',
          regno: '',
          regorg: '',
          revdate: '',
          validtime: '',
          taxCode: '',
          apprdate: '',
          area: '',
          badCount: '',
          candate: '',
          cfCount: '',
          dishonestyCount: '',
          entstatus: '',
          goodCount: '',
          idcard: '',
          opfrom: '',
          opscope: '',
          opto: '',
          otherCount: '',
          rank: '',
          solrStatus: '',
          source: '',
          sysUpdateTime: '',
          xkCount: '',
          spiderId: '',
          createTime: '',
          updateTime: '',
          remark: '',
          dataStatus: ''
        },
        dataRule: {
          creditCode: [
            { required: true, message: '信用代码不能为空', trigger: 'blur' }
          ],
          entName: [
            { required: true, message: '企业名称不能为空', trigger: 'blur' }
          ],
          dom: [
            { required: true, message: '企业地址不能为空', trigger: 'blur' }
          ],
          enttype: [
            { required: true, message: '企业类型不能为空', trigger: 'blur' }
          ],
          esdate: [
            { required: true, message: '成立日期不能为空', trigger: 'blur' }
          ],
          legal: [
            { required: true, message: '法人代表不能为空', trigger: 'blur' }
          ],
//          organizationCode: [
//            { required: true, message: '组织机构代码不能为空', trigger: 'blur' }
//          ],

          regno: [
            { required: true, message: '工商注册号不能为空', trigger: 'blur' }
          ]
          /*
           ,
          regcap: [
            { required: true, message: '注册资本不能为空', trigger: 'blur' }
          ],
          regorg: [
            { required: true, message: '登记机关不能为空', trigger: 'blur' }
          ],
          revdate: [
            { required: true, message: '修订日期不能为空', trigger: 'blur' }
          ],
          validtime: [
            { required: true, message: '有效时间不能为空', trigger: 'blur' }
          ],
          taxCode: [
            { required: true, message: '税号不能为空', trigger: 'blur' }
          ]
          ,
          apprdate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          badCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          candate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cfCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          dishonestyCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          entstatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          goodCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          idcard: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          opfrom: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          opscope: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          opto: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          otherCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rank: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          solrStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sysUpdateTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          xkCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/dataparser/creditchinabaseinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.creditCode = data.creditchinaBaseInfo.creditCode
                this.dataForm.entName = data.creditchinaBaseInfo.entName
                this.dataForm.dom = data.creditchinaBaseInfo.dom
                this.dataForm.enttype = data.creditchinaBaseInfo.enttype
                this.dataForm.esdate = data.creditchinaBaseInfo.esdate
                this.dataForm.legal = data.creditchinaBaseInfo.legal
                this.dataForm.organizationCode = data.creditchinaBaseInfo.organizationCode
                this.dataForm.regcap = data.creditchinaBaseInfo.regcap
                this.dataForm.regno = data.creditchinaBaseInfo.regno
                this.dataForm.regorg = data.creditchinaBaseInfo.regorg
                this.dataForm.revdate = data.creditchinaBaseInfo.revdate
                this.dataForm.validtime = data.creditchinaBaseInfo.validtime
                this.dataForm.taxCode = data.creditchinaBaseInfo.taxCode
                this.dataForm.apprdate = data.creditchinaBaseInfo.apprdate
                this.dataForm.area = data.creditchinaBaseInfo.area
                this.dataForm.badCount = data.creditchinaBaseInfo.badCount
                this.dataForm.candate = data.creditchinaBaseInfo.candate
                this.dataForm.cfCount = data.creditchinaBaseInfo.cfCount
                this.dataForm.dishonestyCount = data.creditchinaBaseInfo.dishonestyCount
                this.dataForm.entstatus = data.creditchinaBaseInfo.entstatus
                this.dataForm.goodCount = data.creditchinaBaseInfo.goodCount
                this.dataForm.idcard = data.creditchinaBaseInfo.idcard
                this.dataForm.opfrom = data.creditchinaBaseInfo.opfrom
                this.dataForm.opscope = data.creditchinaBaseInfo.opscope
                this.dataForm.opto = data.creditchinaBaseInfo.opto
                this.dataForm.otherCount = data.creditchinaBaseInfo.otherCount
                this.dataForm.rank = data.creditchinaBaseInfo.rank
                this.dataForm.solrStatus = data.creditchinaBaseInfo.solrStatus
                this.dataForm.source = data.creditchinaBaseInfo.source
                this.dataForm.sysUpdateTime = data.creditchinaBaseInfo.sysUpdateTime
                this.dataForm.xkCount = data.creditchinaBaseInfo.xkCount
                this.dataForm.spiderId = data.creditchinaBaseInfo.spiderId
                this.dataForm.createTime = data.creditchinaBaseInfo.createTime
                this.dataForm.updateTime = data.creditchinaBaseInfo.updateTime
                this.dataForm.remark = data.creditchinaBaseInfo.remark
                this.dataForm.dataStatus = data.creditchinaBaseInfo.dataStatus
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
              url: this.$http.adornUrl(`/dataparser/creditchinabaseinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'creditCode': this.dataForm.creditCode,
                'entName': this.dataForm.entName,
                'dom': this.dataForm.dom,
                'enttype': this.dataForm.enttype,
                'esdate': this.dataForm.esdate,
                'legal': this.dataForm.legal,
                'organizationCode': this.dataForm.organizationCode,
                'regcap': this.dataForm.regcap,
                'regno': this.dataForm.regno,
                'regorg': this.dataForm.regorg,
                'revdate': this.dataForm.revdate,
                'validtime': this.dataForm.validtime,
                'taxCode': this.dataForm.taxCode,
                'apprdate': this.dataForm.apprdate,
                'area': this.dataForm.area,
                'badCount': this.dataForm.badCount,
                'candate': this.dataForm.candate,
                'cfCount': this.dataForm.cfCount,
                'dishonestyCount': this.dataForm.dishonestyCount,
                'entstatus': this.dataForm.entstatus,
                'goodCount': this.dataForm.goodCount,
                'idcard': this.dataForm.idcard,
                'opfrom': this.dataForm.opfrom,
                'opscope': this.dataForm.opscope,
                'opto': this.dataForm.opto,
                'otherCount': this.dataForm.otherCount,
                'rank': this.dataForm.rank,
                'solrStatus': this.dataForm.solrStatus,
                'source': this.dataForm.source,
                'sysUpdateTime': this.dataForm.sysUpdateTime,
                'xkCount': this.dataForm.xkCount,
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
