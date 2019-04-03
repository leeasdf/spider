package xin.tianchuang.common.utils.tcredit;

/**
 * 判断手机运营商
 * 
 * @author lei.sun
 * @date 2016年1月21日
 */
public class MobileUtil {
	private final static String YD = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-3,7-8]))\\d{8}$";
	private final static String LT = "^((13[0-2])|(145)|(15[5-6])|(17[5-6])|(18[5-6]))\\d{8}$";
	private final static String DX = "^((133)|(149)|(153)|(177)|(18[0-1,9]))\\d{8}$";

	/**
	 * 获取运营商标识
	 * @param mobile
	 * @return
	 */
	public static int operatorFlag(String mobile) {
		int flag = 0; // 运营商标识，默认未识别
		if (mobile.matches(YD)) {
			flag = 1; // 移动
		} else if (mobile.matches(LT)) {
			flag = 2; // 联通
		} else if (mobile.matches(DX)) {
			flag = 3; // 电信
		}
		return flag;
	}
}
