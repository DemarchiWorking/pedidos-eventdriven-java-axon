package com.example.produtoservice.service.aggregate;

import com.example.produtoservice.model.events.AtualizarProdutoEvent;
import com.example.produtoservice.model.events.CriarProdutoEvent;
import com.example.produtoservice.model.events.DeletarProdutoEvent;
import com.example.produtoservice.service.command.AtualizarProdutoCommand;
import com.example.produtoservice.service.command.CriarProdutoCommand;
import com.example.produtoservice.service.command.DeletarProdutoCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProdutoAggregate {
    @AggregateIdentifier
    private String produtoId;
    private String titulo;
    private BigDecimal preco;
    private Integer quantidade;

    public ProdutoAggregate(){

    }
    @CommandHandler
    public ProdutoAggregate(CriarProdutoCommand criarProdutoCommand){
        if(criarProdutoCommand.getPreco().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Preco tem q ser maior que zero.");
        }
        if(criarProdutoCommand.getTitulo() == null ||
                criarProdutoCommand.getTitulo().isBlank()){
            throw new IllegalArgumentException("Titulo não pode ser vazio.");
        }
        CriarProdutoEvent criarProdutoEvent = new CriarProdutoEvent();
        BeanUtils.copyProperties(criarProdutoCommand, criarProdutoEvent);
        AggregateLifecycle.apply(criarProdutoEvent);
    }
    @EventSourcingHandler
    public void on(CriarProdutoEvent criarProdutoEvent){
        this.produtoId = criarProdutoEvent.getProdutoId();
        this.preco = criarProdutoEvent.getPreco();
        this.titulo = criarProdutoEvent.getTitulo();
        this.quantidade = criarProdutoEvent.getQuantidade();
    }

    @CommandHandler
    public void handle(DeletarProdutoCommand deletarProdutoCommand) {

        DeletarProdutoEvent deletarProdutoEvent = new DeletarProdutoEvent();
        deletarProdutoEvent.setProdutoId(deletarProdutoCommand.getProdutoId());
        BeanUtils.copyProperties(deletarProdutoCommand, deletarProdutoEvent);
        AggregateLifecycle.apply(deletarProdutoEvent);
    }

    @EventSourcingHandler
    public void on(DeletarProdutoCommand deletarProdutoCommand) {
        this.produtoId = deletarProdutoCommand.getProdutoId();
    }
    @CommandHandler
    public void handle(AtualizarProdutoCommand atualizarProdutoCommand) {
        if (atualizarProdutoCommand.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço tem que ser maior que zero.");
        }
        if (atualizarProdutoCommand.getTitulo() == null || atualizarProdutoCommand.getTitulo().isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        AtualizarProdutoEvent atualizarProdutoEvent = new AtualizarProdutoEvent();
        BeanUtils.copyProperties(atualizarProdutoCommand, atualizarProdutoEvent);
        AggregateLifecycle.apply(atualizarProdutoEvent);
    }
    @EventSourcingHandler
    public void on(AtualizarProdutoEvent atualizarProdutoEvent) {
        this.preco = atualizarProdutoEvent.getPreco();
        this.titulo = atualizarProdutoEvent.getTitulo();
        this.quantidade = atualizarProdutoEvent.getQuantidade();
    }

}