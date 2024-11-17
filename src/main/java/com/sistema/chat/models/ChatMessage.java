/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.models;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author jdesquivia
 */
@Entity
@Data
@Table(name = "chat_message")
public class ChatMessage implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "room_id", nullable = false)
    private String roomId;

}
