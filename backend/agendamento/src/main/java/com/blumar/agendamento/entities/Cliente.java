package com.blumar.agendamento.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity(name = "Cliente")
@Table(name = "cliente")
@Data
//@JsonIgnoreProperties({ "reservas", "others" })
public class Cliente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 8063180201812979106L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private UUID clienteId;
    private boolean temAcompanhante;

//    @Embedded
//    private Pessoa acompanhante;
    @Column(name = "nome_acompanhante")
    private String nomeAcompanhante;
    @Column(name = "idade_acompanhante")
    private Integer idadeAcompanhante;
    @Column(name = "cpf_acompanhante")
    private Integer cpfAcompanhante;

    //unidad
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    //total
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    // Method to set accompanying person
//    public void setAcompanhante(String nomeAcompanhante, int idadeAcompanhante, String cpfAcompanhante) {
//        this.temAcompanhante = true;
//        this.nomeAcompanhante = nomeAcompanhante;
//        this.idadeAcompanhante = idadeAcompanhante;
//        this.cpfAcompanhante = cpfAcompanhante;
//    }
}


