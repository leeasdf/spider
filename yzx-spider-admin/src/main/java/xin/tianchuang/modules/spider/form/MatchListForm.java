package xin.tianchuang.modules.spider.form;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class MatchListForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8516173506696458542L;

	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	private String enterpriseName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

}
