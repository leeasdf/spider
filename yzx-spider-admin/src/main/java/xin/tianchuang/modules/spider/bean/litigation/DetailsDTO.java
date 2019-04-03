package xin.tianchuang.modules.spider.bean.litigation;

public class DetailsDTO {

	private String caseSource; // 案件来源，例如在逃、前科、吸毒、涉毒，可为空
	private String caseTime; // 发案时间，例如2010-09-15 00: 00: 00，可为“未设置时间”
	private String caseType; // 案件类型，例如：赌博案，涉毒，可为空
	private String crimeType; // 涉案类型，例如：⽐中在逃、⽐中前科

	public String getCaseSource() {
		return caseSource;
	}

	public void setCaseSource(String caseSource) {
		this.caseSource = caseSource;
	}

	public String getCaseTime() {
		return caseTime;
	}

	public void setCaseTime(String caseTime) {
		this.caseTime = caseTime;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

}
