package com.sooft.challenge.transferencia.application;

import com.sooft.challenge.empresa.domain.model.Empresa;
import com.sooft.challenge.transferencia.domain.port.input.BuscarEmpresasConTransferenciasRecientesUseCase;
import com.sooft.challenge.transferencia.domain.port.output.TransferenciaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TransferenciaService implements BuscarEmpresasConTransferenciasRecientesUseCase {

    private final TransferenciaRepositoryPort transferenciaRepositoryPort;

    @Override
    public Page<Empresa> buscarEmpresasUltimoMes(LocalDate desde, Pageable pageable) {
        return transferenciaRepositoryPort.buscarEmpresasConTransferenciasDesde(desde, pageable);
    }
}
