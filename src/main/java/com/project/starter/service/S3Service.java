package com.project.starter.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.project.starter.model.Message;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class S3Service {

    private final static String PATH_RESOURCES = "";

    @Value("${aws-s3-bucket-arn}")
    private String bucketName;

    private AmazonS3 s3Client;

    public S3Service() {
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_WEST_2)
                .build();
    }

    public Message processMessage(Message message) {
        String file = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
        message.setCreated(Instant.now());
        s3Client.putObject(bucketName, file, message.getNote());
        return message;
    }
}
