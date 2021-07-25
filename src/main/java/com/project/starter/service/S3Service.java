package com.project.starter.service;

import com.project.starter.model.Message;
import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

    public Message processMessage(Message message) {
        message.setCreated(Instant.now());
        return message;
    }
}
