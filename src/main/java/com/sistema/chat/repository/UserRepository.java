/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.repository;

import com.sistema.chat.models.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jdesquivia
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    User findByUsername(String username);

    Optional<User> findById(UUID id);

}
