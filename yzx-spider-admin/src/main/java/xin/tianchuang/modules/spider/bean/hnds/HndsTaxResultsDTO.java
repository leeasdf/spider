package xin.tianchuang.modules.spider.bean.hnds;

import java.io.Serializable;
import java.util.List;

public class HndsTaxResultsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1435607770231349089L;

	/**
	 * 总记录数
	 */
	private Integer total;

	/**
	 * 是否有下一页
	 */
	private boolean hasNext;

	/**
	 * 结果列表
	 */
	private List<HndsTaxDTO> rows;

	/**
	 * 是否有结果
	 */
	private boolean found;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List<HndsTaxDTO> getRows() {
		return rows;
	}

	public void setRows(List<HndsTaxDTO> rows) {
		this.rows = rows;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

}
