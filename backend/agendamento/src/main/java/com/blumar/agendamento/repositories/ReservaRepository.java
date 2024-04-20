package com.blumar.agendamento.repositories;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
}
