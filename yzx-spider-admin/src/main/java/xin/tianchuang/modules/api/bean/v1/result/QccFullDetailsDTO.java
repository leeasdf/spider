package xin.tianchuang.modules.api.bean.v1.result;


import java.util.List;
import java.util.Map;

/**
 * Created by yp-tc-m-7179 on 2019/1/2.
 */
public class QccFullDetailsDTO{

    private Map basic;//基本信息
    private Map industry;//行业分类数据
    private Map contactInfo;//联系信息
    private Map liquidation;//清算
    private List<Map> branches;//    分支机构
    private List<Map> changeRecords;//    变更信息
    private List<Map> companyProducts;//公司产品
    private List<Map> companyTaxCreditItems;//纳税信用等级
    private List<Map> employees;//主要人员
    private List<Map> mPledge;//动产抵押
    private List<Map> originalName;//曾用名
    private List<Map> partners;//投资人及出资信息
    private List<Map> penaltyCreditChina;//行政处罚【信用中国】
    private List<Map> penalty;//行政处罚
    private List<Map> permissionEciInfo;//行政许可【工商局】
    private List<Map> permissionInfo;//行政许可【信用中国】
    private List<Map> pledge;//股权出质
    private List<Map> shiXinItems;//失信
    private List<Map> spotCheck;//抽查检查
    private List<Map> zhiXingItems;//执行
    private List<Map> exceptions;//经营异常

    public Map getBasic() {
        return basic;
    }

    public void setBasic(Map basic) {
        this.basic = basic;
    }

    public Map getLiquidation() {
        return liquidation;
    }

    public void setLiquidation(Map liquidation) {
        this.liquidation = liquidation;
    }

    public Map getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Map contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Map getIndustry() {
        return industry;
    }

    public void setIndustry(Map industry) {
        this.industry = industry;
    }

    public List<Map> getPermissionInfo() {
        return permissionInfo;
    }

    public void setPermissionInfo(List<Map> permissionInfo) {
        this.permissionInfo = permissionInfo;
    }

    public List<Map> getPenalty() {
        return penalty;
    }

    public void setPenalty(List<Map> penalty) {
        this.penalty = penalty;
    }

    public List<Map> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Map> exceptions) {
        this.exceptions = exceptions;
    }

    public List<Map> getShiXinItems() {
        return shiXinItems;
    }

    public void setShiXinItems(List<Map> shiXinItems) {
        this.shiXinItems = shiXinItems;
    }

    public List<Map> getZhiXingItems() {
        return zhiXingItems;
    }

    public void setZhiXingItems(List<Map> zhiXingItems) {
        this.zhiXingItems = zhiXingItems;
    }

    public List<Map> getmPledge() {
        return mPledge;
    }

    public void setmPledge(List<Map> mPledge) {
        this.mPledge = mPledge;
    }

    public List<Map> getPledge() {
        return pledge;
    }

    public void setPledge(List<Map> pledge) {
        this.pledge = pledge;
    }

    public List<Map> getSpotCheck() {
        return spotCheck;
    }

    public void setSpotCheck(List<Map> spotCheck) {
        this.spotCheck = spotCheck;
    }

    public List<Map> getCompanyTaxCreditItems() {
        return companyTaxCreditItems;
    }

    public void setCompanyTaxCreditItems(List<Map> companyTaxCreditItems) {
        this.companyTaxCreditItems = companyTaxCreditItems;
    }

    public List<Map> getCompanyProducts() {
        return companyProducts;
    }

    public void setCompanyProducts(List<Map> companyProducts) {
        this.companyProducts = companyProducts;
    }

    public List<Map> getPermissionEciInfo() {
        return permissionEciInfo;
    }

    public void setPermissionEciInfo(List<Map> permissionEciInfo) {
        this.permissionEciInfo = permissionEciInfo;
    }

    public List<Map> getPenaltyCreditChina() {
        return penaltyCreditChina;
    }

    public void setPenaltyCreditChina(List<Map> penaltyCreditChina) {
        this.penaltyCreditChina = penaltyCreditChina;
    }

    public List<Map> getPartners() {
        return partners;
    }

    public void setPartners(List<Map> partners) {
        this.partners = partners;
    }

    public List<Map> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Map> employees) {
        this.employees = employees;
    }

    public List<Map> getBranches() {
        return branches;
    }

    public void setBranches(List<Map> branches) {
        this.branches = branches;
    }

    public List<Map> getChangeRecords() {
        return changeRecords;
    }

    public void setChangeRecords(List<Map> changeRecords) {
        this.changeRecords = changeRecords;
    }

    public List<Map> getOriginalName() {
        return originalName;
    }

    public void setOriginalName(List<Map> originalName) {
        this.originalName = originalName;
    }
}
