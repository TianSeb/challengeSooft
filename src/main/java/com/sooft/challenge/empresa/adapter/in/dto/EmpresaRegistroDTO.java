package com.sooft.challenge.empresa.adapter.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmpresaRegistroDTO(
        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "El CUIT debe tener 11 dígitos")
        String cuit,

        @NotBlank(message = "La razón social es obligatoria")
        String razonSocial
) {}
