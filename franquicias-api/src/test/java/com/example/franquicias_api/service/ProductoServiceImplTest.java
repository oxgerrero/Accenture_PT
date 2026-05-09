package com.example.franquicias_api.service;

import com.example.franquicias_api.dto.request.CrearProductoRequest;
import com.example.franquicias_api.dto.request.ModificarDisponibleRequest;
import com.example.franquicias_api.dto.response.ProductoResponse;
import com.example.franquicias_api.entity.Producto;
import com.example.franquicias_api.entity.Sucursal;
import com.example.franquicias_api.exception.RecursoNoEncontradoException;
import com.example.franquicias_api.repository.ProductoRepository;
import com.example.franquicias_api.repository.SucursalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private SucursalRepository sucursalRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    void shouldCreateProductSuccessfully() {

        Long branchId = 1L;

        CrearProductoRequest request =
                new CrearProductoRequest("Big Mac", 50);

        Sucursal branch = Sucursal.builder()
                .id(branchId)
                .nombre("Sucursal Norte")
                .build();

        Producto product = Producto.builder()
                .id(1L)
                .nombre("Big Mac")
                .disponible(50)
                .sucursal(branch)
                .build();

        when(sucursalRepository.findById(branchId))
                .thenReturn(Optional.of(branch));

        when(productoRepository.save(any(Producto.class)))
                .thenReturn(product);

        ProductoResponse response =
                productoService.crear(branchId, request);

        assertNotNull(response);

        assertEquals("Big Mac", response.nombre());
        assertEquals(50, response.disponible());

        verify(productoRepository, times(1))
                .save(any(Producto.class));
    }

    @Test
    void shouldThrowExceptionWhenBranchNotFound() {

        Long branchId = 1L;

        CrearProductoRequest request =
                new CrearProductoRequest("Big Mac", 50);

        when(sucursalRepository.findById(branchId))
                .thenReturn(Optional.empty());

        assertThrows(
                RecursoNoEncontradoException.class,
                () -> productoService.crear(branchId, request)
        );

        verify(productoRepository, never()).save(any());
    }

    @Test
    void shouldUpdateStockSuccessfully() {

        Long productId = 1L;

        Producto product = Producto.builder()
                .id(productId)
                .nombre("Big Mac")
                .disponible(20)
                .build();

        ModificarDisponibleRequest request =
                new ModificarDisponibleRequest(100);

        when(productoRepository.findById(productId))
                .thenReturn(Optional.of(product));

        when(productoRepository.save(any(Producto.class)))
                .thenReturn(product);

        ProductoResponse response =
                productoService.modificarDisponible(productId, request);

        assertEquals(100, response.disponible());

        verify(productoRepository, times(1)).save(product);
    }

    @Test
    void shouldDeleteProductSuccessfully() {

        Long productId = 1L;

        Producto product = Producto.builder()
                .id(productId)
                .nombre("Big Mac")
                .disponible(20)
                .build();

        when(productoRepository.findById(productId))
                .thenReturn(Optional.of(product));

        productoService.eliminar(productId);

        verify(productoRepository, times(1))
                .delete(product);
    }
}