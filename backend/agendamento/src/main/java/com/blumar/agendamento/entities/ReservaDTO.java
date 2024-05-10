package com.blumar.agendamento.entities;

import com.blumar.agendamento.entities.enums.RoomType;

import javax.validation.constraints.*;

import java.time.LocalDateTime;


public class ReservaDTO {

    @NotNull(message = "CNPJ do hotel é obrigatório")
    public Long cnpjHotel;

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotNull(message = "CPF é obrigatório")
//    @Min(value = 10000000000L, message = "CPF inválido")
//    @Max(value = 99999999999L, message = "CPF inválido")
    @Pattern(regexp = "\\d{11}", message = "CPF inválido")
    public Long cpf;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 18, message = "Idade mínima é 18 anos")
    public Integer idade;

//    @Email(message = "Email inválido")
//    private String email;

    public boolean temAcompanhante = false;
    public String nomeAcompanhante;
    public Long cpfAcompanhante;
    public Integer idadeAcompanhante;

    @NotNull(message = "Tipo de quarto é obrigatório")
    public RoomType tipoQuarto;

    @NotNull(message = "Data de entrada é obrigatória")
    public LocalDateTime entrada = LocalDateTime.now();

    @NotNull(message = "Data de saída é obrigatória")
    public LocalDateTime salida;

    public ReservaDTO() {
    }

    // Getters and setters
}