package com.blumar.agendamento.controllers;


import com.blumar.agendamento.entities.NotaFiscalDTO;
import com.blumar.agendamento.entities.Reserva;
import com.blumar.agendamento.entities.ReservaDTO;
import com.blumar.agendamento.exceptions.ResourceNotFoundException;
import com.blumar.agendamento.exceptions.ValidationException;
import com.blumar.agendamento.services.ClienteService;
import com.blumar.agendamento.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/reservas")
@Validated
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> l =reservaService.findAll();

        return ResponseEntity.ok(l);
    }


    //Cliente cliente=clienteService.findByCpf(cpf);
   @GetMapping("/cliente/{cpf}")
    public ResponseEntity<List<Reserva>> reservasByClienteCPF(@PathVariable String cpf) {
        try {
            Long cpfValue = Long.parseLong(cpf); // Convert CPF string to Long

            List<Reserva> reservas = reservaService.findReservasByClientCPF(cpfValue);
            return ResponseEntity.ok(reservas);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(List.of()); // Invalid CPF format
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
