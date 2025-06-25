package com.farmacia.service.impl;

import com.farmacia.dto.CategoriaProductoResponse;
import com.farmacia.mapper.CategoriaProductoMapper;
import com.farmacia.repository.CategoriaProductoRepository;
import com.farmacia.service.CategoriaProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    private final CategoriaProductoRepository categoriaProductoRepository;
    private final CategoriaProductoMapper categoriaProductoMapper;

    public CategoriaProductoServiceImpl(CategoriaProductoRepository categoriaProductoRepository, CategoriaProductoMapper categoriaProductoMapper) {
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.categoriaProductoMapper = categoriaProductoMapper;
    }

    @Override
    public List<CategoriaProductoResponse> listadoCategoria() {
        return this.categoriaProductoMapper.listCategoriaDtoToCategoriaEntity(
                this.categoriaProductoRepository.findAll()
        );
    }
}
