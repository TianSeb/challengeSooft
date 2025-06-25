package com.sooft.challenge.empresa.domain.model;

import java.math.BigDecimal;

public record Transferencia(
        Long id,
        Long empresaId,
        String cuentaDebito,
        String cuentaCredito,
        BigDecimal importe
) {}
