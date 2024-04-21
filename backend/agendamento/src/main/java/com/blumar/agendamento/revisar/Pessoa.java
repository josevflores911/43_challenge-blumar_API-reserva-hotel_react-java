package com.blumar.agendamento.revisar;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

//@Embeddable

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Pessoa  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    public UUID pessoaId;
    public String nome;

    public int idade;
    public int cpf;


    public Pessoa() {
    }

    public Pessoa(String nome, int idade, int cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && cpf == pessoa.cpf && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                '}';
    }
}



