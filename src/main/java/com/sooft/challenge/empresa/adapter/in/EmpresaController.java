package com.sooft.challenge.empresa.adapter.in;

import com.sooft.challenge.empresa.adapter.in.dto.EmpresaDTO;
import com.sooft.challenge.common.dto.PagedResponse;
import com.sooft.challenge.empresa.adapter.in.dto.EmpresaRegistroDTO;
import com.sooft.challenge.empresa.adapter.mapper.EmpresaMapper;
import com.sooft.challenge.empresa.domain.port.input.BuscarEmpresasAdheridasUseCase;
import com.sooft.challenge.empresa.domain.port.input.RegistrarEmpresaUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
@Slf4j
public class EmpresaController {

    private final RegistrarEmpresaUseCase registrarEmpresaUseCase;
    private final BuscarEmpresasAdheridasUseCase buscarEmpresasAdheridasUseCase;
    private final EmpresaMapper mapper;

    @PostMapping
    public ResponseEntity<EmpresaDTO> registrar(@RequestBody @Valid EmpresaRegistroDTO request) {
        var empresa = mapper.registroDtoToDomain(request);
        var creada = registrarEmpresaUseCase.registrarEmpresa(empresa);
        var response = mapper.domainToDTO(creada);

        return ResponseEntity
                .created(URI.create("/empresas/" + creada.id()))
                .body(response);
    }

    @GetMapping("/adhesion/ultimos-30-dias")
    public PagedResponse<EmpresaDTO> buscarEmpresasAdheridas(@PageableDefault Pageable pageable) {
        var desde = LocalDate.now().minusDays(30);
        var page = buscarEmpresasAdheridasUseCase.buscarEmpresasDesde(desde, pageable);

        return new PagedResponse<>(
                page.getContent().stream()
                        .map(mapper::domainToDTO)
                        .toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements()
        );
    }
}
