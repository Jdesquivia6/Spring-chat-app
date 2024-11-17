/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.services;

import com.sistema.chat.models.User;
import com.sistema.chat.repository.UserRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jdesquivia
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public UUID initSesion(String userName, String password) {
        User user = userRepository.findByUsername(userName);

        if (user != null && user.getPassword().equals(password)) {
            return user.getId();
        }
        return null;
    }

}
