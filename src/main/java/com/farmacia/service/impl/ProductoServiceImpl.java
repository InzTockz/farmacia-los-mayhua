package com.farmacia.service.impl;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;
import com.farmacia.entity.CategoriaProductoEntity;
import com.farmacia.entity.ClasificacionProductoEntity;
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
    private final UploadImage uploadImage;

    public ProductoServiceImpl(ProductoMapper productoMapper, ProductoRepository productoRepository, UploadImage uploadImage) {
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
        this.uploadImage = uploadImage;
    }

    @Override
    public List<ProductoResponse> listadoProductos() {
        return this.productoMapper.ToProductoDtoListado(this.productoRepository.findAll());
    }

    @Override
    public ProductoResponse registrarProducto(ProductoRequest productoRequest, MultipartFile multipartFile) throws IOException {
        if(productoRequest!=null){
            ProductoEntity productoEntity = this.productoMapper.ToProductoEntity(productoRequest);
            productoEntity.setPresentacionImg(this.uploadImage.upload(multipartFile));
            productoEntity.setEstado(true);
            //productoRequest.setPresentacionImg(this.uploadImage.upload(multipartFile));
            return this.productoMapper.ToProductResponseDto(
                    this.productoRepository.save(productoEntity));
        } else {
            return null;
        }
    }

    @Override
    public ProductoResponse actualizarProducto(Long idProducto, ProductoRequest productoRequest, MultipartFile multipartFile) throws IOException {
        if(idProducto!=null){
            if(multipartFile==null){

                ProductoEntity productoEntity = this.productoRepository.findById(idProducto).get();

                productoEntity.setIdProducto(idProducto);
                productoEntity.setNombreProducto(productoRequest.getNombreProducto());
                productoEntity.setFechaFabricacion(productoRequest.getFechaFabricacion());
                productoEntity.setFechaVencimiento(productoRequest.getFechaVencimiento());
                productoEntity.setStock(productoRequest.getStock());
                productoEntity.setPrecio(productoRequest.getPrecio());
                productoEntity.setEstado(productoEntity.isEstado());
                CategoriaProductoEntity categoriaProductoEntity = new CategoriaProductoEntity();
                categoriaProductoEntity.setIdCategoria(productoRequest.getIdCategoria());
                productoEntity.setIdCategoria(categoriaProductoEntity);
                ClasificacionProductoEntity clasificacionProductoEntity = new ClasificacionProductoEntity();
                clasificacionProductoEntity.setIdClasificacion(productoRequest.getIdClasificacionProducto());
                productoEntity.setPresentacionImg(productoEntity.getPresentacionImg());

                return this.productoMapper.ToProductResponseDto(this.productoRepository.save(productoEntity));
            } else {
                ProductoEntity productoEntity = this.productoRepository.findById(idProducto).get();

                productoEntity.setIdProducto(idProducto);
                productoEntity.setNombreProducto(productoRequest.getNombreProducto());
                productoEntity.setFechaFabricacion(productoRequest.getFechaFabricacion());
                productoEntity.setFechaVencimiento(productoRequest.getFechaVencimiento());
                productoEntity.setStock(productoRequest.getStock());
                productoEntity.setPrecio(productoRequest.getPrecio());
                productoEntity.setEstado(productoEntity.isEstado());
                CategoriaProductoEntity categoriaProductoEntity = new CategoriaProductoEntity();
                categoriaProductoEntity.setIdCategoria(productoRequest.getIdCategoria());
                productoEntity.setIdCategoria(categoriaProductoEntity);
                ClasificacionProductoEntity clasificacionProductoEntity = new ClasificacionProductoEntity();
                clasificacionProductoEntity.setIdClasificacion(productoRequest.getIdClasificacionProducto());
                productoEntity.setPresentacionImg(this.uploadImage.upload(multipartFile));

                return this.productoMapper.ToProductResponseDto(this.productoRepository.save(productoEntity));
            }
        } else {
            return null;
        }
    }

    @Override
    public ProductoResponse buscarProducto(Long idProducto) {
        return this.productoMapper.ToProductResponseDto(this.productoRepository.findById(idProducto).get());
    }

    @Override
    public void deshabilitarProducto(Long idProducto) {
        ProductoEntity productoEntity = this.productoRepository.findById(idProducto).get();
        productoEntity.setEstado(false);
        this.productoRepository.save(productoEntity);
    }
}
