package io.github.guardjo.multimodule.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.github.guardjo.multimodule.common")
public class BeanScanConfig {
}
