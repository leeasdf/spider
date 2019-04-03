package xin.tianchuang.modules.spider.bean.litigation;

/**
 * 个人涉诉信息
 * 
 * @author denghui
 * 
 */
public class PersonBadRespDTO {

	// 0-成功 1-系统错误 2-参数错误 -3 数据异常，未能获取结果 4-用户不存在或配置错误
	// 5-TokenKey验证失败 6-接口未定义或停⽌使⽤ 7-用户没有接口使⽤权限 8-用户接口暂停使⽤
	// 9-账户余额不足 10-系统繁忙，请稍候再试
	private int status;

	private String message;

	private String seqNum;

	private BadDataDTO data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public BadDataDTO getData() {
		return data;
	}

	public void setData(BadDataDTO data) {
		this.data = data;
	}

}
