package com.blumar.agendamento.entities;

import com.blumar.agendamento.entities.enums.RoomType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "Quarto")
@Table(name = "quarto")
@Data
@NoArgsConstructor
public class Quarto implements Serializable {
    private static final long serialVersionUID = 8063180201812979106L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_quarto")
    private UUID idQuarto;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RoomType type;

    @Column(name = "numero")
    private int numero;


    private boolean disponivel=true;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public Quarto(RoomType type, int number, Hotel hotel) {
        this.type=type;
        this.numero=number;
        this.hotel=hotel;
    }

}

