package com.blumar.agendamento.controllers;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Hotel;
import com.blumar.agendamento.services.ClienteService;
import com.blumar.agendamento.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoteis")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllHoteis() {
        List<Hotel> l =hotelService.findAll();


        return ResponseEntity.ok(l);
    }
}
