package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

public enum DataSourceEnum implements StrEnum{
	TYC("TYC", "天眼查"),
	HN_ENT_ENV("HN_ENT_ENV", "湖南省企业环境信用评价系统"),
	HNTAX("HNTAX", "湖南省税务局"),
	HNAIC("HNAIC", "湖南省工商行政管理局"),
	CCGP("CCGP", "中国政府采购网"),
	HNDS("HNDS", "湖南省地方税务局"),
	;

	private String key;
	private String desc;

	DataSourceEnum(String key, String desc) {
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
