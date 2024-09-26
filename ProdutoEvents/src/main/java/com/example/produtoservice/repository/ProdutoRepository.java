package com.example.produtoservice.repository;

import com.example.produtoservice.data.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
    ProdutoEntity findByProdutoId(String productId);
}
