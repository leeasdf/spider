package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open370ChangeinfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1161926901075667390L;
	private String changeItem;// 变更事项 varchar（4091）
	private String createTime;// 创建时间
	private String contentBefore;// 变更前 mediumtext
	private String contentAfter;// 变更后 mediumtext
	private String changeTime;// 变更时间

	public String getChangeItem() {
		return changeItem;
	}

	public void setChangeItem(String changeItem) {
		this.changeItem = changeItem;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getContentBefore() {
		return contentBefore;
	}

	public void setContentBefore(String contentBefore) {
		this.contentBefore = contentBefore;
	}

	public String getContentAfter() {
		return contentAfter;
	}

	public void setContentAfter(String contentAfter) {
		this.contentAfter = contentAfter;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

}