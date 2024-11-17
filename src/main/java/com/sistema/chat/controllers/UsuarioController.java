package com.sistema.chat.controllers;

import com.sistema.chat.models.User;
import com.sistema.chat.services.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listAllUsuario")
    public ResponseEntity<List<User>> listAllUser() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuarios());
        } catch (Exception e) {
            e.getMessage();
            e.getLocalizedMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUsuario(@RequestBody User usuario) {
        try {
            User usuarioNuevo = usuarioService.guardarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo);
        } catch (Exception e) {
            e.printStackTrace();
            String mensajeError = "Error al guardar el usuario: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

}
