package com.blumar.agendamento.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

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
    private int valorTotal=0;

    @Column(name = "entrada")
    private LocalDateTime entrada = LocalDateTime.now();

    @JsonIgnore
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reserva> reservas=new ArrayList<>();


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pedido( Cliente cliente) {
        this.cliente=cliente;
        this.cliente.addPedido(this);
    }

    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
        this.calcularValorTotal(reserva);
    }

    private void calcularValorTotal(Reserva reserva){
        this.valorTotal+=reserva.getValorTotalReserva();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", valorTotal=" + valorTotal +
                ", entrada=" + entrada +
                ", cliente=" + cliente +
                '}';
    }
}
