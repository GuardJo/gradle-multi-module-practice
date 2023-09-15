package io.github.guardjo.multimodule.api.controller;

import io.github.guardjo.multimodule.common.model.TestModel;
import io.github.guardjo.multimodule.common.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/test")
    public String test() {
        log.info("Get Test");
        return "test";
    }

    @GetMapping("/model")
    public String findModel() {
        TestModel testModel = testService.findTestModel();

        log.info(testModel.toString());

        return testModel.toString();
    }
}
