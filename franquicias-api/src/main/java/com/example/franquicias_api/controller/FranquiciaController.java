package com.example.franquicias_api.controller;

import com.example.franquicias_api.dto.request.CrearFranquiciaRequest;
import com.example.franquicias_api.dto.request.CrearSucursalRequest;
import com.example.franquicias_api.dto.request.ModificarNombreRequest;
import com.example.franquicias_api.dto.response.FranquiciaResponse;
import com.example.franquicias_api.dto.response.SucursalResponse;
import com.example.franquicias_api.dto.response.TopProductoResponse;
import com.example.franquicias_api.service.FranquiciaService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author LEO
 */
@RestController
@RequestMapping("/api/franquicia")
@RequiredArgsConstructor
public class FranquiciaController {
    private final FranquiciaService franquiciaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FranquiciaResponse crear(
            @Valid @RequestBody CrearFranquiciaRequest request
    ) {

        return franquiciaService.crear(request);
    }
    
    @PostMapping("/{franquiciaId}/sucursal")
    @ResponseStatus(HttpStatus.CREATED)
    public SucursalResponse añadirSucursal(
            @PathVariable Long franquiciaId,
            @Valid @RequestBody CrearSucursalRequest request
    ) {

        return franquiciaService.añadirSucursal(franquiciaId, request);
    }
    
    @GetMapping("/{franquiciaId}/top-disponible-productos")
    public List<TopProductoResponse> getTopProducto(
            @PathVariable Long franquiciaId
    ) {

        return franquiciaService.getTopProducto(franquiciaId);
    }
    
    @PutMapping("/{id}/nombre")
    public FranquiciaResponse modificarNombre(
            @PathVariable Long id,
            @Valid @RequestBody ModificarNombreRequest request
    ) {

        return franquiciaService.modificarNombre(id, request);
    }
}