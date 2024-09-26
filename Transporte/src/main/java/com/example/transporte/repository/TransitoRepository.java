package com.example.transporte.repository;

import com.example.transporte.data.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitoRepository extends JpaRepository<PedidoEntity, String> {
}
