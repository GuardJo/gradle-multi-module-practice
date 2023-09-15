package io.github.guardjo.multimodule.common.model;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class TestModel {
    private String name;
    private String optionValue;
}
