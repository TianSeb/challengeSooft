package com.sooft.challenge.empresa.adapter.mapper;

import com.sooft.challenge.empresa.adapter.in.dto.EmpresaDTO;
import com.sooft.challenge.empresa.adapter.in.dto.EmpresaRegistroDTO;
import com.sooft.challenge.empresa.adapter.out.EmpresaEntity;
import com.sooft.challenge.empresa.domain.model.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmpresaMapper {

    Empresa entityToDomain(EmpresaEntity empresaEntity);

    EmpresaEntity domainToEntity(Empresa empresa);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaAdhesion", expression = "java(java.time.LocalDate.now())")
    Empresa registroDtoToDomain(EmpresaRegistroDTO empresaRegistroDTO);

    EmpresaDTO domainToDTO(Empresa empresa);
}
