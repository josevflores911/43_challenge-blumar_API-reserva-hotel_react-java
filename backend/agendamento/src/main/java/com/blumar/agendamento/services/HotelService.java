package com.blumar.agendamento.services;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Hotel;
import com.blumar.agendamento.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findAll(){return   hotelRepository.findAll(); }
}