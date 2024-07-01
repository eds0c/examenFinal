package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "plataformas")
@Entity
public class Plataformas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idplataforma;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
}
