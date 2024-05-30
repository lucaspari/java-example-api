package com.lucas.helloworldexample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello World", description = "Hello World Controller")
public class HelloWorldController {

    @GetMapping("/hello")
    @Operation(summary = "Hello World", description = "Returns a simple Hello World message")
    public String hello() {
        return "Hello World";
    }
}
