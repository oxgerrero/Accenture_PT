package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.CrearFranquiciaRequest;
import com.example.franquicias_api.dto.request.CrearSucursalRequest;
import com.example.franquicias_api.dto.request.ModificarNombreRequest;
import com.example.franquicias_api.dto.response.FranquiciaDetalleResponse;
import com.example.franquicias_api.dto.response.FranquiciaResponse;
import com.example.franquicias_api.dto.response.ProductoDetalleResponse;
import com.example.franquicias_api.dto.response.SucursalDetalleResponse;
import com.example.franquicias_api.dto.response.SucursalResponse;
import com.example.franquicias_api.dto.response.TopProductoResponse;
import com.example.franquicias_api.entity.Franquicia;
import com.example.franquicias_api.entity.Producto;
import com.example.franquicias_api.entity.Sucursal;
import com.example.franquicias_api.exception.RecursoNoEncontradoException;
import com.example.franquicias_api.repository.FranquiciaRepository;
import com.example.franquicias_api.repository.SucursalRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LEO
 */
@Service
@RequiredArgsConstructor
@Transactional
public class FranquiciaServiceImpl implements FranquiciaService{
    
    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;

    /**
     *
     * @param request
     * @return
     */
    @Override
    public FranquiciaResponse crear(CrearFranquiciaRequest request) {

        Franquicia franquicia = Franquicia.builder()
                .nombre(request.nombre())
                .build();

        Franquicia guardado = franquiciaRepository.save(franquicia);

        return new FranquiciaResponse(
                guardado.getId(),
                guardado.getNombre()
        );
    }
    
    /**
     *
     * @param franquiciaId
     * @param request
     * @return
     */
    @Override
    public SucursalResponse añadirSucursal(
            Long franquiciaId,
            CrearSucursalRequest request
    ) {

        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("franquicia no encontrada"));

        Sucursal sucursal = Sucursal.builder()
                .nombre(request.nombre())
                .franquicia(franquicia)
                .build();

        Sucursal guardado = sucursalRepository.save(sucursal);

        return new SucursalResponse(
                guardado.getId(),
                guardado.getNombre()
        );
    }
    
    /**
     *
     * @param franquiciaId
     * @return
     */
    @Override
    public List<TopProductoResponse> getTopProducto(Long franquiciaId) {

        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Franquicia no encontrada"));

        return franquicia.getSucursales()
                .stream()
                .map(sucursal -> {

                    Producto topProduct = sucursal.getProductos()
                            .stream()
                            .max((a, b) ->
                                    Integer.compare(a.getDisponible(), b.getDisponible()))
                            .orElse(null);

                    if (topProduct == null) {
                        return null;
                    }

                    return new TopProductoResponse(
                            sucursal.getNombre(),
                            topProduct.getNombre(),
                            topProduct.getDisponible()
                    );
                })
                .filter(java.util.Objects::nonNull)
                .toList();
    }
    
    /**
     *
     * @param id
     * @param request
     * @return
     */
    @Override
    public FranquiciaResponse modificarNombre(
            Long id,
            ModificarNombreRequest request
    ) {

        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Franquicia no encontrada"));

        franquicia.setNombre(request.nombre());

        Franquicia modificado = franquiciaRepository.save(franquicia);

        return new FranquiciaResponse(
                modificado.getId(),
                modificado.getNombre()
        );
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<FranquiciaDetalleResponse> findAll() {

        return franquiciaRepository.findAllWithRelations()
                .stream()
                .map(franquicia -> new FranquiciaDetalleResponse(
                        franquicia.getId(),
                        franquicia.getNombre(),
                        franquicia.getSucursales()
                                .stream()
                                .map(sucursal -> new SucursalDetalleResponse(
                                        sucursal.getId(),
                                        sucursal.getNombre(),
                                        sucursal.getProductos()
                                                .stream()
                                                .map(producto -> new ProductoDetalleResponse(
                                                        producto.getId(),
                                                        producto.getNombre(),
                                                        producto.getDisponible()
                                                ))
                                                .toList()

                                ))
                                .toList()

                ))
                .toList();
    }
}
