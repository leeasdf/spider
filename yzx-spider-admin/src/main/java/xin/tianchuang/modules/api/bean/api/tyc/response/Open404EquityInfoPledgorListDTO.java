package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open404EquityInfoPledgorListDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222931218181271850L;
	private String id;// 公司id
	private String name;// 公司名 varchar(255)

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
