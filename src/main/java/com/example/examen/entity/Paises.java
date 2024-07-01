package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "paises")
@Entity
public class Paises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idplataforma;
    @Column(name = "iso")
    private String iso;
    @Column(name = "nombre")
    private String nombre;
}
