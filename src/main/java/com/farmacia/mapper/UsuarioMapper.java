package com.farmacia.mapper;

import com.farmacia.dto.UsuarioRequest;
import com.farmacia.dto.UsuarioResponse;
import com.farmacia.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    List<UsuarioResponse> usuarioResponseToUsuarioEntityList(List<UsuarioEntity> usuarioEntities);

    UsuarioResponse usuarioResponseToUsuarioEntity(UsuarioEntity usuarioEntity);

    UsuarioEntity usuarioEntityToUsuarioRequest(UsuarioRequest usuarioRequest);
}
