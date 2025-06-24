package com.farmacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity {

    @Id
    @Column(name = "id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(name = "importe_total", nullable = false)
    private double importeTotal;

    @Column(name = "")
}
