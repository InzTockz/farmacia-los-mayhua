package com.farmacia.mapper;

import com.farmacia.dto.ClasificacionProductoResponse;
import com.farmacia.entity.ClasificacionProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClasificacionProductoMapper {

    List<ClasificacionProductoResponse> clasificacionToClasificacionEntity(List<ClasificacionProductoEntity> clasificacionProductoEntity);
}
