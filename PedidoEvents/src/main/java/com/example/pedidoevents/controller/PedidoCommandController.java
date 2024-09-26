package com.example.pedidoevents.controller;

import com.example.pedidoevents.model.AtualizarPedidoModel;
import com.example.pedidoevents.model.CriarPedidoModel;
import com.example.pedidoevents.model.Enum.PedidoStatus;
import com.example.pedidoevents.service.command.AtualizarPedidoCommand;
import com.example.pedidoevents.service.command.CriarPedidoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/pedidos")
public class PedidoCommandController {
    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public PedidoCommandController(Environment env, CommandGateway commandGateway){
        this.env = env;
        this.commandGateway = commandGateway;
    }
    @PostMapping
    public String criarPedido(@RequestBody CriarPedidoModel criarPedidoModel){
        CriarPedidoCommand criarPedidoCommand = CriarPedidoCommand.builder()
                .quantidade(criarPedidoModel.getQuantidade()).produtoId(criarPedidoModel.getProdutoId())
                .pedidoStatus(PedidoStatus.FECHADO).clienteId(criarPedidoModel.getClienteId())
                .enderecoId(criarPedidoModel.getEnderecoId())
                .ativo(true).pedidoId(UUID.randomUUID().toString()).build();


        String retorno;
        try{
            retorno = commandGateway.sendAndWait(criarPedidoCommand);
        }catch (Exception ex){
            retorno = ex.getLocalizedMessage();
        }
        return retorno;
    }
    @PutMapping("/{id}")
    public String atualizarPedido(@PathVariable String id, @RequestBody AtualizarPedidoModel atualizarPedidoModel){
        AtualizarPedidoCommand atualizarPedidoCommand = AtualizarPedidoCommand.builder()
                .quantidade(atualizarPedidoModel.getQuantidade()).produtoId(atualizarPedidoModel.getProdutoId())
                .pedidoStatus(atualizarPedidoModel.getPedidoStatus()).clienteId(atualizarPedidoModel.getClienteId())
                .enderecoId(atualizarPedidoModel.getEnderecoId())
                .ativo(atualizarPedidoModel.isAtivo()).pedidoId(id.toString()).build();

        String retorno;
        try{
            retorno = commandGateway.sendAndWait(atualizarPedidoCommand);
        }catch (Exception ex){
            retorno = ex.getLocalizedMessage();
        }
        return retorno;
    }
}
