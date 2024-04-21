package com.blumar.agendamento.services;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Hotel;
import com.blumar.agendamento.entities.Quarto;
import com.blumar.agendamento.repositories.HotelRepository;
import com.blumar.agendamento.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository quartoRepository;

    @Transactional
    public Quarto saveQuarto(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public List<Quarto> findAll(){return   quartoRepository.findAll(); }
}
