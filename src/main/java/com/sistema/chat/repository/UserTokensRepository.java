/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.repository;

import org.springframework.stereotype.Repository;
import com.sistema.chat.models.UserToken;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jdesquivia
 */
@Repository
public interface UserTokensRepository extends JpaRepository<UserToken, UUID> {

    Optional<UserToken> findByToken(String token);
}
