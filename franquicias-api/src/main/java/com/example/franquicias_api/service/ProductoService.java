package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.CrearProductoRequest;
import com.example.franquicias_api.dto.request.ModificarDisponibleRequest;
import com.example.franquicias_api.dto.response.ProductoResponse;

/**
 *
 * @author LEO
 */
public interface ProductoService {
    
    ProductoResponse crear(Long sucursalId, CrearProductoRequest request);

    void eliminar(Long productoId);

    ProductoResponse modificarDisponible(
            Long productoId,
            ModificarDisponibleRequest request
    );
}
