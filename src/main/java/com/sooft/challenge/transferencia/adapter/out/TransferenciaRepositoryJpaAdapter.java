package com.sooft.challenge.transferencia.adapter.out;

import com.sooft.challenge.empresa.adapter.mapper.EmpresaMapper;
import com.sooft.challenge.empresa.domain.model.Empresa;
import com.sooft.challenge.transferencia.domain.port.output.TransferenciaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TransferenciaRepositoryJpaAdapter implements TransferenciaRepositoryPort {

    private final TransferenciaJpaRepository repository;
    private final EmpresaMapper mapper;

    @Override
    public Page<Empresa> buscarEmpresasConTransferenciasDesde(LocalDate desde, Pageable pageable) {
        return repository
                .findEmpresasConTransferenciasDesde(desde, pageable)
                .map(mapper::entityToDomain);
    }
}
