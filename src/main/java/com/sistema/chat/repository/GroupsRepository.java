/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistema.chat.models.Group;
import java.util.UUID;

/**
 *
 * @author jdesquivia
 */
@Repository
public interface GroupsRepository extends JpaRepository<Group, UUID>{
    
}
