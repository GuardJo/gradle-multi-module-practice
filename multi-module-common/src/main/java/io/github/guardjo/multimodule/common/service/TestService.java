package io.github.guardjo.multimodule.common.service;

import io.github.guardjo.multimodule.common.exception.TestException;
import io.github.guardjo.multimodule.common.model.TestModel;
import io.github.guardjo.multimodule.common.type.ResponseCode;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestModel findTestModel() {
        return TestModel.builder()
                .name("tester")
                .build();
    }

    public void throwException() throws TestException {
        throw new TestException(ResponseCode.FAIL);
    }
}
