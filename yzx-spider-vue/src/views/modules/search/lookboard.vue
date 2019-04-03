<template>
	<div class="detail-list" :scrollTop.prop="scrollTop" :style="'height:'+containerHeight+'px'" v-loading="loading">
		<baseinfo :baseInfo="baseInfo"></baseinfo>
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
              <li v-for="(sitem,j) in item.children" :data-id="sitem.id" @click="jump(sitem.id)">
                {{sitem.label}}
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
    <div>
      <div class="block">
        <h3 class="title"><span>公司背景</span></h3>
        <div class="block-data" id="businessinfo">
          <businessinfo :enterpriseId="this.enterpriseId"></businessinfo>
        </div>
        <keyperson class="block-data" id="keyperson" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></keyperson>
        <shareholders class="block-data" id="shareholders" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></shareholders>
        <investments class="block-data" id="investments" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></investments>
        <changerecord class="block-data" id="changerecord" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></changerecord>
        <branches class="block-data" id="branches" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></branches>
      </div>
      <!-- 司法风险 -->
      <div class="block">
        <h3 class="title"><span>司法风险</span></h3>
        <announcementcourt class="block-data" id="announcementcourt" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></announcementcourt>
        <lawsuit class="block-data" id="lawsuit" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></lawsuit>
        <courtnotice class="block-data" id="courtnotice" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></courtnotice>
        <dishonest class="block-data" id="dishonest" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></dishonest>
        <zhixing class="block-data" id="zhixing" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></zhixing>
      </div>
      <!-- 经营风险 -->
      <div class="block">
        <h3 class="title"><span>经营风险</span></h3>
        <abnormal class="block-data" id="abnormal" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></abnormal>
        <penalties class="block-data" id="penalties" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></penalties>
        <illegal class="block-data" id="illegal" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></illegal>
        <equity class="block-data" id="equity" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></equity>
        <owingtax class="block-data" id="owingtax" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></owingtax>
      </div>
      <!-- 经营状况 -->
      <div class="block">
        <h3 class="title"><span>经营状况</span></h3>
        <taxcredit class="block-data" id="taxcredit" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></taxcredit>
        <check class="block-data" id="check" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></check>
        <certificate class="block-data" id="certificate" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></certificate>
        <bid class="block-data" id="bid" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></bid>
        <importexport class="block-data" id="importexport" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></importexport>
      </div>
      <!-- 知识产权 -->
      <div class="block">
        <h3 class="title"><span>知识产权</span></h3>
        <trademark class="block-data" id="trademark" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></trademark>
        <patent class="block-data" id="patent" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></patent>
        <softwareright class="block-data" id="softwareright" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></softwareright>
        <worksright class="block-data" id="worksright" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></worksright>
        <icp class="block-data" id="icp" :enterpriseId="this.enterpriseId" :enterpriseName="this.enterpriseName"></icp>
      </div>
    </div>
	</div>
