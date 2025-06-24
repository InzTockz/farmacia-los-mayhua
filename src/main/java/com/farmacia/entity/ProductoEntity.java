package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "fecha_fabricacion", nullable = false)
    @CreationTimestamp
    private LocalDate fechaFabricacion;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "presentacion_img", nullable = false)
    private String presentacionImg;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @JoinColumn(name = "id_categoria", nullable = false)
    @ManyToOne
    private CategoriaProductoEntity idCategoria;

    @JoinColumn(name = "id_clasificacion", nullable = false)
    @ManyToOne
    private ClasificacionProductoEntity idClasificacionProducto;

}
