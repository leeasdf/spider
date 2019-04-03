<template>
	<div class="mod-search">
		<div class="srh-form">
      <el-form :inline="true" :model="dataForm" @keyup.enter.native="handleSearch()">
  			<el-autocomplete
          v-model="dataForm.key"
          :fetch-suggestions="querySearchAsync"
          placeholder="请输入企业名称"
          :trigger-on-focus="tfocus"
          @select="handleSelect"
          class="yzx-search"
          value-key="enterpriseName">
          <el-button slot="append" icon="el-icon-search" @click="handleSearch()"></el-button>
        </el-autocomplete>
      </el-form>
		</div>
	</div>
</template>
<script>
  export default {
    data () {
      return {
        tfocus: false,
        dataForm: {
          key: ''
        }
      }
    },
    methods: {
      querySearchAsync (queryString, cb) {
        if (queryString !== '') {
          this.$http({
            url: this.$http.adornUrl('/spider/hightechzoneenterpriseinfo/match'),
            method: 'get',
            params: this.$http.adornParams({
              'key': queryString
            })
          }).then(({data}) => {
            if (data && data.code === 0) {
              var restaurants = data.page.list
              /* var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants
              cb(results) */
              cb(restaurants)
            }
          })
        }
      },
      createStateFilter (queryString) {
        return (state) => {
          return (state.enterpriseName.toLowerCase().indexOf(queryString.toLowerCase()) >= 0)
        }
      },
      handleSelect (item) {
        this.$router.push('/search-enterpriseinfo/' + item.id + '/' + item.enterpriseName)
      },
      handleSearch () {
        if (this.dataForm.key !== '') {
          this.$router.push('/search-enterpriselist/' + this.dataForm.key)
        } else {
          this.$message.warning('请输入关键字搜索')
        }
      }
    }
  }
</script>
<style>
	.srh-form{
		width:800px;
    position: relative;
		margin:100px auto;
	}
  .yzx-search{
    width: 100%;
  }

</style>