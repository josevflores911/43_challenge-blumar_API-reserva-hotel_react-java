package com.blumar.agendamento.entities;


import com.blumar.agendamento.entities.Quarto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity(name = "Hotel")
@Table(name = "hotel")
@Data
public class Hotel implements Serializable {
    private static final long serialVersionUID = 8063180201812979106L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hotel")
    private UUID idHotel;
    private int cnpj;
    private String name;
    private String ubicacion;
    private int contacto;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Quarto> quartos;

}
