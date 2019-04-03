package xin.tianchuang.modules.spider.bean.litigation;

import java.util.List;

public class BadDataDTO {
	private int result; // 查询结果，0-无不良记录，1-有不良数据，2-系统⽆记录
	private String resultMsg; // 结果描述
	private List<DetailsDTO> details; // 案件来源

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public List<DetailsDTO> getDetails() {
		return details;
	}

	public void setDetails(List<DetailsDTO> details) {
		this.details = details;
	}

}
