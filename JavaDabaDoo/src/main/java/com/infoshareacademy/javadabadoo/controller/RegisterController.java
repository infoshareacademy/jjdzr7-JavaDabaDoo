package com.infoshareacademy.javadabadoo.controller;

import com.infoshareacademy.javadabadoo.model.user.dto.UserRegistrationDto;
import com.infoshareacademy.javadabadoo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    String registrationForm(Model model) {
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    String register(UserRegistrationDto userRegistrationDto) {
        userService.register(userRegistrationDto);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    String registrationConfirmation() {
        return "confirmation";
    }
}

