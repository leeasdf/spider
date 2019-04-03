package xin.tianchuang.modules.spider.bean.tyc.result;


public class TycApiDataRespDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 238803500216197109L;

	private TycApiDataResultRespDTO result;

	private String msg;
	// 爬⾍返回码，200：成功、400：公司名为空、404：未找到对应公司、500：爬取异常
	private String code;

	public TycApiDataResultRespDTO getResult() {
		return result;
	}

	public void setResult(TycApiDataResultRespDTO result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
