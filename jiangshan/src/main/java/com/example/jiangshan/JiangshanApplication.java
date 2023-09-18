package com.example.jiangshan;

import com.example.jiangshan.config.ServiceReadyEvent;
import com.example.jiangshan.open.Application;
import com.example.jiangshan.config.A;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//(scanBasePackages = {"com.example.jiangshan.mapper.domain","com.example.jiangshan.client","com.example.jiangshan.mapper.domain"})
//@ComponentScan(basePackages = "com.example.jiangshan.service.domain")
public class JiangshanApplication {

	public static void main(String[] args) {
		//A.run(JiangshanApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(JiangshanApplication.class, args);
		context.publishEvent(new ServiceReadyEvent(context));
	}

}
