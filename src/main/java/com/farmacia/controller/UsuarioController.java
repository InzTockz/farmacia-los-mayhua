package com.farmacia.controller;

import com.farmacia.dto.UsuarioRequest;
import com.farmacia.dto.UsuarioResponse;
import com.farmacia.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponse>> listado(){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.listadoUsuarios());
    }

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.registrarUsuario(usuarioRequest));
    }

    @PutMapping("/actualizar/{idUsuario}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long idUsuario, @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.actualizarUsuario(idUsuario, usuarioRequest));
    }

    @GetMapping("/buscar/{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscar(@PathVariable Long idUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.buscarUsuario(idUsuario));
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idUsuario){
        this.usuarioService.deshabilitarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
