package com.blumar.agendamento.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//
//@Entity(name = "Pedido")
//@Table(name = "pedido")
//@Data
//public class Pedido implements Serializable {
//    private static final long serialVersionUID = 8063180201812979106L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id_pedido")
//    private UUID idPedido;
//
//    @Column(name = "valor_total")
//    private int valorTotal;
//
//    @Column(name = "entrada")
//    private LocalDateTime entrada=LocalDateTime.now();
//
//    @JsonIgnore
//    @OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
//    private Reserva reserva;
//
//    @JsonIgnore
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "id_cliente")
//    private Cliente cliente;
//}



@Entity(name = "Pedido")
@Table(name = "pedido")
@Data
public class Pedido implements Serializable {
    private static final long serialVersionUID = 8063180201812979106L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido")
    private UUID idPedido;

    @Column(name = "valor_total")
    private int valorTotal;

    @Column(name = "entrada")
    private LocalDateTime entrada = LocalDateTime.now();

    @JsonIgnore
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reserva> reserva;
    //@JoinColumn(name = "id_reserva") // Assuming id_reserva is the foreign key column in the Pedido table

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
