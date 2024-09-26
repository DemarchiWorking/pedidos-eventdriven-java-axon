package com.example.clienteevents.service.aggregate;

import com.example.clienteevents.model.events.AtualizarClienteEvent;
import com.example.clienteevents.model.events.CriarClienteEvent;
import com.example.clienteevents.service.command.AtualizarClienteCommand;
import com.example.clienteevents.service.command.CriarClienteCommand;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ClienteAggregate {

    @AggregateIdentifier
    private String clienteId;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Boolean ativo;

    public ClienteAggregate(){

    }
    @CommandHandler
    public ClienteAggregate(CriarClienteCommand criarClienteCommand){
        if(criarClienteCommand.getEmail() == ""){
            throw new IllegalArgumentException("Digite um email");
        }
        if(criarClienteCommand.getSenha() == ""){
            throw new IllegalArgumentException("Digite uma senha.");
        }

        CriarClienteEvent criarClienteEvent = new CriarClienteEvent();
        BeanUtils.copyProperties(criarClienteCommand, criarClienteEvent);
        AggregateLifecycle.apply(criarClienteEvent);
    }
    @EventSourcingHandler
    public void on(CriarClienteEvent criarClienteEvent){
        this.clienteId = criarClienteEvent.getClienteId();
        this.nome = criarClienteEvent.getNome();
        this.email = criarClienteEvent.getEmail();
        this.telefone = criarClienteEvent.getTelefone();
        this.senha = criarClienteEvent.getSenha();
        this.ativo = criarClienteEvent.getAtivo();
    }

    @CommandHandler
    public void handle(AtualizarClienteCommand atualizarClienteCommand) {

        AtualizarClienteEvent atualizarClienteEvent = new AtualizarClienteEvent();
        BeanUtils.copyProperties(atualizarClienteCommand, atualizarClienteEvent);
        AggregateLifecycle.apply(atualizarClienteEvent);
    }
    @EventSourcingHandler
    public void on(AtualizarClienteEvent atualizarClienteEvent){
        this.clienteId = atualizarClienteEvent.getClienteId();
        this.nome = atualizarClienteEvent.getNome();
        this.email = atualizarClienteEvent.getEmail();
        this.telefone = atualizarClienteEvent.getTelefone();
        this.senha = atualizarClienteEvent.getSenha();
        this.ativo = atualizarClienteEvent.getAtivo();
    }
}
