<template>
  <div class="mod-search yzx">
    <el-tabs type="border-card" @tab-click="handleClick">
      <el-tab-pane label="基础业务数据">
        <lookboard :enterpriseId="enterpriseId" :enterpriseName="enterpriseName" :baseInfo="baseInfo" v-loading="lookboardLoading"></lookboard>
      </el-tab-pane>
      <el-tab-pane label="信用中国">
        <creditchina :enterpriseId="enterpriseId" :enterpriseName="enterpriseName" :baseInfo="baseInfo"></creditchina>
      </el-tab-pane>
      <el-tab-pane label="信用湖南">
        <credithunan ref="hunan" :enterpriseId="enterpriseId" :enterpriseName="enterpriseName"></credithunan>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import lookboard from './lookboard'
  import credithunan from './credithunan'
  import creditchina from './creditchina'
  export default {
    components: { lookboard, credithunan, creditchina },
    data () {
      return {
        lookboardLoading: false,
        enterpriseId: '',
        enterpriseName: '',
        baseInfo: {
          enterpriseName: '',
          organizationCode: '',
          businessLicenseNo: '',
          taxNo: '',
          esDate: '',
          regCap: '',
          entryDate: '',
          createtime: '',
          creditCode: '',
          industryType: '',
          dataState: '',
          updateTime: '',
          province: '',
          city: '',
          regTime: '',
          tycEnterpriseid: '',
          status: '',
          dataSource: '',
          webSite: '',
          address: '',
          phones: '',
          email: '',
          content: '',
          legalPersonName: '',
          renameFlag: '',
          oldName: '',
          remark: '',
          tycUpdateTime: '',
          score: '',
          version: '',
          oldEnterpriseId: '',
          newName: '',
          newEnterpriseId: '',
          tagList: '',
          historyList: ''
        }
      }
    },
    created () {
      this.enterpriseId = this.$route.params.id
      this.enterpriseName = this.$route.params.enterpriseName
    },
    activated () {
      this.getInfo()
    },
    deactivated () {
      this.baseInfo.enterpriseName = ''
      this.baseInfo.updateTime = ''
      this.baseInfo.phones = ''
      this.baseInfo.email = ''
      this.baseInfo.webSite = ''
      this.baseInfo.address = ''
      this.baseInfo.content = ''
    },
    methods: {
      getInfo () {
        if (this.enterpriseId) {
          this.$http({
            url: this.$http.adornUrl(`/spider/hightechzoneenterpriseinfo/info/${this.enterpriseId}`),
            method: 'get',
            params: this.$http.adornParams()
          }).then(({data}) => {
            if (data && data.code === 0) {
              if (data.highTechZoneEnterpriseInfo) {
                this.baseInfo = data.highTechZoneEnterpriseInfo
              }
            }
          })
        }
      },
      handleClick (tab, event) {
        if (tab.label === '信用湖南') {
          this.$nextTick(() => {
            this.$refs.hunan.init()
          })
        }
      }
    },
    watch: {
      '$route' (to, from) {
        this.enterpriseId = this.$route.params.id
        this.enterpriseName = this.$route.params.enterpriseName
      }
    }
  }
</script>
