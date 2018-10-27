package com.newcomer.fileprocessor.loader;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LoaderContext implements ApplicationContextAware {

	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context= applicationContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return context;
	}

}
