package com.ddubson.poc.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	//@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/index").setViewName("index");
		//registry.addViewController("/").setViewName("index");
		//registry.addViewController("/login").setViewName("login");
		//registry.addViewController("/403").setViewName("403");
	}

	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		//resolver.setViewClass(JstlView.class);
		return resolver;
	}*/
}
