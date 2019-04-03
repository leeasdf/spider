<template>
  <div>
    <h4>非正常户公告信息</h4>
    <table class="table-view">
      <tr>
        <td class="td_txt">纳税人名称</td>
        <td>{{info.taxpayer}}</td>
        <td class="td_txt">组织机构代码</td>
        <td>{{info.organizeCode}}</td>
      </tr>
      <tr>
        <td class="td_txt">法定代表人</td>
        <td>{{info.legalRepresentative}}</td>
        <td class="td_txt">身份证号</td>
        <td>{{info.identityCard}}</td>
      </tr>
      <tr>
        <td class="td_txt">主管税务机关</td>
        <td>{{info.taxAuthority}}</td>
        <td class="td_txt">公告日期</td>
        <td>{{info.declarationDate}}</td>
      </tr>
      <tr>
        <td class="td_txt">非正常户认定日期</td>
        <td>{{info.affirmDate}}</td>
        <td class="td_txt">生产经营地址</td>
        <td>{{info.businessAddress}}</td>
      </tr>
    </table>
  </div>
</template>
<script>
  export default {
    name: 'abnormalnotice',
    props: ['enterpriseId', 'enterpriseName'],
    data () {
      return {
        info: {
          taxpayer: '',
          organizeCode: '',
          legalRepresentative: '',
          identityCard: '',
          taxAuthority: '',
          declarationDate: '',
          affirmDate: '',
          businessAddress: ''
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
            url: this.$http.adornUrl(`/dataparser/credithunanabnormalnotice/info/taxpayer`),
            method: 'get',
            params: this.$http.adornParams({
              'taxpayer': this.enterpriseName
            })
          }).then(({data}) => {
            if (data && data.code === 0) {
              if (data.credithunanAbnormalNotice) {
                this.info = data.credithunanAbnormalNotice
              }
            }
          })
        }
      }
    }
  }
</script>
