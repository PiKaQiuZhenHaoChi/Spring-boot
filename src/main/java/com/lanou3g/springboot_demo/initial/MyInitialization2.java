package com.lanou3g.springboot_demo.initial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 该类可用于SpringBoot应用启动后提前做一些初始化操作，比如缓存数据
 */
@Slf4j
@Component
public class MyInitialization2 implements ApplicationRunner {

	// ApplicationArguments 参数获取形如：--name=zhangsan --gender=nan 格式的命令行参数
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("应用启动了，我准备初始化数据了");
		for(String argKey : args.getOptionNames()) {
			log.info("参数key: " + argKey+"，参数值：" + args.getOptionValues(argKey));
		}
	}
}
