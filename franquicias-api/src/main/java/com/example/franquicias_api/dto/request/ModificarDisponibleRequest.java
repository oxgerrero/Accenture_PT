package com.example.franquicias_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


/**
 *
 * @author LEO
 */
public record ModificarDisponibleRequest(

        @NotNull(message = "Requiere disponible")
        @Min(value = 0, message = "Disponible no puede ser negativo")
        Integer disponible

) {
}