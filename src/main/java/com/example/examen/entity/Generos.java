package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "paises")
@Entity
public class Generos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgenero;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
}
