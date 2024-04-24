package com.blumar.agendamento.repositories;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
    List<Reserva> findByCliente(Cliente cliente);

    List<Reserva> findByClienteCpf(long cpf);

//    @Query("SELECT r FROM Reserva r WHERE r.cliente = :cliente")
//    List<Reserva> findReservasByCliente(@Param("cliente") Cliente cliente);

}
