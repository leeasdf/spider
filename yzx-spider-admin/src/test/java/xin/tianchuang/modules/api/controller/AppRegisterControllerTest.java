package xin.tianchuang.modules.api.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import xin.tianchuang.modules.BaseControllerTest;
import xin.tianchuang.modules.app.form.LoginForm;
import xin.tianchuang.modules.app.form.RegisterForm;

import com.google.gson.Gson;

public class AppRegisterControllerTest extends BaseControllerTest {

	@Test
	public void testRegister() throws Exception {
		String uri = "/app/register";
		RegisterForm form = new RegisterForm();
		form.setMobile("18627568916");
		form.setPassword("123456");
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
	public void testLogin() throws Exception {
		String uri = "/app/login";
		LoginForm form = new LoginForm();
		form.setMobile("18627568916");
		form.setPassword("123456");
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
}
