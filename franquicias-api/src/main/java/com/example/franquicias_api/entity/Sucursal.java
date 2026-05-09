package com.example.franquicias_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author LEO
 */

@Entity
@Table(name = "sucursal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sucursal extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franquicia_id")
    private Franquicia franquicia;

    @OneToMany(mappedBy = "sucursal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Producto> productos;

}
