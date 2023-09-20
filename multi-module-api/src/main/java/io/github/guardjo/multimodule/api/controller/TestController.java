package io.github.guardjo.multimodule.api.controller;

import io.github.guardjo.multimodule.api.response.CommonResponse;
import io.github.guardjo.multimodule.common.exception.TestException;
import io.github.guardjo.multimodule.common.model.TestModel;
import io.github.guardjo.multimodule.common.service.TestService;
import io.github.guardjo.multimodule.common.type.ResponseCode;
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
    public CommonResponse<String> test() {
        log.info("Get Test");

        return CommonResponse.<String>builder()
                .responseCode(ResponseCode.SUCCESS.getCode())
                .responseMessage(ResponseCode.SUCCESS.getMessage())
                .info("test")
                .build();
    }

    @GetMapping("/model")
    public CommonResponse<TestModel> findModel() {
        TestModel testModel = testService.findTestModel();

        log.info(testModel.toString());

        return CommonResponse.<TestModel>builder()
                .responseCode(ResponseCode.SUCCESS.getCode())
                .responseMessage(ResponseCode.SUCCESS.getMessage())
                .info(testModel)
                .build();
    }

    @GetMapping("/exception")
    public void exception() throws TestException {
        log.info("Request Exception");
        testService.throwException();
    }
}
