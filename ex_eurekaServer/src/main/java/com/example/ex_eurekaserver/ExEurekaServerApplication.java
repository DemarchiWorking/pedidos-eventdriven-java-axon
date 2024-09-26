package com.example.ex_eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ExEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExEurekaServerApplication.class, args);
    }

}