</template>
<script>
import baseinfo from './lookboard/baseinfo'
import keyperson from './lookboard/cBackground/keyperson'
import businessinfo from './lookboard/cBackground/businessinfo'
import shareholders from './lookboard/cBackground/shareholders'
import investments from './lookboard/cBackground/investments'
import changerecord from './lookboard/cBackground/changerecord'
import branches from './lookboard/cBackground/branches'
import announcementcourt from './lookboard/justice/announcementcourt'
import lawsuit from './lookboard/justice/lawsuit'
import courtnotice from './lookboard/justice/courtnotice'
import dishonest from './lookboard/justice/dishonest'
import zhixing from './lookboard/justice/zhixing'
import abnormal from './lookboard/businessRisk/abnormal'
import penalties from './lookboard/businessRisk/penalties'
import illegal from './lookboard/businessRisk/illegal'
import equity from './lookboard/businessRisk/equity'
import owingtax from './lookboard/businessRisk/owingtax'
import taxcredit from './lookboard/conditions/taxcredit'
import check from './lookboard/conditions/check'
import certificate from './lookboard/conditions/certificate'
import bid from './lookboard/conditions/bid'
import importexport from './lookboard/conditions/importexport'
import trademark from './lookboard/intellectual/trademark'
import patent from './lookboard/intellectual/patent'
import softwareright from './lookboard/intellectual/softwareright'
import worksright from './lookboard/intellectual/worksright'
import icp from './lookboard/intellectual/icp'
export default {
  name: 'lookboard',
  props: ['enterpriseId', 'enterpriseName', 'baseInfo'],
  components: { baseinfo, keyperson, businessinfo, shareholders, investments, changerecord, branches, announcementcourt, lawsuit, courtnotice, dishonest, zhixing, abnormal, penalties, illegal, equity, owingtax, taxcredit, check, certificate, bid, importexport, trademark, patent, softwareright, worksright, icp },
  data () {
    return {
      loading: false,
      hoverIndex: '',
      menus: [
        {
          label: '公司背景',
          children: [
            { label: '工商信息', id: 'businessinfo', type: 'basicInfo' },
            { label: '主要人员', id: 'keyperson', type: 'person', count: 0 },
            { label: '股东信息', id: 'shareholders', type: 'shareholders', count: 0 },
            { label: '对外投资', id: 'investments', type: 'invest', count: 0 },
            { label: '变更记录', id: 'changerecord', type: 'change', count: 0 },
            { label: '分支机构', id: 'branches', type: 'branches', count: 0 }
          ]
        }, {
          label: '司法风险',
          children: [
            { label: '开庭公告', id: 'announcementcourt', type: 'announcementcourt', count: 0 },
            { label: '法律诉讼', id: 'lawsuit', type: 'lawsuit', count: 0 },
            { label: '法院公告', id: 'courtnotice', type: 'courtNotice', count: 0 },
            { label: '失信人信息', id: 'dishonest', type: 'dishonest', count: 0 },
            { label: '被执行人', id: 'zhixing', type: 'zhixing', count: 0 }
          ]
        }, {
          label: '经营风险',
          children: [
            { label: '经营异常', id: 'abnormal', type: 'abnormal', count: 0 },
            { label: '行政处罚[工商局]', id: 'penalties', type: 'penalties', count: 0 },
            { label: '严重违法', id: 'illegal', type: 'illegal', count: 0 },
            { label: '股权出质', id: 'equity', type: 'equity', count: 0 },
            // { label: '动产抵押', id: 'dcdy' },
            { label: '欠税公告', id: 'owingtax', type: 'owingTax', count: 0 }
          ]
        }, {
          label: '经营状况',
          children: [
            { label: '税务评级', id: 'taxcredit', type: 'taxCredit', count: 0 },
            { label: '抽查检查', id: 'check', type: 'check', count: 0 },
            { label: '资质证书', id: 'certificate', type: 'certificate', count: 0 },
            { label: '招投标信息', id: 'bid', type: 'bid', count: 0 },
            { label: '进出口信用', id: 'importexport', type: 'importExport', count: 0 }
          ]
        }, {
          label: '知识产权',
          children: [
            { label: '商标信息', id: 'trademark', type: 'trademark', count: 0 },
            { label: '专利信息', id: 'patent', type: 'patent', count: 0 },
            { label: '软件著作权', id: 'softwareright', type: 'softwareRight', count: 0 },
            { label: '作品著作权', id: 'worksright', type: 'worksRight', count: 0 },
            { label: '网站备案', id: 'icp', type: 'icp', count: 0 }
          ]
        }
      ],
      activeIndex: '0',
      activeId: '',
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
  mounted () {
    // 监听scroll事件
    const _this = this
    setTimeout(function () {
      const rightItem = document.querySelectorAll('.block')
      var arr = []
      rightItem.forEach(function (v, i) {
        arr.push({
          top: v.offsetTop,
          height: v.offsetHeight,
          index: i
        })
      })
      _this.itemVal = arr
      const cateList = document.querySelectorAll('.detail-list')[0]
      cateList.addEventListener('scroll', _this.onScroll)
      _this.container = cateList

      _this.menu = document.querySelectorAll('.yzx-menu')[0]
      _this.menuOffsetTop = _this.menu.offsetTop
      _this.fixedW = _this.container.clientWidth
    }, 500)
  },
  methods: {
    handleHover (index) {
      this.hoverIndex = index
    },
    handleLeave (index) {
      this.hoverIndex = ''
    },
    onScroll () {
      var _this = this
      let tp = this.temp
      _this.itemVal.forEach(function (obj, i) {
        _this.scrollTop = _this.container.scrollTop
        if ((_this.scrollTop + tp) >= obj.top && (_this.scrollTop + tp) < (obj.top + obj.height - 10)) {
          // _this.activeId = obj.id
          _this.activeIndex = obj.index
        }
      })
      if (_this.scrollTop >= _this.menuOffsetTop) {
        _this.menu.classList.add('fixed')
        _this.menu.style.width = _this.fixedW + 'px'
        _this.menu.style.top = _this.fixedTop + 'px'
      } else {
        _this.menu.classList.remove('fixed')
        _this.menu.style = ''
      }
    },
    jump (id) {
      const cateItem = document.getElementById(id)
      let ifFixed = false
      if (this.menu.className.indexOf('fixed') > -1) {
        ifFixed = true
      }
      let total = cateItem.offsetTop - (ifFixed ? 80 : this.temp)
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
  },
  computed: {
    // 计算属性的 getter
    containerHeight: function () {
      let h = document.documentElement.clientHeight - this.offsetH - 90
      return h
    }
  }
}
</script>
<style>
  .fixed{
    position: fixed;
    z-index: 999;
  }
  .detail-list{
    position: relative;
    padding-right:15px;
    overflow: auto;
  }
  .title{

  }
  .info{
    padding: 20px;
    background:#f5faff;
  }
</style>