import Mock from 'mockjs'

// 生成数据列表
var dataList = []
for (let i = 0; i < Math.floor(Math.random() * 10 + 1); i++) {
  dataList.push(Mock.mock({
    'id': '@increment',
    'paramKey': '@first',
    'paramValue': '@last',
    'remark': '@csentence'
  }))
}

// 获取参数列表
export function list () {
  return {
    // isOpen: false,
    url: '/spider/hightechzoneenterpriseinfo/match',
    type: 'get',
    data: {
      'msg': 'success',
      'code': 0,
      'page': {
        'list': [
          { 'enterpriseName': '深圳市腾讯计算机技术有限公司', 'id': '1' },
          { 'enterpriseName': '天创云征信有限公司', 'id': '2' },
          { 'enterpriseName': '易宝天创有限公司', 'id': '3' },
          { 'enterpriseName': '浙江腾讯有限公司', 'id': '4' },
          { 'enterpriseName': '杭州阿里巴巴有限公司', 'id': '5' }
        ]
      }
    }
  }
}
