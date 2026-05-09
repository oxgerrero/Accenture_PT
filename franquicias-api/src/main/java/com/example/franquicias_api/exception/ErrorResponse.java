package com.example.franquicias_api.exception;

import java.time.LocalDateTime;

/**
 *
 * @author LEO
 */

public record ErrorResponse(

        LocalDateTime timestamp,
        int estado,
        String error

) {
}
