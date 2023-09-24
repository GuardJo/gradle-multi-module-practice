package io.github.guardjo.multimodule.feign.client;

import io.github.guardjo.multimodule.feign.data.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "demo-client",
        url = "${feign.url.prefix}",
        configuration = DemoClientConfig.class
)
public interface DemoClient {
    @GetMapping
    ResponseEntity<ResponseInfo> callGet(@RequestHeader("external-header") String header,
                                         @RequestParam("name") String name);
}
