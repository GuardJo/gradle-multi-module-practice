package io.github.guardjo.multimodule.feign.client;

import io.github.guardjo.multimodule.feign.decoder.DemoErrorDecoder;
import io.github.guardjo.multimodule.feign.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoClientConfig {
    @Bean
    public DemoInterceptor demoInterceptor() {
        return DemoInterceptor.create();
    }

    @Bean
    public DemoErrorDecoder demoErrorDecoder() {
        return DemoErrorDecoder.create();
    }
}
