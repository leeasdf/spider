import Mock from 'mockjs'

// 生成数据列表
var dataList = []
for (let i = 0; i < Math.floor(Math.random() * 10 + 1); i++) {
  dataList.push(Mock.mock({
    'enterpriseId': '@increment',
    'enterpriseName': '@name',
    'creditCode': /^[a-zA-z0-9]{18}$/,
    'createTime': 'datetime'
  }))
}

// 获取企业列表
export function list () {
  return {
    // isOpen: false,
    url: '/search/enterprise/list',
    type: 'get',
    data: {
      'msg': 'success',
      'code': 0,
      'page': {
        'totalCount': dataList.length,
        'pageSize': 10,
        'totalPage': 1,
        'currPage': 1,
        'list': dataList
      }
    }
  }
}