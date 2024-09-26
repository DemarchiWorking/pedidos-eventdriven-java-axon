package com.example.pedidoevents.service.aggregate;

import com.example.pedidoevents.model.Enum.PedidoStatus;
import com.example.pedidoevents.model.events.AtualizarPedidoEvent;
import com.example.pedidoevents.model.events.CriarPedidoEvent;
import com.example.pedidoevents.service.command.AtualizarPedidoCommand;
import com.example.pedidoevents.service.command.CriarPedidoCommand;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class PedidoAggregate {

    @AggregateIdentifier
    private String pedidoId;
    private String produtoId;
    private String clienteId;
    private Integer quantidade;
    private String enderecoId;
    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;
    private boolean ativo;

    public PedidoAggregate(){

    }
    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand criarPedidoCommand){
        if(criarPedidoCommand.getQuantidade() <= 0){
            throw new IllegalArgumentException("Quantidade tem q ser maior que zero.");
        }

        CriarPedidoEvent criarPedidoEvent = new CriarPedidoEvent();
        BeanUtils.copyProperties(criarPedidoCommand, criarPedidoEvent);
        AggregateLifecycle.apply(criarPedidoEvent);
    }
    @EventSourcingHandler
    public void on(CriarPedidoEvent criarPedidoEvent){
        this.produtoId = criarPedidoEvent.getProdutoId();
        this.ativo = criarPedidoEvent.getAtivo();
        this.quantidade = criarPedidoEvent.getQuantidade();
        this.enderecoId = criarPedidoEvent.getEnderecoId();
        this.pedidoStatus = criarPedidoEvent.getPedidoStatus();
        this.pedidoId = criarPedidoEvent.getPedidoId();
        this.clienteId = criarPedidoEvent.getClienteId();
    }

    @CommandHandler
    public void handle(AtualizarPedidoCommand atualizarPedidoCommand) {

        AtualizarPedidoEvent atualizarPedidoEvent = new AtualizarPedidoEvent();
        BeanUtils.copyProperties(atualizarPedidoCommand, atualizarPedidoEvent);
        AggregateLifecycle.apply(atualizarPedidoEvent);
    }
    @EventSourcingHandler
    public void on(AtualizarPedidoEvent atualizarPedidoEvent){
        this.ativo = atualizarPedidoEvent.getAtivo();
        this.quantidade = atualizarPedidoEvent.getQuantidade();
        this.enderecoId = atualizarPedidoEvent.getEnderecoId();
        this.pedidoStatus = atualizarPedidoEvent.getPedidoStatus();
        this.pedidoId = atualizarPedidoEvent.getPedidoId();
        this.clienteId = atualizarPedidoEvent.getClienteId();
    }
}
