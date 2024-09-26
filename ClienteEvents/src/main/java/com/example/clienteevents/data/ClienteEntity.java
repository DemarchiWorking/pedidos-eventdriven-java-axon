package com.example.clienteevents.data;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name ="pedidos")
@Data
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID = -22726495080660124L;
    @Id
    @Column(unique = true)
    private String clienteId;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Boolean ativo;
}
