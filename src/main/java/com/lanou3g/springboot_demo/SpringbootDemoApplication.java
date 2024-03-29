package com.lanou3g.springboot_demo;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// Springboot中启动类上的@ComponentScan注解默认扫描当前包及子包中的类
// 如果其他包中没有需要扫描的类，可以不写
//@ComponentScan("com.lanou3g")
public class SpringbootDemoApplication extends SpringBootServletInitializer {

	// 将我们的SpringbootDemoApplication与原生Servlet容器(如：Tomcat)初始化流程挂上钩，
	// 这样我们如果是打成war包放到外部Servlet容器中运行，就可以正常启动工程
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringbootDemoApplication.class);
	}

	/**
	 * SpringBoot 2.1版本设置Tomcat上传文件大小上限参数
	 */
	/*@Bean
	public TomcatServletWebServerFactory tomcatEmbedded() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
				//-1 means unlimited
				((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
			}
		});
		return tomcat;
	}*/

	/**
	 * SpringBoot 1.5版本设置Tomcat上传文件大小上限参数
	 * @return
	 */
	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
		TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
		tomcatFactory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
				//-1 means unlimited
				((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
			}
		});
		return tomcatFactory;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
