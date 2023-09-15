package io.github.guardjo.multimodule.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "io.github.guardjo.multimodule.common",
        "io.github.guardjo.multimodule.api"
})
public class MultiModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleApiApplication.class, args);
    }

}
