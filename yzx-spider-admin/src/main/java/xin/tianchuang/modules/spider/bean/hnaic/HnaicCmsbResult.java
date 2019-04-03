package xin.tianchuang.modules.spider.bean.hnaic;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

//根元素
@XStreamAlias("response")
public class HnaicCmsbResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5743258108441620917L;

	@XStreamImplicit(itemFieldName = "markid")
	private List<String> markId;

	@XStreamImplicit(itemFieldName = "marktype")
	private List<String> markType;

	@XStreamImplicit(itemFieldName = "markname")
	private List<String> markName;

	@XStreamImplicit(itemFieldName = "markpassnumb")
	private List<String> markPassNum;

	@XStreamImplicit(itemFieldName = "blongtoenterprise")
	private List<String> blongToEnterprise;

	@XStreamImplicit(itemFieldName = "marktopro")
	private List<String> markToPro;

	@XStreamImplicit(itemFieldName = "selecttime")
	private List<String> selectTime;

	@XStreamImplicit(itemFieldName = "enterpriseaddr")
	private List<String> enterpriseAddr;

	@XStreamAsAttribute
	private String div;

	public List<String> getMarkId() {
		return markId;
	}

	public void setMarkId(List<String> markId) {
		this.markId = markId;
	}

	public List<String> getMarkType() {
		return markType;
	}

	public void setMarkType(List<String> markType) {
		this.markType = markType;
	}

	public List<String> getMarkName() {
		return markName;
	}

	public void setMarkName(List<String> markName) {
		this.markName = markName;
	}

	public List<String> getMarkPassNum() {
		return markPassNum;
	}

	public void setMarkPassNum(List<String> markPassNum) {
		this.markPassNum = markPassNum;
	}

	public List<String> getBlongToEnterprise() {
		return blongToEnterprise;
	}

	public void setBlongToEnterprise(List<String> blongToEnterprise) {
		this.blongToEnterprise = blongToEnterprise;
	}

	public List<String> getMarkToPro() {
		return markToPro;
	}

	public void setMarkToPro(List<String> markToPro) {
		this.markToPro = markToPro;
	}

	public List<String> getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(List<String> selectTime) {
		this.selectTime = selectTime;
	}

	public List<String> getEnterpriseAddr() {
		return enterpriseAddr;
	}

	public void setEnterpriseAddr(List<String> enterpriseAddr) {
		this.enterpriseAddr = enterpriseAddr;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

}
