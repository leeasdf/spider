package xin.tianchuang.modules.spider.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.BaseServiceTest;

public class RptTnBasicInfoServiceTest extends BaseServiceTest {

	@Autowired
	private RptTnBasicInfoService rptTnBasicInfoService;

	@Test
	public void selectCountByEnterpriseIdTest() {
		rptTnBasicInfoService.selectCountByEnterpriseId(24962L);
	}
}
