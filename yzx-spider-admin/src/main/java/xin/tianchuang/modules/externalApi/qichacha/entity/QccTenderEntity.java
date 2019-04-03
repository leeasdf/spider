package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import xin.tianchuang.modules.externalApi.qichacha.meta.ResultObj;

import java.io.Serializable;
import java.util.Date;

/**
 * 企查查——企业招投标信息
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:29:53
 */
@TableName("qcc_tender")
public class QccTenderEntity implements ResultObj ,Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 描述
	 */
	@JSONField(name="Title")
	private String title;
	/**
	 * 发布时间
	 */
	@JSONField(name="Pubdate" , format = "yyyy-MM-dd")
	private Date pubdate;
	/**
	 * 所属区域
	 */
	@JSONField(name="ProvinceName")
	private String provinceName;
	/**
	 * 项目分类
	 */
	@JSONField(name="ChannelName")
	private String channelName;
	/**
	 * 关键字（公司名、社会统一信用代码、注册号）
	 */
	private String entName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 版本号
	 */
	private Integer version;
	/**
	 * 数据状态
	 */
	private Integer dataStatus;

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
	 * 设置：描述
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：描述
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPubdate() {
		return pubdate;
	}
	/**
	 * 设置：所属区域
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	/**
	 * 获取：所属区域
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * 设置：项目分类
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * 获取：项目分类
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * 设置：关键字（公司名、社会统一信用代码、注册号）
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：关键字（公司名、社会统一信用代码、注册号）
	 */
	public String getEntName() {
		return entName;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本号
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 设置：数据状态
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：数据状态
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}

	@Override
	public QccTenderEntity getEntity(String data) {
		return JSONObject.parseObject(data,this.getClass());
	}
}
