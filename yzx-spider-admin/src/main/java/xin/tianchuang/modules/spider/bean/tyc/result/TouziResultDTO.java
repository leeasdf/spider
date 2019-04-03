package xin.tianchuang.modules.spider.bean.tyc.result;

import java.io.Serializable;
import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.TouziDTO;

public class TouziResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8367188426671022185L;
	private String pageTotal;
	private List<TouziDTO> touziResults;
	private String pageNum;

	public void setPageTotal(String pageTotal) {
		this.pageTotal = pageTotal;
	}

	public String getPageTotal() {
		return pageTotal;
	}

	public List<TouziDTO> getTouziResults() {
		return touziResults;
	}

	public void setTouziResults(List<TouziDTO> touziResults) {
		this.touziResults = touziResults;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageNum() {
		return pageNum;
	}
}
