
package xin.tianchuang.modules.oss.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.oss.dao.SysOssDao;
import xin.tianchuang.modules.oss.entity.SysOssEntity;
import xin.tianchuang.modules.oss.service.SysOssService;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<SysOssEntity> page = this.selectPage(
				new Query<SysOssEntity>(params).getPage()
		);

		return new PageUtils(page);
	}
	
}
