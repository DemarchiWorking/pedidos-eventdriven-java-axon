package com.example.produtoservice.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="produtos")
@Data
public class ProdutoEntity implements Serializable{
    private static final long serialVersionUID =5313493413859894403L;
    @Id
    @Column(unique = true)
    private String produtoId;
    private String titulo;
    private BigDecimal preco;
    private Integer quantidade;


}
