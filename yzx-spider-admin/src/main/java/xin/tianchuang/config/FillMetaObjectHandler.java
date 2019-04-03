package xin.tianchuang.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.DataStatusEnum;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

/**
 * Created by lee on 2018/10/16. 自定义 填充字段
 */
@Component
public class FillMetaObjectHandler extends MetaObjectHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(FillMetaObjectHandler.class);

	@Override
	public void insertFill(MetaObject metaObject) {
		LOGGER.debug("insert fill");
		this.setFieldValByName("dataState", DataStatusEnum.ACTIVE.key(), metaObject);
		this.setFieldValByName("dataStatus", DataStatusEnum.ACTIVE.key(), metaObject);
		this.setFieldValByName("createTime", new Date(), metaObject);
		this.setFieldValByName("updateTime", new Date(), metaObject);
//		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
//		if (null != user) {
//			Long userId = user.getUserId();
//			this.setFieldValByName("creator", userId, metaObject);
//		} else {
//			this.setFieldValByName("creator", ConfigConstant.SYSTEM_USER, metaObject);
//		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		LOGGER.debug("update fill");
		this.setFieldValByName("updateTime", new Date(), metaObject);
//		SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
//		if (null != user) {
//			Long userId = user.getUserId();
//			this.setFieldValByName("updater", userId, metaObject);
//		} else {
//			this.setFieldValByName("updater", ConfigConstant.SYSTEM_USER, metaObject);
//		}
	}

}