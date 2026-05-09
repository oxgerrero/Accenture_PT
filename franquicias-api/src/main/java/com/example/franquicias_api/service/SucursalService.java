package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.ModificarNombreRequest;
import com.example.franquicias_api.dto.response.SucursalResponse;

/**
 *
 * @author LEO
 */
public interface SucursalService {

    /**
     *
     * @param sucursalId
     * @param request
     * @return
     */
    SucursalResponse modificarNombre(
            Long sucursalId,
            ModificarNombreRequest request
    );
}
