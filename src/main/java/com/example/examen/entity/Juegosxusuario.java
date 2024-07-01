package com.example.examen.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "juegosxusuario")
@Entity
public class Juegosxusuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idjuegosxusuario;
    @ManyToOne
    @JoinColumn(name = "idjuego", nullable = false)
    private Juegos juegos;
    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuarios usuarios;
    @Column(name = "cantidad")
    private Integer cantidad;

}
