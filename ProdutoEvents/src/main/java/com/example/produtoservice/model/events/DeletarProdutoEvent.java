package com.example.produtoservice.model.events;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeletarProdutoEvent {
    private String produtoId;

}
