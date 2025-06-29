package com.farmacia.service.impl;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;
import com.farmacia.entity.ProductoEntity;
import com.farmacia.mapper.ProductoMapper;
import com.farmacia.repository.ProductoRepository;
import com.farmacia.service.ProductoService;
import com.farmacia.utils.UploadImage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;
    private UploadImage uploadImage;

    public ProductoServiceImpl(ProductoMapper productoMapper, ProductoRepository productoRepository) {
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoResponse> listadoProductos() {
        return List.of();
    }

    @Override
    public ProductoResponse registrarProducto(ProductoRequest productoRequest, MultipartFile multipartFile) throws IOException {
        if(productoRequest!=null){
            productoRequest.setPresentacionImg(this.uploadImage.upload(multipartFile));
            return this.productoMapper.ToProductDto(this.productoRepository.save(this.productoMapper.ToProductoEntity(productoRequest)));
        } else {
            return null;
        }
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
