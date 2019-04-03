package xin.tianchuang.common.utils.tcredit;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 读取settings配置文件信息
 * @author chenguang.li
 * @date 2016年10月10日上午10:29:16
 *
 * com.yeepay.credit.api.core.util
 */
public class SettingUtil {
	private static Properties pro;
	static {
		pro = new Properties();
		try {
			FileInputStream in = new FileInputStream(SettingUtil.class.getClassLoader().getResource("settings.properties").getFile());
			pro.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return pro.getProperty(key);
	}
	
}
