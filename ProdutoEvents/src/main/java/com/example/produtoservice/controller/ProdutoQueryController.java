package com.example.produtoservice.controller;

import com.example.produtoservice.model.ProdutoModel;
import com.example.produtoservice.service.query.BuscarProdutoPorIdQuery;
import com.example.produtoservice.service.query.BuscarProdutosQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoQueryController {

    @Autowired
    QueryGateway queryGateway;
    @GetMapping
    public List<ProdutoModel> obterProdutos(){
        BuscarProdutosQuery buscarProdutoQuery = new BuscarProdutosQuery();
        List<ProdutoModel> produtos = queryGateway.query(buscarProdutoQuery, ResponseTypes.multipleInstancesOf(ProdutoModel.class)).join();

        return produtos;
    }

    @GetMapping("/{id}")
    public List<ProdutoModel> obterProdutoPorId(@PathVariable String id){
        BuscarProdutoPorIdQuery buscarProdutoQuery = new BuscarProdutoPorIdQuery(id);
        List<ProdutoModel> produtos = queryGateway.query(buscarProdutoQuery, ResponseTypes.multipleInstancesOf(ProdutoModel.class)).join();

        return produtos;
    }
}
