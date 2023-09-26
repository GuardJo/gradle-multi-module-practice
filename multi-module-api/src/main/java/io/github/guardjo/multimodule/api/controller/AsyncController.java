package io.github.guardjo.multimodule.api.controller;

import io.github.guardjo.multimodule.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/async")
@RestController
@Slf4j(topic = "ASYNC_LOG")
@RequiredArgsConstructor
public class AsyncController {
    private final AsyncService asyncService;

    @GetMapping("/bean")
    public void executeWithBean() {
        log.info("Request Execute With Bean");

        asyncService.executeWithBean();
    }

    @GetMapping("/instance")
    public void executeWithNewInstance() {
        log.info("Request Execute With New Instance");

        asyncService.executeWithNewInstance();
    }

    @GetMapping("/method")
    public void executeWithInnerMethod() {
        log.info("Request Execute With Inner Method");

        asyncService.executeWithInnerMethod();
    }
}
