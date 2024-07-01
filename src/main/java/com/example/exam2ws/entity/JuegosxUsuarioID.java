package com.example.exam2ws.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class JuegosxUsuarioID implements Serializable {
    @Column(name = "idjuego", nullable = false)
    private Integer idjuego;

    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;
}
