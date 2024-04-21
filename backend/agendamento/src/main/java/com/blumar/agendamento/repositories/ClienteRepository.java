package com.blumar.agendamento.repositories;

import com.blumar.agendamento.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository< Cliente , UUID> {
}
