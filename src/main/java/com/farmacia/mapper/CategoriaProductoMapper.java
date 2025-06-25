package com.farmacia.mapper;

import com.farmacia.dto.CategoriaProductoResponse;
import com.farmacia.entity.CategoriaProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoriaProductoMapper {

    List<CategoriaProductoResponse> listCategoriaDtoToCategoriaEntity (List<CategoriaProductoEntity> categoriaProductoEntities);
}
