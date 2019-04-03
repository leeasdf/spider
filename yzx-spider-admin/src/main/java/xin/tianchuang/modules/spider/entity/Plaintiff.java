/**
 * 
 */
package xin.tianchuang.modules.spider.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author denghui
 *
 */
public class Plaintiff {

	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	private String name;
	private int type;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

}
