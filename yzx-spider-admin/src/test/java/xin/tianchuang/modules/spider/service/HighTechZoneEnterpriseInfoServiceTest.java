package xin.tianchuang.modules.spider.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.BaseServiceTest;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;

public class HighTechZoneEnterpriseInfoServiceTest extends BaseServiceTest {

	@Autowired
	private HighTechZoneEnterpriseInfoService highTechZoneEnterpriseInfoService;

	@Test
	public void queryPageTest() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("enterpriseName", "腾讯");

		highTechZoneEnterpriseInfoService.queryPage(params);
	}

	@Test
	public void batchTest() {

		List<HighTechZoneEnterpriseInfoEntity> entityList = new ArrayList<HighTechZoneEnterpriseInfoEntity>();
		HighTechZoneEnterpriseInfoEntity e = new HighTechZoneEnterpriseInfoEntity();
		
		highTechZoneEnterpriseInfoService.insertBatch(entityList);
	}
}
