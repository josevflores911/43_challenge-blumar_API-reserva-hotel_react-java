package com.blumar.agendamento.entities;

import com.blumar.agendamento.entities.enums.RoomType;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
public class NotaFiscalDTO {
    private UUID idReserva;
    private String nome;
    private Long cpf;
    private String nomeHotel;
    private int numeroDeQuarto;
    private RoomType tipoDeQuarto;
    private LocalDateTime entrada;
    private LocalDateTime salida;
    private int cantidadDeNoites;
    private int valorTotal;

    public NotaFiscalDTO(Cliente cliente, Hotel hotel, Quarto quarto, Reserva reserva) {
        this.idReserva = reserva.getIdReserva();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.nomeHotel=hotel.getNome();
        this.numeroDeQuarto = quarto.getNumero();
        this.tipoDeQuarto = quarto.getType();
        this.entrada = reserva.getDataEntrada();
        this.salida = reserva.getDataSaida();
        this.cantidadDeNoites = reserva.getCantidadNoites();
        this.valorTotal = reserva.getValorTotalReserva();
    }
}
