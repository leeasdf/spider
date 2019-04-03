package xin.tianchuang.modules.api.bean.api.tyc.biz;

import java.io.Serializable;

public class BizRequestParamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6680111339757520353L;

	/**
	 * 公司id
	 */
	private Long id;
	/**
	 * 公司名称
	 */
	private String name;

	/**
	 * 当前页数（默认第一页，每页10条或者20条）
	 */
	private Integer pageNum;

	/**
	 * 每页条数（默认10或者20）
	 */
	private Integer pageSize;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
