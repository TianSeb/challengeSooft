package com.sooft.challenge.transferencia.adapter.out;

import com.sooft.challenge.empresa.adapter.out.EmpresaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transferencia")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal importe;

    @Column(name = "cuenta_debito", nullable = false)
    private String cuentaDebito;

    @Column(name = "cuenta_credito", nullable = false)
    private String cuentaCredito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaEntity empresa;
}
