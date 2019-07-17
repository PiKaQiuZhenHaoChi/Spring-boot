package com.lanou3g.springboot_demo.bean;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取application.properties中的自定义属性
 */
@Getter
@Component
public class Student {
	@Value("${com.lanou.yanfa4.yunjie}")
	private int yunJieAge;
	@Value("${com.lanou.yanfa4.jinsaisai}")
	private int saisaiAge;

}
