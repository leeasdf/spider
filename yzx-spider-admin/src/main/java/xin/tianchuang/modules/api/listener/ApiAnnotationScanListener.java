package xin.tianchuang.modules.api.listener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.RedisUtils;
import xin.tianchuang.modules.api.annotation.ApiToken;
import xin.tianchuang.modules.api.entity.SysApiMenuEntity;
import xin.tianchuang.modules.api.service.SysApiMenuService;

@Component
@Configuration
public class ApiAnnotationScanListener implements ApplicationContextAware {

	private final static Logger logger = LoggerFactory.getLogger(ApiAnnotationScanListener.class);

	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private SysApiMenuService sysApiMenuService;

	/** 存放需要权限拦截的接口uri */
	public static List<String> checkApis = new ArrayList<>();

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {

		logger.info(" the api manager url is begin");
		Map<String, Object> beans = ctx.getBeansWithAnnotation(RestController.class);// 获取全部ControllerBean
		if (null == beans) {
			logger.warn("无RestController注解的controller类");
			return;
		}
		Set<Map.Entry<String, Object>> entries = beans.entrySet();// 遍历Bean
		Iterator<Map.Entry<String, Object>> iterator = entries.iterator();

		SysApiMenuEntity entity;
		List<SysApiMenuEntity> insertEntityList = new ArrayList<>();
		List<SysApiMenuEntity> updateEntityList = new ArrayList<>();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> map = iterator.next();
			Class<?> clz = map.getValue().getClass();
			Method[] methods = clz.getMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(ApiToken.class)) {// 有无权限注解
					ApiToken annotation = method.getAnnotation(ApiToken.class);
					String apiUrl = getApiUri(clz, method);
					entity = sysApiMenuService.queryApiMenuByApiUrl(apiUrl);
					if (null == entity) {
						entity = new SysApiMenuEntity();
						entity.setApiUrl(apiUrl);
						entity.setApiDesc(annotation.desc());
						entity.setStatus(DataStatusEnum.UN_ACTIVE.key());
						insertEntityList.add(entity);
					} else {
						entity.setApiDesc(annotation.desc());
						updateEntityList.add(entity);
					}
					checkApis.add(apiUrl);// 遍历权限点，放入集合中
				}
			}
		}
		// 更新或者插入
		if (null != insertEntityList && insertEntityList.size() >= 1) {
			sysApiMenuService.insertBatch(insertEntityList);
		}

		if (null != updateEntityList && updateEntityList.size() >= 1) {
			sysApiMenuService.updateBatchById(updateEntityList);
		}
		// 删除非权限集合url
		sysApiMenuService.deleteBatchByNotApiUrls(checkApis);

		logger.info(" the api manager url is end");
	}

	private String getApiUri(Class<?> clz, Method method) {
		StringBuilder uri = new StringBuilder();
		uri.append(clz.getAnnotation(RequestMapping.class).value()[0]);
		if (method.isAnnotationPresent(GetMapping.class)) {
			uri.append(method.getAnnotation(GetMapping.class).value()[0]);
		} else if (method.isAnnotationPresent(PostMapping.class)) {
			uri.append(method.getAnnotation(PostMapping.class).value()[0]);
		} else if (method.isAnnotationPresent(RequestMapping.class)) {
			uri.append(method.getAnnotation(RequestMapping.class).value()[0]);
		} else if (method.isAnnotationPresent(DeleteMapping.class)) {
			uri.append(method.getAnnotation(DeleteMapping.class).value()[0]);
		} else if (method.isAnnotationPresent(DeleteMapping.class)) {
			uri.append(method.getAnnotation(DeleteMapping.class).value()[0]);
		} else if (method.isAnnotationPresent(PatchMapping.class)) {
			uri.append(method.getAnnotation(PatchMapping.class).value()[0]);
		} else if (method.isAnnotationPresent(PutMapping.class)) {
			uri.append(method.getAnnotation(PutMapping.class).value()[0]);
		}
		return uri.toString();
	}
}
