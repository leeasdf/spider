package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnBidDTO;

public class RptTnBidResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 964128430928746879L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnBidDTO> items = new ArrayList<>();

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<RptTnBidDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnBidDTO> items) {
		this.items = items;
	}


}
