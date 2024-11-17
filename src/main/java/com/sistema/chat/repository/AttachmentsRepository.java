/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.chat.models.Attachment;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jdesquivia
 */
@Repository
public interface AttachmentsRepository extends JpaRepository<Attachment, UUID> {

}
