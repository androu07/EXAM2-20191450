package com.example.exam2ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"idplataforma"})
@Table(name="plataformas")
public class Plataformas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idplataforma")
    private int idplataforma;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
}
