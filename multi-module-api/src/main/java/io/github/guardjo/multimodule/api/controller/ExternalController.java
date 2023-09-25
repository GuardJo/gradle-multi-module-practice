package io.github.guardjo.multimodule.api.controller;

import io.github.guardjo.multimodule.api.response.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/external")
@Slf4j
public class ExternalController {
    @GetMapping
    public ExternalResponse getExternalResponse(@RequestHeader("external-header") String externalHeader,
                                                @RequestParam("name") String name,
                                                @RequestParam(value = "option", required = false) String option) {
        log.info("Request Get External, header = {}, param = {}, option = {}", externalHeader, name, option);

        return ExternalResponse.builder()
                .header(externalHeader)
                .name(name)
                .option(option)
                .build();
    }
}
