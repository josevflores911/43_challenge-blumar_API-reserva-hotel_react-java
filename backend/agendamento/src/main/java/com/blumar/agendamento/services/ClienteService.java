package com.blumar.agendamento.services;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Hotel;
import com.blumar.agendamento.repositories.ClienteRepository;
import com.blumar.agendamento.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){return   clienteRepository.findAll(); }

    public void addCliente(Object cliente) {
    }

    public void updateCliente(Long cpf, Object cliente) {
    }
}