package com.farmacia.dto;

public record UsuarioResponse(
        Long idUsuario,
        String nombreUsuario,
        String correo,
        String dni,
        String estado,
        String roles
) {
}
