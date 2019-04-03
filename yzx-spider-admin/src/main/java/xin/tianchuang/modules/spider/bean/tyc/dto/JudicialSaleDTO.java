package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;

/**
 * 企业-司法拍卖信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 10:14:18
 */

public class JudicialSaleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5446803410867000846L;
	/**
	 * 拍卖公告
	 */
	private String publicNotice;
	/**
	 * 公告日期
	 */
	private String publicDate;
	/**
	 * 执行法院
	 */
	private String court;
	/**
	 * 拍卖标的
	 */
	private String auctionTarget;

	public String getPublicNotice() {
		return publicNotice;
	}

	public void setPublicNotice(String publicNotice) {
		this.publicNotice = publicNotice;
	}

	public String getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getAuctionTarget() {
		return auctionTarget;
	}

	public void setAuctionTarget(String auctionTarget) {
		this.auctionTarget = auctionTarget;
	}

}
