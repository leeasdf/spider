package xin.tianchuang.modules.spider.bean.industrycommerce;
/**
 * 分支机构
 * @author jinlong.chen
 * @since 2017年4月21日 下午2:59:00
 * @version 1.0
 */
public class FiliationDTO {
	private String brname;//分支机构名称
	private String brregno;//分支机构企业注册号
	private String brprincipal;//分支机构负责人
	private String cbuitem;//一般经营项目
	private String braddr;//分支机构地址
	public String getBrname() {
		return brname;
	}
	public void setBrname(String brname) {
		this.brname = brname;
	}
	public String getBrregno() {
		return brregno;
	}
	public void setBrregno(String brregno) {
		this.brregno = brregno;
	}
	public String getBrprincipal() {
		return brprincipal;
	}
	public void setBrprincipal(String brprincipal) {
		this.brprincipal = brprincipal;
	}
	public String getCbuitem() {
		return cbuitem;
	}
	public void setCbuitem(String cbuitem) {
		this.cbuitem = cbuitem;
	}
	public String getBraddr() {
		return braddr;
	}
	public void setBraddr(String braddr) {
		this.braddr = braddr;
	}
	
}
