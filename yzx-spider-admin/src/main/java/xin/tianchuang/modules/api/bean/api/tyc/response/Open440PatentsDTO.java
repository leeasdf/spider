package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Open440PatentsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6662781538485197151L;
	private String status;// 状态 varchar(50)
	private String tmClass;// 国际分类code
	private String searchType;// 无用
	private String uni;// 唯一标识符
	private String tmName;// 商标名称 varchar(600)
	private String id;// 商标id
	@JsonAlias("_type")
	private String type;// 无用
	private String intCls;// 国际分类 varchar(50)
	private String tmFlow;// 商标流程
	private String category;// 商标状态 varchar(50)
	private String tmPic;// 商标图片 varchar(150)
	private List<String> connList;// 跳转天眼查链接
	private String eventTime;// 无用
	private String appDate;// 申请日期 毫秒数
	private String regNo;// 注册号 varchar(20)
	private String applicantCn;// 申请人 varchar(200)

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTmClass() {
		return tmClass;
	}

	public void setTmClass(String tmClass) {
		this.tmClass = tmClass;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public String getTmName() {
		return tmName;
	}

	public void setTmName(String tmName) {
		this.tmName = tmName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIntCls() {
		return intCls;
	}

	public void setIntCls(String intCls) {
		this.intCls = intCls;
	}

	public String getTmFlow() {
		return tmFlow;
	}

	public void setTmFlow(String tmFlow) {
		this.tmFlow = tmFlow;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTmPic() {
		return tmPic;
	}

	public void setTmPic(String tmPic) {
		this.tmPic = tmPic;
	}

	public List<String> getConnList() {
		return connList;
	}

	public void setConnList(List<String> connList) {
		this.connList = connList;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getApplicantCn() {
		return applicantCn;
	}

	public void setApplicantCn(String applicantCn) {
		this.applicantCn = applicantCn;
	}

}
