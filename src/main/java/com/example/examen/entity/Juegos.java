package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "juegos")
@Entity
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idjuego;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Generos generos;
    @ManyToOne
    @JoinColumn(name = "idplataforma")
    private Plataformas plataformas;
    @ManyToOne
    @JoinColumn(name = "ideditora")
    private Editoras editoras;
    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    private Distribuidoras distribuidoras;
}
