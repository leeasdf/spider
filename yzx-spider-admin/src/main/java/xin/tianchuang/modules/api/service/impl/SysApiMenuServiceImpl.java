package xin.tianchuang.modules.api.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.api.dao.SysApiMenuDao;
import xin.tianchuang.modules.api.entity.SysApiMenuEntity;
import xin.tianchuang.modules.api.service.SysApiMenuService;


@Service("sysApiMenuService")
public class SysApiMenuServiceImpl extends ServiceImpl<SysApiMenuDao, SysApiMenuEntity> implements SysApiMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysApiMenuEntity> page = this.selectPage(
                new Query<SysApiMenuEntity>(params).getPage(),
                new EntityWrapper<SysApiMenuEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public SysApiMenuEntity queryApiMenuByApiUrl(String apiUrl) {
		return this.baseMapper.queryApiMenuByApiUrl(apiUrl);
	}

	@Override
	public Integer deleteBatchByNotApiUrls(List<String> checkApis) {
		return this.baseMapper.deleteBatchByNotApiUrls(checkApis);
	}

	@Override
	public List<SysApiMenuEntity> queryApiMenuByAppId(Long appId) {
		return this.baseMapper.queryApiMenuByAppId(appId);
	}
}
