package com.example.itokenserviceadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.itokenserviceadmin.mapper")
public class ItokenServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItokenServiceAdminApplication.class, args);
    }

}
