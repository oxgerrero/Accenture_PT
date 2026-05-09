package com.example.franquicias_api.controller;

import com.example.franquicias_api.dto.request.CrearProductoRequest;
import com.example.franquicias_api.dto.request.ModificarDisponibleRequest;
import com.example.franquicias_api.dto.response.ProductoResponse;
import com.example.franquicias_api.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author LEO
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping("/sucursal/{sucursalId}/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponse crear(
            @PathVariable Long sucursalId,
            @Valid @RequestBody CrearProductoRequest request
    ) {

        return productoService.crear(sucursalId, request);
    }

    @DeleteMapping("/producto/{productoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(
            @PathVariable Long productoId
    ) {

        productoService.eliminar(productoId);
    }

    @PatchMapping("/producto/{productoId}/disponible")
    public ProductoResponse modificarDisponible(
            @PathVariable Long productoId,
            @Valid @RequestBody ModificarDisponibleRequest request
    ) {

        return productoService.modificarDisponible(productoId, request);
    }
}
