const industryTypeList = [
  { key: 1, text: '先进装备制造产业' },
  { key: 2, text: '电子信息及互联网应用产业' },
  { key: 3, text: '新材料产业' },
  { key: 4, text: '新能源与节能环保产业' },
  { key: 5, text: '生物医药与健康产业' },
  { key: 6, text: '现代服务业' },
  { key: 7, text: '其他' }
]
export default {
  industryTypeList
}
/**
 * 数据状态
 * @param {*} s
 */
export function formatDataState (s) {
  let str = ''
  if (s === 1) {
    str = '正常'
  } else if (s === 0) {
    str = '删除'
  }
  return str
}

/**
 * 数据状态
 * @param {*} s
 */
export function formatIsInvalid (s) {
  let str = ''
  if (s === 0) {
    str = '正常'
  } else if (s === 1) {
    str = '更新'
  } else if (s === 2) {
    str = '删除'
  }
  return str
}

/**
 * 证件类型
 * @param {*} s
 */
export function formatCerType (s) {
  if (s === '1') {
    return '身份证'
  } else {
    return s
  }
}

/**
 * 行业归属
 * @param {*} s
 */
export function formatIndustryType (s) {
  if (s === '1') {
    return '先进装备制造产业'
  } else if (s === '2') {
    return '电子信息及互联网应用产业'
  } else if (s === '3') {
    return '新材料产业'
  } else if (s === '4') {
    return '新能源与节能环保产业'
  } else if (s === '5') {
    return '生物医药与健康产业'
  } else if (s === '6') {
    return '现代服务业'
  } else if (s === '7') {
    return '其他'
  } else {
    return s
  }
}
/**
 * 爬虫任务是否可用
 * @param {*} s
 */
export function formatSpiderMissionAvailable (s) {
  if (s === 1) {
    return '可用'
  } else if (s === 0) {
    return '停用'
  } else {
    return ''
  }
}
/**
 * 异常类型
 * @param {*} s
 */
export function formatSpiderType (s) {
  if (s === 1) {
    return '爬虫异常'
  } else {
    return ''
  }
}
/**
 * 日期格式 yyyy-MM-dd
 * @param {*} s
 */
export function formatDate (s) {
  return s.split(' ')[0]
}
