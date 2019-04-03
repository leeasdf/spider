package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

public enum HndsTaxAYearsEnum implements StrEnum {
	Y_2012_2013("1","2012-2013年度"),
	Y_2014("3","2014年度"),
	Y_2015("4","2015年度"),
	Y_2016("5","2016年度"),
	Y_2017("6","2017年度"),
//	Y_2018("2018","2018年"),
	;
	private String key;
	private String desc;

	HndsTaxAYearsEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public String desc() {
		return desc;
	}
}
