package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * API接口参数-企业类型
 * 
 * @author denghui
 *
 */
public enum TaxUserTypeEnum implements IEnum {
	ENTERPRISE(1, "企或单位"), //
	PERSON_ENT(2, "个体工商户"), //
	PERSON(3, "个人"), //
	;

	private int key;
	private String desc;

	TaxUserTypeEnum(int key, String desc) {
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
