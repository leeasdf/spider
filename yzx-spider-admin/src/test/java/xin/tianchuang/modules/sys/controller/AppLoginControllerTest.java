package xin.tianchuang.modules.sys.controller;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import xin.tianchuang.modules.BaseControllerTest;
import xin.tianchuang.modules.app.entity.UserEntity;
import xin.tianchuang.modules.app.form.LoginForm;
import xin.tianchuang.modules.app.service.UserService;

import com.baomidou.mybatisplus.plugins.Page;
import com.google.gson.Gson;

public class AppLoginControllerTest extends BaseControllerTest {

	@Autowired
	private UserService userService;

	@Test
	public void testLogin() throws Exception {
		String uri = "/app/login";
		LoginForm form = new LoginForm();
		form.setPassword("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918");
		form.setMobile("13612345678");
		ResultActions perform = mvc.perform(MockMvcRequestBuilders.post(uri) //
				.contentType(MediaType.APPLICATION_JSON_UTF8) //
				.content(new Gson().toJson(form)) // 请求实体
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

	@Test
	public void testPage() throws Exception {
		Page<UserEntity> page = new Page<UserEntity>(0, 3);
		Integer state = 1;
		List<UserEntity> list = userService.selectUserPage(page, state);
		Assert.assertNotEquals("should have page info", 0, page.getTotal());
		Assert.assertEquals(3, list.size());
	}
}
