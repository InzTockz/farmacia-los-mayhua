package com.farmacia.controller;

import com.farmacia.dto.CategoriaProductoResponse;
import com.farmacia.service.CategoriaProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria-producto")
@Slf4j
@CrossOrigin("*")
public class CategoriaProductoController {

    private final CategoriaProductoService categoriaProductoService;

    public CategoriaProductoController(CategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<CategoriaProductoResponse>> listado(){
        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaProductoService.listadoCategoria());
    }
}
