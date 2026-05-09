package com.example.franquicias_api.dto.response;

/**
 *
 * @author LEO
 */
public record ProductoDetalleResponse (
        Long id,
        String nombre,
        Integer disponible
) {
}
