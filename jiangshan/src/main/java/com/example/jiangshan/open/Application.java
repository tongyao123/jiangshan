package com.example.jiangshan.open;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.jiangshan.config.A;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        A.run(Application.class, args);
    }
}