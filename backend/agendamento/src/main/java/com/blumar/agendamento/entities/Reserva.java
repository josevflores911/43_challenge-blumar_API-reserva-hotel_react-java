package com.blumar.agendamento.entities;

import com.blumar.agendamento.services.CalculoDePrecios;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;



import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Reserva")
@Table(name = "reserva")
@Data
@NoArgsConstructor
public class Reserva implements Serializable {

    //avoid autowired in entities @Autowired

    public Reserva( int noites, Quarto quarto, Pedido pedido, Cliente cliente) throws Exception {

        this.dataSaida=this.dataEntrada.plusDays(noites);
        this.cantidadNoites=noites;
        //this.quarto.setDisponivel(false);
        this.pedido=pedido;
        this.cliente=cliente;
        this.pedido.addReserva(this);
        this.cliente.addReserva(this);

    }



    private static final long serialVersionUID = 8063180201812979106L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva")
    private UUID idReserva;

    @Column(name = "data_entrada")
    private LocalDateTime dataEntrada=LocalDateTime.now();

    @Column(name = "data_saida")
    private LocalDateTime dataSaida;

    @Column(name = "valor_total_reserva")
    private int valorTotalReserva;

    @Column(name = "cantidad_noites")
    private int cantidadNoites;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_quarto")
    private Quarto quarto;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}

