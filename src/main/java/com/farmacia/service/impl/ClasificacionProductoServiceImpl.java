package com.farmacia.service.impl;

import com.farmacia.dto.ClasificacionProductoResponse;
import com.farmacia.mapper.ClasificacionProductoMapper;
import com.farmacia.repository.ClasificacionProductoRepository;
import com.farmacia.service.ClasificacionProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasificacionProductoServiceImpl implements ClasificacionProductoService {

    private final ClasificacionProductoRepository clasificacionProductoRepository;
    private final ClasificacionProductoMapper clasificacionProductoMapper;

    public ClasificacionProductoServiceImpl(ClasificacionProductoRepository clasificacionProductoRepository, ClasificacionProductoMapper clasificacionProductoMapper) {
        this.clasificacionProductoRepository = clasificacionProductoRepository;
        this.clasificacionProductoMapper = clasificacionProductoMapper;
    }

    @Override
    public List<ClasificacionProductoResponse> listadoClasificaciones() {
        return this.clasificacionProductoMapper.clasificacionToClasificacionEntity(this.clasificacionProductoRepository.findAll());
    }

    //AQUI TE QUEDASTE, ATENTO
}
