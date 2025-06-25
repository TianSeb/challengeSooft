package com.sooft.challenge.transferencia.domain.port.input;

import com.sooft.challenge.empresa.domain.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface BuscarEmpresasConTransferenciasRecientesUseCase {
    Page<Empresa> buscarEmpresasUltimoMes(LocalDate desde, Pageable pageable);
}
