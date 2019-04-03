/**
 * 邮箱
 * @param {*} s
 */
export function isEmail (s) {
  // return /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(s)
  return /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/.test(s)
}

/**
 * 手机号码
 * @param {*} s
 */
export function isMobile (s) {
  return /^1[0-9]{10}$/.test(s)
}

/**
 * 电话号码
 * @param {*} s
 */
export function isPhone (s) {
  return /^([0-9]{3,4}-)?[0-9]{7,8}$/.test(s)
}

/**
 * URL地址
 * @param {*} s
 */
export function isURL (s) {
  return /^http[s]?:\/\/.*/.test(s)
}

/**
 * 身份证号码
 * @param {*} s
 */
export function isIDCard (s) {
  return /^(\d{14}|\d{17})[0-9|X|x]{1}$/.test(s)
}

/**
 * 百分比
 * @param {*} s
 */
export function isPercentage (s) {
  return /^(\d?\d(\.\d{0,2})?|100(\.[0]{0,2})?)%$/.test(s)
}

/**
 * 大于0的正整数
 * @param {*} s
 */
export function isInterger (s) {
  return /^[1-9]{1}\d*$/.test(s)
}

/**
 * 整数
 * @param {*} s
 */
export function isNumber (s) {
  return /^\d+$/.test(s)
}

/**
 * 浮点数
 * @param {*} s
 */
export function isFloat (s) {
  return /^\d+(\.\d+)?$/.test(s)
}

/**
 * 利润（涨幅）
 * @param {*} s
 */
export function isProfit (s) {
  return /^(-)?\d+(\.\d+)?$/.test(s)
}
