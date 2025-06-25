package com.farmacia.dto;

public record CategoriaProductoResponse(
        Long idCategoria,
        String nombreCategoria,
        boolean estado
) {
}
