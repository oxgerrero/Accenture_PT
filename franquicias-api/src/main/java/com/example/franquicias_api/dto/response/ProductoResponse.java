package com.example.franquicias_api.dto.response;

/**
 *
 * @author LEO
 */
public record ProductoResponse  (

        Long id,
        String nombre,
        Integer disponible

) {
}
