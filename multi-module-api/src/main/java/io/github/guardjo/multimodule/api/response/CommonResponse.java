package io.github.guardjo.multimodule.api.response;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
public class CommonResponse<T> {
    private String responseCode;
    private String responseMessage;
    private T info;
}
