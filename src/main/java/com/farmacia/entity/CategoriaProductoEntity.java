package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_categoria_producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProductoEntity {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "nombre_categoria", nullable = false, length = 150)
    private String nombreCategoria;

    @Column(name = "estado", nullable = false)
    private boolean estado;
}
