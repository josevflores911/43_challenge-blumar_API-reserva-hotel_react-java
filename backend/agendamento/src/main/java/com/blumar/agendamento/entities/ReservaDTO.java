package com.blumar.agendamento.entities;

import com.blumar.agendamento.entities.enums.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ReservaDTO {

    public int cnpjHotel;
    public String nome;
    public long cpf;
    public int idade;

    public boolean temAcompanhante=false;
    public String nomeAcompanhante="";
    public long cpfAcompanhante=0;
    public int idadeAcompanhante=0;
    public RoomType tipoQuarto;
    public LocalDateTime entrada=LocalDateTime.now();
    public LocalDateTime salida;

    public ReservaDTO(String nome, long cpf, int idade, boolean temAcompanhante, String nomeAcompanhante, long cpfAcompanhante, int idadeAcompanhante, RoomType tipoQuarto, String salida) throws ParseException {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.temAcompanhante = temAcompanhante;
        this.nomeAcompanhante = nomeAcompanhante;
        this.cpfAcompanhante = cpfAcompanhante;
        this.idadeAcompanhante = idadeAcompanhante;
        this.tipoQuarto = tipoQuarto;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = formatter.parse(salida);

        this.salida = parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}