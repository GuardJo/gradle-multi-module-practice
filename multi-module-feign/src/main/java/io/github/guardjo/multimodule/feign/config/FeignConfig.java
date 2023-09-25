package io.github.guardjo.multimodule.feign.config;

import feign.Logger;
import io.github.guardjo.multimodule.feign.logger.FeignCustomLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Logger feignCustomLogger() {
        return FeignCustomLogger.create();
    }
}
