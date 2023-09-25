package io.github.guardjo.multimodule.feign.controller;

import io.github.guardjo.multimodule.feign.data.RequestInfo;
import io.github.guardjo.multimodule.feign.data.ResponseInfo;
import io.github.guardjo.multimodule.feign.service.FeignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
@Slf4j
@RequiredArgsConstructor
public class DemoController {
    private final FeignService feignService;

    @GetMapping
    public ResponseInfo callGet(@RequestHeader("feign-header") String header, @RequestParam("name") String name) {
        log.info("Request Get External Server Response, header = {}, name = {}", header, name);

        RequestInfo requestInfo = RequestInfo.builder()
                .header(header)
                .name(name)
                .build();

        return feignService.callGet(requestInfo);
    }

    @GetMapping("/not-found")
    public ResponseInfo callGetNotFound() {
        log.info("Request Get External Server Not Found Response");

        return feignService.callGetNotFound();
    }
}
