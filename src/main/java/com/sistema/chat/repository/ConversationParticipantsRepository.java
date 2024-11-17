/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.repository;

import com.sistema.chat.models.Conversation;
import com.sistema.chat.models.ConversationParticipant;
import com.sistema.chat.models.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author jdesquivia
 */
@Repository
public interface ConversationParticipantsRepository extends JpaRepository<ConversationParticipant, UUID> {

    List<ConversationParticipant> findByConversationId(UUID conversationId);

    List<ConversationParticipant> findByUserId(UUID userId);

    List<ConversationParticipant> findByUser(User user);

    Optional<ConversationParticipant> findByConversationAndUser(UUID conversationId, UUID userId);
    
    Optional<ConversationParticipant> findByConversationIdAndUserId(UUID conversationId, UUID userId);

    List<Conversation> findDistinctByUser(User user);
}
