package com.example.franquicias_api.dto.response;


/**
 *
 * @author LEO
 */
public record TopProductoResponse(

        String sucursalNombre,
        String productoNombre,
        Integer disponible

) {
}