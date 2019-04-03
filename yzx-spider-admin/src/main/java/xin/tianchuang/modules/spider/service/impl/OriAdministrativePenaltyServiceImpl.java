package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriAdministrativePenaltyDao;
import xin.tianchuang.modules.spider.entity.OriAdministrativePenaltyEntity;
import xin.tianchuang.modules.spider.service.OriAdministrativePenaltyService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriAdministrativePenaltyService")
public class OriAdministrativePenaltyServiceImpl extends ServiceImpl<OriAdministrativePenaltyDao, OriAdministrativePenaltyEntity> implements OriAdministrativePenaltyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String pollutionSourceName = (String) params.get("pollutionSourceName");
        Page<OriAdministrativePenaltyEntity> page = this.selectPage(
                new Query<OriAdministrativePenaltyEntity>(params).getPage(),
                new EntityWrapper<OriAdministrativePenaltyEntity>() //
                .like(StringUtils.isNotBlank(pollutionSourceName), "pollution_source_name", pollutionSourceName)//
				.orderBy("create_time", false) //
        );

        return new PageUtils(page);
    }

}
