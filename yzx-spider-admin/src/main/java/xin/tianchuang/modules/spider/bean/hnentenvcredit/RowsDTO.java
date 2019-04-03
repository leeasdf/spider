package xin.tianchuang.modules.spider.bean.hnentenvcredit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

public class RowsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3473435191355958824L;

	@JsonAlias("result6_r_id")
	private String result6RIid;
	/**
	 * 区域id
	 */
	@JsonAlias("area_id")
	private String areaId;
	@JsonAlias("result5_r_id")
	private String result5RId;
	/**
	 * 备注
	 */
	private String remark;
	@JsonAlias("rowno_")
	private String rowno;
	@JsonAlias("com_type")
	private String comType;
	private String result3;
	@JsonAlias("result3RId")
	private String result3RId;
	private String result4;
	/**
	 * 评定时间
	 */
	private String ext1;
	/**
	 * 地区
	 */
	@JsonAlias("area_name")
	private String areaName;
	/**
	 * 企业名称
	 */
	@JsonAlias("com_name")
	private String comName;
	@JsonAlias("result4_r_id")
	private String result4RId;
	/**
	 * 评定等级
	 */
	private String result5;
	private String result6;

	public String getResult6RIid() {
		return result6RIid;
	}

	public void setResult6RIid(String result6rIid) {
		result6RIid = result6rIid;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getResult5RId() {
		return result5RId;
	}

	public void setResult5RId(String result5rId) {
		result5RId = result5rId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRowno() {
		return rowno;
	}

	public void setRowno(String rowno) {
		this.rowno = rowno;
	}

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public String getResult3() {
		return result3;
	}

	public void setResult3(String result3) {
		this.result3 = result3;
	}

	public String getResult3RId() {
		return result3RId;
	}

	public void setResult3RId(String result3rId) {
		result3RId = result3rId;
	}

	public String getResult4() {
		return result4;
	}

	public void setResult4(String result4) {
		this.result4 = result4;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getResult4RId() {
		return result4RId;
	}

	public void setResult4RId(String result4rId) {
		result4RId = result4rId;
	}

	public String getResult5() {
		return result5;
	}

	public void setResult5(String result5) {
		this.result5 = result5;
	}

	public String getResult6() {
		return result6;
	}

	public void setResult6(String result6) {
		this.result6 = result6;
	}

}
