package com.farmacia.controller;

import com.farmacia.dto.ProductoRequest;
import com.farmacia.dto.ProductoResponse;
import com.farmacia.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
@CrossOrigin("*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<ProductoResponse>> listado(){
        return ResponseEntity.status(HttpStatus.OK).body(this.productoService.listadoProductos());
    }

    @GetMapping("/buscar/{idProducto}")
    public ResponseEntity<ProductoResponse> buscarProducto(@PathVariable Long idProducto){
        return ResponseEntity.status(HttpStatus.OK).body(this.productoService.buscarProducto(idProducto));
    }

    @PostMapping(value = "/registrar")
    public ResponseEntity<ProductoResponse> registrarProducto(
            @RequestParam ("nombreProducto") String nombreProducto,
            @RequestParam("fechaFabricacion") LocalDate fechaFabricacion,
            @RequestParam("fechaVencimiento") LocalDate fechaVencimiento,
            @RequestParam("stock") int stock,
            @RequestParam("precio") double precio,
            @RequestParam("estado") boolean estado,
            @RequestParam("idCategoria") Long idCategoria,
            @RequestParam("idClasificacionProducto") Long idClasificacionProducto,
            @RequestParam(value = "imagen", required = false) MultipartFile imagen) throws IOException {

        ProductoRequest producto = new ProductoRequest(nombreProducto, fechaFabricacion, fechaVencimiento, stock, precio, estado, idCategoria, idClasificacionProducto);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.productoService.registrarProducto(producto, imagen));
    }

    @PutMapping("/actualizar/{idProducto}")
    public ResponseEntity<ProductoResponse> actualizarProducto(@PathVariable Long idProducto,
                                                               @RequestParam ("nombreProducto") String nombreProducto,
                                                               @RequestParam("fechaFabricacion") LocalDate fechaFabricacion,
                                                               @RequestParam("fechaVencimiento") LocalDate fechaVencimiento,
                                                               @RequestParam("stock") int stock,
                                                               @RequestParam("precio") double precio,
                                                               @RequestParam("estado") boolean estado,
                                                               @RequestParam("idCategoria") Long idCategoria,
                                                               @RequestParam("idClasificacionProducto") Long idClasificacionProducto,
                                                               @RequestParam(value = "imagen", required = false) MultipartFile imagen) throws IOException {

        ProductoRequest producto = new ProductoRequest(nombreProducto, fechaFabricacion, fechaVencimiento, stock, precio, estado, idCategoria, idClasificacionProducto);

        return ResponseEntity.status(HttpStatus.OK).body(this.productoService.actualizarProducto(idProducto, producto, imagen));
    }

    @DeleteMapping("/deshabilitar/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProducto){
        this.productoService.deshabilitarProducto(idProducto);
        return ResponseEntity.ok().build();
    }
}
