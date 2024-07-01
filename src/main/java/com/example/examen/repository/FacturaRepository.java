package com.example.examen.repository;

import com.example.examen.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
