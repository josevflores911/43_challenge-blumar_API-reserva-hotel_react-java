package com.blumar.agendamento.controllers;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.NotaFiscalDTO;
import com.blumar.agendamento.entities.Reserva;
import com.blumar.agendamento.entities.ReservaDTO;
import com.blumar.agendamento.services.ClienteService;
import com.blumar.agendamento.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reservas")
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

    @PostMapping
    @Transactional
    public ResponseEntity<Optional<NotaFiscalDTO>> addReserve(@RequestBody final ReservaDTO reservaDTO) throws Exception {
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

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<List<Reserva>> reservasByClienteCPF(@PathVariable Long cpf) {
        //Cliente cliente=clienteService.findByCpf(cpf);

        List<Reserva> l =reservaService.findReservasByClientCPF(cpf);

        return ResponseEntity.ok(l);
    }
}
