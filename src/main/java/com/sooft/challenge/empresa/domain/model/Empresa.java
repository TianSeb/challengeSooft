package com.sooft.challenge.empresa.domain.model;

import java.time.LocalDate;

public record Empresa(Long id, String cuit, String razonSocial, LocalDate fechaAdhesion) {
}
