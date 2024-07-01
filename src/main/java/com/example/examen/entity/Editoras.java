package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "editoras")
@Entity
public class Editoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ideditora;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

}
