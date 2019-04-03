package xin.tianchuang.modules.spider.bean.tyc.result;


public class TycApiRespDTO extends BaseTycResultsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7963516610611203279L;

	private String status;

	private String message;

	private String uuid;

	private TycApiDataRespDTO data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public TycApiDataRespDTO getData() {
		return data;
	}

	public void setData(TycApiDataRespDTO data) {
		this.data = data;
	}

}
