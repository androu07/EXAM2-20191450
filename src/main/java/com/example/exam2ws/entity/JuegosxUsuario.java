package com.example.exam2ws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="juegosxusuario")
public class JuegosxUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idjuegosxusuario")
    private int idjuegosxusuario;
    @Column(nullable = false)
    private Integer cantidad;


}
