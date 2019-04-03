package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaApiConfig;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaStatusCode;
import xin.tianchuang.modules.externalApi.qichacha.dao.QichachaDataPatentDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.Patent;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaDataPatentEntity;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRq;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRs;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaDataPatentService;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;


@Service("qichachaDataPatentService")
public class QichachaDataPatentServiceImpl extends ServiceImpl<QichachaDataPatentDao, QichachaDataPatentEntity> implements QichachaDataPatentService {
    @Autowired
    private QichachaService qichachaService;

    @Autowired
    private QichachaApiConfig config;

    @Autowired
    private ExecutorService executors;

    @Resource
    private QichachaDataPatentDao patentDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String entName = params.get("ent_name").toString();
        Page<QichachaDataPatentEntity> page = this.selectPage(
                new Query<QichachaDataPatentEntity>(params).getPage(),
                new EntityWrapper<QichachaDataPatentEntity>().eq("data_status", DataStatusEnum.ACTIVE.key())
                        .eq(entName != null||!entName.equals(""),"ent_name", entName)
        );

        return new PageUtils(page);
    }

    @Override
    public void getApiQccPatent(String searchKey) {
        final QichachaPagingRq rq = QichachaUtils.newPagingRq();
        rq.getParam().setSearchKey(searchKey);
        rq.setUrl(config.patent);
        try {
            QichachaPagingRs rs = qichachaService.getPagingData(rq, Patent.class, "专利查询");
            if (QichachaStatusCode.CODE_200.equals(rs.getStatus())) {
                if (rs.getPaging().getTotalRecords() > rq.getParam().getPageSize()) {
                    getApiQccPatentLtPageSize(rq);
                }
                List<Patent> list = rs.getResult();
                List<QichachaDataPatentEntity> entityList = new ArrayList<>();
                for (Patent patent : list) {
                    QichachaDataPatentEntity entity = new QichachaDataPatentEntity();
                    BeanUtils.copyProperties(patent, entity);
                    entity.setCreateTime(new Date());
                    entity.setEntName(searchKey);
                    entity.setDataStatus(DataStatusEnum.ACTIVE.key());
                    entityList.add(entity);
                }
                insertBatch(entityList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataStatusByEntName(String name, DataStatusEnum statusEnum) {
        patentDao.deleteByEntName(name, statusEnum.key());
    }

    private void getApiQccPatentLtPageSize(QichachaPagingRq rq) {
        Integer pageSize = rq.getParam().getPageSize();
        Integer pageIndex = rq.getParam().getPageIndex();
        rq.getParam().setPageIndex(pageIndex + 1);
        try {
            QichachaPagingRs rs = qichachaService.getPagingData(rq, Patent.class, "专利查询");
            if (QichachaStatusCode.CODE_200.equals(rs.getStatus())) {
                List<Patent> list = rs.getResult();
                List<QichachaDataPatentEntity> entityList = new ArrayList<>();
                for (Patent patent : list) {
                    QichachaDataPatentEntity entity = new QichachaDataPatentEntity();
                    BeanUtils.copyProperties(patent, entity);
                    entity.setCreateTime(new Date());
                    entity.setEntName(rq.getParam().getSearchKey());
                    entity.setDataStatus(DataStatusEnum.ACTIVE.key());
                    entityList.add(entity);
                }
                insertBatch(entityList);
            }
            Integer hasRecord = pageSize * rq.getParam().getPageIndex();
            if (hasRecord < rs.getPaging().getTotalRecords() && hasRecord < config.getMaxRecord()) {
                getApiQccPatentLtPageSize(rq);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
