package com.project.starter.model;

import java.time.Instant;
import lombok.Data;

@Data
public class Message {
    private String note;
    private String subject;
    private Instant created;
}
