package com.lanou3g.springboot_demo.initial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 该类可用于SpringBoot应用启动后提前做一些初始化操作，比如缓存数据
 */
@Slf4j
@Component
public class MyInitialization implements CommandLineRunner {

	// args 可以获取启动应用时通过命令行传进来的参数
	@Override
	public void run(String... args) throws Exception {
		log.info("应用启动了，我准备初始化数据了");
		for(String arg : args) {
			log.info("arg: " + arg);
		}
	}
}
