package com.example.almoxarifado.repository;

import com.example.almoxarifado.data.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, String> {
    PedidoEntity findByPedidoId(String pedidoId);
}
