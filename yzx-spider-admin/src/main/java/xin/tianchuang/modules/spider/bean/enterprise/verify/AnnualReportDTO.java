package xin.tianchuang.modules.spider.bean.enterprise.verify;

/**
 * 企业年报
 * @author denghui
 *
 */
public class AnnualReportDTO {

	private int year; // 报送年度
	private int status;// 企业经营状态
	private int empNum;// 员工人数
	private int hasShareUpdate;// 有限责任公司本年度是否发⽣股东股权转让
	private int hasInvest;// 企业是否有投资信息或购买其他公司股权
	private int totalCapital;// 资产总额（人民币元）
	private Long ownerCapital;// 所有者权益合计（人民币元）
	private Long totalRevenue;// 营业总收⼊（人民币元）
	private Long totalProfit;// 利润总额（人民币元）
	private Long mainItemRevenue;// 营业总收⼊中主营业务收⼊（人民币元）
	private Long pureProfit;//净利润（人民币元） 
	private Long totalTax;// 纳税总额（人民币元）
	private Long totalDebt;// 负债总额（人民币元）
	private String launchDate;// 发布⽇期
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public int getHasShareUpdate() {
		return hasShareUpdate;
	}
	public void setHasShareUpdate(int hasShareUpdate) {
		this.hasShareUpdate = hasShareUpdate;
	}
	public int getHasInvest() {
		return hasInvest;
	}
	public void setHasInvest(int hasInvest) {
		this.hasInvest = hasInvest;
	}
	public int getTotalCapital() {
		return totalCapital;
	}
	public void setTotalCapital(int totalCapital) {
		this.totalCapital = totalCapital;
	}
	public Long getOwnerCapital() {
		return ownerCapital;
	}
	public void setOwnerCapital(Long ownerCapital) {
		this.ownerCapital = ownerCapital;
	}
	public Long getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(Long totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public Long getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(Long totalProfit) {
		this.totalProfit = totalProfit;
	}
	public Long getMainItemRevenue() {
		return mainItemRevenue;
	}
	public void setMainItemRevenue(Long mainItemRevenue) {
		this.mainItemRevenue = mainItemRevenue;
	}
	public Long getPureProfit() {
		return pureProfit;
	}
	public void setPureProfit(Long pureProfit) {
		this.pureProfit = pureProfit;
	}
	public Long getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(Long totalTax) {
		this.totalTax = totalTax;
	}
	public Long getTotalDebt() {
		return totalDebt;
	}
	public void setTotalDebt(Long totalDebt) {
		this.totalDebt = totalDebt;
	}
	public String getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}
	
}
