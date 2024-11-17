/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.controllers;

import com.sistema.chat.dto.ChatMessageDto;
import com.sistema.chat.models.ChatMessage;
import com.sistema.chat.services.ChatMessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jdesquivia
 */
@Controller
@CrossOrigin("*")
public class WebSocketController {

    @Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessageDto chat(@DestinationVariable String roomId, ChatMessageDto message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserName(message.getUser());
        chatMessage.setMessage(message.getMessage());
        chatMessage.setRoomId(roomId);
        chatMessageService.saveMessage(chatMessage);

        return new ChatMessageDto(message.getMessage(), message.getUser());
    }

    @GetMapping("/api/chat/{roomId}")
    public ResponseEntity<List<ChatMessage>> getAllChatMessages(@PathVariable String roomId) {
        return ResponseEntity.ok(chatMessageService.getMessagesByRoomId(roomId));
    }

}
