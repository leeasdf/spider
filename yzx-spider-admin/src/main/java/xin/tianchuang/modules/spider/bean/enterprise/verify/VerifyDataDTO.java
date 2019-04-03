package xin.tianchuang.modules.spider.bean.enterprise.verify;


public class VerifyDataDTO {

	/**
	 * 查询结果 0 -无数据 1 有数据，计费 resultMsg
	 */
	private int result;

	/**
	 * 查询结果描述
	 */
	private String resultMsg;

	/**
	 * 不同年度的企业税务信息
	 */
	private ContentDTO content;

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

	public ContentDTO getContent() {
		return content;
	}

	public void setContent(ContentDTO content) {
		this.content = content;
	}

}
