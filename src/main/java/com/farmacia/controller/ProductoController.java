package com.farmacia.controller;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;
import com.farmacia.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/producto")
@CrossOrigin("*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping(value = "/registrar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductoResponse> registrarProducto(@RequestParam ("producto") ProductoRequest producto, @RequestParam("imagen") MultipartFile imagen) throws IOException {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.productoService.registrarProducto(producto, imagen));
    }
}
