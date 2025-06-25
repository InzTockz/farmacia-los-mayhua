package com.farmacia.dto;

public record ClasificacionProductoResponse (
        Long idClasificacion,
        String nombreClasificacion,
        boolean estado
){
}
