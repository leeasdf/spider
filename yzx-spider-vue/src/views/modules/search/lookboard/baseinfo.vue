<template>
	<div class="yzx-info">
		<el-row>
      <el-col :span="24" class="name">{{baseInfo.enterpriseName}}<span class="time">更新时间：{{formatDate(baseInfo.updateTime)}}</span>
        <el-button type="text" @click="refresh()" :disabled="disabled"><i class="el-icon-refresh"></i></el-button>
      </el-col>
    </el-row>
    <div class="info">
      <el-row :gutter="20">
        <el-col :span="10">电话：{{baseInfo.phones}}</el-col>
        <el-col :span="14">邮箱：{{baseInfo.email}}</el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="10">网址：{{baseInfo.webSite}}</el-col>
        <el-col :span="14">地址：{{baseInfo.address}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="24">简介：{{baseInfo.content}}</el-col>
      </el-row>
    </div>
	</div>
</template>
<script>
export default {
  name: 'baseinfo',
  props: ['baseInfo'],
  data () {
    return {
      disabled: false
    }
  },
  methods: {
    refresh () {
      this.disabled = true
      this.$http({
        url: this.$http.adornUrl(`/spider/hightechzoneenterpriseinfo/retry/${this.baseInfo.enterpriseName}`),
        method: 'get'
      }).then(({data}) => {
        this.disabled = false
        if (data && data.code === 0) {
          location.reload()
        }
      })
    },
    formatDate (val) {
      return val.split(' ')[0]
    }
  }
}
</script>