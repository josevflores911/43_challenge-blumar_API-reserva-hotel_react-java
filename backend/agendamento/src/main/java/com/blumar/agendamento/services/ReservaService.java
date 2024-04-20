package com.blumar.agendamento.services;


import com.blumar.agendamento.entities.Reserva;
import com.blumar.agendamento.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}