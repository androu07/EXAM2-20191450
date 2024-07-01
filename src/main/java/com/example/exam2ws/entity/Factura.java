package com.example.exam2ws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idfactura")
    private int id;
    @Column(nullable = false)
    private String fechaenvio;
    private String tarjeta;
    private String codigoverificacion;
    private String direccion;
    private Float monto;

    @ManyToOne
    @JoinColumn(name = "idjuegosxusuario")
    private JuegosxUsuario idjuegosxusuario;
}
/*CAMBIE EL NOMBRE DE LOS ATRIBUTOS DE codigoVerificacion y fechaEnvio a codigoverificacion y fechaenvio dentro de la bd*/
