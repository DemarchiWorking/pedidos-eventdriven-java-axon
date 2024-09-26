package com.example.produtoservice.service.query;

import com.example.produtoservice.data.ProdutoEntity;
import com.example.produtoservice.model.events.AtualizarProdutoEvent;
import com.example.produtoservice.model.events.CriarProdutoEvent;
import com.example.produtoservice.model.events.DeletarProdutoEvent;
import com.example.produtoservice.repository.ProdutoRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProdutoEventosHandler {
    private final ProdutoRepository produtoRepository;
    public ProdutoEventosHandler(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    @EventHandler
    public void on(CriarProdutoEvent event){
        ProdutoEntity produtoEntity = new ProdutoEntity();
        BeanUtils.copyProperties(event, produtoEntity);
        produtoRepository.save(produtoEntity);
    }

    @EventHandler
    public void on(AtualizarProdutoEvent event) {
        ProdutoEntity produto = produtoRepository.findByProdutoId(event.getProdutoId());

        if(produto == null) {
            // TODO: Do something about it
            return;
        }
        produto.setTitulo(event.getTitulo());
        produto.setPreco(event.getPreco());
        produto.setQuantidade(event.getQuantidade());
        produtoRepository.save(produto);
    }
    @EventHandler
    public void on(DeletarProdutoEvent event) {
        System.out.println("test "+event.getProdutoId());
        produtoRepository.deleteById(event.getProdutoId());

    }
}
