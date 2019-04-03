<template>
	<div>
		<h4>工商信息</h4>
		<table class="table-view">
			<tr>
				<td class="td_txt">法定代表人</td>
				<td>{{info.legalPerson}}</td>
				<td class="td_txt">注册资本</td>
				<td>{{info.regCap}}</td>
			</tr>
			<tr>
				<td class="td_txt">注册时间</td>
				<td>{{info.regTime}}</td>
				<td class="td_txt">公司状态</td>
				<td>{{info.status}}</td>
			</tr>
			<tr>
				<td class="td_txt">工商注册号</td>
				<td>{{info.regNo}}</td>
				<td class="td_txt">组织机构代码</td>
				<td>{{info.orgCode}}</td>
			</tr>
			<tr>
				<td class="td_txt">统一社会信用代码</td>
				<td>{{info.creCode}}</td>
				<td class="td_txt">公司类型</td>
				<td>{{info.entType}}</td>
			</tr>
			<tr>
				<td class="td_txt">纳税人识别号</td>
				<td>{{info.ideNum}}</td>
				<td class="td_txt">行业</td>
				<td>{{info.industryPhyName}}</td>
			</tr>
			<tr>
				<td class="td_txt">营业期限</td>
				<td>{{info.opePeriod}}</td>
				<td class="td_txt">核准日期</td>
				<td>{{info.appDate}}</td>
			</tr>
			<!-- <tr>
				<td class="td_txt">纳税人资质</td>
				<td></td>
				<td class="td_txt">人员规模</td>
				<td></td>
			</tr> -->
			<tr>
				<!-- <td class="td_txt">实缴资本</td>
				<td></td> -->
				<td class="td_txt">登记机关</td>
				<td>{{info.regAuthority}}</td>
				<td class="td_txt">英文名称</td>
				<td>{{info.engName}}</td>
			</tr>
			<!-- <tr>
				<td class="td_txt">参保人数</td>
				<td></td>
				<td class="td_txt">英文名称</td>
				<td>{{info.engName}}</td>
			</tr> -->
			<tr>
				<td class="td_txt">注册地址</td>
				<td colspan="3">{{info.regAddress}}</td>
			</tr>
			<tr>
				<td class="td_txt">经营范围</td>
				<td colspan="3">{{info.busScope}}</td>
			</tr>
		</table>
	</div>
</template>
<script>
  export default {
    name: 'businessinfo',
    props: ['enterpriseId'],
    data () {
      return {
        info: {
          id: 0,
          enterpriseId: '',
          entName: '',
          regNo: '',
          entType: '',
          industryPhyName: '',
          ideNum: '',
          creCode: '',
          engName: '',
          orgCode: '',
          regAuthority: '',
          opePeriod: '',
          appDate: '',
          regAddress: '',
          busScope: '',
          cmpName: '',
          regTime: '',
          legalPerson: '',
          regCap: '',
          status: '',
          creator: '',
          createTime: '',
          updater: '',
          updateTime: '',
          dataState: '',
          version: ''
        }
      }
    },
    activated () {
      this.getData()
    },
    methods: {
      getData () {
        if (this.enterpriseId) {
          this.$http({
            url: this.$http.adornUrl(`/spider/rpttnbasicinfo/searchInfo/${this.enterpriseId}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              if (data.rptTnBasicInfo) {
                this.info = data.rptTnBasicInfo
              }
            }
          })
        }
      }
    }
  }
</script>