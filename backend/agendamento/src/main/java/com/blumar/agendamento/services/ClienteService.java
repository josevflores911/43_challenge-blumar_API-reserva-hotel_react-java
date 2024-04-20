package com.blumar.agendamento.services;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Hotel;
import com.blumar.agendamento.repositories.ClienteRepository;
import com.blumar.agendamento.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}