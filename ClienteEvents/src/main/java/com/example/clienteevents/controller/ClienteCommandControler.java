package com.example.clienteevents.controller;

import com.example.clienteevents.model.AtualizarClienteModel;
import com.example.clienteevents.model.CriarClienteModel;
import com.example.clienteevents.service.command.AtualizarClienteCommand;
import com.example.clienteevents.service.command.CriarClienteCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/clientes")
public class ClienteCommandControler {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ClienteCommandControler(Environment env, CommandGateway commandGateway){
        this.env = env;
        this.commandGateway = commandGateway;
    }
    @PostMapping
    public String criarCliente(@RequestBody CriarClienteModel criarClienteModel){
        CriarClienteCommand criarClienteCommand = CriarClienteCommand.builder()
         .ativo(true).nome(criarClienteModel.getNome())
         .telefone(criarClienteModel.getTelefone())
         .email(criarClienteModel.getEmail()).senha(criarClienteModel.getSenha())
         .clienteId(UUID.randomUUID().toString()).build();

        String retorno;
        try{
            retorno = commandGateway.sendAndWait(criarClienteCommand);
        }catch (Exception ex){
            retorno = ex.getLocalizedMessage();
        }
        return retorno;
    }
    @PutMapping("/{id}")
    public String atualizarCliente(@PathVariable String id, @RequestBody AtualizarClienteModel atualizarClienteModel){
        AtualizarClienteCommand atualizarClienteCommand = AtualizarClienteCommand.builder()
                .ativo(atualizarClienteModel.getAtivo()).nome(atualizarClienteModel.getNome())
                .telefone(atualizarClienteModel.getTelefone())
                .email(atualizarClienteModel.getEmail()).senha(atualizarClienteModel.getSenha())
                .clienteId(id.toString()).build();

        String retorno;
        try{
            retorno = commandGateway.sendAndWait(atualizarClienteCommand);
        }catch (Exception ex){
            retorno = ex.getLocalizedMessage();
        }
        return retorno;
    }
}
