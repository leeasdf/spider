package xin.tianchuang.modules.externalApi.qichacha.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import xin.tianchuang.modules.externalApi.qichacha.meta.ResultObj;

/**
 * Created by yp-tc-m-7179 on 2018/12/19.
 *
 */
public class Patent implements ResultObj {
    private String documentTypes;//文档类型
    private String agent;//代理人
    private String legalStatusDate;//法律状态日期
    private String primaryExaminer;//审查官
    private String assiantExaminer;//助理审查官
    private String cites;//引用
    private String otherReferences;//其他参考文献
    private String patentImage;//专利图片
    private String ipcList;//国际专利分类号（IPC）
    private String applicationNumber;//申请号
    private String applicationDate;//申请日
    private String publicationNumber;//公开（公告）号
    private String publicationDate;//公开（公告）日
    private String legalStatusDesc;//法律状态详情
    private String title;//标题
    private String abstractText;//摘要介绍
    private String agency;//专利代理机构
    private String kindCodeDesc;//类型名称
    private String ipcDesc;//国际专利分类详情
    private String inventorStringList;//发明人
    private String assigneestringList;//申请人
    private String patentLegalHistory;//法律状态历史记录

    public String getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(String documentTypes) {
        this.documentTypes = documentTypes;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getLegalStatusDate() {
        return legalStatusDate;
    }

    public void setLegalStatusDate(String legalStatusDate) {
        this.legalStatusDate = legalStatusDate;
    }

    public String getPrimaryExaminer() {
        return primaryExaminer;
    }

    public void setPrimaryExaminer(String primaryExaminer) {
        this.primaryExaminer = primaryExaminer;
    }

    public String getAssiantExaminer() {
        return assiantExaminer;
    }

    public void setAssiantExaminer(String assiantExaminer) {
        this.assiantExaminer = assiantExaminer;
    }

    public String getCites() {
        return cites;
    }

    public void setCites(String cites) {
        this.cites = cites;
    }

    public String getOtherReferences() {
        return otherReferences;
    }

    public void setOtherReferences(String otherReferences) {
        this.otherReferences = otherReferences;
    }

    public String getPatentImage() {
        return patentImage;
    }

    public void setPatentImage(String patentImage) {
        this.patentImage = patentImage;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getPublicationNumber() {
        return publicationNumber;
    }

    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getLegalStatusDesc() {
        return legalStatusDesc;
    }

    public void setLegalStatusDesc(String legalStatusDesc) {
        this.legalStatusDesc = legalStatusDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getKindCodeDesc() {
        return kindCodeDesc;
    }

    public void setKindCodeDesc(String kindCodeDesc) {
        this.kindCodeDesc = kindCodeDesc;
    }

    public String getIpcDesc() {
        return ipcDesc;
    }

    public void setIpcDesc(String ipcDesc) {
        this.ipcDesc = ipcDesc;
    }

    public String getInventorStringList() {
        return inventorStringList;
    }

    public void setInventorStringList(String inventorStringList) {
        this.inventorStringList = inventorStringList;
    }

    public String getAssigneestringList() {
        return assigneestringList;
    }

    public void setAssigneestringList(String assigneestringList) {
        this.assigneestringList = assigneestringList;
    }

    public String getPatentLegalHistory() {
        return patentLegalHistory;
    }

    public void setPatentLegalHistory(String patentLegalHistory) {
        this.patentLegalHistory = patentLegalHistory;
    }

    @Override
    public Patent getEntity(String result) {
        if (StringUtils.isNotBlank(result)){
            JSONObject jsonObject = JSON.parseObject(result);
            setDocumentTypes(jsonObject.getString("DocumentTypes"));
            setAgent(jsonObject.getString("Agent"));
            setLegalStatusDate(jsonObject.getString("LegalStatusDate"));
            setPrimaryExaminer(jsonObject.getString("PrimaryExaminer"));
            setAssiantExaminer(jsonObject.getString("AssiantExaminer"));
            setCites(jsonObject.getString("Cites"));
            setOtherReferences(jsonObject.getString("OtherReferences"));
            setPatentImage(jsonObject.getString("PatentImage"));
            setIpcList(jsonObject.getString("IPCList"));
            setApplicationNumber(jsonObject.getString("ApplicationNumber"));
            setApplicationDate(jsonObject.getString("ApplicationDate"));
            setPublicationNumber(jsonObject.getString("PublicationNumber"));
            setPublicationDate(jsonObject.getString("PublicationDate"));
            setLegalStatusDesc(jsonObject.getString("LegalStatusDesc"));
            setTitle(jsonObject.getString("Title"));
            setAbstractText(jsonObject.getString("AbstractText"));
            setAgency(jsonObject.getString("Agency"));
            setKindCodeDesc(jsonObject.getString("KindCodeDesc"));
            setIpcDesc(jsonObject.getString("IPCDesc"));
            setInventorStringList(jsonObject.getString("InventorStringList"));
            setAssigneestringList(jsonObject.getString("AssigneestringList"));
            setPatentLegalHistory(jsonObject.getString("PatentLegalHistory"));
        }
        return this;
    }

    public String getIpcList() {
        return ipcList;
    }

    public void setIpcList(String ipcList) {
        this.ipcList = ipcList;
    }
}
