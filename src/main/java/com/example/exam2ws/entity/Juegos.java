package com.example.exam2ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"idjuego"})
@Table(name="juegos")
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idjuego")
    private int idjuego;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    private Double precio;
    private String image;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Generos idgenero;

    @ManyToOne
    @JoinColumn(name = "idplataforma")
    private Plataformas idplataforma;

    @ManyToOne
    @JoinColumn(name = "ideditora")
    private Editoras ideditora;

    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    private Editoras iddistribuidora;
}
