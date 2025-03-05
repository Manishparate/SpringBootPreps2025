package com.ait.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello User! You are authenticated.";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello Admin! You are authenticated.";
    }
}
