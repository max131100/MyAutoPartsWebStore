package com.my.controller;

import com.my.entity.Role;
import com.my.entity.User;
import com.my.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(User user, Model model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb == null) {
            Role role = userRepository.findAll().size() == 0 ? Role.ADMIN : Role.USER;
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.saveAndFlush(user);
            return "redirect:/login";
        } else {
            model.addAttribute("errorMessage", "User with that username already exists");
            return "registration";
        }
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        return "user";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
