package com.farmacia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequest {

    private String nombreProducto;
    private LocalDate fechaFabricacion;
    private LocalDate fechaVencimiento;
    private int stock;
    private double precio;
    private Long idCategoria;
    private Long idClasificacionProducto;
}
