package com.farmacia.service;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductoService {

    List<ProductoResponse> listadoProductos();
    ProductoResponse registrarProducto(ProductoRequest productoRequest, MultipartFile multipartFile) throws IOException;
    ProductoResponse actualizarProducto(Long idProducto, ProductoRequest productoRequest, MultipartFile multipartFile) throws  IOException;
    ProductoResponse buscarProducto(Long idProducto);
    void deshabilitarProducto(Long idProducto);
}
