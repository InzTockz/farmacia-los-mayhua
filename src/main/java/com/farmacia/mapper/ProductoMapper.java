package com.farmacia.mapper;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;
import com.farmacia.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductoMapper {

    //@Mapping(source = "idCategoria", target = "idCategoria.idCategoria")
    //@Mapping(source = "idClasificacionProducto", target = "idClasificacionProducto.idClasificacion")
    //@Mapping(source = )
    List<ProductoResponse> ToProductoDtoListado(List<ProductoEntity> productoEntities);

    @Mapping(target = "idCategoria", source = "idCategoria.idCategoria")
    @Mapping(target = "idClasificacionProducto", source = "idClasificacionProducto.idClasificacion")
    @Mapping(target = "nombreCategoria", source = "idCategoria.nombreCategoria")
    ProductoResponse ToProductResponseDto(ProductoEntity productoEntity);

    @Mapping(target = "idCategoria", source = "idCategoria.idCategoria")
    @Mapping(target = "idClasificacionProducto", source = "idClasificacionProducto.idClasificacion")
    ProductoRequest ToProductRequestDto(ProductoEntity productoEntity);

    @Mapping(target = "idCategoria.idCategoria", source = "idCategoria")
    @Mapping(target = "idClasificacionProducto.idClasificacion", source = "idClasificacionProducto")
    ProductoEntity ToProductoEntity(ProductoRequest productoRequest);
}
