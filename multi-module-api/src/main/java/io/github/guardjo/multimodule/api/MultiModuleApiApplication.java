package io.github.guardjo.multimodule.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.github.guardjo.multimodule.common.repository")
@EntityScan(basePackages = "io.github.guardjo.multimodule.common.domain")
public class MultiModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleApiApplication.class, args);
    }

}
