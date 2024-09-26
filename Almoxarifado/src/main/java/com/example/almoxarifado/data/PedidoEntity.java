package com.example.almoxarifado.data;

import com.example.almoxarifado.model.PedidoStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name ="pedidos")
@Data
public class PedidoEntity implements Serializable {
    private static final long serialVersionUID = -22726495080660124L;
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

