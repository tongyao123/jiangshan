package com.example.jiangshan.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class A {
    private A(){}
	public static ConfigurableApplicationContext run(Class<?> cls, String... args) {
		ConfigurableApplicationContext context = SpringApplication.run(cls,args);
		context.publishEvent(new ServiceReadyEvent(context));
		return context;
	}

}
