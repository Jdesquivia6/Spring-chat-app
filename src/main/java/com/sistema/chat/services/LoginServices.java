///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sistema.chat.services;
//
//import com.sistema.chat.models.Usuario;
//import com.sistema.chat.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author jdesquivia
// */
//@Service
//public class LoginServices {
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    public boolean iniciarSesion(String userName, String password) {
//
//        Usuario usuario = usuarioRepository.findByNombre(userName);
//
//        if (usuario != null) {
//            if (usuario.getContrasenia().equals(password)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//}
