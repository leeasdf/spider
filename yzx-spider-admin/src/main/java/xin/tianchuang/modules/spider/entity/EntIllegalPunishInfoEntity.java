package xin.tianchuang.modules.spider.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 市场主体违法行为记录信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
@TableName("ent_illegal_punish_info")
public class EntIllegalPunishInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员id
	 */
	private Integer memId;
	/**
	 * 公开ID
	 */
	private String publicId;
	/**
	 * 当事人名称或姓名
	 */
	private String partyName;
	/**
	 * 主要违法事实
	 */
	private String illegact;
	/**
	 * 处罚内容
	 */
	private String punishdesicion;
	/**
	 * 处罚依据
	 */
	private String quabasisText;
	/**
	 * 处罚日期
	 */
	private String pendesissDate;
	/**
	 * 办案机关
	 */
	private String bsjgText;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：会员id
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getMemId() {
		return memId;
	}
	/**
	 * 设置：公开ID
	 */
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
	/**
	 * 获取：公开ID
	 */
	public String getPublicId() {
		return publicId;
	}
	/**
	 * 设置：当事人名称或姓名
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	/**
	 * 获取：当事人名称或姓名
	 */
	public String getPartyName() {
		return partyName;
	}
	/**
	 * 设置：主要违法事实
	 */
	public void setIllegact(String illegact) {
		this.illegact = illegact;
	}
	/**
	 * 获取：主要违法事实
	 */
	public String getIllegact() {
		return illegact;
	}
	/**
	 * 设置：处罚内容
	 */
	public void setPunishdesicion(String punishdesicion) {
		this.punishdesicion = punishdesicion;
	}
	/**
	 * 获取：处罚内容
	 */
	public String getPunishdesicion() {
		return punishdesicion;
	}
	/**
	 * 设置：处罚依据
	 */
	public void setQuabasisText(String quabasisText) {
		this.quabasisText = quabasisText;
	}
	/**
	 * 获取：处罚依据
	 */
	public String getQuabasisText() {
		return quabasisText;
	}
	/**
	 * 设置：处罚日期
	 */
	public void setPendesissDate(String pendesissDate) {
		this.pendesissDate = pendesissDate;
	}
	/**
	 * 获取：处罚日期
	 */
	public String getPendesissDate() {
		return pendesissDate;
	}
	/**
	 * 设置：办案机关
	 */
	public void setBsjgText(String bsjgText) {
		this.bsjgText = bsjgText;
	}
	/**
	 * 获取：办案机关
	 */
	public String getBsjgText() {
		return bsjgText;
	}
	/**
	 * 设置：企业ID
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业ID
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}
}
