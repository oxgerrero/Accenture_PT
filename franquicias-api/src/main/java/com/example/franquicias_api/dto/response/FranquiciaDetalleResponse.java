package com.example.franquicias_api.dto.response;

import java.util.List;

/**
 *
 * @author LEO
 */
public record FranquiciaDetalleResponse(
        Long id,
        String nombre,
        List<SucursalDetalleResponse> sucursales
) {
}

