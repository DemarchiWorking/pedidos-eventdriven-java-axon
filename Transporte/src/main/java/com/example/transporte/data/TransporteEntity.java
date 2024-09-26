package com.example.transporte.data;

import com.example.transporte.model.Enum.PedidoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

public class TransporteEntity {
    private static final long serialVersionUID = -22726495080660124L;
    @Id
    @Column(unique = true)
    private String transporteId;
    private String pedidoId;
    private String produtoId;
    private String clienteId;
    private Integer quantidade;
    private String enderecoId;
    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;
    private Boolean ativo;
}
