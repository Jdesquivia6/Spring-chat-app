/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.services;

import com.sistema.chat.models.Conversation;
import com.sistema.chat.models.ConversationParticipant;
import com.sistema.chat.models.User;
import com.sistema.chat.repository.ConversationParticipantsRepository;
import com.sistema.chat.repository.ConversationsRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jdesquivia
 */
@Service
public class ConversationService {

    private final ConversationsRepository conversationRepository;
    private final ConversationParticipantsRepository participantRepository;

    @Autowired
    public ConversationService(ConversationsRepository conversationRepository,
            ConversationParticipantsRepository participantRepository) {
        this.conversationRepository = conversationRepository;
        this.participantRepository = participantRepository;
    }

    public Conversation createConversation(User creator, boolean isGroup) {
        Conversation conversation = new Conversation();
        conversation.setCreatedBy(creator);
        conversation.setGroup(isGroup);
        conversationRepository.save(conversation);

        ConversationParticipant participant = new ConversationParticipant();
        participant.setConversation(conversation);
        participant.setUser(creator);
        participant.setRole("admin");
        participantRepository.save(participant);

        return conversation;
    }

    public List<Conversation> getUserConversations(User user) {
        List<ConversationParticipant> participants = participantRepository.findByUser(user);

        return participants.stream()
                .map(ConversationParticipant::getConversation)
                .distinct()
                .collect(Collectors.toList());
    }

    public void addParticipantToConversation(UUID conversationId, User user) {
        Optional<Conversation> conversation = conversationRepository.findById(conversationId);
        if (conversation.isPresent()) {
            ConversationParticipant participant = new ConversationParticipant();
            participant.setConversation(conversation.get());
            participant.setUser(user);
            participant.setRole("participant");
            participantRepository.save(participant);
        }
    }

    public void removeParticipantFromConversation(UUID conversationId, User user) {
        Optional<ConversationParticipant> participant = participantRepository.findByConversationAndUser(conversationId, user.getId());
        participant.ifPresent(participantRepository::delete);
    }

    public Optional<ConversationParticipant> getParticipant(UUID conversationId, User user) {
        return participantRepository.findByConversationAndUser(conversationId, user.getId());
    }

}
