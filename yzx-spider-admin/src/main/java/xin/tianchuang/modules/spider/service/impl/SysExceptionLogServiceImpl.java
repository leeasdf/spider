package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.spider.dao.SysExceptionLogDao;
import xin.tianchuang.modules.spider.entity.SysExceptionLogEntity;
import xin.tianchuang.modules.spider.service.SysExceptionLogService;


@Service("sysExceptionLogService")
public class SysExceptionLogServiceImpl extends ServiceImpl<SysExceptionLogDao, SysExceptionLogEntity> implements SysExceptionLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String desc = (String)params.get("key");
        Page<SysExceptionLogEntity> page = this.selectPage(
                new Query<SysExceptionLogEntity>(params).getPage(),
                new EntityWrapper<SysExceptionLogEntity>().like(StringUtils.isNotBlank(desc),"name",(String)params.get("key"))
                .orderBy("createTime",false)
        );

        return new PageUtils(page);
    }

}
