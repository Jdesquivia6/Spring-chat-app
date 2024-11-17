package com.sistema.chat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @GetMapping("/getRoomId")
    public String getRoomId(@RequestParam String userId, @RequestParam String otherUserId) {
        List<String> ids = Arrays.asList(userId, otherUserId);
        Collections.sort(ids);
        return "chat_" + String.join("-", ids);
    }

}
