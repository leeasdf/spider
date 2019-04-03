package xin.tianchuang.modules.spider.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.SpiderRawDataDao;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;
import xin.tianchuang.modules.spider.service.SpiderRawDataService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("spiderRawDataService")
public class SpiderRawDataServiceImpl extends ServiceImpl<SpiderRawDataDao, SpiderRawDataEntity> implements SpiderRawDataService {

    @Autowired
    private SpiderRawDataDao spiderRawDataDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SpiderRawDataEntity> page = this.selectPage(
                new Query<SpiderRawDataEntity>(params).getPage(),
                new EntityWrapper<SpiderRawDataEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public Date selectLatestDateByType(Integer type) {
        SpiderRawDataEntity spiderRawDataEntity = spiderRawDataDao.selectLatestCreditHunanByType(type);
        Date date = null;
        try {
            if (spiderRawDataEntity != null) {
                return DateUtils.parseDate(spiderRawDataEntity.getCursorIndex(), "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss", "yyyy/MM/dd");
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public List<SpiderRawDataEntity> selectListByEnterpriseNameAndType(String enterpriseName, SpiderTypeEnum levelATaxer) {
        EntityWrapper entityWrapper=new EntityWrapper<SpiderRawDataEntity>();
        if(StringUtils.isNotBlank(enterpriseName)){
             entityWrapper.eq("ent_name",enterpriseName);
        }
        entityWrapper.eq("type",levelATaxer.key())
                .eq("if_analysised",0)
                .eq("data_state", 1);
        return spiderRawDataDao.selectList(entityWrapper);
    }

    @Override
    public Long selectLatestIdByType(int type) {
        SpiderRawDataEntity spiderRawDataEntity = spiderRawDataDao.selectLatestCreditChinaData(type);
        if (spiderRawDataEntity==null) return null;
        return Long.valueOf(spiderRawDataEntity.getCursorIndex());
    }
}
