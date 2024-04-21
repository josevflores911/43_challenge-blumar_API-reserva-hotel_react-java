package com.blumar.agendamento.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
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
    private long contacto;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Quarto> quartos=new ArrayList<>();

    public void addRoom(Quarto quarto){
        this.quartos.add(quarto);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "idHotel=" + idHotel +
                ", cnpj=" + cnpj +
                ", name='" + name + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", contacto=" + contacto +
                '}';
    }
}
