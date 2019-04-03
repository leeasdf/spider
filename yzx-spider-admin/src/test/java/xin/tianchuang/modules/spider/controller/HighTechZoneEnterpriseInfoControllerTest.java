package xin.tianchuang.modules.spider.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import xin.tianchuang.modules.BaseControllerTest;

public class HighTechZoneEnterpriseInfoControllerTest extends BaseControllerTest {

	@Test
	public void testLogin() throws Exception {
		String uri = "/spider/hightechzoneenterpriseinfo/list/match";
		ResultActions perform = mvc.perform(MockMvcRequestBuilders.get(uri) //
				.param("key", "腾讯") //
				.contentType(MediaType.APPLICATION_JSON_UTF8) //
				.accept(MediaType.APPLICATION_JSON) // 断言返回结果是json
				);
		// 得到返回结果
		// MvcResult mvcResult = perform.andReturn();
		// 拿到请求返回码
		// MockHttpServletResponse response = mvcResult.getResponse();
		// 拿到结果
		// String result = response.getContentAsString();
		perform.andExpect(MockMvcResultMatchers.status().isOk()) //
				.andDo(MockMvcResultHandlers.print()) //
				.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("success")) //
				);
	}

}
