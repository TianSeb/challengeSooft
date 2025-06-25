package com.sooft.challenge.transferencia.adapter.out;

import com.sooft.challenge.empresa.adapter.out.EmpresaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TransferenciaJpaRepository extends JpaRepository<TransferenciaEntity, Long> {

    @Query("""
    SELECT DISTINCT t.empresa
    FROM TransferenciaEntity t
    WHERE t.fecha >= :desde
""")
    Page<EmpresaEntity> findEmpresasConTransferenciasDesde(@Param("desde") LocalDate desde, Pageable pageable);
}
