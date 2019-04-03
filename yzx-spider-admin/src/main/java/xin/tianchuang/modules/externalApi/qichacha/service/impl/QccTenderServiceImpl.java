package xin.tianchuang.modules.externalApi.qichacha.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.externalApi.qichacha.QichachaUtils;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaApiConfig;
import xin.tianchuang.modules.externalApi.qichacha.config.QichachaStatusCode;
import xin.tianchuang.modules.externalApi.qichacha.dao.QccTenderDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTenderEntity;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRq;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRs;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTenderService;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("qccTenderService")
public class QccTenderServiceImpl extends ServiceImpl<QccTenderDao, QccTenderEntity> implements QccTenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QccTenderServiceImpl.class);

    @Autowired
    private QichachaService qichachaService;
    @Autowired
    private QichachaApiConfig config;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        params.put("sidx","id");
        params.put("order","ASC");
        String entName = params.get("ent_name").toString();
        Page<QccTenderEntity> page = this.selectPage(
                new Query<QccTenderEntity>(params).getPage(),
                new EntityWrapper<QccTenderEntity>().eq("data_status", DataStatusEnum.ACTIVE.key())
                        .eq(StrUtil.isNotBlank(entName),"ent_name", entName)

        );

        return new PageUtils(page);
    }


    @Override
    public void getApiQccTender(String searchKey) {
        QichachaPagingRq rq= QichachaUtils.newPagingRq();
        rq.getParam().setSearchKey(searchKey);
        rq.setUrl(config.getTender());
        try {
            QichachaPagingRs rs = qichachaService.getPagingData(rq, QccTenderEntity.class, "企业招投标信息");
            if(QichachaStatusCode.CODE_200.equals(rs.getStatus())){
                if(rs.getPaging().getTotalRecords()>rq.getParam().getPageSize()){
//                    executors.execute(()->{
                    getApiQccTenderLtPageSize(rq);
//                    });
                }
                List<QccTenderEntity> list = rs.getResult();
                for(QccTenderEntity entity :list){
                    entity.setCreateTime(new Date());
                    entity.setEntName(searchKey);
                    entity.setDataStatus(DataStatusEnum.ACTIVE.key());
                }
                insertBatch(list);
            }
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            e.printStackTrace();
        }

    }

    private void getApiQccTenderLtPageSize(QichachaPagingRq rq) {
        Integer pageSize = rq.getParam().getPageSize();

        Integer hasRecord=0;
        QichachaPagingRs rs;
        List<QccTenderEntity> list=new ArrayList<>();
        try {
            do {
                Integer pageIndex = rq.getParam().getPageIndex();
                rq.getParam().setPageIndex(pageIndex+1);
                rs = qichachaService.getPagingData(rq, QccTenderEntity.class, "企业招投标信息");
                if (QichachaStatusCode.CODE_200.equals(rs.getStatus())) {

                    List<QccTenderEntity> sublist = rs.getResult();
                    for (QccTenderEntity entity : sublist) {
                        entity.setCreateTime(new Date());
                        entity.setEntName(rq.getParam().getSearchKey());
                        entity.setDataStatus(DataStatusEnum.ACTIVE.key());
                    }
                    list.addAll(sublist);
                }
                hasRecord= pageSize * rq.getParam().getPageIndex();
            }while (hasRecord<rs.getPaging().getTotalRecords() && hasRecord<config.getMaxRecord());
            insertBatch(list);
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataStatusByEntName(String name, DataStatusEnum statusEnum) {
        this.baseMapper.updateDataStatusByEntName(name,statusEnum.key());
    }
}
