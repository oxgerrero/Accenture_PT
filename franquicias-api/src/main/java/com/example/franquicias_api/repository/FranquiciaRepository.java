package com.example.franquicias_api.repository;

import com.example.franquicias_api.entity.Franquicia;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LEO
 */
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
    @Query("""
        SELECT DISTINCT f
        FROM Franquicia f
        LEFT JOIN FETCH f.sucursales b
        LEFT JOIN FETCH b.productos
    """)
    List<Franquicia> findAllWithRelations();
}
