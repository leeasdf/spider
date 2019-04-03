package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaApiConfig;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaStatusCode;
import xin.tianchuang.modules.externalApi.qichacha.dao.QccSeriousViolationDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccSeriousViolationEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.SeriousViolation;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaDefaultListRs;
import xin.tianchuang.modules.externalApi.qichacha.meta.SeriousViolationParam;
import xin.tianchuang.modules.externalApi.qichacha.meta.SeriousViolationReqParam;
import xin.tianchuang.modules.externalApi.qichacha.service.QccSeriousViolationService;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaService;

import javax.annotation.Resource;

@Service("qccSeriousViolationService")
public class QccSeriousViolationServiceImpl extends ServiceImpl<QccSeriousViolationDao, QccSeriousViolationEntity> implements QccSeriousViolationService {

    @Autowired
    private QichachaService qichachaService;
    @Autowired
    private QichachaApiConfig config;
    @Resource
    private QccSeriousViolationDao qccSeriousViolationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String entName = params.get("ent_name").toString();
        Page<QccSeriousViolationEntity> page = this.selectPage(
                new Query<QccSeriousViolationEntity>(params).getPage(),
                new EntityWrapper<QccSeriousViolationEntity>().eq("data_status", DataStatusEnum.ACTIVE.key())
                        .eq(entName != null||!entName.equals(""),"ent_name", entName)
        );
        return new PageUtils(page);
    }

    @Override
    public void getApiQccViolation(String searchKey) {
        SeriousViolationReqParam rq = QichachaUtils.newViolationRq();
        SeriousViolationParam seriousViolationParam = new SeriousViolationParam();
        seriousViolationParam.setKey(rq.getParam().getKey());
        seriousViolationParam.setKeyword(searchKey);
        rq.setParam(seriousViolationParam);
        rq.setUrl(config.seriousViolation);
        try {
            QichachaDefaultListRs rs = qichachaService.getListData(rq, SeriousViolation.class, "严重违法信息查询");
            if (QichachaStatusCode.CODE_200.equals(rs.getStatus())) {
                List<SeriousViolation> seriousViolationList = rs.getResult();
                List<QccSeriousViolationEntity> qccSeriousViolationEntities = new ArrayList<>();
                if (seriousViolationList != null && seriousViolationList.size() > 0) {
                    for (SeriousViolation seriousViolation : seriousViolationList) {
                        QccSeriousViolationEntity qccSeriousViolationEntity = new QccSeriousViolationEntity();
                        BeanUtils.copyProperties(seriousViolation, qccSeriousViolationEntity);
                        qccSeriousViolationEntity.setCreateTime(new Date());
                        qccSeriousViolationEntity.setEntName(searchKey);
                        qccSeriousViolationEntity.setDataStatus(DataStatusEnum.ACTIVE.key());
                        qccSeriousViolationEntities.add(qccSeriousViolationEntity);
                    }
                    insertBatch(qccSeriousViolationEntities);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataStatusByEntName(String name, DataStatusEnum statusEnum) {
        qccSeriousViolationDao.deleteByEntName(name, statusEnum.key());
    }

}
