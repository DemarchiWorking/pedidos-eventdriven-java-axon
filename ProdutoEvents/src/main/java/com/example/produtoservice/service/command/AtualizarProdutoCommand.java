package com.example.produtoservice.service.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Builder
@Data
public class AtualizarProdutoCommand {

        @TargetAggregateIdentifier
        private final String produtoId;
        private final String titulo;
        private final BigDecimal preco;
        private final Integer quantidade;

}
