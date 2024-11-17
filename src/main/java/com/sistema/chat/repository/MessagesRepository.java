/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.repository;

import com.sistema.chat.models.Message;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jdesquivia
 */
@Repository
public interface MessagesRepository extends JpaRepository<Message, UUID> {

    List<Message> findByConversationId(UUID conversationId);

    List<Message> findByConversationIdAndIsReadFalse(UUID conversationId);

}
