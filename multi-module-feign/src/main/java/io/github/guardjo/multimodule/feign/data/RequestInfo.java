package io.github.guardjo.multimodule.feign.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestInfo {
    private String header;
    private String name;
    private String option;
}
