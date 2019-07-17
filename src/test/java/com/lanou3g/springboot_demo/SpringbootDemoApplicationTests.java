package com.lanou3g.springboot_demo;

import com.lanou3g.springboot_demo.bean.Student;
import com.lanou3g.springboot_demo.conf.JDBConf;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot测试Service、Dao、Mapper层代码
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

	@Autowired
	private Student student;

	@Autowired
	private JDBConf jdbConf;

	@Test
	public void testReadConf() {
		Assert.assertEquals("雲杰不是已经34了吗？", 34, student.getYunJieAge());
		Assert.assertEquals("赛赛不是已经168了吗？", 16, student.getSaisaiAge());
	}

	@Test
	public void testReadJDBCConf() {
		Assert.assertEquals("driver类不对", "com.mysql.jdbc.Driver", jdbConf.getDriver());
	}

}
