package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.SpiderMissionDao;
import xin.tianchuang.modules.spider.entity.SpiderMissionEntity;
import xin.tianchuang.modules.spider.service.SpiderMissionService;


@Service("spiderMissionService")
public class SpiderMissionServiceImpl extends ServiceImpl<SpiderMissionDao, SpiderMissionEntity> implements SpiderMissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("key");
        Page<SpiderMissionEntity> page = this.selectPage(
                new Query<SpiderMissionEntity>(params).getPage(),
                new EntityWrapper<SpiderMissionEntity>().like(StringUtils.isNotBlank(name),"spider_mission_name",name)
        );

        return new PageUtils(page);
    }

}
