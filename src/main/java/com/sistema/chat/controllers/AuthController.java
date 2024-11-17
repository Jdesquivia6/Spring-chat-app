/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.controllers;

import com.sistema.chat.models.User;
import com.sistema.chat.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 *
 * @author jdesquivia
 */
@RestController
@RequestMapping("/api/login")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<?> initSesion(@RequestBody User user) {
        UUID userFound = authService.initSesion(user.getUsername(), user.getPassword());

        if (userFound != null) {
            return ResponseEntity.ok(userFound);
        } else {
            return ResponseEntity.badRequest().body("Usuario o contraseña incorrectos");
        }
    }

}
