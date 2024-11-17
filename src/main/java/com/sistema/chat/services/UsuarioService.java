package com.sistema.chat.services;

import com.sistema.chat.models.User;
import com.sistema.chat.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UserRepository userRepository;

    @Autowired
    public UsuarioService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User guardarUsuario(User usuario) {
        User usuarioExistente = userRepository.findByUsername(usuario.getUsername());
        if (usuarioExistente != null) {
            throw new RuntimeException("El usuario ya existe.");
        }

        return userRepository.save(usuario);
    }

}
