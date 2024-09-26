package com.example.pedidoevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PedidoEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedidoEventsApplication.class, args);
    }

}
