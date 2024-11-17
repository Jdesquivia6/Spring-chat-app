/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jdesquivia
 */
@Data
@AllArgsConstructor
public class ChatMessageDto {

    String message;
    String user;
    
}
