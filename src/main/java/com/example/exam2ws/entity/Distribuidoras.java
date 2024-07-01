package com.example.exam2ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"iddistribuidora"})
@Table(name="distribuidoras")
public class Distribuidoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddistribuidora")
    private int iddistribuidora;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    private Integer fundacion;
    private String web;

    @ManyToOne
    @JoinColumn(name = "idpais")
    private Paises idsede;
}
