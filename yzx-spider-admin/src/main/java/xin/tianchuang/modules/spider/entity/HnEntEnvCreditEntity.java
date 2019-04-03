package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 湖南省企业环境信用评价信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-12-12 12:12:48
 */
@TableName("hn_ent_env_credit")
public class HnEntEnvCreditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;
	/**
	 * 企业主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 企业名称
	 */
	private String comName;
	/**
	 * 区域id
	 */
	private String areaId;
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 行号
	 */
	private String rowno;
	/**
	 * 企业类别
	 */
	private String comType;
	/**
	 * 评级时间
	 */
	private String ext1;
	/**
	 * 年份
	 */
	private String years;
	/**
	 * 结果3 ID
	 */
	private String result3RId;
	/**
	 * 结果3
	 */
	private String result3;
	/**
	 * 结果4 ID
	 */
	private String result4RId;
	/**
	 * 结果4
	 */
	private String result4;
	/**
	 * 结果5 ID
	 */
	private String result5RId;
	/**
	 * 评定等级
	 */
	private String result5;
	/**
	 * 结果6 ID
	 */
	private String result6RId;
	/**
	 * 结果6
	 */
	private String result6;
	/**
	 * 数据来源
	 */
	private String dataSource;
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
	 * 设置：企业主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	/**
	 * 获取：企业主键
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}

	/**
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
	 * 获取：企业名称
	 */
	public String getEntName() {
		return entName;
	}

	/**
	 * 设置：企业名称
	 */
	public void setComName(String comName) {
		this.comName = comName;
	}

	/**
	 * 获取：企业名称
	 */
	public String getComName() {
		return comName;
	}

	/**
	 * 设置：区域id
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * 获取：区域id
	 */
	public String getAreaId() {
		return areaId;
	}

	/**
	 * 设置：区域名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 获取：区域名称
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置：行号
	 */
	public void setRowno(String rowno) {
		this.rowno = rowno;
	}

	/**
	 * 获取：行号
	 */
	public String getRowno() {
		return rowno;
	}

	/**
	 * 设置：企业类别
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}

	/**
	 * 获取：企业类别
	 */
	public String getComType() {
		return comType;
	}

	/**
	 * 设置：评级时间
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	/**
	 * 获取：评级时间
	 */
	public String getExt1() {
		return ext1;
	}

	/**
	 * 设置：年份
	 */
	public void setYears(String years) {
		this.years = years;
	}

	/**
	 * 获取：年份
	 */
	public String getYears() {
		return years;
	}

	/**
	 * 设置：结果3 ID
	 */
	public void setResult3RId(String result3RId) {
		this.result3RId = result3RId;
	}

	/**
	 * 获取：结果3 ID
	 */
	public String getResult3RId() {
		return result3RId;
	}

	/**
	 * 设置：结果3
	 */
	public void setResult3(String result3) {
		this.result3 = result3;
	}

	/**
	 * 获取：结果3
	 */
	public String getResult3() {
		return result3;
	}

	/**
	 * 设置：结果4 ID
	 */
	public void setResult4RId(String result4RId) {
		this.result4RId = result4RId;
	}

	/**
	 * 获取：结果4 ID
	 */
	public String getResult4RId() {
		return result4RId;
	}

	/**
	 * 设置：结果4
	 */
	public void setResult4(String result4) {
		this.result4 = result4;
	}

	/**
	 * 获取：结果4
	 */
	public String getResult4() {
		return result4;
	}

	/**
	 * 设置：结果5 ID
	 */
	public void setResult5RId(String result5RId) {
		this.result5RId = result5RId;
	}

	/**
	 * 获取：结果5 ID
	 */
	public String getResult5RId() {
		return result5RId;
	}

	/**
	 * 设置：评定等级
	 */
	public void setResult5(String result5) {
		this.result5 = result5;
	}

	/**
	 * 获取：评定等级
	 */
	public String getResult5() {
		return result5;
	}

	/**
	 * 设置：结果6 ID
	 */
	public void setResult6RId(String result6RId) {
		this.result6RId = result6RId;
	}

	/**
	 * 获取：结果6 ID
	 */
	public String getResult6RId() {
		return result6RId;
	}

	/**
	 * 设置：结果6
	 */
	public void setResult6(String result6) {
		this.result6 = result6;
	}

	/**
	 * 获取：结果6
	 */
	public String getResult6() {
		return result6;
	}

	/**
	 * 设置：数据来源
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取：数据来源
	 */
	public String getDataSource() {
		return dataSource;
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
