package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.ModificarNombreRequest;
import com.example.franquicias_api.dto.response.SucursalResponse;
import com.example.franquicias_api.entity.Sucursal;
import com.example.franquicias_api.exception.RecursoNoEncontradoException;
import com.example.franquicias_api.repository.SucursalRepository;
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
public class SucursalServiceImpl implements SucursalService{
    private final SucursalRepository sucursalRepository;

    @Override
    public SucursalResponse modificarNombre(
            Long sucursalId,
            ModificarNombreRequest request
    ) {

        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Sucursal no encontrada"));

        sucursal.setNombre(request.nombre());

        Sucursal modificado = sucursalRepository.save(sucursal);

        return new SucursalResponse(
                modificado.getId(),
                modificado.getNombre()
        );
    }
}
