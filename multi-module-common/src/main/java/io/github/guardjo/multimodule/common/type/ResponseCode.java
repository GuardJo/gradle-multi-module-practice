package io.github.guardjo.multimodule.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS("success-code", "This is Successed!"),
    FAIL("fail-code", "This is Failed"),
    UNKNOWN("unknown-code", "This is Unknown");

    private String code;
    private String message;
}
