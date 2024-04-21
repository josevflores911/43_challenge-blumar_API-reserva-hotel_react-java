package com.blumar.agendamento.repositories;

import com.blumar.agendamento.entities.Quarto;
import com.blumar.agendamento.entities.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuartoRepository extends JpaRepository<Quarto, UUID> {

    List<Quarto> findByTypeAndDisponivel(RoomType type, boolean disponivel);
}
