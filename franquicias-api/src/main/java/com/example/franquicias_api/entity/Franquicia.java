package com.example.franquicias_api.entity;

  
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LEO
 */
@Entity
@Table(name = "franquicia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Franquicia extends BaseEntity{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "franquicia",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Sucursal> sucursales = new ArrayList<>();
 
}
