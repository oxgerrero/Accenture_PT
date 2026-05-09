package com.example.franquicias_api.repository;

import com.example.franquicias_api.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LEO
 */
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
