<template>
  <div>
    <h4>重大税收违法案件公告信息 <el-tag size="mini">信息来源：{{info.source}}</el-tag></h4>
    <table class="table-view">
      <tr>
        <td class="td_txt">纳税人名称</td>
        <td>{{info.taxpayer}}</td>
        <td class="td_txt">纳税人识别号</td>
        <td>{{info.taxpayerNo}}</td>
      </tr>
      <tr>
        <td class="td_txt">社会信用统一代码</td>
        <td>{{info.creditCode}}</td>
        <td class="td_txt">注册地址</td>
        <td>{{info.registerAddress}}</td>
      </tr>
      <tr>
        <td class="td_txt">法定代表人</td>
        <td>{{info.legal}}</td>
        <td class="td_txt">身份证号</td>
        <td>{{info.certificationNo}}</td>
      </tr>
      <tr>
        <td class="td_txt">实施检查单位</td>
        <td>{{info.checkUnit}}</td>
        <td class="td_txt">公告日期</td>
        <td>{{info.declarationDate}}</td>
      </tr>
    </table>
  </div>
</template>
<script>
  export default {
    name: 'taxcontravention',
    props: ['enterpriseId', 'enterpriseName'],
    data () {
      return {
        info: {
          taxpayer: '',
          taxpayerNo: '',
          creditCode: '',
          registerAddress: '',
          legal: '',
          certificationNo: '',
          checkUnit: '',
          declarationDate: '',
          infomationName: '',
          source: '',
          infomationType: '',
          sourceTime: '',
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
            url: this.$http.adornUrl(`/dataparser/credithunantaxcontravention/info/taxpayer`),
            method: 'get',
            params: this.$http.adornParams({
              'source': '省地税局',
              'taxpayer': this.enterpriseName
            })
          }).then(({data}) => {
            if (data && data.code === 0) {
              if (data.credithunanTaxContravention) {
                this.info = data.credithunanTaxContravention
              }
            }
          })
        }
      }
    }
  }
</script>
