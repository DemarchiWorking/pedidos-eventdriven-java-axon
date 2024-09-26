package com.example.pedidoevents.service.command;

import com.example.pedidoevents.model.Enum.PedidoStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Builder
@Data
public class AtualizarPedidoCommand {
    @TargetAggregateIdentifier
    private final String pedidoId;
    private final String produtoId;
    private final String clienteId;
    private final Integer quantidade;
    private final String enderecoId;
    @Enumerated(EnumType.STRING)
    private final PedidoStatus pedidoStatus;
    private final boolean ativo;

}
