package com.example.produtoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProdutoEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutoEventsApplication.class, args);
    }

}
