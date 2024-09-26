package com.example.clienteevents.model;

import lombok.Data;

@Data
public class CriarClienteModel {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Boolean ativo;
}
