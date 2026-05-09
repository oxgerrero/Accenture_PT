package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.CrearProductoRequest;
import com.example.franquicias_api.dto.request.ModificarDisponibleRequest;
import com.example.franquicias_api.dto.response.ProductoResponse;
import com.example.franquicias_api.entity.Producto;
import com.example.franquicias_api.entity.Sucursal;
import com.example.franquicias_api.exception.RecursoNoEncontradoException;
import com.example.franquicias_api.repository.ProductoRepository;
import com.example.franquicias_api.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author LEO
 */
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;

    @Override
    public ProductoResponse crear(
            Long sucursalId,
            CrearProductoRequest request
    ) {

        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Sucursal no encontrada"));

        Producto producto = Producto.builder()
                .nombre(request.nombre())
                .disponible(request.disponible())
                .sucursal(sucursal)
                .build();

        Producto guardado = productoRepository.save(producto);

        return new ProductoResponse(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getDisponible()
        );
    }

    @Override
    public void eliminar(Long productoId) {

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Producto no encontrado"));

        productoRepository.delete(producto);
    }

    @Override
    public ProductoResponse modificarDisponible(
            Long productoId,
            ModificarDisponibleRequest request
    ) {

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Producto no encontrado"));

        producto.setDisponible(request.disponible());

        Producto modificado = productoRepository.save(producto);

        return new ProductoResponse(
                modificado.getId(),
                modificado.getNombre(),
                modificado.getDisponible()
        );
    }
}
