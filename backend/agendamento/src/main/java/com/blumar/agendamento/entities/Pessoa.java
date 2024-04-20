package com.blumar.agendamento.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

//@Embeddable
public class Pessoa  {
    private String nome;
    private int idade;
    private int cpf;

    public Pessoa() {
    }
    public Pessoa( String nome, int idade,int cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf=cpf;
    }
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}



