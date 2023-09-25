package io.github.guardjo.multimodule.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MultiModuleFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleFeignApplication.class, args);
    }

}
