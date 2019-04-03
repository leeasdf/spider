package xin.tianchuang.modules.externalApi.qichacha.vo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.*;
import xin.tianchuang.modules.externalApi.qichacha.meta.ResultObj;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/1/4.
 */
public class QccBasicInfo implements ResultObj{
    private QccBasicEntity basicEntity;
    private QccBasicIndustryEntity industryEntity;
    private QccBasicContactInfoEntity contactInfoEntity;
    private QccBasicLiquidationEntity liquidationEntity;
    private List<QccBasicBranchesEntity> basicBranchesEntityList;
    private List<QccBasicChangeRecordsEntity> changeRecordsEntityList;
    private List<QccBasicCompanyProductsEntity> companyProductsEntityList;
    private List<QccBasicCompanyTaxCreditItemsEntity> companyTaxCreditItemsEntityList;
    private List<QccBasicEmployeesEntity> employeesEntityList;
    private List<QccBasicMPledgeEntity> mPledgeEntityList;
    private List<QccBasicOriginalNameEntity> originalNameEntityList;
    private List<QccBasicPartnersEntity> partnersEntityList;
    private List<QccBasicPenaltyCreditChinaEntity> penaltyCreditChinaEntityList;
    private List<QccBasicPenaltyEntity> penaltyEntityList;
    private List<QccBasicPermissionEciinfoEntity> permissionEciinfoEntityList;
    private List<QccBasicPermissionInfoEntity> permissionInfoEntityList;
    private List<QccBasicPledgeEntity> pledgeEntityList;
    private List<QccBasicShixinItemsEntity> shixinItemsEntityList;
    private List<QccBasicSpotCheckEntity> spotCheckEntityList;
    private List<QccBasicZhixingItemsEntity> zhixingItemsEntityList;
    private List<QccBasicExceptionsEntity> exceptionsEntityList;

    public List<QccBasicExceptionsEntity> getExceptionsEntityList() {
        return exceptionsEntityList;
    }

    public void setExceptionsEntityList(List<QccBasicExceptionsEntity> exceptionsEntityList) {
        this.exceptionsEntityList = exceptionsEntityList;
    }

    public List<QccBasicBranchesEntity> getBasicBranchesEntityList() {
        return basicBranchesEntityList;
    }

    public void setBasicBranchesEntityList(List<QccBasicBranchesEntity> basicBranchesEntityList) {
        this.basicBranchesEntityList = basicBranchesEntityList;
    }

    public List<QccBasicChangeRecordsEntity> getChangeRecordsEntityList() {
        return changeRecordsEntityList;
    }

    public void setChangeRecordsEntityList(List<QccBasicChangeRecordsEntity> changeRecordsEntityList) {
        this.changeRecordsEntityList = changeRecordsEntityList;
    }

    public List<QccBasicCompanyProductsEntity> getCompanyProductsEntityList() {
        return companyProductsEntityList;
    }

    public void setCompanyProductsEntityList(List<QccBasicCompanyProductsEntity> companyProductsEntityList) {
        this.companyProductsEntityList = companyProductsEntityList;
    }

    public List<QccBasicCompanyTaxCreditItemsEntity> getCompanyTaxCreditItemsEntityList() {
        return companyTaxCreditItemsEntityList;
    }

    public void setCompanyTaxCreditItemsEntityList(List<QccBasicCompanyTaxCreditItemsEntity> companyTaxCreditItemsEntityList) {
        this.companyTaxCreditItemsEntityList = companyTaxCreditItemsEntityList;
    }

    public QccBasicContactInfoEntity getContactInfoEntity() {
        return contactInfoEntity;
    }

    public void setContactInfoEntity(QccBasicContactInfoEntity contactInfoEntity) {
        this.contactInfoEntity = contactInfoEntity;
    }

    public List<QccBasicEmployeesEntity> getEmployeesEntityList() {
        return employeesEntityList;
    }

    public void setEmployeesEntityList(List<QccBasicEmployeesEntity> employeesEntityList) {
        this.employeesEntityList = employeesEntityList;
    }

    public QccBasicEntity getBasicEntity() {
        return basicEntity;
    }

    public void setBasicEntity(QccBasicEntity basicEntity) {
        this.basicEntity = basicEntity;
    }

    public QccBasicIndustryEntity getIndustryEntity() {
        return industryEntity;
    }

    public void setIndustryEntity(QccBasicIndustryEntity industryEntity) {
        this.industryEntity = industryEntity;
    }

    public QccBasicLiquidationEntity getLiquidationEntity() {
        return liquidationEntity;
    }

    public void setLiquidationEntity(QccBasicLiquidationEntity liquidationEntity) {
        this.liquidationEntity = liquidationEntity;
    }

    public List<QccBasicMPledgeEntity> getmPledgeEntityList() {
        return mPledgeEntityList;
    }

    public void setmPledgeEntityList(List<QccBasicMPledgeEntity> mPledgeEntityList) {
        this.mPledgeEntityList = mPledgeEntityList;
    }

    public List<QccBasicOriginalNameEntity> getOriginalNameEntityList() {
        return originalNameEntityList;
    }

    public void setOriginalNameEntityList(List<QccBasicOriginalNameEntity> originalNameEntityList) {
        this.originalNameEntityList = originalNameEntityList;
    }

    public List<QccBasicPartnersEntity> getPartnersEntityList() {
        return partnersEntityList;
    }

    public void setPartnersEntityList(List<QccBasicPartnersEntity> partnersEntityList) {
        this.partnersEntityList = partnersEntityList;
    }

    public List<QccBasicPenaltyCreditChinaEntity> getPenaltyCreditChinaEntityList() {
        return penaltyCreditChinaEntityList;
    }

