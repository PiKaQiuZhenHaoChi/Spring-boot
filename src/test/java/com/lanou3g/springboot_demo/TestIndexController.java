package com.lanou3g.springboot_demo;

import com.lanou3g.springboot_demo.web.IndexController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *  SpringBoot mock测试Controller层代码
 */
@WebMvcTest(IndexController.class)
@RunWith(SpringRunner.class)
public class TestIndexController {


	@Autowired
	private MockMvc mock;

	@Test
	public void testIndexController() throws Exception {
		mock.perform(get("http://localhost:8081/")).andExpect(status().isOk())
				.andExpect(content().string(containsString("ityouknow")));
	}

}
