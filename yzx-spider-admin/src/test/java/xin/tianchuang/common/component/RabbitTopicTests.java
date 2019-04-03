package xin.tianchuang.common.component;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xin.tianchuang.AdminApplication;
import xin.tianchuang.common.component.rabbit.Sender;

// https://www.jianshu.com/p/e1258c004314
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class RabbitTopicTests {

	@Autowired
	private Sender sender;

	@Test
	public void sendTest() throws Exception {
		while (true) {
			String msg = new Date().toString();
			sender.send("key.1", "测试消息" + msg);
			Thread.sleep(30 * 1000);
		}
	}
}