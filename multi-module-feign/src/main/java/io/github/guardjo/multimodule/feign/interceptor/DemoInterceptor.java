package io.github.guardjo.multimodule.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor(staticName = "create")
@Slf4j
public class DemoInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        log.info("Add Default Options");

        template.query("option", "default options");

        template.queries().forEach((query, values) -> log.info("{} : {}", query, values));
    }
}
