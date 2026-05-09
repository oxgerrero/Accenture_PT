package com.example.franquicias_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 *
 * @author LEO
 */
public record CrearProductoRequest(

        @NotBlank(message = "Requiere nombre del producto")
        String nombre,

        @NotNull(message = "Requiere disponible")
        @Min(value = 0, message = "Disponible no puede ser negativo")
        Integer disponible

) {
}