package com.farmacia.dto;

import java.time.LocalDate;

public record ProductoRequest(
        String nombreProducto,
        LocalDate fechaFabricacion,
        LocalDate fechaVencimiento,
        int stock,
        double precio,
        String presentacionImg,
        boolean estado,
        Long idCategoria,
        Long idClasificacionProducto
) {
}
