package com.jsc.javageeks.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jsc.javageeks.interceptor.LoggingInterceptor;
import com.jsc.javageeks.interceptor.SecurityInterceptor;

/*providing the component-scanning and annotation support*/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jsc.javageeks")
public class LoggingTmplConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SecurityInterceptor());
		registry.addInterceptor(new LoggingInterceptor());
	}
}
