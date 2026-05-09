package com.example.franquicias_api.controller;

import com.example.franquicias_api.dto.request.ModificarNombreRequest;
import com.example.franquicias_api.dto.response.SucursalResponse;
import com.example.franquicias_api.service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author LEO
 */
@RestController
@RequestMapping("/api/sucursal")
@RequiredArgsConstructor
@Tag(name = "Sucursal", description = "Administrar Endpoint Sucursal")
public class SucursalController {
    private final SucursalService sucursalService;

    @PutMapping("/{sucursalId}/nombre")
    @Operation(summary = "Modificar nombre Sucursal")
    public SucursalResponse modificarNombre(
            @PathVariable Long sucursalId,
            @Valid @RequestBody ModificarNombreRequest request
    ) {

        return sucursalService.modificarNombre(sucursalId, request);
    }
}
