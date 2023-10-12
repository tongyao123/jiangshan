package com.example.jiangshan;

import com.example.jiangshan.config.ServiceReadyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication//(scanBasePackages = {"com.example.jiangshan.mapper.domain","com.example.jiangshan.client","com.example.jiangshan.mapper.domain"})
//@ComponentScan(basePackages = "com.example.jiangshan.service.domain")
public class JiangshanApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JiangshanApplication.class, args);
		//context.publishEvent(new ServiceReadyEvent(context));
	}

}
