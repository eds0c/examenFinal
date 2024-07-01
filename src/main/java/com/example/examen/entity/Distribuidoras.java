package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "distribuidoras")
@Entity
public class Distribuidoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddistribuidora;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fundacion", nullable = false)
    private Integer fundacion;
    @Column(name = "web")
    private String web;
    @ManyToOne
    @JoinColumn(name = "idsede")
    private Paises paises;
}
