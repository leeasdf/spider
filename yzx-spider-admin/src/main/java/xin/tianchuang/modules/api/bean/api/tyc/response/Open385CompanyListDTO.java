package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open385CompanyListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7982528300732826408L;
	private Integer type;// 1-公司 2-人
	private String id;// 人或公司id
	private String name;// 人或公司名 varchar(255)

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
