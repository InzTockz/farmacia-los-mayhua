package com.farmacia.service.impl;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;
import com.farmacia.entity.ProductoEntity;
import com.farmacia.mapper.ProductoMapper;
import com.farmacia.repository.ProductoRepository;
import com.farmacia.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoMapper productoMapper, ProductoRepository productoRepository) {
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoResponse> listadoProductos() {
        return List.of();
    }

    @Override
    public ProductoResponse registrarProducto(ProductoRequest productoRequest) {
        return this.productoMapper.ToProductDto(this.productoRepository.save(this.productoMapper.ToProductoEntity(productoRequest)));
    }

    @Override
    public ProductoResponse actualizarProducto(Long idProducto, ProductoRequest productoRequest) {
        return null;
    }

    @Override
    public ProductoResponse buscarProducto(Long idProducto) {
        return null;
    }

    @Override
    public void deshabilitarProducto(Long idProducto) {

    }
}
