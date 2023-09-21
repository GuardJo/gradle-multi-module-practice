package io.github.guardjo.multimodule.api.controller;

import io.github.guardjo.multimodule.api.response.CommonResponse;
import io.github.guardjo.multimodule.common.exception.TestException;
import io.github.guardjo.multimodule.common.type.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "io.github.guardjo.multimodule.api.controller")
@Slf4j
public class TestControllerHandler {

    @ExceptionHandler(value = TestException.class)
    public CommonResponse<String> handleTestException(Exception e) {
        log.warn("Error!");

        return CommonResponse.<String>builder()
                .responseCode(ResponseCode.FAIL.getCode())
                .responseMessage(ResponseCode.FAIL.getMessage())
                .info(e.getMessage())
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResponse<Exception> handleUnknownException(Exception e) {
        log.error("Unknown Error!!");

        return CommonResponse.<Exception>builder()
                .responseCode(ResponseCode.UNKNOWN.getCode())
                .responseMessage(ResponseCode.UNKNOWN.getMessage())
                .info(e)
                .build();
    }
}
