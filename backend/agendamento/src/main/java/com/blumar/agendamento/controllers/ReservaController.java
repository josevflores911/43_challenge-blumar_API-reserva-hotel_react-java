package com.blumar.agendamento.controllers;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.NotaFiscal;
import com.blumar.agendamento.entities.Reserva;
import com.blumar.agendamento.entities.ReservaDTO;
import com.blumar.agendamento.services.ClienteService;
import com.blumar.agendamento.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllReservas() {
        List<Reserva> l =reservaService.findAll();

        return ResponseEntity.ok(l);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Optional<NotaFiscal>> addReserve(@RequestBody final ReservaDTO reservaDTO) throws Exception {
        try {
            var notaFiscal= reservaService.createReserva(reservaDTO);

            //return ResponseEntity.ok(notaFiscal);
            return Optional.of(notaFiscal)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
