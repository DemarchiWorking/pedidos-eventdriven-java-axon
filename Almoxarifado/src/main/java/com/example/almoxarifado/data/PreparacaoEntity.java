package com.example.almoxarifado.data;

import com.example.almoxarifado.model.PedidoStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="preparacao")
@Data
public class PreparacaoEntity {
    @Id
    @Column(unique = true)
    private String pedidoId;
    private String produtoId;
    private String clienteId;
    private Integer quantidade;
    private String enderecoId;
    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;
    private Boolean ativo;
}
