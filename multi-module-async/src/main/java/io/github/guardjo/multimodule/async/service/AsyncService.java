package io.github.guardjo.multimodule.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {
    public void executeWithBean() {
        log.info("Execute with Bean");
    }

    public void executeWithNewInstance() {
        log.info("Execute with New Instance");
    }

    public void executeWithInnerMethod() {
        log.info("Execute with Inner Method");
    }
}
