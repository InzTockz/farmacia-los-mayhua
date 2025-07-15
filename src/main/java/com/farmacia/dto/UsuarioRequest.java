package com.farmacia.dto;

import com.farmacia.entity.Roles;

public record UsuarioRequest (
        String nombreUsuario,
        String correo,
        String dni
) {
}
