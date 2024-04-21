package com.blumar.agendamento.controllers;

import com.blumar.agendamento.entities.Cliente;
import com.blumar.agendamento.entities.Pedido;
import com.blumar.agendamento.services.ClienteService;
import com.blumar.agendamento.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPedidos() {
        List<Pedido> l =pedidoService.findAll();

        return ResponseEntity.ok(l);
    }
}
