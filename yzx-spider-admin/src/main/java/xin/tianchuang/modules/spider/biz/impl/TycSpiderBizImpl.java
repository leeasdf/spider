package xin.tianchuang.modules.spider.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xin.tianchuang.common.component.tcredit.TcreditApiTool;
import xin.tianchuang.common.constant.PageConstant;
import xin.tianchuang.common.enums.DataSourceEnum;
import xin.tianchuang.common.enums.TysDataStateEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.modules.spider.bean.tyc.dto.ListResultsDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.SimpleBackgroundResultDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataRespDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiDataResultRespDTO;
import xin.tianchuang.modules.spider.bean.tyc.result.TycApiRespDTO;
import xin.tianchuang.modules.spider.biz.TycBackgroundBiz;
import xin.tianchuang.modules.spider.biz.TycCompanyGrowthBiz;
import xin.tianchuang.modules.spider.biz.TycKnowledgePropertyBiz;
import xin.tianchuang.modules.spider.biz.TycLawDangerBiz;
import xin.tianchuang.modules.spider.biz.TycManageDangerousBiz;
import xin.tianchuang.modules.spider.biz.TycManageStatusBiz;
import xin.tianchuang.modules.spider.biz.TycSpiderBiz;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;
import xin.tianchuang.modules.spider.service.HighTechZoneEnterpriseInfoService;

import com.alibaba.fastjson.JSONObject;

@Service
public class TycSpiderBizImpl implements TycSpiderBiz {
	private static final Logger logger = LoggerFactory.getLogger(TycSpiderBiz.class);

	@Autowired
	private TycBackgroundBiz tycBackgroundBiz;
	@Autowired
	private TycKnowledgePropertyBiz tycKnowledgePropertyBiz;
	@Autowired
	private TycLawDangerBiz tycLawDangerBiz;
	@Autowired
	private TycManageStatusBiz tycManageStatusBiz;
	@Autowired
	private TycManageDangerousBiz tycManageDangerousBiz;
	@Autowired
	private TycCompanyGrowthBiz tycCompanyGrowthBiz;
	@Autowired
	private HighTechZoneEnterpriseInfoService highTechZoneEnterpriseInfoService;

	@Autowired
	private TcreditApiTool properties;

	@Override
	public boolean getTycSpiderEnterpriseListData(Integer fetch, Integer status, String province, String city, String remark, Boolean isAsc) {
		fetch = fetch <= 0 ? PageConstant.PAGE_FETCH : fetch;
		status = status < 0 ? 0 : status; // 正常状态

		List<HighTechZoneEnterpriseInfoEntity> enterpriseInfoLs = highTechZoneEnterpriseInfoService.querEnterpriseListByCondition(fetch, status, province, city, remark, isAsc);
		if (null == enterpriseInfoLs || enterpriseInfoLs.size() <= 0) {
			logger.info("无可爬取的状态为[{}]企业信息数据", status);
			return false;
		}
		return spiderEnterpriseListData(enterpriseInfoLs);
	}

	@Override
	public boolean getTycSpiderEnterpriseDataByCreditCode(String creditCode) {
		HighTechZoneEnterpriseInfoEntity entity = highTechZoneEnterpriseInfoService.selectByNameCode(null, creditCode);
		List<HighTechZoneEnterpriseInfoEntity> enterpriseInfoLs = new ArrayList<HighTechZoneEnterpriseInfoEntity>();
		enterpriseInfoLs.add(entity);
		return spiderEnterpriseListData(enterpriseInfoLs);
	}

	@Override
	public boolean getTycSpiderEnterpriseDataByName(String enterpriseName) {
		HighTechZoneEnterpriseInfoEntity entity = highTechZoneEnterpriseInfoService.selectByEnterpriseName(enterpriseName);
		List<HighTechZoneEnterpriseInfoEntity> enterpriseInfoLs = new ArrayList<HighTechZoneEnterpriseInfoEntity>();
		enterpriseInfoLs.add(entity);
		return spiderEnterpriseListData(enterpriseInfoLs);
	}

