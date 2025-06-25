package com.sooft.challenge.transferencia.domain.port.output;

import com.sooft.challenge.empresa.domain.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface TransferenciaRepositoryPort {
    Page<Empresa> buscarEmpresasConTransferenciasDesde(LocalDate desde, Pageable pageable);
}
