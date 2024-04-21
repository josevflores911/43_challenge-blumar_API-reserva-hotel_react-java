package com.blumar.agendamento.services;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Pedido;
import com.blumar.agendamento.repositories.ClienteRepository;
import com.blumar.agendamento.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll(){return   pedidoRepository.findAll(); }
}