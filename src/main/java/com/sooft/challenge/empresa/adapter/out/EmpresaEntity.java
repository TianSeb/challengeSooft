package com.sooft.challenge.empresa.adapter.out;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "empresa")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cuit;

    @Column(nullable = false)
    private String razonSocial;

    @Column(nullable = false)
    private LocalDate fechaAdhesion;
}
