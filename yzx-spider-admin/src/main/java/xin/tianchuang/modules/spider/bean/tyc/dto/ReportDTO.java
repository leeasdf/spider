package xin.tianchuang.modules.spider.bean.tyc.dto;

import java.io.Serializable;
import java.util.List;

import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportAmountInfoResult;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportBaseInfoResult;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportInvestResults;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportShareholderResults;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportSocialInfoResult;
import xin.tianchuang.modules.spider.bean.tyc.dto.report.ReportWebsiteResults;

/**
 * 企业年报
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 10:14:18
 */

public class ReportDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 412061646881888338L;

	/**
	 * 年报标题
	 */
	private String reportTitle;

	/**
	 * 年份
	 */
	private String years;

	/**
	 * 社保信息
	 */
	private ReportSocialInfoResult ReportSocialInfoResult;

	/**
	 * 企业资产状况信息
	 */
	private ReportAmountInfoResult ReportAmountInfoResult;

	/**
	 * 对外投资信息
	 */
	private List<ReportInvestResults> investResults;
	/**
	 * 企业基本信息
	 */
	private ReportBaseInfoResult ReportBaseInfoResult;

	/**
	 * 股东及出资信息
	 */
	private List<ReportShareholderResults> shareholderResults;
	/**
	 * 网站或网店信息
	 */
	private List<ReportWebsiteResults> websiteResults;

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public ReportSocialInfoResult getReportSocialInfoResult() {
		return ReportSocialInfoResult;
	}

	public void setReportSocialInfoResult(ReportSocialInfoResult reportSocialInfoResult) {
		ReportSocialInfoResult = reportSocialInfoResult;
	}

	public ReportAmountInfoResult getReportAmountInfoResult() {
		return ReportAmountInfoResult;
	}

	public void setReportAmountInfoResult(ReportAmountInfoResult reportAmountInfoResult) {
		ReportAmountInfoResult = reportAmountInfoResult;
	}

	public List<ReportInvestResults> getInvestResults() {
		return investResults;
	}

	public void setInvestResults(List<ReportInvestResults> investResults) {
		this.investResults = investResults;
	}

	public ReportBaseInfoResult getReportBaseInfoResult() {
		return ReportBaseInfoResult;
	}

	public void setReportBaseInfoResult(ReportBaseInfoResult reportBaseInfoResult) {
		ReportBaseInfoResult = reportBaseInfoResult;
	}

	public List<ReportShareholderResults> getShareholderResults() {
		return shareholderResults;
	}

	public void setShareholderResults(List<ReportShareholderResults> shareholderResults) {
		this.shareholderResults = shareholderResults;
	}

	public List<ReportWebsiteResults> getWebsiteResults() {
		return websiteResults;
	}

	public void setWebsiteResults(List<ReportWebsiteResults> websiteResults) {
		this.websiteResults = websiteResults;
	}

}
