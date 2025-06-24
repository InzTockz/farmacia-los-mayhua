package com.farmacia.service;

import com.farmacia.dto.VentaRequest;
import com.farmacia.dto.VentaResponse;

import java.util.List;

public interface VentaService {

    List<VentaResponse> listadoVenta();
    VentaResponse registrarVenta(VentaRequest ventaRequest);
    void deshabilitarVenta(Long idVenta);
}
