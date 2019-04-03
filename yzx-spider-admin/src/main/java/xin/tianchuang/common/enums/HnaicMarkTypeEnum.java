package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * API接口参数-企业类型
 * 
 * @author denghui
 *
 */
public enum HnaicMarkTypeEnum implements IEnum {
//	WELL_KNOWN(1, "驰名商标"), //
	FAMOUS(2, "著名商标"), //
	;

	private int key;
	private String desc;

	HnaicMarkTypeEnum(int key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public int key() {
		return key;
	}

	public String desc() {
		return desc;
	}

	@Override
	public Serializable getValue() {
		return key;
	}

}
