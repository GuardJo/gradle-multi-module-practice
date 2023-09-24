package io.github.guardjo.multimodule.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {
    @Async(value = "defaultThreadPoolExecutor")
    public void sendEmail() {
        log.info("Send Email! :: {}", Thread.currentThread().getName());
    }

    @Async(value = "messageThreadPoolExecutor")
    public void sendEmailWithCustomExecutor() {
        log.info("Send Email! :: {}", Thread.currentThread().getName());
    }
}
