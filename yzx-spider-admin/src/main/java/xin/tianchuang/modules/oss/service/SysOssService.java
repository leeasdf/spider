
package xin.tianchuang.modules.oss.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.oss.entity.SysOssEntity;

/**
 * 文件上传
 * 
 * @author hui.deng
 * 
 * @date 2017-03-25 12:13:26
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
