package com.sooft.challenge.empresa.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record EmpresaDTO(
        String cuit,
        String razonSocial,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate fechaAdhesion
) {
}
