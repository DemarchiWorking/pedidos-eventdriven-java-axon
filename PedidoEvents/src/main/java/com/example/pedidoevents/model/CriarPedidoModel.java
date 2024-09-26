package com.example.pedidoevents.model;

import com.example.pedidoevents.model.Enum.PedidoStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class CriarPedidoModel {

    private String produtoId;
    private String clienteId;
    private Integer quantidade;
    private String enderecoId;
    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;
    private boolean ativo;
}
