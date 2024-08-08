package com.koushik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.koushik.interceptor.RequestLogInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer{

	@Autowired
	private RequestLogInterceptor logIntercepotor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(logIntercepotor);
	}
}
