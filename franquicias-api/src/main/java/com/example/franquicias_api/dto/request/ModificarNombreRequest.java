package com.example.franquicias_api.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author LEO
 */
public record ModificarNombreRequest(

        @NotBlank(message = "Requiere nombre")
        String nombre

) {
}
