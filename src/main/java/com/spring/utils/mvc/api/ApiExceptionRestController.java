package com.spring.utils.mvc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionRestController {

    @GetMapping("/api/examples/{id}")
    public exampleDto getExampleDto(@PathVariable String id) {

        if (id.equals("exception")) {
            throw new RuntimeException("rte message");
        }

        return new exampleDto(id, "example");
    }


    @Data
    @AllArgsConstructor
    public static class exampleDto {
        private String exId;
        private String name;
    }
}
