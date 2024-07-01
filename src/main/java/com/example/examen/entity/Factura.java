package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "factura")
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfactura;
    @Column(name = "fechaEnvio", nullable = false)
    private String fechaEnvio;
    @Column(name = "tarjeta")
    private String tarjeta;
    @Column(name = "codigoVerificacion", nullable = false)
    private Integer codigoVerificacion;
    @Column(name = "direccion", nullable = false)
    private Integer direccion;
    @Column(name = "monto", nullable = false)
    private Float monto;
    @ManyToOne
    @JoinColumn(name = "idjuegosxusuario")
    private Juegosxusuario juegosxusuario;
}
