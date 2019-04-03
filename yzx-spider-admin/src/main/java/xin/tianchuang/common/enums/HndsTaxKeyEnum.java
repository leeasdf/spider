package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

public enum HndsTaxKeyEnum implements StrEnum {
	
//	KEY_0("有限","KEY_0"),   // 894912 
//	KEY_2("长沙市岳麓区","KEY_2"),
//	KEY_3("长沙市开福区","KEY_3"),
//	KEY_4("长沙市天心区","KEY_4"),
//	KEY_5("长沙市开福区","KEY_5"),
//	KEY_6("长沙市芙蓉区","KEY_6"),
//	KEY_7("长沙市望城","KEY_7"),
//	KEY_8("长沙市雨花区","KEY_8"),
//	KEY_9("长沙市星沙","KEY_9"),
//	KEY_10("公司","KEY_10"),
	KEY_11("%有限%公司%","KEY_11"), //  894912
	;
	private String key;
	private String desc;

	HndsTaxKeyEnum(String key, String desc) {
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
