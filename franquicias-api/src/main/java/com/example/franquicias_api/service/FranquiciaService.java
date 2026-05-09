package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.CrearFranquiciaRequest;
import com.example.franquicias_api.dto.request.CrearSucursalRequest;
import com.example.franquicias_api.dto.request.ModificarNombreRequest;
import com.example.franquicias_api.dto.response.FranquiciaDetalleResponse;
import com.example.franquicias_api.dto.response.FranquiciaResponse;
import com.example.franquicias_api.dto.response.SucursalResponse;
import com.example.franquicias_api.dto.response.TopProductoResponse;
import java.util.List;

/**
 *
 * @author LEO
 */

public interface FranquiciaService {

    FranquiciaResponse crear(CrearFranquiciaRequest request);
    SucursalResponse añadirSucursal(Long franquiciaId, CrearSucursalRequest request);
    List<TopProductoResponse> getTopProducto(Long franquiciaId);
    FranquiciaResponse modificarNombre(Long id, ModificarNombreRequest request);
    List<FranquiciaDetalleResponse> findAll();
}