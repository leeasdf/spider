package xin.tianchuang.modules.api.bean.v1;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by lee on 2019/1/2.
 */
public class QccTenderApiDTO {

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