	@Override
	public boolean spiderEnterpriseData(HighTechZoneEnterpriseInfoEntity entity) {
		List<HighTechZoneEnterpriseInfoEntity> enterpriseInfoLs = new ArrayList<HighTechZoneEnterpriseInfoEntity>();
		enterpriseInfoLs.add(entity);
		return spiderEnterpriseListData(enterpriseInfoLs);
	}

	public boolean spiderEnterpriseListData(List<HighTechZoneEnterpriseInfoEntity> enterpriseInfoLs) {
		for (HighTechZoneEnterpriseInfoEntity dto : enterpriseInfoLs) {
			String enterpriseName = dto.getEnterpriseName();
			String creditCode = dto.getCreditCode();
			try {
				String key = "";
				if (StringUtils.isNotBlank(creditCode)) {
					key = creditCode;
				} else {
					key = enterpriseName;
				}
				String apiData = retryRequestApi(key);
				parseData(dto, apiData);
			} catch (SpiderException e) {
				logger.error("解析异常", e);
				continue;
			} catch (Exception e) {
				logger.error("解析异常", e);
				continue;
			}
		}

		return true;
	}

	@Override
	public void parseData(HighTechZoneEnterpriseInfoEntity dto, String apiData) {
		logger.info("企业信息数据 response：{}", apiData);
		if (StringUtils.isEmpty(apiData)) {
			throw new SpiderException("接口异常，API数据返回为空");
		}

		TycApiRespDTO dtos = JSONObject.parseObject(apiData, TycApiRespDTO.class);
		if (dtos == null) { // 成功
			throw new SpiderException("数据返回为空");
		}

		String status = dtos.getStatus();
		String uuid = dtos.getUuid();
		String message = dtos.getMessage();
		if (!"0".equals(status)) { // 成功
			logger.error("[{}]状态为未成功状态:{}-->{}", uuid, status, message);
			if ("10".equals(status)) { // 系统繁忙，请稍后再试
				throw new SpiderException("系统繁忙，请稍后再试");
			} else { // 其他
				// 超出当天使用次数,请明天再试，系统异常等
				// 502 查找可用代理失败
				throw new SpiderException("系统异常，请稍后再试");
			}
		}
		TycApiDataRespDTO data = dtos.getData();
		if (null == data) {
			throw new SpiderException("data节点数据返回为空");
		}

		String spiderCode = data.getCode();
		String spiderMsg = data.getMsg();

		if (!"200".equals(spiderCode)) {
			logger.error("爬虫返回码为非成功状态,[{}][{}]", spiderCode, spiderMsg);
			if ("404".equals(spiderCode)) { // 没发现公司
				updateEnterpriseByStatus(dto, TysDataStateEnum.NOT_FOUND.key());
			} else if ("500".equals(spiderCode)) { // 爬取异常
				updateEnterpriseByStatus(dto, TysDataStateEnum.ERROR.key());
			} else if ("502".equals(spiderCode)) { // 查找可用代理失败
				throw new SpiderException("查找可用代理失败");
			}
			throw new SpiderException("返回非成功状态");
		}

		TycApiDataResultRespDTO result = data.getResult();
		if (null == result && "0".equals(spiderCode)) {
			logger.error("爬虫结果成功，{}{}", spiderCode, spiderMsg);
			throw new SpiderException("爬取成功，未抓取到数据");
		}
		// 存储数据
		saveData(dto, result);
	}

	private String retryRequestApi(String name) {
		try {
			return properties.getTycEnterpriseInfo(name);
		} catch (Exception e) {
			logger.error("调用天眼查API接口失败", e);
			throw new SpiderException("调用天眼查API接口失败", 990001);
		}
	}

