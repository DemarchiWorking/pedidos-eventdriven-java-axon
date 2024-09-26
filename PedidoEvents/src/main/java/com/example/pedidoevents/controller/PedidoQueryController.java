package com.example.pedidoevents.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PedidoQueryController {
    @GetMapping
    public String obterPedido(){
        return "test";
    }
}
