package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open386KtannouncementDefendantDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -879099786230769718L;

	private Integer type; // Number 1-公司 2-人

	private Long id;// Number 人或公司id
	private String name;// String 人或公司名 varchar(255);

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

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

}
