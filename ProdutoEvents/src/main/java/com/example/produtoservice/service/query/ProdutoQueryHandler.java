package com.example.produtoservice.service.query;

import com.example.produtoservice.data.ProdutoEntity;
import com.example.produtoservice.model.ProdutoModel;
import com.example.produtoservice.repository.ProdutoRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoQueryHandler {

    private final ProdutoRepository produtoRepository;

    public ProdutoQueryHandler(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    @QueryHandler
    public List<ProdutoModel> buscarProdutos(BuscarProdutosQuery query){
        List<ProdutoModel> produtoRest = new ArrayList<>();
        List<ProdutoEntity> produtos = produtoRepository.findAll();

        for(ProdutoEntity produtoEntity: produtos) {
            ProdutoModel produtoModel = new ProdutoModel();
            BeanUtils.copyProperties(produtoEntity, produtoModel);
            produtoRest.add(produtoModel);
        }
        return produtoRest;
    }
    @QueryHandler
    public ProdutoModel buscarPorId(BuscarProdutoPorIdQuery query){
        List<ProdutoModel> produtoRest = new ArrayList<>();
        ProdutoEntity produto = produtoRepository.findByProdutoId(query.getProdutoId());
        ProdutoModel resposta = new ProdutoModel();
        resposta.setProdutoId(produto.getTitulo());
        resposta.setTitulo(produto.getTitulo());
        resposta.setPreco(produto.getPreco());
        resposta.setQuantidade(produto.getQuantidade());
        return resposta;
    }


}
