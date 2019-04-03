package xin.tianchuang.modules.spider.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xin.tianchuang.AdminApplication;
import xin.tianchuang.modules.api.bean.v1.RptTnBasicInfoDTO;
import xin.tianchuang.modules.api.facade.tyc.TycBackgroundFacade;
import xin.tianchuang.modules.api.facade.tyc.TycFacade;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class TycFacadeTest {
	@Autowired
	private TycFacade facade;
	@Autowired
	private TycBackgroundFacade backgroundFacade;

	@Test
	public void testGetGxstBaseInfo() {
		RptTnBasicInfoDTO dto = backgroundFacade.getGxstBaseInfo("深圳市腾讯计算机系统有限公司", "");
		Assert.assertNotNull(dto);
	}

	@Test
	public void testGetStaff() {
//		List<PersonDTO> staff = backgroundFacade.getStaff("北京中景橙石科技股份有限公司", "");
//		Assert.assertNotNull(staff);
	}

}
