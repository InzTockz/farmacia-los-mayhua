package com.farmacia.dto;

import java.time.LocalDate;

public record ProductoResponse (
        Long idProducto,
        String nombreProducto,
        LocalDate fechaFabricacion,
        LocalDate fechaVencimiento,
        int stock,
        String presentacionImg,
        boolean estado,
        Long idCategoria,
        Long idClasificacionProducto
){
}
