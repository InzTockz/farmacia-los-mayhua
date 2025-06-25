package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_clasificacion_producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionProductoEntity {

    @Id
    @Column(name = "id_clasificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasificacion;

    @Column(name = "nombre_clasificacion", nullable = false, length = 100)
    private String nombreClasificacion;

    @Column(name = "estado", nullable = false)
    private boolean estado;
}
