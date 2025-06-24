package com.farmacia.service;

import com.farmacia.dto.UsuarioRequest;
import com.farmacia.dto.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> listadoUsuarios();
    UsuarioResponse registrarUsuario (UsuarioRequest usuarioRequest);
    UsuarioResponse actualizarUsuario (Long idUsuario, UsuarioRequest usuarioRequest);
    UsuarioResponse buscarUsuario (Long id);
    void deshabilitarUsuario(Long id);
}
