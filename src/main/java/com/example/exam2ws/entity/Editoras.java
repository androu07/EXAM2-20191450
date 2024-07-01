package com.example.exam2ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"ideditora"})
@Table(name="editoras")
public class Editoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ideditora")
    private int ideditora;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
}
