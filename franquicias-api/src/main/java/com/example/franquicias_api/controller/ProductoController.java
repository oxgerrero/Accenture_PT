package com.example.franquicias_api.controller;

import com.example.franquicias_api.dto.request.CrearProductoRequest;
import com.example.franquicias_api.dto.request.ModificarDisponibleRequest;
import com.example.franquicias_api.dto.request.ModificarNombreRequest;
import com.example.franquicias_api.dto.response.ProductoResponse;
import com.example.franquicias_api.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @author LEO
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Producto", description = "Administrar Endpoint Productos")
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping("/sucursal/{sucursalId}/producto")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear Prodcuto")
    public ProductoResponse crear(
            @PathVariable Long sucursalId,
            @Valid @RequestBody CrearProductoRequest request
    ) {

        return productoService.crear(sucursalId, request);
    }

    @DeleteMapping("/producto/{productoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar Producto")
    public void eliminar(
            @PathVariable Long productoId
    ) {

        productoService.eliminar(productoId);
    }

    @PatchMapping("/producto/{productoId}/disponible")
    @Operation(summary = "Modificar el disponible por Producto")
    public ProductoResponse modificarDisponible(
            @PathVariable Long productoId,
            @Valid @RequestBody ModificarDisponibleRequest request
    ) {

        return productoService.modificarDisponible(productoId, request);
    }
    
    @PutMapping("/producto/{productoId}/nombre")
    @Operation(summary = "Modificar nombre Producto")
    public ProductoResponse modificarNombre(
            @PathVariable Long productoId,
            @Valid @RequestBody ModificarNombreRequest request
    ) {

        return productoService.modificarNombre(productoId, request);
    }
}
