/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.services;

import com.sistema.chat.dto.ChatMessageDto;
import com.sistema.chat.models.ChatMessage;
import com.sistema.chat.repository.ChatMessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author jdesquivia
 */
@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Transactional
    public ChatMessage saveMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getMessagesByRoomId(String roomId) {
        return chatMessageRepository.findByRoomId(roomId);
    }
}
