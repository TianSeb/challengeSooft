package com.sooft.challenge.transferencia.adapter.in;

import com.sooft.challenge.empresa.adapter.mapper.EmpresaMapper;
import com.sooft.challenge.common.dto.PagedResponse;
import com.sooft.challenge.transferencia.domain.port.input.BuscarEmpresasConTransferenciasRecientesUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/transferencias")
@RequiredArgsConstructor
@Slf4j
public class TransferenciaController {

    private final BuscarEmpresasConTransferenciasRecientesUseCase useCase;
    private final EmpresaMapper mapper;

    @GetMapping("/ultimos-30-dias")
    public PagedResponse buscarEmpresasConTransferencias(@PageableDefault Pageable pageable) {
        var desde = LocalDate.now().minusDays(30);
        var page = useCase.buscarEmpresasUltimoMes(desde, pageable);

        return new PagedResponse(
                page.getContent().stream()
                        .map(mapper::domainToDTO)
                        .toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements()
        );
    }
}
