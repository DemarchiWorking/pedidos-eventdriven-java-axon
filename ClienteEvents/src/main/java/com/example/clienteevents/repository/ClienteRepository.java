package com.example.clienteevents.repository;

import com.example.clienteevents.data.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    ClienteEntity buscarClienteId(String clienteId);
}
