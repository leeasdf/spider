<template>
	<div>
		<h4>纳税信用A级纳税人信息 <el-tag size="mini">信息来源：{{info.source}}</el-tag></h4>
		<table class="table-view">
      <tr>
        <td class="td_txt">纳税人名称</td>
        <td>{{info.taxpayer}}</td>
        <td class="td_txt">组织机构代码</td>
        <td>{{info.orgCode}}</td>
      </tr>
      <tr>
        <td class="td_txt">负责人</td>
        <td>{{info.responsiblePerson}}</td>
        <td class="td_txt">评价年度</td>
        <td>{{info.year}}</td>
      </tr>
      <tr>
        <td class="td_txt">信用级别A级</td>
        <td>{{info.creditLevel}}</td>
        <td class="td_txt">主管税务机关</td>
        <td>{{info.taxAuthorities}}</td>
      </tr>
      <tr>
        <td class="td_txt">更新时间</td>
        <td colspan="3">{{info.updateTime}}</td>
      </tr>
    </table>
	</div>
</template>
<script>
  export default {
    name: 'taxa',
    props: ['enterpriseId', 'enterpriseName'],
    data () {
      return {
        info: {
          taxpayer: '',
          taxpayerNo: '',
          orgCode: '',
          responsiblePerson: '',
          taxAuthorities: '',
          creditLevel: '',
          year: '',
          taxType: '',
          infomationName: '',
          source: '',
          infomationType: '',
          sourceTime: '',
          taxUpdateTime: '',
          spiderId: '',
          createTime: '',
          updateTime: '',
          remark: '',
          version: '',
          dataStatus: ''
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
            url: this.$http.adornUrl(`/dataparser/credithunantaxa/info/taxpayer`),
            method: 'get',
            params: this.$http.adornParams({
              'source': '省地税局',
              'taxpayer': this.enterpriseName
            })
          }).then(({data}) => {
            if (data && data.code === 0) {
              if (data.credithunanTaxA) {
                this.info = data.credithunanTaxA
              }
            }
          })
        }
      }
    }
  }
</script>
