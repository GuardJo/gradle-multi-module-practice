package io.github.guardjo.multimodule.api.controller;

import io.github.guardjo.multimodule.common.model.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test() {
        log.info("Get Test");
        return "test";
    }

    @GetMapping("/model")
    public String findModel() {
        TestModel testModel = TestModel.builder()
                .name("tester")
                .build();

        log.info(testModel.toString());

        return testModel.toString();
    }
}
