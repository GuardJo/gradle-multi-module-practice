package io.github.guardjo.multimodule.common.exception;

import io.github.guardjo.multimodule.common.type.ResponseCode;
import lombok.Getter;

@Getter
public class TestException extends Exception {
    private String exceptionCode;
    private String exceptionMessage;

    public TestException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.exceptionCode = responseCode.getCode();
        this.exceptionMessage = responseCode.getMessage();
    }
}
