package io.github.guardjo.multimodule.feign.service;

import io.github.guardjo.multimodule.feign.client.DemoClient;
import io.github.guardjo.multimodule.feign.data.RequestInfo;
import io.github.guardjo.multimodule.feign.data.ResponseInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeignService {
    private final DemoClient demoClient;

    public ResponseInfo callGet(RequestInfo requestInfo) {
        log.info("Call External Get, header = {}, name = {}", requestInfo.getHeader(), requestInfo.getName());

        return demoClient.callGet(requestInfo.getHeader(), requestInfo.getName()).getBody();
    }
}
