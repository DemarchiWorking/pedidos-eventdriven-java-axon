package com.example.produtoservice.controller;

import com.example.produtoservice.model.ProdutoModel;
import com.example.produtoservice.service.command.AtualizarProdutoCommand;
import com.example.produtoservice.service.command.CriarProdutoCommand;
import com.example.produtoservice.service.command.DeletarProdutoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProdutoCommandController(Environment env, CommandGateway commandGateway){
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String criarProduto(@RequestBody ProdutoModel produtoModel){
            CriarProdutoCommand criarProdutoComando = CriarProdutoCommand.builder()
                    .preco(produtoModel.getPreco())
                    .quantidade(produtoModel.getQuantidade())
                    .titulo(produtoModel.getTitulo())
                    .produtoId(UUID.randomUUID().toString()).build();

            String retorno;
            try{
                retorno = commandGateway.sendAndWait(criarProdutoComando);
            }catch (Exception ex){
                retorno = ex.getLocalizedMessage();
            }
        return retorno;
    }
    @PutMapping("/{id}")
    public String atualizarProduto(@PathVariable String id, @RequestBody ProdutoModel produtoModel){
        System.out.println(produtoModel.getTitulo());
        System.out.println(id);

        AtualizarProdutoCommand atualizarProdutoCommand = AtualizarProdutoCommand.builder()
                .preco(produtoModel.getPreco())
                .quantidade(produtoModel.getQuantidade())
                .titulo(produtoModel.getTitulo())
                .produtoId(id.toString()).build();

        String retorno;
        try{
            retorno = commandGateway.sendAndWait(atualizarProdutoCommand);
        }catch (Exception ex){
            retorno = ex.getLocalizedMessage();
        }
        return retorno;
    }

    @DeleteMapping("/{id}")
    public String deleteProduto(@PathVariable String id){
        System.out.println(id);
        DeletarProdutoCommand deletarProdutoCommand = DeletarProdutoCommand.builder()
                .produtoId(id).build();

        String retorno;
        try{
            retorno = commandGateway.sendAndWait(deletarProdutoCommand);
        }catch (Exception ex){
            retorno = ex.getLocalizedMessage();
        }
        return retorno;
    }
    /*
    @GetMapping
    public String obterProdutos(){
        return "Get";
    }

    @DeleteMapping
    public String deleteProduto(){
        return "delete";
    }*/
}
