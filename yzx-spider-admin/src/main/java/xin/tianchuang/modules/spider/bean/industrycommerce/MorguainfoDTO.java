package xin.tianchuang.modules.spider.bean.industrycommerce;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 动产抵押物信息
 * 
 * @author jinlong.chen
 * @since 2017年4月20日 下午8:01:12
 * @version 1.0
 */
public class MorguainfoDTO {
	@JSONField(name = "morreg_id")
	private String morregId;// 抵押ID
	private String guaname;// 抵押物名称
	private String quan;// 数量
	private BigDecimal value;// 价值(万元)

	public String getMorregId() {
		return morregId;
	}

	public void setMorregId(String morregId) {
		this.morregId = morregId;
	}

	public String getGuaname() {
		return guaname;
	}

	public void setGuaname(String guaname) {
		this.guaname = guaname;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
