package com.example.almoxarifado.repository;

import com.example.almoxarifado.data.PedidoEntity;
import com.example.almoxarifado.data.PreparacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreparacaoRepository extends JpaRepository<PreparacaoEntity, String> {
}
