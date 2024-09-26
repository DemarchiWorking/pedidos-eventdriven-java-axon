package com.example.clienteevents.service.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CriarClienteCommand
{
    @TargetAggregateIdentifier
    private final String clienteId;
    private final String nome;
    private final String email;
    private final String senha;
    private final String telefone;
    private final Boolean ativo;
}
