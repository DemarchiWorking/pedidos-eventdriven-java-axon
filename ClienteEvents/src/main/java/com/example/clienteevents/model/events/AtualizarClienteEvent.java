package com.example.clienteevents.model.events;

import lombok.Data;

@Data
public class AtualizarClienteEvent {
    private String clienteId;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Boolean ativo;
}
