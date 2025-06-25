package com.farmacia.mapper;

import com.farmacia.dto.UsuarioRequest;
import com.farmacia.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    //@Mapping(source = "", target = "")
    //UsuarioRequest UsuarioDtoToUsuarioEntity(UsuarioEntity usuarioEntity);
}
