package com.sooft.challenge.empresa.adapter.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EmpresaJpaRepository extends JpaRepository<EmpresaEntity, Long> {
    Page<EmpresaEntity> findByFechaAdhesionGreaterThanEqual(LocalDate fecha, Pageable pageable);
}