	private void updateEnterpriseByStatus(HighTechZoneEnterpriseInfoEntity dto, int status) {
		dto.setDataState(status);
		highTechZoneEnterpriseInfoService.updateById(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	private void saveData(HighTechZoneEnterpriseInfoEntity param, TycApiDataResultRespDTO result) {
		logger.info("[{}]事物开启",param.getEnterpriseName());
		HighTechZoneEnterpriseInfoEntity entity = saveListData(result, param);
		Long enterpriseId = entity.getId();
		String enterpriseName = entity.getEnterpriseName();
		// --->公司发展
		tycBackgroundBiz.saveData(enterpriseId, enterpriseName, result);

		// --->司法风险
		tycLawDangerBiz.saveData(enterpriseId, enterpriseName, result);
		// --->经营风险
		tycManageDangerousBiz.saveData(enterpriseId, enterpriseName, result);
		// ---> 公司发展
		tycCompanyGrowthBiz.saveData(enterpriseId, enterpriseName, result);
		// --->经营状况
		tycManageStatusBiz.saveData(enterpriseId, enterpriseName, result);
		// --->知识产权
		tycKnowledgePropertyBiz.saveData(enterpriseId, enterpriseName, result);

	}

	/**
	 * TODO 存储列表数据 增加版本号来控制
	 * 
	 * @param result
	 * @param name
	 */
	private HighTechZoneEnterpriseInfoEntity saveListData(TycApiDataResultRespDTO result, HighTechZoneEnterpriseInfoEntity oldEntity) {

		// 存储基本列表信息
		List<ListResultsDTO> listResults = result.getListResults();
		if (null == listResults || listResults.size() <= 0) {
			logger.error("天眼查列表信息为空");
			throw new SpiderException("天眼查列表信息为空", 990002);
		}

		HighTechZoneEnterpriseInfoEntity resultEntity = null;
		for (ListResultsDTO listResultDTO : listResults) {
			Boolean renameFlag = listResultDTO.getRenameFlag(); // 是否更名
			if (null != renameFlag && renameFlag) { // 更名企业
				HighTechZoneEnterpriseInfoEntity entity = highTechZoneEnterpriseInfoService.selectByEnterpriseName(listResultDTO.getNewName());
				// 如果不存在，则新增
				if (null == entity) {
					// 新增新企业
					HighTechZoneEnterpriseInfoEntity newDto = new HighTechZoneEnterpriseInfoEntity();
					BeanUtils.copyProperties(oldEntity, newDto);
					newDto.setId(null); // 移除就有old属性id
					newDto.setEnterpriseName(listResultDTO.getNewName());
					newDto.setOldEnterpriseId(oldEntity.getId());
					newDto.setOldName(oldEntity.getOldName());
					newDto.setDataState(TysDataStateEnum.FINISH.key()); // 等待采集
					newDto.setDataSource(DataSourceEnum.TYC.key());
					boolean insertFlag = highTechZoneEnterpriseInfoService.insert(newDto);

					// 查找新名称，数据库中是否已经存在
					entity = highTechZoneEnterpriseInfoService.selectByEnterpriseName(listResultDTO.getOldName());
					BeanUtils.copyProperties(listResultDTO, entity);
					// 先更新旧有企业信息
					oldEntity.setNewName(listResultDTO.getEnterpriseName());
					oldEntity.setDataState(TysDataStateEnum.FINISH.key());
					oldEntity.setNewEnterpriseId(newDto.getId());
					highTechZoneEnterpriseInfoService.updateById(oldEntity);

					resultEntity = entity;
					continue;
				}
			} else { // 未更名
				// 1、企业名称相同为查找信息
				if (listResultDTO.getEnterpriseName().equals(oldEntity.getEnterpriseName())
						&& !("香港".equals(listResultDTO.getProvince()) || "台湾".equals(listResultDTO.getProvince()) || "澳门".equals(listResultDTO.getProvince()))) {
					SimpleBackgroundResultDTO simpleBackground = result.getSimpleBackground();
					BeanUtils.copyProperties(simpleBackground, oldEntity);

					List<String> historyList = simpleBackground.getHistoryList();
					if (null != historyList && historyList.size() >= 1) {
						oldEntity.setHistoryList(StringUtils.join(historyList, ","));
					}
					// 判断电话号码、邮箱地址是否进行了加密处理，如果进行了加密处理，则不允许覆盖原有值，重新赋值回来
					if (StringUtils.isNotBlank(simpleBackground.getPhones()) && !simpleBackground.getPhones().contains("*")) {
						oldEntity.setPhones(simpleBackground.getPhones());
					}

					if (StringUtils.isNotBlank(simpleBackground.getEmail()) && !simpleBackground.getEmail().contains("*")) {
						oldEntity.setEmail(simpleBackground.getEmail());
					}

					oldEntity.setRegTime(listResultDTO.getRegTime());
					oldEntity.setWebSite(simpleBackground.getWebsite());

					BeanUtils.copyProperties(listResultDTO, oldEntity);
					oldEntity.setProvince(listResultDTO.getProvince());
					oldEntity.setTycEnterpriseid(listResultDTO.getTycEnterpriseId());
					oldEntity.setRegCap(listResultDTO.getRegCap());
					oldEntity.setLegalPersonName(listResultDTO.getLegalPersonName());
					oldEntity.setStatus(listResultDTO.getStatus());
					oldEntity.setDataState(TysDataStateEnum.FINISH.key());
					oldEntity.setDataSource(DataSourceEnum.TYC.key());

					highTechZoneEnterpriseInfoService.updateById(oldEntity);

					resultEntity = oldEntity;
					continue;
				} else {
					// 2、 判断其他企业名称是否已经入库
					HighTechZoneEnterpriseInfoEntity entity = highTechZoneEnterpriseInfoService.selectByEnterpriseName(listResultDTO.getEnterpriseName());
					if (null == entity) {
						// 新增新企业
						HighTechZoneEnterpriseInfoEntity target = new HighTechZoneEnterpriseInfoEntity();
						BeanUtils.copyProperties(listResultDTO, target);
						target.setDataState(TysDataStateEnum.WAIT.key()); // 等待采集
						target.setDataSource(DataSourceEnum.TYC.key());
						highTechZoneEnterpriseInfoService.insert(target);
					}

				}
			}
		}

		if (resultEntity == null) {
			return oldEntity;
		}
		return resultEntity;
	}

	// public void initPersonBusRoleInfo(Integer enterpriseId, String name, String data) {
	// try {
	// if (StringUtils.isBlank(data)) {
	// logger.error("商业角色为空");
	// return;
	// }

	// List<RptTnBusRole> dtos = JSONObject.parseArray(data, RptTnBusRole.class);
	// if (dtos != null && dtos.size() > 0) {
	// for (RptTnBusRole dto : dtos) {
	// dto.setEntName(name);
	// dto.setUpdateTime(new Date());
	// dto.setDataState(1);
	// dto.setCreateTime(new Date());
	// // TODO 插入管管姓名
	// rptTnBusRoleMapper.insert(dto);
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error("报文-商业角色息插入失败", e);
	// }
	// }

	// private void initWorksRightAuthorInfo(String name, RptTnWorksRightAuthor dto) {
	// try {
	//
	// // if (dtos != null && dtos.size() > 0) {
	// // for (RptTnWorksRightAuthor dto : dtos) {
	// dto.setEntName(name);
	// dto.setUpdateTime(new Date());
	// dto.setDataState(1);
	// dto.setCreateTime(new Date());
	// rptTnWorksRightAuthorMapper.insert(dto);
	// // }
	// // }
	// } catch (Exception e) {
	// LOGGER.error("企业著作⼈详情信息异常", e);
	// }
	// }

}
