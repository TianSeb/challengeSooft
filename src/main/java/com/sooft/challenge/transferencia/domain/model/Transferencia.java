package com.sooft.challenge.transferencia.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transferencia(
        Long id,
        Long empresaId,
        String cuentaDebito,
        String cuentaCredito,
        BigDecimal importe,
        LocalDate fecha
) {}
