package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.BitSet;

@Getter
@Setter
@Table(name = "usuarios")
@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusario;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "password")
    private String password;
    @Column(name = "autorizacion")
    private String autorizacion;
    @Column(name = "enabled")
    private BitSet enabled;
}
