package com.project.starter.rest;

import com.project.starter.model.Message;
import com.project.starter.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value="/s3")
public class S3Controller {

    private final S3Service service;

    @PostMapping(value="/add")
    public Message process(@RequestBody Message message) {
        return service.processMessage(message);
    }
}
