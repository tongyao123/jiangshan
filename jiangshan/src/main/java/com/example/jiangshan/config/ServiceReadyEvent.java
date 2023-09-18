package com.example.jiangshan.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class ServiceReadyEvent extends ApplicationEvent{
    private static final long serialVersionUID = -72803256455379683L;
	private transient ConfigurableApplicationContext context;

	public ServiceReadyEvent(ConfigurableApplicationContext context) {
		super("服务启动成功");
		this.context = context;
	}

	public ConfigurableApplicationContext getContext() {
		return context;
	}

}