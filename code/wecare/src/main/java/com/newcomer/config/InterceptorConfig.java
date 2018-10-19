package com.newcomer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.newcomer.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*")
			.excludePathPatterns("/").excludePathPatterns("/login");
	}

}
