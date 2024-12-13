package com.techgirl.social_app.controller;


import com.techgirl.social_app.model.User;
import com.techgirl.social_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserDetailsService userDetailsService;
    private final UserService userService;

    public UserController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model, User userDto) {
        model.addAttribute("user", userDto);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model, User userDto) {
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute("user") User userDto, Model model) {
        User user = userService.findByUsername(userDto.getUsername());
        if (user != null) {
            model.addAttribute("Userexist", user);
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

}
