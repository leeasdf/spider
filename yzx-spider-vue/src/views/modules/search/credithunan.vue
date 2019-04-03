<template>
	<div class="hunan">
    <div class="yzx-menu">
      <el-menu :default-active="activeIndex+''" class="el-menu-demo menu_search" mode="horizontal">
        <el-menu-item v-for="(item,index) in menus" :key="item.label" :index="''+index" class="yzx-mitem" @mouseover.native="handleHover(index)" @mouseleave.native="handleLeave(index)">
          {{item.label}}
        </el-menu-item>
      </el-menu>
      <div class="yzx-menu-panel">
        <ul class="yzx-menu-ul">
          <li v-for="(item,index) in menus" :class="index===hoverIndex? 'active': ''" @mouseover="handleHover(index)" @mouseleave.native="handleLeave(index)">
            <ul class="yzx-submenu clearfix">
              <li v-for="(sitem,j) in item.children" :data-id="sitem.id" @click="jump(sitem.id)">{{sitem.label}}</li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
    <div class="hunan-list" :style="'height:'+containerHeight+'px'" :scrollTop.prop="scrollTop">
      <!-- 省地税局 -->
      <div class="block">
        <h3 class="title"><span>省地税局</span></h3>
        <taxa class="block-data" id="taxa" :enterpriseId="this.enterpriseId"></taxa>
        <taxcontravention class="block-data" id="taxcontravention" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></taxcontravention>
        <abnormalnotice class="block-data" id="abnormalnotice" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></abnormalnotice>
      </div>
      <!-- 省国税局 -->
      <div class="block">
        <h3 class="title"><span>省国税局</span></h3>
        <nationaltaxa class="block-data" id="nationaltaxa" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></nationaltaxa>
        <nationltaxataxcontravention class="block-data" id="nationltaxataxcontravention" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></nationltaxataxcontravention>
      </div>
      <!-- 双公示 -->
      <div class="block">
        <h3 class="title"><span>双公示</span></h3>
        <administrativepenalty class="block-data" id="administrativepenalty" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></administrativepenalty>
        <administrativelicensing class="block-data" id="administrativelicensing" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></administrativelicensing>
      </div>
    </div>
	</div>
</template>
<script>
import taxa from './credithunan/taxa'
import taxcontravention from './credithunan/taxcontravention'
import abnormalnotice from './credithunan/abnormalnotice'
import nationaltaxa from './credithunan/nationaltaxa'
import nationltaxataxcontravention from './credithunan/nationltaxataxcontravention'
import administrativepenalty from './credithunan/administrativepenalty'
import administrativelicensing from './credithunan/administrativelicensing'
export default {
  name: 'credithunan',
  props: ['enterpriseId', 'enterpriseName'],
  components: { taxa, taxcontravention, abnormalnotice, nationaltaxa, nationltaxataxcontravention, administrativepenalty, administrativelicensing },
  data () {
    return {
      cHeight: '',
      hoverIndex: '',
      menus: [
        {
          label: '省地税局',
          children: [
            { label: '纳税信用A级纳税人信息', id: 'taxa' },
            { label: '重大税收违法案件公告信息', id: 'taxcontravention' },
            { label: '非正常户公告信息', id: 'abnormalnotice' }
          ]
        }, {
          label: '省国税局',
          children: [
            { label: '纳税信用A级纳税人信息', id: 'nationaltaxa' },
            { label: '重大税收违法案件公告信息', id: 'nationltaxataxcontravention' }
          ]
        }, {
          label: '双公示',
          children: [
            { label: '行政处罚', id: 'administrativepenalty' },
            { label: '行政许可', id: 'administrativelicensing' }
          ]
        }
      ],
      activeIndex: '0',
      scrollTop: 0,
      container: '',
      menu: '',
      fixedW: 0,
      fixedTop: 180,
      menuOffsetTop: '',
      temp: 140,
      offsetH: 145
    }
  },
  computed: {
    // 计算属性的 getter
    containerHeight: function () {
      let h = document.documentElement.clientHeight - this.offsetH - 150
      return h
    }
  },
  methods: {
    init () {
      // 监听scroll事件
      const _this = this
      const cateList = document.querySelectorAll('.hunan-list')[0]
      cateList.addEventListener('scroll', _this.onScroll)
      _this.container = cateList
      setTimeout(function () {
        const rightItem = _this.container.querySelectorAll('.block')
        var arr = []
        rightItem.forEach(function (v, i) {
          arr.push({
            top: v.offsetTop,
            height: v.offsetHeight,
            index: i
          })
        })
        _this.itemVal = arr
      }, 500)
    },
    handleHover (index) {
      this.hoverIndex = index
    },
    handleLeave (index) {
      this.hoverIndex = ''
    },
    onScroll () {
      var _this = this
      _this.itemVal.forEach(function (obj, i) {
        _this.scrollTop = _this.container.scrollTop
        if (_this.scrollTop >= obj.top && _this.scrollTop < (obj.top + obj.height - 10)) {
          _this.activeIndex = obj.index
        }
      })
    },
    jump (id) {
      const cateItem = document.getElementById(id)
      let total = cateItem.offsetTop
      let distance = this.container.scrollTop // 获取到顶部的距离(this.container便是.cate-list,为了方便存起来了)
      let step = total / 50
      // this.activeIndex = index; // 菜单列表显示当前样式
      this.activeId = id
      const _this = this
      if (total > distance) {
        smoothDown()
      } else {
        let newTotal = distance - total
        step = newTotal / 50
        smoothUp()
      }

      function smoothDown () {
        if (distance < total) {
          distance += step
          _this.scrollTop = distance
          setTimeout(smoothDown, 10)
        } else {
          _this.scrollTop = total
        }
      }

      function smoothUp () {
        if (distance > total) {
          distance -= step
          _this.scrollTop = distance
          setTimeout(smoothUp, 10)
        } else {
          _this.scrollTop = total
        }
      }
    }
  }
}
</script>
<style>
  .fixed{
    position: fixed;
    z-index: 999;
  }
  .hunan-list{
    position: relative;
    padding-right:15px;
    overflow: auto;
  }
  .info{
    padding: 20px;
    background:#f5faff;
  }
</style>