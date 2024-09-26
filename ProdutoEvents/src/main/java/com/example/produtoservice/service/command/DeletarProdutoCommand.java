package com.example.produtoservice.service.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Builder
@Data
public class DeletarProdutoCommand {
        @TargetAggregateIdentifier
        private final String produtoId;

}