    public void setPenaltyCreditChinaEntityList(List<QccBasicPenaltyCreditChinaEntity> penaltyCreditChinaEntityList) {
        this.penaltyCreditChinaEntityList = penaltyCreditChinaEntityList;
    }

    public List<QccBasicPenaltyEntity> getPenaltyEntityList() {
        return penaltyEntityList;
    }

    public void setPenaltyEntityList(List<QccBasicPenaltyEntity> penaltyEntityList) {
        this.penaltyEntityList = penaltyEntityList;
    }

    public List<QccBasicPermissionEciinfoEntity> getPermissionEciinfoEntityList() {
        return permissionEciinfoEntityList;
    }

    public void setPermissionEciinfoEntityList(List<QccBasicPermissionEciinfoEntity> permissionEciinfoEntityList) {
        this.permissionEciinfoEntityList = permissionEciinfoEntityList;
    }

    public List<QccBasicPermissionInfoEntity> getPermissionInfoEntityList() {
        return permissionInfoEntityList;
    }

    public void setPermissionInfoEntityList(List<QccBasicPermissionInfoEntity> permissionInfoEntityList) {
        this.permissionInfoEntityList = permissionInfoEntityList;
    }

    public List<QccBasicPledgeEntity> getPledgeEntityList() {
        return pledgeEntityList;
    }

    public void setPledgeEntityList(List<QccBasicPledgeEntity> pledgeEntityList) {
        this.pledgeEntityList = pledgeEntityList;
    }

    public List<QccBasicShixinItemsEntity> getShixinItemsEntityList() {
        return shixinItemsEntityList;
    }

    public void setShixinItemsEntityList(List<QccBasicShixinItemsEntity> shixinItemsEntityList) {
        this.shixinItemsEntityList = shixinItemsEntityList;
    }

    public List<QccBasicSpotCheckEntity> getSpotCheckEntityList() {
        return spotCheckEntityList;
    }

    public void setSpotCheckEntityList(List<QccBasicSpotCheckEntity> spotCheckEntityList) {
        this.spotCheckEntityList = spotCheckEntityList;
    }

    public List<QccBasicZhixingItemsEntity> getZhixingItemsEntityList() {
        return zhixingItemsEntityList;
    }

    public void setZhixingItemsEntityList(List<QccBasicZhixingItemsEntity> zhixingItemsEntityList) {
        this.zhixingItemsEntityList = zhixingItemsEntityList;
    }

    @Override
    public QccBasicInfo getEntity(String data) {
        //字段名称忽略大小写后equals就复制数据
        try {
            String entName = JSON.parseObject(data).getString("Name");
            String creditCode = JSON.parseObject(data).getString("CreditCode");
            //bugfix -- 190301 --部分企业没有信用代码，用注册号代替
            if (StringUtils.isEmpty(creditCode)){
                creditCode = JSON.parseObject(data).getString("No");
            }
            setBasicEntity(QichachaUtils.tranData(JSON.parseObject(data),QccBasicEntity.class,entName,creditCode,true));
            setIndustryEntity(QichachaUtils.tranData(JSON.parseObject(data).getJSONObject("Industry"),QccBasicIndustryEntity.class,entName,creditCode,true));
            setContactInfoEntity(QichachaUtils.tranData(JSON.parseObject(data).getJSONObject("ContactInfo"),QccBasicContactInfoEntity.class,entName,creditCode,true));
            setLiquidationEntity(QichachaUtils.tranData(JSON.parseObject(data).getJSONObject("Liquidation"),QccBasicLiquidationEntity.class,entName,creditCode,true));
            setBasicBranchesEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("Branches"),QccBasicBranchesEntity.class,entName,creditCode,true));
            setChangeRecordsEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("ChangeRecords"),QccBasicChangeRecordsEntity.class,entName,creditCode,true));
            setCompanyProductsEntityList (QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("CompanyProducts"),QccBasicCompanyProductsEntity.class,entName,creditCode,true));
            setCompanyTaxCreditItemsEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("CompanyTaxCreditItems"),QccBasicCompanyTaxCreditItemsEntity.class,entName,creditCode,true));
            setEmployeesEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("Employees"),QccBasicEmployeesEntity.class,entName,creditCode,true));
            setmPledgeEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("MPledge"),QccBasicMPledgeEntity.class,entName,creditCode,true));
            setOriginalNameEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("OriginalName"),QccBasicOriginalNameEntity.class,entName,creditCode,true));
            setPartnersEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("Partners"),QccBasicPartnersEntity.class,entName,creditCode,true));
            setPenaltyCreditChinaEntityList (QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("PenaltyCreditChina"),QccBasicPenaltyCreditChinaEntity.class,entName,creditCode,true));
            setPenaltyEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("Penalty"),QccBasicPenaltyEntity.class,entName,creditCode,true));
            setPermissionEciinfoEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("PermissionEciInfo"),QccBasicPermissionEciinfoEntity.class,entName,creditCode,true));
            setPermissionInfoEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("PermissionInfo"),QccBasicPermissionInfoEntity.class,entName,creditCode,true));
            setPledgeEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("Pledge"),QccBasicPledgeEntity.class,entName,creditCode,true));
            setShixinItemsEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("ShixinItems"),QccBasicShixinItemsEntity.class,entName,creditCode,true));
            setSpotCheckEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("SpotCheck"),QccBasicSpotCheckEntity.class,entName,creditCode,true));
            setZhixingItemsEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("ZhixingItems"),QccBasicZhixingItemsEntity.class,entName,creditCode,true));
            setExceptionsEntityList(QichachaUtils.tranData(JSON.parseObject(data).getJSONArray("Exceptions"),QccBasicExceptionsEntity.class,entName,creditCode,true));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
