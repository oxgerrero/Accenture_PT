package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.CrearFranquiciaRequest;
import com.example.franquicias_api.dto.response.FranquiciaResponse;
import com.example.franquicias_api.entity.Franquicia;
import com.example.franquicias_api.repository.FranquiciaRepository;
import com.example.franquicias_api.repository.SucursalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FranquiciaServiceImplTest {

    @Mock
    private FranquiciaRepository franquiciaRepository;

    @Mock
    private SucursalRepository sucursalRepository;

    @InjectMocks
    private FranquiciaServiceImpl franchiseService;

    @Test
    void shouldCreateFranchiseSuccessfully() {

        CrearFranquiciaRequest request =
                new CrearFranquiciaRequest("McDonalds");

        Franquicia franchise = Franquicia.builder()
                .id(1L)
                .nombre("McDonalds")
                .build();

        when(franquiciaRepository.save(any(Franquicia.class)))
                .thenReturn(franchise);

        FranquiciaResponse response =
                franchiseService.crear(request);

        assertEquals(1L, response.id());
        assertEquals("McDonalds", response.nombre());
    }
}