package xin.tianchuang.modules.spider.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * Created by yp-tc-m-7179 on 2018/9/29. 信用湖南爬取内容分类
 */
public enum SpiderTypeEnum implements IEnum {

	ADMINISTRATIVE_PUNISHMENT(0, "信用湖南-行政处罚"), //
	MAJOR_TAX_OFFENCES(1, "信用湖南-重大税收违法案件公告信息"), //
	LEVEL_A_TAXER(2, "信用湖南-国税A级纳税人"), //
	ADMINISTRATIVE_LICENSING(3, "信用湖南-行政许可"), //
	ABNORMAL_NOTICE(4, "信用湖南-非正常户公告信息"), //
	CREDIT_A_TAXPAYER(5, "信用湖南-地税纳税信用A级纳税人"), //
	CREDIT_CHINA(6, "信用中国数据"); //
	private Integer key;
	private String desc;

	SpiderTypeEnum(int key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public static SpiderTypeEnum transfar(int value){
		for(SpiderTypeEnum item: SpiderTypeEnum.values()){
			if(item.key==value){
				return  item;
			}
		}
		return null;
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
