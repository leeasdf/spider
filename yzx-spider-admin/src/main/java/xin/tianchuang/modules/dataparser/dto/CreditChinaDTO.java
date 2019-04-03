package xin.tianchuang.modules.dataparser.dto;

import xin.tianchuang.modules.dataparser.entity.CreditchinaBaseInfoEntity;
import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeRecordEntity;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPenaltyEntity;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPermissionEntity;

import java.util.List;

/**
 * Created by lee on 2018/10/12.
 * 信用中国网站对象解析结果对象
 * 路由记录表的意义在于可以根据这个记录找到对应的解析记录在那张表里面
 * 路由记录表冗余这么多路由定义表字段的意义在于不用在去查询路由定义表的内容了（后面觉得可以多查定义表获得信息的话可以去掉重复的字段）
 */
public class CreditChinaDTO {

    /**
     * 基本信息
     */
    private CreditchinaBaseInfoEntity baseInfo;

    /**
     * 行政许可
     */
    private List<CreditchinaPubPermissionEntity> permissions;
    /**
     * 行政处罚
     */
    private List<CreditchinaPubPenaltyEntity> penaltys;
    /**
     * 守信红名单+重点关注名单+黑名单
     */
    private List<Object> lists;

    /**
     * 路由记录 每一条红名单、重点关注、黑名单 都对应一条路由记录
     */
    private List<CreditchinaCreditTypeRecordEntity> routes;

    public CreditchinaBaseInfoEntity getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(CreditchinaBaseInfoEntity baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<CreditchinaPubPermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<CreditchinaPubPermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public List<CreditchinaPubPenaltyEntity> getPenaltys() {
        return penaltys;
    }

    public void setPenaltys(List<CreditchinaPubPenaltyEntity> penaltys) {
        this.penaltys = penaltys;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public List<CreditchinaCreditTypeRecordEntity> getRoutes() {
        return routes;
    }

    public void setRoutes(List<CreditchinaCreditTypeRecordEntity> routes) {
        this.routes = routes;
    }
}
