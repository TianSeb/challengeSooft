package com.sooft.challenge.transferencia.adapter.in;

import com.sooft.challenge.empresa.adapter.mapper.EmpresaMapper;
import com.sooft.challenge.empresa.domain.model.Empresa;
import com.sooft.challenge.transferencia.domain.port.input.BuscarEmpresasConTransferenciasRecientesUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TransferenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BuscarEmpresasConTransferenciasRecientesUseCase useCase;

    @MockitoSpyBean
    private EmpresaMapper mapper;

    @Test
    void deberiaRetornarEmpresasConTransferenciasPaginadas() throws Exception {
        Empresa empresa = new Empresa(1L, "20304050607", "Test S.A.",
                LocalDate.now().minusDays(15));
        Page<Empresa> page = new PageImpl<>(List.of(empresa), PageRequest.of(0, 10), 1);

        when(useCase.buscarEmpresasUltimoMes(any(), any())).thenReturn(page);

        mockMvc.perform(get("/transferencias/ultimos-30-dias")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].cuit").value("20304050607"))
                .andExpect(jsonPath("$.totalElements").value(1));
    }
}