package com.newcomer.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:NeedAssessRef.properties")
@ConfigurationProperties("checker")
public class NeedAssessRefCheckerConfig {
	
	private List<Integer> notNull;

	public List<Integer> getNotNull() {
		return notNull;
	}

	public void setNotNull(List<Integer> notNull) {
		this.notNull = notNull;
	}
	
	
}
