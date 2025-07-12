package com.farmacia.dto;

import java.time.LocalDate;

public record ProductoResponse (
        Long idProducto,
        String nombreProducto,
        LocalDate fechaFabricacion,
        LocalDate fechaVencimiento,
        int stock,
        double precio,
        String presentacionImg,
        boolean estado,
        Long idCategoria,
        String nombreCategoria,
        Long idClasificacionProducto
){
}
