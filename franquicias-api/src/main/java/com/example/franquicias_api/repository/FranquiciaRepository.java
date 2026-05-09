package com.example.franquicias_api.repository;

import com.example.franquicias_api.entity.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LEO
 */
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
    
}
