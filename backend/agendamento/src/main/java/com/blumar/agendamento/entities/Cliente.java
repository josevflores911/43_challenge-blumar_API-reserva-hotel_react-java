package com.blumar.agendamento.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Cliente")
@Table(name = "cliente")
@Getter
//@JsonIgnoreProperties({ "reservas", "others" })
public class Cliente  implements Serializable {
    private static final long serialVersionUID = 8063180201812979106L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private UUID idCliente;
    private String nome;
    private int idade;
    private long cpf;

    private boolean temAcompanhante;
    @Column(name = "nome_acompanhante")
    private String nomeAcompanhante;
    @Column(name = "idade_acompanhante")
    private int idadeAcompanhante;
    @Column(name = "cpf_acompanhante")
    private long cpfAcompanhante;

    //    @Embedded
//    private Pessoa acompanhante;

    public Cliente(String nome,long cpf,int idade
            ,boolean temAcompanhante,String nomeAcompanhante,long cpfAcompanhante,int idadeAcompanhante){
        this.nome=nome;
        this.cpf= cpf;
        this.idade=idade;
        this.temAcompanhante=temAcompanhante;
        this.nomeAcompanhante=nomeAcompanhante;
        this.cpfAcompanhante=cpfAcompanhante;
        this.idadeAcompanhante=idadeAcompanhante;

    }

    //unidad
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reserva> reservas=new ArrayList<>();

    //total
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Pedido> pedidos=new ArrayList<>();

    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", temAcompanhante=" + temAcompanhante +
                ", nomeAcompanhante='" + nomeAcompanhante + '\'' +
                ", idadeAcompanhante=" + idadeAcompanhante +
                ", cpfAcompanhante=" + cpfAcompanhante +
                '}';
    }
}


