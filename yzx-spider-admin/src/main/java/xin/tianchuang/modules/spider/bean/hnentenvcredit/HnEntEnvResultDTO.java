package xin.tianchuang.modules.spider.bean.hnentenvcredit;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlRootElement(name = "Response")
public class HnEntEnvResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5743258108441620917L;

	Integer total;

	List<RowsDTO> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<RowsDTO> getRows() {
		return rows;
	}

	public void setRows(List<RowsDTO> rows) {
		this.rows = rows;
	}

}
