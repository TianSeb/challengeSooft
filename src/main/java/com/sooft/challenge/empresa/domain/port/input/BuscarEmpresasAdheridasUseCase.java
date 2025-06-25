package com.sooft.challenge.empresa.domain.port.input;

import com.sooft.challenge.empresa.domain.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface BuscarEmpresasAdheridasUseCase {
    Page<Empresa> buscarEmpresasDesde(LocalDate desde, Pageable pageable);
}
