package io.github.guardjo.multimodule.common.service;

import io.github.guardjo.multimodule.common.model.TestModel;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestModel findTestModel() {
        return TestModel.builder()
                .name("tester")
                .build();
    }
}
