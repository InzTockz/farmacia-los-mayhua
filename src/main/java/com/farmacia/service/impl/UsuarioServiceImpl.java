package com.farmacia.service.impl;

import com.farmacia.dto.UsuarioRequest;
import com.farmacia.dto.UsuarioResponse;
import com.farmacia.entity.Roles;
import com.farmacia.entity.UsuarioEntity;
import com.farmacia.mapper.UsuarioMapper;
import com.farmacia.repository.UsuarioRepository;
import com.farmacia.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioResponse> listadoUsuarios() {
        return this.usuarioMapper.usuarioResponseToUsuarioEntityList(usuarioRepository.findAll());
    }

    @Override
    public UsuarioResponse registrarUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity usuario = this.usuarioMapper.usuarioEntityToUsuarioRequest(usuarioRequest);
        usuario.setEstado(true);
        usuario.setRoles(Roles.CLIENTE);
        return this.usuarioMapper.usuarioResponseToUsuarioEntity(this.usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponse actualizarUsuario(Long idUsuario, UsuarioRequest usuarioRequest) {
        if(idUsuario!=null){
            UsuarioEntity usuario = this.usuarioRepository.findById(idUsuario).get();
            usuario.setNombreUsuario(usuarioRequest.nombreUsuario());
            usuario.setCorreo(usuarioRequest.correo());
            usuario.setDni(usuarioRequest.dni());
            return this.usuarioMapper.usuarioResponseToUsuarioEntity(this.usuarioRepository.save(usuario));
        } else {
            return null;
        }
    }

    @Override
    public UsuarioResponse buscarUsuario(Long id) {
        return this.usuarioMapper.usuarioResponseToUsuarioEntity(this.usuarioRepository.findById(id).get());
    }

    @Override
    public void deshabilitarUsuario(Long id) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(id).get();
        usuarioEntity.setEstado(false);
        this.usuarioRepository.save(usuarioEntity);
    }
}
