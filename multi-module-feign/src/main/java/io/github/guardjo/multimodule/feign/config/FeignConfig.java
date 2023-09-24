package io.github.guardjo.multimodule.feign.config;

import io.github.guardjo.multimodule.feign.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public DemoInterceptor demoInterceptor() {
        return DemoInterceptor.create();
    }
}
