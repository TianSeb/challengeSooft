package com.sooft.challenge.empresa.application;

import com.sooft.challenge.empresa.domain.model.Empresa;
import com.sooft.challenge.empresa.domain.port.input.RegistrarEmpresaUseCase;
import com.sooft.challenge.empresa.domain.port.output.EmpresaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrarEmpresaService implements RegistrarEmpresaUseCase {

    private final EmpresaRepositoryPort empresaRepositoryPort;

    @Override
    @Transactional
    public Empresa registrarEmpresa(Empresa empresa) {
        return empresaRepositoryPort.registrarEmpresa(empresa);
    }
}
