package com.lanou3g.springboot_demo.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 通过类型安全方式直接将读取到的属性封装到POJO类上
 * 省去了在每个属性上写@Value注解
 * 适用于属性比较多，都以指定前缀开始的属性读取
 */
@Component
@Getter
@Setter
@PropertySource("classpath:jdbc.properties")
@ConfigurationProperties(prefix = "jdbc")
public class JDBConf {
	private String url;
	private String driver;
	private String user;
	private String password;
}
