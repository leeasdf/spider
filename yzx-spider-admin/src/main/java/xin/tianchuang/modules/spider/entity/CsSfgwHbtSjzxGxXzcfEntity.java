package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 省发改委-企业行政处罚信息(省环保厅)
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
@TableName("cs_sfgw_hbt_sjzx_gx_xzcf")
public class CsSfgwHbtSjzxGxXzcfEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据状态（0：正常 1：更新 2：删除）
	 */
	private Integer isinvalid;
	/**
	 * 数据最后修改时间
	 */
	private Date lastdate;
	/**
	 * 序号
	 */
	private String xh;
	/**
	 * 污染源编号
	 */
	private String wrybh;
	/**
	 * 污染源名称
	 */
	private String wrymc;
	/**
	 * 年度
	 */
	private String nd;
	/**
	 * 处罚主体
	 */
	private String cfzt;
	/**
	 * 调查机构
	 */
	private String dcjg;
	/**
	 * 立案号
	 */
	private String lah;
	/**
	 * 决定书文号
	 */
	private String jdswh;
	/**
	 * 立案日期
	 */
	private Date larq;
	/**
	 * 案情简介
	 */
	private String aqjj;
	/**
	 * 主要违法行为
	 */
	private String zywfxw;
	/**
	 * 处罚依据
	 */
	private String cfyj;
	/**
	 * 处罚种类
	 */
	private String cfzl;
	/**
	 * 罚款数额（万元）
	 */
	private BigDecimal fkse;
	/**
	 * 行政命令种类
	 */
	private String xzmlzl;
	/**
	 * 是否举行听证
	 */
	private String sfjxtz;
	/**
	 * 决定下达日期
	 */
	private Date jdxdrq;
	/**
	 * 决定书内容
	 */
	private String jdsnr;
	/**
	 * 执行情况
	 */
	private String zxqk;
	/**
	 * 执行完毕日期
	 */
	private Date zxwbrq;
	/**
	 * 复议结果
	 */
	private String fyjg;
	/**
	 * 诉讼结果
	 */
	private String ssjg;
	/**
	 * 移送信息
	 */
	private String ysxx;
	/**
	 * 结案日期
	 */
	private Date jarq;
	/**
	 * 是否结案N：未结案Y：已结案
	 */
	private String sfja;
	/**
	 * 案卷号
	 */
	private String ajh;
	/**
	 * 备注
	 */
	private String bz;
	/**
	 * 创建时间
	 */
	private Date cjsj;
	/**
	 * 修改时间
	 */
	private Date xgsj;
	/**
	 * 数据来源
	 */
	private String sjly;
	/**
	 * 状态0：新增1：修改2：删除
	 */
	private String zt;
	/**
	 * 是否已交换N：未交换Y：已交换
	 */
	private String sfyjh;
	/**
	 * 审核状态
	 */
	private String shzt;
	/**
	 * 统一社会信用代码
	 */
	private String tyshxydm;
	/**
	 * 作出决定的相关材料
	 */
	private String zcjdxgcl;
	/**
	 * 违法案件类型
	 */
	private String wfajlx;
	/**
	 * 更新时间戳
	 */
	private Date xyhnDbTime;
	/**
	 * 主键
	 */
	@TableId(value = "zjid", type = IdType.ID_WORKER)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long zjid;

	/**
	 * 设置：数据状态（0：正常 1：更新 2：删除）
	 */
	public void setIsinvalid(Integer isinvalid) {
		this.isinvalid = isinvalid;
	}
	/**
	 * 获取：数据状态（0：正常 1：更新 2：删除）
	 */
	public Integer getIsinvalid() {
		return isinvalid;
	}
	/**
	 * 设置：数据最后修改时间
	 */
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	/**
	 * 获取：数据最后修改时间
	 */
	public Date getLastdate() {
		return lastdate;
	}
	/**
	 * 设置：序号
	 */
	public void setXh(String xh) {
		this.xh = xh;
	}
	/**
	 * 获取：序号
	 */
	public String getXh() {
		return xh;
	}
	/**
	 * 设置：污染源编号
	 */
	public void setWrybh(String wrybh) {
		this.wrybh = wrybh;
	}
	/**
	 * 获取：污染源编号
	 */
	public String getWrybh() {
		return wrybh;
	}
	/**
	 * 设置：污染源名称
	 */
	public void setWrymc(String wrymc) {
		this.wrymc = wrymc;
	}
	/**
	 * 获取：污染源名称
	 */
	public String getWrymc() {
		return wrymc;
	}
	/**
	 * 设置：年度
	 */
	public void setNd(String nd) {
		this.nd = nd;
	}
	/**
	 * 获取：年度
	 */
	public String getNd() {
		return nd;
	}
	/**
	 * 设置：处罚主体
	 */
	public void setCfzt(String cfzt) {
		this.cfzt = cfzt;
	}
	/**
	 * 获取：处罚主体
	 */
	public String getCfzt() {
		return cfzt;
	}
	/**
	 * 设置：调查机构
	 */
	public void setDcjg(String dcjg) {
		this.dcjg = dcjg;
	}
	/**
	 * 获取：调查机构
	 */
	public String getDcjg() {
		return dcjg;
	}
	/**
	 * 设置：立案号
	 */
	public void setLah(String lah) {
		this.lah = lah;
	}
	/**
	 * 获取：立案号
	 */
	public String getLah() {
		return lah;
	}
	/**
	 * 设置：决定书文号
	 */
	public void setJdswh(String jdswh) {
		this.jdswh = jdswh;
	}
	/**
	 * 获取：决定书文号
	 */
	public String getJdswh() {
		return jdswh;
	}
	/**
	 * 设置：立案日期
	 */
	public void setLarq(Date larq) {
		this.larq = larq;
	}
	/**
	 * 获取：立案日期
	 */
	public Date getLarq() {
		return larq;
	}
	/**
	 * 设置：案情简介
	 */
	public void setAqjj(String aqjj) {
		this.aqjj = aqjj;
	}
	/**
	 * 获取：案情简介
	 */
	public String getAqjj() {
		return aqjj;
	}
	/**
	 * 设置：主要违法行为
	 */
	public void setZywfxw(String zywfxw) {
		this.zywfxw = zywfxw;
	}
	/**
	 * 获取：主要违法行为
	 */
	public String getZywfxw() {
		return zywfxw;
	}
	/**
	 * 设置：处罚依据
	 */
	public void setCfyj(String cfyj) {
		this.cfyj = cfyj;
	}
	/**
	 * 获取：处罚依据
	 */
	public String getCfyj() {
		return cfyj;
	}
	/**
	 * 设置：处罚种类
	 */
	public void setCfzl(String cfzl) {
		this.cfzl = cfzl;
	}
	/**
	 * 获取：处罚种类
	 */
	public String getCfzl() {
		return cfzl;
	}
	/**
	 * 设置：罚款数额（万元）
	 */
	public void setFkse(BigDecimal fkse) {
		this.fkse = fkse;
	}
	/**
	 * 获取：罚款数额（万元）
	 */
	public BigDecimal getFkse() {
		return fkse;
	}
	/**
	 * 设置：行政命令种类
	 */
	public void setXzmlzl(String xzmlzl) {
		this.xzmlzl = xzmlzl;
	}
	/**
	 * 获取：行政命令种类
	 */
	public String getXzmlzl() {
		return xzmlzl;
	}
	/**
	 * 设置：是否举行听证
	 */
	public void setSfjxtz(String sfjxtz) {
		this.sfjxtz = sfjxtz;
	}
	/**
	 * 获取：是否举行听证
	 */
	public String getSfjxtz() {
		return sfjxtz;
	}
	/**
	 * 设置：决定下达日期
	 */
	public void setJdxdrq(Date jdxdrq) {
		this.jdxdrq = jdxdrq;
	}
	/**
	 * 获取：决定下达日期
	 */
	public Date getJdxdrq() {
		return jdxdrq;
	}
	/**
	 * 设置：决定书内容
	 */
	public void setJdsnr(String jdsnr) {
		this.jdsnr = jdsnr;
	}
	/**
	 * 获取：决定书内容
	 */
	public String getJdsnr() {
		return jdsnr;
	}
	/**
	 * 设置：执行情况
	 */
	public void setZxqk(String zxqk) {
		this.zxqk = zxqk;
	}
	/**
	 * 获取：执行情况
	 */
	public String getZxqk() {
		return zxqk;
	}
	/**
	 * 设置：执行完毕日期
	 */
	public void setZxwbrq(Date zxwbrq) {
		this.zxwbrq = zxwbrq;
	}
	/**
	 * 获取：执行完毕日期
	 */
	public Date getZxwbrq() {
		return zxwbrq;
	}
	/**
	 * 设置：复议结果
	 */
	public void setFyjg(String fyjg) {
		this.fyjg = fyjg;
	}
	/**
	 * 获取：复议结果
	 */
	public String getFyjg() {
		return fyjg;
	}
	/**
	 * 设置：诉讼结果
	 */
	public void setSsjg(String ssjg) {
		this.ssjg = ssjg;
	}
	/**
	 * 获取：诉讼结果
	 */
	public String getSsjg() {
		return ssjg;
	}
	/**
	 * 设置：移送信息
	 */
	public void setYsxx(String ysxx) {
		this.ysxx = ysxx;
	}
	/**
	 * 获取：移送信息
	 */
	public String getYsxx() {
		return ysxx;
	}
	/**
	 * 设置：结案日期
	 */
	public void setJarq(Date jarq) {
		this.jarq = jarq;
	}
	/**
	 * 获取：结案日期
	 */
	public Date getJarq() {
		return jarq;
	}
	/**
	 * 设置：是否结案N：未结案Y：已结案
	 */
	public void setSfja(String sfja) {
		this.sfja = sfja;
	}
	/**
	 * 获取：是否结案N：未结案Y：已结案
	 */
	public String getSfja() {
		return sfja;
	}
	/**
	 * 设置：案卷号
	 */
	public void setAjh(String ajh) {
		this.ajh = ajh;
	}
	/**
	 * 获取：案卷号
	 */
	public String getAjh() {
		return ajh;
	}
	/**
	 * 设置：备注
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 获取：备注
	 */
	public String getBz() {
		return bz;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCjsj() {
		return cjsj;
	}
	/**
	 * 设置：修改时间
	 */
	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getXgsj() {
		return xgsj;
	}
	/**
	 * 设置：数据来源
	 */
	public void setSjly(String sjly) {
		this.sjly = sjly;
	}
	/**
	 * 获取：数据来源
	 */
	public String getSjly() {
		return sjly;
	}
	/**
	 * 设置：状态0：新增1：修改2：删除
	 */
	public void setZt(String zt) {
		this.zt = zt;
	}
	/**
	 * 获取：状态0：新增1：修改2：删除
	 */
	public String getZt() {
		return zt;
	}
	/**
	 * 设置：是否已交换N：未交换Y：已交换
	 */
	public void setSfyjh(String sfyjh) {
		this.sfyjh = sfyjh;
	}
	/**
	 * 获取：是否已交换N：未交换Y：已交换
	 */
	public String getSfyjh() {
		return sfyjh;
	}
	/**
	 * 设置：审核状态
	 */
	public void setShzt(String shzt) {
		this.shzt = shzt;
	}
	/**
	 * 获取：审核状态
	 */
	public String getShzt() {
		return shzt;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getTyshxydm() {
		return tyshxydm;
	}
	/**
	 * 设置：作出决定的相关材料
	 */
	public void setZcjdxgcl(String zcjdxgcl) {
		this.zcjdxgcl = zcjdxgcl;
	}
	/**
	 * 获取：作出决定的相关材料
	 */
	public String getZcjdxgcl() {
		return zcjdxgcl;
	}
	/**
	 * 设置：违法案件类型
	 */
	public void setWfajlx(String wfajlx) {
		this.wfajlx = wfajlx;
	}
	/**
	 * 获取：违法案件类型
	 */
	public String getWfajlx() {
		return wfajlx;
	}
	/**
	 * 设置：更新时间戳
	 */
	public void setXyhnDbTime(Date xyhnDbTime) {
		this.xyhnDbTime = xyhnDbTime;
	}
	/**
	 * 获取：更新时间戳
	 */
	public Date getXyhnDbTime() {
		return xyhnDbTime;
	}
	/**
	 * 设置：主键
	 */
	public void setZjid(Long zjid) {
		this.zjid = zjid;
	}
	/**
	 * 获取：主键
	 */
	public Long getZjid() {
		return zjid;
	}
}
