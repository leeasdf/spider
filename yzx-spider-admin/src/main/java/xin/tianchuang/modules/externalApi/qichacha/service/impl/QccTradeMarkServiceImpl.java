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
import xin.tianchuang.modules.externalApi.qichacha.dao.QccTradeMarkDao;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTradeMarkEntity;
import xin.tianchuang.modules.externalApi.qichacha.entity.TradeMarkQuery;
import xin.tianchuang.modules.externalApi.qichacha.entity.TradeMarkResult;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRq;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaPagingRs;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTradeMarkService;
import xin.tianchuang.modules.externalApi.qichacha.service.QichachaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;


@Service("qccTradeMarkService")
public class QccTradeMarkServiceImpl extends ServiceImpl<QccTradeMarkDao, QccTradeMarkEntity> implements QccTradeMarkService {

    @Autowired
    private QichachaService qichachaService;

    @Autowired
    private QichachaApiConfig config;

    @Autowired
    private ExecutorService executors;

    @Autowired
    private QccTradeMarkDao qccTradeMarkDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String entName = params.get("ent_name").toString();
        Page<QccTradeMarkEntity> page = this.selectPage(
                new Query<QccTradeMarkEntity>(params).getPage(),
                new EntityWrapper<QccTradeMarkEntity>().eq("data_status",DataStatusEnum.ACTIVE.key())
                        .eq(entName != null||!entName.equals(""),"ent_name", entName)
        );

        return new PageUtils(page);
    }

    @Override
    public void getApiQccTradeMark(String searchKey) {
        TradeMarkQuery rq= new TradeMarkQuery();
        final QichachaPagingRq qichachaRq = QichachaUtils.newPagingRq();
        rq.setKey(qichachaRq.getParam().getKey());
        rq.setDtype(qichachaRq.getParam().getDtype());
        rq.setKeyword(searchKey);
        qichachaRq.setParam(rq);
        qichachaRq.setUrl(config.trademark);
        try {
            QichachaPagingRs rs = qichachaService.getPagingData(qichachaRq, TradeMarkResult.class, "商标查询");
            if (QichachaStatusCode.CODE_200.equals(rs.getStatus())) {
                if (rs.getPaging().getTotalRecords() > qichachaRq.getParam().getPageSize()) {
                    getApiQccTradeMarkLtPageSize(qichachaRq);
                }
                List<TradeMarkResult> list = rs.getResult();
                List<QccTradeMarkEntity> entityList = new ArrayList<>();
                for(TradeMarkResult tradeMarkResult :list){
                    QccTradeMarkEntity entity = new QccTradeMarkEntity();
                    BeanUtils.copyProperties(tradeMarkResult,entity);
                    entity.setCreateTime(new Date());
                    entity.setEntName(searchKey);
                    entity.setDataStatus(DataStatusEnum.ACTIVE.key());
                    entityList.add(entity);
                }
                insertBatch(entityList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateDataStatusByEntName(String name, DataStatusEnum statusEnum) {
        qccTradeMarkDao.deleteByEntName(name,statusEnum.key());

    }

    private void getApiQccTradeMarkLtPageSize(QichachaPagingRq rq) {
        Integer pageSize = rq.getParam().getPageSize();
        Integer pageIndex = rq.getParam().getPageIndex();
        rq.getParam().setPageIndex(pageIndex+1);
        try {
            QichachaPagingRs rs=qichachaService.getPagingData(rq,TradeMarkResult.class,"商标查询");
            if(QichachaStatusCode.CODE_200.equals(rs.getStatus())){
                List<TradeMarkResult> list = rs.getResult();
                List<QccTradeMarkEntity> entityList = new ArrayList<>();
                for(TradeMarkResult tradeMarkResult :list){
                    QccTradeMarkEntity entity = new QccTradeMarkEntity();
                    BeanUtils.copyProperties(tradeMarkResult,entity);
                    entity.setCreateTime(new Date());
                    entity.setEntName(rq.getParam().getSearchKey());
                    entity.setDataStatus(DataStatusEnum.ACTIVE.key());
                    entityList.add(entity);
                }
                insertBatch(entityList);
            }
            Integer  hasRecord = pageSize*rq.getParam().getPageIndex();
            if(hasRecord<rs.getPaging().getTotalRecords() && hasRecord<config.getMaxRecord()){
                getApiQccTradeMarkLtPageSize(rq);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
