package com.example.examen.repository;

import com.example.examen.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
