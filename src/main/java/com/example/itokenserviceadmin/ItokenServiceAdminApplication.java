package com.example.itokenserviceadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.itokenserviceadmin.mapper")
public class ItokenServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServiceAdminApplication.class, args);
    }

}
