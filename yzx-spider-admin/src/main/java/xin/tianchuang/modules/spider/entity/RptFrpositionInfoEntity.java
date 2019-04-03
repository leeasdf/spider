package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 信用麓谷-待定
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
@TableName("rpt_frposition_info")
public class RptFrpositionInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 会员ID
	 */
	private Integer memId;
	/**
	 * 企业ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 法定代表人姓名
	 */
	private String name;
	/**
	 * 企业(机构)名称
	 */
	private String entname;
	/**
	 * 注册号
	 */
	private String regno;
	/**
	 * 企业(机构)类型
	 */
	private String enttype;
	/**
	 * 注册资本
	 */
	private String regcap;
	/**
	 * 注册资本币种
	 */
	private String regcapcur;
	/**
	 * 企业状态
	 */
	private String entstatus;
	/**
	 * 注销日期
	 */
	private String candate;
	/**
	 * 吊销日期
	 */
	private String revdate;
	/**
	 * 登记机关
	 */
	private String regorg;
	/**
	 * 职务
	 */
	private String position;
	/**
	 * 是否法定代表人
	 */
	private String lerepsign;
	/**
	 * 开业日期
	 */
	private String esdate;
	/**
	 * 创建人ID
	 */
	private Integer creator;
	/**
	 * 创建时间
	 */
	  @TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 修改人ID
	 */
	private Integer updater;
	/**
	 * 修改时间
	 */
		 @TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 数据状态：1-正常 0-删除
	 */
	@TableField(value = "data_state", fill = FieldFill.INSERT)
private Integer dataState;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：会员ID
	 */
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getMemId() {
		return memId;
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
	/**
	 * 设置：法定代表人姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：法定代表人姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：企业(机构)名称
	 */
	public void setEntname(String entname) {
		this.entname = entname;
	}
	/**
	 * 获取：企业(机构)名称
	 */
	public String getEntname() {
		return entname;
	}
	/**
	 * 设置：注册号
	 */
	public void setRegno(String regno) {
		this.regno = regno;
	}
	/**
	 * 获取：注册号
	 */
	public String getRegno() {
		return regno;
	}
	/**
	 * 设置：企业(机构)类型
	 */
	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}
	/**
	 * 获取：企业(机构)类型
	 */
	public String getEnttype() {
		return enttype;
	}
	/**
	 * 设置：注册资本
	 */
	public void setRegcap(String regcap) {
		this.regcap = regcap;
	}
	/**
	 * 获取：注册资本
	 */
	public String getRegcap() {
		return regcap;
	}
	/**
	 * 设置：注册资本币种
	 */
	public void setRegcapcur(String regcapcur) {
		this.regcapcur = regcapcur;
	}
	/**
	 * 获取：注册资本币种
	 */
	public String getRegcapcur() {
		return regcapcur;
	}
	/**
	 * 设置：企业状态
	 */
	public void setEntstatus(String entstatus) {
		this.entstatus = entstatus;
	}
	/**
	 * 获取：企业状态
	 */
	public String getEntstatus() {
		return entstatus;
	}
	/**
	 * 设置：注销日期
	 */
	public void setCandate(String candate) {
		this.candate = candate;
	}
	/**
	 * 获取：注销日期
	 */
	public String getCandate() {
		return candate;
	}
	/**
	 * 设置：吊销日期
	 */
	public void setRevdate(String revdate) {
		this.revdate = revdate;
	}
	/**
	 * 获取：吊销日期
	 */
	public String getRevdate() {
		return revdate;
	}
	/**
	 * 设置：登记机关
	 */
	public void setRegorg(String regorg) {
		this.regorg = regorg;
	}
	/**
	 * 获取：登记机关
	 */
	public String getRegorg() {
		return regorg;
	}
	/**
	 * 设置：职务
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：职务
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：是否法定代表人
	 */
	public void setLerepsign(String lerepsign) {
		this.lerepsign = lerepsign;
	}
	/**
	 * 获取：是否法定代表人
	 */
	public String getLerepsign() {
		return lerepsign;
	}
	/**
	 * 设置：开业日期
	 */
	public void setEsdate(String esdate) {
		this.esdate = esdate;
	}
	/**
	 * 获取：开业日期
	 */
	public String getEsdate() {
		return esdate;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人ID
	 */
	public Integer getCreator() {
		return creator;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改人ID
	 */
	public void setUpdater(Integer updater) {
		this.updater = updater;
	}
	/**
	 * 获取：修改人ID
	 */
	public Integer getUpdater() {
		return updater;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：数据状态：1-正常 0-删除
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态：1-正常 0-删除
	 */
	public Integer getDataState() {
		return dataState;
	}
}
