package com.blumar.agendamento.services;

import com.blumar.agendamento.entities.Cliente;

import com.blumar.agendamento.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){return   clienteRepository.findAll(); }

    public Cliente findByCpf(long cpf){return   clienteRepository.findByCpf(cpf); }

    public void updateCliente(Long cpf, Cliente cliente) {
    }
}