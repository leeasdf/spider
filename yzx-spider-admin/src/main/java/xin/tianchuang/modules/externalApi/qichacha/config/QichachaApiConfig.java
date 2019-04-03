package xin.tianchuang.modules.externalApi.qichacha.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lee on 2018/12/20.
 */
@Component
@ConfigurationProperties(prefix = "qichacha.api-url")
public class QichachaApiConfig {

    private Integer pageSize;

    private Integer pageIndex;

    private  Integer maxRecord;

    private  String copyright;

    public  String patent;

    public  String trademark;

    public String seriousViolation;

    public String fullDetails;

    public String getFullDetails() {
        return fullDetails;
    }

    public void setFullDetails(String fullDetails) {
        this.fullDetails = fullDetails;
    }

    public String getSeriousViolation() {
        return seriousViolation;
    }

    public void setSeriousViolation(String seriousViolation) {
        this.seriousViolation = seriousViolation;
    }

    private String tender;

    public String getTender() {
        return tender;
    }

    public void setTender(String tender) {
        this.tender = tender;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    private Integer updatePeriod;


    public Integer getUpdatePeriod() {
        return updatePeriod;
    }

    public void setUpdatePeriod(Integer updatePeriod) {
        this.updatePeriod = updatePeriod;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getMaxRecord() {
        return maxRecord;
    }

    public void setMaxRecord(Integer maxRecord) {
        this.maxRecord = maxRecord;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }
}
