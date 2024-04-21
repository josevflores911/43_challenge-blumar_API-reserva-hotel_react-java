package com.blumar.agendamento.entities;

import com.blumar.agendamento.entities.enums.RoomType;

import java.time.LocalDateTime;

public class ReservaDTO {

    public int cnpjHotel;
    public String nome;
    public long cpf;
    public int idade;

    public boolean temAcompanhante=false;
    public String nomeAcompanhante="";
    public long cpfAcompanhante=0;
    public int idadeAcompanhante=0;
    public RoomType tipoQUarto;
    public LocalDateTime entrada=LocalDateTime.now();
    public LocalDateTime salida;

    public ReservaDTO(String nome, long cpf, int idade, boolean temAcompanhante, String nomeAcompanhante, long cpfAcompanhante, int idadeAcompanhante, RoomType tipoQUarto, LocalDateTime entrada, LocalDateTime salida) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.temAcompanhante = temAcompanhante;
        this.nomeAcompanhante = nomeAcompanhante;
        this.cpfAcompanhante = cpfAcompanhante;
        this.idadeAcompanhante = idadeAcompanhante;
        this.tipoQUarto = tipoQUarto;

        this.salida = salida;
    }
}
