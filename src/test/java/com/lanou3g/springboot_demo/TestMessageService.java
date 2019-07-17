package com.lanou3g.springboot_demo;


import com.lanou3g.springboot_demo.service.MessageService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 测试Service层代码，这里咱们直接将SpringBoot单元测试配置抽出来一个父类
 * 需要些单元测试时直接继承父类就行了，不需要每个类上都写SpringBoot测试相关注解
 */
public class TestMessageService extends BaseSpringBootTest{

	@Autowired
	private MessageService ms;

	@Test
	public void testQueryMessage() {
		List<Map<String, Object>> datas = ms.selectAllMessage();
		Assert.assertEquals("应该是57条才对", 57, datas.size());
	}
}
