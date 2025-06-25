package com.sooft.challenge.empresa.domain.port.output;

import com.sooft.challenge.empresa.domain.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface EmpresaRepositoryPort {

    Empresa registrarEmpresa(Empresa empresa);

    Page<Empresa> buscarEmpresasDesde(LocalDate desde, Pageable pageable);
}
