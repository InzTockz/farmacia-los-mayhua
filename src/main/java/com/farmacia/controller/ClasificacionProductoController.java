package com.farmacia.controller;

import com.farmacia.dto.ClasificacionProductoResponse;
import com.farmacia.service.ClasificacionProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/clasificacion-producto")
@Slf4j
@CrossOrigin("*")
public class ClasificacionProductoController {

    private final ClasificacionProductoService clasificacionProductoService;

    public ClasificacionProductoController(ClasificacionProductoService clasificacionProductoService) {
        this.clasificacionProductoService = clasificacionProductoService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<ClasificacionProductoResponse>> listado(){
        return ResponseEntity.status(HttpStatus.OK).body(this.clasificacionProductoService.listadoClasificaciones());
    }
}
