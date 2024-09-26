package com.example.produtoservice.model.events;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
public class CriarProdutoEvent {

    private String produtoId;
    private String titulo;
    private BigDecimal preco;
    private Integer quantidade;

}
