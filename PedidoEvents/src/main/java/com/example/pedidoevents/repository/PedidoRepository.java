package com.example.pedidoevents.repository;

import com.example.pedidoevents.data.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, String> {
    PedidoEntity findByPedidoId(String pedidoId);
}
