package com.example.clienteevents.service.handler;


import com.example.clienteevents.data.ClienteEntity;
import com.example.clienteevents.model.events.AtualizarClienteEvent;
import com.example.clienteevents.model.events.CriarClienteEvent;
import com.example.clienteevents.repository.ClienteRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClienteEventHandler {
    private final ClienteRepository clienteRepository;
    public ClienteEventHandler(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @EventHandler
    public void on(CriarClienteEvent event){
        ClienteEntity cliente = new ClienteEntity();
        BeanUtils.copyProperties(event, cliente);
        clienteRepository.save(cliente);
    }

    @EventHandler
    public void on(AtualizarClienteEvent event) {
        ClienteEntity cliente = clienteRepository.buscarClienteId(event.getClienteId());

        if(cliente == null) {
            // TODO: Do something about it
            return;
        }
        cliente.setNome(event.getNome());
        cliente.setTelefone(event.getTelefone());
        cliente.setEmail(event.getEmail());
        cliente.setSenha(event.getSenha());
        cliente.setAtivo(event.getAtivo());
        clienteRepository.save(cliente);
    }
}
