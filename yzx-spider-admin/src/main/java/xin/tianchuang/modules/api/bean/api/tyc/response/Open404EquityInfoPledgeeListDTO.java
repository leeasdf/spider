package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open404EquityInfoPledgeeListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3729275841033670847L;
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
