package com.farmacia.dto;

public record ClasificacionProductoResponse (
        Long idClasificacion,
        String nombre_clasificacion,
        boolean estado
){
}
