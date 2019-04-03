package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 失信公告信息概要
 */
public class SxggDTO {
	private String sxggId;// 开庭公告ID
	private String sortTime;// 开庭时间
	private String body;// 内容
	private String court;// 法院名称

	private String pname;// 被执行人姓名
	// 详情
	private String sex;// 性别
	private String lxqk;// 被执⾏⼈的履⾏情况
	private String yjCode;// 执⾏依据⽂号
	private String idcardNo;// ⾝份证/组织机构代码

	private String yjdw;// 做出执⾏依据单位
	private String jtqx;// 失信被执⾏⼈⾏为具体情形
	private String yiwu;// ⽣效法律⽂书确定的义务
	private String age;// 年龄
	private String province;// 省份

	private String caseNo;// 案号
	private String postTime;// 发布时间

	public String getSxggId() {
		return sxggId;
	}

	public void setSxggId(String sxggId) {
		this.sxggId = sxggId;
	}

	public String getSortTime() {
		return sortTime;
	}

	public void setSortTime(String sortTime) {
		this.sortTime = sortTime;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLxqk() {
		return lxqk;
	}

	public void setLxqk(String lxqk) {
		this.lxqk = lxqk;
	}

	public String getYjCode() {
		return yjCode;
	}

	public void setYjCode(String yjCode) {
		this.yjCode = yjCode;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getYjdw() {
		return yjdw;
	}

	public void setYjdw(String yjdw) {
		this.yjdw = yjdw;
	}

	public String getJtqx() {
		return jtqx;
	}

	public void setJtqx(String jtqx) {
		this.jtqx = jtqx;
	}

	public String getYiwu() {
		return yiwu;
	}

	public void setYiwu(String yiwu) {
		this.yiwu = yiwu;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

}
