package com.farmacia.service;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;

import java.util.List;

public interface ProductoService {

    List<ProductoResponse> listadoProductos();
    ProductoResponse registrarProducto(ProductoRequest productoRequest);
    ProductoResponse actualizarProducto(Long idProducto, ProductoRequest productoRequest);
    ProductoResponse buscarProducto(Long idProducto);
    void deshabilitarProducto(Long idProducto);
}
