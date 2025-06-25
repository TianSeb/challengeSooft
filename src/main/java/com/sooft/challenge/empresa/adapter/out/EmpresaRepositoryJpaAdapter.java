package com.sooft.challenge.empresa.adapter.out;

import com.sooft.challenge.empresa.adapter.mapper.EmpresaMapper;
import com.sooft.challenge.empresa.domain.model.Empresa;
import com.sooft.challenge.empresa.domain.port.output.EmpresaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class EmpresaRepositoryJpaAdapter implements EmpresaRepositoryPort {

    private final EmpresaJpaRepository repository;
    private final EmpresaMapper mapper;

    @Override
    public Empresa registrarEmpresa(Empresa empresa) {
        var empresaEntity = mapper.domainToEntity(empresa);
        var savedEmpresa = repository.save(empresaEntity);

        return mapper.entityToDomain(savedEmpresa);
    }

    @Override
    public Page<Empresa> buscarEmpresasDesde(LocalDate desde, Pageable pageable) {
        return repository.findByFechaAdhesionGreaterThanEqual(desde, pageable)
                .map(mapper::entityToDomain);
    }
}
