package com.CoWork.CoWork.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "espacios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(name = "precio_hora")
    private Double precioHora;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "nombre_sede")
    private String nombreSede;
}