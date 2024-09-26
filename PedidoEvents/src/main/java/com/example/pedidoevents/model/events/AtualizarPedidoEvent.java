package com.example.pedidoevents.model.events;

import com.example.pedidoevents.model.Enum.PedidoStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AtualizarPedidoEvent {
    private String produtoId;
    private String clienteId;
    private Integer quantidade;
    private String pedidoId;
    private String enderecoId;
    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;
    private Boolean ativo;
}
