package com.example.produtoservice.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProdutoModel {
    private String produtoId;
    private String titulo;
    private BigDecimal preco;
    private Integer quantidade;

}
