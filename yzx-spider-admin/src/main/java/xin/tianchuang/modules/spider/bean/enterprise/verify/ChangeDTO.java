package xin.tianchuang.modules.spider.bean.enterprise.verify;

public class ChangeDTO {
	private String changeTitle;// ⼯商变更项
	private String beforeChange;// 更改前
	private String afterChange;// 更改后
	private String changeDate;// 变更时间

	public String getChangeTitle() {
		return changeTitle;
	}

	public void setChangeTitle(String changeTitle) {
		this.changeTitle = changeTitle;
	}

	public String getBeforeChange() {
		return beforeChange;
	}

	public void setBeforeChange(String beforeChange) {
		this.beforeChange = beforeChange;
	}

	public String getAfterChange() {
		return afterChange;
	}

	public void setAfterChange(String afterChange) {
		this.afterChange = afterChange;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

}
