<template>
	<div class="china">
	  <el-tabs v-model="activeName" class="yzx-tabs" tab-position="top" type="">
	    <el-tab-pane label="基本信息" name="baseinfo">
	    	<h4>基本信息</h4>
				<table class="table-view">
					<tr>
						<td class="td_txt">企业名称</td>
						<td>{{info.entName}}</td>
						<td class="td_txt">统一社会信用代码</td>
						<td>{{info.creditCode}}</td>
					</tr>
					<tr>
						<td class="td_txt">工商注册号</td>
						<td>{{info.regno}}</td>
						<td class="td_txt">法人信息</td>
						<td>{{info.legal}}</td>
					</tr>
					<tr>
						<td class="td_txt">企业类型</td>
						<td>{{info.enttype}}</td>
						<td class="td_txt">企业状态</td>
						<td></td>
					</tr>
					<tr>
						<td class="td_txt">成立日期</td>
						<td>{{info.esdate}}</td>
						<td class="td_txt">登记机关</td>
						<td>{{info.regorg}}</td>
					</tr>
				</table>
	    </el-tab-pane>
	    <el-tab-pane label="行政许可" name="pubpermission">
	    	<pubpermission :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></pubpermission>
	    </el-tab-pane>
	    <el-tab-pane label="行政处罚" name="pubpenalty">
	    	<pubpenalty :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></pubpenalty>
	    </el-tab-pane>
	    <el-tab-pane label="守信红名单" name="honestytax">
	    	<honestytax :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></honestytax>
	    </el-tab-pane>
	    <el-tab-pane label="重点关注名单" name="focusgszj">
	    	<focusgszj :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></focusgszj>
        <focuspenalty :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></focuspenalty>
	    </el-tab-pane>
	    <el-tab-pane label="黑名单" name="blacklaw">
	    	<blacklaw :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></blacklaw>
	    </el-tab-pane>
	  </el-tabs>
	</div>
</template>
<script>
import pubpermission from './creditchina/pubpermission'
import pubpenalty from './creditchina/pubpenalty'
import honestytax from './creditchina/honestytax'
import focusgszj from './creditchina/focusgszj'
import focuspenalty from './creditchina/focuspenalty'
import blacklaw from './creditchina/blacklaw'
export default {
  name: 'creditchina',
  props: ['enterpriseId', 'enterpriseName', 'baseInfo'],
  components: { pubpermission, pubpenalty, honestytax, focusgszj, focuspenalty, blacklaw },
  data () {
    return {
      activeName: 'baseinfo',
      info: {
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
      }
    }
  },
  activated () {
    this.getInfo()
  },
  methods: {
    getInfo () {
      if (this.enterpriseName) {
        this.$http({
          url: this.$http.adornUrl(`/dataparser/creditchinabaseinfo/info/entName`),
          method: 'get',
          params: this.$http.adornParams({
            'entName': this.enterpriseName
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            if (data.creditchinaBaseInfo) {
              this.info = data.creditchinaBaseInfo
            }
          }
        })
      }
    }
  }
}
</script>