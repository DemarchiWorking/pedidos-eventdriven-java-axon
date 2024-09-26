package com.example.produtoservice.model.events;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AtualizarProdutoEvent {

    private String produtoId;
    private String titulo;
    private BigDecimal preco;
    private Integer quantidade;

}
