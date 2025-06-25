package com.sooft.challenge.empresa.domain.port.input;

import com.sooft.challenge.empresa.domain.model.Empresa;

public interface RegistrarEmpresaUseCase {
    Empresa registrarEmpresa(Empresa empresa);
}
