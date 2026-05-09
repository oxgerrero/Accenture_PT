package com.example.franquicias_api.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author LEO
 */
public record CrearFranquiciaRequest(

        @NotBlank(message = "Requiere nombre de la franquicia")
        String nombre

) {
}