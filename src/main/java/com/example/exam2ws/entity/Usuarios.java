package com.example.exam2ws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private int id;
    @Column(nullable = false)
    private String apellidos;
    private String nombres;
    private String correo;
    private String password;
    private String autorizacion;
    private boolean enabled;
}
