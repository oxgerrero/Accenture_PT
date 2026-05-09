package com.example.franquicias_api.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author LEO
 */
public record CrearSucursalRequest (

        @NotBlank(message = "Requiere nombre de la sucursal")
        String name

) {
}