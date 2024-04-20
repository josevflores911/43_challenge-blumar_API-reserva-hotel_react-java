package com.blumar.agendamento.repositories;

import com.blumar.agendamento.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuartoRepository extends JpaRepository<Quarto, UUID> {
}
