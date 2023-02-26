package com.infoshareacademy.javadabadoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/register")
    String loginForm() {
        return "register";
    }
}
