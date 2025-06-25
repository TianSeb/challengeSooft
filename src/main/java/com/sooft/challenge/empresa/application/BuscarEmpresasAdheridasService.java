package com.sooft.challenge.empresa.application;

import com.sooft.challenge.empresa.domain.port.input.BuscarEmpresasAdheridasUseCase;
import com.sooft.challenge.empresa.domain.port.output.EmpresaRepositoryPort;
import com.sooft.challenge.empresa.domain.model.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BuscarEmpresasAdheridasService implements BuscarEmpresasAdheridasUseCase {

    private final EmpresaRepositoryPort empresaRepositoryPort;

    @Override
    public Page<Empresa> buscarEmpresasDesde(LocalDate desde, Pageable pageable) {
        return empresaRepositoryPort.buscarEmpresasDesde(desde, pageable);
    }
}
