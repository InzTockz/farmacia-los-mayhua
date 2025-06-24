package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_detalle_venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaEntity {

    @Id
    @Column(name = "id_detalle_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVenta;

    @JoinColumn(name = "id_venta", nullable = false)
    @ManyToOne
    private VentaEntity idVenta;

    @JoinColumn(name = "id_producto", nullable = false)
    @ManyToOne
    private ProductoEntity idProducto;
}
