package xin.tianchuang.modules.spider.bean.industrycommerce;
/**
 * 变更信息
 * @author jinlong.chen
 * @since 2017年4月20日 下午7:56:44
 * @version 1.0
 */
public class AlterDTO {
	private String altdate;//变更日期
	private String altitem;//变更事项
	private String altbe;//变更前内容
	private String altaf;//变更后内容
	public String getAltdate() {
		return altdate;
	}
	public void setAltdate(String altdate) {
		this.altdate = altdate;
	}
	public String getAltitem() {
		return altitem;
	}
	public void setAltitem(String altitem) {
		this.altitem = altitem;
	}
	public String getAltbe() {
		return altbe;
	}
	public void setAltbe(String altbe) {
		this.altbe = altbe;
	}
	public String getAltaf() {
		return altaf;
	}
	public void setAltaf(String altaf) {
		this.altaf = altaf;
	}
	
}
