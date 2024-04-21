package com.blumar.agendamento.controllers;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Quarto;
import com.blumar.agendamento.services.ClienteService;
import com.blumar.agendamento.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllQuartos() {
        List<Quarto> l =quartoService.findAll();
        return ResponseEntity.ok(l);
    }
}
