package com.example.almoxarifado.service;


import com.example.almoxarifado.data.PedidoEntity;
import com.example.almoxarifado.model.events.AtualizarPedidoEvent;
import com.example.almoxarifado.model.events.CriarPedidoEvent;
import com.example.almoxarifado.repository.PedidoRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PedidoEventsHandler {

    private final PedidoRepository pedidoRepository;

    public PedidoEventsHandler(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @EventHandler
    public void on(CriarPedidoEvent event) {
        PedidoEntity pedido = new PedidoEntity();
        BeanUtils.copyProperties(event, pedido);
        pedidoRepository.save(pedido);
    }
    @EventHandler
    public void on(AtualizarPedidoEvent event) {
        PedidoEntity pedido = pedidoRepository.findByPedidoId(event.getPedidoId());

        if (pedido == null) {
            return;
        }
        pedido.setProdutoId(event.getProdutoId());
        pedido.setClienteId(event.getClienteId());
        pedido.setQuantidade(event.getQuantidade());
        pedido.setEnderecoId(event.getEnderecoId());
        pedido.setPedidoStatus(event.getPedidoStatus());
        pedido.setAtivo(event.getAtivo());
        pedidoRepository.save(pedido);
    }
}