package com.blumar.agendamento.repositories;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
