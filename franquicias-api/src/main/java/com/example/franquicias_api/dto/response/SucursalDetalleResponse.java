package com.example.franquicias_api.dto.response;

import java.util.List;

/**
 *
 * @author LEO
 */
public record SucursalDetalleResponse (
        Long id,
        String nombre,
        List<ProductoDetalleResponse> productos
) {
}
