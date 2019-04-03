package xin.tianchuang.modules.api.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.transaction.annotation.Transactional;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.api.dao.SysAppApiDao;
import xin.tianchuang.modules.api.entity.SysAppApiEntity;
import xin.tianchuang.modules.api.service.SysAppApiService;
import xin.tianchuang.modules.sys.entity.SysRoleMenuEntity;


@Service("sysAppApiService")
public class SysAppApiServiceImpl extends ServiceImpl<SysAppApiDao, SysAppApiEntity> implements SysAppApiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysAppApiEntity> page = this.selectPage(
                new Query<SysAppApiEntity>(params).getPage(),
                new EntityWrapper<SysAppApiEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public SysAppApiEntity queryInfoByApiIdAndAppId(String appId, Integer apiId) {
		return this.baseMapper.queryInfoByApiIdAndAppId(appId, apiId);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(String appId, List<Long> apiIdList) {
        //先删除应用与api的关系
        deleteBatch(new String[]{appId});

        if(apiIdList.size() == 0){
            return ;
        }

        //保存应用与api关系
        List<SysAppApiEntity> list = new ArrayList<>(apiIdList.size());
        for(Long apiId : apiIdList){
            SysAppApiEntity appApiEntity = new SysAppApiEntity();
            appApiEntity.setApiId(apiId);
            appApiEntity.setAppId(appId+"");

            list.add(appApiEntity);
        }
        this.insertBatch(list);
    }

    @Override
    public int deleteBatch(String[] appIds) {
        return baseMapper.deleteBatch(appIds);
    }
}
