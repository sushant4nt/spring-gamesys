package org.example.springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class MyController {

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping("/authenticated")
    public String authenticated(Principal principal) {
        return String.format("%s, you are authenticated!", principal.getName());
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin stuff";
    }

    @GetMapping("/stuart")
    public String stuart() {
        return "Just for Stuart";
    }
}
