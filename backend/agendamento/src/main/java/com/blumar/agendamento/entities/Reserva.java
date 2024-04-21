package com.blumar.agendamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Reserva")
@Table(name = "reserva")
@Data
public class Reserva implements Serializable {
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


    public Reserva( int noites, Quarto quarto,Pedido pedido, Cliente cliente) throws Exception {
        this.dataSaida=this.dataEntrada.plusDays(noites);

        this.valorTotalReserva=calculoValorTotal(noites,cliente.isTemAcompanhante(), cliente.getIdadeAcompanhante());
        this.cantidadNoites=noites;


        this.quarto=checkQuarto(quarto);
        this.quarto.setDisponivel(false);

        this.pedido=pedido;
        this.cliente=cliente;

        this.pedido.addReserva(this);
        this.cliente.addReserva(this);



    }

    private Quarto checkQuarto(Quarto quarto) throws Exception {
        if(quarto.isDisponivel()){
            return quarto;
        }else {
            throw new Exception("Quarto nao disponivel");
        }
    }

    private int calculoValorTotal(int noites, boolean temAcompanhante, int idadeAcompanhante) {
        int valorTotalReserva = 0; // Initialize the total reservation cost

        for (int i = 0; i < noites; i++) {
            var dayOfWeek = LocalDateTime.now().plusDays(i).getDayOfWeek();

            switch (dayOfWeek) {
                case MONDAY, THURSDAY, WEDNESDAY, TUESDAY:
                    if (temAcompanhante) {
                        if (idadeAcompanhante >= 18) {
                            valorTotalReserva += 130;
                        } else {
                            valorTotalReserva += 160;
                        }
                    } else {
                        valorTotalReserva += 100;
                    }
                    break;

                case FRIDAY, SATURDAY, SUNDAY:
                    if (temAcompanhante ) {
                        if (idadeAcompanhante >= 18) {
                            valorTotalReserva += 150;
                        } else {
                            valorTotalReserva += 180;
                        }
                    } else {
                        valorTotalReserva += 120;
                    }
                    break;
            }
        }

        return valorTotalReserva;
    }
}

