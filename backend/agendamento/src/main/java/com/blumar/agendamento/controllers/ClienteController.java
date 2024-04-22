package com.blumar.agendamento.controllers;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<Cliente> l =clienteService.findAll();
        l.sort(Comparator.comparing(Cliente::getNome));
        return ResponseEntity.ok(l);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> addCliente(@RequestBody final Cliente cliente) throws Exception {
        try {
            clienteService.saveCliente(cliente);

//            return ResponseEntity.ok(cliente);
            return Optional.of(cliente)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{cpf}")
    @Transactional
    public ResponseEntity<?> updateCliente(@PathVariable Long cpf, @RequestBody Cliente cliente) throws Exception {
        clienteService.updateCliente(cpf, cliente);
        return ResponseEntity.ok().build();
    }


}
